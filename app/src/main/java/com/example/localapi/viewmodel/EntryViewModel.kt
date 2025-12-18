package com.example.localapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.localapi.modeldata.DetailSiswa
import com.example.localapi.modeldata.UIStateSiswa
import com.example.localapi.modeldata.toDataSiswa
import com.example.localapi.repositori.RepositoryDataSiswa
import retrofit2.Response
import kotlinx.coroutines.launch

class EntryViewModel(private val repositoryDataSiswa: RepositoryDataSiswa): ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa ): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    //Fungsi untuk menangani saat ada perubahan pada text input
    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    /* Fungsi untuk menyimpan data yang di-entry */
    fun addSiswa() {
        viewModelScope.launch {
            if (validasiInput()) {
                val sip: Response<Void> = repositoryDataSiswa.postDataSiswa(uiStateSiswa.detailSiswa.toDataSiswa())
                if (sip.isSuccessful){
                    println("Sukses Tambah Data : ${sip.message()}")
                }else{
                    println("Gagal tambah data : ${sip.errorBody()}")
                }
            }
        }
    }
}
