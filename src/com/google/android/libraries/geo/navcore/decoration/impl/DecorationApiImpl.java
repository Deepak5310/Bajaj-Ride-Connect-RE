package com.google.android.libraries.geo.navcore.decoration.impl;

import com.google.android.apps.gmm.jni.util.NativeHelper;
import com.google.android.libraries.navigation.internal.acg.j;
import com.google.android.libraries.navigation.internal.acg.l;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.yx.ax;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class DecorationApiImpl implements com.google.android.libraries.navigation.internal.rr.a, h {
    public static final /* synthetic */ int b = 0;
    public long a = 0;
    private final com.google.android.libraries.navigation.internal.vm.e c = new com.google.android.libraries.navigation.internal.vm.e();

    static {
        NativeHelper.c();
        nativeInitClass();
    }

    private static native boolean nativeInitClass();

    @Override // com.google.android.libraries.navigation.internal.rr.a
    public final void a(com.google.android.libraries.navigation.internal.rr.b bVar, Executor executor) {
        this.c.c(bVar, executor);
    }

    @Override // com.google.android.libraries.navigation.internal.rr.a
    public final void b(com.google.android.libraries.navigation.internal.rr.b bVar) {
        this.c.b(bVar);
    }

    @Override // com.google.android.libraries.geo.navcore.decoration.impl.h
    public final void c(d dVar) {
        nativeTriggerEvent(this.a, dVar.m());
    }

    protected final void finalize() {
        long j = this.a;
        if (j != 0) {
            nativeUnsubscribeAndFree(j);
            this.a = 0L;
        }
    }

    public native long nativeAllocateAndSubscribe(long j);

    public native void nativeTriggerEvent(long j, byte[] bArr);

    public native void nativeUnsubscribeAndFree(long j);

    void receiveEvent(byte[] bArr) {
        try {
            bi biVarV = bi.v(g.a, bArr, 0, bArr.length, ar.b());
            bi.I(biVarV);
            final g gVar = (g) biVarV;
            this.c.a(new ax() { // from class: com.google.android.libraries.geo.navcore.decoration.impl.a
                @Override // com.google.android.libraries.navigation.internal.yx.ax
                public final void a(Object obj) {
                    int i;
                    com.google.android.libraries.navigation.internal.rr.b bVar = (com.google.android.libraries.navigation.internal.rr.b) obj;
                    int i2 = DecorationApiImpl.b;
                    g gVar2 = gVar;
                    int i3 = gVar2.b;
                    if (i3 == 0) {
                        i = f.c;
                    } else if (i3 != 1) {
                        i = i3 != 2 ? 0 : f.b;
                    } else {
                        i = f.a;
                    }
                    if (i == 0) {
                        throw null;
                    }
                    int i4 = i - 1;
                    if (i4 == 0) {
                        if (bVar instanceof com.google.android.libraries.navigation.internal.rr.d) {
                            ((com.google.android.libraries.navigation.internal.rr.d) bVar).n(gVar2.b == 1 ? (l) gVar2.c : l.a);
                        }
                    } else if (i4 == 1 && (bVar instanceof com.google.android.libraries.navigation.internal.rr.c)) {
                        ((com.google.android.libraries.navigation.internal.rr.c) bVar).m(gVar2.b == 2 ? (j) gVar2.c : j.a);
                    }
                }
            });
        } catch (cc unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1397)).p("Invalid protobuf received from JNI");
        }
    }
}
