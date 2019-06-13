package com.example.dong.kaoshi10.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.dong.kaoshi10.R;
import com.example.dong.kaoshi10.adapter.Rlv2Adapter;
import com.example.dong.kaoshi10.bean.Bean;
import com.example.dong.kaoshi10.model.ModelImp;
import com.example.dong.kaoshi10.presenter.PresenterImp;
import com.example.dong.kaoshi10.view.MyView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment implements MyView {


    private View view;
    private RecyclerView rlv;
    private ArrayList<Bean> beans;
    private Rlv2Adapter rlv2Adapter;
    private WebView web;

    public BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_b, container, false);
      //  EventBus.getDefault().register(this);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        PresenterImp presenterImp = new PresenterImp(new ModelImp(), this);
        presenterImp.getData();
    }
//    @Subscribe (threadMode = ThreadMode.MAIN)
//    public void String (Bean bean){
//        String url = bean.getUrl();
//        WebSettings settings = web.getSettings();
//        settings.setJavaScriptEnabled(true);
//        web.loadUrl(url);
//        EventBus.getDefault().unregister(this);
//    }

    private void initView(View inflate) {
        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        beans = new ArrayList<>();
        rlv2Adapter = new Rlv2Adapter(getContext(), beans);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        rlv.setAdapter(rlv2Adapter);


       // web = (WebView) inflate.findViewById(R.id.web);

    }

    @Override
    public void getData(List<Bean> bean) {
        beans.addAll(bean);
        rlv2Adapter.notifyDataSetChanged();

    }
}
