package com.google.android.libraries.navigation.internal.ze;

import com.google.android.libraries.navigation.internal.zd.n;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j extends com.google.android.libraries.navigation.internal.zg.a {
    public static final j a = new j(com.google.android.libraries.navigation.internal.zg.c.a);
    private final AtomicReference b;

    public j(com.google.android.libraries.navigation.internal.zg.a aVar) {
        this.b = new AtomicReference(aVar);
    }

    @Override // com.google.android.libraries.navigation.internal.zg.a
    public final n a() {
        return ((com.google.android.libraries.navigation.internal.zg.a) this.b.get()).a();
    }

    @Override // com.google.android.libraries.navigation.internal.zg.a
    public final com.google.android.libraries.navigation.internal.zg.l b() {
        return ((com.google.android.libraries.navigation.internal.zg.a) this.b.get()).b();
    }

    @Override // com.google.android.libraries.navigation.internal.zg.a
    public final void c(String str, Level level, boolean z) {
        ((com.google.android.libraries.navigation.internal.zg.a) this.b.get()).c(str, level, z);
    }
}
