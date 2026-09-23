package com.google.android.libraries.navigation.internal.tj;

import android.text.TextUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class e {
    public String b;
    public com.google.android.libraries.navigation.internal.db.r a = null;
    public boolean c = true;
    public boolean d = false;

    public final void a(com.google.android.libraries.navigation.internal.db.r rVar) {
        com.google.android.libraries.navigation.internal.db.af afVar;
        this.b = null;
        if (rVar == null || !rVar.B() || (afVar = rVar.l().d) == null || TextUtils.isEmpty(afVar.a)) {
            return;
        }
        this.b = afVar.a;
    }
}
