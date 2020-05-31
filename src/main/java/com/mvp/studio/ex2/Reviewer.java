package com.mvp.studio.ex2;

public class Reviewer {
    /**
     * Assume there are exactly 5 films that need to be rated.
     */
    private int[] ratings = new int[5];


    public void setRating(int movieIndex, int rating) {
        // TODO: implement method stub
        ratings[movieIndex] = rating;
    }

    public int getRating(int movieIndex) {
        // TODO: implement method stub
        return ratings[movieIndex];
    }

    /**
     * Return the index of the film which gets the highest rating.
     */
    public int indexOfHighestRating() {
       int highestRating = 0;
        // TODO: implement method stub
        for(int i =0 ; i < ratings.length; i++) {
            if(ratings[i] > highestRating){
                highestRating = i;
            }
        }

        return highestRating;
    }
}
