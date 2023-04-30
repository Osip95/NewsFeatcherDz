package com.example.newsfeatcherdz.feature.article_details_screen.di

import com.example.newsfeatcherdz.feature.article_details_screen.ui.ArticleDetailsScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val articleDetailsModule = module {
    viewModel { parameters ->
        ArticleDetailsScreenViewModel(
            title = parameters[0],
            description = parameters[1],
            urlImage = parameters[2]
        )
    }
}

