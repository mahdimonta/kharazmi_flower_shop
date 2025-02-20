package com.example.composeapp.mainPage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.R
import com.example.composeapp.dataClasses.dataModel.Product
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainHomeListItem(categoryName: String) {

    Column(
        modifier = Modifier
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
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { },
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Icon(
                    modifier = Modifier.size(14.dp),
                    painter = painterResource(R.drawable.arrow_back),
                    contentDescription = null,
                    tint = Color(0xFF0B5B3F)
                )
                Text(
                    text = stringResource(R.string.more),
                    color = Color(0xFF0B5B3F),
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
                name = "gol",
                description = "ye gol",
                price = "1'000'000",
                stock = 11,
                discountAfterPrice = "900'000",
                discount = "10",
                category = "gols",
                imageUrls = listOf(""),
                rating = 5.0,
                availability = "mojod"
            ),
            Product(
                id = 1,
                name = "gol",
                description = "ye gol",
                price = "1'000'000",
                stock = 11,
                discountAfterPrice = "900'000",
                discount = "10",
                category = "gols",
                imageUrls = listOf(""),
                rating = 5.0,
                availability = "mojod"
            ),
            Product(
                id = 1,
                name = "gol",
                description = "ye gol",
                price = "1'000'000",
                discountAfterPrice = "900'000",
                discount = "10",
                stock = 11,
                category = "gols",
                imageUrls = listOf(""),
                rating = 5.0,
                availability = "mojod"
            )


        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(list) { item: Product ->
                ProductListItem(item)
            }
            items(1) {
                ProductListItem(defaultMode = true)
            }

        }


    }


}

@Composable
fun ProductListItem(product: Product? = null, defaultMode: Boolean = false) {

    if (defaultMode) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(200.dp)
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
//        Card(
//            shape = RoundedCornerShape(20.dp),
//            elevation = CardDefaults.cardElevation(5.dp),
//            modifier = Modifier
//                .background(Color.Transparent)
//                .fillMaxHeight()
//                .width(200.dp)
//                .padding(top = 10.dp, end = 20.dp, start = 10.dp)
//        ) {
//            Column(
//                modifier = Modifier.fillMaxSize()
//            ) {
//                Image(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .fillMaxHeight(0.6f)
//                        .padding(top = 10.dp, end = 5.dp, start = 5.dp)
//                        .clip(RoundedCornerShape(20.dp)),
//                    painter = painterResource(id = R.drawable.show_more),
//                    contentDescription = product?.name,
//                    contentScale = ContentScale.Inside
//
//                )
//                Text(
//                    text = product?.name ?: "error",
//                    modifier = Modifier.padding(5.dp, top = 10.dp),
//                    fontSize = 20.sp
//                )
//
//
//            }
//        }
        ElevatedCard(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .width(160.dp)
                .padding(start = 8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 3.dp
            ),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(

                modifier = Modifier.padding(8.dp).fillMaxSize()
            ) {

                    Image(
                        painter = painterResource(id = R.drawable.show_more),
                        contentDescription = "Product Image",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxWidth().height(110.dp)
                    )


                Text(
                    text = product?.description ?: "gol 1",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp).fillMaxWidth().height(50.dp)
                )
                Text(
                    text = "${product?.price} تومان",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${product?.discountAfterPrice} تومان",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        textDecoration = TextDecoration.LineThrough
                    )

                    Box(
                        modifier = Modifier
                            .background(Color(0xFF18AF7C), shape = RoundedCornerShape(8.dp))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "${product?.discount}%",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            }
    }


}

@Composable
fun ImageSlider() {
    val imagesDe = listOf(
        R.drawable.show_more,
        R.drawable.arrow_back,
        R.drawable.show_more
    )

    val pagerState = rememberPagerState { imagesDe.size }
    val coroutineScope = rememberCoroutineScope()


    LaunchedEffect(pagerState.currentPage) {
        while (true) {
            delay(3000)

            if (pagerState.isScrollInProgress) continue

            val nextPage = (pagerState.currentPage + 1) % imagesDe.size
            coroutineScope.launch {
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) { page ->
            Card(
                Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                ),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Image(
                    painter = painterResource(id = imagesDe[page]),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }


        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(imagesDe.size) { index ->
                val color =
                    if (pagerState.currentPage == index) Color(0xFF0B5B3F) else Color.Gray.copy(
                        alpha = 0.5f
                    )
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(color)
                        .padding(4.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
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
    Column {
        MainHomeListItem("hello")
        ImageSlider()
    }
}