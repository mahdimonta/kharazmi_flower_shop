package com.example.composeapp.mainPage

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composeapp.R
import com.example.composeapp.dataClasses.NavigationItem
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        NavigationItem(
            "پروفایل",
            selectedIcon = painterResource(id = R.drawable.person),
            unSelectedIcon = painterResource(id = R.drawable.outlined_person),
            "Profile"
        ),
        NavigationItem(
            "سبد خرید",
            selectedIcon = painterResource(id = R.drawable.shop),
            unSelectedIcon = painterResource(id = R.drawable.outline_shop),
            "Shop"
        ),

        NavigationItem(
            "خانه",
            selectedIcon = painterResource(id = R.drawable.home),
            unSelectedIcon = painterResource(id = R.drawable.outline_home),
            "Home"
        ),
        NavigationItem(
            "دسته بندی ها",
            selectedIcon = painterResource(id = R.drawable.category),
            unSelectedIcon = painterResource(id = R.drawable.category),
            "Category"
        ),

        NavigationItem(
            "تخفیف ها",
            selectedIcon = painterResource(id = R.drawable.message),
            unSelectedIcon = painterResource(id = R.drawable.outline_message),
            "Discount"
        )
    )


    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    var state by remember { mutableIntStateOf(2) }

    AnimatedNavigationBar(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp , bottom = 10.dp),
        selectedIndex = state,
        ballColor = Color(0xFF0B5B3F),
        barColor = Color(0xFF18AF7C),
        cornerRadius = shapeCornerRadius(20.dp)

    ) {
        items.forEachIndexed { index, navigationItem ->
            Box(
                modifier = Modifier
                    .noRippleClickable {
                        navController.navigate(navigationItem.route) {
                            popUpTo(0) {
                                inclusive = false
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true

                        }
                        state = index
                    }
                    .height(80.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    painter = if (navigationItem.route == currentRoute) navigationItem.selectedIcon else navigationItem.unSelectedIcon,
                    contentDescription = navigationItem.title,
                    tint = if (navigationItem.route == currentRoute) Color(0xFF0B5B3F)
                    else Color(0xFF85E5B9)
                )

            }
        }
    }

}

@Composable
fun ProfileScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("profile", fontSize = 24.sp)
    }
}

@Composable
fun ShopScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Shop", fontSize = 24.sp)
    }
}

@Composable
fun HomeScreen() {
    val focusManager = LocalFocusManager.current
    var active by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }

    val widthFraction by animateFloatAsState(if (active) 1f else 0.195f)


    Scaffold(
        modifier = Modifier
            .systemBarsPadding()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                    active = false
                })
            },
        topBar = {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.183f)
                        .padding(top = 10.dp, start = 20.dp, end = 8.dp),
                    elevation = CardDefaults.cardElevation(3.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notification"
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth(widthFraction)
                        .padding(top = 10.dp, end = 20.dp)
                        .clickable {
                            active = true
                        },
                    elevation = CardDefaults.cardElevation(3.dp),
                    shape = if (active) CardDefaults.shape else CircleShape,
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {

                        if (active) {

                            OutlinedTextField(
                                value = text,
                                onValueChange = { text = it },
                                modifier = Modifier
                                    .padding(horizontal = 16.dp) // فاصله درون فیلد
                                    .fillMaxSize(),
                                singleLine = true,
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "Search TextField"
                                    )
                                },
                                trailingIcon = {
                                    Icon(
                                        modifier = Modifier.clickable { if(text.isNotEmpty()) text="" else active = false },
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Close TextField"
                                    )
                                }
                            )


                        } else {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Notification"
                            )
                        }

                    }
                }
            }


        }
    ) {
        it.toString()
        MainHomeListItem("")
    }


}


@Composable
fun CategoryScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Category", fontSize = 24.sp)
    }
}

@Composable
fun DiscountScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Offer", fontSize = 24.sp)
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_7_PRO
)
@Composable
fun AllScreenPRE() {

    HomeScreen()
}