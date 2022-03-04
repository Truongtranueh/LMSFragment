package trantruong9080.gmail.com.lmsfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Photo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_layout);

        Intent intent = getIntent();
        ImageView imageView = findViewById(R.id.id_photolay);

        int exMenu = intent.getIntExtra("exMenu", 0);
        int exContent = intent.getIntExtra("exContent", 0);
        TypedArray photos = getResources().obtainTypedArray(R.array.contentdata);
        int photoid = photos.getResourceId(exMenu, R.array.animals);
        String urlphoto = getResources().getStringArray(photoid)[exContent];
        photos.recycle();

        Picasso.get().load(urlphoto).resize(600, 600).centerCrop().into(imageView);
    }
}