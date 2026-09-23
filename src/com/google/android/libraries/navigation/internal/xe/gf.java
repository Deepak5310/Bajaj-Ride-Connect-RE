package com.google.android.libraries.navigation.internal.xe;

import android.content.Context;
import com.google.android.libraries.geo.navcore.ui.header.views.MultiIconView;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gf {
    public static final com.google.android.libraries.navigation.internal.yz.fd a;
    public final com.google.android.libraries.navigation.internal.tn.m b;
    public final Context c;
    public final com.google.android.libraries.navigation.internal.um.d.a d;
    public final com.google.android.libraries.navigation.internal.um.d e;
    public MultiIconView f;

    static {
        com.google.android.libraries.navigation.internal.yz.ez ezVar = new com.google.android.libraries.navigation.internal.yz.ez();
        ezVar.f(com.google.android.libraries.navigation.internal.adr.en.NONE, 0);
        ezVar.f(com.google.android.libraries.navigation.internal.adr.en.LEFT, 1);
        ezVar.f(com.google.android.libraries.navigation.internal.adr.en.RIGHT, 2);
        a = ezVar.d();
    }

    public gf(com.google.android.libraries.navigation.internal.tn.m mVar, Context context, com.google.android.libraries.navigation.internal.um.d dVar) {
        this.b = mVar;
        Context applicationContext = context.getApplicationContext();
        this.c = applicationContext;
        this.e = dVar;
        this.d = com.google.android.libraries.navigation.internal.ul.a.a(applicationContext);
    }
}
