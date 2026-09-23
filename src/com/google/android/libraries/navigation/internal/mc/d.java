package com.google.android.libraries.navigation.internal.mc;

import com.google.android.gms.common.Scopes;
import com.google.android.libraries.navigation.internal.ld.j;
import com.google.android.libraries.navigation.internal.ld.k;
import com.google.android.libraries.navigation.internal.ld.z;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static final j a;
    public static final j b;
    public static final com.google.android.libraries.navigation.internal.ld.a c;
    static final com.google.android.libraries.navigation.internal.ld.a d;
    public static final k e;

    static {
        j jVar = new j();
        a = jVar;
        b = new j();
        a aVar = new a();
        c = aVar;
        d = new b();
        new z(Scopes.PROFILE);
        new z("email");
        e = new k("SignIn.API", aVar, jVar);
    }
}
