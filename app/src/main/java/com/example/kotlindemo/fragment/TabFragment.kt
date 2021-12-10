package com.example.kotlindemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.SimplenessRecyclerAdapter


/**
 * @author TomCan
 * @description:
 * @date:2021/12/8 13:49
 */
class TabFragment() : Fragment() {

    var textContent: String = "tabFragment1"


    constructor(textContent: String) : this() {
        this.textContent = textContent
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        when (textContent) {
            "tabFragment1" ->
                return View.inflate(context, R.layout.fragment_tab, null)

            "tabFragment2" ->
                return View.inflate(context, R.layout.fragment_tab, null)

            "tabFragment1" ->
                return View.inflate(context, R.layout.fragment_tab, null)
        }
        return View.inflate(context, R.layout.fragment_tab, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.tv_content).text = textContent
        val rvDataList = view.findViewById<RecyclerView>(R.id.rv_datalist)

        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        linearLayoutManager.reverseLayout = false

        val mManagerLayout = GridLayoutManager(activity, 2)

        rvDataList.layoutManager = mManagerLayout


        rvDataList.adapter = SimplenessRecyclerAdapter()
    }


}