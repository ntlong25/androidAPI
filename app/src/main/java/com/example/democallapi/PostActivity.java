package com.example.democallapi;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.ArticlePost;
import com.example.lib.Model.Message;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    CircleImageView imgImage;
    EditText edtGroupName, edtTitle, edtContent, edtImage;
    Button btnPost;
    String photoUrl = "https://scontent.fsgn13-2.fna.fbcdn.net/v/t39.30808-6/241266519_184911220416071_3086572495811781746_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=730e14&_nc_ohc=yR4xxraf528AX-bXV5a&_nc_oc=AQk6KLhrRq6JTBhUNt7ohEy-UF24jXS0mCpiH-J2t-Pz5GI9EbHP3b_ahsLzyEuUsKLd7ItLylx5_BDRpN7r1bdH&_nc_ht=scontent.fsgn13-2.fna&oh=614faf27a5b6594c05675a058e7cbd46&oe=6168781E";
    Methods methods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        setUp();

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postArticle();
            }
        });
    }

    private void postArticle() {
        String groupName = edtGroupName.getText().toString();
        String title = edtTitle.getText().toString();
        String content = edtContent.getText().toString();
        ArticlePost post = new ArticlePost(groupName, title, content, photoUrl);
        Call<Message> call = methods.postArticle(post);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Toast.makeText(PostActivity.this, "Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(PostActivity.this, "Post Api Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setUp() {
        imgImage = findViewById(R.id.imgPost);
        Picasso.get().load(photoUrl).into(imgImage);
        edtGroupName = findViewById(R.id.edtGroupName);
        edtGroupName.setText("18DTHC5_Nhom 11");
        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);
        edtImage = findViewById(R.id.edtImage);
        edtImage.setText(photoUrl);
        btnPost = findViewById(R.id.btnPost);
        methods = getRetrofit().create(Methods.class);
    }
}