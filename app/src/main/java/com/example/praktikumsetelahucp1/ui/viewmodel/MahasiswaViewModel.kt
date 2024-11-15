package com.example.praktikumsetelahucp1.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.praktikumsetelahucp1.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel: ViewModel() { // : ViewModel() merupakan view modelnya
    //harus ada fungsi untuk menyimpan
    private val _uiState = MutableStateFlow(Mahasiswa()) // dalam val diisi dengan data yg ingin diisi // isi dari val ui_state yaitu data mahasiswa
    //buat akses public
    val uistate : StateFlow<Mahasiswa> = _uiState.asStateFlow() //  StateFlow tipe data yang bisa mengakses apa yang diisi

    fun saveDataMahasiswa(
        ls :MutableList<String> // ls merupakan nama list
    ){
        _uiState.update {data -> //  isi dari 'data' yaitu Mahasiswa
            data.copy(
                nama= ls[0],
                nim = ls[1],
                email = ls[2],
                noHp = ls[3],
                gender = ls[4],
                alamat = ls[5]

            )
        }
    }
}