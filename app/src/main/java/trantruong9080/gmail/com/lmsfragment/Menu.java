package trantruong9080.gmail.com.lmsfragment;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listmenu, container, false);
        String[] menu = getResources().getStringArray(R.array.menudata);
        ListView listView = view.findViewById(R.id.myList);
        listView.setAdapter(new ArrayAdapter<>(getActivity(), R.layout.menu_layout, menu));
        listView.setOnItemClickListener((adapterView, view1, i, l) ->{
            Content content = (Content) getParentFragmentManager().findFragmentById(R.id.fragment2);
            content.updateContent(i);
        });
        return  view;
    }
}
