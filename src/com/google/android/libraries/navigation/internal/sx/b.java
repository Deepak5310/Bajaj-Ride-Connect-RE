package com.google.android.libraries.navigation.internal.sx;

import com.google.android.libraries.navigation.internal.afl.gv;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.lt;
import com.google.android.libraries.navigation.internal.afl.mj;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.EnumMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends ao {
    public bg a;
    public com.google.android.libraries.navigation.internal.ael.x b;
    public com.google.android.libraries.navigation.internal.db.r c;
    public lt d;
    public lr e;
    public ev f;
    public ev g;
    public Double h;
    public com.google.android.libraries.navigation.internal.ady.n i;
    public mj j;
    public com.google.android.libraries.navigation.internal.adu.s k;
    public com.google.android.libraries.navigation.internal.ael.x l;
    public EnumMap m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f584n;
    public Long o;
    public gv p;
    private boolean q;
    private boolean r;
    private byte s;

    @Override // com.google.android.libraries.navigation.internal.sx.ao
    public final ap a() {
        if (this.s == 3) {
            return new c(this.a, this.b, this.c, this.q, this.d, this.e, this.f, this.g, this.h, this.i, this.j, null, this.r, this.l, this.m, this.f584n, this.o, this.p);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ao
    public final void b(boolean z) {
        this.r = z;
        this.s = (byte) (this.s | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.sx.ao
    public final void c(boolean z) {
        this.q = z;
        this.s = (byte) (this.s | 1);
    }
}
