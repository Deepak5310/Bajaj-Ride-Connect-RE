package com.google.android.libraries.navigation.internal.ky;

import android.content.Context;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class e {
    public static volatile int a = -1;
    public static final com.google.android.libraries.navigation.internal.ma.l[] b = new com.google.android.libraries.navigation.internal.ma.l[0];
    public static final String[] c = new String[0];

    @Deprecated
    public static final com.google.android.libraries.navigation.internal.ld.k d;
    private static final com.google.android.libraries.navigation.internal.ld.j o;
    private static final com.google.android.libraries.navigation.internal.ld.a p;
    public final ar e;
    public final Context f;
    protected final p g;
    protected final String h;
    public final String i;
    public final aw j;
    public final r k;
    protected final com.google.android.libraries.navigation.internal.ll.d l;
    protected final a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f477n;

    static {
        com.google.android.libraries.navigation.internal.ld.j jVar = new com.google.android.libraries.navigation.internal.ld.j();
        o = jVar;
        b bVar = new b();
        p = bVar;
        d = new com.google.android.libraries.navigation.internal.ld.k("ClearcutLogger.API", bVar, jVar);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.android.libraries.navigation.internal.ky.a] */
    protected e(Context context, String str, aw awVar, p pVar, br brVar, r rVar) {
        if (!awVar.a(ax.ACCOUNT_NAME)) {
            be.b(true, "Upload account name cannot be used with a deidentified or pseudonymous logger.");
        }
        b(awVar);
        this.f = context.getApplicationContext();
        this.i = context.getPackageName();
        this.h = str;
        this.j = awVar;
        this.f477n = com.google.android.libraries.navigation.internal.afk.c.a;
        this.g = pVar == null ? new com.google.android.libraries.navigation.internal.la.i(context, brVar) : pVar;
        this.l = com.google.android.libraries.navigation.internal.ll.d.a;
        this.e = new com.google.android.libraries.navigation.internal.la.v(context);
        this.k = rVar;
        this.m = new Object() { // from class: com.google.android.libraries.navigation.internal.ky.a
        };
    }

    static final String a(Iterable iterable) {
        return new com.google.android.libraries.navigation.internal.yx.ah(", ").f(iterable);
    }

    static final void b(aw awVar) {
        if (!awVar.equals(aw.c) && !awVar.equals(aw.a) && !awVar.equals(aw.b)) {
            throw new IllegalArgumentException("piiLevelSet must be one of ZWIEBACK_ONLY, NO_RESTRICTIONS, or DEIDENTIFIED");
        }
    }

    public static final int[] d(ArrayList arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            iArr[i2] = ((Integer) arrayList.get(i)).intValue();
            i++;
            i2++;
        }
        return iArr;
    }

    public final boolean c() {
        return this.j.equals(aw.b);
    }
}
