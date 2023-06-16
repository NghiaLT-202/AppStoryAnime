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
            binding.tvTop.text = value
            when (value) {
                "TOP TRUYỆN" -> {
                    binding.layoutRoot.setBackgroundResource(R.drawable.custom_boder_top_story)
                }

                "XẾP HẠNG" -> {
                    binding.layoutRoot.setBackgroundResource(R.drawable.custom_boder_rate)
                }

                "THỂ LOẠI" -> {
                    binding.layoutRoot.setBackgroundResource(R.drawable.custom_boder_category)
                }

                "BOOKMARK" -> {
                    binding.layoutRoot.setBackgroundResource(R.drawable.custom_boder_bookmark)
                }
            }
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