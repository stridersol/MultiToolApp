package com.example.strider_sol.multitoolapp.common.demo;

import com.example.strider_sol.multitoolapp.models.Notes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Strider_sol on 4/12/2016.
 */
public class SampleData {
    public static List<Notes> getSampleNote() {
        List<Notes> sampleNotes = new ArrayList<Notes>();
        ///create some dummy notes


        Notes notes1 = new Notes();
        notes1.setTitle("Chatbir zoo Trip");
        notes1.setContent("Visited chatbir zoo near Chandigarh . Had lot of funs and selfies");

        Calendar calendar1 = GregorianCalendar.getInstance();
        notes1.setDateCreated(calendar1.getTimeInMillis());
        notes1.setDateModified(calendar1.getTimeInMillis());

        //add note to the list of notes
        sampleNotes.add(notes1);

        Notes notes2 = new Notes();
        notes2.setTitle("JoinGYM");
        notes2.setContent("Join up a local, get some abs, girls love abs");

        Calendar calendar2 = GregorianCalendar.getInstance();
        calendar2.add(Calendar.DAY_OF_WEEK, 1);
        calendar2.add(Calendar.MILLISECOND, 13425241);
        notes2.setDateCreated(calendar2.getTimeInMillis());
        notes2.setDateModified(calendar2.getTimeInMillis());

        sampleNotes.add(notes2);


        Notes notes3 = new Notes();
        notes2.setTitle("Favroite");
        notes2.setContent("common apps of the year , gone rouge");

        Calendar calendar3 = GregorianCalendar.getInstance();
        calendar3.add(Calendar.DAY_OF_WEEK, 5);
        calendar3.add(Calendar.MILLISECOND, 53425241);
        notes3.setDateCreated(calendar3.getTimeInMillis());
        notes3.setDateModified(calendar3.getTimeInMillis());

        sampleNotes.add(notes3);

        Notes notes4 = new Notes();
        notes4.setTitle("Hope for life");
        notes4.setContent("indonesia , south Africa Jubliee can ");

        Calendar calendar4 = GregorianCalendar.getInstance();
        calendar4.add(Calendar.DAY_OF_WEEK, 10);
        calendar4.add(Calendar.MILLISECOND, 83425241);
        notes4.setDateCreated(calendar4.getTimeInMillis());
        notes4.setDateModified(calendar4.getTimeInMillis());

        sampleNotes.add(notes4);

        Notes notes5 = new Notes();
        notes5.setTitle("drama of th king");
        notes5.setContent("clickon the gubar a Jubliee can ");

        Calendar calendar5 = GregorianCalendar.getInstance();
        calendar5.add(Calendar.DAY_OF_WEEK, 12);
        calendar5.add(Calendar.MILLISECOND, 443425241);
        notes5.setDateCreated(calendar5.getTimeInMillis());
        notes5.setDateModified(calendar5.getTimeInMillis());

        sampleNotes.add(notes5);

        Notes notes6 = new Notes();
        notes6.setTitle("uber app");
        notes6.setContent("indonesia , south Africa Jubliee can ");

        Calendar calendar6 = GregorianCalendar.getInstance();
        calendar6.add(Calendar.DAY_OF_WEEK, 15);
        calendar6.add(Calendar.MILLISECOND, 99425241);
        notes6.setDateCreated(calendar6.getTimeInMillis());
        notes6.setDateModified(calendar6.getTimeInMillis());

        sampleNotes.add(notes6);

        Notes notes7 = new Notes();
        notes7.setTitle("myhological");
        notes7.setContent("indonesia , south Africa Jubliee can ");

        Calendar calendar7 = GregorianCalendar.getInstance();
        calendar7.add(Calendar.DAY_OF_WEEK, 17);
        calendar7.add(Calendar.MILLISECOND, 678425241);
        notes7.setDateCreated(calendar7.getTimeInMillis());
        notes7.setDateModified(calendar7.getTimeInMillis());

        sampleNotes.add(notes7);

        Notes notes8 = new Notes();
        notes8.setTitle("bumper of car");
        notes8.setContent("indonesia , south Africa Jubliee can ");

        Calendar calendar8 = GregorianCalendar.getInstance();
        calendar8.add(Calendar.DAY_OF_WEEK, 20);
        calendar8.add(Calendar.MILLISECOND, 456425241);
        notes8.setDateCreated(calendar8.getTimeInMillis());
        notes8.setDateModified(calendar8.getTimeInMillis());

        sampleNotes.add(notes8);

        return sampleNotes;
    }
}
