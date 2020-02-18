package com.example.biye.ui.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.biye.R;
import com.example.biye.ZhichuFragment;
import com.example.biye.shouruFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    private LayoutInflater inflater;
    private View rootView;// 缓存Fragment view
    private Context zhuyeActivity;
    private ZhichuFragment twoToOne;
    private shouruFragment twoToTwo;
    /**
     * one、two RadioGroup 控件
     */
    protected Button twoOne, twoTwo;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        zhuyeActivity = getActivity();
        inflater = LayoutInflater.from(getActivity());
//      初始化控件和声明事件
//        rootView = inflater.inflate(R.layout.two, null);
        twoOne = (Button) getActivity().findViewById(R.id.zhichu);
        twoOne.setOnClickListener(this);
        twoTwo = (Button) getActivity().findViewById(R.id.shouru);
        twoTwo.setOnClickListener(this);
        //控件颜色
        twoOne.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        twoTwo.setTextColor(getResources().getColor(R.color.black));

        setDefaultFragment();
    }


    private void setDefaultFragment()
    {
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        twoToOne = new ZhichuFragment();
        transaction.add(R.id.xia_fragment, twoToOne).commit();//??
    }


    @Override
    public void onClick(View v) {
        FragmentManager fm = getChildFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();

        switch (v.getId())
        {
            case R.id.zhichu:
                if (twoToOne == null)
                {
                    twoToOne = new ZhichuFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.xia_fragment, twoToOne);
                transaction.addToBackStack(null);//添加fragment到返回栈
                transaction.commit();
                //控件颜色
                twoOne.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                twoTwo.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.shouru:
                if (twoToTwo == null)
                {
                    twoToTwo = new shouruFragment();
                }
                transaction.replace(R.id.xia_fragment, twoToTwo);
                transaction.addToBackStack(null);//添加fragment到返回栈
                transaction.commit();
                //控件颜色
                twoOne.setTextColor(getResources().getColor(R.color.black));
                twoTwo.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
        }
        // transaction.addToBackStack();
        // 事务提交
        //transaction.commit();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_dashboard, null);

    }

}