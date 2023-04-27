package com.example.newsfeatcherdz.feature.bookmarks.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeatcherdz.R
import com.example.newsfeatcherdz.feature.shared.ArticlesAdapter
import com.example.newsfeatcherdz.feature.newsscreen.ui.NewsFragment

import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarksFragment : Fragment(R.layout.fragment_bookmarks) {

    private val viewModel: BookmarksScreenViewModel by viewModel()
    private val rvBookmarks: RecyclerView by lazy { requireActivity().findViewById(R.id.rvBookMarkedArticles) }
    private val adapter: ArticlesAdapter by lazy {
        ArticlesAdapter { index ->
            viewModel.processUIEvent(
                UiEvent.OnArticleClicked(index)
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, ::render)
        viewModel.goNewsEvent.observe(viewLifecycleOwner, ::goNewsFragment)
        rvBookmarks.adapter = adapter
    }

    private fun render(viewState: ViewState?) {
        adapter.setData(viewState!!.bookmarksArticle)
    }

    private fun goNewsFragment(index: Int) {
        val newsFragment = NewsFragment.newInstance(
            description = viewModel.viewState.value!!.bookmarksArticle[index].description,
            urlImage = viewModel.viewState.value!!.bookmarksArticle[index].urlToImage,
            title = viewModel.viewState.value!!.bookmarksArticle[index].title
        )
        requireActivity().supportFragmentManager.beginTransaction().hide(this)
            .add(R.id.container, newsFragment).addToBackStack(null).commit()

    }
}