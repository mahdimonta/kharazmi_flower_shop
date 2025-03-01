package com.example.composeapp.mainPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.dataClasses.dataModel.Order
import com.example.composeapp.dataClasses.dataModel.Product
import com.example.composeapp.dataClasses.dataModel.ShopBoxItem
import com.example.composeapp.dataClasses.dataModel.User

@Composable
fun UserInfo(info:User){

    Column (
        modifier = Modifier.fillMaxWidth().padding(30.dp)
    ){
        Text(info.name, fontSize = 20.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        Text(info.phone, fontSize = 16.sp, color = MaterialTheme.colorScheme.primary)
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_7
)
@Composable
fun ProfileStuffPRE() {
    val testUser=User(1,"ali","ali@gmail.com","022222222", "wddefef", listOf(Order(1,1, listOf(ShopBoxItem(Product(1,"11","111","1", stock = 1, category = "11", imageUrls = listOf("111","111"), rating = 4.1, availability = "exist"), 22)),"wdwd","dwdwd","Dwdwdwd","Dwdwdw","wdwdwdw","ewdwdw")))
    UserInfo(testUser)
}