package com.mvp.studio.ex2.challenge.sevice;

import com.mvp.studio.ex2.challenge.model.Movie;
import com.mvp.studio.ex2.challenge.util.MovieRatingCompare;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * In Real World ReviewingService acts like a Reviewer, It does all the functionality around what a Reviewer does.
 * It is best practice to name classes with name + service which indicates the Actor and type of service/role is does.
 */
public class ReviewingService {

    private Map<String, Movie> movieMap = new HashMap<String, Movie>();
    private MovieRatingCompare movieRatingCompare = new MovieRatingCompare();

    public void addMovieRating(String movieTitle, int rating){
        Movie movie = new Movie();
        movie.setMovieTitle(movieTitle);
        movie.setRating(rating);
        movieMap.put(movieTitle, movie);
    }

    public void removeMovieRating(String movieTitle){
        if(movieMap.containsKey(movieTitle)){
            movieMap.remove(movieTitle);
        }
    }

    public Movie findMovieRating(String movieTitle){
        Movie movie = null;

        if(movieMap.containsKey(movieTitle)){
            movie= movieMap.get(movieTitle);
        }
        return movie;
    }

    public String displayAllMovies(){

        StringBuilder builder = new StringBuilder( "List Of Movies That Have Been Rated \n");
        List<Movie> movies = sortMoviesByRating();
        for (Movie movie :movies ){
            builder.append(movie.toString()).append("\n");
        }
        return builder.toString();
    }

    public List<Movie> sortMoviesByRating(){
        Collection<Movie> values = movieMap.values();
        List<Movie> movies = new ArrayList<Movie>(values);
        Collections.sort(movies, movieRatingCompare);
        return  movies;
    }

    public Map<String, Movie> getMovieMap() {
        return movieMap;
    }
}
