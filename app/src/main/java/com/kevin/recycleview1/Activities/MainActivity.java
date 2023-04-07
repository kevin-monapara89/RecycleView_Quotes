package com.kevin.recycleview1.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.kevin.recycleview1.Adapters.QuotesAdapter;
import com.kevin.recycleview1.Click.QuoteClick;
import com.kevin.recycleview1.R;
import com.kevin.recycleview1.Utils.Utils;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvlist = findViewById(R.id.rcvlist);

        QuoteClick click = new QuoteClick() {
            @Override
            public void getQuote(String quote) {
                Intent intent = new Intent(MainActivity.this, ActivityQuotes.class);
                intent.putExtra("quote",quote);
                startActivity(intent);
            }
        };

        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        QuotesAdapter adapter = new QuotesAdapter(Utils.quotes,click);
        rcvlist.setLayoutManager(manager);
        rcvlist.setAdapter(adapter);
    }
}