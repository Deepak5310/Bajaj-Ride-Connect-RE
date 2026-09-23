package com.google.android.libraries.navigation.internal.ye;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.xy.e {
    public com.google.android.libraries.navigation.internal.ya.a[] a;

    @Override // com.google.android.libraries.navigation.internal.xy.e
    public final /* bridge */ /* synthetic */ Object a(com.google.android.libraries.navigation.internal.xy.d dVar) throws IOException {
        List listA = dVar.a(dVar.a.j(dVar.e));
        com.google.android.libraries.navigation.internal.ya.a[] aVarArr = this.a;
        if (aVarArr != null) {
            aVarArr[0].b(listA);
        }
        return (OutputStream) listA.get(0);
    }
}
