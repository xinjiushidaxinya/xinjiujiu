package com.example.biye.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.biye.ChatmsgActivity;
import com.example.biye.ContactAapter;

import com.example.biye.R;
import com.example.biye.contacts;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<contacts> contactsList = new ArrayList<>();
    private ListView listView;
    private ContactAapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        listView = (ListView)view.findViewById(R.id.contact_item);
        adapter = new ContactAapter(getActivity(), R.layout.contacts_item,contactsList);
        listView.setAdapter(adapter);
        initcontats();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contacts contacts = contactsList.get(position);
                String name = contacts.getNames();
                ListView listView1 = (ListView)parent;

                Intent intent = new Intent(getActivity(), ChatmsgActivity.class);

             //   Bundle bundle = new Bundle();
            //    bundle.putString("name", name);
             //   intent.putExtras(bundle);
                startActivity(intent);
            }
        });



    }

    private void initcontats(){
        for(int i = 0;i < 2; i++){
            contacts flower1 = new contacts("王源",R.drawable.flower1);
            contactsList.add(flower1);
            contacts flower2 = new contacts("易烊千玺",R.drawable.flower2);
            contactsList.add(flower2);
            contacts flower3 = new contacts("王俊凯",R.drawable.flower3);
            contactsList.add(flower3);
            contacts flower4 = new contacts("胡歌",R.drawable.flower4);
            contactsList.add(flower4);
            contacts flower5 = new contacts("刘诗诗",R.drawable.flower5);
            contactsList.add(flower5);
            contacts flower6 = new contacts("刘亦菲",R.drawable.flower6);
            contactsList.add(flower6);
            contacts flower7 = new contacts("华晨宇",R.drawable.flower7);
            contactsList.add(flower7);
        }
 }

}