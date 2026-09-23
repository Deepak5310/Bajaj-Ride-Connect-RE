package com.mappls.sdk.navigation.ui.utils;

import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.facebook.imageutils.JfifUtil;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.plugin.directions.DistanceType;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    public static int a(float f) {
        if (f <= 45.0f) {
            return 45;
        }
        if (f <= 90.0f) {
            return 90;
        }
        if (f <= 135.0f) {
            return NikonType2MakernoteDirectory.TAG_FLASH_USED;
        }
        if (f <= 180.0f) {
            return 180;
        }
        if (f <= 225.0f) {
            return JfifUtil.MARKER_APP1;
        }
        return f <= 270.0f ? 270 : 315;
    }

    public static DistanceType a() {
        return MapplsNavigationHelper.getInstance().isCurrentMetricSystemKm() ? DistanceType.METRIC : DistanceType.IMPERIAL;
    }
}
