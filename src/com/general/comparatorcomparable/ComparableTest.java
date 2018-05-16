package com.general.comparatorcomparable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dhanetwa on 4/26/2018.
 */
class Movie implements Comparable<Movie>{
    double rating;
    int year;
    String name;

    public Movie( String name, double rating, int year) {
        this.rating = rating;
        this.year = year;
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Movie o) {
        return this.year - o.year;
    }
}
public class ComparableTest {
    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
        System.out.println("Movies before sorting : ");
        for (Movie movie: list)
        {
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }
        Collections.sort(list);
        System.out.println("Movies after sorting : ");
        for (Movie movie: list)
        {
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }
    }
}
