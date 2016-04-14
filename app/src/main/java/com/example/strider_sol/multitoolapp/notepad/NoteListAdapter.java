package com.example.strider_sol.multitoolapp.notepad;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.strider_sol.multitoolapp.Listener.OnNoteListChangedListener;
import com.example.strider_sol.multitoolapp.Listener.OnStartDragListener;
import com.example.strider_sol.multitoolapp.R;
import com.example.strider_sol.multitoolapp.common.ItemTouchHelperAdapter;
import com.example.strider_sol.multitoolapp.common.ItemTouchHelperViewHolder;
import com.example.strider_sol.multitoolapp.models.Notes;

import java.util.Collections;
import java.util.List;

/**
 * Created by Strider_sol on 4/8/2016.
 */
public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.ViewHolder> implements ItemTouchHelperAdapter {


    private List<Notes> mNotes;
    private Context mContext;

    private OnStartDragListener mDragListener;
    private OnNoteListChangedListener mListListener;

    public NoteListAdapter(Context context, List<Notes> notes, OnStartDragListener dragListener) {
        mContext = context;
        mNotes = notes;
        mDragListener = dragListener;
    }

    public void setNoteListListener(OnNoteListChangedListener listener) {
        mListListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Notes selectedNotes = mNotes.get(position);
        holder.noteTitle.setText(selectedNotes.getTitle());
        holder.noteCreated.setText(selectedNotes.getModifiedDate());

        holder.handleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mDragListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    @Override
    public void OnItemMove(int fromPosition, int toPosition) {
        Collections.swap(mNotes, fromPosition, toPosition);
        mListListener.OnNoteListChanged(mNotes);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void OnItemDismised(int position) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
        public TextView noteTitle, noteCreated;
        public ImageView handleView;

        public ViewHolder(View itemView) {
            super(itemView);

            noteTitle = (TextView) itemView.findViewById(R.id.noteListTitle);
            noteCreated = (TextView) itemView.findViewById(R.id.noteListCreated);
            handleView = (ImageView) itemView.findViewById(R.id.handle);
        }


        @Override
        public void OnItemSelected() {
            itemView.setBackgroundColor(Color.BLUE);

        }

        @Override
        public void OnItemClear() {
            itemView.setBackgroundColor(0);

        }
    }

}
