package com.google.android.libraries.navigation.internal.ev;

import android.content.Context;
import java.io.File;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final String a = "users".concat(String.valueOf(File.separator));
    public final Context b;
    private final Context c;

    static {
        String str = File.separator;
        String str2 = File.separator;
        String str3 = File.separator;
        int i = a.a;
    }

    public b(Context context) {
        this.b = context;
        this.c = context;
        Objects.requireNonNull(context);
    }
}
