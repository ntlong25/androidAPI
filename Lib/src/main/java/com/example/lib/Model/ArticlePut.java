package com.example.lib.Model;

public class ArticlePut {
    private String _id;
    private  String groupName;
    private  String title;
    private  String content;
    private  String imageUrl;

    public ArticlePut(String _id, String groupname, String title, String content, String imageUrl) {
        this._id = _id;
        this.groupName = groupname;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }
}
