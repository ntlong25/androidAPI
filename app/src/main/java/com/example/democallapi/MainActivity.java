package com.example.democallapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.lib.RetrofitClient.getRetrofit;

import com.example.democallapi.Adapter.ArticleAdapter;
import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.Article;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArticleAdapter userAdapter;
    Methods methods;
    Button btnPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        methods = getRetrofit().create(Methods.class);
        listView = findViewById(R.id.listPosts);
        btnPost = findViewById(R.id.btnPostActivity);

        userAdapter = new ArticleAdapter(MainActivity.this, R.layout.user_info);

        getArticle();
        
        listView.setAdapter(userAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, ArticleActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("article", userAdapter.getItem(position));
            intent.putExtras(bundle);
            startActivity(intent);
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getArticle() {
        Call<Article> call = methods.getArticle();
        call.enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                Article.Data[] data = response.body().getData();
                for(Article.Data dt : data){
                    userAdapter.add(dt);
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Get Api Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}