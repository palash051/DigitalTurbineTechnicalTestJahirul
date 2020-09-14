package com.jbhuiyan.projects.digitalturbinetechnicaltest.di

import com.jbhuiyan.projects.digitalturbinetechnicaltest.businesslogic.CampaignApi
import com.jbhuiyan.projects.digitalturbinetechnicaltest.businesslogic.CampaignService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {

    private val BASE_URL = "https://ads.appia.com/"

    @Provides
    fun providePhotosApi(): CampaignApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getUnsafeOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CampaignApi::class.java)
    }

    @Provides
    fun providePhotosService(): CampaignService {
        return CampaignService()
    }

    @Singleton
    fun getUnsafeOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(SupportInterceptor())
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
        return builder.build()
    }

}