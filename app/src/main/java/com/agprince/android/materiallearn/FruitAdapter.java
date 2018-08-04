package com.agprince.android.materiallearn;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private Context mContext;
    private List<Fruit> mFruits;

    public FruitAdapter(List<Fruit> fruits){
        mFruits=fruits;
    }

    static class FruitViewHolder extends RecyclerView.ViewHolder{

        CardView mCardView;
        ImageView mfruitImage;
        TextView mfruitName;

        public FruitViewHolder(View itemView) {
            super(itemView);
            mCardView= (CardView) itemView;
            mfruitImage =itemView.findViewById(R.id.fruit_image);
            mfruitName=itemView.findViewById(R.id.fruit_name);
        }

    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContext ==null){
            mContext=parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item,parent,false);
        final FruitViewHolder viewHolder = new FruitViewHolder(view);
        viewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mFruits.get(position);
                Intent intent = new Intent(mContext,FruitActivity.class);
                intent.putExtra(FruitActivity.FRUIT_NAME,fruit.getName());
                intent.putExtra(FruitActivity.FURIT_IMAGE_ID,fruit.getImageId());
                mContext.startActivity(intent);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        Fruit fruit = mFruits.get(position);
        holder.mfruitName.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(holder.mfruitImage);
    }

    @Override
    public int getItemCount() {
        return mFruits.size();
    }


}
