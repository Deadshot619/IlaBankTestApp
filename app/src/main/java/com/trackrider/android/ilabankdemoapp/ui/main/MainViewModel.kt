package com.trackrider.android.ilabankdemoapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trackrider.android.ilabankdemoapp.data.repository.HomeRepository
import com.trackrider.android.ilabankdemoapp.model.CarouselData
import com.trackrider.android.ilabankdemoapp.model.CarouselListData
import java.text.FieldPosition

class MainViewModel: ViewModel() {

    companion object{
        private const val NO_OF_CAROUSEL_DATA = 10
        private const val NO_OF_CAROUSEL_ITEM_DATA = 10
    }

    private val repository = HomeRepository()

    private val _carouselData = MutableLiveData<List<CarouselData>>()
    val carouselData: LiveData<List<CarouselData>>
        get() = _carouselData

    private val _currentCarouselListData = MutableLiveData<List<CarouselListData>>()
    val currentCarouselListData: LiveData<List<CarouselListData>>
        get() = _currentCarouselListData

    init {
        _carouselData.value = repository.generateCarouselData(carouselCount = NO_OF_CAROUSEL_DATA, carouselItemCount = NO_OF_CAROUSEL_ITEM_DATA)
    }

    /**
     * Method to set list of [CarouselListData] to [_currentCarouselListData]
     */
    fun setDataToCarouselListData(carouselListData: List<CarouselListData>){
        _currentCarouselListData.value = carouselListData
    }

    fun getDataWithRespectToPosition(position: Int): List<CarouselListData>{
        return _carouselData.value?.get(position)?.data ?: listOf()
    }
}