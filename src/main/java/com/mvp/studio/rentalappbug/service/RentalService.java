package com.mvp.studio.rentalappbug.service;

import com.mvp.studio.rentalappbug.model.Video;

import java.util.HashMap;
import java.util.Map;

public class RentalService {

    Map<String, Video> videos = new HashMap<String, Video>();

    public void adVideo(String videoName){
        Video video = new Video(videoName);
        videos.put(videoName, video);
    }

    public boolean checkOut(String videoName){

        boolean isCheckedOut = false;

        if(videos.containsKey(videoName)){
            Video video = videos.get(videoName);
            if(!video.isCheckedOut()) {
                video.setCheckedOut(true);
                isCheckedOut = true;
            }
        }
        return isCheckedOut;
    }


    public boolean returnVideo(String videoName){
        boolean isReturned = false;

        if(videos.containsKey(videoName)){
            Video video = videos.get(videoName);
            video.setCheckedOut(false);
            isReturned= true;
        }

        return isReturned;

    }

    public void receiveRating(String videoName, int rating){
        if(videos.containsKey(videoName)){
            Video video = videos.get(videoName);
            video.getRatingHistory().add(rating);
        }
    }

    public String listInventory(){
        StringBuilder builder = new StringBuilder( "\n-------------------------------------- List Of Videos To Checkout ------------------------------------- \n");

        for (Map.Entry<String, Video> entry : videos.entrySet()){
            Video video = entry.getValue();
            builder.append(video.toString());
        }
        return builder.toString();
    }


}
