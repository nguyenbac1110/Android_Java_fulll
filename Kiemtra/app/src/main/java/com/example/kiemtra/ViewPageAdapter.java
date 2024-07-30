package com.example.kiemtra;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageAdapter extends FragmentStateAdapter {

    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new Fragment_blank();
            case 1: return new Fragment_blank2();
            case 3: return new Fragment_blank3();
        }
        return new Fragment_blank();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
