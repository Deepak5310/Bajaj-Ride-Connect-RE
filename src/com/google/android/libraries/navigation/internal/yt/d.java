package com.google.android.libraries.navigation.internal.yt;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yr.aw;
import com.google.android.libraries.navigation.internal.yr.ax;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static final a a = new b();

    public static final a a(String str) {
        if (aw.d(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS)) {
            return e(str);
        }
        return Trace.isEnabled() ? f.b(str) : a;
    }

    public static a b(String str, com.google.android.libraries.navigation.internal.xn.a aVar) {
        if (aw.d(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS)) {
            return e(str.concat(String.valueOf(String.valueOf(aVar))));
        }
        return Trace.isEnabled() ? f.b(str.concat(String.valueOf(String.valueOf(aVar)))) : a;
    }

    public static a c(String str, Enum r2) {
        if (aw.d(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS)) {
            return e(str.concat(String.valueOf(r2.name())));
        }
        return Trace.isEnabled() ? f.b(str.concat(String.valueOf(r2.name()))) : a;
    }

    public static a d(String str, Object obj) {
        if (obj instanceof e) {
            return b(str, ((e) obj).b());
        }
        return Trace.isEnabled() ? f.b(str.concat(String.valueOf(obj.getClass().getSimpleName()))) : a;
    }

    public static a e(String str) {
        return new c(aw.b(str, ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS));
    }
}
