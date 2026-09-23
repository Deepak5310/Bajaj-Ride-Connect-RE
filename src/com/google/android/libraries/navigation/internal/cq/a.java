package com.google.android.libraries.navigation.internal.cq;

import com.google.android.libraries.navigation.internal.aaq.an;
import com.google.android.libraries.navigation.internal.adg.ex;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends p {
    public an a;
    public ex b;
    public ex c;
    public ex d;
    public ex e;
    public w f;
    public Integer g;
    public String h;
    public int i;
    private int j;
    private int k;
    private String l;
    private k m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ex f378n;
    private com.google.android.libraries.navigation.internal.qk.t o;
    private Function1 p;
    private String q;
    private String r;
    private com.google.android.libraries.navigation.internal.ado.j s;
    private com.google.android.libraries.navigation.internal.afd.a t;

    @Override // com.google.android.libraries.navigation.internal.cq.p
    public final p a(Function1 function1) {
        Objects.requireNonNull(function1);
        this.p = function1;
        this.i |= 4096;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.p
    public final aa b() {
        int i = ~this.i;
        if ((i & 2319) != 0) {
            throw new IllegalStateException();
        }
        int i2 = this.j;
        int i3 = this.k;
        String str = this.l;
        k kVar = this.m;
        an anVar = this.a;
        ex exVar = this.b;
        ex exVar2 = this.c;
        ex exVar3 = this.d;
        ex exVar4 = this.f378n;
        ex exVar5 = this.e;
        w wVar = this.f;
        com.google.android.libraries.navigation.internal.qk.t tVar = this.o;
        Function1 function1 = this.p;
        Integer num = this.g;
        ex exVar6 = exVar;
        String str2 = this.q;
        String str3 = this.r;
        com.google.android.libraries.navigation.internal.afd.a aVar = this.t;
        String str4 = this.h;
        com.google.android.libraries.navigation.internal.ado.j jVar = this.s;
        if ((i & 32) != 0) {
            exVar6 = ex.LEGEND_STYLE_ROUTE_DECORATION_CALLOUT_LAYOUT;
        }
        if ((i & 64) != 0) {
            exVar2 = ex.LEGEND_STYLE_ROUTE_DECORATION_CALLOUT_EXTRA_PADDING_LAYOUT;
        }
        ex exVar7 = exVar2;
        ex exVar8 = (i & 128) != 0 ? ex.LEGEND_STYLE_ROUTE_DECORATION_CALLOUT_EXTRA_PADDING_LAYOUT_RTL : exVar3;
        ex exVar9 = (i & 512) != 0 ? ex.LEGEND_STYLE_ROUTE_DECORATION_CALLOUT_TITLE : exVar5;
        w wVar2 = (i & 1024) != 0 ? null : wVar;
        Function1 function2 = (i & 4096) != 0 ? n.a : function1;
        Integer num2 = (i & 8192) != 0 ? null : num;
        String str5 = (i & 16384) != 0 ? null : str2;
        String str6 = (32768 & i) != 0 ? null : str3;
        com.google.android.libraries.navigation.internal.afd.a aVar2 = (65536 & i) != 0 ? null : aVar;
        String str7 = (131072 & i) != 0 ? null : str4;
        if ((i & 262144) != 0) {
            jVar = null;
        }
        return new aa(i2, i3, str, kVar, anVar, exVar6, exVar7, exVar8, exVar4, exVar9, wVar2, tVar, function2, num2, str5, str6, aVar2, str7, jVar);
    }

    @Override // com.google.android.libraries.navigation.internal.cq.p
    public final void c(String str) {
        this.r = str;
        this.i |= 32768;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.p
    public final void d(k kVar) {
        Objects.requireNonNull(kVar);
        this.m = kVar;
        this.i |= 8;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.p
    public final void e(String str) {
        Objects.requireNonNull(str);
        this.l = str;
        this.i |= 4;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.p
    public final void f(ex exVar) {
        Objects.requireNonNull(exVar);
        this.f378n = exVar;
        this.i |= 256;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.p
    public final void g(int i) {
        this.k = i;
        this.i |= 2;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.p
    public final void h(com.google.android.libraries.navigation.internal.ado.j jVar) {
        this.s = jVar;
        this.i |= 262144;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.p
    public final void i(int i) {
        this.j = i;
        this.i |= 1;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.p
    public final void j(String str) {
        this.q = str;
        this.i |= 16384;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.p
    public final void k(com.google.android.libraries.navigation.internal.qk.t tVar) {
        Objects.requireNonNull(tVar);
        this.o = tVar;
        this.i |= 2048;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.p
    public final void l(com.google.android.libraries.navigation.internal.afd.a aVar) {
        this.t = aVar;
        this.i |= 65536;
    }
}
