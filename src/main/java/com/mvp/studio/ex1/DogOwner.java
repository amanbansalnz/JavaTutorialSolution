package com.mvp.studio.ex1;

/**
 * TODO: Add a description of the class.
 *
 */

public class DogOwner {
        /**
         * Take the dog for a walk if it needs to go.
         * @param dog    The dog that needs walking.
         * @return     Whether or not to take the dog for a walk.
         */
        public boolean takeForWalk(Dog dog) {
           return dog.needsToGo();
        }

}
