package com.example.muscle_studio_100;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.muscle_studio_100.fragments.FemaleFragment;
import com.example.muscle_studio_100.fragments.MaleFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new MaleFragment();
            case 1:
                return new FemaleFragment();

            default:
                return new MaleFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
