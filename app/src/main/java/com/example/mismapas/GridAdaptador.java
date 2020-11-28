package com.example.mismapas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdaptador extends BaseAdapter {
    Context context;
    int ciudades[];
    LayoutInflater inflter;
    public GridAdaptador(Context applicationContext, int[] ciudades ) {
        this.context = applicationContext;
        this.ciudades = ciudades;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return ciudades.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_gridview, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.icon); // get the reference of ImageView
        icon.setImageResource(ciudades[i]); // set logo images
        return view;
    }
}
