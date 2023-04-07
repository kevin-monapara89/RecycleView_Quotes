package com.kevin.recycleview1.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kevin.recycleview1.Click.QuoteClick;
import com.kevin.recycleview1.R;

import java.util.Locale;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesHolder> {

    String[] quotes;
    QuoteClick click;
    Context context;

    public QuotesAdapter(String[] quotes, QuoteClick click) {
        this.quotes = quotes;
        this.click = click;
    }

    @NonNull
    @Override
    public QuotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotesview, parent, false);
        return new QuotesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtquotes.setText(quotes[position]);
//        TextToSpeech tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int i) {
//            }
//        });
//        tts.setLanguage(Locale.forLanguageTag("hi"));
//        tts.setPitch(1);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click.getQuote(quotes[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quotes.length;
    }

    public class QuotesHolder extends RecyclerView.ViewHolder {
        TextView txtquotes;

        public QuotesHolder(@NonNull View itemView) {
            super(itemView);

            txtquotes = itemView.findViewById(R.id.txtquote);
        }
    }
}
