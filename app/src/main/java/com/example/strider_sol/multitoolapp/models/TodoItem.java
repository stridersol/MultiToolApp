package com.example.strider_sol.multitoolapp.models;

import com.orm.SugarRecord;

/**
 * Created by Strider_sol on 4/8/2016.
 */
public class TodoItem extends SugarRecord {

    private String title;
    private boolean checked;
    private long dateCreated;
    private long dateModified;


    public TodoItem() {

    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public long getDateModified() {
        return dateModified;
    }

    public void setDateModified(long dateModified) {
        this.dateModified = dateModified;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
