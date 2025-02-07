@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composeapp.mainPage

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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composeapp.R
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
            .padding(start = 20.dp, end = 20.dp),
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


    Scaffold(
        modifier = Modifier
            .systemBarsPadding()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                    active=false
                })
            },
        topBar = {


            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Card(
                    modifier = Modifier.size(50.dp).padding(start = 10.dp),
                    elevation = CardDefaults.cardElevation(10.dp),
                    shape = CircleShape
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center) {
                        Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notification")
                    }
                }
                SearchBar(
                    shape = SearchBarDefaults.fullScreenShape,
                    colors = SearchBarDefaults.colors(Color.Gray),
                    modifier = Modifier.fillMaxWidth(),
                    query = text,
                    onQueryChange = { text = it },
                    onSearch = { active = false },
                    onActiveChange = { active = it },
                    active = active,
                    trailingIcon ={
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "search"
                        )
                    },
                    leadingIcon =  {
                        if (active) {
                            Icon(
                                modifier = Modifier.clickable {
                                    if (text.isNotEmpty()) {
                                        text = ""
                                    } else {
                                        active = false
                                    }
                                },
                                imageVector = Icons.Default.Close,
                                contentDescription = "close"
                            )
                        }
                    }
                ) {

                }
            }
        }
    ) {
        it.toString()

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