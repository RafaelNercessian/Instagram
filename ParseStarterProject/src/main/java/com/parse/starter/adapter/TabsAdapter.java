package com.parse.starter.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.parse.starter.R;
import com.parse.starter.fragment.HomeFragment;
import com.parse.starter.fragment.UsuariosFragment;

/**
 * Created by Rafael on 08/03/2017.
 */

public class TabsAdapter extends FragmentStatePagerAdapter {

    private final Context context;
    private String[] abas=new String[]{"HOME","USUÁRIOS"};
    private Fragment fragment;
    private int[] icones=new int[]{R.drawable.ic_home,R.drawable.ic_people};
    private int tamanhoIcone;

    public TabsAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
        double escala=this.context.getResources().getDisplayMetrics().density;
        tamanhoIcone=(int)(36*escala);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                fragment=new HomeFragment();
                break;
            case 1:
                fragment=new UsuariosFragment();
                break;
        }

        return fragment;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable drawable = ContextCompat.getDrawable(this.context, icones[position]);
        drawable.setBounds(0,0,tamanhoIcone,tamanhoIcone);
        ImageSpan imageSpan=new ImageSpan(drawable);
        SpannableString spannableString=new SpannableString(" ");
        spannableString.setSpan(imageSpan,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    @Override
    public int getCount() {
        return icones.length;
    }
}
