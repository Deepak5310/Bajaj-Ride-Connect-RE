package com.google.android.libraries.navigation.internal.ms;

import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class at {
    private static final bc a;

    /* JADX INFO: compiled from: PG */
    final class a {
        static {
            TimeUnit.MILLISECONDS.toNanos(5L);
        }

        public a() {
            new LinkedHashSet();
        }
    }

    static {
        new a();
        a = new bc(new Function1() { // from class: com.google.android.libraries.navigation.internal.ms.as
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(cy.a((cs) obj));
            }
        });
    }

    public final void a(cs viewModel) {
        bc bcVar = a;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        bcVar.a.invoke(viewModel);
    }
}
