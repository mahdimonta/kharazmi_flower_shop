package com.example.composeapp.mainPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composeapp.R
import com.example.composeapp.dataClasses.dataModel.Category
import com.example.composeapp.dataClasses.dataModel.Product
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeInit() {
    val categoryList = listOf(

        Category(
            id = 1,
            name = "gols",
            imageUrl = "",
            listOfProduct = listOf(
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
        ),
        Category(
            id = 1,
            name = "gols",
            imageUrl = "",
            listOfProduct = listOf(
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
        ),

        Category(
            id = 1,
            name = "gols",
            imageUrl = "",
            listOfProduct = listOf(
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
        ),

        Category(
            id = 1,
            name = "gols",
            imageUrl = "",
            listOfProduct = listOf(
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
        )


    )
    val gridList = listOf(
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





    val images =
        listOf(
            "https://randomuser.me/api/portraits/women/96.jpg",
            "https://picsum.photos/800/400",
            "https://randomuser.me/api/portraits/women/96.jpg",
            "https://picsum.photos/800/400",
        )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // 📌 کل صفحه اسکرولی می‌شه

    ) {


        ImageSlider(images) // 📌 اسلایدر بالای صفحه


        categoryList.forEach { item: Category ->

            MainHomeListItem(item)
            Posters("https://picsum.photos/800/400")
        }

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            maxItemsInEachRow = 2, // 📌 دو آیتم در هر سطر
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            gridList.forEach { item2: Product ->
                Box(
                    modifier = Modifier
                        .width((LocalConfiguration.current.screenWidthDp.dp / 2) - 8.dp) // 📌 هر آیتم نصف صفحه بشه
                ) {
                    RandomProduct(item2)
                }
            }
        }


    }


}

@Composable
fun MainHomeListItem(category: Category? = null) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 10.dp)
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
                text = category?.name ?: "error to receiving name",
                style = TextStyle(fontSize = 16.sp, color = Color.Black),
                fontWeight = FontWeight.Bold
            )
        }

        val list2 = listOf(
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
            reverseLayout = true,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(category?.listOfProduct ?: list2) { item: Product ->
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
                .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(90.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp)),
                painter = painterResource(id = R.drawable.show_more),
                contentDescription = "More",
                contentScale = ContentScale.Inside

            )

        }
    } else {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .width(160.dp)
                .padding(start = 5.dp, end = 5.dp)
                .fillMaxHeight(),

            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(1.dp),
        ) {
            Column(

                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.show_more),
                    contentDescription = "Product Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                )


                Text(
                    text = product?.description ?: "gol 1",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .height(50.dp)
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
                            .padding(horizontal = 6.dp)
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
fun ImageSlider(images:List<String>) {




    val pagerState = rememberPagerState { images.size}
    val coroutineScope = rememberCoroutineScope()


    LaunchedEffect(pagerState.currentPage) {
        while (true) {
            delay(3000)

            if (pagerState.isScrollInProgress) continue

            val nextPage = (pagerState.currentPage + 1) % (images.size)
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
                    defaultElevation = 1.dp
                ),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                AsyncImage(
                    model = images[page],
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
        }


        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(images.size) { index ->
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
@Composable
fun Posters(image:String){
    Card(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun RandomProduct(product: Product? = null) {

    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width((LocalConfiguration.current.screenWidthDp.dp / 2))
            .padding(10.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.show_more),
                contentDescription = "Product Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(140.dp)
            )

            Text(
                text = product?.description ?: "dwewdwdwdwdwwdw",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(top = 10.dp, bottom = 10.dp)
            )
            Text(
                text = "${product?.price ?: ""} تومان",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7_PRO)
@Composable
fun ListPre() {
    val images = listOf(
        "https://randomuser.me/api/portraits/women/96.jpg",
        "https://randomuser.me/api/portraits/women/96.jpg",
        "https://randomuser.me/api/portraits/women/96.jpg",
    )
    Column {
        MainHomeListItem()
        ImageSlider(images)
        RandomProduct()
    }
}