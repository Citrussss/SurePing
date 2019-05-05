package com.sureping.biscuits.dialog;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.PopupWindow;

import androidx.appcompat.widget.ListPopupWindow;

import com.sureping.biscuits.R;

/**
 * @author sureping
 * @create 19-5-2.
 */
public class IosListPopWindowBuilder {
    public static PopupWindow build(Context context) {
        PopupWindow popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setContentView();

//        String[] mGoodArray = {"pencil", "potato", "peanut", "carrot", "cabbage", "cat"};
//        ListPopupWindow mPopup = new ListPopupWindow(context);
//        ArrayAdapter adapter = new ArrayAdapter(context, R.layout.item_select_ios, mGoodArray);
//        mPopup.setAdapter(adapter);
//        mPopup.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
//        mPopup.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//        mPopup.setModal(true);
//        mPopup.setOnItemClickListener((parent, view, position, id) -> {
//        });
//
//        return mPopup;
        return popupWindow;
    }


}
