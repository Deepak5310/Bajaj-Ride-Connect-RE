package com.google.android.libraries.navigation.internal.ly;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.react.uimanager.ViewProps;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cq {
    private cq() {
    }

    public static Bundle a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(cq.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(cq.class.getClassLoader());
        return bundle2;
    }

    public static Bundle b(Bundle bundle) {
        bundle.setClassLoader(cq.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(cq.class.getClassLoader());
        return bundle2;
    }

    public static Parcelable c(Bundle bundle, String str) {
        Bundle bundleA = a(bundle);
        if (bundleA == null) {
            return null;
        }
        return bundleA.getParcelable(str);
    }

    public static void d(Bundle bundle, Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return;
        }
        Bundle bundleA = a(bundle);
        if (bundleA != null) {
            Bundle bundleB = b(bundle2);
            Parcelable parcelable = bundleA.getParcelable("MapOptions");
            if (parcelable != null) {
                bundleB.putParcelable("MapOptions", parcelable);
            }
            Parcelable parcelable2 = bundleA.getParcelable("StreetViewPanoramaOptions");
            if (parcelable2 != null) {
                bundleB.putParcelable("StreetViewPanoramaOptions", parcelable2);
            }
            Parcelable parcelable3 = bundleA.getParcelable("camera");
            if (parcelable3 != null) {
                bundleB.putParcelable("camera", parcelable3);
            }
            if (bundleA.containsKey("indoor_state")) {
                bundleB.putBundle("indoor_state", bundleA.getBundle("indoor_state"));
            }
            if (bundleA.containsKey("lat_lng_bounds")) {
                bundleB.putParcelable("lat_lng_bounds", bundleA.getParcelable("lat_lng_bounds"));
            }
            if (bundleA.containsKey("paddings")) {
                bundleB.putIntegerArrayList("paddings", bundleA.getIntegerArrayList("paddings"));
            }
            if (bundleA.containsKey("compass_enabled")) {
                bundleB.putBoolean("compass_enabled", bundleA.getBoolean("compass_enabled"));
            }
            if (bundleA.containsKey("min_zoom_preference")) {
                bundleB.putFloat("min_zoom_preference", bundleA.getFloat("min_zoom_preference"));
            }
            if (bundleA.containsKey("max_zoom_preference")) {
                bundleB.putFloat("max_zoom_preference", bundleA.getFloat("max_zoom_preference"));
            }
            e(bundle2, bundleB);
        }
        if (bundle.containsKey(ViewProps.POSITION)) {
            bundle2.putString(ViewProps.POSITION, bundle.getString(ViewProps.POSITION));
        }
        if (bundle.containsKey("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT")) {
            bundle2.putBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", bundle.getBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", false));
        }
    }

    public static void e(Bundle bundle, Bundle bundle2) {
        bundle.putBundle("map_state", bundle2);
    }

    public static void f(Bundle bundle, String str, Parcelable parcelable) {
        Bundle bundleB = b(bundle);
        bundleB.putParcelable(str, parcelable);
        e(bundle, bundleB);
    }
}
