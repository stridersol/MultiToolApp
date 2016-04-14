package com.example.strider_sol.multitoolapp.Listener;

import com.example.strider_sol.multitoolapp.models.Notes;

import java.util.List;

/**
 * Created by Strider_sol on 4/14/2016.
 */
public interface OnNoteListChangedListener {
    void OnNoteListChanged(List<Notes> notes);
}
