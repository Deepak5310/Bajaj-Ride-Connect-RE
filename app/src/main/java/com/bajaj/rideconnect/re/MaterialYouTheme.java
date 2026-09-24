package com.bajaj.rideconnect.re;

import android.app.WallpaperColors;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/**
 * Material You (Material 3 Monet / Dynamic Wallpaper) Theming Engine.
 * Extracts dynamic accent colors from the Android system / current wallpaper
 * and crafts a high-contrast, pure AMOLED Deep Black (#000000) palette.
 *
 * Supports live dynamic re-theming via WallpaperManager.OnColorsChangedListener.
 */
public class MaterialYouTheme {

    private static final String TAG = "MaterialYouTheme";
    private static final int DEFAULT_FALLBACK_ACCENT = 0xFF38BDF8; // Electric Cyan

    public static class Palette {
        public final int accentPrimary;
        public final int accentSecondary;
        public final int accentContainer;
        public final int onAccentContainer;
        public final int accentGlow;
        public final int accentBorder;
        public final int surfaceDeepBlack;
        public final int surfaceCard;
        public final int surfaceCardBorder;
        public final int surfaceElevated;
        public final int textPrimary;
        public final int textSecondary;
        public final int textMuted;
        public final String accentHex;
        public final String accentRgb;

        public Palette(int primary, int secondary) {
            this.accentPrimary = primary;
            this.accentSecondary = secondary;

            int r = Color.red(primary);
            int g = Color.green(primary);
            int b = Color.blue(primary);

            this.accentContainer = Color.argb(45, r, g, b);    // ~18% alpha
            this.onAccentContainer = primary;
            this.accentGlow = Color.argb(90, r, g, b);         // ~35% alpha
            this.accentBorder = Color.argb(65, r, g, b);       // ~25% alpha
            this.surfaceDeepBlack = 0xFF000000;                // Pure AMOLED Black
            this.surfaceCard = 0xFF07080B;                     // Pitch Stealth Surface
            this.surfaceCardBorder = Color.argb(55, r, g, b);  // Subtle Dynamic Accent Edge
            this.surfaceElevated = 0xFF0D0E14;
            this.textPrimary = 0xFFF8FAFC;
            this.textSecondary = 0xFF94A3B8;
            this.textMuted = 0xFF64748B;
            this.accentHex = String.format("#%06X", (0xFFFFFF & primary));
            this.accentRgb = r + ", " + g + ", " + b;
        }

        @Override
        public String toString() {
            return "Palette{accent=" + accentHex + ", rgb=" + accentRgb + "}";
        }
    }

    public interface OnThemeChangeListener {
        void onThemeChanged(Palette palette);
    }

    private static Palette currentPalette = null;
    private static WallpaperManager.OnColorsChangedListener wallpaperColorsListener = null;

    /**
     * Extracts dynamic Material You palette tailored for AMOLED pure black background.
     */
    public static Palette getPalette(Context context) {
        if (currentPalette != null) {
            return currentPalette;
        }
        currentPalette = extractPalette(context);
        return currentPalette;
    }

    /**
     * Re-extracts palette and forces an update.
     */
    public static Palette refreshPalette(Context context) {
        currentPalette = extractPalette(context);
        return currentPalette;
    }

    private static Palette extractPalette(Context context) {
        int primaryAccent = 0;
        int secondaryAccent = 0;

        // 1. Android 12+ (API 31+) Monet system dynamic color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            try {
                // system_accent1_200 is the canonical dark theme primary accent in Material 3
                int resAccent200 = android.R.color.system_accent1_200;
                int monetColor = context.getColor(resAccent200);
                if (monetColor != 0) {
                    primaryAccent = monetColor;
                    try {
                        secondaryAccent = context.getColor(android.R.color.system_accent2_200);
                    } catch (Exception ignored) {}
                    Log.i(TAG, "Extracted Monet system_accent1_200: " + String.format("#%06X", (0xFFFFFF & primaryAccent)));
                }
            } catch (Throwable t) {
                Log.w(TAG, "Monet system accent lookup failed: " + t.getMessage());
            }
        }

        // 2. WallpaperManager.getWallpaperColors (API 27+)
        if (primaryAccent == 0 && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            try {
                WallpaperManager wm = WallpaperManager.getInstance(context);
                WallpaperColors colors = wm.getWallpaperColors(WallpaperManager.FLAG_SYSTEM);
                if (colors != null && colors.getPrimaryColor() != null) {
                    primaryAccent = colors.getPrimaryColor().toArgb();
                    if (colors.getSecondaryColor() != null) {
                        secondaryAccent = colors.getSecondaryColor().toArgb();
                    }
                    Log.i(TAG, "Extracted WallpaperColors primary: " + String.format("#%06X", (0xFFFFFF & primaryAccent)));
                }
            } catch (Throwable t) {
                Log.w(TAG, "WallpaperColors extraction failed: " + t.getMessage());
            }
        }

        // 3. Fallback: Sample dominant vibrant color from Wallpaper Drawable
        if (primaryAccent == 0) {
            try {
                WallpaperManager wm = WallpaperManager.getInstance(context);
                Drawable drawable = wm.getDrawable();
                if (drawable != null) {
                    primaryAccent = sampleDominantVibrantColor(drawable);
                    Log.i(TAG, "Sampled wallpaper bitmap color: " + String.format("#%06X", (0xFFFFFF & primaryAccent)));
                }
            } catch (Throwable t) {
                Log.w(TAG, "Wallpaper bitmap sampling failed: " + t.getMessage());
            }
        }

        // 4. Default signature Bajaj electric cyan fallback
        if (primaryAccent == 0) {
            primaryAccent = DEFAULT_FALLBACK_ACCENT;
            secondaryAccent = 0xFF06B6D4;
        }

        // Ensure high contrast and vibrant luminance for deep black AMOLED visibility
        primaryAccent = boostLuminanceForDeepBlack(primaryAccent);
        if (secondaryAccent != 0) {
            secondaryAccent = boostLuminanceForDeepBlack(secondaryAccent);
        } else {
            secondaryAccent = primaryAccent;
        }

        Palette palette = new Palette(primaryAccent, secondaryAccent);
        Log.i(TAG, "Active Material You AMOLED Palette: " + palette);
        return palette;
    }

    /**
     * Boosts color saturation and value/luminance so it remains vivid and legible
     * against pure AMOLED black (#000000).
     */
    private static int boostLuminanceForDeepBlack(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);

        // If purely achromatic (white/gray/black), convert to sleek crisp white-silver
        if (hsv[1] < 0.05f) {
            hsv[2] = 0.95f;
            return Color.HSVToColor(hsv);
        }

        // Boost saturation if too pastel or washed out
        if (hsv[1] < 0.45f) {
            hsv[1] = 0.65f;
        }

        // Boost brightness if too dim for dark cockpit mode
        if (hsv[2] < 0.80f) {
            hsv[2] = 0.92f;
        }

        return Color.HSVToColor(hsv);
    }

    /**
     * Fast downscaled bitmap sampler to find dominant vibrant hue.
     */
    private static int sampleDominantVibrantColor(Drawable drawable) {
        try {
            int w = 32;
            int h = 32;
            Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, w, h);
            drawable.draw(canvas);

            float maxVibrancy = -1f;
            int bestColor = 0;
            float[] hsv = new float[3];

            for (int x = 0; x < w; x += 4) {
                for (int y = 0; y < h; y += 4) {
                    int pixel = bitmap.getPixel(x, y);
                    Color.colorToHSV(pixel, hsv);
                    // Filter out extreme blacks, whites and dull grays
                    if (hsv[2] > 0.15f && hsv[2] < 0.95f && hsv[1] > 0.20f) {
                        float vibrancy = hsv[1] * hsv[2]; // Higher saturation + brightness
                        if (vibrancy > maxVibrancy) {
                            maxVibrancy = vibrancy;
                            bestColor = pixel;
                        }
                    }
                }
            }
            bitmap.recycle();
            return bestColor != 0 ? bestColor : DEFAULT_FALLBACK_ACCENT;
        } catch (Throwable t) {
            return DEFAULT_FALLBACK_ACCENT;
        }
    }

    /**
     * Registers a live listener to re-theme the cockpit when the system wallpaper changes.
     */
    public static void registerWallpaperListener(Context context, OnThemeChangeListener listener) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 && listener != null) {
            try {
                WallpaperManager wm = WallpaperManager.getInstance(context);
                if (wallpaperColorsListener != null) {
                    try {
                        wm.removeOnColorsChangedListener(wallpaperColorsListener);
                    } catch (Exception ignored) {}
                }
                wallpaperColorsListener = (colors, which) -> {
                    if ((which & WallpaperManager.FLAG_SYSTEM) != 0) {
                        new Handler(Looper.getMainLooper()).post(() -> {
                            Palette newPalette = refreshPalette(context);
                            listener.onThemeChanged(newPalette);
                        });
                    }
                };
                wm.addOnColorsChangedListener(wallpaperColorsListener, new Handler(Looper.getMainLooper()));
                Log.i(TAG, "WallpaperColors listener successfully registered.");
            } catch (Throwable t) {
                Log.w(TAG, "Unable to register WallpaperColors listener: " + t.getMessage());
            }
        }
    }

    /**
     * Unregisters the live wallpaper listener.
     */
    public static void unregisterWallpaperListener(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 && wallpaperColorsListener != null) {
            try {
                WallpaperManager wm = WallpaperManager.getInstance(context);
                wm.removeOnColorsChangedListener(wallpaperColorsListener);
                wallpaperColorsListener = null;
            } catch (Exception ignored) {}
        }
    }
}
