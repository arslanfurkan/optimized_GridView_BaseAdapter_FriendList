package com.arslanfurkan.friendlist_gridviewsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by furka on 13.02.2019.
 */
 class Friends{

    public String isim;
    public String durum;
    public int resim;

    public Friends(String isim, String durum, int resim){
        this.isim=isim;
        this.durum=durum;
        this.resim=resim;
    }

}

class FriendListViewHolder{
    public ImageView imageView;

    public FriendListViewHolder(View v){

        this.imageView=v.findViewById(R.id.imageView);
    }
}


public class FriendListGridAdapter extends BaseAdapter {
    Context context;
    ArrayList<Friends> friends;

    public  FriendListGridAdapter(Context context){
        this.context=context;
        friends=new ArrayList<Friends>();
        String[] isimler= context.getResources().getStringArray(R.array.isimler);
        String[] durumlar= context.getResources().getStringArray(R.array.durum);
        int [] resimler={R.drawable.friend1,R.drawable.friend2,R.drawable.friend3,
                R.drawable.friend4,R.drawable.friend5,R.drawable.friend6,R.drawable.friend7,R.drawable.friend8, R.drawable.friend9,
                R.drawable.friend10,R.drawable.friend11,R.drawable.friend12,R.drawable.friend13,R.drawable.friend14,R.drawable.friend15,
                R.drawable.friend16,R.drawable.friend17,R.drawable.friend18,R.drawable.friend19,R.drawable.friend20};

        for (int i=0;i<20;i++){
            Friends yeni= new Friends(isimler[i],durumlar[i],resimler[i]);
            friends.add(yeni);

        }

    }





    @Override
    public int getCount() {
        return friends.size();
    }

    @Override
    public Object getItem(int position) {
        return friends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View tek_hucre=convertView;
        FriendListViewHolder viewHolder=null;
        if(tek_hucre==null){
            LayoutInflater inf= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            tek_hucre= inf.inflate(R.layout.tek_hucre,parent,false);
            viewHolder=new FriendListViewHolder(tek_hucre);
            tek_hucre.setTag(viewHolder);
        }
        else{
            viewHolder= (FriendListViewHolder) tek_hucre.getTag();
        }

        Friends friend= friends.get(position);
        viewHolder.imageView.setTag(friend);


        viewHolder.imageView.setImageResource(friend.resim);
        return tek_hucre;
    }
}
