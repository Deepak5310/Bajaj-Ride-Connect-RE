package com.google.android.libraries.navigation.internal.ii;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static an a(Class cls, Context context) {
        ar.q(context);
        if (context instanceof c) {
            return an.i(((c) context).a());
        }
        return (!(context instanceof ContextWrapper) || (context instanceof AppCompatActivity)) ? com.google.android.libraries.navigation.internal.yx.a.a : a(cls, ((ContextWrapper) context).getBaseContext());
    }
}
