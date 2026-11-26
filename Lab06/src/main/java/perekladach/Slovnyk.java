package perekladach;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Slovnyk {

    private HashMap<String, String> slovnyk = new HashMap<>();

    public Slovnyk() {
        slovnyk.put("hello", "привіт");
        slovnyk.put("world", "світ");
        slovnyk.put("i", "я");
        slovnyk.put("you", "ти");
        slovnyk.put("love", "люблю");
        slovnyk.put("cat", "кіт");
        slovnyk.put("dog", "собака");
        slovnyk.put("book", "книга");
        slovnyk.put("good", "гарний");
        slovnyk.put("morning", "ранок");
        slovnyk.put("how", "як");
        slovnyk.put("are", "є");
        slovnyk.put("thank", "дякую");
        slovnyk.put("friend", "друг");
        slovnyk.put("water", "вода");
        slovnyk.put("apple", "яблуко");
        slovnyk.put("house", "будинок");
        slovnyk.put("school", "школа");
        slovnyk.put("computer", "комп'ютер");
        slovnyk.put("java", "Java");
    }

    public void dodatySlovo(String angliiske, String ukrainske) {

        if (angliiske == null || angliiske.isBlank()
                || ukrainske == null || ukrainske.isBlank()) {
            throw new IllegalArgumentException(
                    "Слова не можуть бути порожніми."
            );
        }

        slovnyk.put(
                angliiske.trim().toLowerCase(Locale.ROOT),
                ukrainske.trim()
        );
    }

    public String pereklastyFrazu(String fraza) {

        if (fraza == null || fraza.isBlank()) {
            return "";
        }

        StringBuilder rezultat = new StringBuilder();

        Pattern pattern = Pattern.compile("\\p{L}+|[^\\p{L}]+");
        Matcher matcher = pattern.matcher(fraza);

        while (matcher.find()) {

            String slovo = matcher.group();

            if (slovo.matches("\\p{L}+")) {

                String pereklad = slovnyk.get(
                        slovo.toLowerCase(Locale.ROOT)
                );

                if (pereklad == null) {
                    rezultat.append(slovo);
                } else {
                    if (Character.isUpperCase(slovo.charAt(0))) {
                        pereklad = Character.toUpperCase(
                                pereklad.charAt(0)
                        ) + pereklad.substring(1);
                    }

                    rezultat.append(pereklad);
                }

            } else {
                rezultat.append(slovo);
            }
        }

        return rezultat.toString();
    }

    public Map<String, String> otrymatySlovnyk() {
        return new HashMap<>(slovnyk);
    }
}
