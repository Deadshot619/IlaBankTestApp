package com.trackrider.android.ilabankdemoapp.model

import androidx.annotation.DrawableRes

data class CarouselListData (
        val carouselId: Int,
        val carouselDataId: Int,
        @DrawableRes val image: Int,
        val label: String
        )