package com.google.android.libraries.navigation.internal.la;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.libraries.navigation.internal.ky.ar;
import com.google.android.libraries.navigation.internal.ky.as;
import com.google.android.libraries.navigation.internal.ky.au;
import com.google.android.libraries.navigation.internal.ky.av;
import com.google.android.libraries.navigation.internal.ky.aw;
import com.google.android.libraries.navigation.internal.ky.ax;
import com.google.android.libraries.navigation.internal.ld.ab;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h extends com.google.android.libraries.navigation.internal.le.l {
    final /* synthetic */ i a;
    private final com.google.android.libraries.navigation.internal.ky.h j;
    private final au k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, com.google.android.libraries.navigation.internal.ky.h hVar, com.google.android.libraries.navigation.internal.ld.s sVar, au auVar) {
        super(com.google.android.libraries.navigation.internal.ky.o.d, sVar);
        this.a = iVar;
        this.j = hVar;
        this.k = auVar;
    }

    @Override // com.google.android.libraries.navigation.internal.le.q
    protected final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.ld.y a(ab abVar) {
        return abVar;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0081  */
    @Override // com.google.android.libraries.navigation.internal.le.l
    protected final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.ld.b bVar) throws RemoteException {
        ArrayList arrayList;
        int i;
        int i2;
        long jLongValue;
        long jA;
        j jVar = (j) bVar;
        try {
            com.google.android.libraries.navigation.internal.ky.h hVarB = this.j.b();
            if (hVarB == null) {
                i(ab.a);
                return;
            }
            com.google.android.libraries.navigation.internal.afk.a aVar = hVarB.b;
            String str = hVarB.h;
            int i3 = ((com.google.android.libraries.navigation.internal.afk.b) aVar.b).e;
            as asVar = null;
            if (str == null || str.isEmpty()) {
                str = null;
            }
            ar arVar = hVarB.a.e;
            if (str == null) {
                arrayList = new ArrayList();
            } else {
                List<com.google.android.libraries.navigation.internal.afk.p> listA = ((v) arVar).a(str);
                ArrayList arrayList2 = new ArrayList();
                for (com.google.android.libraries.navigation.internal.afk.p pVar : listA) {
                    if ((pVar.b & 1) == 0 || (i = pVar.c) == 0 || i == i3) {
                        arrayList2.add(pVar);
                    }
                }
                arrayList = arrayList2;
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    com.google.android.libraries.navigation.internal.afk.p pVar2 = (com.google.android.libraries.navigation.internal.afk.p) it2.next();
                    String str2 = pVar2.d;
                    Context context = ((v) arVar).d;
                    if (com.google.android.libraries.navigation.internal.nd.a.b(context)) {
                        jLongValue = 0;
                    } else {
                        if (v.c == null) {
                            if (context != null) {
                                if (v.b == null) {
                                    v.b = Boolean.valueOf(com.google.android.libraries.navigation.internal.ln.d.b(context).a.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
                                }
                                v.c = v.b.booleanValue() ? Long.valueOf(com.google.android.libraries.navigation.internal.mh.c.b(context.getContentResolver())) : 0L;
                            } else {
                                jLongValue = 0;
                            }
                        }
                        jLongValue = v.c.longValue();
                    }
                    if (str2 == null || str2.isEmpty()) {
                        jA = n.a(ByteBuffer.allocate(8).putLong(jLongValue).array());
                    } else {
                        byte[] bytes = str2.getBytes(v.a);
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 8);
                        byteBufferAllocate.put(bytes);
                        byteBufferAllocate.putLong(jLongValue);
                        jA = n.a(byteBufferAllocate.array());
                    }
                    long j = pVar2.e;
                    Iterator it3 = it2;
                    long j2 = pVar2.f;
                    if (j >= 0 && j2 > 0) {
                        if ((jA >= 0 ? jA % j2 : (((Long.MAX_VALUE % j2) + 1) + ((jA & Long.MAX_VALUE) % j2)) % j2) >= j) {
                            i(ab.a);
                            return;
                        }
                    }
                    it2 = it3;
                } else {
                    if (this.k.b() == 1) {
                        i(new ab(0, "The event was not logged due to sampling."));
                        this.a.d(new a(Arrays.asList(new s(hVarB.h, 1006, 1))));
                        return;
                    }
                    if (this.k.a() != 0.0d) {
                        au auVar = this.k;
                        com.google.android.libraries.navigation.internal.afk.a aVar2 = ((com.google.android.libraries.navigation.internal.ky.n) hVarB).b;
                        double dA = auVar.a();
                        if (!aVar2.b.H()) {
                            aVar2.v();
                        }
                        com.google.android.libraries.navigation.internal.afk.b bVar2 = (com.google.android.libraries.navigation.internal.afk.b) aVar2.b;
                        bVar2.b |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                        bVar2.i = dA;
                    }
                    try {
                        com.google.android.libraries.navigation.internal.afk.a aVar3 = ((com.google.android.libraries.navigation.internal.ky.n) hVarB).b;
                        com.google.android.libraries.navigation.internal.ael.x xVarK = ((com.google.android.libraries.navigation.internal.ky.n) hVarB).m.k();
                        if (!aVar3.b.H()) {
                            aVar3.v();
                        }
                        com.google.android.libraries.navigation.internal.afk.b bVar3 = (com.google.android.libraries.navigation.internal.afk.b) aVar3.b;
                        bVar3.b |= 2048;
                        bVar3.f = xVarK;
                        com.google.android.libraries.navigation.internal.afk.b bVar4 = (com.google.android.libraries.navigation.internal.afk.b) ((com.google.android.libraries.navigation.internal.ky.n) hVarB).b.t();
                        com.google.android.libraries.navigation.internal.ky.e eVar = ((com.google.android.libraries.navigation.internal.ky.n) hVarB).a;
                        String str3 = ((com.google.android.libraries.navigation.internal.ky.o) eVar).i;
                        Context context2 = ((com.google.android.libraries.navigation.internal.ky.o) eVar).f;
                        int i4 = -1;
                        if (com.google.android.libraries.navigation.internal.ky.e.a == -1) {
                            synchronized (com.google.android.libraries.navigation.internal.ky.e.class) {
                                if (com.google.android.libraries.navigation.internal.ky.e.a == -1) {
                                    try {
                                        com.google.android.libraries.navigation.internal.ky.e.a = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode;
                                    } catch (PackageManager.NameNotFoundException unused) {
                                    }
                                }
                            }
                        }
                        int i5 = com.google.android.libraries.navigation.internal.ky.e.a;
                        String str4 = ((com.google.android.libraries.navigation.internal.ky.n) hVarB).h;
                        int iE = hVarB.e();
                        aw awVar = ((com.google.android.libraries.navigation.internal.ky.o) ((com.google.android.libraries.navigation.internal.ky.n) hVarB).a).j;
                        boolean zA = awVar.a(ax.ANDROID_ID);
                        boolean zEquals = awVar.equals(aw.b);
                        int i6 = iE - 1;
                        if (iE == 0) {
                            throw null;
                        }
                        if (awVar.equals(aw.a)) {
                            i2 = 0;
                        } else {
                            nn nnVarListIterator = awVar.d.listIterator();
                            while (nnVarListIterator.hasNext()) {
                                i4 &= ~((ax) nnVarListIterator.next()).e;
                            }
                            i2 = i4;
                        }
                        y yVar = new y(str3, i5, -1, null, zA, str4, zEquals, i6, null, false, i2);
                        byte[] bArrM = bVar4.m();
                        int[] iArrD = com.google.android.libraries.navigation.internal.ky.e.d(null);
                        int[] iArrD2 = com.google.android.libraries.navigation.internal.ky.e.d(((com.google.android.libraries.navigation.internal.ky.n) hVarB).d);
                        ArrayList arrayList3 = ((com.google.android.libraries.navigation.internal.ky.n) hVarB).e;
                        com.google.android.libraries.navigation.internal.ma.l[] lVarArr = arrayList3 != null ? (com.google.android.libraries.navigation.internal.ma.l[]) arrayList3.toArray(com.google.android.libraries.navigation.internal.ky.e.b) : null;
                        Set set = ((com.google.android.libraries.navigation.internal.ky.n) hVarB).g;
                        as asVar2 = new as(yVar, bVar4, bArrM, iArrD, null, iArrD2, lVarArr, true, set != null ? (String[]) set.toArray(com.google.android.libraries.navigation.internal.ky.e.c) : null, bVar4.e, null);
                        av avVar = ((com.google.android.libraries.navigation.internal.ky.n) hVarB).f478n;
                        if (avVar != null) {
                            com.google.android.libraries.navigation.internal.afk.b bVar5 = asVar2.l;
                            com.google.android.libraries.navigation.internal.yx.ar.q(bVar5);
                            avVar.a(bVar5.f);
                            asVar2.i = new w(true);
                        }
                        asVar = asVar2;
                        if (asVar == null) {
                            e(new ab(10, "MessageProducer"));
                            return;
                        }
                        try {
                            ((r) jVar.u()).f(new g(this), asVar);
                            com.google.android.libraries.navigation.internal.ky.d.c().booleanValue();
                            return;
                        } catch (RemoteException | RuntimeException e) {
                            if (e instanceof TransactionTooLargeException) {
                                this.a.d(new a(Arrays.asList(new s(asVar.a.f, 31004, 1))));
                            } else {
                                com.google.android.libraries.navigation.internal.ky.d.c().booleanValue();
                            }
                            throw e;
                        }
                    } catch (RuntimeException unused2) {
                    }
                }
            }
        } catch (RuntimeException unused3) {
            e(new ab(10, "EventModifier"));
        }
    }
}
