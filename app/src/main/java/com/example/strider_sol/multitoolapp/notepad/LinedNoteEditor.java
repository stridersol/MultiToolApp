package com.example.strider_sol.multitoolapp.notepad;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.strider_sol.multitoolapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LinedNoteEditor extends Fragment {


    public LinedNoteEditor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lined_note_editor, container, false);
    }

}
