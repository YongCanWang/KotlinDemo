package com.example.kotlindemo.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.R

/**
 * @author TomCan
 * @description:
 * @date:2021/12/9 10:04
 */
class SimplenessRecyclerAdapter : RecyclerView.Adapter<SimplenessRecyclerAdapter.MyViewHolder>() {


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(View.inflate(parent.context, R.layout.item_simplenessrecycler, null))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 50
    }


}