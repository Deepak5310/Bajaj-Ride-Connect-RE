package com.google.android.libraries.navigation.internal.gm;

import com.google.android.libraries.navigation.internal.aac.ca;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements com.google.android.libraries.navigation.internal.fw.a {
    final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.fw.a
    public final void a() {
        ca caVar;
        f fVar = this.a;
        com.google.android.libraries.navigation.internal.gh.b bVarB = fVar.b();
        synchronized (fVar) {
            caVar = null;
            if (bVarB != null) {
                try {
                    ca caVar2 = this.a.a;
                    if (caVar2 != null) {
                        caVar = caVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (caVar != null) {
            caVar.d(bVarB);
        }
    }
}
