package com.example.kotlindemo.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * @author TomCan
 * @description:
 * @date:2021/12/8 13:32
 */
public class HomePageContentAdapter2 extends FragmentPagerAdapter {
    private final ArrayList<TabLayout.Tab> tabs;
    ArrayList<Fragment> dataFragments = new ArrayList();

    public HomePageContentAdapter2(FragmentManager fragmentManager, ArrayList<Fragment> dataFragments, ArrayList<TabLayout.Tab> tabs) {
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.dataFragments.clear();
        this.dataFragments.addAll(dataFragments);
        this.tabs = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return dataFragments.get(position);
    }

    @Override
    public int getCount() {
        return dataFragments.size();
    }


    /**
     * 解决tabLayout 在绑定ViewPage（执行setupWithViewPager()方法）后TabLayout上面的TAB文字显示不见
     *
     * @param position
     * @return
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getText();
    }
}
