package com.tommisaarnio.ostoslista2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.tommisaarnio.ostoslista2.fragments.EtusivuFragment;
import com.tommisaarnio.ostoslista2.fragments.InfoFragment;
import com.tommisaarnio.ostoslista2.fragments.LisaaUusiFragment;
import com.tommisaarnio.ostoslista2.fragments.ListaFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new EtusivuFragment();
            case 1:
                return new ListaFragment();
            case 2:
                return new LisaaUusiFragment();
            case 3:
                return new InfoFragment();
            default:
                return new EtusivuFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
