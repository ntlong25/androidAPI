package com.example.lib.Model;

public class ArticlePost {
    private  String groupName;
    private  String title;
    private  String content;
    private  String imageUrl;

    public ArticlePost(String groupname, String title, String content, String imageUrl) {
        this.groupName = groupname;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }
}
