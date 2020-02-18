package com.example.biye.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.biye.R;

import android.os.Handler;
import android.os.Message;

import java.util.Calendar;
import java.util.TimeZone;

public class NotificationsFragment extends Fragment {
    private static final int msgKey1 = 1;
    private TextView time;
    private ListView clock_item;
    private ArrayAdapter<String> adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        time = root.findViewById(R.id.time);
        new TimeThread().start();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        clock_item =(ListView)view.findViewById(R.id.clock_item);
        String[] data={"18:00","17:00","07:00","06:00","18:00","17:00","07:00","06:00","18:00","17:00","07:00","06:00","18:00","17:00","07:00","06:00"};
        adapter = new ArrayAdapter<String>
                (getActivity(),android.R.layout.simple_list_item_1,data);
        clock_item.setAdapter(adapter);


    }

    public class TimeThread extends Thread {
        @Override
        public void run () {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = msgKey1;
                    mHandler.sendMessage(msg);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while(true);
        }
    }
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage (Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case msgKey1:
                    time.setText(getTime());
                    break;
                default:
                    break;
            }
        }
    };
    //获得当前年月日时分秒星期
    public String getTime(){
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

        String mHour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));//时
        String mMinute = String.valueOf(c.get(Calendar.MINUTE));//分
        String mSecond = String.valueOf(c.get(Calendar.SECOND));//秒

        return mHour+":"+mMinute+":"+mSecond;
    }
}