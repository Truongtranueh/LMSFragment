package trantruong9080.gmail.com.lmsfragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.Arrays;

public class Content extends Fragment {
    GridView gridView;
    int exMenu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listcontent, container, false);
        gridView = view.findViewById(R.id.grview);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), Photo.class);
                intent.putExtra("exMenu", exMenu);
                intent.putExtra("exContent", i);
                startActivity(intent);
            }
        });
        updateContent(1);
        return view;
    }
    public void updateContent(int position){
        exMenu = position;
        TypedArray photos = getResources().obtainTypedArray(R.array.contentdata);
        int idphotos = photos.getResourceId(exMenu, R.array.flowers);
        gridView.setAdapter(new PhotoAdapter(getActivity(), getResources().getStringArray(idphotos)));
        photos.recycle();
    }
}
