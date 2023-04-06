package com.kevin.recycleview1.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kevin.recycleview1.R;

import java.util.Locale;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesHolder> {

    String[] quotes;
    Context context;

    public QuotesAdapter(String[] quotes) {
        this.quotes = quotes;
    }

    @NonNull
    @Override
    public QuotesAdapter.QuotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotesview, parent, false);
        return new QuotesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesAdapter.QuotesHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtquotes.setText(quotes[position]);
        TextToSpeech tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
            }
        });
        tts.setLanguage(Locale.forLanguageTag("hi"));
        tts.setPitch(1);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + quotes[position], Toast.LENGTH_SHORT).show();
                tts.speak(quotes[position], TextToSpeech.QUEUE_ADD, null, null);
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
