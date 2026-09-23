package com.google.android.libraries.navigation.internal.yh;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.yr.ax;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ap implements com.google.android.libraries.navigation.internal.aac.s {
    public List a;
    final /* synthetic */ as b;

    public ap(as asVar) {
        this.b = asVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.s
    public final bj a() throws Exception {
        as asVar = this.b;
        com.google.android.libraries.navigation.internal.yr.w wVarA = asVar.e.a("Initialize ".concat(String.valueOf(asVar.a)), ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        try {
            synchronized (this.b.d) {
                if (this.a == null) {
                    as asVar2 = this.b;
                    this.a = asVar2.f;
                    asVar2.f = Collections.emptyList();
                }
            }
            ArrayList arrayList = new ArrayList(this.a.size());
            ar arVar = new ar(this.b);
            Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                try {
                    arrayList.add(((com.google.android.libraries.navigation.internal.aac.t) it2.next()).a(arVar));
                } catch (Exception e) {
                    arrayList.add(az.g(e));
                }
            }
            bj bjVarA = az.b(arrayList).a(new Callable() { // from class: com.google.android.libraries.navigation.internal.yh.ao
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    ap apVar = this.a;
                    synchronized (apVar.b.d) {
                        apVar.a = null;
                    }
                    return null;
                }
            }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            wVarA.a(bjVarA);
            wVarA.close();
            return bjVarA;
        } catch (Throwable th) {
            try {
                wVarA.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
