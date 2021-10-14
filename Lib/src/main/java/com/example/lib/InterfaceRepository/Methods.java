package com.example.lib.InterfaceRepository;

import com.example.lib.Model.Article;
import com.example.lib.Model.ArticlePost;
import com.example.lib.Model.ArticlePut;
import com.example.lib.Model.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Methods {

    @GET("articles")
    Call<Article> getArticle();

    @PUT("article/{id}")
    Call<Message> putArticle(@Path("id") String id, @Body ArticlePut article);

    @POST("article")
    Call<Message> postArticle(@Body ArticlePost post);

    @DELETE("article/{id}")
    Call<Message> deleteArticle(@Path("id") String id);
}
