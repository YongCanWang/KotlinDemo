package com.example.kotlindemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.HomePageContentAdapter2
import com.example.kotlindemo.view.QuickViewPage
import com.google.android.material.tabs.TabLayout

/**
 * @author TomCan
 * @description:
 * @date:2021/12/8 10:20
 */
class HomePageFragment : Fragment() {
    lateinit var tlContent: TabLayout
    lateinit var vpContent: QuickViewPage

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return View.inflate(context, R.layout.fragment_home_page, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tlContent = view.findViewById(R.id.tl_content)
        vpContent = view.findViewById(R.id.vp_content)

        val tabs = ArrayList<TabLayout.Tab>()
        tabs.add(tlContent.newTab().setText("tab1"))
        tabs.add(tlContent.newTab().setText("tab2"))
        tabs.add(tlContent.newTab().setText("tab3"))
        tabs.add(tlContent.newTab().setText("tab4"))
        tabs.add(tlContent.newTab().setText("tab5"))
        tabs.add(tlContent.newTab().setText("tab6"))

        val fragments = ArrayList<Fragment>()
        fragments.add(TabFragment("tabFragment1"))
        fragments.add(TabFragment("tabFragment2"))
        fragments.add(TabFragment("tabFragment3"))
        fragments.add(TabFragment("tabFragment4"))
        fragments.add(TabFragment("tabFragment5"))
        fragments.add(TabFragment("tabFragment6"))
        vpContent.adapter = HomePageContentAdapter2(activity!!.supportFragmentManager, fragments, tabs)


        tlContent.addTab(tlContent.newTab().setText("tab1"))
        tlContent.addTab(tlContent.newTab().setText("tab2"))
        tlContent.addTab(tlContent.newTab().setText("tab3"))
        tlContent.addTab(tlContent.newTab().setText("tab4"))
        tlContent.addTab(tlContent.newTab().setText("tab5"))
        tlContent.addTab(tlContent.newTab().setText("tab6"))
        tlContent.setupWithViewPager(vpContent)


    }


}