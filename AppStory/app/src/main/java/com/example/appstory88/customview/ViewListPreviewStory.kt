package com.example.appstory88.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.appstory88.adapter.ListStoryPreviewAdapter
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.databinding.ViewListStoryBinding
import com.example.appstory88.model.Story


class ViewListPreviewStory : ConstraintLayout {

    private var binding: ViewListStoryBinding =
        ViewListStoryBinding.inflate(LayoutInflater.from(context), this, true)

    var textCategory: String = ""
        set(value) {
            field = value
            binding.tvTitle.text = value
        }
    var listPreviewStory: MutableList<Story> = mutableListOf()
        set(value) {
            field = value
            listStoryPreviewAdapter?.listStory = value
        }
     var listStoryPreviewAdapter: ListStoryPreviewAdapter? = null

    init {
        listStoryPreviewAdapter = ListStoryPreviewAdapter().apply {
            binding.rcStoryPreview.adapter = this
            onItemClickListener = object : StoryAdapter.ItemClickListener {


                override fun onItemClick(story: Story, position: Int) {
//                    intentActivityAndData(story,position)
                }

            }

        }
        binding.imRight.setOnClickListener {

        }

    }
//    private fun intentActivityAndData(story: Story,position: Int) {
//        val intent = Intent(this, DetailStoryActivity::class.java)
//        intent.putExtra(
//            Constant.KEY_DETAIL_STORY,
//            Gson().toJson(listStoryPreviewAdapter?.listStory?.get(position))
//        )
//        startActivity(intent)
//    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    )

    constructor(
        context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)
}