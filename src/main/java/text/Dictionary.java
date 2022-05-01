package text;

import java.util.LinkedHashMap;
import java.util.Objects;

public class Dictionary {

    private String name;

    public Dictionary(String name) {
        this.name = name;
    }

    private final LinkedHashMap<String, String> dictionary = new LinkedHashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dictionary that = (Dictionary) o;
        return Objects.equals(name, that.name) && Objects.equals(dictionary, that.dictionary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dictionary.values());
    }

    public void addMeaning(String word, String meaning){
        dictionary.put(word, meaning);
    }

    public String getMeaning(String word){
        return dictionary.get(word);
    }

    public void changeMeaning(String word, String meaning){
        dictionary.replace(word, meaning);
    }

}
