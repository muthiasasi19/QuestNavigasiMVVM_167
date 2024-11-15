package com.example.praktikumsetelahucp1.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable // Fungsi @Composable bertanggung jawab untuk menampilkan UI
fun FormulirView(
    modifier: Modifier = Modifier,
    pilihanJK : List<String>,
    onClickButton:(MutableList<String>) -> Unit // onclick tipe datanya adalah Unit
) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisK by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var lisData : MutableList<String> = mutableListOf(nama, nim, email, noHp, jenisK, alamat)

    Column (modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp)
        Spacer(modifier = Modifier.padding(20.dp))
        TextField(
            value = nama,
            onValueChange = {nama = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Nama")
            },
            placeholder = {  //placeholder adalah teks yang muncul dalam TextField ketika bidang input kosong
                Text("Masukkan Nama Anda")
            }
        )
        Row {
            pilihanJK.forEach { selectedJK ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(selected = jenisK == selectedJK,
                        onClick = {
                            jenisK = selectedJK
                        })
                    Text(selectedJK)
                }
            }
        }
        TextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Email")
            },
            placeholder = {
                Text("Masukkan Email Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = noHp,
            onValueChange = {noHp = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Nomer Handphone")
            },
            placeholder = {
                Text("Masukkan Nomer Handphone Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Alamat")
            },
            placeholder = {
                Text("Masukkan Alamat Anda")
            }
        )
        Button(onClick = { //
            onClickButton(lisData)


        },modifier = Modifier.padding(vertical = 10.dp)) {
            Text ("Simpan")
        }

    }
}
