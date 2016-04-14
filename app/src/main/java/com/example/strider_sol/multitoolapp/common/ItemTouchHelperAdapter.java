package com.example.strider_sol.multitoolapp.common;

/**
 * Created by Strider_sol on 4/14/2016.
 */
public interface ItemTouchHelperAdapter {

    // this is called when everytime item is moved

    void OnItemMove(int fromPosition, int toPosition);

    //called when item is dismissed during swipe

    void OnItemDismised(int position);
}
