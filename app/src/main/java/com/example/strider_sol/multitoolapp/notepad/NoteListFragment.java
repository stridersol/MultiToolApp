package com.example.strider_sol.multitoolapp.notepad;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.strider_sol.multitoolapp.Listener.OnNoteListChangedListener;
import com.example.strider_sol.multitoolapp.Listener.OnStartDragListener;
import com.example.strider_sol.multitoolapp.R;
import com.example.strider_sol.multitoolapp.common.SimpleItemTouchHelperCallback;
import com.example.strider_sol.multitoolapp.common.demo.SampleData;
import com.example.strider_sol.multitoolapp.models.Notes;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment implements OnStartDragListener {

    private View mRootView;
    private RecyclerView mRecyclerview;
    private RecyclerView.LayoutManager mLayoutManager;

    private NoteListAdapter mNoteListAdapter;
    private List<Notes> mNotes;

    private ItemTouchHelper mItemTouchHelper;


    public NoteListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mRootView = inflater.inflate(R.layout.fragment_note_list, container, false);

        intView();
        return mRootView;
    }

    private void intView() {
        mRecyclerview = (RecyclerView) mRootView.findViewById(R.id.xnote_recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerview.setLayoutManager(mLayoutManager);
        mRecyclerview.setHasFixedSize(true);


        mNotes = SampleData.getSampleNote();
        mNoteListAdapter = new NoteListAdapter(getActivity(), mNotes, this);
        mRecyclerview.setAdapter(mNoteListAdapter);
        mNoteListAdapter.setNoteListListener(new OnNoteListChangedListener() {
            @Override
            public void OnNoteListChanged(List<Notes> notes) {
                List<Long> listOfNoteId = new ArrayList<Long>();
                for (Notes note : notes)
                    listOfNoteId.add(note.getId());
            }
        });


        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mNoteListAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerview);


        FloatingActionButton fab = (FloatingActionButton) mRootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);

    }
}
