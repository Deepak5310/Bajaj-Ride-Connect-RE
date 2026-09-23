package com.google.android.libraries.navigation.internal.ft;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class k implements com.google.android.libraries.navigation.internal.fu.a {
    private static final com.google.android.libraries.navigation.internal.zb.j g = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.ft.k");
    public final Context a;
    public final n b;
    public final TelephonyManager c;
    public final ca d = new ca();
    public final AtomicBoolean e = new AtomicBoolean();
    public String f = "";

    public k(Context context, n nVar) {
        this.a = context;
        this.b = nVar;
        this.c = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
    }

    public static boolean f(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "device_provisioned", 0) != 0;
    }

    private static Object g(bj bjVar, long j, br brVar) {
        try {
            return bjVar.get(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 527)).p("Thread interrupted while trying to read persisted LegalInformation, returning defaults.");
            Thread.currentThread().interrupt();
            return brVar.a();
        } catch (CancellationException | ExecutionException | TimeoutException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 526)).p("Failed to read persisted LegalInformation, returning defaults.");
            return brVar.a();
        }
    }

    private static void h(bj bjVar) {
        try {
            bjVar.get(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 530)).p("Thread interrupted while trying to persist LegalInformation.");
            Thread.currentThread().interrupt();
        } catch (CancellationException e) {
            e = e;
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) g.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 528)).p("Failed to persist LegalInformation.");
        } catch (ExecutionException e2) {
            e = e2;
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) g.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 528)).p("Failed to persist LegalInformation.");
        } catch (TimeoutException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 529)).p("Timed out waiting to persist LegalInformation. Continuing.");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fu.a
    public final int a() {
        return ((Integer) g(com.google.android.libraries.navigation.internal.yu.c.b(this.b.b(), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.ft.g
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                m mVar = (m) obj;
                return Locale.KOREA.getCountry().equals(this.a.c(mVar)) ? Integer.valueOf(mVar.b()) : Integer.valueOf(mVar.a());
            }
        }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE), 1000L, new br() { // from class: com.google.android.libraries.navigation.internal.ft.f
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return 0;
            }
        })).intValue();
    }

    @Override // com.google.android.libraries.navigation.internal.fu.a
    public final String b() {
        return c((m) g(this.b.b(), 500L, new br() { // from class: com.google.android.libraries.navigation.internal.ft.h
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return new j();
            }
        }));
    }

    public final String c(m mVar) {
        String str = this.f;
        if (!aq.c(str)) {
            return str;
        }
        String strD = mVar.d();
        this.f = strD;
        if (!aq.c(strD)) {
            return strD;
        }
        String strC = mVar.c();
        this.f = strC;
        if (!aq.c(strC)) {
            return strC;
        }
        String networkCountryIso = this.c.getPhoneType() != 2 ? this.c.getNetworkCountryIso() : "";
        if (aq.c(networkCountryIso)) {
            networkCountryIso = this.c.getSimCountryIso();
        }
        if (aq.c(networkCountryIso)) {
            networkCountryIso = Locale.getDefault().getCountry();
        }
        this.f = networkCountryIso.toUpperCase(Locale.ROOT);
        if (f(this.a)) {
            this.b.e(this.f);
        }
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.fu.a
    public final void d() {
        h(this.b.g());
        this.e.set(true);
        this.d.d(null);
    }

    @Override // com.google.android.libraries.navigation.internal.fu.a
    public final boolean e() {
        throw null;
    }
}
