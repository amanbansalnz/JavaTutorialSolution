package com.mvp.studio.rentalappbug;



import com.mvp.studio.rentalapp.service.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class VideoStoreApplication {

    private static Logger logger = LoggerFactory.getLogger(com.mvp.studio.rentalapp.VideoStoreApplication.class);
    private static com.mvp.studio.rentalapp.service.RentalService rentalService = new RentalService();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        addInitialVideos();
        displayMainMenu();

        boolean notFinished = true;

        while(notFinished) {
            String input = in.nextLine();

            if (input.equals("1")) {
                displayRentalScreen();
            } else if (input.equals("2")) {
                displayReturnVideoScreen();
            } else if (input.equals("3")) {
                displayAddVideoScreen();
            } else if (input.equals("0")) {
                notFinished=false;
            } else {
                logger.info("You entered an invalid selection");
            }
        }

        logger.info("Bye Bye THANK YOU FOR VISITING COME BACK SOON");
    }

    private static void displayAddVideoScreen() {
        logger.info("-------------------------------------- Video Returning Screen -------------------------------------");
        logger.info("----------------- please input the video movie title you want to add to inventory -----------------");
        logger.info("------------------------------ please input 0 to display the main screen --------------------------");

        boolean notFinished = true;

        while(notFinished) {
            displayAllVideos();
            String input = in.nextLine();

            if ((input).equals("0")) {
                notFinished=false;
            }else{
                addNewVideo(input);
            }
            logger.info("---------------------------- please input 0 to display the main screen -------------------------");
        }
        displayMainMenu();
    }

    private static void addNewVideo(String input) {
        rentalService.addVideo(input);
    }

    private static void displayReturnVideoScreen() {
        logger.info("-------------------------------------- Video Returning Screen -------------------------------------");
        logger.info("----------------- please input the video movie title for the video you wish to return -------------");
        logger.info("------------------------------ please input 0 to display the main screen --------------------------");

        boolean notFinished = true;

        while(notFinished) {

            displayAllVideos();
            String input = in.nextLine();
            if ((input).equals("0")) {
                notFinished=false;
            }else{
                boolean returnVideo = returnVideo(input);
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

    private static void displayRentalScreen() {

        logger.info("-------------------------------------- Video Rental Screen -------------------------------------");
        logger.info("----------------- please input the video movie title for the video you wish to rent ------------");
        logger.info("---------------------------- please input 0 to display the main screen -------------------------");

        boolean notFinished = true;

        while(notFinished) {
            displayAllVideos();
            String input = in.nextLine();
            if ((input).equals("0")) {
                notFinished=false;
            }else{
                checkOut(input);
            }

            logger.info("---------------------------- please input 0 to display the main screen -------------------------");

        }

        displayMainMenu();
    }

    private static void checkOut(String input) {
        boolean checkedOut =  rentalService.checkOut(input);

        if(checkedOut) {
            logger.info("Movie {} checked out successfully.\n",input);
        }else{
            logger.info("Movie {} was not checkout please renting another movie.\n", input);
        }
    }

    private static boolean returnVideo(String input) {
        boolean checkedOut =  rentalService.returnVideo(input);

        if(checkedOut) {
            logger.info("Movie {}  returned successfully.\n",input);
        }else{
            logger.info("Movie {} was not return\n", input);
        }

        return  checkedOut;
    }

    private static void displayMainMenu() {
        logger.info("----------------------- Welcome To Video Rental -----------------------");
        logger.info("------------- please input an option from the following selections ------------");
        logger.info("--------------- please input 0 to display the main screen -------------");
        logger.info("1: for renting out movies");
        logger.info("2: for returning rented out movies");
        logger.info("3: for adding a new video to inventory");
        logger.info("-----------------------------------------------------------------------");
    }

    private static void displayAllVideos() {
        logger.info(rentalService.listInventory() + "\n");
    }

    private static void addInitialVideos() {
        rentalService.addVideo("The Matrix");
        rentalService.addVideo("Godfather II");
        rentalService.addVideo("Star Wars Episode IV: A New Hope");
        rentalService.addVideo("ET");
        rentalService.addVideo("War");
        rentalService.addVideo("The Meg");
        rentalService.addVideo("Star Trooper");
        rentalService.addVideo("Avengers");
        rentalService.addVideo("X-Men");
        rentalService.addVideo("I am Java");
    }
}
