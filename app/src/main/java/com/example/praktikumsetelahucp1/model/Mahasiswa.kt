package com.example.praktikumsetelahucp1.model

data class Mahasiswa( // data class umumnya menggunakan val
    val nama : String ="", // untuk menyimpan nama // bisa berganti tapi static (replace)
    val nim : String = "",
    val email : String = "",
    val noHp : String = "",
    val gender : String ="", // untuk menyimpan gender
    val alamat : String ="" // untuk menyimpan alamat
)
