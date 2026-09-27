package com.bajaj.rideconnect.re.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val PulsarColorScheme = darkColorScheme(
    primary = PulsarCyan,
    onPrimary = CockpitBlack,
    primaryContainer = PulsarCyanDim,
    onPrimaryContainer = TextPrimary,
    secondary = PulsarGreen,
    onSecondary = CockpitBlack,
    tertiary = PulsarAmber,
    onTertiary = CockpitBlack,
    background = CockpitBlack,
    onBackground = TextPrimary,
    surface = CockpitSurface,
    onSurface = TextPrimary,
    surfaceVariant = CockpitBorder,
    onSurfaceVariant = TextSecondary,
    error = PulsarRed,
    onError = CockpitBlack
)

@Composable
fun MyPulsarTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = PulsarColorScheme, typography = Typography, content = content
    )
}