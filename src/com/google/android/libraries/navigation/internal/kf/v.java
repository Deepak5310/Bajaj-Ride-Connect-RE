package com.google.android.libraries.navigation.internal.kf;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v {
    public final SharedPreferences a;
    public final com.google.android.libraries.navigation.internal.gv.d b;
    public final f c;
    public String g;
    public final AtomicInteger d = new AtomicInteger();
    public final AtomicInteger e = new AtomicInteger();
    public final List f = new ArrayList();
    public String h = "";

    public v(SharedPreferences sharedPreferences, com.google.android.libraries.navigation.internal.gv.d dVar, f fVar) {
        this.a = sharedPreferences;
        this.b = dVar;
        this.c = fVar;
    }

    static String a() {
        Random random = new Random();
        long jCurrentTimeMillis = System.currentTimeMillis() * 1000;
        com.google.android.libraries.navigation.internal.zt.e eVar = (com.google.android.libraries.navigation.internal.zt.e) com.google.android.libraries.navigation.internal.zt.f.a.q();
        if (!eVar.b.H()) {
            eVar.v();
        }
        com.google.android.libraries.navigation.internal.zt.f fVar = (com.google.android.libraries.navigation.internal.zt.f) eVar.b;
        fVar.b |= 1;
        fVar.c = jCurrentTimeMillis;
        int iNextInt = random.nextInt(16777216) - 536870912;
        if (!eVar.b.H()) {
            eVar.v();
        }
        com.google.android.libraries.navigation.internal.zt.f fVar2 = (com.google.android.libraries.navigation.internal.zt.f) eVar.b;
        fVar2.b |= 2;
        fVar2.d = iNextInt;
        int iNextInt2 = random.nextInt();
        if (!eVar.b.H()) {
            eVar.v();
        }
        com.google.android.libraries.navigation.internal.zt.f fVar3 = (com.google.android.libraries.navigation.internal.zt.f) eVar.b;
        fVar3.b |= 4;
        fVar3.e = iNextInt2;
        return com.google.android.libraries.navigation.internal.kb.a.d((com.google.android.libraries.navigation.internal.zt.f) eVar.t());
    }

    public final synchronized void b() {
        this.a.edit().putInt("sequenceId", this.e.get()).putInt("activationId", this.d.get()).putString("previousClientEventId", this.g).putString("baseEventId", this.h).apply();
    }
}
