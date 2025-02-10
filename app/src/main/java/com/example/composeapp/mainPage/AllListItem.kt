package com.example.composeapp.mainPage

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeListItem(){

    Row {
        
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_7_PRO
)
@Composable
fun ListPre() {

    HomeListItem()
}