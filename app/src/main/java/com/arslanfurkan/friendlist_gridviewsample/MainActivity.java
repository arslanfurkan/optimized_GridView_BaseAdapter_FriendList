package com.arslanfurkan.friendlist_gridviewsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gv= (GridView) findViewById(R.id.gridView);
        FriendListGridAdapter adapter = new FriendListGridAdapter(this);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, DiaglogActivity.class);

        FriendListViewHolder viewHolder= (FriendListViewHolder) view.getTag();
        Friends gelenFriend= (Friends) viewHolder.imageView.getTag();

        intent.putExtra("resim",gelenFriend.resim);
        intent.putExtra("isim",gelenFriend.isim);
        intent.putExtra("durum",gelenFriend.durum);

        startActivity(intent);
    }
}
