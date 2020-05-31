package com.mvp.studio.ex2;

import com.mvp.studio.ex1.DogWalkLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReviewerLauncher {
    private static Logger logger = LoggerFactory.getLogger(DogWalkLauncher.class);

    public static void main(String[] args) {

        boolean testGetRating = false;
        boolean highestRatingIndex = false;

/**   This array is just an example of some movies --
 *    it doesn't actually get used.
 *
 *    String[] movies = {"The Matrix", "ET", "Slumdog Millionaire",
 *			"Le Rayon Vert", "Mamma Mia"};
 */

        Reviewer reviewer = new Reviewer();

        // setRating1(i, j) -- assign the value j
        // to the movie corresponding to index i
        reviewer.setRating(0, 3);
        reviewer.setRating(1, 4);
        reviewer.setRating(2, 5);
        reviewer.setRating(3, 2);
        reviewer.setRating(4, 1);

        // Run some tests.
        if (reviewer.getRating(1) == 4) {
            testGetRating = true;
        }

        if (reviewer.indexOfHighestRating() == 2 ){
            highestRatingIndex = true;
        }

        logger.info("testGetRating1: {}",  testGetRating);
        logger.info("highest rating  index is 2: {}",  highestRatingIndex);
    }
}