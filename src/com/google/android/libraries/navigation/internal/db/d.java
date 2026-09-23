package com.google.android.libraries.navigation.internal.db;

import android.location.Location;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static com.google.android.libraries.navigation.internal.pt.d a(Location location) {
        Float fB;
        Bundle extras;
        String string;
        int i;
        com.google.android.libraries.navigation.internal.oe.i iVarA;
        if (location == null) {
            return null;
        }
        if (((!Objects.equals(location.getProvider(), "fused") && !Objects.equals(location.getProvider(), "network")) || ((fB = b(location)) != null && fB.floatValue() >= 0.7f)) && (extras = location.getExtras()) != null) {
            synchronized (extras) {
                try {
                    string = extras.getString("levelId");
                    i = extras.getInt("levelNumberE3", Integer.MIN_VALUE);
                } catch (IllegalArgumentException unused) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(169)).p("Android Bundle failure.");
                }
            }
            if (string != null && (iVarA = com.google.android.libraries.navigation.internal.oe.i.a(string)) != null) {
                return new com.google.android.libraries.navigation.internal.pt.d(iVarA, i);
            }
        }
        return null;
    }

    public static Float b(Location location) {
        Bundle extras;
        if (location == null || location.getExtras() == null || (extras = location.getExtras()) == null || !extras.containsKey("indoorProbability")) {
            return null;
        }
        return Float.valueOf(extras.getFloat("indoorProbability"));
    }
}
