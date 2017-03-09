package com.parse.starter.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.parse.starter.fragment.HomeFragment;
import com.parse.starter.fragment.UsuariosFragment;

/**
 * Created by Rafael on 08/03/2017.
 */

public class TabsAdapter extends FragmentStatePagerAdapter {

    private final Context context;
    private String[] abas=new String[]{"HOME","USUÁRIOS"};
    private Fragment fragment;

    public TabsAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
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
        return abas[position];
    }

    @Override
    public int getCount() {
        return 0;
    }
}
