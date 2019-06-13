package com.example.dong.kaoshi10.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Bean {
    @Id
    private Long id;
    private String title;
    private String name;
    private String html;
    private String url;
    @Generated(hash = 1584211345)
    public Bean(Long id, String title, String name, String html, String url) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.html = html;
        this.url = url;
    }
    @Generated(hash = 80546095)
    public Bean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHtml() {
        return this.html;
    }
    public void setHtml(String html) {
        this.html = html;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
 
    

}
