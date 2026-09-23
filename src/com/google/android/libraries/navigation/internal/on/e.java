package com.google.android.libraries.navigation.internal.on;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    static int a(int i, float f) {
        float f2 = f * (((i >> 24) & 255) / 255.0f);
        return (((int) (f2 * ((i >> 16) & 255))) << 24) + (((int) (((i >> 8) & 255) * f2)) << 16) + (((int) ((i & 255) * f2)) << 8) + ((int) (255.0f * f2));
    }
}
