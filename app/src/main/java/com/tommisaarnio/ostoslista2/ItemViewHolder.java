package com.tommisaarnio.ostoslista2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    TextView itemName, itemNote, itemImportant;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.txtItemName);
        itemNote = itemView.findViewById(R.id.txtItemNote);
        itemImportant = itemView.findViewById(R.id.txtImportant);

    }
}
