package com.mappls.sdk.navigation.helpers;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.mappls.sdk.navigation.NavigationFormatter;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.gpx.GPXUtilities;
import java.text.MessageFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    static {
        Locale locale = Locale.US;
        new MessageFormat("{0, number,#.##} GB", locale);
        new MessageFormat("{0, number,##.#} MB", locale);
    }

    public static String a(String str, String str2) {
        return "<font color=\"" + str + "\">" + str2 + "</font>";
    }

    public static void a(Context context, GPXUtilities.GPXTrackAnalysis gPXTrackAnalysis) {
        String strA = com.mappls.sdk.navigation.util.a.a(ContextCompat.getColor(context, R.color.mappls_gpx_time_span_color));
        String strA2 = com.mappls.sdk.navigation.util.a.a(ContextCompat.getColor(context, R.color.mappls_gpx_distance_color));
        String strA3 = com.mappls.sdk.navigation.util.a.a(ContextCompat.getColor(context, R.color.mappls_gpx_speed));
        String strA4 = com.mappls.sdk.navigation.util.a.a(ContextCompat.getColor(context, R.color.mappls_gpx_altitude_asc));
        String strA5 = com.mappls.sdk.navigation.util.a.a(ContextCompat.getColor(context, R.color.mappls_gpx_altitude_desc));
        context.getString(R.string.mappls_gpx_info_distance, a(strA2, NavigationFormatter.getFormattedDistance(gPXTrackAnalysis.totalDistance, context)), a(strA2, gPXTrackAnalysis.points + ""));
        if (gPXTrackAnalysis.totalTracks > 1) {
            context.getString(R.string.mappls_gpx_info_subtracks, a(strA3, gPXTrackAnalysis.totalTracks + ""));
        }
        if (gPXTrackAnalysis.wptPoints > 0) {
            context.getString(R.string.mappls_gpx_info_waypoints, a(strA3, gPXTrackAnalysis.wptPoints + ""));
        }
        if (gPXTrackAnalysis.isTimeSpecified()) {
            context.getString(R.string.mappls_gpx_info_start_time, Long.valueOf(gPXTrackAnalysis.startTime));
            context.getString(R.string.mappls_gpx_info_end_time, Long.valueOf(gPXTrackAnalysis.endTime));
        }
        long j = gPXTrackAnalysis.timeSpan;
        if (j > 0) {
            long j2 = j / 1000;
            if (j2 != gPXTrackAnalysis.timeMoving / 1000) {
                context.getString(R.string.mappls_gpx_timespan, a(strA, com.mappls.sdk.navigation.util.a.a((int) j2, true)));
            }
        }
        if (gPXTrackAnalysis.isTimeMoving()) {
            context.getString(R.string.mappls_gpx_timemoving, a(strA, com.mappls.sdk.navigation.util.a.a((int) (gPXTrackAnalysis.timeMoving / 1000), true)));
            a(strA2, NavigationFormatter.getFormattedDistance(gPXTrackAnalysis.totalDistanceMoving, context));
        }
        if (gPXTrackAnalysis.isElevationSpecified()) {
            context.getString(R.string.mappls_gpx_info_avg_altitude, a(strA3, NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.avgElevation, context)));
            String strA6 = a(strA5, NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.minElevation, context));
            String strA7 = a(strA4, NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.maxElevation, context));
            String strA8 = a(strA4, NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.diffElevationUp, context));
            String strA9 = a(strA5, NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.diffElevationDown, context));
            context.getString(R.string.mappls_gpx_info_diff_altitude, strA6 + " - " + strA7);
            context.getString(R.string.mappls_gpx_info_asc_altitude, "↓ " + strA9 + "   ↑ " + strA8 + "");
        }
        if (gPXTrackAnalysis.isSpeedSpecified()) {
            String strA10 = a(strA3, NavigationFormatter.getFormattedSpeed(gPXTrackAnalysis.avgSpeed, context));
            String strA11 = a(strA4, NavigationFormatter.getFormattedSpeed(gPXTrackAnalysis.maxSpeed, context));
            context.getString(R.string.mappls_gpx_info_average_speed, strA10);
            context.getString(R.string.mappls_gpx_info_maximum_speed, strA11);
        }
    }

    public static String b(String str, String str2) {
        return a(str, str2);
    }
}
