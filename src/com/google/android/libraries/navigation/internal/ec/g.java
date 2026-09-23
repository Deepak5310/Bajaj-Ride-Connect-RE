package com.google.android.libraries.navigation.internal.ec;

import com.google.android.libraries.navigation.internal.nt.m;
import com.google.android.libraries.navigation.internal.nt.o;
import com.google.android.libraries.navigation.internal.nt.p;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.google.android.libraries.navigation.internal.ed.b {
    public final p a;
    public final MutableStateFlow b;

    public g() {
        this(null);
    }

    @Override // com.google.android.libraries.navigation.internal.ed.b
    public final m a() {
        o oVar = this.a.a;
        Intrinsics.checkNotNullExpressionValue(oVar, "getObservableState(...)");
        return oVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ed.b
    public final boolean c() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    public g(byte[] bArr) {
        this.a = new p(false);
        this.b = StateFlowKt.MutableStateFlow(false);
    }
}
