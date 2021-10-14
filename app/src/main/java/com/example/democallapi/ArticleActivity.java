package com.example.democallapi;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.Article;
import com.example.lib.Model.ArticlePut;
import com.example.lib.Model.Message;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleActivity extends AppCompatActivity {

    ImageView imgSource;
    EditText edtGroupName, edtTitle, edtContent;
    TextView txtId;
    Button btnUpdate, btnDelete;
    String photoUrl = "https://scontent.fsgn13-2.fna.fbcdn.net/v/t39.30808-6/241266519_184911220416071_3086572495811781746_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=730e14&_nc_ohc=yR4xxraf528AX-bXV5a&_nc_oc=AQk6KLhrRq6JTBhUNt7ohEy-UF24jXS0mCpiH-J2t-Pz5GI9EbHP3b_ahsLzyEuUsKLd7ItLylx5_BDRpN7r1bdH&_nc_ht=scontent.fsgn13-2.fna&oh=614faf27a5b6594c05675a058e7cbd46&oe=6168781E";
    Methods methods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        imgSource = findViewById(R.id.imgSource);
        edtGroupName = findViewById(R.id.edtGroupName);
        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);
        txtId = findViewById(R.id.txtId);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        methods = getRetrofit().create(Methods.class);

        Article.Data data = (Article.Data) getIntent().getExtras().get("article");
        setData(data);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putArticle();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteArticle();
            }
        });

    }

    private void deleteArticle() {
        String id = txtId.getText().toString();
        Call<Message> call = methods.deleteArticle(id);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Toast.makeText(ArticleActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(ArticleActivity.this, "Delete Api Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void putArticle() {
        String id = txtId.getText().toString();
        String groupName = edtGroupName.getText().toString();
        String title = edtTitle.getText().toString();
        String content = edtContent.getText().toString();
        ArticlePut article = new ArticlePut(id, groupName, title, content, photoUrl);
        Call<Message> call = methods.putArticle(id, article);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Toast.makeText(ArticleActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(ArticleActivity.this, "Delete Api Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setData(Article.Data data){
        Picasso.get().load(photoUrl).into(imgSource);
        txtId.setText(data.get_id());
        edtGroupName.setText(data.getGroupName());
        edtTitle.setText(data.getTitle());
        edtContent.setText(data.getContent());
    }
}