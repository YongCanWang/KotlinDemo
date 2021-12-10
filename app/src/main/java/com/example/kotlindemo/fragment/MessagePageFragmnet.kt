package com.example.kotlindemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kotlindemo.Constant
import com.example.kotlindemo.R
import com.google.android.material.appbar.CollapsingToolbarLayout

/**
 * @author TomCan
 * @description:
 * @date:2021/12/1 11:19
 *
 */
class MessagePageFragmnet() : Fragment() {

    private lateinit var title: String


    constructor(title: String) : this() {
        this.title = title
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return View.inflate(context, R.layout.fragment_message_page, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.tv_content).text = Constant.FayeWong
        val ctlBar = view.findViewById<CollapsingToolbarLayout>(R.id.ctl_bar)
        ctlBar.title = "Faye Wong"
    }


}