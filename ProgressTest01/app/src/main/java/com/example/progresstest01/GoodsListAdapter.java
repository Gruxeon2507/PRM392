package com.example.progresstest01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.ViewHolder> {

    private Context context;
    private List<Goods> goodsList;

    public GoodsListAdapter(Context context, List<Goods> goodsList) {
        this.context = context;
        this.goodsList = goodsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_goods, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Goods goods = goodsList.get(position);
        holder.textViewName.setText(goods.getName());
        holder.textViewCode.setText(goods.getCode());
        holder.textViewPrice.setText(goods.getPrice());
        holder.textViewDetail.setText(goods.getDetails());
        holder.textViewType.setText(goods.getType());
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewCode;
        public TextView textViewDetail;
        public TextView textViewType;
        public TextView textViewPrice;
        public ViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.textViewName);
            textViewCode = view.findViewById(R.id.textViewCode);
            textViewDetail = view.findViewById(R.id.textViewDetails);
            textViewType = view.findViewById(R.id.textViewType);
            textViewPrice = view.findViewById(R.id.textViewPrice);
        }
    }
}
