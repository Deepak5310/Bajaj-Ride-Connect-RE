package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.common.base.Ascii;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class co implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.aac.ca a;
    final /* synthetic */ Map b;
    final /* synthetic */ com.google.android.libraries.navigation.internal.ol.aq c;
    final /* synthetic */ Map d;
    final /* synthetic */ com.google.android.libraries.navigation.internal.ol.aq e;
    final /* synthetic */ Map f;
    final /* synthetic */ com.google.android.libraries.navigation.internal.ol.aq g;
    final /* synthetic */ Map h;
    final /* synthetic */ com.google.android.libraries.navigation.internal.ol.aq i;

    public co(com.google.android.libraries.navigation.internal.aac.ca caVar, Map map, com.google.android.libraries.navigation.internal.ol.aq aqVar, Map map2, com.google.android.libraries.navigation.internal.ol.aq aqVar2, Map map3, com.google.android.libraries.navigation.internal.ol.aq aqVar3, Map map4, com.google.android.libraries.navigation.internal.ol.aq aqVar4) {
        this.a = caVar;
        this.b = map;
        this.c = aqVar;
        this.d = map2;
        this.e = aqVar2;
        this.f = map3;
        this.g = aqVar3;
        this.h = map4;
        this.i = aqVar4;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        ex exVar = cp.a;
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(Ascii.MAX)).p("A problem occurred while waiting for the MapStyles to become ready:");
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        this.a.d(new cp(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i));
    }
}
