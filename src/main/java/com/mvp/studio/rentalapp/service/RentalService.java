package com.mvp.studio.rentalapp.service;

import com.mvp.studio.rentalapp.model.Video;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the service class which carries out the core functionality around video renting
 */
public class RentalService {

    // Java 8 and above you can create this like the following Map<String, Video> videos = new HashMap<>();
    // Also is much easier to work with a map then a list, you can do the same implementation with a list
    Map<String, Video> videos = new HashMap<String, Video>();

    public void addVideo(String videoName) {
        Video video = new Video(videoName);
        videos.put(videoName, video);
    }

    public boolean checkOut(String videoName) {

        boolean isCheckedOut = false;

        if (videos.containsKey(videoName)) {
            Video video = videos.get(videoName);
            if (!video.isCheckedOut()) {
                video.setCheckedOut(true);
                isCheckedOut = true;
            }
        }
        return isCheckedOut;
    }

    public boolean returnVideo(String videoName) {
        boolean isReturned = false;

        if (videos.containsKey(videoName)) {
            Video video = videos.get(videoName);
            if (video.isCheckedOut()) {
                video.setCheckedOut(false);
                isReturned = true;
            }
        }
        return isReturned;
    }

    public void receiveRating(String videoName, int rating) {
        if (videos.containsKey(videoName)) {
            Video video = videos.get(videoName);
            video.setRating(rating);
        }
    }

    public String listInventory() {
        //Important to know the difference between String StringBuilder and StringBuffer
        StringBuilder builder = new StringBuilder("\n-------------------------------------- List Of Videos To Checkout ------------------------------------- \n");

        for (Map.Entry<String, Video> entry : videos.entrySet()) {
            Video video = entry.getValue();
            builder.append(video.toString());
        }
        return builder.toString();
    }

    public Map<String, Video> getVideos() {
        return videos;
    }
}
