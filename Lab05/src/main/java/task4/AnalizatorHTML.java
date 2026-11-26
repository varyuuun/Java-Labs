package task4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class AnalizatorHTML {

    public List<TagStatystyka> pidrakhuvatyTegy(String url)
            throws IOException {

        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException(
                    "URL не може бути порожнім."
            );
        }

        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .timeout(15000)
                .get();

        Map<String, Integer> chastoty = new TreeMap<>();

        for (Element element : document.getAllElements()) {

            String nazvaTegu = element.tagName()
                    .toLowerCase(Locale.ROOT);

            // Пропускаємо службовий кореневий елемент
            if (nazvaTegu.startsWith("#")) {
                continue;
            }

            chastoty.merge(nazvaTegu, 1, Integer::sum);
        }

        List<TagStatystyka> rezultat = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : chastoty.entrySet()) {
            rezultat.add(
                    new TagStatystyka(entry.getKey(), entry.getValue())
            );
        }

        return rezultat;
    }

    public List<TagStatystyka> sortuvatyZaNazvoiu(
            List<TagStatystyka> statystyka) {

        List<TagStatystyka> rezultat = new ArrayList<>(statystyka);

        rezultat.sort(
                Comparator.comparing(TagStatystyka::getNazvaTegu)
        );

        return rezultat;
    }

    public List<TagStatystyka> sortuvatyZaChastotoiu(
            List<TagStatystyka> statystyka) {

        List<TagStatystyka> rezultat = new ArrayList<>(statystyka);

        rezultat.sort(
                Comparator.comparingInt(TagStatystyka::getChastota)
                        .thenComparing(TagStatystyka::getNazvaTegu)
        );

        return rezultat;
    }

    public void vyvestyStatystyku(List<TagStatystyka> statystyka) {
        for (TagStatystyka tag : statystyka) {
            System.out.println(tag);
        }
    }
}
