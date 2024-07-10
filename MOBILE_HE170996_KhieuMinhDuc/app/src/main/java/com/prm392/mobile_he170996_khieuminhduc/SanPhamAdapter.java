package com.prm392.mobile_he170996_khieuminhduc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder> {

    private Context context;
    private ArrayList<SanPham> sanPhamList;
    private OnItemClickListener mListener;

    // Interface for item click listener
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void updateList(ArrayList<SanPham> newList) {
        sanPhamList.clear();
        sanPhamList.addAll(newList);
        notifyDataSetChanged();
    }

    // Setter for item click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    // Constructor
    public SanPhamAdapter(Context context, ArrayList<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    // Create ViewHolder
    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sanpham, parent, false);
        return new SanPhamViewHolder(view, mListener);
    }

    // Bind data to ViewHolder
    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {
        SanPham sanPham = sanPhamList.get(position);
        holder.tvTenSanPham.setText(sanPham.getTen());
        holder.tvMaSanPham.setText(sanPham.getMa());
        holder.tvDonGia.setText(sanPham.getDonGia());
    }

    // Return number of items in list
    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }

    // ViewHolder class
    public static class SanPhamViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTenSanPham;
        public TextView tvMaSanPham;
        public TextView tvDonGia;

        // Constructor
        public SanPhamViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            tvTenSanPham = itemView.findViewById(R.id.tvTenSanPham);
            tvMaSanPham = itemView.findViewById(R.id.tvMaSanPham);
            tvDonGia = itemView.findViewById(R.id.tvDonGia);

            // Item click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

    }
}
