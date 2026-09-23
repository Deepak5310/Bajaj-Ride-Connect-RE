package com.google.android.libraries.navigation.internal.ar;

import com.google.android.libraries.navigation.internal.at.d;
import com.google.android.libraries.navigation.internal.nt.m;
import com.google.android.libraries.navigation.internal.nt.o;
import com.google.android.libraries.navigation.internal.nt.p;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final d a;
    private final p b;
    private final p c;

    public a(d transitionLogger) {
        Intrinsics.checkNotNullParameter(transitionLogger, "transitionLogger");
        this.a = transitionLogger;
        this.b = new p(false);
        new p(false);
        new p(false);
        new p(false);
        p pVar = new p(new com.google.android.libraries.navigation.internal.aq.a());
        this.c = pVar;
        StateFlowKt.MutableStateFlow(false);
        StateFlowKt.MutableStateFlow(false);
        StateFlowKt.MutableStateFlow(false);
        StateFlowKt.MutableStateFlow(false);
        Object objC = pVar.a.c();
        if (objC == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        transitionLogger.a(objC);
    }

    public final m a() {
        o oVar = this.b.a;
        Intrinsics.checkNotNullExpressionValue(oVar, "getObservableState(...)");
        return oVar;
    }
}
