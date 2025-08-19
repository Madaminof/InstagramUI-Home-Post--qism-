package com.example.instagramprofile.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// 1️⃣ Light va Dark rang sxemalari
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFE1306C),
    secondary = Color(0xFF833AB4),
    background = Color.White,
    onBackground = Color.Black,
    surface = lightKulrang,

    )

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFE1306C),
    secondary = Color(0xFF833AB4),
    background = Color.Black,
    onBackground = Color.White,
    surface = blackKulrang,        // Yengil qora-yashil

)

// 2️⃣ Tipografiya
private val AppTypography = Typography(
    titleLarge = Typography().titleLarge.copy(color = Color.Unspecified),
    bodyMedium = Typography().bodyMedium.copy(color = Color.Unspecified)
)

// 3️⃣ Theme composable
@Composable
fun InstagramProfileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}
