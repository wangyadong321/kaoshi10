package com.example.dong.kaoshi10.bean;

public class Listbean {
    private String title;
    private String name;
    private String html;
    private String url;

    public Listbean(String title, String name, String html, String url) {
        this.title = title;
        this.name = name;
        this.html = html;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Listbean{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", html='" + html + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
