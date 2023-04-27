package com.example.newsfeatcherdz.feature.newsscreen.ui


import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.newsfeatcherdz.R
import com.example.newsfeatcherdz.feature.shared.BottomMenuController


class NewsFragment : Fragment(R.layout.fragment_news) {



    private lateinit var newsScreenViewModel: NewsScreenViewModel
    private val tvDescription: TextView by lazy { requireActivity().findViewById(R.id.tvNews) }
    private val imgView: ImageView by lazy { requireActivity().findViewById(R.id.filmPreviewImageView) }
    private val tvToolbar: TextView by lazy { requireActivity().findViewById(R.id.custom_title) }
    private val btnClose: ImageButton by lazy { requireActivity().findViewById(R.id.btnClose) }

    companion object {
        private const val DESCRIPTION_KEY = "DESCRIPTION_KEY"
        private const val URL_IMAGE_KEY = "URL_IMAGE_KEY"
        private const val TITLE_KEY = "TITLE_KEY"
        private const val NOT_FOUND = "NOT_FOUND"
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
        val bottomMenuController: BottomMenuController = requireActivity() as BottomMenuController
        bottomMenuController.hideBottomNavigationMenu()
        val description = arguments?.getString(DESCRIPTION_KEY) ?: NOT_FOUND
        val urlImage = arguments?.getString(URL_IMAGE_KEY) ?: NOT_FOUND
        val title = arguments?.getString(TITLE_KEY) ?: NOT_FOUND

        newsScreenViewModel =
            NewsScreenViewModel(title = title, description = description, urlImage = urlImage)
        newsScreenViewModel.viewState.observe(viewLifecycleOwner, ::render)



        btnClose.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            bottomMenuController.showBottomNavigationMenu()
        }

        requireActivity().onBackPressedDispatcher.addCallback(this){
            requireActivity().supportFragmentManager.popBackStack()
            bottomMenuController.showBottomNavigationMenu()
        }

    }

    private fun render(viwState: ViewState) {
        tvDescription.text = viwState.description
        tvToolbar.text = viwState.title
        Glide
            .with(this)
            .load(viwState.urlImage)
            .into(imgView)
    }
}