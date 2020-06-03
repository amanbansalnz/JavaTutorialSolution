package com.mvp.studio.rentalapp.service;

import com.mvp.studio.rentalapp.model.Video;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RentalServiceTest {

    private RentalService rentalService;

    @Before
    public void setUp() throws Exception {
        rentalService = new RentalService();
        rentalService.addVideo("testing2");
    }

    @Test
    public void addVideo() {
        rentalService.addVideo("testing");
        Map<String, Video> videos = rentalService.getVideos();
        assertThat(videos.containsKey("testing"), is(true));
    }

    @Test
    public void checkOut() {
        Map<String, Video> videos = rentalService.getVideos();
        assertThat(videos.get("testing2").isCheckedOut(), is(false));
        rentalService.checkOut("testing2");
        assertThat(videos.get("testing2").isCheckedOut(), is(true));
    }

    @Test
    public void returnVideo() {
        Map<String, Video> videos = rentalService.getVideos();
        rentalService.checkOut("testing2");
        assertThat(videos.get("testing2").isCheckedOut(), is(true));
        rentalService.returnVideo("testing2");
        assertThat(videos.get("testing2").isCheckedOut(), is(false));
    }

    @Test
    public void receiveRating() {
        rentalService.receiveRating("testing2", 3);
        Map<String, Video> videos = rentalService.getVideos();
        assertThat(videos.get("testing2").getRating(), is(3.0));
    }
}