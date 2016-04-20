package com.example.strider_sol.multitoolapp.common;

public interface ItemTouchHelperAdapter {

    //this is called when everytime item is moved
    void OnItemMove(int fromPosition, int toPosition);

    // called when item is dismissed during swipe

    void OnItemDismissed(int position);
}
