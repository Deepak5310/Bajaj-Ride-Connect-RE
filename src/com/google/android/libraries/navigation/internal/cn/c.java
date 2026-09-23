package com.google.android.libraries.navigation.internal.cn;

import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends p {
    public ev a;
    public ev b;

    @Override // com.google.android.libraries.navigation.internal.cn.p
    public final void a(ev evVar) {
        Objects.requireNonNull(evVar);
        this.b = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.p
    public final void b(ev evVar) {
        Objects.requireNonNull(evVar);
        this.a = evVar;
    }
}
