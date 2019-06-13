package com.example.dong.kaoshi10.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dong.kaoshi10.Main2Activity;
import com.example.dong.kaoshi10.R;
import com.example.dong.kaoshi10.adapter.RlvAdapter;
import com.example.dong.kaoshi10.bean.Bean;
import com.example.dong.kaoshi10.model.ModelImp;
import com.example.dong.kaoshi10.presenter.PresenterImp;
import com.example.dong.kaoshi10.view.MyView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements MyView {


    private View view;
    private RecyclerView rlv;
    private ArrayList<Bean> beans;
    private RlvAdapter rlvAdapter;

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        PresenterImp presenterImp = new PresenterImp(new ModelImp(), this);
       presenterImp.getData();
    }

    private void initView(final View inflate) {
        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        beans = new ArrayList<>();
        rlvAdapter = new RlvAdapter(getContext(), beans);
        rlv.setAdapter(rlvAdapter);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        rlvAdapter.setOnClickListener(new RlvAdapter.OnClickListener() {
            @Override
            public void onCLick(int position) {
                Bean bean = beans.get(position);
                Intent intent = new Intent(getContext(), Main2Activity.class);
                intent.putExtra("name",bean.getHtml());
                startActivity(intent);

            }
        });

    }

    @Override
    public void getData(List<Bean> bean) {
        beans.addAll(bean);
        rlvAdapter.notifyDataSetChanged();

    }
}
