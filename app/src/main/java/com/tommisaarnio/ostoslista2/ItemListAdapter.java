package com.tommisaarnio.ostoslista2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private Context context;
    private ArrayList<Item> items = new ArrayList<>();

    public ItemListAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.itemName.setText(items.get(position).getName());
        holder.itemNote.setText(items.get(position).getNote());
        if (items.get(position).isImportant() == true) {
            holder.itemImportant.setText("***Tämä on supertärkeä!***");
        } else {
            holder.itemImportant.setText("");
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
