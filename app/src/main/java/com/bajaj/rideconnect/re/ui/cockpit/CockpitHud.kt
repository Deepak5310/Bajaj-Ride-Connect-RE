package com.bajaj.rideconnect.re.ui.cockpit

import android.content.res.Configuration
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
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bajaj.rideconnect.re.R
import com.bajaj.rideconnect.re.ui.theme.CockpitBlack
import com.bajaj.rideconnect.re.ui.theme.CockpitBlackArgb
import com.bajaj.rideconnect.re.ui.theme.CockpitBorder
import com.bajaj.rideconnect.re.ui.theme.CockpitSurface
import com.bajaj.rideconnect.re.ui.theme.MyPulsarTheme
import com.bajaj.rideconnect.re.ui.theme.PulsarCyan
import com.bajaj.rideconnect.re.ui.theme.PulsarGreen
import com.bajaj.rideconnect.re.ui.theme.TextPrimary
import com.bajaj.rideconnect.re.ui.theme.TextSecondary

@Immutable
data class MediaTrackInfo(
    val title: String = "",
    val artist: String = "",
    val isPlaying: Boolean = false,
    val progress: Float = 0f,
    val currentPosition: String = "0:00",
    val totalDuration: String = "0:00"
)

@Composable
fun CockpitHud(
    onLaunchMaps: () -> Unit,
    modifier: Modifier = Modifier,
    bikeName: String = stringResource(R.string.no_bike_connected),
    mediaInfo: MediaTrackInfo = MediaTrackInfo(),
    onExpandedChanged: (Boolean) -> Unit = {},
    onPlayPauseToggle: () -> Unit = {},
    onSkipNext: () -> Unit = {},
    onSkipPrevious: () -> Unit = {}
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
                    mediaInfo = mediaInfo,
                    onCollapse = { isManuallyCollapsed = true },
                    onLaunchMaps = onLaunchMaps,
                    onPlayPauseToggle = onPlayPauseToggle,
                    onSkipNext = onSkipNext,
                    onSkipPrevious = onSkipPrevious,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                RiderEdgeTab(
                    isLandscape = isLandscape,
                    bikeName = bikeName,
                    onClick = { if (isLandscape) isManuallyCollapsed = false })
            }
        }
    }
}

@Composable
private fun RiderDock(
    bikeName: String,
    mediaInfo: MediaTrackInfo,
    onCollapse: () -> Unit,
    onLaunchMaps: () -> Unit,
    onPlayPauseToggle: () -> Unit,
    onSkipNext: () -> Unit,
    onSkipPrevious: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
        colors = CardDefaults.cardColors(containerColor = CockpitSurface),
        border = BorderStroke(1.dp, CockpitBorder)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(start = 12.dp, end = 12.dp, top = 6.dp, bottom = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        PulsingDot(color = PulsarGreen)
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
                                text = stringResource(R.string.status_standby),
                                style = MaterialTheme.typography.labelSmall,
                                fontFamily = FontFamily.Monospace,
                                color = TextSecondary,
                                fontSize = 9.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(6.dp))

                    HudCircleButton(
                        icon = "◀",
                        onClick = onCollapse,
                        size = 28.dp,
                        containerColor = CockpitBlack,
                        contentColor = TextSecondary,
                        fontSize = 11.sp
                    )
                }

                MediaControlCard(
                    mediaInfo = mediaInfo,
                    onPlayPauseToggle = onPlayPauseToggle,
                    onSkipNext = onSkipNext,
                    onSkipPrevious = onSkipPrevious
                )

                RiderStatusDeck()
            }

            Button(
                onClick = onLaunchMaps,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PulsarCyan, contentColor = CockpitBlack
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                Text(
                    text = stringResource(R.string.action_open_maps),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
private fun RiderStatusDeck(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = CockpitBlack),
        border = BorderStroke(1.dp, CockpitBorder)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 9.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "COCKPIT LINK",
                    style = MaterialTheme.typography.labelSmall,
                    fontFamily = FontFamily.Monospace,
                    color = TextSecondary,
                    fontSize = 9.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    PulsingDot(color = PulsarGreen)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "BLE READY",
                        style = MaterialTheme.typography.labelSmall,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        color = PulsarCyan,
                        fontSize = 11.sp
                    )
                }
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "HUD MODE",
                    style = MaterialTheme.typography.labelSmall,
                    fontFamily = FontFamily.Monospace,
                    color = TextSecondary,
                    fontSize = 9.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "NAV DOCK",
                    style = MaterialTheme.typography.labelSmall,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    fontSize = 11.sp
                )
            }
        }
    }
}

@Composable
private fun MediaControlCard(
    mediaInfo: MediaTrackInfo,
    onPlayPauseToggle: () -> Unit,
    onSkipNext: () -> Unit,
    onSkipPrevious: () -> Unit,
    modifier: Modifier = Modifier
) {
    val displayTitle = mediaInfo.title.ifEmpty { stringResource(R.string.media_no_track) }
    val displayArtist = mediaInfo.artist.ifEmpty { stringResource(R.string.media_open_player) }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = CockpitBlack),
        border = BorderStroke(1.dp, CockpitBorder)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = CockpitSurface,
                    border = BorderStroke(1.dp, PulsarCyan.copy(alpha = 0.3f)),
                    modifier = Modifier.size(42.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = "🎵", fontSize = 18.sp)
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

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

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(CockpitBorder)
            ) {
                if (mediaInfo.progress > 0f) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(mediaInfo.progress.coerceIn(0.001f, 1f))
                            .fillMaxHeight()
                            .background(PulsarCyan)
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
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

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HudCircleButton(
                    icon = "⏮", onClick = onSkipPrevious
                )

                HudCircleButton(
                    icon = if (mediaInfo.isPlaying) "⏸" else "▶",
                    onClick = onPlayPauseToggle,
                    size = 38.dp,
                    containerColor = PulsarCyan,
                    contentColor = CockpitBlack,
                    borderColor = PulsarCyan,
                    fontSize = 14.sp
                )

                HudCircleButton(
                    icon = "⏭", onClick = onSkipNext
                )
            }
        }
    }
}

@Composable
private fun HudCircleButton(
    icon: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 32.dp,
    containerColor: Color = CockpitSurface,
    contentColor: Color = TextPrimary,
    borderColor: Color = CockpitBorder,
    fontSize: TextUnit = 12.sp
) {
    Surface(
        onClick = onClick,
        shape = CircleShape,
        color = containerColor,
        border = BorderStroke(1.dp, borderColor),
        modifier = modifier.size(size)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = icon, color = contentColor, fontSize = fontSize, fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun RiderEdgeTab(
    isLandscape: Boolean, bikeName: String, onClick: () -> Unit, modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
        color = CockpitSurface.copy(alpha = 0.95f),
        border = BorderStroke(1.dp, PulsarCyan.copy(alpha = 0.5f)),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(start = 10.dp, end = 12.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PulsingDot(color = PulsarGreen)
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = bikeName,
                style = MaterialTheme.typography.labelSmall,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = PulsarCyan,
                maxLines = 1
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = if (isLandscape) "▶" else "↻",
                style = MaterialTheme.typography.labelSmall,
                fontFamily = FontFamily.Monospace,
                color = TextSecondary,
                fontSize = 11.sp
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
            onLaunchMaps = {},
            bikeName = stringResource(R.string.bike_name),
            mediaInfo = MediaTrackInfo(
                title = "Blinding Lights",
                artist = "The Weeknd",
                isPlaying = true,
                progress = 0.45f,
                currentPosition = "1:38",
                totalDuration = "3:20"
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
            onLaunchMaps = {}, bikeName = stringResource(R.string.bike_name)
        )
    }
}