package com.google.android.libraries.navigation.internal.uh;

import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.libraries.navigation.internal.ea.c;
import com.google.android.libraries.navigation.internal.ea.e;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a<S extends com.google.android.libraries.navigation.internal.ea.e, T extends com.google.android.libraries.navigation.internal.ea.c<S, T>> implements c, d {
    public static final com.google.android.libraries.navigation.internal.uc.k a;
    public final com.google.android.libraries.navigation.internal.ea.c b;
    public com.google.android.libraries.navigation.internal.ea.e c;
    public boolean d;

    static {
        com.google.android.libraries.navigation.internal.uc.j jVar = new com.google.android.libraries.navigation.internal.uc.j();
        jVar.a = com.google.android.libraries.navigation.internal.uc.g.FOLLOWING;
        jVar.d();
        a = jVar.a();
    }

    public a(com.google.android.libraries.navigation.internal.ea.c cVar) {
        this.b = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void aC() {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void ay(Configuration configuration) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void h(Bundle bundle) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public /* synthetic */ void j(Bundle bundle) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public void k() {
        this.d = true;
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public void l() {
        this.c = null;
        this.d = false;
    }
}
