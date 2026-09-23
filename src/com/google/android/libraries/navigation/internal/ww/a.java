package com.google.android.libraries.navigation.internal.ww;

import com.google.android.libraries.navigation.internal.aac.az;
import java.util.concurrent.Future;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    @JvmStatic
    public static final Object a(Future future, Object obj) {
        Intrinsics.checkNotNullParameter(future, "future");
        try {
            return az.n(future);
        } catch (Exception unused) {
            return obj;
        }
    }
}
