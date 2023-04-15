package com.tommisaarnio.ostoslista2;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ItemStorage {

    private ArrayList<Item> itemList = new ArrayList<>();

    private static ItemStorage itemStorage = null;


    private ItemStorage(){
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public static ItemStorage getInstance() {
        if (itemStorage == null) {
            itemStorage = new ItemStorage();
        }
        return itemStorage;
    }


    public void addItem (Item item) {
        itemList.add(item);
    }

    public void saveItem(Context context){
        try{
            ItemStorage.getInstance().getItemList();
            ObjectOutputStream itemWriter = new ObjectOutputStream(context.openFileOutput("lista.data", Context.MODE_PRIVATE));
            itemWriter.writeObject(itemList);
            itemWriter.close();
        } catch (IOException e) {
            System.out.println("Ostoksen lisääminen ei onnistunut");
        }
    }

    public void loadItems(Context context){
        try {
            ObjectInputStream itemReader = new ObjectInputStream(context.openFileInput("lista.data"));
            itemList = (ArrayList<Item>) itemReader.readObject();
            itemReader.close();
        } catch (IOException e) {
            System.out.println("Ei onnistu");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
