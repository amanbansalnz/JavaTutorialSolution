package com.mvp.studio.rentalapp.challenge;

import com.mvp.studio.rentalapp.challenge.service.PasswordService;
import com.mvp.studio.rentalapp.challenge.service.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class VideoStoreApplication {

    //It is important you understand the use of static keyword
    private static Logger logger = LoggerFactory.getLogger(VideoStoreApplication.class);
    private static RentalService rentalService = new RentalService();
    private static PasswordService passwordService = new PasswordService();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        addInitialVideos();
        displayMainMenu();

        boolean notFinished = true;

        while (notFinished) {
            String input = in.nextLine();

            if (input.equals("1")) {
                displayRentalScreen();
                rent();
            } else if (input.equals("2")) {
                displayReturnVideoScreen();
                returnAndRate();
            } else if (input.equals("3")) {
                displayLoginScreen();
                login();
            } else if (input.equals("0")) {
                notFinished = false;
            } else {
                logger.info("You entered an invalid selection");
            }
            displayMainMenu();
        }
        logger.info("Bye Bye THANK YOU FOR VISITING COME BACK SOON");
    }

    private static void login() {

        while(true) {
            String input = in.nextLine();
            if ((input).equals("0")) {
                break;
            }else{
                if( passwordService.validatePassword(input)){
                    displayAddVideoScreen();
                    addVideoToInventory();
                    break;
                }else{
                    logger.info("Invalid password entered! please try again!");
                }
            }
            displayLoginScreen();
        }
    }

    private static void addVideoToInventory() {

        while (true) {
            displayAllVideos();
            String input = in.nextLine();

            if ((input).equals("0")) {
                break;
            } else {
                rentalService.addVideo(input);
            }
            displayAddVideoScreen();
        }
    }

    private static void returnAndRate() {

        while (true) {
            displayAllVideos();
            String input = in.nextLine();
            if ((input).equals("0")) {
                break;
            } else {

                if (rentalService.returnVideo(input)) {
                    logger.info("Movie {}  returned successfully.\n", input);
                    String videoTitle = input;
                    logger.info("Please input rating 1 - 10 for video {}", videoTitle);
                    input = in.nextLine();
                    rentalService.receiveRating(videoTitle, Integer.valueOf(input));
                    logger.info("Thank you for submitting rating :)");
                } else {
                    logger.info("Movie {} was not return\n", input);
                }
            }

            displayReturnVideoScreen();
        }
    }

    private static void rent() {
        while (true) {
            displayAllVideos();
            String input = in.nextLine();
            if ((input).equals("0")) {
                break;
            } else {
                if (rentalService.checkOut(input)) {
                    logger.info("Movie {} checked out successfully.\n", input);
                } else {
                    logger.info("Movie {} was not checkout it could be already checked out, or could be invalid selection please rent another movie.\n", input);
                }
            }
            displayRentalScreen();
        }
    }

    private static void displayAllVideos() {
        logger.info(rentalService.listInventory() + "\n");
    }

    private static void displayMainMenu() {
        logger.info("----------------------- Welcome To Video Rental -----------------------");
        logger.info("------------- please input an option from the following selections ------------");
        logger.info("1: for renting out movies");
        logger.info("2: for returning rented out movies");
        logger.info("3: for login screen");
        logger.info("0: exit the app ");
        logger.info("-----------------------------------------------------------------------");
    }

    private static void displayReturnVideoScreen() {
        logger.info("-------------------------------------- Video Returning Screen -------------------------------------");
        logger.info("----------------- please input the video movie title for the video you wish to return -------------");
        logger.info("------------------------------ please input 0 to display the main screen --------------------------");
    }

    private static void displayRentalScreen() {
        logger.info("-------------------------------------- Video Rental Screen -------------------------------------");
        logger.info("----------------- please input the video movie title for the video you wish to rent ------------");
        logger.info("---------------------------- please input 0 to display the main screen -------------------------");
    }

    private static void displayAddVideoScreen() {
        logger.info("-------------------------------------- Add Video Screen -------------------------------------");
        logger.info("----------------- please input the video movie title you want to add to inventory -----------------");
        logger.info("------------------------------ please input 0 to display the main screen --------------------------");
    }

    private static void displayLoginScreen() {
        logger.info("------------------------------- Login Screen -----------------------------------");
        logger.info("------------------ please input the secret password to login -------------------");
        logger.info("------------------- please input 0 to display the main screen ------------------");
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
