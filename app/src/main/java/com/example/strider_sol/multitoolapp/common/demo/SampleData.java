package com.example.strider_sol.multitoolapp.common.demo;

import com.example.strider_sol.multitoolapp.models.Notes;
import com.example.strider_sol.multitoolapp.models.TodoItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class SampleData {

    public static List<TodoItem> getSampleTask() {
        List<TodoItem> items = new ArrayList<TodoItem>();
        //create new todo item


        TodoItem item1 = new TodoItem();
        item1.setTitle("Get milk");
        item1.setChecked(true);
        Calendar calender1 = GregorianCalendar.getInstance();
        item1.setDateModified(calender1.getTimeInMillis());
        items.add(item1);

        TodoItem item2 = new TodoItem();
        item2.setTitle("Get milk");
        item2.setChecked(true);
        Calendar calender2 = GregorianCalendar.getInstance();
        calender2.add(Calendar.DAY_OF_WEEK, 2);
        calender2.add(Calendar.MILLISECOND, 24387923);
        item2.setDateModified(calender2.getTimeInMillis());
        items.add(item2);

        TodoItem item3 = new TodoItem();
        item3.setTitle("Get milk");
        item3.setChecked(false);
        Calendar calender3 = GregorianCalendar.getInstance();
        calender3.add(Calendar.DAY_OF_WEEK, 3);
        calender3.add(Calendar.MILLISECOND, 44387923);
        item3.setDateModified(calender3.getTimeInMillis());
        items.add(item3);


        return items;
    }

    public static List<Notes> getSampleNote() {
        List<Notes> sampleNotes = new ArrayList<Notes>();
        //create some notes
        return sampleNotes;
    }

}
