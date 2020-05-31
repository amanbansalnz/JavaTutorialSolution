package com.mvp.studio.ex2;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class ReviewerTest {

    @InjectMocks
    Reviewer reviewer;

    @Test
    public void givenArrayOfRating_whenIndexOfHighestRating_thenReturnHighestRatingIndex(){
        reviewer.setRating(0, 3);
        reviewer.setRating(1, 4);
        reviewer.setRating(2, 5);
        reviewer.setRating(3, 10);
        reviewer.setRating(4, 1);

       int index = reviewer.indexOfHighestRating();

       assertThat(index, is(3));
    }

    @Test
    public void givenEmptyArrayOfRating_whenIndexOfHighestRating_thenReturnDefault(){
        int index = reviewer.indexOfHighestRating();
        assertThat(index, is(0));
    }

}
