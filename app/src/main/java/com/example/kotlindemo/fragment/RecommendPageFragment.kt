package com.example.kotlindemo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kotlindemo.R

/**
 * @author TomCan
 * @description:
 * @date:2021/12/8 10:38
 */
class RecommendPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("wyc", "onCreateView")
        return View.inflate(context, R.layout.fragment_recommend_page, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvContent = view.findViewById<TextView>(R.id.tv_content)
        tvContent.setOnClickListener {
            tvContent.scrollBy(0, -30)
            Log.e("wyc", " tvContent.scrollBy(0, -30)")
        }

    }

}