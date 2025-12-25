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

    @GET("bacasiswa.php")
    suspend fun getSiswaById(@retrofit2.http.Query("id") id: String): DataSiswa

    @POST("insertsiswa.php")
    @Headers("Content-Type: application/json")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa): Response<Void>

    @POST("editsiswa.php")
    @Headers("Content-Type: application/json")
    suspend fun updateSiswa(@retrofit2.http.Query("id") id: String, @Body dataSiswa: DataSiswa): Response<Void>

    @GET("deletesiswa.php")
    suspend fun deleteSiswa(@retrofit2.http.Query("id") id: String): Response<Void>
}
