package com.example.strider_sol.multitoolapp.todo;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.strider_sol.multitoolapp.R;
import com.example.strider_sol.multitoolapp.models.TodoItem;

import java.util.List;


public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder> {
    private List<TodoItem> mTodoItems;//represents the data in the form of array

    private Context mContext;

    public TodoListAdapter(List<TodoItem> Items, Context context) {
        mTodoItems = Items;
        mContext = context;
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TodoItem selectedTodo = mTodoItems.get(position);

        holder.mToDoCheckbox.setText(selectedTodo.getTitle());

        if (selectedTodo.isChecked()) {
            holder.mToDoDate.setVisibility(View.VISIBLE);
            holder.mToDoDate.setText(selectedTodo.getReadableModifiedDate());
            holder.mToDoCheckbox.setChecked(true);
            holder.mToDoCheckbox.setPaintFlags(holder.mToDoCheckbox.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }

    }

    //holds the view of Recycler view
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mToDoDate;
        public CheckBox mToDoCheckbox;
        public ImageView mHandleView;


        public ViewHolder(View itemView) {
            super(itemView);
            mToDoDate = (TextView) itemView.findViewById(R.id.todoListTitle);
            mToDoCheckbox = (CheckBox) itemView.findViewById(R.id.todoListcheckbox);
            mHandleView = (ImageView) itemView.findViewById(R.id.handle);


        }
    }
}

