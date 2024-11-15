package com.example.praktikumsetelahucp1.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktikumsetelahucp1.model.Mahasiswa

//

@Composable
fun TampilMahasiswaView(
    mhs: Mahasiswa // diapanggil

) {
    Column(modifier = Modifier.fillMaxSize()) {
        TampilData(
            Judul = "Nama",
            Isinya = mhs.nama // didapat dari model

        )
        TampilData(
            Judul = "Gender",
            Isinya = mhs.gender // didapat dari model

        )

        TampilData(
            Judul = "Alamat",
            Isinya = mhs.alamat // didapat dari model

        )
    }

}
@Composable
fun TampilData(
    Judul: String,
    Isinya:String
){
    Row(modifier = Modifier.fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(Judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(Isinya, modifier = Modifier.weight(2f))
    }
}