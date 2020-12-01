package com.example.recyclermuiltivewtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.recyclermuiltivewtask.ItemLayout.LayoutOne;
import static com.example.recyclermuiltivewtask.ItemLayout.LayoutTwo;
public class Adapter extends RecyclerView.Adapter{
    Context context;
    private List<ItemLayout> itemClassList;

public Adapter(List<ItemLayout> itemClassList)
        {
        this.itemClassList = itemClassList;
        }

@Override
public int getItemViewType(int position)
        {
        switch (itemClassList.get(position).getViewType()) {
        case 0:
        return LayoutOne;
        case 1:
        return LayoutTwo;
default:
        return -1;
        }
        }

//  classes layout one  ViewHolder.

class LayoutOneViewHolder
        extends RecyclerView.ViewHolder {

    private TextView textview;
    private LinearLayout linearLayout;

    public LayoutOneViewHolder(@NonNull View itemView)
    {
        super(itemView);
        textview = itemView.findViewById(R.id.text);
        linearLayout
                = itemView.findViewById(R.id.linearlayout1);
    }

    private void setView(String text)
    {

        textview.setText(text);
    }
}

//  class  layout two

class LayoutTwoViewHolder
        extends RecyclerView.ViewHolder {

    private ImageView icon;
    private LinearLayout linearLayout;

    public LayoutTwoViewHolder(@NonNull View itemView)
    {
        super(itemView);
        icon = itemView.findViewById(R.id.image);
        linearLayout
                = itemView.findViewById(R.id.linearlayout2);
    }

    private void setViews(int image)
    {
        icon.setImageResource(image);

    }
}

    @NonNull
    @Override
    public RecyclerView.ViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        switch (viewType) {
            case LayoutOne:
                View layoutOne
                        = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.appviewlayout, parent,
                                false);
                return new LayoutOneViewHolder(layoutOne);
            case LayoutTwo:
                View layoutTwo
                        = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.appviewlayout2, parent,
                                false);
                return new LayoutTwoViewHolder(layoutTwo);
            default:
                return null;
        }
    }


    @Override
    public void onBindViewHolder(
            @NonNull RecyclerView.ViewHolder holder,
            int position)
    {

        switch (itemClassList.get(position).getViewType()) {
            case LayoutOne:

                String text
                        = itemClassList.get(position).getText();
                ((LayoutOneViewHolder)holder).setView(text);
                ((LayoutOneViewHolder)holder)
                        .linearLayout.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {

                                Toast
                                        .makeText(
                                                view.getContext(),text
                                                ,
                                                Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });

                break;

            case LayoutTwo:
                int image
                        = itemClassList.get(position).getIcon();

                ((LayoutTwoViewHolder)holder)
                        .setViews(image);
                ((LayoutTwoViewHolder)holder)
                        .linearLayout.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {

                                Toast
                                        .makeText(
                                                view.getContext(),
                                                "Clicked on image",
                                                Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
                break;
            default:
                return;
        }
    }


    @Override
    public int getItemCount()
    {
        return itemClassList.size();
    }
}
