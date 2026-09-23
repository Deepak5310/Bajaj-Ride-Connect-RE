package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import j$.time.Instant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah {
    public af a;
    public Map b;
    public com.google.android.libraries.navigation.internal.ady.al c;
    public ev d;
    public ev e;
    public com.google.android.libraries.navigation.internal.hc.a f;
    public com.google.android.libraries.navigation.internal.hc.a g;
    public Instant h;
    public com.google.android.libraries.navigation.internal.hc.a i;
    public Instant j;
    public int k;
    public boolean l;

    public ah() {
        this.b = new HashMap();
        int i = ev.d;
        this.d = lv.a;
        this.e = lv.a;
        this.h = Instant.EPOCH;
        this.j = Instant.EPOCH;
        this.l = false;
    }

    public final void a(com.google.android.libraries.navigation.internal.afl.bz bzVar) {
        this.g = new com.google.android.libraries.navigation.internal.hc.a(bzVar);
    }

    public final void b(lz lzVar) {
        this.i = com.google.android.libraries.navigation.internal.hc.a.a(lzVar);
    }

    public final void c(lr lrVar) {
        this.f = new com.google.android.libraries.navigation.internal.hc.a(lrVar);
    }

    public final void d(ev evVar) {
        cn.a(evVar.size());
        this.d = evVar;
    }

    public ah(ai aiVar) {
        this.b = new HashMap();
        int i = ev.d;
        this.d = lv.a;
        this.e = lv.a;
        this.h = Instant.EPOCH;
        this.j = Instant.EPOCH;
        this.l = false;
        this.a = aiVar.b;
        this.b = aiVar.c;
        this.c = aiVar.d;
        this.d = aiVar.e;
        this.e = aiVar.f;
        this.f = aiVar.g;
        this.g = aiVar.h;
        this.h = aiVar.i;
        this.i = aiVar.j;
        this.j = aiVar.k;
        this.k = aiVar.l;
        this.l = aiVar.m;
    }
}
