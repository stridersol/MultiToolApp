package com.example.strider_sol.multitoolapp.notepad;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.strider_sol.multitoolapp.Listener.OnStartNewFragmentListener;
import com.example.strider_sol.multitoolapp.R;
import com.example.strider_sol.multitoolapp.common.Constant;
import com.example.strider_sol.multitoolapp.models.Notes;
import com.google.gson.Gson;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class LineNoteEditor extends Fragment {
    private EditText mTitleEditText, mContentEditText;
    private View mRootView;

    private boolean InEditMode = false;

    private OnStartNewFragmentListener mCallback;

    private Notes mCurrentNote = null;

    public LineNoteEditor() {
        // Required empty public constructor
    }

    public static LineNoteEditor newInstance(String serializedNote) {
        LineNoteEditor fragment = new LineNoteEditor();
        if (!serializedNote.isEmpty()) {
            Bundle args = new Bundle();
            args.putString(Constant.SERIALIZED_NOTES, serializedNote);
            fragment.setArguments(args);
        }
        return fragment;
    }

    private void getNote() {
        Bundle args = getArguments();
        if (args != null) {
            if (args.containsKey(Constant.SERIALIZED_NOTES)) {
                //ve have an edit mode
                String jsonNote = args.getString(Constant.SERIALIZED_NOTES);
                Gson gson = new Gson();
                mCurrentNote = gson.fromJson(jsonNote, Notes.class);

                if (mCurrentNote != null && mCurrentNote.getId() != null && mCurrentNote.getId() > 0) {
                    InEditMode = true;
                }
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_line_note_editor, container, false);
        mTitleEditText = (EditText) mRootView.findViewById(R.id.xETitle);
        mContentEditText = (EditText) mRootView.findViewById(R.id.xEBody);

        getNote();
        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (InEditMode) {
            populateNote();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.lined_editor_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                saveNoteConfirmation();
                mCallback.onStartNewFragment(new NoteListFragment(), getString(R.string.note_list));
                break;
            case R.id.action_delete:
                if (InEditMode) {
                    askForConfirmation();
                } else {
                    Snackbar.make(mRootView, "Save note before deleting !", Snackbar.LENGTH_SHORT).show();
                }
        }
        return super.onOptionsItemSelected(item);
    }

    private void askForConfirmation() {
        final String titleOfNote = mCurrentNote.getTitle();
        titleOfNote.toUpperCase();

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle("Delete '" + titleOfNote + "' ?")
                .setMessage("Are you sure you want to delete '" + titleOfNote + "' ?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mCurrentNote.delete();
                mCallback.onStartNewFragment(new NoteListFragment(), "Note List");
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }


    private void saveNoteConfirmation() {
        if (InEditMode) {
            if (saveNote()) {
                Snackbar.make(mRootView, R.string.note_updated, Snackbar.LENGTH_SHORT).show();
            }
        } else {
            if (!saveNote()) {
                Snackbar.make(mRootView, R.string.note_not_saved, Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    private boolean saveNote() {
        String title = mTitleEditText.getText().toString();
        String content = mContentEditText.getText().toString();

        if (TextUtils.isEmpty(title)) {
            mTitleEditText.setError(getString(R.string.Titleisrequired));
            return false;

        }
        if (TextUtils.isEmpty(content)) {
            mContentEditText.setError(getString(R.string.Contentisrequired));
            return false;
        }
        Notes notes = new Notes();
        notes.setTitle(title);
        notes.setContent(content);
        notes.setDateCreated(Calendar.getInstance().getTimeInMillis());
        notes.setDateModified(Calendar.getInstance().getTimeInMillis());
        notes.save();

        Snackbar.make(mRootView, "note '" + notes.getId() + "is created'", Snackbar.LENGTH_SHORT).show();
        return true;

    }

    private void populateNote() {
        mTitleEditText.setText(mCurrentNote.getTitle());
        mContentEditText.setText(mCurrentNote.getContent());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnStartNewFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnStartNewFragmentListener");
        }
    }
}
