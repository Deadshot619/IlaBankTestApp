package com.trackrider.android.ilabankdemoapp.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.trackrider.android.ilabankdemoapp.model.CarouselListData
import com.trackrider.android.ilabankdemoapp.ui.home.HomeRecyclerAdapter


/**
 * When there is no [CarouselListData] List data (data is null), hide the [RecyclerView], otherwise show it.
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CarouselListData>?){
    val adapter = recyclerView.adapter as HomeRecyclerAdapter
    adapter.submitList(data)
}
