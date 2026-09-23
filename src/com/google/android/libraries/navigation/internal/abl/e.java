package com.google.android.libraries.navigation.internal.abl;

import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements com.google.android.libraries.navigation.internal.b.y {
    final /* synthetic */ i a;

    public e(i iVar) {
        this.a = iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.b.y
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        String strReplace = ((String) obj).replace("[", "").replace("]", "").replace("\"", "").replace(",", ", ");
        i iVar = this.a;
        iVar.l = ("©" + iVar.d.get(1) + StringUtils.SPACE + strReplace).trim();
        this.a.c();
    }
}
