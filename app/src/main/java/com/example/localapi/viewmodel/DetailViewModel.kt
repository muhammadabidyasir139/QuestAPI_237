package com.example.localapi.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.localapi.modeldata.DetailSiswa
import com.example.localapi.modeldata.toDetailSiswa
import com.example.localapi.repositori.RepositoryDataSiswa
import com.example.localapi.uicontroller.route.DestinasiDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed class DetailUiState {
    data class Success(val detailSiswa: DetailSiswa) : DetailUiState()
    object Error : DetailUiState()
    object Loading : DetailUiState()
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryDataSiswa: RepositoryDataSiswa
) : ViewModel() {

    private val _idSiswa: String = checkNotNull(savedStateHandle[DestinasiDetail.idSiswa])
    
    private val _detailUiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val detailUiState: StateFlow<DetailUiState> = _detailUiState.asStateFlow()

    init {
        getDetailSiswa()
    }

    fun getDetailSiswa() {
        viewModelScope.launch {
            _detailUiState.value = DetailUiState.Loading
            try {
                val siswa = repositoryDataSiswa.getSiswaById(_idSiswa)
                _detailUiState.value = DetailUiState.Success(siswa.toDetailSiswa())
            } catch (e: Exception) {
                _detailUiState.value = DetailUiState.Error
            }
        }
    }

    fun deleteSiswa() {
        viewModelScope.launch {
            try {
                repositoryDataSiswa.deleteDataSiswa(_idSiswa)
            } catch (e: Exception) {
                _detailUiState.value = DetailUiState.Error
            }
        }
    }
}
