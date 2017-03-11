package com.parse.starter.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.starter.R;
import com.parse.starter.activity.FeedUsuariosActivity;
import com.parse.starter.adapter.UsuariosAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsuariosFragment extends Fragment {

    private ListView listView;
    private ArrayList<ParseUser> usuarios = new ArrayList<>();
    private ParseQuery<ParseUser> query;
    private UsuariosAdapter usuariosAdapter;


    public UsuariosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_usuarios, container, false);
        listView = (ListView) view.findViewById(R.id.list_usuarios);
        getUsuarios();
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               ParseUser parseUser=usuarios.get(position);
               Intent intent = new Intent(getActivity(), FeedUsuariosActivity.class);
               intent.putExtra("username",parseUser.getUsername());
               startActivity(intent);
           }
       });
        return view;
    }

    private void getUsuarios() {
        query = ParseUser.getQuery();
        query.whereNotEqualTo("username", ParseUser.getCurrentUser().getUsername());
        query.orderByAscending("username");
        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if (e == null) {
                    usuarios.clear();
                    if (objects.size() > 0) {
                        for (ParseUser user : objects) {
                            usuarios.add(user);
                        }
                    }
                }else{
                    e.printStackTrace();
                }
                usuariosAdapter = new UsuariosAdapter(getActivity(), usuarios);
                listView.setAdapter(usuariosAdapter);
            }
        });
    }

}
