package com.example.newsfeatcherdz.feature.newsscreen.ui


import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.newsfeatcherdz.R

class NewsFragment : Fragment(R.layout.fragment_news) {

    companion object {
        private const val DESCRIPTION_KEY = "DESCRIPTION_KEY"
        private const val URL_IMAGE_KEY = "URL_IMAGE_KEY"
        private const val TITLE_KEY = "TITLE_KEY"
        fun newInstance(description: String, urlImage: String, title: String): NewsFragment {
            val bundle = Bundle().apply {
                putString(DESCRIPTION_KEY, description)
                putString(URL_IMAGE_KEY, urlImage)
                putString(TITLE_KEY, title)
            }
            return NewsFragment().apply { arguments = bundle }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvDescription: TextView = view.findViewById(R.id.tvNews)
        val imgView: ImageView = view.findViewById(R.id.filmPreviewImageView)
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        val description = arguments?.getString(DESCRIPTION_KEY) ?: ""
        val urlImage = arguments?.getString(URL_IMAGE_KEY) ?: ""
        val title = arguments?.getString(TITLE_KEY) ?: ""
        tvDescription.text = description
        toolbar.title = title
        Glide
            .with(this)
            .load(urlImage)
            .into(imgView)

    }
}