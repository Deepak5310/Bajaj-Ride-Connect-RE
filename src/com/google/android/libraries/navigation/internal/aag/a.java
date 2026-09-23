package com.google.android.libraries.navigation.internal.aag;

import android.content.Context;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends h {
    public Context a;
    public String b;
    public boolean c;
    public String d;
    public j e;
    public byte f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;

    @Override // com.google.android.libraries.navigation.internal.aag.h
    public final i a() {
        if (this.f == -1) {
            return new b(this.a, this.b, this.c, this.g, this.h, this.i, this.d, this.e, this.j);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f & 1) == 0) {
            sb.append(" enableQuic");
        }
        if ((this.f & 2) == 0) {
            sb.append(" enableBrotli");
        }
        if ((this.f & 4) == 0) {
            sb.append(" enableCertificateCache");
        }
        if ((this.f & 8) == 0) {
            sb.append(" enableHttpCache");
        }
        if ((this.f & Ascii.DLE) == 0) {
            sb.append(" enableNetworkQualityEstimator");
        }
        if ((this.f & 32) == 0) {
            sb.append(" diskCacheSizeBytes");
        }
        if ((this.f & SignedBytes.MAX_POWER_OF_TWO) == 0) {
            sb.append(" inMemoryFallbackCacheSizeBytes");
        }
        if ((this.f & 128) == 0) {
            sb.append(" threadPriority");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.navigation.internal.aag.h
    public final void b(int i) {
        this.i = i;
        this.f = (byte) (this.f | 32);
    }

    @Override // com.google.android.libraries.navigation.internal.aag.h
    public final void c(boolean z) {
        this.g = z;
        this.f = (byte) (this.f | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.aag.h
    public final void d(boolean z) {
        this.h = z;
        this.f = (byte) (this.f | Ascii.DLE);
    }

    @Override // com.google.android.libraries.navigation.internal.aag.h
    public final void e(int i) {
        this.j = i;
        this.f = (byte) (this.f | (-128));
    }
}
