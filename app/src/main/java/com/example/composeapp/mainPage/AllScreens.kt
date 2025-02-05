package com.example.composeapp.mainPage

import androidx.annotation.Nullable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        modifier = Modifier.padding(bottom = 60.dp, start = 20.dp, end = 20.dp),
        selectedIndex = state,
        ballColor = Color(0xFF05690B),
        barColor = Color(0xFF22C528),
        cornerRadius = shapeCornerRadius(20.dp)

    ) {
        items.forEachIndexed { index, navigationItem ->
            Box(
                modifier = Modifier
                    .noRippleClickable {
                        navController.navigate(navigationItem.route) {
                        popUpTo("home") { saveState = true }
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
                    tint = if (navigationItem.route == currentRoute) Color(0xFF05690B)
                    else Color(0xFFA2E3A5)
                )

            }
        }
    }

}

@Composable
fun ProfileScreen(){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("profile", fontSize = 24.sp)
    }
}
@Composable
fun ShopScreen(){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Shop", fontSize = 24.sp)
    }
}
@Composable
fun HomeScreen(){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Home", fontSize = 24.sp)
    }
}
@Composable
fun CategoryScreen(){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Category", fontSize = 24.sp)
    }
}
@Composable
fun DiscountScreen(){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Offer", fontSize = 24.sp)
    }
}