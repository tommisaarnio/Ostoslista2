package com.tommisaarnio.ostoslista2.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.tommisaarnio.ostoslista2.Item;
import com.tommisaarnio.ostoslista2.ItemStorage;
import com.tommisaarnio.ostoslista2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LisaaUusiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LisaaUusiFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private EditText name;
    private EditText note;

    private Context context;

    private CheckBox important;

    private Boolean imp;

    public LisaaUusiFragment() {
        // Required empty public constructor
    }

    public static LisaaUusiFragment newInstance(String param1, String param2) {
        LisaaUusiFragment fragment = new LisaaUusiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lisaa_uusi, container, false);
        Button addItem = view.findViewById(R.id.btnAddItem);
        name = view.findViewById(R.id.txtItem);
        note = view.findViewById(R.id.txtNote);
        important = view.findViewById(R.id.cbImportant);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addToList();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Do any additional view setup here if needed
    }

    public void addToList(){
        String itemName = name.getText().toString();
        String itemNote = note.getText().toString();
        if (important.isChecked()) {
            imp = true;
        } else {
            imp = false;
        }
        Item item = new Item(itemName, itemNote, imp);
        ItemStorage.getInstance().addItem(item);
        ItemStorage.getInstance().saveItem(context);
    }


}
