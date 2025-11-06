package com.example.navigasime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-Laki", "Perempuan"),
    OnSubmitBtnClick: () -> Unit
) {
    // State untuk menyimpan input dari pengguna
    var nama by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.home)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700),
                    titleContentColor = Color.White
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nama, // Menggunakan state
                onValueChange = { nama = it }, // Memperbarui state
                singleLine = true,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(width = 250.dp),
                label = { Text(text = "Nama Lengkap") },
            )

            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(250.dp),
                thickness = 1.dp, // Perbaikan sintaks
                color = Color.Red
            )

            Row {
                jenisK.forEach { item ->
                    Row(
                        // Modifier untuk membuat seluruh baris bisa diklik
                        modifier = Modifier.selectable(
                            selected = (jenisKelamin == item),
                            onClick = { jenisKelamin = item }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (jenisKelamin == item), // Menggunakan state
                            onClick = { jenisKelamin = item } // Memperbarui state
                        )
                        Text(text = item)
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(width = 250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            OutlinedTextField(
                value = alamat, // Menggunakan state
                onValueChange = { alamat = it }, // Memperbarui state
                singleLine = true,
                modifier = Modifier
                    .width(width = 250.dp),
                label = { Text(text = "Alamat") },
            )
        }
    }
}
