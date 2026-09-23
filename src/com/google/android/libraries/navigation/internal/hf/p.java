package com.google.android.libraries.navigation.internal.hf;

import android.content.Context;
import java.text.DateFormat;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    public static final o a = new o();
    public final DateFormat b;
    private final Locale c;
    private final boolean d;

    public p(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = o.a(context);
        this.d = android.text.format.DateFormat.is24HourFormat(context);
        this.b = android.text.format.DateFormat.getTimeFormat(context);
    }

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Intrinsics.areEqual(o.a(context), this.c) && android.text.format.DateFormat.is24HourFormat(context) == this.d;
    }
}
