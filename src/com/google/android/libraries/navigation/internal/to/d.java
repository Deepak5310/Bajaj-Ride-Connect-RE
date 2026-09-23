package com.google.android.libraries.navigation.internal.to;

import android.app.Service;
import com.google.android.libraries.navigation.internal.afr.f;
import com.google.android.libraries.navigation.internal.tp.e;
import com.google.android.libraries.navigation.internal.wa.g;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;

    public d(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final a a() {
        return new a(((com.google.android.libraries.navigation.internal.wa.f) this.a).a(), ((e) this.b).a(), (g) this.c.a(), (Service) ((com.google.android.libraries.navigation.internal.afr.g) this.d).a);
    }
}
