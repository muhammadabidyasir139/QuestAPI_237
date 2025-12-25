package com.example.localapi.repositori

import com.example.localapi.modeldata.DataSiswa

interface RepositoryDataSiswa {
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa) :retrofit2.Response<Void>
    suspend fun updateDataSiswa(id: String, dataSiswa: DataSiswa): retrofit2.Response<Void>
    suspend fun deleteDataSiswa(id: String): retrofit2.Response<Void>
    suspend fun getSiswaById(id: String): DataSiswa
}

class JaringanRepositoryDataSiswa(
    private val serviceApiSiswa: serviceApiSiswa
) : RepositoryDataSiswa {
    override suspend fun getDataSiswa(): List<DataSiswa> = serviceApiSiswa.getSiswa()
    override suspend fun postDataSiswa(dataSiswa: DataSiswa): retrofit2.Response<Void> = serviceApiSiswa.postSiswa(dataSiswa)
    override suspend fun updateDataSiswa(id: String, dataSiswa: DataSiswa): retrofit2.Response<Void> = serviceApiSiswa.updateSiswa(id, dataSiswa)
    override suspend fun deleteDataSiswa(id: String): retrofit2.Response<Void> = serviceApiSiswa.deleteSiswa(id)
    override suspend fun getSiswaById(id: String): DataSiswa = serviceApiSiswa.getSiswaById(id)
}