package lesson8.HW8;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mod {
    @JsonProperty("Key")
    private String key;
    @JsonProperty("EnglishName")
    private String name;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}