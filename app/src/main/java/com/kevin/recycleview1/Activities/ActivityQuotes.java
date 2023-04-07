package com.kevin.recycleview1.Activities;


import static com.kevin.recycleview1.R.drawable.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kevin.recycleview1.Adapters.ImageListAdapter;
import com.kevin.recycleview1.Click.ImageClick;
import com.kevin.recycleview1.R;

public class ActivityQuotes extends AppCompatActivity {

    int imgArray[] = {img, img_1, img_2, img_3, img_4, img_5, img_6 };
    RecyclerView imglist;
    TextView txtQuotes;
    ImageView bgimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        imglist = findViewById(R.id.imgList);
        txtQuotes = findViewById(R.id.txtQuote);
        bgimage = findViewById(R.id.bgimage);

        String quote = getIntent().getStringExtra("quote");
        txtQuotes.setText(quote);

        ImageClick click = new ImageClick() {
            @Override
            public void getImage(int pos) {
                Glide.with(ActivityQuotes.this).load(imgArray[pos]).into(bgimage);
            }
        };
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ImageListAdapter adapter = new ImageListAdapter(imgArray,click);
        imglist.setLayoutManager(manager);
        imglist.setAdapter(adapter);
    }
}