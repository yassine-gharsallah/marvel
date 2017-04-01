package fr.everydaysapps.marvelsuperheroes.models;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by ygharsallah on 30/03/2017.
 */

public class Heroes {

    @Expose
    private List<Hero> elements;

    public List<Hero> getElements() {
        return elements;
    }

    public void setElements(List<Hero> elements) {
        this.elements = elements;
    }


}
