package com.trackrider.android.ilabankdemoapp.data.repository

import com.trackrider.android.ilabankdemoapp.R
import com.trackrider.android.ilabankdemoapp.model.CarouselData
import com.trackrider.android.ilabankdemoapp.model.CarouselListData

class HomeRepository {

    private val data = mutableListOf<CarouselData>()

    /**
     * Method to generate data for Carousels in HomePage
     *
     * @param carouselCount Defines the number of [CarouselData], default is 1
     * @param carouselItemCount Defines the number of [CarouselListData] in a [CarouselData], default is 1
     *
     * @return Returns a list of Carousel Data after generating a list
     */
    fun generateCarouselData(carouselCount: Int = 1, carouselItemCount: Int = 1): List<CarouselData> {
        data.clear()
        for (i in 1..carouselCount){
            val temp = mutableListOf<CarouselListData>()
            for (j in 1..carouselItemCount){
                temp.add(CarouselListData(
                        carouselId = i,
                        carouselDataId = j,
                        image = R.drawable.logo,
                        label = "Carousel List data $i.$j"
                ))
            }
            data.add(CarouselData(
                    carouselId = i,
                    carouselImage = R.drawable.carousel_image,
                    data = temp
            ))
        }

        return data
    }

    /**
     * Method to get a list of Carousel data
     */
    fun getCarouselData(): List<CarouselData> = data
}