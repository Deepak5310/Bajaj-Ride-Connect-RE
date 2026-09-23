package com.google.android.libraries.navigation.internal.hf;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b {
    private final String a;
    private final StringBuffer b;

    public b(Context context) {
        Resources resources = context.getResources();
        resources.getString(com.google.android.libraries.navigation.internal.f.h.c);
        this.a = resources.getString(com.google.android.libraries.navigation.internal.f.h.d);
        this.b = new StringBuffer();
    }

    public final void a(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        StringBuffer stringBuffer = this.b;
        if (stringBuffer.length() != 0) {
            stringBuffer.append(this.a);
        }
        this.b.append(charSequence);
    }

    public final String toString() {
        return this.b.toString();
    }
}
