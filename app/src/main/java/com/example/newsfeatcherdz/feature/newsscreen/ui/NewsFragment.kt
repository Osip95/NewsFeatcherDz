package com.example.newsfeatcherdz.feature.newsscreen.ui


import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.newsfeatcherdz.R

class NewsFragment: Fragment(R.layout.fragment_news) {

    companion object {
        private const val DESCRIPTION_KEY = "DESCRIPTION_KEY"
        private const val URL_IMAGE_KEY = "URL_IMAGE_KEY"
        fun newInstance(description: String, urlImage: String): NewsFragment {
            val bundle = Bundle().apply {
                putString(DESCRIPTION_KEY, description)
                putString(URL_IMAGE_KEY, urlImage)
            }
            return NewsFragment().apply { arguments = bundle }
        }
    }
    private lateinit var tvDescription:TextView
    private lateinit var imgView:ImageView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvDescription = view.findViewById(R.id.tvNews)
        imgView = view.findViewById(R.id.ivNews)


        val description = arguments?.getString(DESCRIPTION_KEY) ?: ""
        val urlImage =  arguments?.getString(URL_IMAGE_KEY) ?: ""
        tvDescription.text = description
        Glide
            .with(this)
            .load(urlImage)
            .into(imgView)

    }
}