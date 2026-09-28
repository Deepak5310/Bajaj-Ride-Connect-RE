package com.bajaj.rideconnect.re.ui.cockpit

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.bajaj.rideconnect.re.R
import com.bajaj.rideconnect.re.ui.theme.CockpitAccent
import com.bajaj.rideconnect.re.ui.theme.CockpitAction
import com.bajaj.rideconnect.re.ui.theme.CockpitActionOn
import com.bajaj.rideconnect.re.ui.theme.CockpitBlack
import com.bajaj.rideconnect.re.ui.theme.CockpitBlackArgb
import com.bajaj.rideconnect.re.ui.theme.CockpitBorder
import com.bajaj.rideconnect.re.ui.theme.CockpitSurface
import com.bajaj.rideconnect.re.ui.theme.CockpitSurfaceElevated
import com.bajaj.rideconnect.re.ui.theme.MyPulsarTheme
import com.bajaj.rideconnect.re.ui.theme.PulsarAmber
import com.bajaj.rideconnect.re.ui.theme.PulsarGreen
import com.bajaj.rideconnect.re.ui.theme.TextPrimary
import com.bajaj.rideconnect.re.ui.theme.TextSecondary
import com.bajaj.rideconnect.re.ui.theme.TextTertiary
import compose.icons.FeatherIcons
import compose.icons.feathericons.ChevronLeft
import compose.icons.feathericons.ChevronRight
import compose.icons.feathericons.Github
import compose.icons.feathericons.Info
import compose.icons.feathericons.Lock
import compose.icons.feathericons.Music
import compose.icons.feathericons.Pause
import compose.icons.feathericons.Play
import compose.icons.feathericons.Power
import compose.icons.feathericons.SkipBack
import compose.icons.feathericons.SkipForward
import compose.icons.feathericons.Volume2
import compose.icons.feathericons.X

@Immutable
data class MediaTrackInfo(
    val title: String = "",
    val artist: String = "",
    val isPlaying: Boolean = false,
    val progress: Float = 0f,
    val currentPosition: String = "0:00",
    val totalDuration: String = "0:00",
    val source: String = "",
    val albumArt: Bitmap? = null,
    val hasPermission: Boolean = true
)

@Composable
fun CockpitHud(
    modifier: Modifier = Modifier,
    bikeName: String = stringResource(R.string.no_bike_connected),
    bikeStatus: String = stringResource(R.string.status_standby),
    isBleConnected: Boolean = false,
    mediaInfo: MediaTrackInfo = MediaTrackInfo(),
    onExpandedChanged: (Boolean) -> Unit = {},
    onPlayPauseToggle: () -> Unit = {},
    onSkipNext: () -> Unit = {},
    onSkipPrevious: () -> Unit = {},
    onSeek: (Float) -> Unit = {},
    onRequestNotificationPermission: () -> Unit = {},
    onBikeClick: () -> Unit = {},
    onExitApp: () -> Unit = {}
) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    var isManuallyCollapsed by remember { mutableStateOf(false) }

    val showDock = isLandscape && !isManuallyCollapsed

    LaunchedEffect(showDock) {
        onExpandedChanged(showDock)
    }

    Box(
        modifier = modifier, contentAlignment = Alignment.CenterStart
    ) {
        AnimatedContent(
            targetState = showDock,
            transitionSpec = { fadeIn() togetherWith fadeOut() },
            label = "HudTransition"
        ) { expanded ->
            if (expanded) {
                RiderDock(
                    bikeName = bikeName,
                    bikeStatus = bikeStatus,
                    isBleConnected = isBleConnected,
                    mediaInfo = mediaInfo,
                    onCollapse = { isManuallyCollapsed = true },
                    onPlayPauseToggle = onPlayPauseToggle,
                    onSkipNext = onSkipNext,
                    onSkipPrevious = onSkipPrevious,
                    onSeek = onSeek,
                    onRequestNotificationPermission = onRequestNotificationPermission,
                    onBikeClick = onBikeClick,
                    onExitApp = onExitApp,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                RiderEdgeTab(
                    isLandscape = isLandscape,
                    bikeName = bikeName,
                    isBleConnected = isBleConnected,
                    mediaInfo = mediaInfo,
                    onClick = { if (isLandscape) isManuallyCollapsed = false })
            }
        }
    }
}

@Composable
private fun RiderDock(
    bikeName: String,
    bikeStatus: String,
    isBleConnected: Boolean,
    mediaInfo: MediaTrackInfo,
    onCollapse: () -> Unit,
    onPlayPauseToggle: () -> Unit,
    onSkipNext: () -> Unit,
    onSkipPrevious: () -> Unit,
    onSeek: (Float) -> Unit,
    onRequestNotificationPermission: () -> Unit,
    onBikeClick: () -> Unit,
    onExitApp: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showGuide by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
            colors = CardDefaults.cardColors(containerColor = CockpitBlack.copy(alpha = 0.95f)),
            border = BorderStroke(1.dp, CockpitBorder)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .padding(start = 10.dp, end = 10.dp, top = 6.dp, bottom = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // 1. Header: Bike Status & Collapse Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { onBikeClick() }
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                        val dotColor = when {
                            isBleConnected -> PulsarGreen
                            bikeStatus == stringResource(R.string.status_connecting) -> PulsarAmber
                            else -> TextTertiary
                        }
                        PulsingDot(color = dotColor)
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = bikeName,
                                style = MaterialTheme.typography.labelMedium,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = bikeStatus,
                                style = MaterialTheme.typography.labelSmall,
                                fontFamily = FontFamily.Monospace,
                                color = if (isBleConnected) PulsarGreen else TextSecondary,
                                fontSize = 9.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(6.dp))

                    HudCircleButton(
                        onClick = onCollapse,
                        contentDescription = stringResource(R.string.cd_collapse_hud),
                        size = 36.dp,
                        containerColor = CockpitSurfaceElevated,
                        borderColor = CockpitBorder
                    ) {
                        Icon(
                            imageVector = FeatherIcons.ChevronLeft,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = TextSecondary
                        )
                    }
                }

                // 2. Media Control Card (Track info, Seekbar & Large Transport Controls)
                MediaControlCard(
                    mediaInfo = mediaInfo,
                    onPlayPauseToggle = onPlayPauseToggle,
                    onSkipNext = onSkipNext,
                    onSkipPrevious = onSkipPrevious,
                    onSeek = onSeek,
                    onRequestNotificationPermission = onRequestNotificationPermission
                )

                // 3. Cockpit Footer Deck: Connection / Handlebar Guide & Exit
                CockpitFooterDeck(
                    isBleConnected = isBleConnected,
                    onBikeClick = onBikeClick,
                    onShowGuide = { showGuide = true },
                    onExitApp = onExitApp
                )
            }
        }

        if (showGuide) {
            HandlebarGuideOverlay(
                onDismiss = { showGuide = false }, modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
private fun MediaControlCard(
    mediaInfo: MediaTrackInfo,
    onPlayPauseToggle: () -> Unit,
    onSkipNext: () -> Unit,
    onSkipPrevious: () -> Unit,
    onSeek: (Float) -> Unit,
    onRequestNotificationPermission: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (!mediaInfo.hasPermission) {
        Card(
            onClick = onRequestNotificationPermission,
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = CockpitSurface),
            border = BorderStroke(1.dp, PulsarAmber.copy(alpha = 0.5f))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = FeatherIcons.Lock,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = PulsarAmber
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = stringResource(R.string.media_access_required),
                        style = MaterialTheme.typography.labelSmall,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        color = PulsarAmber,
                        fontSize = 11.sp
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(R.string.media_grant_access_desc),
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = CockpitSurfaceElevated,
                    border = BorderStroke(1.dp, CockpitBorder)
                ) {
                    Text(
                        text = stringResource(R.string.media_enable_access),
                        color = TextPrimary,
                        fontSize = 10.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    )
                }
            }
        }
        return
    }

    val displayTitle = mediaInfo.title.ifEmpty { stringResource(R.string.media_no_track) }
    val displayArtist = mediaInfo.artist.ifEmpty { stringResource(R.string.media_open_player) }
    val displaySource = mediaInfo.source.ifEmpty { stringResource(R.string.media_source_default) }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = CockpitSurface),
        border = BorderStroke(1.dp, CockpitBorder)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp)
        ) {
            // Source Badge & Live Status Pill
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = CockpitSurfaceElevated,
                    border = BorderStroke(1.dp, CockpitBorder)
                ) {
                    Text(
                        text = displaySource,
                        color = TextSecondary,
                        fontSize = 9.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(if (mediaInfo.isPlaying) PulsarGreen else TextTertiary)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (mediaInfo.isPlaying) {
                            stringResource(R.string.media_status_playing)
                        } else {
                            stringResource(R.string.media_status_paused)
                        },
                        style = MaterialTheme.typography.labelSmall,
                        fontFamily = FontFamily.Monospace,
                        color = if (mediaInfo.isPlaying) PulsarGreen else TextSecondary,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Album Artwork & Track Info
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                if (mediaInfo.albumArt != null) {
                    Image(
                        bitmap = mediaInfo.albumArt.asImageBitmap(),
                        contentDescription = stringResource(R.string.cd_album_art),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(44.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, CockpitBorder, RoundedCornerShape(8.dp))
                    )
                } else {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = CockpitSurfaceElevated,
                        border = BorderStroke(1.dp, CockpitBorder),
                        modifier = Modifier.size(44.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = FeatherIcons.Music,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp),
                                tint = TextSecondary
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = displayTitle,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = displayArtist,
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary,
                        fontSize = 11.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Responsive Seekbar
            var isDragging by remember { mutableStateOf(false) }
            var dragProgress by remember { mutableFloatStateOf(0f) }
            val currentProgress = if (isDragging) dragProgress else mediaInfo.progress

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 22.dp, end = 6.dp)
                    .height(18.dp)
                    .pointerInput(mediaInfo.totalDuration) {
                        detectTapGestures { offset ->
                            val width = size.width
                            if (width > 0) {
                                val ratio = (offset.x / width).coerceIn(0f, 1f)
                                onSeek(ratio)
                            }
                        }
                    }
                    .pointerInput(mediaInfo.totalDuration) {
                        detectHorizontalDragGestures(onDragStart = { offset ->
                            isDragging = true
                            val width = size.width
                            if (width > 0) {
                                dragProgress = (offset.x / width).coerceIn(0f, 1f)
                            }
                        }, onDragEnd = {
                            isDragging = false
                            onSeek(dragProgress)
                        }, onDragCancel = {
                            isDragging = false
                        }, onHorizontalDrag = { change, _ ->
                            change.consume()
                            val width = size.width
                            if (width > 0) {
                                dragProgress = (change.position.x / width).coerceIn(0f, 1f)
                            }
                        })
                    }, contentAlignment = Alignment.CenterStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(3.5.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(CockpitBorder)
                ) {
                    if (currentProgress > 0f) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(currentProgress.coerceIn(0.001f, 1f))
                                .fillMaxHeight()
                                .background(CockpitAccent)
                        )
                    }
                }

                if (currentProgress > 0f) {
                    Box(
                        modifier = Modifier.fillMaxWidth(currentProgress.coerceIn(0.001f, 1f)),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Box(
                            modifier = Modifier
                                .size(if (isDragging) 12.dp else 8.dp)
                                .clip(CircleShape)
                                .background(CockpitAction)
                                .border(1.dp, CockpitAccent, CircleShape)
                        )
                    }
                }
            }

            // Duration Counters
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 22.dp, end = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = mediaInfo.currentPosition,
                    style = MaterialTheme.typography.labelSmall,
                    fontFamily = FontFamily.Monospace,
                    color = TextSecondary,
                    fontSize = 9.sp
                )
                Text(
                    text = mediaInfo.totalDuration,
                    style = MaterialTheme.typography.labelSmall,
                    fontFamily = FontFamily.Monospace,
                    color = TextSecondary,
                    fontSize = 9.sp
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Large Ergonomic Media Controls (44dp - 52dp hit targets)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HudCircleButton(
                    onClick = onSkipPrevious,
                    contentDescription = stringResource(R.string.media_action_prev),
                    size = 44.dp,
                    containerColor = CockpitSurfaceElevated,
                    borderColor = CockpitBorder
                ) {
                    Icon(
                        imageVector = FeatherIcons.SkipBack,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint = TextPrimary
                    )
                }

                HudCircleButton(
                    onClick = onPlayPauseToggle,
                    contentDescription = stringResource(R.string.media_action_play_pause),
                    size = 52.dp,
                    containerColor = if (mediaInfo.isPlaying) CockpitAction else CockpitSurfaceElevated,
                    borderColor = if (mediaInfo.isPlaying) Color.Transparent else CockpitBorder
                ) {
                    if (mediaInfo.isPlaying) {
                        Icon(
                            imageVector = FeatherIcons.Pause,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = CockpitActionOn
                        )
                    } else {
                        Icon(
                            imageVector = FeatherIcons.Play,
                            contentDescription = null,
                            modifier = Modifier.size(22.dp),
                            tint = CockpitAction
                        )
                    }
                }

                HudCircleButton(
                    onClick = onSkipNext,
                    contentDescription = stringResource(R.string.media_action_next),
                    size = 44.dp,
                    containerColor = CockpitSurfaceElevated,
                    borderColor = CockpitBorder
                ) {
                    Icon(
                        imageVector = FeatherIcons.SkipForward,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint = TextPrimary
                    )
                }
            }
        }
    }
}


@Composable
private fun CockpitFooterDeck(
    isBleConnected: Boolean,
    onBikeClick: () -> Unit,
    onShowGuide: () -> Unit,
    onExitApp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(34.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (!isBleConnected) {
            Surface(
                onClick = onBikeClick,
                shape = RoundedCornerShape(10.dp),
                color = CockpitSurface,
                border = BorderStroke(1.dp, CockpitBorder),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        PulsingDot(color = PulsarAmber)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = stringResource(R.string.action_connect_bike),
                            style = MaterialTheme.typography.labelSmall,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            color = PulsarAmber,
                            fontSize = 10.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Icon(
                        imageVector = FeatherIcons.ChevronRight,
                        contentDescription = null,
                        modifier = Modifier.size(12.dp),
                        tint = TextSecondary
                    )
                }
            }

            Spacer(modifier = Modifier.width(6.dp))

            HudCircleButton(
                onClick = onShowGuide,
                contentDescription = stringResource(R.string.action_guide),
                size = 34.dp,
                containerColor = CockpitSurfaceElevated,
                borderColor = CockpitBorder
            ) {
                Icon(
                    imageVector = FeatherIcons.Info,
                    contentDescription = null,
                    modifier = Modifier.size(15.dp),
                    tint = CockpitAccent
                )
            }

            Spacer(modifier = Modifier.width(6.dp))

            HudCircleButton(
                onClick = onExitApp,
                contentDescription = stringResource(R.string.action_exit),
                size = 34.dp,
                containerColor = CockpitSurfaceElevated,
                borderColor = PulsarAmber.copy(alpha = 0.5f)
            ) {
                Icon(
                    imageVector = FeatherIcons.Power,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = PulsarAmber
                )
            }
        } else {
            // Connected State: Two Dedicated Buttons (Guide & Exit)
            Surface(
                onClick = onShowGuide,
                shape = RoundedCornerShape(10.dp),
                color = CockpitSurfaceElevated,
                border = BorderStroke(1.dp, CockpitAccent.copy(alpha = 0.4f)),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = FeatherIcons.Info,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp),
                        tint = CockpitAccent
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = stringResource(R.string.action_guide),
                        style = MaterialTheme.typography.labelSmall,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        color = CockpitAccent,
                        fontSize = 10.sp
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Surface(
                onClick = onExitApp,
                shape = RoundedCornerShape(10.dp),
                color = CockpitSurfaceElevated,
                border = BorderStroke(1.dp, PulsarAmber.copy(alpha = 0.4f)),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = FeatherIcons.Power,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp),
                        tint = PulsarAmber
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = stringResource(R.string.action_exit),
                        style = MaterialTheme.typography.labelSmall,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        color = PulsarAmber,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun HandlebarGuideOverlay(
    onDismiss: () -> Unit, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
        colors = CardDefaults.cardColors(containerColor = CockpitBlack.copy(alpha = 0.98f)),
        border = BorderStroke(1.dp, CockpitBorder)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 12.dp, vertical = 8.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = FeatherIcons.Info,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = CockpitAccent
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = stringResource(R.string.guide_title),
                            style = MaterialTheme.typography.labelMedium,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary,
                            fontSize = 11.sp
                        )
                        Text(
                            text = stringResource(R.string.guide_subtitle),
                            style = MaterialTheme.typography.labelSmall,
                            fontFamily = FontFamily.Monospace,
                            color = TextSecondary,
                            fontSize = 9.sp
                        )
                    }
                }
                HudCircleButton(
                    onClick = onDismiss,
                    contentDescription = stringResource(R.string.guide_action_close),
                    size = 30.dp,
                    containerColor = CockpitSurfaceElevated,
                    borderColor = CockpitBorder
                ) {
                    Icon(
                        imageVector = FeatherIcons.X,
                        contentDescription = null,
                        modifier = Modifier.size(12.dp),
                        tint = TextSecondary
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Guide Rows (4 Switchgear Controls)
            Column(
                modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                GuideRow(
                    icon = {
                        Icon(
                            imageVector = FeatherIcons.Play,
                            contentDescription = null,
                            modifier = Modifier.size(13.dp),
                            tint = PulsarGreen
                        )
                    },
                    badgeColor = PulsarGreen,
                    action = stringResource(R.string.guide_action_play_pause),
                    instruction = stringResource(R.string.guide_inst_set)
                )
                GuideRow(
                    icon = {
                        Icon(
                            imageVector = FeatherIcons.SkipForward,
                            contentDescription = null,
                            modifier = Modifier.size(12.dp),
                            tint = CockpitAccent
                        )
                    },
                    badgeColor = CockpitAccent,
                    action = stringResource(R.string.guide_action_next),
                    instruction = stringResource(R.string.guide_inst_next)
                )
                GuideRow(
                    icon = {
                        Icon(
                            imageVector = FeatherIcons.SkipBack,
                            contentDescription = null,
                            modifier = Modifier.size(12.dp),
                            tint = CockpitAccent
                        )
                    },
                    badgeColor = CockpitAccent,
                    action = stringResource(R.string.guide_action_prev),
                    instruction = stringResource(R.string.guide_inst_prev)
                )
                GuideRow(
                    icon = {
                        Icon(
                            imageVector = FeatherIcons.Volume2,
                            contentDescription = null,
                            modifier = Modifier.size(13.dp),
                            tint = PulsarAmber
                        )
                    },
                    badgeColor = PulsarAmber,
                    action = stringResource(R.string.guide_action_volume),
                    instruction = stringResource(R.string.guide_inst_volume)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Developer GitHub Handle / Link
            val context = LocalContext.current
            Surface(
                onClick = {
                    try {
                        val browserIntent = Intent(
                            Intent.ACTION_VIEW, "https://github.com/Deepak5310".toUri()
                        ).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        }
                        context.startActivity(browserIntent)
                    } catch (_: Exception) {
                    }
                    onDismiss()
                },
                shape = RoundedCornerShape(8.dp),
                color = CockpitSurfaceElevated,
                border = BorderStroke(1.dp, CockpitBorder),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = FeatherIcons.Github,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp),
                        tint = CockpitAccent
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = stringResource(R.string.guide_github_handle),
                        style = MaterialTheme.typography.labelSmall,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun GuideRow(
    icon: @Composable () -> Unit,
    badgeColor: Color,
    action: String,
    instruction: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .background(CockpitSurface)
            .border(BorderStroke(0.5.dp, CockpitBorder), RoundedCornerShape(6.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = RoundedCornerShape(4.dp),
            color = badgeColor.copy(alpha = 0.15f),
            border = BorderStroke(1.dp, badgeColor.copy(alpha = 0.5f)),
            modifier = Modifier.size(24.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                icon()
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = action,
                color = TextPrimary,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp
            )
            Text(
                text = instruction,
                color = TextSecondary,
                fontFamily = FontFamily.Monospace,
                fontSize = 9.sp,
                maxLines = 2,
                softWrap = true
            )
        }
    }
}

@Composable
private fun HudCircleButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    size: Dp = 44.dp,
    containerColor: Color = CockpitSurfaceElevated,
    borderColor: Color = CockpitBorder,
    content: @Composable () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = CircleShape,
        color = containerColor,
        border = if (borderColor != Color.Transparent) BorderStroke(1.dp, borderColor) else null,
        modifier = modifier
            .size(size)
            .semantics {
                if (contentDescription != null) {
                    this.contentDescription = contentDescription
                }
            }) {
        Box(contentAlignment = Alignment.Center) {
            content()
        }
    }
}

@Composable
private fun RiderEdgeTab(
    isLandscape: Boolean,
    bikeName: String,
    isBleConnected: Boolean,
    mediaInfo: MediaTrackInfo,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val edgeTabDesc = if (isLandscape) {
        stringResource(R.string.cd_expand_hud)
    } else {
        stringResource(R.string.cd_rotate_screen)
    }
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(topEnd = 14.dp, bottomEnd = 14.dp),
        color = CockpitSurface.copy(alpha = 0.95f),
        border = BorderStroke(1.dp, CockpitBorder),
        modifier = modifier
            .height(44.dp)
            .semantics { contentDescription = edgeTabDesc }) {
        Row(
            modifier = Modifier.padding(start = 10.dp, end = 12.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val pillDotColor = when {
                isBleConnected -> PulsarGreen
                mediaInfo.isPlaying -> CockpitAccent
                else -> TextTertiary
            }
            PulsingDot(color = pillDotColor)
            Spacer(modifier = Modifier.width(6.dp))

            if (mediaInfo.isPlaying && mediaInfo.title.isNotEmpty()) {
                Icon(
                    imageVector = FeatherIcons.Music,
                    contentDescription = null,
                    modifier = Modifier.size(12.dp),
                    tint = CockpitAccent
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = mediaInfo.title.take(12),
                    style = MaterialTheme.typography.labelSmall,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Medium,
                    color = TextPrimary,
                    maxLines = 1
                )
            } else {
                Text(
                    text = bikeName,
                    style = MaterialTheme.typography.labelSmall,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Medium,
                    color = TextPrimary,
                    maxLines = 1
                )
            }

            Spacer(modifier = Modifier.width(6.dp))
            Icon(
                imageVector = FeatherIcons.ChevronRight,
                contentDescription = null,
                modifier = Modifier.size(12.dp),
                tint = TextSecondary
            )
        }
    }
}

@Composable
private fun PulsingDot(
    color: Color, modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.35f, targetValue = 1.0f, animationSpec = infiniteRepeatable(
            animation = tween(700), repeatMode = RepeatMode.Reverse
        ), label = "dotAlpha"
    )

    Box(modifier = modifier
        .size(8.dp)
        .graphicsLayer { this.alpha = alpha }
        .background(color, CircleShape))
}

@Preview(
    name = "Landscape Dock",
    device = "spec:parent=pixel_5,orientation=landscape",
    showBackground = true,
    backgroundColor = CockpitBlackArgb
)
@Composable
private fun CockpitHudLandscapePreview() {
    MyPulsarTheme {
        CockpitHud(
            bikeName = stringResource(R.string.bike_name), mediaInfo = MediaTrackInfo(
                title = "Blinding Lights",
                artist = "The Weeknd",
                isPlaying = true,
                progress = 0.45f,
                currentPosition = "1:38",
                totalDuration = "3:20",
                source = "SPOTIFY"
            )
        )
    }
}

@Preview(
    name = "Portrait Edge Tab", showBackground = true, backgroundColor = CockpitBlackArgb
)
@Composable
private fun CockpitHudPortraitPreview() {
    MyPulsarTheme {
        CockpitHud(
            bikeName = stringResource(R.string.bike_name)
        )
    }
}