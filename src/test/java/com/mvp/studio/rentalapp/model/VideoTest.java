package com.mvp.studio.rentalapp.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class VideoTest {

    @Test
    public void givenVideoRatings_whenGettingRating_ThenReturnAverageRating(){

        Video video = new Video("Testing");
        video.setRating(2);
        video.setRating(4);
        video.setRating(5);

        assertThat( video.getRating(), is(3.6666666666666665 ));
    }

}