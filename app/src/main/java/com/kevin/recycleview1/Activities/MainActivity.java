package com.kevin.recycleview1.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.kevin.recycleview1.Adapters.QuotesAdapter;
import com.kevin.recycleview1.R;
import com.kevin.recycleview1.Utils.Utils;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvlist = findViewById(R.id.rcvlist);

        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        QuotesAdapter adapter = new QuotesAdapter(Utils.quotes);
        rcvlist.setLayoutManager(manager);
        rcvlist.setAdapter(adapter);
    }
}