package com.kevin.recycleview1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kevin.recycleview1.Click.ImageClick;
import com.kevin.recycleview1.R;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageListHolder> {

    int[] imageArray;
    ImageClick click;
    Context context;

    public ImageListAdapter(int[] imageArray, ImageClick click) {
        this.imageArray = imageArray;
        this.click = click;
    }

    @NonNull
    @Override
    public ImageListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
        return new ImageListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListAdapter.ImageListHolder holder, int position) {
        Glide.with(context).load(imageArray[position]).into(holder.imgItem);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.getImage(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageArray.length;
    }

    public class ImageListHolder extends RecyclerView.ViewHolder {
        public ImageView imgItem;

        public ImageListHolder(View itemview) {
            super(itemview);
            imgItem = itemview.findViewById(R.id.imgItem);
        }
    }
}
