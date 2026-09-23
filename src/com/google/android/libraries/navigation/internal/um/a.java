package com.google.android.libraries.navigation.internal.um;

import android.content.res.Resources;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import com.google.android.libraries.navigation.internal.gw.w;
import com.google.android.libraries.navigation.internal.gw.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    final /* synthetic */ Resources a;
    final /* synthetic */ Picture b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ com.google.android.libraries.navigation.internal.o.d e;
    final /* synthetic */ int f;
    final /* synthetic */ d g;

    public a(d dVar, Resources resources, Picture picture, int i, int i2, com.google.android.libraries.navigation.internal.o.d dVar2, int i3) {
        this.a = resources;
        this.b = picture;
        this.c = i;
        this.d = i2;
        this.e = dVar2;
        this.f = i3;
        this.g = dVar;
    }

    public final int a() {
        return this.f;
    }

    public final Drawable b() {
        w wVarF = x.f();
        wVarF.b(true);
        com.google.android.libraries.navigation.internal.gw.d dVar = (com.google.android.libraries.navigation.internal.gw.d) wVarF;
        dVar.a = Integer.valueOf(this.c);
        dVar.b = Integer.valueOf(this.d);
        dVar.c = this.e;
        return this.g.b.b(this.a, this.b, wVarF.c());
    }
}
