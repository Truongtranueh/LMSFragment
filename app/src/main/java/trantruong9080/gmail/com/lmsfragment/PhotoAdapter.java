package trantruong9080.gmail.com.lmsfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PhotoAdapter extends BaseAdapter {
    Context context;
    String[] photos;

    public PhotoAdapter(Context context, String[] photos) {
        this.context = context;
        this.photos = photos;
    }

    @Override
    public int getCount() {
        return photos.length;
    }

    @Override
    public Object getItem(int i) {
        return photos[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.content_layout,viewGroup, false);
        }
        ImageView imageView = view.findViewById(R.id.myimage);
        Picasso.get().load(photos[i]).resize(600, 600).centerCrop().into(imageView);
        return view;
    }
}
