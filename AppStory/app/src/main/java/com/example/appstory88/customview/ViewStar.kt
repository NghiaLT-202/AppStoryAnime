package com.example.appstory88.customview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import com.example.appstory88.R
import com.example.appstory88.databinding.LayoutViewStarBinding

class ViewStar : LinearLayout {


    var numberStar: Int = 0
    var binding: LayoutViewStarBinding


    init {
        binding = LayoutViewStarBinding.inflate(LayoutInflater.from(context), this, true)
        Log.e("tnghia", "numebr star: " + numberStar)


        layout(0, 0, WRAP_CONTENT, WRAP_CONTENT)
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        val typeArrray = context.theme.obtainStyledAttributes(attrs, R.styleable.ViewStar, 0, 0)
        numberStar = typeArrray.getInteger(R.styleable.ViewStar_numberStar, 0)
        Log.e("tnghia", "numebr star1: " + numberStar)
        when (numberStar) {
            1 -> {
                binding.imStar1.setImageResource(R.drawable.icon_star_48)
                binding.imStar2.setImageResource(R.drawable.icon_star_gray_48)
                binding.imStar3.setImageResource(R.drawable.icon_star_gray_48)
                binding.imStar4.setImageResource(R.drawable.icon_star_gray_48)
                binding.imStar5.setImageResource(R.drawable.icon_star_gray_48)
            }

            2 -> {
                binding.imStar1.setImageResource(R.drawable.icon_star_48)
                binding.imStar2.setImageResource(R.drawable.icon_star_48)
                binding.imStar3.setImageResource(R.drawable.icon_star_gray_48)
                binding.imStar4.setImageResource(R.drawable.icon_star_gray_48)
                binding.imStar5.setImageResource(R.drawable.icon_star_gray_48)
            }


            3 -> {
                binding.imStar1.setImageResource(R.drawable.icon_star_48)
                binding.imStar2.setImageResource(R.drawable.icon_star_48)
                binding.imStar3.setImageResource(R.drawable.icon_star_48)
                binding.imStar4.setImageResource(R.drawable.icon_star_gray_48)
                binding.imStar5.setImageResource(R.drawable.icon_star_gray_48)
            }


            4 -> {
                binding.imStar1.setImageResource(R.drawable.icon_star_48)
                binding.imStar2.setImageResource(R.drawable.icon_star_48)
                binding.imStar3.setImageResource(R.drawable.icon_star_48)
                binding.imStar4.setImageResource(R.drawable.icon_star_48)
                binding.imStar5.setImageResource(R.drawable.icon_star_gray_48)
            }

            5 -> {
                binding.imStar1.setImageResource(R.drawable.icon_star_48)
                binding.imStar2.setImageResource(R.drawable.icon_star_48)
                binding.imStar3.setImageResource(R.drawable.icon_star_48)
                binding.imStar4.setImageResource(R.drawable.icon_star_48)
                binding.imStar5.setImageResource(R.drawable.icon_star_48)
            }
        }
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {


    }

    constructor(
        context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)


}