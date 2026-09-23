package com.google.android.libraries.navigation.internal.jc;

import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b {
    public abstract int a();

    public abstract int b();

    public abstract int c();

    public final String toString() {
        return String.format(Locale.US, "%d.%d.%d", Integer.valueOf(a()), Integer.valueOf(b()), Integer.valueOf(c()));
    }
}
