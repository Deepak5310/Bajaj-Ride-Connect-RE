package com.google.android.libraries.navigation.internal.ie;

import android.content.Context;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final Context a;
    public final Executor b;

    public b(Context application, d glideMemoryCacheReference, Executor bgExecutor, Executor uiExecutor) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(glideMemoryCacheReference, "glideMemoryCacheReference");
        Intrinsics.checkNotNullParameter(bgExecutor, "bgExecutor");
        Intrinsics.checkNotNullParameter(uiExecutor, "uiExecutor");
        this.a = application;
        this.b = uiExecutor;
    }
}
