package com.google.android.libraries.navigation.internal.dd;

import com.google.android.libraries.navigation.internal.zb.j;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements com.google.android.libraries.navigation.internal.sp.b {
    public static final j a = j.e("com.google.android.libraries.navigation.internal.dd.d");
    public c b;
    private final Executor c;

    public d(Executor executor) {
        this.c = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(final com.google.android.libraries.navigation.internal.sp.c cVar) {
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.dd.b
            @Override // java.lang.Runnable
            public final void run() {
                c cVar2 = this.a.b;
                if (cVar2 != null) {
                    cVar2.n();
                }
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(final boolean z) {
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.dd.a
            @Override // java.lang.Runnable
            public final void run() {
                c cVar = this.a.b;
                if (cVar != null) {
                    cVar.o();
                }
            }
        });
    }
}
