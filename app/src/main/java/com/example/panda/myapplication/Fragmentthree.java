package com.example.panda.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by panda on 2018/3/14.
 */

public class Fragmentthree extends Fragment {
    private GridView gridView2;
    private String[] grid_item_text=new String[]{"状态","消息2","消息3","消息4"};
    private int[] item_img2=new int[]{R.drawable.slice,R.drawable.slice,R.drawable.slice,R.drawable.slice};
    private List<Map<String,Object>> item2_datas = new ArrayList<>();

    private static final String TAG = "Fragmentthree";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragmentthree, container, false);
        gridView2=(GridView)view.findViewById(R.id.gridView2);
        initData();
        final SimpleAdapter adapter =new SimpleAdapter(getActivity(),item2_datas,R.layout.grid_item2,new String[]{"item2_text","item2_img"},new int[]{R.id.item2_text,R.id.item2_img});
        gridView2.setAdapter(adapter);

        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),grid_item_text[position],Toast.LENGTH_SHORT).show();
            }
        });


        return view;

    }

    private void initData() {
        for (int i = 0; i <grid_item_text.length ; i++) {
            Map<String,Object>item=new HashMap<>();
            item.put("item2_text",grid_item_text[i]);
            item.put("item2_img",item_img2[i]);
            item2_datas.add(item);
        }
    }



}
