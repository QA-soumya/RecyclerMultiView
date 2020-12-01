package com.example.recyclermuiltivewtask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.example.recyclermuiltivewtask.R.drawable.icon1;
import static com.example.recyclermuiltivewtask.R.drawable.icon2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView
                = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<ItemLayout> itemClasses = new ArrayList<>();

        // Even-Image, Odd-Text

        itemClasses.add(new ItemLayout(ItemLayout.LayoutOne,
                "Text 1"));
        itemClasses.add(new ItemLayout(ItemLayout.LayoutTwo, R.drawable.icon2));
        itemClasses.add(new ItemLayout(ItemLayout.LayoutOne, "Text 2"));
        itemClasses.add(new ItemLayout(ItemLayout.LayoutTwo, R.drawable.icon2));
        itemClasses.add(new ItemLayout(ItemLayout.LayoutOne,
                "Text 3"));
        itemClasses.add(new ItemLayout(ItemLayout.LayoutTwo, R.drawable.icon2));
        itemClasses.add(new ItemLayout(ItemLayout.LayoutOne,
                "Text 4"));
        itemClasses.add(new ItemLayout(ItemLayout.LayoutTwo, R.drawable.icon2));
        itemClasses.add(new ItemLayout(ItemLayout.LayoutOne,
                "Text 5"));
        itemClasses.add(new ItemLayout(ItemLayout.LayoutTwo, R.drawable.icon2));
        Adapter adapterClass
                = new Adapter(itemClasses);
        Adapter adapterClass1
                = new Adapter(itemClasses);
        recyclerView.setAdapter(adapterClass1);
    }
}

