package com.example.kiosk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    Context context;
    LayoutInflater inflater;
    int[] arrmenuImage;
    String[] arrmenuname;

    // GirdViewAdapter의 생성자
    public GridViewAdapter(Context context, int[] arrmenuImage, String[] arrmenuname) {
        this.context = context;
        this.arrmenuname = arrmenuname;
        this.arrmenuImage= arrmenuImage;
    }

    public int getCount(){
        return arrmenuname.length;
    }
    public Object getItem(int position){
        return arrmenuname[position];
    }
    public long getItemId(int position){
        return 0;
    }
    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        // "GridView_item" Layout을 inflate하여 convertView 참조 획득.
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        if(view == null){
            view = inflater.inflate(R.layout.griditem, null);
        }
        ImageView numberImage = view.findViewById(R.id.imagemenu);
        TextView numbername = view.findViewById(R.id.menu_name);

        numberImage.setImageResource(arrmenuImage[position]);
        numbername.setText(arrmenuname[position]);

        return view;
    }
}
