package com.example.democallapi.Adapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.democallapi.R;
import com.example.lib.Model.Article;
import com.squareup.picasso.Picasso;

public class ArticleAdapter extends ArrayAdapter<Article.Data> {

    Activity context;
    int resource;

    public ArticleAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater LayoutInflater = this.context.getLayoutInflater();
        View photoView = LayoutInflater.inflate(this.resource, null);

        ImageView img_Source = photoView.findViewById(R.id.imgSource);
        TextView txtTitle = photoView.findViewById(R.id.txtTitle);
        TextView txtContent = photoView.findViewById(R.id.txtContent);
        TextView txtGroupName = photoView.findViewById(R.id.txtGroupName);

        Article.Data data = getItem(position);

        String photoUrl = "https://scontent.fsgn13-2.fna.fbcdn.net/v/t39.30808-6/241266519_184911220416071_3086572495811781746_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=730e14&_nc_ohc=yR4xxraf528AX-bXV5a&_nc_oc=AQk6KLhrRq6JTBhUNt7ohEy-UF24jXS0mCpiH-J2t-Pz5GI9EbHP3b_ahsLzyEuUsKLd7ItLylx5_BDRpN7r1bdH&_nc_ht=scontent.fsgn13-2.fna&oh=614faf27a5b6594c05675a058e7cbd46&oe=6168781E";
        Picasso.get().load(photoUrl).into(img_Source);
        txtTitle.setText(data.getTitle());
        txtContent.setText(data.getContent());
        txtGroupName.setText(data.getGroupName());

        return photoView;
    }
}
