package com.mvp.studio.ex2.challenge.sevice;

import com.mvp.studio.ex2.challenge.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReviewingServiceTest {

    ReviewingService reviewingService;

    @Before
    public void setUp() {
        reviewingService = new ReviewingService();
    }

    @Test
    public void givenMovieTitle_whenAddMovieRating_ThenMovieIsAdded() {
        assertThat(0, is(reviewingService.getMovieMap().size()));
        reviewingService.addMovieRating("Testing Movie",1 );
        assertThat(1, is(reviewingService.getMovieMap().size()));
    }

    @Test
    public void givenMovieTitle_whenRemoveMovieRating_ThenMovieIsAdded() {
        reviewingService.addMovieRating("Testing Movie",1 );
        reviewingService.addMovieRating("Testing Movie2",3 );
        assertThat(2, is(reviewingService.getMovieMap().size()));
        reviewingService.removeMovieRating("Testing Movie");
        assertThat(1, is(reviewingService.getMovieMap().size()));
    }

    @Test
    public void givenMovieTitle_whenFindMovieRating_ThenMovieIsAdded() {
        reviewingService.addMovieRating("Testing Movie",1 );
        reviewingService.addMovieRating("Testing Movie2",3 );
        Movie movie = reviewingService.findMovieRating("Testing Movie");
        assertThat(movie.getMovieTitle(), is("Testing Movie"));
    }

    @Test
    public void givenMovieTitle_whenSortMoviesByRating_ThenMoviesAreSortedByHighestRating() {
        reviewingService.addMovieRating("Testing Movie",4);
        reviewingService.addMovieRating("Testing Movie2",3 );
        reviewingService.addMovieRating("Testing Movie3",10 );
        reviewingService.addMovieRating("Testing Movie4",1 );

        List<Movie> movies = reviewingService.sortMoviesByRating();

        assertThat(movies.get(0).getRating(), is(10));
        assertThat(movies.get(1).getRating(), is(4));
        assertThat(movies.get(2).getRating(), is(3));
        assertThat(movies.get(3).getRating(), is(1));
    }

}