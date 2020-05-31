package com.mvp.studio.ex2.challenge2.util;

import com.mvp.studio.ex2.challenge2.model.EntertainmentContent;

import java.util.Comparator;

public class EntertainmentContentRatingCompare implements Comparator<EntertainmentContent> {

    public int compare(EntertainmentContent m1, EntertainmentContent m2)
    {
        if (m1.getRating() < m2.getRating()) return 1;
        if (m1.getRating() > m2.getRating()) return -1;
        else return 0;
    }
}
