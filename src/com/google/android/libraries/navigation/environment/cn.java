package com.google.android.libraries.navigation.environment;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class cn implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;

    public cn(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    public static com.google.android.libraries.navigation.internal.vx.a c(Context context, Executor executor, com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.wr.a aVar2) {
        return new com.google.android.libraries.navigation.internal.vx.a(fVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final com.google.android.libraries.navigation.internal.vx.a a() {
        return c((Context) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a, ((com.google.android.libraries.navigation.internal.nj.b) this.b).a(), this.c, (com.google.android.libraries.navigation.internal.iv.f) this.d.a(), ((com.google.android.libraries.navigation.internal.wr.b) this.e).a());
    }
}
