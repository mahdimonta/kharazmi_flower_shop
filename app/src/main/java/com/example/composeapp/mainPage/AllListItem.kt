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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.example.composeapp.dataClasses.dataModel.Product

@Composable
fun MainHomeListItem(categoryName: String) {

    Column(
        modifier = Modifier
            .padding(top = 80.dp)
            .fillMaxWidth()
            .height(260.dp)

        )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
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
        val list = listOf(
            Product(
                id = 1,
                name="gol",
                description="ye gol",
                price="1'000'000",
                stock=11,
                category="gols",
                imageUrls= listOf(""),
                rating=5.0,
                availability="mojod"
            ),
            Product(
                id = 1,
                name="gol",
                description="ye gol",
                price="1'000'000",
                stock=11,
                category="gols",
                imageUrls= listOf(""),
                rating=5.0,
                availability="mojod"
            ),
            Product(
                id = 1,
                name="gol",
                description="ye gol",
                price="1'000'000",
                stock=11,
                category="gols",
                imageUrls= listOf(""),
                rating=5.0,
                availability="mojod"
            )


        )
        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(list){item: Product ->
                ProductListItem(item)
            }
            items(1){
                ProductListItem(defaultMode = true)
            }

        }


    }

}

@Composable
fun ProductListItem(
    product: Product? = null,
    defaultMode: Boolean = false
) {

    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier
            .background(Color.White)
            .fillMaxHeight()
            .width(200.dp)
            .padding(top = 10.dp, end = 20.dp, start = 10.dp)
    ) {
        if (defaultMode) {

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    painter = painterResource(id = R.drawable.show_more),
                    contentDescription = "More",
                    contentScale = ContentScale.Inside

                )

            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.6f)
                        .padding(top = 10.dp, end = 5.dp, start = 5.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    painter = painterResource(id = R.drawable.show_more),
                    contentDescription = product?.name,
                    contentScale = ContentScale.Inside

                )

            }
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
    MainHomeListItem("hello")
}