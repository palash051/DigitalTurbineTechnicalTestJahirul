package com.jbhuiyan.projects.digitalturbinetechnicaltest.di

import okhttp3.Interceptor
import okhttp3.Response

class SupportInterceptor : Interceptor {

    companion object {
        const val AUTHORIZATION_API_KEY =
            "Bearer zVgrQja11MhoNIxjmCQnWj2pTNKQ7c4ORHQf9x6UcFamXJ_Q7hbp5B70K-dYLobg1LMR2DRbolXSsV-8-1XpFgU90ZJ3X_kM4FYhbSzoxQvtp-JVBSQOQeXZNj4VX3Yx"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request?.newBuilder()
            ?.addHeader("Accept","application/json")
            ?.build()
        return chain.proceed(request)
    }
}