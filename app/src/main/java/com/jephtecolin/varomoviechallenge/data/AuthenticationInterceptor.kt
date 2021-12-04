package com.jephtecolin.varomoviechallenge.data

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response



class AuthenticationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        val originalHttpUrl = chain.request().url()
        val url = originalHttpUrl.newBuilder().addQueryParameter("api_key", "7bfe007798875393b05c5aa1ba26323e").build()
        requestBuilder.url(url)

        return chain.proceed(requestBuilder.build())
    }
}