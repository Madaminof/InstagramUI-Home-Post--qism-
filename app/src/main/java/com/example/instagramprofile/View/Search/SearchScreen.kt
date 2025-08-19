package com.example.instagramprofile.View.Search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.compose.material3.Scaffold
import com.example.instagramprofile.Components.ButtonNavBar.BottomNavBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.*
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.background
import androidx.compose.ui.Alignment
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.ui.draw.clip
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import androidx.compose.foundation.ExperimentalFoundationApi


@Composable
fun SearchScreen(navController: NavController){
    var selectedIndex by remember { mutableStateOf(0) }
    var query by remember { mutableStateOf("") }


    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = navController,
                selectedIndex = selectedIndex,
                onSelectedChange = { selectedIndex = it }
            )
        }
    ) {padding ->


        Column {
            Search(
                padding = padding,
                query = query,
                onQueryChange = { query = it}
            )
            VideoGridShimmer()
        }
    }





}


@Composable
fun Search(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues()
) {
    Box(
        modifier = modifier
            .padding(top = 32.dp) // 35dp pastroqqa tushadi
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .shadow(4.dp, RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp)) // 🔥 qora fon
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White // 🔥 oq icon (qora fonda ko‘rinsin)
            )
            Spacer(modifier = Modifier.width(8.dp))
            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                singleLine = true,
                textStyle = TextStyle(color = Color.White, fontSize = 16.sp), // 🔥 oq text
                modifier = Modifier.weight(1f),
                decorationBox = { innerTextField ->
                    if (query.isEmpty()) {
                        Text(
                            text = "Search...",
                            color = Color.Gray, // placeholder kulrang
                            fontSize = 16.sp
                        )
                    }
                    innerTextField()
                }
            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VideoGridShimmer() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10) { // 10 ta shimmer item ko‘rsatamiz
            Box(
                modifier = Modifier
                    .aspectRatio(0.75f) // videoning nisbatiga yaqin
                    .clip(RoundedCornerShape(12.dp))
                    .placeholder(
                        visible = true,
                        color = Color.Gray.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(12.dp),
                        highlight = PlaceholderHighlight.shimmer(
                            highlightColor = MaterialTheme.colorScheme.surface
                        )
                    )
            )
        }
    }
}

