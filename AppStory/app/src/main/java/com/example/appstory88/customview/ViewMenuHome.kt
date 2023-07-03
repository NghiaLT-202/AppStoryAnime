package com.example.appstory88.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.appstory88.R
import com.example.appstory88.databinding.ViewMenuHomeBinding


class ViewMenuHome : ConstraintLayout {

    private var textTop: String = ""
        set(value) {
            field = value
            with(binding) {
                tvTop.text = value
                when (value) {
                    "TOP TRUYỆN" -> setView(R.drawable.im_bg_top_story, R.drawable.custom_boder_top_story)
                    "XẾP HẠNG" -> setView(R.drawable.img_bg_rate, R.drawable.custom_boder_rate)
                    "THỂ LOẠI" -> setView(R.drawable.img_bg_category, R.drawable.custom_boder_category)
                    "BOOKMARK" -> setView(R.drawable.img_bg_book_mark, R.drawable.custom_boder_bookmark)
                }
            }
        }

    private fun ViewMenuHomeBinding.setView(image: Int, backgroud: Int) {
        imBg.setImageResource(image)
        viewBackground.setBackgroundResource(backgroud)
    }

    private var textBottom: String = ""
        set(value) {
            field = value
            binding.tvBottom.text = value
        }

    private var binding: ViewMenuHomeBinding =
        ViewMenuHomeBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val typeArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.TextViewHomeMenu, 0, 0)
        textBottom = typeArray.getString(R.styleable.TextViewHomeMenu_textBottom).toString()
        textTop = typeArray.getString(R.styleable.TextViewHomeMenu_textTop).toString()
    }


    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)
}