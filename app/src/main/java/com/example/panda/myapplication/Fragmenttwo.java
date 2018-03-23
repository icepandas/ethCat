package com.example.panda.myapplication;

/**
 * Created by panda on 2018/3/14.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class Fragmenttwo extends Fragment{

    private GridView gridView3;
    private String[] grid_item3_text=new String[]{"地址:\n昵称:\n总数:\n","地址:\n昵称:\n总数:\n","地址:\n昵称:\n总数:\n","设置"};
    private int[] item_img3=new int[]{R.drawable.slice,R.drawable.slice,R.drawable.slice,R.drawable.slice};
    private List<Map<String,Object>> item3_datas = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragmenttwo, container, false);
        gridView3=(GridView)view.findViewById(R.id.gridView3);
        initData();
        SimpleAdapter adapter =new SimpleAdapter(getActivity(),item3_datas,R.layout.grid_item3,new String[]{"item3_text","item3_img"},new int[]{R.id.item3_text,R.id.item3_img});
        gridView3.setAdapter(adapter);

        gridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==3){
                    Intent intent =new Intent(getActivity(),SettingActivity.class);
                    startActivity(intent);
                }

            }
        });

        return view;
    }

    private void initData() {

        for (int i = 0; i <grid_item3_text.length ; i++) {
            Map<String,Object>item=new HashMap<>();
            item.put("item3_text",grid_item3_text[i]);
            item.put("item3_img",item_img3[i]);
            item3_datas.add(item);
        }

    }

}
