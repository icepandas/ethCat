package com.example.panda.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * Created by panda on 2018/3/14.
 */


public class Fragmentone extends Fragment {
    private GridView gridView;
    private String[] names=new String[]{"getId()","getName()","getFuncy()","getNew()"};
    private int[] imgIds=new int[]{R.drawable.slice,R.drawable.slice,R.drawable.slice,R.drawable.slice};
    private List<Map<String,Object>> datas = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragmentone, container, false);

        gridView=(GridView)view.findViewById(R.id.gridView);
        initData();
        SimpleAdapter adapter =new SimpleAdapter(getActivity(),datas,R.layout.grid_item,new String[]{"name","imgId"},new int[]{R.id.name,R.id.img});
        gridView.setAdapter(adapter);

        return view;
    }


    private void initData() {
        for (int i = 0; i <names.length ; i++) {
            Map<String,Object>item=new HashMap<>();
            item.put("name",names[i]);
            item.put("imgId",imgIds[i]);
            datas.add(item);
        }
    }

}
