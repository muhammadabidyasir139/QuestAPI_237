package com.example.localapi.uicontroller.route

import com.example.localapi.R

object DestinasiDetail : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val idSiswa = "idSiswa"
    val routeWithArgs = "$route/{$idSiswa}"
}
