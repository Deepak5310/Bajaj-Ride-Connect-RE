package com.google.android.libraries.navigation.internal.uh;

import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class m implements o {
    private n a;
    public final p t;

    public m(n nVar, p pVar) {
        this.a = nVar;
        this.t = pVar;
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public void aC() {
        this.a = null;
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public /* synthetic */ void ay(Configuration configuration) {
    }

    public n az() {
        n nVar = this.a;
        ar.q(nVar);
        return nVar;
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public /* synthetic */ void h(Bundle bundle) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public /* synthetic */ void j(Bundle bundle) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public /* synthetic */ void k() {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public /* synthetic */ void l() {
    }
}
