package com.mvp.studio.rentalappbug;

import com.mvp.studio.rentalappbug.service.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class VideoStoreApplication {

    private static Logger logger = LoggerFactory.getLogger(VideoStoreApplication.class);

    public static void main(String[] args) {

        RentalService rentalService = new RentalService();

        addInitialVideos(rentalService);
        displayMainMenu();

        Scanner in = new Scanner(System.in);


        boolean notFinished = true;

        while(notFinished) {
            String input = in.nextLine();
            if (input.equals("1")) {
                displayRentalScreen(rentalService, in);
            } else if (input.equals("2")) {
                displayReturnVideoScreen(rentalService, in);
            } else if (input.equals("0")) {
                notFinished=false;
            } else {
                logger.info("You entered an invalid selection");
            }
        }

    }

    private static void displayReturnVideoScreen(RentalService rentalService, Scanner in) {
        String input;
        logger.info("-------------------------------------- Video Returning Screen -------------------------------------");
        logger.info("----------------- please input the video movie title for the video you wish to return -------------");
        logger.info("------------------------------ please input 0 to display the main screen --------------------------");

        boolean notFinished = true;

        while(notFinished) {

            displayAllVideos(rentalService);
            input = in.nextLine();
            if ((input).equals("0")) {
                notFinished=false;
            }else{
                boolean returnVideo = returnVideo(rentalService, input);
                if(returnVideo) {
                   String videoTitle = input;
                    logger.info("Please input rating 1 - 10 for video {}", videoTitle);
                    input = in.nextLine();
                    rentalService.receiveRating(videoTitle, Integer.valueOf(input));
                    logger.info("Thank you for submitting rating :)");
                }
            }

            logger.info("---------------------------- please input 0 to display the main screen -------------------------");

        }

        displayMainMenu();
    }

    private static void displayRentalScreen(RentalService rentalService, Scanner in) {

        String input;
        logger.info("-------------------------------------- Video Rental Screen -------------------------------------");
        logger.info("----------------- please input the video movie title for the video you wish to rent ------------");
        logger.info("---------------------------- please input 0 to display the main screen -------------------------");


        boolean notFinished = true;

        while(notFinished) {
            displayAllVideos(rentalService);
            input = in.nextLine();
            if ((input).equals("0")) {
                notFinished=false;
            }else{
                checkOut(rentalService, input);
            }

            logger.info("---------------------------- please input 0 to display the main screen -------------------------");

        }

        displayMainMenu();
    }

    private static void checkOut(RentalService rentalService, String input) {
        boolean checkedOut =  rentalService.checkOut(input);

        if(checkedOut) {
            logger.info("Movie {} checked out successfully.\n",input);
        }else{
            logger.info("Movie {} was not checkout please renting another movie.\n", input);
        }
    }

    private static boolean returnVideo(RentalService rentalService, String input) {
        boolean checkedOut =  rentalService.returnVideo(input);

        if(checkedOut) {
            logger.info("Movie {}  returned successfully.\n",input);
        }else{
            logger.info("Movie {} was not return please check if input is valid\n", input);
        }

        return  checkedOut;
    }

    private static void displayMainMenu() {
        logger.info("-------------------------- Welcome To Video Rental -----------------------");
        logger.info("----------------- please input one of the following selections ------------");
        logger.info("1: for renting out movies");
        logger.info("2: for returning rented out movies \n");
    }

    private static void displayAllVideos(RentalService rentalService) {
        logger.info(rentalService.listInventory() + "\n");
    }

    private static void addInitialVideos(RentalService rentalService) {
        rentalService.adVideo("The Matrix");
        rentalService.adVideo("Godfather II");
        rentalService.adVideo("Star Wars Episode IV: A New Hope");
        rentalService.adVideo("ET");
        rentalService.adVideo("War");
        rentalService.adVideo("The Meg");
        rentalService.adVideo("Star Trooper");
        rentalService.adVideo("Avengers");
        rentalService.adVideo("X-Men");
        rentalService.adVideo("I am Java");
    }
}
