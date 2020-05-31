package com.mvp.studio.ex2.challenge;

import com.mvp.studio.ex2.challenge.model.Movie;
import com.mvp.studio.ex2.challenge.sevice.ReviewingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RatingApplication {

    private static Logger logger = LoggerFactory.getLogger(RatingApplication.class);

    public static void main(String[] args){

        ReviewingService reviewingService = new ReviewingService();

        logger.info("Adding Movie Ratings size={}", reviewingService.getMovieMap().size());

        reviewingService.addMovieRating("ET", 1);
        reviewingService.addMovieRating("The Matrix", 10);

        logger.info("Adding Movie Ratings size={}", reviewingService.getMovieMap().size());

        reviewingService.addMovieRating("Slumdog Millionaire", 8);
        reviewingService.addMovieRating("Le Rayon Vert", 4);
        reviewingService.addMovieRating("Mamma Mia", 3);


        logger.info("Adding Movie Ratings size={}", reviewingService.getMovieMap().size());

        logger.info(reviewingService.displayAllMovies());

        reviewingService.removeMovieRating("Le Rayon Vert");

        logger.info("After Removing \"Le Rayon Vert\"");

        logger.info(reviewingService.displayAllMovies());


        Movie movieFound = reviewingService.findMovieRating("Slumdog Millionaire");
        logger.info("Finding \"Slumdog Millionaire\" ----> Found {}", movieFound);


    }
}
