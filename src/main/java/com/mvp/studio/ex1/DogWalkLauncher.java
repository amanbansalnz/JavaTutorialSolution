package com.mvp.studio.ex1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DogWalkLauncher {

    private static Logger logger = LoggerFactory.getLogger(DogWalkLauncher.class);

    public static void main(String[] args) {
        DogOwner owner = new DogOwner();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        // Specify when the dogs last drank.
        dog1.setDrinkTime(2);
        dog2.setDrinkTime(5);

        boolean testDogWalk1 = owner.takeForWalk(dog1);
        boolean testDogWalk2 = owner.takeForWalk(dog2);
        // Test the negation of a condition.

        logger.info("dog1 should return false = {}",  testDogWalk1);
        logger.info("dog1 should return true = {}",  testDogWalk2);
    }
}