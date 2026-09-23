package com.google.android.libraries.navigation.internal.ee;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;
    public static final String i;
    public static final p j;
    public static final p k;

    static {
        String string = Integer.toString(com.google.android.libraries.navigation.internal.adu.m.NAVIGATION_STATUS.eU);
        a = string;
        String strD = l.d(com.google.android.libraries.navigation.internal.adu.m.NAVIGATION_STATUS, "_foreground");
        b = strD;
        String strConcat = String.valueOf(string).concat("_2");
        c = strConcat;
        String strConcat2 = String.valueOf(strD).concat("_1");
        d = strConcat2;
        e = Integer.toString(com.google.android.libraries.navigation.internal.adu.m.REVIEW_AT_A_PLACE.eU);
        f = Integer.toString(com.google.android.libraries.navigation.internal.adu.m.PHOTO_TAKEN.eU);
        g = Integer.toString(com.google.android.libraries.navigation.internal.adu.m.POST_CONTRIBUTION_IMPACT.eU);
        h = l.d(com.google.android.libraries.navigation.internal.adu.m.ADD_YOUR_PICKUP_ORDER, ":3");
        i = l.d(com.google.android.libraries.navigation.internal.adu.m.OFF_ROUTE, ":4");
        n nVarH = p.h(3);
        nVarH.b(strConcat2);
        nVarH.d(com.google.android.libraries.navigation.internal.em.a.G);
        nVarH.g(false);
        nVarH.f(false);
        j = nVarH.a();
        n nVarH2 = p.h(4);
        nVarH2.b(strConcat);
        nVarH2.d(com.google.android.libraries.navigation.internal.em.a.H);
        nVarH2.g(false);
        nVarH2.f(false);
        k = nVarH2.a();
    }
}
