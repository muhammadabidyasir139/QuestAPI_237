package com.example.localapi.repositori

import com.example.localapi.modeldata.DataSiswa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface serviceApiSiswa {
    @GET("bacasiswa.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insertsiswa.php")
    @Headers("Content-Type: application/json")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa): Response<Void>
}
