package com.bajaj.rideconnect.re.ui.cockpit

import android.content.res.Configuration
import android.graphics.Bitmap
import android.widget.Toast
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
import androidx.compose.foundation.basicMarquee
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bajaj.rideconnect.re.R
import com.bajaj.rideconnect.re.ui.theme.CockpitAccent
import com.bajaj.rideconnect.re.ui.theme.CockpitAction
import com.bajaj.rideconnect.re.ui.theme.CockpitActionOn
import com.bajaj.rideconnect.re.ui.theme.CockpitBlack
import com.bajaj.rideconnect.re.ui.theme.CockpitBlackArgb
import com.bajaj.rideconnect.re.ui.theme.CockpitBorder
import com.bajaj.rideconnect.re.ui.theme.CockpitBorderSubtle
import com.bajaj.rideconnect.re.ui.theme.CockpitSurface
import com.bajaj.rideconnect.re.ui.theme.CockpitSurfaceElevated
import com.bajaj.rideconnect.re.ui.theme.MyPulsarTheme
import com.bajaj.rideconnect.re.ui.theme.PulsarAmber
import com.bajaj.rideconnect.re.ui.theme.PulsarGreen
import com.bajaj.rideconnect.re.ui.theme.TelemetryTimerStyle
import com.bajaj.rideconnect.re.ui.theme.TextPrimary
import com.bajaj.rideconnect.re.ui.theme.TextSecondary
import com.bajaj.rideconnect.re.ui.theme.TextTertiary
import compose.icons.FeatherIcons
import compose.icons.feathericons.ChevronLeft
import compose.icons.feathericons.ChevronRight
import compose.icons.feathericons.Lock
import compose.icons.feathericons.Music
import compose.icons.feathericons.Pause
import compose.icons.feathericons.Play
import compose.icons.feathericons.Power
import compose.icons.feathericons.SkipBack
import compose.icons.feathericons.SkipForward

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
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    var isManuallyCollapsed by remember { mutableStateOf(false) }
    val rotateToastText = stringResource(R.string.toast_rotate_landscape)

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
                    onClick = {
                        if (isLandscape) {
                            isManuallyCollapsed = false
                        } else {
                            Toast.makeText(context, rotateToastText, Toast.LENGTH_SHORT).show()
                        }
                    })
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
    Surface(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
        color = CockpitBlack.copy(alpha = 0.94f),
        border = BorderStroke(1.dp, CockpitBorder)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Header: Bike Status & Collapse Button
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
                    PulsingDot(color = dotColor, size = 7.dp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = bikeName,
                            style = MaterialTheme.typography.labelLarge,
                            color = TextPrimary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = bikeStatus,
                            style = MaterialTheme.typography.bodySmall,
                            color = if (isBleConnected) PulsarGreen else TextSecondary
                        )
                    }
                }

                Spacer(modifier = Modifier.width(6.dp))

                HudCircleButton(
                    onClick = onCollapse,
                    contentDescription = stringResource(R.string.cd_collapse_hud),
                    size = 36.dp
                ) {
                    Icon(
                        imageVector = FeatherIcons.ChevronLeft,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = TextSecondary
                    )
                }
            }

            // Media Control Card (Expands to occupy vertical space evenly)
            MediaControlCard(
                mediaInfo = mediaInfo,
                onPlayPauseToggle = onPlayPauseToggle,
                onSkipNext = onSkipNext,
                onSkipPrevious = onSkipPrevious,
                onSeek = onSeek,
                onRequestNotificationPermission = onRequestNotificationPermission,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )

            // Cockpit Footer Deck
            CockpitFooterDeck(
                isBleConnected = isBleConnected, onBikeClick = onBikeClick, onExitApp = onExitApp
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
        Surface(
            onClick = onRequestNotificationPermission,
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            color = CockpitSurface,
            border = BorderStroke(1.dp, PulsarAmber.copy(alpha = 0.4f))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
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
                        style = MaterialTheme.typography.labelLarge,
                        color = PulsarAmber
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(R.string.media_grant_access_desc),
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    onClick = onRequestNotificationPermission,
                    shape = RoundedCornerShape(8.dp),
                    color = CockpitSurfaceElevated,
                    border = BorderStroke(1.dp, CockpitBorder)
                ) {
                    Text(
                        text = stringResource(R.string.media_enable_access),
                        style = MaterialTheme.typography.labelMedium,
                        color = TextPrimary,
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

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = CockpitSurface,
        border = BorderStroke(1.dp, CockpitBorder)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween
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
                    border = BorderStroke(1.dp, CockpitBorderSubtle)
                ) {
                    Text(
                        text = displaySource,
                        style = MaterialTheme.typography.labelSmall,
                        color = TextSecondary,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (mediaInfo.isPlaying) {
                        PulsingDot(color = PulsarGreen, size = 6.dp)
                    } else {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(TextTertiary)
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (mediaInfo.isPlaying) {
                            stringResource(R.string.media_status_playing)
                        } else {
                            stringResource(R.string.media_status_paused)
                        },
                        style = MaterialTheme.typography.labelSmall,
                        color = if (mediaInfo.isPlaying) PulsarGreen else TextSecondary
                    )
                }
            }

            // Album Artwork & Track Info
            val albumBitmap = remember(mediaInfo.albumArt) { mediaInfo.albumArt?.asImageBitmap() }
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                if (albumBitmap != null) {
                    Image(
                        bitmap = albumBitmap,
                        contentDescription = stringResource(R.string.cd_album_art),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, CockpitBorder, RoundedCornerShape(8.dp))
                    )
                } else {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = CockpitSurfaceElevated,
                        border = BorderStroke(1.dp, CockpitBorder),
                        modifier = Modifier.size(48.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = FeatherIcons.Music,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp),
                                tint = CockpitAccent
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = displayTitle,
                        style = MaterialTheme.typography.titleMedium,
                        color = TextPrimary,
                        maxLines = 1,
                        modifier = Modifier.basicMarquee()
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = displayArtist,
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // Responsive Seekbar & Duration Counters Section
            Column(modifier = Modifier.fillMaxWidth()) {
                var isDragging by remember { mutableStateOf(false) }
                var dragProgress by remember { mutableFloatStateOf(0f) }
                val currentProgress = if (isDragging) dragProgress else mediaInfo.progress

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp)
                        .height(20.dp)
                        .pointerInput(Unit) {
                            detectTapGestures { offset ->
                                val width = size.width
                                if (width > 0) {
                                    val ratio = (offset.x / width).coerceIn(0f, 1f)
                                    onSeek(ratio)
                                }
                            }
                        }
                        .pointerInput(Unit) {
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
                            .height(4.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(CockpitBorderSubtle)
                    ) {
                        if (currentProgress > 0f) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(
                                        currentProgress.coerceIn(
                                            0.001f, 1f
                                        )
                                    )
                                    .fillMaxHeight()
                                    .background(CockpitAccent)
                            )
                        }
                    }

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

                // Monospace Tabular Duration Counters
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = mediaInfo.currentPosition,
                        style = TelemetryTimerStyle,
                        color = TextSecondary
                    )
                    Text(
                        text = mediaInfo.totalDuration,
                        style = TelemetryTimerStyle,
                        color = TextSecondary
                    )
                }
            }

            // Large Ergonomic Media Controls
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HudCircleButton(
                    onClick = onSkipPrevious,
                    contentDescription = stringResource(R.string.media_action_prev),
                    size = 46.dp
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
                    size = 56.dp,
                    containerColor = if (mediaInfo.isPlaying) CockpitAction else CockpitSurfaceElevated,
                    borderColor = if (mediaInfo.isPlaying) Color.Transparent else CockpitAccent
                ) {
                    Icon(
                        imageVector = if (mediaInfo.isPlaying) FeatherIcons.Pause else FeatherIcons.Play,
                        contentDescription = null,
                        modifier = Modifier.size(if (mediaInfo.isPlaying) 22.dp else 24.dp),
                        tint = if (mediaInfo.isPlaying) CockpitActionOn else CockpitAccent
                    )
                }

                HudCircleButton(
                    onClick = onSkipNext,
                    contentDescription = stringResource(R.string.media_action_next),
                    size = 46.dp
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
    onExitApp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(34.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val bikeActionText = if (isBleConnected) {
            stringResource(R.string.status_linked)
        } else {
            stringResource(R.string.action_connect_bike)
        }
        val bikeActionColor = if (isBleConnected) PulsarGreen else PulsarAmber

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
                    PulsingDot(color = bikeActionColor, size = 6.dp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = bikeActionText,
                        style = MaterialTheme.typography.labelMedium,
                        color = bikeActionColor,
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
            onClick = onExitApp,
            contentDescription = stringResource(R.string.action_exit),
            size = 34.dp,
            borderColor = PulsarAmber.copy(alpha = 0.4f)
        ) {
            Icon(
                imageVector = FeatherIcons.Power,
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = PulsarAmber
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
    val tabHeight = if (isLandscape) 36.dp else 32.dp
    val textMaxWidth = if (isLandscape) 80.dp else 64.dp

    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp),
        color = CockpitSurface.copy(alpha = 0.95f),
        border = BorderStroke(1.dp, CockpitBorder),
        modifier = modifier
            .height(tabHeight)
            .semantics { contentDescription = edgeTabDesc }) {
        Row(
            modifier = Modifier.padding(start = 8.dp, end = 10.dp, top = 4.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val pillDotColor = when {
                isBleConnected -> PulsarGreen
                mediaInfo.isPlaying -> CockpitAccent
                else -> TextTertiary
            }
            PulsingDot(color = pillDotColor, size = 6.dp)
            Spacer(modifier = Modifier.width(5.dp))

            val isTrackShown = mediaInfo.isPlaying && mediaInfo.title.isNotEmpty()
            if (isTrackShown) {
                Icon(
                    imageVector = FeatherIcons.Music,
                    contentDescription = null,
                    modifier = Modifier.size(11.dp),
                    tint = CockpitAccent
                )
                Spacer(modifier = Modifier.width(3.dp))
            }
            Text(
                text = if (isTrackShown) mediaInfo.title else bikeName,
                style = MaterialTheme.typography.labelSmall,
                color = TextPrimary,
                maxLines = 1,
                overflow = TextOverflow.Clip,
                modifier = Modifier
                    .widthIn(max = textMaxWidth)
                    .basicMarquee()
            )

            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = FeatherIcons.ChevronRight,
                contentDescription = null,
                modifier = Modifier.size(11.dp),
                tint = TextSecondary
            )
        }
    }
}

@Composable
private fun PulsingDot(
    color: Color, modifier: Modifier = Modifier, size: Dp = 8.dp
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.35f, targetValue = 1.0f, animationSpec = infiniteRepeatable(
            animation = tween(700), repeatMode = RepeatMode.Reverse
        ), label = "dotAlpha"
    )

    Box(
        modifier = modifier
            .size(size)
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