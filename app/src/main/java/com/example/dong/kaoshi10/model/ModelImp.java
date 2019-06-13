package com.example.dong.kaoshi10.model;

import com.example.dong.kaoshi10.CallBack;
import com.example.dong.kaoshi10.bean.Bean;
import com.example.dong.kaoshi10.bean.Listbean;
import com.example.dong.kaoshi10.db.DbUtil;

import java.util.ArrayList;
import java.util.List;

public class ModelImp implements Model {
    @Override
    public void getData(CallBack callBack) {
        ArrayList<Bean> beans = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            DbUtil.getDbUtil().insert(new Bean(Long.valueOf(i),"张三"+i,"你好","https://www.baidu.com/","http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg"));
        }

        List<Bean> query = DbUtil.getDbUtil().query();
        callBack.onSuccess(query);

    }
}
