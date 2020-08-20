package com.chris.swapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class People which represents an individual character within the Star Wars Universe
 */
public class People{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("mass")
    @Expose
    private int mass;
    @SerializedName("hair_color")
    @Expose
    private String hairColor;
    @SerializedName("skin_color")
    @Expose
    private String skinColor;
    @SerializedName("eye_color")
    @Expose
    private String eyeColor;
    @SerializedName("birth_year")
    @Expose
    private String birthYear;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("homeworld")
    @Expose
    private String homeWorldUrl;
    @SerializedName("films")
    @Expose
    private List<String> filmsUrls = null;

    public List<String> getRelatedFilms() {
        return filmsUrls;
    }

    public void setRelatedFilms(List<String> filmsUrls) {
        this.filmsUrls = filmsUrls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHomeWorldUrl() {
        return homeWorldUrl;
    }

    public void setHomeWorldUrl(String homeWorldUrl) {
        this.homeWorldUrl = homeWorldUrl;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

}
