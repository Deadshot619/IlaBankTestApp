package com.trackrider.android.ilabankdemoapp.ui.home

import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.viewpager.widget.ViewPager
import com.trackrider.android.ilabankdemoapp.databinding.FragmentHomeBinding
import com.trackrider.android.ilabankdemoapp.databinding.FragmentSplashBinding
import com.trackrider.android.ilabankdemoapp.ui.base.BaseFragment
import com.trackrider.android.ilabankdemoapp.ui.main.MainActivity
import com.trackrider.android.ilabankdemoapp.ui.main.MainViewModel
import com.trackrider.android.ilabankdemoapp.utils.showToast

class HomeFragment: BaseFragment<MainViewModel, FragmentHomeBinding>() {

    override val mViewModel: MainViewModel by activityViewModels()
    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    lateinit var homeRecyclerAdapter: HomeRecyclerAdapter
    lateinit var homeViewPagerAdapter: HomeViewPagerAdapter

    override fun onBinding() {
        mViewBinding.run {
            lifecycleOwner = viewLifecycleOwner
            viewModel = mViewModel
        }

        setUpListeners()
        setUpRecyclerView()
        setUpObservers()
        setUpViewPager()
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).supportActionBar?.show()
    }

    //Method to setup ViewPager
    private fun setUpViewPager(){
        homeViewPagerAdapter = HomeViewPagerAdapter()
        mViewBinding.vpCarousel.adapter = homeViewPagerAdapter
        mViewBinding.tlBottomDots.setupWithViewPager(mViewBinding.vpCarousel, true)
    }

    //Method to setup RecyclerView
    private fun setUpRecyclerView(){
        homeRecyclerAdapter = HomeRecyclerAdapter()
        mViewBinding.rvCarouselList.run {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            setHasFixedSize(true)
            adapter = homeRecyclerAdapter
        }
        mViewModel.getDataWithRespectToPosition(0)
    }

    //Method to setup Listeners
    private fun setUpListeners() {
//        Carousel
        mViewBinding.vpCarousel.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {

                mViewModel.setDataToCarouselListData(
                    mViewModel.getDataWithRespectToPosition(
                        position
                    )
                )
            }
        })

        //Search
        mViewBinding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                homeRecyclerAdapter.filter.filter(editable.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }

    //Method to setup Observers
    private fun setUpObservers() {
//        Carousel Data
        mViewModel.carouselData.observe(viewLifecycleOwner, {
            homeViewPagerAdapter.addItems(it)
        })

        //Carousel List data
        mViewModel.currentCarouselListData.observe(viewLifecycleOwner, {
            homeRecyclerAdapter.setOriginalList(it)
        })
    }

}