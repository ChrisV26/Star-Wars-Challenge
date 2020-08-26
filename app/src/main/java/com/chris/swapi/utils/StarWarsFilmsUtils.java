package com.chris.swapi.utils;

public class StarWarsFilmsUtils {

    /** Method to relate Films URL to respected Movie Title
     * @param filmsUrl url from Model Class People
     */
    public static String filmUrlToFilmTitle(String filmsUrl) {
       int filmId;
        try {
            //get the id of the film, example: "https://swapi.dev/api/films/2/"
            String [] string=filmsUrl.split("/");
            filmId= Integer.parseInt(string[string.length-1]);
        } catch (Exception e) {
            return e.getMessage();
        }
        switch (filmId) {
            case 1:
                return "Star Wars Episode IV A New Hope";
            case 2:
                return "Star Wars Episode V The Empire Strikes Back";
            case 3:
                return "Star Wars Episode VI Return of the Jedi";
            case 4:
                return "Star Wars Episode I The Phantom Menace";
            case 5:
                return "Star Wars Episode II Attack of the Clones";
            case 6:
                return "Star Wars Episode III Revenge of the Sith";
            default:
                return null;
        }
    }
}
