package com.example.dong.kaoshi10;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.dong.kaoshi10.adapter.VpAdapter;
import com.example.dong.kaoshi10.bean.Bean;
import com.example.dong.kaoshi10.fragment.AFragment;
import com.example.dong.kaoshi10.fragment.BFragment;
import com.example.dong.kaoshi10.model.ModelImp;
import com.example.dong.kaoshi10.presenter.PresenterImp;
import com.example.dong.kaoshi10.view.MyView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private TabLayout tab;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        ArrayList<String> list = new ArrayList<>();
        list.add("校门");
        list.add("关注");
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments, list);
        vp.setAdapter(vpAdapter);
        tab.setupWithViewPager(vp);


    }


}
