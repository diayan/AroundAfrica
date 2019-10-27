package com.diayan.aroundafrica.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diayan.aroundafrica.MainActivity
import com.diayan.aroundafrica.R
import com.diayan.aroundafrica.data.OnBoardingItem
import com.diayan.aroundafrica.util.IntentUtil
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {

    private val mutablePageListItemList: MutableList<OnBoardingItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        /**
         * viewpager item to display artist's latest works
         */
        mutablePageListItemList.add(OnBoardingItem("AROUND AFRICA", R.drawable.ic_onbarding_start, getString(R.string.dummy_description_text)))
        mutablePageListItemList.add(OnBoardingItem("AROUND AFRICA", R.drawable.ic_onboarding_2, getString(R.string.dummy_description_text)))
        mutablePageListItemList.add(OnBoardingItem("AROUND AFRICA", R.drawable.ic_onboarding_last, getString(R.string.dummy_description_text)))
        boarding_view_pager.adapter = OnBoardingAdapter(this, mutablePageListItemList)
        walk_through_indicator.setViewPager(boarding_view_pager)

        startNewActivity()
    }

    private fun startNewActivity(){
        start_button.setOnClickListener {
            IntentUtil.start(this, MainActivity::class.java)
        }
    }
}
