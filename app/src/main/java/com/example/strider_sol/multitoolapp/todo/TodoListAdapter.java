package com.example.strider_sol.multitoolapp.todo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.strider_sol.multitoolapp.Listener.OnStartDragListener;
import com.example.strider_sol.multitoolapp.R;
import com.example.strider_sol.multitoolapp.common.ItemTouchHelperAdapter;
import com.example.strider_sol.multitoolapp.common.ItemTouchHelperViewHolder;
import com.example.strider_sol.multitoolapp.models.TodoItem;

import java.util.Collections;
import java.util.List;


public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder>
        implements ItemTouchHelperAdapter {
    private List<TodoItem> mTodoItems;//represents the data in the form of array

    private Context mContext;

    private OnStartDragListener mDragListener;


    public TodoListAdapter(List<TodoItem> Items, Context context, OnStartDragListener dragListener) {
        mTodoItems = Items;
        mContext = context;
        mDragListener = dragListener;
    }

    @Override
    public int getItemCount() {
        return mTodoItems.size();
    }

    //activity is made at backend
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View rowView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_todo_list, parent, false);
        ViewHolder ViewHolder = new ViewHolder(rowView);
        return ViewHolder;
    }

    //main funtionality present here
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final TodoItem selectedTodo = mTodoItems.get(position);//holds the position for selected item

        holder.mToDoCheckbox.setText(selectedTodo.getTitle());

        if (selectedTodo.isChecked()) {
            holder.mToDoDate.setVisibility(View.VISIBLE);
            holder.mToDoDate.setText(selectedTodo.getReadableModifiedDate());
            holder.mToDoCheckbox.setChecked(true);
            holder.mToDoCheckbox.setPaintFlags(holder.mToDoCheckbox.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        holder.mHandleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mDragListener.OnStartDrag(holder);
                }
                return false;
            }
        });

    }

    @Override
    public void OnItemMove(int fromPosition, int toPosition) {
        Collections.swap(mTodoItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);

    }

    @Override
    public void OnItemDismissed(int position) {

    }


    //holds the view of Recycler view
    public static class ViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

        public TextView mToDoDate;
        public CheckBox mToDoCheckbox;
        public ImageView mHandleView;


        public ViewHolder(View itemView) {
            super(itemView);
            mToDoDate = (TextView) itemView.findViewById(R.id.todoListTitle);
            mToDoCheckbox = (CheckBox) itemView.findViewById(R.id.todoListcheckbox);
            mHandleView = (ImageView) itemView.findViewById(R.id.handle);

        }

        @Override
        public void OnItemSelected() {
            itemView.setBackgroundColor(Color.rgb(222, 185, 11));

        }

        @Override
        public void OnItemClear() {
            itemView.setBackgroundColor(Color.rgb(237, 227, 176));
        }
    }
}

