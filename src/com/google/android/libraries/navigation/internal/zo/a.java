package com.google.android.libraries.navigation.internal.zo;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends Exception {
    private static final long serialVersionUID = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Exception exc) {
        super(exc);
        ar.q(exc);
    }

    @Override // java.lang.Throwable
    public final /* bridge */ /* synthetic */ Throwable getCause() {
        return (Exception) Objects.requireNonNull(super.getCause());
    }
}
