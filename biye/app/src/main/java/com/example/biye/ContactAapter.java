package com.example.biye;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAapter extends ArrayAdapter<contacts> {

    private int resourceId;

    public ContactAapter(Context context, int textViewResourceId,
                         List<contacts>objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View converView, ViewGroup parent){
        contacts contacts = getItem(position);//获取当前实例
        View view;

        if (converView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);


        }else {
            view = converView;
        }

        ImageView contact_image = (ImageView) view.findViewById(R.id.contact_image);
        TextView contact_text = (TextView) view.findViewById(R.id.contact_name);
        contact_image.setImageResource(contacts.getImageId());
        contact_text.setText(contacts.getNames());

        return view;
    }
}
