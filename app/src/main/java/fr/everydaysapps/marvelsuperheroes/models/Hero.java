package fr.everydaysapps.marvelsuperheroes.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by ygharsallah on 30/03/2017.
 */

public class Hero  implements Serializable{

    @Expose
    private String image;
    @Expose
    private String title;
    @Expose
    private String intro;
    @Expose
    private String year;
    @Expose
    private String text;
    @Expose
    private String color;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
