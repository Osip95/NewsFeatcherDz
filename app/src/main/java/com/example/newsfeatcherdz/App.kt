package com.example.newsfeatcherdz

import android.app.Application
import com.example.newsfeatcherdz.feature.article_details_screen.di.articleDetailsModule
import com.example.newsfeatcherdz.feature.bookmarks.di.bookmarksModule
import com.example.newsfeatcherdz.feature.di.mainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

            startKoin {
                androidLogger()
                androidContext(this@App)
                modules(networkModule, mainScreenModule, bookmarksModule, databaseModule,articleDetailsModule)
            }

    }
}