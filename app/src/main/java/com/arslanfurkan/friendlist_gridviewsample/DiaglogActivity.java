package com.arslanfurkan.friendlist_gridviewsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DiaglogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaglog);

        Intent intent= getIntent();
        if(intent!=null){

            ImageView img = (ImageView) findViewById(R.id.imageViewDialogResim);
            TextView isim = (TextView) findViewById(R.id.textViewDialogName);
            TextView durum = (TextView) findViewById(R.id.textViewState);

            img.setImageResource(intent.getIntExtra("resim",R.mipmap.ic_launcher));
            isim.setText(intent.getStringExtra("isim"));
            durum.setText(intent.getStringExtra("durum"));
        }

    }

    public void DialogKapat(View view ){
        finish();
    }

}
