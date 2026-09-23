package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class x {
    private static x a;

    public static x b() {
        if (a == null) {
            a = new s(com.google.android.gms.maps.al.f46n);
        }
        return a;
    }

    public abstract Bitmap a(be beVar);
}
