package com.mvp.studio.ex2.challenge2;

import com.mvp.studio.ex2.challenge2.model.EntertainmentContent;
import com.mvp.studio.ex2.challenge2.sevice.ReviewingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RatingApplication {

    private static Logger logger = LoggerFactory.getLogger(RatingApplication.class);

    public static void main(String[] args){

        ReviewingService reviewingService = new ReviewingService();

        logger.info("Adding Movie Ratings size={}", reviewingService.getEntertainmentContentHashMap().size());

        reviewingService.addMovieRating("ET", 1);
        reviewingService.addMovieRating("The Matrix", 10);

        logger.info("Adding Movie Ratings size={}", reviewingService.getEntertainmentContentHashMap().size());

        reviewingService.addMovieRating("Slumdog Millionaire", 8);
        reviewingService.addMovieRating("Le Rayon Vert", 4);
        reviewingService.addMovieRating("Mamma Mia", 3);


        logger.info("Adding Movie Ratings size={}", reviewingService.getEntertainmentContentHashMap().size());

        logger.info(reviewingService.displayAllEntertainmentContent());

        reviewingService.removeEntertainmentContentRating("Le Rayon Vert");

        logger.info("After Removing \"Le Rayon Vert\"");

        logger.info(reviewingService.displayAllEntertainmentContent());


        EntertainmentContent movieFound = reviewingService.findEntertainmentContentRating("Slumdog Millionaire");
        logger.info("Finding \"Slumdog Millionaire\" ----> Found {}", movieFound);

        reviewingService.addSeriesRating("Breaking Bad", "amazing show" ,10);
        reviewingService.addSeriesRating("Under The Dome", "could have been better", 5);

        logger.info(reviewingService.displayAllEntertainmentContent());

    }
}
