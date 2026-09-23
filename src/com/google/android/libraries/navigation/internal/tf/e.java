package com.google.android.libraries.navigation.internal.tf;

import com.google.android.libraries.navigation.internal.aes.h;
import com.google.android.libraries.navigation.internal.ke.j;
import com.google.android.libraries.navigation.internal.zr.de;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends j {
    private final de a;
    private final h d;

    public e(de deVar, h hVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        super(aVar);
        this.a = deVar;
        this.d = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ke.j
    protected final de w() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ke.j
    protected final h x() {
        return this.d;
    }
}
