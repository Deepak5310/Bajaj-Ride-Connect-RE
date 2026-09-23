package com.google.android.libraries.navigation.internal.aaf;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.s;
import com.google.android.libraries.navigation.internal.yq.h;
import com.google.android.libraries.navigation.internal.zd.ah;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements a {
    public static final /* synthetic */ int a = 0;
    private final Executor b;

    static {
        ah.d("xRPC");
        new AtomicInteger();
    }

    public d(final b bVar) {
        Executor executor = bVar.b;
        this.b = executor;
        new h(new s() { // from class: com.google.android.libraries.navigation.internal.aaf.c
            @Override // com.google.android.libraries.navigation.internal.aac.s
            public final bj a() {
                int i = d.a;
                return az.h((CronetEngine) bVar.c.a());
            }
        }, executor);
        bVar.d.i();
    }
}
