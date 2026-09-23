package com.google.android.libraries.navigation.internal.zd;

import com.facebook.react.devsupport.StackTraceHelper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak {
    public final com.google.android.libraries.navigation.internal.zi.d a;
    public final String b;

    public ak(com.google.android.libraries.navigation.internal.zi.d dVar, String str) {
        com.google.android.libraries.navigation.internal.zj.b.d(dVar, "parser");
        this.a = dVar;
        com.google.android.libraries.navigation.internal.zj.b.d(str, StackTraceHelper.MESSAGE_KEY);
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ak) {
            ak akVar = (ak) obj;
            if (this.a.equals(akVar.a) && this.b.equals(akVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.b;
        return str.hashCode() ^ this.a.hashCode();
    }
}
