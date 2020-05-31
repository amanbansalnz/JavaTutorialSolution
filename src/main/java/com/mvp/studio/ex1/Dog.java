package com.mvp.studio.ex1;

/**
 * TODO: Add a description of the class.
 *
 */
public class Dog {

    private int time;

    // TODO: declare an instance variable to hold the drinking time

    public void setDrinkTime(int time) {
        // TODO: implement method stub
        this.time = time;
    }

    public int getDrinkTime() {
        // TODO: implement method stub
        return time;
    }

    /**
     * The dog needs to go for a walk if it had a drink more than 4 hours ago;
     * i.e., if getDrinkTime() returns true if it has been more then 4 hours
     */
    public boolean needsToGo() {
       boolean needsToGo = false;
        // TODO: implement method stub
        if(time > 4) {
            needsToGo = true;
        }
        return needsToGo;
    }
}
