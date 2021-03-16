package com.trackrider.android.ilabankdemoapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes

data class CarouselData (
        val carouselId: Int,
        @DrawableRes val carouselImage: Int,
        val data: List<CarouselListData>
        )