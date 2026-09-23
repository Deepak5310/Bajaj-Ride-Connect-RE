package com.google.android.libraries.navigation.internal.gz;

import com.facebook.react.devsupport.StackTraceHelper;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.ic.a {
    private final String a;
    private final c b;

    public d(String str, c cVar) {
        this.a = str;
        this.b = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.e, com.google.android.libraries.navigation.internal.ic.a
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        com.google.android.libraries.navigation.internal.kp.f fVar = new com.google.android.libraries.navigation.internal.kp.f("DebugToast");
        fVar.m(StackTraceHelper.MESSAGE_KEY, this.a);
        fVar.m("audience", this.b.toString());
        return fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.e
    public final boolean k() {
        return false;
    }

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.g(StackTraceHelper.MESSAGE_KEY, this.a);
        akVarB.g("audience", this.b);
        return akVarB.toString();
    }
}
