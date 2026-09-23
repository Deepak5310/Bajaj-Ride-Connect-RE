package com.google.android.libraries.navigation.internal.ld;

import android.accounts.Account;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.ArraySet;
import androidx.core.content.ContextCompat;
import com.google.android.libraries.navigation.internal.le.ai;
import com.google.android.libraries.navigation.internal.le.aj;
import com.google.android.libraries.navigation.internal.le.ao;
import com.google.android.libraries.navigation.internal.le.av;
import com.google.android.libraries.navigation.internal.le.aw;
import com.google.android.libraries.navigation.internal.le.ax;
import com.google.android.libraries.navigation.internal.le.bc;
import com.google.android.libraries.navigation.internal.le.bj;
import com.google.android.libraries.navigation.internal.lh.be;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class o {
    private final com.google.android.libraries.navigation.internal.le.h a;
    public final Context b;
    public final String c;
    public final com.google.android.libraries.navigation.internal.ln.a d;
    public final k e;
    public final g f;
    public final com.google.android.libraries.navigation.internal.le.i g;
    public final Looper h;
    public final int i;
    public final s j;
    protected final ai k;

    public o(Context context, k kVar, g gVar, n nVar) {
        be.k(context, "Null context is not permitted.");
        be.k(kVar, "Api must not be null.");
        be.k(nVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        be.k(applicationContext, "The provided context did not have an application context.");
        this.b = applicationContext;
        com.google.android.libraries.navigation.internal.ln.a aVar = null;
        String attributionTag = (Build.VERSION.SDK_INT < 30 || context == null) ? null : ContextCompat.getAttributionTag(context);
        this.c = attributionTag;
        if (Build.VERSION.SDK_INT >= 31 && context != null) {
            aVar = new com.google.android.libraries.navigation.internal.ln.a(context.getAttributionSource());
        }
        this.d = aVar;
        this.e = kVar;
        this.f = gVar;
        this.h = nVar.b;
        this.g = new com.google.android.libraries.navigation.internal.le.i(kVar, gVar, attributionTag);
        this.j = new aj(this);
        ai aiVarC = ai.c(applicationContext);
        this.k = aiVarC;
        this.i = aiVarC.k.getAndIncrement();
        this.a = nVar.c;
        Handler handler = aiVarC.p;
        handler.sendMessage(handler.obtainMessage(7, this));
    }

    private final com.google.android.libraries.navigation.internal.me.w a(int i, bj bjVar) {
        com.google.android.libraries.navigation.internal.me.aa aaVar = new com.google.android.libraries.navigation.internal.me.aa();
        int i2 = bjVar.d;
        ai aiVar = this.k;
        aiVar.d(aaVar, i2, this);
        com.google.android.libraries.navigation.internal.le.e eVar = new com.google.android.libraries.navigation.internal.le.e(i, bjVar, aaVar, this.a);
        Handler handler = aiVar.p;
        handler.sendMessage(handler.obtainMessage(4, new av(eVar, aiVar.l.get(), this)));
        return aaVar.a;
    }

    public final com.google.android.libraries.navigation.internal.lh.n e() {
        com.google.android.libraries.navigation.internal.kw.a aVarA;
        com.google.android.libraries.navigation.internal.kw.a aVarA2;
        com.google.android.libraries.navigation.internal.lh.n nVar = new com.google.android.libraries.navigation.internal.lh.n();
        g gVar = this.f;
        Account accountA = null;
        if (!(gVar instanceof e) || (aVarA2 = ((e) gVar).a()) == null) {
            g gVar2 = this.f;
            if (gVar2 instanceof d) {
                accountA = ((d) gVar2).a();
            }
        } else {
            String str = aVarA2.c;
            if (str != null) {
                accountA = new Account(str, "com.google");
            }
        }
        nVar.a = accountA;
        g gVar3 = this.f;
        Set setEmptySet = (!(gVar3 instanceof e) || (aVarA = ((e) gVar3).a()) == null) ? Collections.emptySet() : aVarA.a();
        if (nVar.b == null) {
            nVar.b = new ArraySet();
        }
        nVar.b.addAll(setEmptySet);
        Context context = this.b;
        nVar.d = context.getClass().getName();
        nVar.c = context.getPackageName();
        return nVar;
    }

    public final com.google.android.libraries.navigation.internal.me.w f(bj bjVar) {
        return a(2, bjVar);
    }

    public final com.google.android.libraries.navigation.internal.me.w g(bj bjVar) {
        return a(0, bjVar);
    }

    public final com.google.android.libraries.navigation.internal.me.w h(bc bcVar) {
        be.k(bcVar.a.a(), "Listener has already been released.");
        be.k(bcVar.b.b, "Listener has already been released.");
        com.google.android.libraries.navigation.internal.me.aa aaVar = new com.google.android.libraries.navigation.internal.me.aa();
        ai aiVar = this.k;
        aw awVar = bcVar.a;
        aiVar.d(aaVar, awVar.d, this);
        com.google.android.libraries.navigation.internal.le.d dVar = new com.google.android.libraries.navigation.internal.le.d(new ax(awVar, bcVar.b, bcVar.c), aaVar);
        Handler handler = aiVar.p;
        handler.sendMessage(handler.obtainMessage(8, new av(dVar, aiVar.l.get(), this)));
        return aaVar.a;
    }

    public final com.google.android.libraries.navigation.internal.me.w i(ao aoVar, int i) {
        com.google.android.libraries.navigation.internal.me.aa aaVar = new com.google.android.libraries.navigation.internal.me.aa();
        ai aiVar = this.k;
        aiVar.d(aaVar, i, this);
        com.google.android.libraries.navigation.internal.le.f fVar = new com.google.android.libraries.navigation.internal.le.f(aoVar, aaVar);
        Handler handler = aiVar.p;
        handler.sendMessage(handler.obtainMessage(13, new av(fVar, aiVar.l.get(), this)));
        return aaVar.a;
    }

    public final com.google.android.libraries.navigation.internal.me.w j(bj bjVar) {
        return a(1, bjVar);
    }
}
