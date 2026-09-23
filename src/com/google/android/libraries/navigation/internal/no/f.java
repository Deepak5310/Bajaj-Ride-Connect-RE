package com.google.android.libraries.navigation.internal.no;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.core.os.ConfigurationCompat;
import com.google.android.libraries.navigation.internal.nt.ac;
import com.google.android.libraries.navigation.internal.nt.m;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements a {
    public final BroadcastReceiver a;
    private final ac b;
    private final Context c;

    public f(final Context context) {
        this.c = context;
        final ac acVar = new ac(new br() { // from class: com.google.android.libraries.navigation.internal.no.b
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return f.d(context);
            }
        });
        this.b = acVar;
        this.a = new e(acVar);
        acVar.a.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.no.c
            @Override // java.lang.Runnable
            public final void run() {
                if (acVar.a.t() == 0) {
                    Context context2 = context;
                    f fVar = this.a;
                    context2.registerReceiver(fVar.a, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
                }
            }
        });
        acVar.a.m(new Runnable() { // from class: com.google.android.libraries.navigation.internal.no.d
            @Override // java.lang.Runnable
            public final void run() {
                if (acVar.a.t() == 0) {
                    context.unregisterReceiver(this.a.a);
                }
            }
        });
    }

    public static Locale d(Context context) {
        Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
        return locale == null ? Locale.getDefault() : locale;
    }

    @Override // com.google.android.libraries.navigation.internal.no.a
    public final m a() {
        return this.b.a;
    }

    @Override // com.google.android.libraries.navigation.internal.no.a
    public final Locale b() {
        return d(this.c);
    }

    @Override // com.google.android.libraries.navigation.internal.no.a
    public final Locale c() {
        return Locale.getDefault();
    }
}
