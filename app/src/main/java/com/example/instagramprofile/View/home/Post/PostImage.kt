package com.example.instagramprofile.View.home.Post

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import coil.compose.rememberAsyncImagePainter
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.graphicsLayer
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout


@Composable
fun PostMedia(
    mediaUrl: String,
    onDoubleTapLike: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isVideo = remember(mediaUrl) {
        val clean = mediaUrl.lowercase().substringBefore('?').substringBefore('#')
        listOf(".mp4", ".mov", ".avi", ".m4v", ".webm").any { clean.endsWith(it) }
    }

    var showHeart by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    val scale by animateFloatAsState(
        targetValue = if (showHeart) 1f else 0f,
        animationSpec = tween(durationMillis = 300),
        label = "Heart Scale"
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(Color.Black)
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        showHeart = true
                        onDoubleTapLike()
                        coroutineScope.launch {
                            delay(600)
                            showHeart = false
                        }
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        if (isVideo) {
            val context = LocalContext.current
            val exoPlayer = remember {
                ExoPlayer.Builder(context).build().apply {
                    setMediaItem(MediaItem.fromUri(mediaUrl))
                    prepare()
                    playWhenReady = false
                    repeatMode = Player.REPEAT_MODE_ALL
                }
            }

            DisposableEffect(
                AndroidView(
                    factory = { ctx ->
                        PlayerView(ctx).apply {
                            player = exoPlayer
                            useController = true
                            resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                            layoutParams = FrameLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT
                            )
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )
            ) {
                onDispose {
                    exoPlayer.release()
                }
            }
        } else {
            Image(
                painter = rememberAsyncImagePainter(mediaUrl),
                contentDescription = "Post Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // Yurak animatsiyasi
        AnimatedVisibility(visible = showHeart) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Heart",
                tint = Color.Red,
                modifier = Modifier
                    .size(100.dp)
                    .scale(scale)
            )
        }
    }
}
