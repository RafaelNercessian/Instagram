package com.parse.starter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.starter.R;

import java.util.List;

/**
 * Created by Rafael on 10/03/2017.
 */

public class HomeAdapater extends ArrayAdapter<ParseObject> {

    private Context context;
    private List<ParseObject> postagens;

    public HomeAdapater(Context context,List<ParseObject> objects) {
        super(context, 0, objects);
        this.context=context;
        this.postagens=objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(view==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_postagem, parent, false);
        }

        if(postagens.size()>0){
            ImageView imagemPostagem = (ImageView) view.findViewById(R.id.image_lista_postagem);
            ParseObject parseObject=postagens.get(position);
            parseObject.getParseFile("imagem");
        }

        return view;
    }
}
