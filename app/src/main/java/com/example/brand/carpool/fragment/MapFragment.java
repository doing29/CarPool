package com.example.brand.carpool.fragment;

/*
 *  项目名：  Carpool
 *  包名：    com.example.brand.carpool.fragment
 *  文件名:   MapFragment
 *  创建者:
 *  创建时间:  2018/08/24 22:50
 *  描述：    Map
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brand.carpool.R;


public class MapFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, null);
        return view;
    }
}
