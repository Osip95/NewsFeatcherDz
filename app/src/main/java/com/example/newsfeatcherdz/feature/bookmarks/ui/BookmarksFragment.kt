package com.example.newsfeatcherdz.feature.bookmarks.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeatcherdz.R
import com.example.newsfeatcherdz.feature.mainscreen.ArticlesAdapter
import com.example.newsfeatcherdz.feature.mainscreen.UiEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarksFragment: Fragment(R.layout.fragment_bookmarks) {

    private val viewModel: BookmarksScreenViewModel by viewModel()
    private val rvBookmarks: RecyclerView by lazy { requireActivity().findViewById(R.id.rvBookMarkedArticles)}
    private val adapter: BookmarksAdapter by lazy { BookmarksAdapter()}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, ::render)
        rvBookmarks.adapter = adapter
    }

    private fun render(viewState: ViewState?) {
        adapter.setData(viewState!!.bookmarksArticle)
    }
}