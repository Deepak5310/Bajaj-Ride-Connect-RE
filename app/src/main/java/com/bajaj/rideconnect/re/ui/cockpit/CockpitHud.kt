package com.bajaj.rideconnect.re.ui.cockpit

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
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
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
    volumePct: Int = 70,
    onVolumeDown: () -> Unit = {},
    onVolumeUp: () -> Unit = {},
    onExpandedChanged: (Boolean) -> Unit = {},
    onPlayPauseToggle: () -> Unit = {},
    onSkipNext: () -> Unit = {},
    onSkipPrevious: () -> Unit = {},
    onSeek: (Float) -> Unit = {},
    onRequestNotificationPermission: () -> Unit = {},
    onBikeClick: () -> Unit = {}
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
                    volumePct = volumePct,
                    onVolumeDown = onVolumeDown,
                    onVolumeUp = onVolumeUp,
                    onCollapse = { isManuallyCollapsed = true },
                    onPlayPauseToggle = onPlayPauseToggle,
                    onSkipNext = onSkipNext,
                    onSkipPrevious = onSkipPrevious,
                    onSeek = onSeek,
                    onRequestNotificationPermission = onRequestNotificationPermission,
                    onBikeClick = onBikeClick,
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
    volumePct: Int,
    onVolumeDown: () -> Unit,
    onVolumeUp: () -> Unit,
    onCollapse: () -> Unit,
    onPlayPauseToggle: () -> Unit,
    onSkipNext: () -> Unit,
    onSkipPrevious: () -> Unit,
    onSeek: (Float) -> Unit,
    onRequestNotificationPermission: () -> Unit,
    onBikeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
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
                    ChevronLeftIcon(modifier = Modifier.size(16.dp), tint = TextSecondary)
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

            // 3. Ergonomic Glove-Friendly Volume Deck
            VolumeCockpitDeck(
                volumePct = volumePct, onVolumeDown = onVolumeDown, onVolumeUp = onVolumeUp
            )

            // 4. Cockpit Footer Deck: Connection / Handlebar Monitor
            CockpitFooterDeck(
                isBleConnected = isBleConnected, onBikeClick = onBikeClick
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
                    LockIcon(modifier = Modifier.size(16.dp), tint = PulsarAmber)
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
                            MusicNoteIcon(modifier = Modifier.size(20.dp), tint = TextSecondary)
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
                    .padding(start = 14.dp, end = 4.dp)
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
                    .padding(start = 14.dp, end = 4.dp),
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
                    PreviousIcon(modifier = Modifier.size(18.dp), tint = TextPrimary)
                }

                HudCircleButton(
                    onClick = onPlayPauseToggle,
                    contentDescription = stringResource(R.string.media_action_play_pause),
                    size = 52.dp,
                    containerColor = if (mediaInfo.isPlaying) CockpitAction else CockpitSurfaceElevated,
                    borderColor = if (mediaInfo.isPlaying) Color.Transparent else CockpitBorder
                ) {
                    if (mediaInfo.isPlaying) {
                        PauseIcon(modifier = Modifier.size(20.dp), tint = CockpitActionOn)
                    } else {
                        PlayIcon(modifier = Modifier.size(22.dp), tint = CockpitAction)
                    }
                }

                HudCircleButton(
                    onClick = onSkipNext,
                    contentDescription = stringResource(R.string.media_action_next),
                    size = 44.dp,
                    containerColor = CockpitSurfaceElevated,
                    borderColor = CockpitBorder
                ) {
                    NextIcon(modifier = Modifier.size(18.dp), tint = TextPrimary)
                }
            }
        }
    }
}

@Composable
private fun VolumeCockpitDeck(
    volumePct: Int, onVolumeDown: () -> Unit, onVolumeUp: () -> Unit, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = CockpitSurface),
        border = BorderStroke(1.dp, CockpitBorder)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Large Tactile Minus Button (48dp x 44dp)
            Surface(
                onClick = onVolumeDown,
                shape = RoundedCornerShape(10.dp),
                color = CockpitSurfaceElevated,
                border = BorderStroke(1.dp, CockpitBorder),
                modifier = Modifier
                    .size(width = 48.dp, height = 44.dp)
                    .semantics { contentDescription = "Decrease volume" }) {
                Box(contentAlignment = Alignment.Center) {
                    MinusIcon(modifier = Modifier.size(18.dp), tint = TextPrimary)
                }
            }

            // Center Gauge & Percentage Display
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    SpeakerIcon(modifier = Modifier.size(14.dp), tint = CockpitAccent)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = stringResource(R.string.volume_format, volumePct),
                        style = MaterialTheme.typography.labelSmall,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary,
                        fontSize = 11.sp
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                // 10-Step LED Segment Meter matching Pulsar cluster scale
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(3.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val activeSegments = (volumePct / 10).coerceIn(0, 10)
                    for (i in 1..10) {
                        val isActive = i <= activeSegments
                        val segmentColor = when {
                            !isActive -> CockpitBorder
                            i > 8 -> PulsarAmber
                            else -> CockpitAccent
                        }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(5.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(segmentColor)
                        )
                    }
                }
            }

            // Large Tactile Plus Button (48dp x 44dp)
            Surface(
                onClick = onVolumeUp,
                shape = RoundedCornerShape(10.dp),
                color = CockpitSurfaceElevated,
                border = BorderStroke(1.dp, CockpitBorder),
                modifier = Modifier
                    .size(width = 48.dp, height = 44.dp)
                    .semantics { contentDescription = "Increase volume" }) {
                Box(contentAlignment = Alignment.Center) {
                    PlusIcon(modifier = Modifier.size(18.dp), tint = TextPrimary)
                }
            }
        }
    }
}

@Composable
private fun CockpitFooterDeck(
    isBleConnected: Boolean, onBikeClick: () -> Unit, modifier: Modifier = Modifier
) {
    Surface(
        onClick = onBikeClick,
        shape = RoundedCornerShape(10.dp),
        color = if (isBleConnected) CockpitSurfaceElevated else CockpitSurface,
        border = BorderStroke(
            1.dp, if (isBleConnected) PulsarGreen.copy(alpha = 0.35f) else CockpitBorder
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(34.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)
            ) {
                PulsingDot(color = if (isBleConnected) PulsarGreen else PulsarAmber)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (isBleConnected) {
                        stringResource(R.string.bike_handlebar_ready)
                    } else {
                        stringResource(R.string.action_connect_bike)
                    },
                    style = MaterialTheme.typography.labelSmall,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    color = if (isBleConnected) PulsarGreen else PulsarAmber,
                    fontSize = 10.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            ChevronRightIcon(
                modifier = Modifier.size(12.dp),
                tint = if (isBleConnected) PulsarGreen else TextSecondary
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
                MusicNoteIcon(modifier = Modifier.size(12.dp), tint = CockpitAccent)
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
            ChevronRightIcon(modifier = Modifier.size(12.dp), tint = TextSecondary)
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

// Clean Automotive Vector Icons
@Composable
fun PlayIcon(modifier: Modifier = Modifier, tint: Color = Color.White) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val path = Path().apply {
            moveTo(w * 0.24f, h * 0.16f)
            lineTo(w * 0.86f, h * 0.50f)
            lineTo(w * 0.24f, h * 0.84f)
            close()
        }
        drawPath(path, color = tint)
    }
}

@Composable
fun PauseIcon(modifier: Modifier = Modifier, tint: Color = Color.White) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val barWidth = w * 0.26f
        val barHeight = h * 0.72f
        val top = (h - barHeight) / 2f
        val corner = CornerRadius(barWidth / 2f)
        drawRoundRect(
            color = tint,
            topLeft = Offset(w * 0.16f, top),
            size = Size(barWidth, barHeight),
            cornerRadius = corner
        )
        drawRoundRect(
            color = tint,
            topLeft = Offset(w * 0.58f, top),
            size = Size(barWidth, barHeight),
            cornerRadius = corner
        )
    }
}

@Composable
fun PreviousIcon(modifier: Modifier = Modifier, tint: Color = Color.White) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val path = Path().apply {
            moveTo(w * 0.82f, h * 0.20f)
            lineTo(w * 0.34f, h * 0.50f)
            lineTo(w * 0.82f, h * 0.80f)
            close()
        }
        drawPath(path, color = tint)
        val barWidth = w * 0.14f
        drawRoundRect(
            color = tint,
            topLeft = Offset(w * 0.12f, h * 0.20f),
            size = Size(barWidth, h * 0.60f),
            cornerRadius = CornerRadius(barWidth / 2f)
        )
    }
}

@Composable
fun NextIcon(modifier: Modifier = Modifier, tint: Color = Color.White) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val path = Path().apply {
            moveTo(w * 0.18f, h * 0.20f)
            lineTo(w * 0.66f, h * 0.50f)
            lineTo(w * 0.18f, h * 0.80f)
            close()
        }
        drawPath(path, color = tint)
        val barWidth = w * 0.14f
        drawRoundRect(
            color = tint,
            topLeft = Offset(w * 0.74f, h * 0.20f),
            size = Size(barWidth, h * 0.60f),
            cornerRadius = CornerRadius(barWidth / 2f)
        )
    }
}

@Composable
fun PlusIcon(modifier: Modifier = Modifier, tint: Color = Color.White) {
    Canvas(modifier = modifier) {
        val stroke = 2.5f.dp.toPx()
        val c = center
        val arm = size.minDimension * 0.36f
        drawLine(tint, Offset(c.x - arm, c.y), Offset(c.x + arm, c.y), stroke, StrokeCap.Round)
        drawLine(tint, Offset(c.x, c.y - arm), Offset(c.x, c.y + arm), stroke, StrokeCap.Round)
    }
}

@Composable
fun MinusIcon(modifier: Modifier = Modifier, tint: Color = Color.White) {
    Canvas(modifier = modifier) {
        val stroke = 2.5f.dp.toPx()
        val c = center
        val arm = size.minDimension * 0.36f
        drawLine(tint, Offset(c.x - arm, c.y), Offset(c.x + arm, c.y), stroke, StrokeCap.Round)
    }
}

@Composable
fun SpeakerIcon(modifier: Modifier = Modifier, tint: Color = Color.White) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val cone = Path().apply {
            moveTo(w * 0.12f, h * 0.34f)
            lineTo(w * 0.36f, h * 0.34f)
            lineTo(w * 0.62f, h * 0.14f)
            lineTo(w * 0.62f, h * 0.86f)
            lineTo(w * 0.36f, h * 0.66f)
            lineTo(w * 0.12f, h * 0.66f)
            close()
        }
        drawPath(cone, color = tint)
        drawArc(
            color = tint,
            startAngle = -40f,
            sweepAngle = 80f,
            useCenter = false,
            topLeft = Offset(w * 0.44f, h * 0.24f),
            size = Size(w * 0.42f, h * 0.52f),
            style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round)
        )
    }
}

@Composable
fun ChevronLeftIcon(modifier: Modifier = Modifier, tint: Color = Color.White) {
    Canvas(modifier = modifier) {
        val path = Path().apply {
            moveTo(size.width * 0.64f, size.height * 0.24f)
            lineTo(size.width * 0.36f, size.height * 0.50f)
            lineTo(size.width * 0.64f, size.height * 0.76f)
        }
        drawPath(
            path, color = tint, style = Stroke(
                width = 2.2f.dp.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round
            )
        )
    }
}

@Composable
fun ChevronRightIcon(modifier: Modifier = Modifier, tint: Color = Color.White) {
    Canvas(modifier = modifier) {
        val path = Path().apply {
            moveTo(size.width * 0.36f, size.height * 0.24f)
            lineTo(size.width * 0.64f, size.height * 0.50f)
            lineTo(size.width * 0.36f, size.height * 0.76f)
        }
        drawPath(
            path, color = tint, style = Stroke(
                width = 2.2f.dp.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round
            )
        )
    }
}

@Composable
fun MusicNoteIcon(modifier: Modifier = Modifier, tint: Color = Color.White) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val r = w * 0.18f
        drawCircle(color = tint, radius = r, center = Offset(w * 0.32f, h * 0.74f))
        drawLine(
            color = tint,
            start = Offset(w * 0.32f + r, h * 0.74f),
            end = Offset(w * 0.32f + r, h * 0.20f),
            strokeWidth = 2.dp.toPx(),
            cap = StrokeCap.Round
        )
        val flag = Path().apply {
            moveTo(w * 0.32f + r, h * 0.20f)
            cubicTo(
                w * 0.75f, h * 0.24f, w * 0.75f, h * 0.44f, w * 0.52f, h * 0.52f
            )
        }
        drawPath(flag, color = tint, style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round))
    }
}

@Composable
fun LockIcon(modifier: Modifier = Modifier, tint: Color = Color.White) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        drawArc(
            color = tint,
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = false,
            topLeft = Offset(w * 0.26f, h * 0.12f),
            size = Size(w * 0.48f, h * 0.46f),
            style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round)
        )
        drawRoundRect(
            color = tint,
            topLeft = Offset(w * 0.18f, h * 0.44f),
            size = Size(w * 0.64f, h * 0.46f),
            cornerRadius = CornerRadius(3.dp.toPx())
        )
    }
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