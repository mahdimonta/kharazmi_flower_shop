package com.example.composeapp.mainPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.R

@Composable
fun MainHomeListItem(categoryName:String) {

    Column(
        modifier = Modifier
            .padding(top = 80.dp)
            .fillMaxWidth()
            .height(260.dp)
            .background(Color.Gray),

        )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(Color.Yellow),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        )
        {
            Row(
                modifier = Modifier
                    .padding(5.dp, top = 8.dp)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Icon(
                    modifier = Modifier.size(14.dp),
                    painter = painterResource(R.drawable.arrow_back),
                    contentDescription = null,
                    tint = Color(0xFF303F88)
                )
                Text(
                    text = stringResource(R.string.more),
                    color = Color(0xFF303F88),
                    fontSize = 15.sp
                )
            }
            Text(
                modifier = Modifier.padding(top = 5.dp, end = 13.dp),
                text = categoryName,
                style = TextStyle(fontSize = 16.sp, color = Color.Black),
                fontWeight = FontWeight.Bold
            )
        }

        ProductListItem("name","price",0,"availability")
    }
}

@Composable
fun ProductListItem(name:String, price:String, image:Int, availability: String){

    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier.background(Color.White).fillMaxHeight().width(150.dp).padding(top = 10.dp, end = 10.dp, start = 10.dp)
    ) {

       Column(
           modifier = Modifier.fillMaxSize()
       ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.55f)
                    .padding(top = 10.dp, end = 5.dp, start = 5.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = Color.Gray),
                painter = painterResource(id =  image),
                contentDescription = name,
                contentScale = ContentScale.FillBounds
            )

       }

    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_7_PRO
)
@Composable
fun ListPre() {
    MainHomeListItem("efefefe")
}