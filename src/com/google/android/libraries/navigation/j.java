package com.google.android.libraries.navigation;

import com.google.android.libraries.navigation.internal.xe.bd;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class j implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ NavigationTransactionRecorder a;

    public j(NavigationTransactionRecorder navigationTransactionRecorder) {
        this.a = navigationTransactionRecorder;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        com.google.android.libraries.navigation.internal.xh.b bVar = (com.google.android.libraries.navigation.internal.xh.b) obj;
        this.a.b = bVar;
        if (!bVar.c()) {
            this.a.c.clear();
        } else {
            this.a.c.stream().forEach(new Consumer() { // from class: com.google.android.libraries.navigation.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj2) {
                    try {
                        ((bd) obj2).a();
                    } catch (NavigationTransactionRecorder.TransactionException unused) {
                    }
                }
            });
            this.a.c.clear();
        }
    }
}
