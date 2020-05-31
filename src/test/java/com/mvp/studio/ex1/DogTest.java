package com.mvp.studio.ex1;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class DogTest {

    @InjectMocks
    Dog dog;

    @Test
    public void givenTimeLessThen4hours_whenNeedsToGo_thenShouldReturnFalse(){

        dog.setDrinkTime(2);
        boolean needsToGo = dog.needsToGo();
        assertThat(needsToGo, is(false));
    }

    @Test
    public void givenTimeMoreThen4hours_whenNeedsToGo_thenShouldReturnTrue(){
        dog.setDrinkTime(6);
        boolean needsToGo = dog.needsToGo();
        assertThat(needsToGo, is(true));
    }

    @Test
    public void givenTimeEqualsTo4hours_whenNeedsToGo_thenShouldReturnFalse(){
        dog.setDrinkTime(4);
        boolean needsToGo = dog.needsToGo();
        assertThat(needsToGo, is(false));
    }

}