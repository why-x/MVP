package com.example.edz.mvp.bean;

import java.util.List;

public class MyBanner {

    /**
     * id : 6
     * type : news_type
     * title : 测试资讯上传文章1
     * img_url : https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3936733252,1496860707&fm=26&gp=0.jpg
     * url :
     * infor_title : 资讯标题老师李鹏
     * main_img_url : https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1512370681,599101890&fm=26&gp=0.jpg
     */

    private int id;
    private String type;
    private String title;
    private String img_url;
    private String url;
    private String infor_title;
    private String main_img_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInfor_title() {
        return infor_title;
    }

    public void setInfor_title(String infor_title) {
        this.infor_title = infor_title;
    }

    public String getMain_img_url() {
        return main_img_url;
    }

    public void setMain_img_url(String main_img_url) {
        this.main_img_url = main_img_url;
    }
}
