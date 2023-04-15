package com.tommisaarnio.ostoslista2;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private String note;

    private boolean important;

    protected static final long serialVersionUID = 142051;


    public Item(String name, String note, boolean important){
        this.name = name;
        this.note = note;
        this.important = important;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    public boolean isImportant() {
        return important;
    }
}
