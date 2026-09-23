package com.google.android.libraries.navigation.internal.cn;

import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends y {
    public long a;
    public boolean b;
    public ev c;
    public q d;
    public byte e;

    @Override // com.google.android.libraries.navigation.internal.cn.y
    public final void a(boolean z) {
        this.b = z;
        this.e = (byte) (this.e | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.cn.y
    public final void b(ev evVar) {
        Objects.requireNonNull(evVar);
        this.c = evVar;
    }
}
