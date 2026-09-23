package com.google.android.apps.gmm.offline.settings.dataview;

import com.google.android.apps.gmm.jni.util.NativeHelper;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class OfflineDataViewProvider {
    public static final /* synthetic */ int a = 0;
    private static final bj b = NativeHelper.a(new Runnable() { // from class: com.google.android.apps.gmm.offline.settings.dataview.b
        @Override // java.lang.Runnable
        public final void run() {
            OfflineDataViewProvider.nativeInitClass();
        }
    });
    private final com.google.android.libraries.navigation.internal.ep.b c;
    private long d;
    private final br e;

    public OfflineDataViewProvider(br brVar, com.google.android.libraries.navigation.internal.ep.b bVar) {
        this.e = brVar;
        this.c = bVar;
        NativeHelper.b(b);
        this.d = nativeInitDataViewProvider();
    }

    private static native void nativeDestroyDataViewProvider(long j);

    public static native boolean nativeInitClass();

    private native long nativeInitDataViewProvider();

    public final synchronized long a() {
        return this.d;
    }

    public final synchronized void b() {
        long j = this.d;
        if (j != 0) {
            nativeDestroyDataViewProvider(j);
            this.d = 0L;
        }
    }

    public byte[] getActiveDataViewInfoBytes() {
        if ((((a) this.e).a.b & 2) != 0) {
            com.google.android.libraries.navigation.internal.acp.b bVar = ((a) this.e).a.c;
            if (bVar == null) {
                bVar = com.google.android.libraries.navigation.internal.acp.b.a;
            }
            return bVar.m();
        }
        com.google.android.libraries.navigation.internal.acp.b bVar2 = this.c.c;
        if (bVar2 == null) {
            bVar2 = com.google.android.libraries.navigation.internal.acp.b.a;
        }
        return bVar2.m();
    }
}
