package com.example.aderelemaryidowu.recyclerviewyupdev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FilmDetails extends AppCompatActivity {
    ImageView filmImageView;
    TextView filmNameTextView;
    TextView directorNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_details_layout);
        filmImageView = (ImageView)findViewById(R.id.film_image_details);
        filmNameTextView = (TextView)findViewById(R.id.film_name_details);
        directorNameTextView = (TextView)findViewById(R.id.director_name_details);
        filmImageView.setImageResource(getIntent().getIntExtra("image", 0));
        filmNameTextView.setText("Film Title: " + getIntent().getStringExtra("FilmName"));
        directorNameTextView.setText("Director Name: " + getIntent().getStringExtra("DirectorName"));

    }
}
