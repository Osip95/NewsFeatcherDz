package com.example.newsfeatcherdz.feature.newsscreen.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsfeatcherdz.base.BaseViewModel
import com.example.newsfeatcherdz.base.Event


class NewsScreenViewModel(val title: String, val description: String, val urlImage: String) :
    BaseViewModel<ViewState>() {


    override fun initialViewState(): ViewState = ViewState(
        title = title,
        description = description,
        urlImage = urlImage
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? = previousState

}