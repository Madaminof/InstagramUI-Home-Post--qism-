package com.example.instagramprofile.View.Profile
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.instagramprofile.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import com.example.instagramprofile.Components.ButtonNavBar.BottomNavBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.compose.material3.TabRow
import androidx.compose.material3.Tab
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.filled.Loop
import androidx.compose.material.icons.filled.Person

@Composable
fun ProfileScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = navController,
                selectedIndex = selectedIndex,
                onSelectedChange = { selectedIndex = it }
            )
        }
    ) { padding ->
        ProfileView(padding = padding)
    }
}

@Composable
fun ProfileView(padding: PaddingValues = PaddingValues()){
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        UsernameRow()
        ProfileHeaderSection()
        BioRow(
            bioText = "Android Developer",
            linkText = "t.me/android_notes_developer"
        )

        DashboardView()
        Spacer(modifier = Modifier.height(6.dp))
        ButtonRow()
        ProfileTabs(
            selectedTabIndex = selectedTabIndex,
            onTabSelected = { index ->
                selectedTabIndex = index
            }
        )

        // Content
        when (selectedTabIndex) {
            0 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Create your first post",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Give this space some love",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = { /* TODO: Post yaratish action */ }) {
                        Text(text = "Create", color = Color.White)
                    }
                }
            }

            1 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Reels bo‘limi")
                }
            }

            2 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Uzatish")
                }
            }
            3 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Tagged bo‘limi")
                }
            }
        }

    }
}




@Composable
fun UsernameRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp, start = 24.dp, end = 16.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "sames_o2",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        )

        // Iconlar bir xil masofada
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp) // teng bo‘shliq
        ) {
            Icon(
                imageVector = Icons.Default.AlternateEmail,
                contentDescription = "@",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .clickable { /* Send bosilganda amal */ }
                    .padding(4.dp)
            )

            Icon(
                imageVector = Icons.Default.AddCircleOutline,
                contentDescription = "add",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .clickable { /* Like bosilganda amal */ }
                    .padding(4.dp)
            )

            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .clickable { /* Menu bosilganda amal */ }
                    .padding(4.dp)
            )
        }
    }
}


// postRow.kt
@Composable
fun ProfileHeaderSection(
    profileImageRes: Int = R.drawable.r1, // profil rasmi resursi
    name: String = "Samandar",
    postsCount: String = "0",
    followersCount: String = "100k",
    followingCount: String = "10"
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Ism tepasida

        Spacer(modifier = Modifier.height(12.dp))

        // Profil rasmi va statistikalar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp), // chap va o‘ngdan masofa
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = profileImageRes),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(24.dp)) // rasm va statistikalar orasidagi masofa

            Column {
                // Ism tepasida
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(28.dp) // statistikalar orasidagi bo‘shliq

                ) {
                    ProfileStat(number = postsCount, label = "Posts")
                    ProfileStat(number = followersCount, label = "Followers")
                    ProfileStat(number = followingCount, label = "Following")
                }
            }
        }


    }
}

@Composable
fun ProfileStat(number: String, label: String) {
    Column(
        modifier = Modifier.clickable {  },
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = number.toString(),
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onBackground
            )
        )
    }
}



@Composable
fun BioRow(
    bioText: String,
    linkText: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 4.dp)
    ) {
        Text(
            text = bioText,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onBackground
            )
        )


        Text(
            modifier = Modifier.clickable {  },
            text = linkText,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color(0xFF7E65C4)
            )
        )
    }
}

@Composable
fun ButtonRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically // 🟢 Shu kerak
    ) {
        // Birinchi keng button
        Button(
            onClick = { /* Amal */ },
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            Text(text = "Edit profile")
        }

        // Ikkinchi keng button
        Button(
            onClick = { /* Amal */ },
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            Text(text = "Share profile")
        }

        // Kichik button icon bilan
        Button(
            onClick = { /* Amal */ },
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.CenterVertically), // 🟢 Qator bilan markazga
            shape = RoundedCornerShape(12.dp),
            contentPadding = PaddingValues(0.dp), // icon to‘liq ko‘rsin
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.background
            )
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Add",
                tint = MaterialTheme.colorScheme.onBackground, // Rangni dark/light bilan moslashtirdik

                modifier = Modifier.fillMaxSize(0.7f) // iconni button ichida kattalashtiramiz
            )
        }
    }
}






@Composable
fun ProfileTabs(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val tabs = listOf(
        Icons.Default.GridOn,  // Grid (postlar)
        Icons.Default.VideoLibrary, // Reels
        Icons.Default.Loop,  // Remix
        Icons.Default.Person // Tagged
    )

    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground
    ) {
        tabs.forEachIndexed { index, icon ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                selectedContentColor = MaterialTheme.colorScheme.onBackground,
                unselectedContentColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Tab $index",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}




@Composable
fun DashboardView(modifier: Modifier = Modifier) {
    Button(
        onClick = { /* Amal */ },
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
        ) {
            Text("Dashboard", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "110k views in the last 30 days",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f) // xira rang
                )
            )
        }
    }
}






