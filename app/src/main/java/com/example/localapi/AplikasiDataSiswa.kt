package com.example.localapi

import android.app.Application
import com.example.localapi.repositori.ContainerApp
import com.example.localapi.repositori.DefaultContainerApp

class AplikasiDataSiswa : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = DefaultContainerApp()
    }
}
