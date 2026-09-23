package com.google.android.libraries.geo.mapcore.internal.model;

import androidx.core.view.InputDeviceCompat;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bk {
    public int a;
    private byte b;
    private int c;

    public bk() {
        this(0L);
    }

    public bk(long j) {
        this.a = (int) ((-256) & j);
        this.b = (byte) (255 & j);
        this.c = (int) (j >> 32);
    }

    public final long a() {
        return ((long) ((this.a & InputDeviceCompat.SOURCE_ANY) | (this.b & 255))) | (((long) this.c) << 32);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof bk) && a() == ((bk) obj).a();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(a())});
    }
}
