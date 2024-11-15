package com.example.praktikumsetelahucp1

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikumsetelahucp1.model.DataJK
import com.example.praktikumsetelahucp1.ui.view.FormulirView
import com.example.praktikumsetelahucp1.ui.view.TampilMahasiswaView
import com.example.praktikumsetelahucp1.ui.viewmodel.MahasiswaViewModel

enum class Halaman { //untuk halaman
    Form,
    Data
}


@Composable
fun Navigasi( // namanya sesuai dengan nama file
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
) {
    Scaffold { isipadding ->
        val uiState by viewModel.uistate.collectAsState()//Membuat variable untuk
        NavHost(
            modifier =  modifier.padding(isipadding),// pilih yang start Destination = any
            navController = navHost, startDestination = Halaman.Form.name
        ) {

            composable(route = Halaman.Form.name) { // Halamab pertama
                val konteks = LocalContext.current
                FormulirView(
                    pilihanJK = DataJK.isiJK.map{
                        isi -> konteks.resources.getString(isi)

                    },
                    onClickButton = {
                        viewModel.saveDataMahasiswa(it)
                        navHost.navigate(Halaman.Data.name)

                    }
                )
            }
            composable(route = Halaman.Data.name) {
                TampilMahasiswaView(
                    mhs = uiState,
                    onBackKlick = { navHost.popBackStack() }

                )
            }
        }
    }
}
