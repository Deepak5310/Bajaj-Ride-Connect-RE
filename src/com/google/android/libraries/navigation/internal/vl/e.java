package com.google.android.libraries.navigation.internal.vl;

import android.content.Context;
import android.text.Spanned;
import com.google.android.libraries.navigation.internal.adr.dc;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class e implements com.google.android.libraries.navigation.internal.vk.c {
    private Spanned a;
    private Spanned b;

    public e(int i, Context context, boolean z, boolean z2, boolean z3, String str, Spanned spanned, Spanned spanned2, com.google.android.libraries.navigation.internal.vk.c.a aVar, dc dcVar) {
        this.a = spanned;
        this.b = spanned2;
    }

    @Override // com.google.android.libraries.navigation.internal.vk.c
    public Spanned a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.vk.c
    public Spanned b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.vk.c
    public void c(Spanned spanned) {
        this.b = spanned;
    }

    @Override // com.google.android.libraries.navigation.internal.vk.c
    public void d(Spanned spanned) {
        this.a = spanned;
    }
}
