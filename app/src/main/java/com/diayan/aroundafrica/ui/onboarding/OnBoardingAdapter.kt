package com.diayan.aroundafrica.ui.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.viewpager.widget.PagerAdapter
import com.diayan.aroundafrica.R
import com.diayan.aroundafrica.R.id.boarding_circleImageView
import com.diayan.aroundafrica.R.id.boarding_information_textView
import com.diayan.aroundafrica.data.OnBoardingItem

class OnBoardingAdapter(private var context: Context, private var itemsList: List<OnBoardingItem>) : PagerAdapter() {

    override fun getCount(): Int {
        return itemsList.size
    }

    override fun isViewFromObject(@NonNull view: View, @NonNull `object`: Any): Boolean {
        return view === `object`
    }

    @NonNull
    override fun instantiateItem(@NonNull container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.item_onboarding, container, false) as ViewGroup
        val boardingTitleTextView: TextView = layout.findViewById(R.id.boarding_title_textView)
        val boardingInforTextView = layout.findViewById<TextView>(boarding_information_textView)
        val boardingImageView = layout.findViewById<ImageView>(boarding_circleImageView)

        val pagerItem = itemsList[position]
        boardingTitleTextView.text = pagerItem.title
        boardingInforTextView.text = pagerItem.information
        boardingImageView.setImageResource(pagerItem.imageResource)
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}