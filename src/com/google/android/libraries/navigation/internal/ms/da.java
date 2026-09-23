package com.google.android.libraries.navigation.internal.ms;

import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class da {
    @JvmStatic
    public static dd a(Object obj) {
        return new ar(obj);
    }

    @JvmStatic
    public static dd b(final by contextFunction) {
        Intrinsics.checkNotNullParameter(contextFunction, "contextFunction");
        return new dd() { // from class: com.google.android.libraries.navigation.internal.ms.db
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs viewModel) {
                Intrinsics.checkNotNullParameter(viewModel, "viewModel");
                Context context = (Context) al.a.get();
                if (context != null) {
                    return contextFunction.a(viewModel, context);
                }
                throw new IllegalStateException("VmFunction.invoke() may not be called from here. VmFunctions must only be invoked by Curvular internals or from within other VmFunctions, because correct execution depends on private state managed by Curvular.");
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
    }
}
