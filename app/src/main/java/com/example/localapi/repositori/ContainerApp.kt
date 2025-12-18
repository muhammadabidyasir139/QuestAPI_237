package com.example.localapi.repositori

import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

interface ContainerApp {
    val repositoryDataSiswa : RepositoryDataSiswa
}

class DefaultContainerApp : ContainerApp(
    private val baseurl = "http://10.0.2.2/umyTI/"

    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val klien = OkHttpClient.Builder()
        .addInterceptor (interceptor = logging)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder(
        .baseUrl(baseurl = baseurl)
    )
)

