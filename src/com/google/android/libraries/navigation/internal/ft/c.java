package com.google.android.libraries.navigation.internal.ft;

import com.google.android.libraries.navigation.internal.aac.as;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements as {
    final /* synthetic */ Consumer a;

    public c(Consumer consumer) {
        this.a = consumer;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 525)).p("Failed to get the lazy BasicClearcutController");
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        this.a.accept((com.google.android.libraries.navigation.internal.kl.a) obj);
    }
}
