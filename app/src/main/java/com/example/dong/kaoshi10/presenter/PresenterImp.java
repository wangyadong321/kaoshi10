package com.example.dong.kaoshi10.presenter;

import com.example.dong.kaoshi10.CallBack;
import com.example.dong.kaoshi10.bean.Bean;
import com.example.dong.kaoshi10.model.Model;
import com.example.dong.kaoshi10.view.MyView;

import java.util.List;

public class PresenterImp implements Presenter, CallBack {
    private Model model;
    private MyView myView;

    public PresenterImp(Model model, MyView myView) {
        this.model = model;
        this.myView = myView;
    }

    @Override
    public void getData() {
        model.getData(this);
    }

    @Override
    public void onSuccess(List<Bean> bean) {
        myView.getData(bean);
    }
}
