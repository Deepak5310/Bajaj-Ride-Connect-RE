package com.google.android.libraries.navigation.internal.da;

import com.google.android.libraries.navigation.internal.dh.ai;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b {
    final /* synthetic */ d a;

    public b(d dVar) {
        this.a = dVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0022  */
    /* JADX WARN: Code duplicated, block: B:15:0x0026 A[Catch: all -> 0x0034, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000d, B:10:0x0015, B:12:0x001b, B:18:0x0032, B:15:0x0026, B:17:0x002c), top: B:23:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x002c A[Catch: all -> 0x0034, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000d, B:10:0x0015, B:12:0x001b, B:18:0x0032, B:15:0x0026, B:17:0x002c), top: B:23:0x0005 }] */
    public final void a(ai aiVar) {
        d dVar;
        synchronized (this.a.c) {
            if (aiVar.g()) {
                float f = aiVar.b;
                if (f <= 30.0f) {
                    d dVar2 = this.a;
                    if (!dVar2.d) {
                        dVar2.d = true;
                        dVar2.c();
                    } else if (f > 30.0f) {
                        dVar = this.a;
                        if (dVar.d) {
                            dVar.d = false;
                            dVar.c();
                        }
                    }
                } else if (f > 30.0f) {
                    dVar = this.a;
                    if (dVar.d) {
                        dVar.d = false;
                        dVar.c();
                    }
                }
            }
        }
    }
}
