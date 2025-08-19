package com.example.instagramprofile.Components.ButtonNavBar


import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.instagramprofile.R
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import com.example.instagramprofile.Navigation.Routes
import androidx.navigation.NavController

@Composable
fun BottomNavItem(
    iconRes: Int,
    selected: Boolean,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(48.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(4.dp),
            tint = if (selected)
                MaterialTheme.colorScheme.onBackground
            else
                MaterialTheme.colorScheme.onBackground.copy(alpha = 0.85f)
        )
    }
}

@Composable
fun BottomNavBar(
    navController: NavController,
    selectedIndex: Int,
    onSelectedChange: (Int) -> Unit
) {
    val dividerColor = MaterialTheme.colorScheme.onBackground

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                drawLine(
                    color = dividerColor.copy(alpha = 0.2f),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = strokeWidth
                )
            }
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavItem(R.drawable.ic_home, selectedIndex == 0) {
            onSelectedChange(0)
            navController.navigate(Routes.FEED)
        }
        BottomNavItem(R.drawable.ic_dearch2, selectedIndex == 1) {
            onSelectedChange(1)
            navController.navigate(Routes.SEARCH)
        }
        BottomNavItem(R.drawable.icadd, selectedIndex == 2) {
            onSelectedChange(2)
            // Add post screen navigatsiya
        }
        BottomNavItem(R.drawable.ic_reels, selectedIndex == 3) {
            onSelectedChange(3)
            navController.navigate(Routes.REELS)
        }
        BottomNavItem(R.drawable.pr2, selectedIndex == 4) {
            onSelectedChange(4)
            navController.navigate(Routes.PROFILE)
        }
    }
}
