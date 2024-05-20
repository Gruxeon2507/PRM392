package com.example.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<MenuItem> {
    public MenuAdapter(Context context, List<MenuItem> menuItems) {
        super(context, 0, menuItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_item, parent, false);
        }

        MenuItem menuItem = getItem(position);

        ImageView itemImage = convertView.findViewById(R.id.item_image);
        TextView itemName = convertView.findViewById(R.id.item_name);
        TextView itemDescription = convertView.findViewById(R.id.item_description);
        TextView itemPrice = convertView.findViewById(R.id.item_price);

        if (menuItem != null) {
            itemImage.setImageResource(menuItem.getImage());
            itemName.setText(menuItem.getName());
            itemDescription.setText(menuItem.getDescription());
            itemPrice.setText(menuItem.getPrice());
        }

        return convertView;
    }
}

