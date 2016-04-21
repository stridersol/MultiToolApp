package com.example.strider_sol.multitoolapp.todo;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.strider_sol.multitoolapp.Listener.OnStartDragListener;
import com.example.strider_sol.multitoolapp.R;
import com.example.strider_sol.multitoolapp.common.SimpleItemTouchHelperCallback;
import com.example.strider_sol.multitoolapp.common.demo.SampleData;
import com.example.strider_sol.multitoolapp.models.TodoItem;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoListFragment extends Fragment implements OnStartDragListener {

    private View mRootView;
    private FloatingActionButton mFloatingActionButton;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private TodoListAdapter mAdapter;
    private List<TodoItem> mTodoItems;

    private ItemTouchHelper mItemTouchHelper;

    public ToDoListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mRootView = inflater.inflate(R.layout.fragment_to_do_list, container, false);
        initView();
        return mRootView;
    }

    //infalte the Recycler view
    private void initView() {

        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.xToDoRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //  mTodoItems = SampleData.getSampleNote();
        mTodoItems = SampleData.getSampleTask();
        mAdapter = new TodoListAdapter(mTodoItems, getActivity(), this);

        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);


        mFloatingActionButton = (FloatingActionButton) mRootView.findViewById(R.id.fab);
        if (mFloatingActionButton != null) {
            mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    @Override
    public void OnStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
