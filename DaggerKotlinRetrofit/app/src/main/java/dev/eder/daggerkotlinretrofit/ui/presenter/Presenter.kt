package dev.eder.daggerkotlinretrofit.ui.presenter

import okhttp3.ResponseBody

interface Presenter {

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     */
    interface GetNoticeIntractor {

        interface OnFinishedListener {
            fun onFinished(pokemon: ResponseBody)
            fun onFailure(t: Throwable)
            fun onComplete()
        }

    }
}