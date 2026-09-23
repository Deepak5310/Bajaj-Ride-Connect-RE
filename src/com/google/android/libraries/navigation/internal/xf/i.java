package com.google.android.libraries.navigation.internal.xf;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.afl.fv;
import com.google.android.libraries.navigation.internal.hn.r;
import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class i implements com.google.android.libraries.navigation.internal.fu.a {
    private static final com.google.android.libraries.navigation.internal.zb.j d = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.xf.i");
    public final com.google.android.libraries.navigation.internal.ft.n a;
    private final Context e;
    private final TelephonyManager f;
    private final r g;
    private final com.google.android.libraries.navigation.internal.xh.c j;
    private final Executor k;
    public final ca b = new ca();
    public final AtomicBoolean c = new AtomicBoolean();
    private String h = "";
    private final com.google.android.libraries.navigation.internal.nt.p i = new com.google.android.libraries.navigation.internal.nt.p(com.google.android.libraries.navigation.internal.yx.a.a);

    public i(Context context, com.google.android.libraries.navigation.internal.ft.n nVar, r rVar, com.google.android.libraries.navigation.internal.xh.c cVar, Executor executor) {
        this.e = context;
        this.a = nVar;
        this.f = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        this.g = rVar;
        this.j = cVar;
        this.k = executor;
    }

    public static void f(bj bjVar) {
        try {
            bjVar.get(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 2013)).p("Thread interrupted while trying to persist LegalInformation.");
            Thread.currentThread().interrupt();
        } catch (CancellationException e) {
            e = e;
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) d.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 2011)).p("Failed to persist LegalInformation.");
        } catch (ExecutionException e2) {
            e = e2;
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) d.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 2011)).p("Failed to persist LegalInformation.");
        } catch (TimeoutException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 2012)).p("Timed out waiting to persist LegalInformation. Continuing.");
        }
    }

    private static Object h(bj bjVar, br brVar) {
        try {
            return bjVar.get(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 2010)).p("Thread interrupted while trying to read persisted LegalInformation, returning defaults.");
            Thread.currentThread().interrupt();
            return brVar.a();
        } catch (CancellationException | ExecutionException | TimeoutException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 2009)).p("Failed to read persisted LegalInformation, returning defaults.");
            return brVar.a();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fu.a
    public final int a() {
        return ((Integer) h(com.google.android.libraries.navigation.internal.yu.c.b(this.a.b(), new aa() { // from class: com.google.android.libraries.navigation.internal.xf.e
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                com.google.android.libraries.navigation.internal.ft.m mVar = (com.google.android.libraries.navigation.internal.ft.m) obj;
                return Locale.KOREA.getCountry().equals(this.a.c(mVar)) ? Integer.valueOf(mVar.b()) : Integer.valueOf(mVar.a());
            }
        }, ac.INSTANCE), new br() { // from class: com.google.android.libraries.navigation.internal.xf.d
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return 0;
            }
        })).intValue();
    }

    @Override // com.google.android.libraries.navigation.internal.fu.a
    public final String b() {
        return this.h;
    }

    public final String c(com.google.android.libraries.navigation.internal.ft.m mVar) {
        String str = this.h;
        if (!aq.c(str)) {
            return str;
        }
        String strD = mVar.d();
        this.h = strD;
        if (!aq.c(strD)) {
            return strD;
        }
        String strC = mVar.c();
        this.h = strC;
        if (!aq.c(strC)) {
            return strC;
        }
        String networkCountryIso = this.f.getPhoneType() != 2 ? this.f.getNetworkCountryIso() : "";
        if (aq.c(networkCountryIso)) {
            networkCountryIso = this.f.getSimCountryIso();
        }
        if (aq.c(networkCountryIso)) {
            networkCountryIso = Locale.getDefault().getCountry();
        }
        this.h = networkCountryIso.toUpperCase(Locale.ROOT);
        if (Settings.System.getInt(this.e.getContentResolver(), "device_provisioned", 0) != 0) {
            this.a.e(this.h);
        }
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.fu.a
    public final synchronized void d() {
    }

    @Override // com.google.android.libraries.navigation.internal.fu.a
    public final boolean e() {
        final bj bjVarH = g() ? com.google.android.libraries.navigation.internal.aac.j.h(this.j.b(), new aa() { // from class: com.google.android.libraries.navigation.internal.xf.f
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.xh.b) obj).b());
            }
        }, this.k) : az.h(false);
        return ((Boolean) h(new com.google.android.libraries.navigation.internal.yu.b(az.c(bjVarH, this.a.b())).a.a(com.google.android.libraries.navigation.internal.yu.f.c(new Callable() { // from class: com.google.android.libraries.navigation.internal.xf.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                i iVar = this.a;
                com.google.android.libraries.navigation.internal.ft.m mVar = (com.google.android.libraries.navigation.internal.ft.m) az.n(iVar.a.b());
                boolean zBooleanValue = ((Boolean) com.google.android.libraries.navigation.internal.ww.a.a(bjVarH, false)).booleanValue();
                if (Locale.KOREA.getCountry().equals(iVar.c(mVar))) {
                    return Boolean.valueOf(mVar.b() == 1);
                }
                return Boolean.valueOf(mVar.a() >= ((!iVar.g() || zBooleanValue) ? 1 : 2));
            }
        }), ac.INSTANCE), new br() { // from class: com.google.android.libraries.navigation.internal.xf.h
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.FALSE;
            }
        })).booleanValue();
    }

    public final boolean g() {
        return ((fv) this.g.b()).h;
    }
}
