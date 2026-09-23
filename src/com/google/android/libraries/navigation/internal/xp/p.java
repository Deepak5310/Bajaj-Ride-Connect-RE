package com.google.android.libraries.navigation.internal.xp;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.RemoteException;
import android.os.StrictMode;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.t;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.le.bb;
import com.google.android.libraries.navigation.internal.le.bd;
import com.google.android.libraries.navigation.internal.le.bi;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.android.libraries.navigation.internal.ma.al;
import com.google.android.libraries.navigation.internal.me.ae;
import com.google.android.libraries.navigation.internal.me.w;
import com.google.android.libraries.navigation.internal.xt.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements l {
    private final al a;

    public p(al alVar) {
        this.a = alVar;
    }

    private static bj g(w wVar) {
        final com.google.android.libraries.navigation.internal.wu.d dVar = new com.google.android.libraries.navigation.internal.wu.d(wVar, null);
        wVar.g(ac.INSTANCE, new com.google.android.libraries.navigation.internal.me.o() { // from class: com.google.android.libraries.navigation.internal.wu.c
            @Override // com.google.android.libraries.navigation.internal.me.o
            public final void a(w wVar2) {
                boolean z = ((ae) wVar2).d;
                d dVar2 = dVar;
                if (z) {
                    dVar2.cancel(false);
                    return;
                }
                if (wVar2.e()) {
                    dVar2.d(wVar2.d());
                    return;
                }
                Exception excC = wVar2.c();
                if (excC == null) {
                    throw new IllegalStateException();
                }
                dVar2.ap(excC);
            }
        });
        return com.google.android.libraries.navigation.internal.aac.c.i(dVar, com.google.android.libraries.navigation.internal.ld.l.class, new t() { // from class: com.google.android.libraries.navigation.internal.xp.o
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                com.google.android.libraries.navigation.internal.ld.l lVar = (com.google.android.libraries.navigation.internal.ld.l) obj;
                throw new m(lVar.a(), lVar.getMessage(), lVar);
            }
        }, ac.INSTANCE);
    }

    @Override // com.google.android.libraries.navigation.internal.xp.l
    public final bj a(String str) {
        ar.q(str);
        return g(this.a.a(str));
    }

    @Override // com.google.android.libraries.navigation.internal.xp.l
    public final bj b(final f fVar) {
        ar.q(fVar);
        bi biVar = new bi();
        biVar.a = new bd() { // from class: com.google.android.libraries.navigation.internal.ma.ag
            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj, Object obj2) throws RemoteException {
                int i = al.a;
                ((com.google.android.libraries.navigation.internal.mb.h) ((com.google.android.libraries.navigation.internal.mb.i) obj).u()).f(new ak((com.google.android.libraries.navigation.internal.me.aa) obj2), fVar.m());
            }
        };
        biVar.b = new com.google.android.libraries.navigation.internal.lc.d[]{com.google.android.libraries.navigation.internal.ma.n.a};
        biVar.b();
        com.google.android.libraries.navigation.internal.le.bj bjVarA = biVar.a();
        final al alVar = this.a;
        return g(alVar.g(bjVarA).b(ac.INSTANCE, new com.google.android.libraries.navigation.internal.me.e() { // from class: com.google.android.libraries.navigation.internal.ma.af
            @Override // com.google.android.libraries.navigation.internal.me.e
            public final Object a(com.google.android.libraries.navigation.internal.me.w wVar) {
                boolean z = wVar.c() instanceof com.google.android.libraries.navigation.internal.ld.ae;
                al alVar2 = alVar;
                com.google.android.libraries.navigation.internal.xp.f fVar2 = fVar;
                if (z) {
                    return alVar2.a(fVar2.c);
                }
                if (!(wVar.c() instanceof com.google.android.libraries.navigation.internal.ld.l)) {
                    return wVar;
                }
                com.google.android.libraries.navigation.internal.ld.l lVar = (com.google.android.libraries.navigation.internal.ld.l) wVar.c();
                ar.q(lVar);
                return lVar.a() == 29514 ? alVar2.a(fVar2.c) : wVar;
            }
        }));
    }

    @Override // com.google.android.libraries.navigation.internal.xp.l
    public final bj c(final String str, String str2) {
        ar.q(str);
        final String str3 = "";
        ar.q("");
        bi biVar = new bi();
        biVar.a = new bd(str, str3) { // from class: com.google.android.libraries.navigation.internal.ma.z
            public final /* synthetic */ String a;
            public final /* synthetic */ String b = "";

            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj, Object obj2) throws RemoteException {
                int i = al.a;
                ((com.google.android.libraries.navigation.internal.mb.h) ((com.google.android.libraries.navigation.internal.mb.i) obj).u()).i(new ak((com.google.android.libraries.navigation.internal.me.aa) obj2), this.a, this.b);
            }
        };
        return g(this.a.g(biVar.a()).a(ac.INSTANCE, new com.google.android.libraries.navigation.internal.me.e() { // from class: com.google.android.libraries.navigation.internal.xp.n
            @Override // com.google.android.libraries.navigation.internal.me.e
            public final Object a(w wVar) {
                int i;
                k kVar;
                com.google.android.libraries.navigation.internal.ma.c cVar = (com.google.android.libraries.navigation.internal.ma.c) wVar.d();
                g gVar = (g) h.a.q();
                String str4 = cVar.a;
                if (!gVar.b.H()) {
                    gVar.v();
                }
                h hVar = (h) gVar.b;
                str4.getClass();
                hVar.b |= 1;
                hVar.c = str4;
                String str5 = cVar.c;
                if (!gVar.b.H()) {
                    gVar.v();
                }
                h hVar2 = (h) gVar.b;
                str5.getClass();
                hVar2.b |= 4;
                hVar2.e = str5;
                boolean z = cVar.f;
                if (!gVar.b.H()) {
                    gVar.v();
                }
                h hVar3 = (h) gVar.b;
                hVar3.b |= 8;
                hVar3.h = z;
                long j = cVar.g;
                if (!gVar.b.H()) {
                    gVar.v();
                }
                h hVar4 = (h) gVar.b;
                hVar4.b |= 16;
                hVar4.i = j;
                byte[] bArr = cVar.b;
                int i2 = 2;
                if (bArr != null) {
                    x xVarT = x.t(bArr);
                    if (!gVar.b.H()) {
                        gVar.v();
                    }
                    h hVar5 = (h) gVar.b;
                    hVar5.b |= 2;
                    hVar5.d = xVarT;
                }
                com.google.android.libraries.navigation.internal.ma.a[] aVarArr = cVar.d;
                int length = aVarArr.length;
                int i3 = 0;
                while (i3 < length) {
                    com.google.android.libraries.navigation.internal.ma.a aVar = aVarArr[i3];
                    com.google.android.libraries.navigation.internal.ma.o[] oVarArr = aVar.b;
                    int length2 = oVarArr.length;
                    int i4 = 0;
                    while (i4 < length2) {
                        com.google.android.libraries.navigation.internal.ma.o oVar = oVarArr[i4];
                        int i5 = oVar.g;
                        if (i5 == 1) {
                            i = i2;
                            i iVar = (i) k.a.q();
                            String str6 = oVar.a;
                            if (!iVar.b.H()) {
                                iVar.v();
                            }
                            k kVar2 = (k) iVar.b;
                            str6.getClass();
                            kVar2.b |= 1;
                            kVar2.e = str6;
                            if (oVar.g != 1) {
                                throw new IllegalArgumentException("Not a long type");
                            }
                            long j2 = oVar.b;
                            if (!iVar.b.H()) {
                                iVar.v();
                            }
                            k kVar3 = (k) iVar.b;
                            kVar3.c = 1;
                            kVar3.d = Long.valueOf(j2);
                            kVar = (k) iVar.t();
                        } else if (i5 != i2) {
                            if (i5 == 3) {
                                i iVar2 = (i) k.a.q();
                                String str7 = oVar.a;
                                if (!iVar2.b.H()) {
                                    iVar2.v();
                                }
                                k kVar4 = (k) iVar2.b;
                                str7.getClass();
                                kVar4.b |= 1;
                                kVar4.e = str7;
                                if (oVar.g != 3) {
                                    throw new IllegalArgumentException("Not a double type");
                                }
                                double d = oVar.d;
                                if (!iVar2.b.H()) {
                                    iVar2.v();
                                }
                                k kVar5 = (k) iVar2.b;
                                kVar5.c = 3;
                                kVar5.d = Double.valueOf(d);
                                kVar = (k) iVar2.t();
                            } else if (i5 == 4) {
                                i iVar3 = (i) k.a.q();
                                String str8 = oVar.a;
                                if (!iVar3.b.H()) {
                                    iVar3.v();
                                }
                                k kVar6 = (k) iVar3.b;
                                str8.getClass();
                                kVar6.b |= 1;
                                kVar6.e = str8;
                                if (oVar.g != 4) {
                                    throw new IllegalArgumentException("Not a String type");
                                }
                                String str9 = oVar.e;
                                be.j(str9);
                                if (!iVar3.b.H()) {
                                    iVar3.v();
                                }
                                k kVar7 = (k) iVar3.b;
                                kVar7.c = 4;
                                kVar7.d = str9;
                                kVar = (k) iVar3.t();
                            } else {
                                if (i5 != 5) {
                                    throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.b(i5, "Unrecognized flag type: "));
                                }
                                i iVar4 = (i) k.a.q();
                                String str10 = oVar.a;
                                if (!iVar4.b.H()) {
                                    iVar4.v();
                                }
                                k kVar8 = (k) iVar4.b;
                                str10.getClass();
                                kVar8.b |= 1;
                                kVar8.e = str10;
                                if (oVar.g != 5) {
                                    throw new IllegalArgumentException("Not a bytes type");
                                }
                                byte[] bArr2 = oVar.f;
                                be.j(bArr2);
                                x xVarT2 = x.t(bArr2);
                                if (!iVar4.b.H()) {
                                    iVar4.v();
                                }
                                k kVar9 = (k) iVar4.b;
                                kVar9.c = 5;
                                kVar9.d = xVarT2;
                                kVar = (k) iVar4.t();
                            }
                            i = 2;
                        } else {
                            i iVar5 = (i) k.a.q();
                            String str11 = oVar.a;
                            if (!iVar5.b.H()) {
                                iVar5.v();
                            }
                            k kVar10 = (k) iVar5.b;
                            str11.getClass();
                            kVar10.b |= 1;
                            kVar10.e = str11;
                            i = 2;
                            if (oVar.g != 2) {
                                throw new IllegalArgumentException("Not a boolean type");
                            }
                            boolean z2 = oVar.c;
                            if (!iVar5.b.H()) {
                                iVar5.v();
                            }
                            k kVar11 = (k) iVar5.b;
                            kVar11.c = 2;
                            kVar11.d = Boolean.valueOf(z2);
                            kVar = (k) iVar5.t();
                        }
                        if (!gVar.b.H()) {
                            gVar.v();
                        }
                        h hVar6 = (h) gVar.b;
                        kVar.getClass();
                        bz bzVar = hVar6.f;
                        if (!bzVar.c()) {
                            hVar6.f = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                        }
                        hVar6.f.add(kVar);
                        i4++;
                        i2 = i;
                    }
                    int i6 = i2;
                    String[] strArr = aVar.c;
                    if (strArr != null) {
                        for (String str12 : strArr) {
                            if (!gVar.b.H()) {
                                gVar.v();
                            }
                            h hVar7 = (h) gVar.b;
                            str12.getClass();
                            bz bzVar2 = hVar7.g;
                            if (!bzVar2.c()) {
                                hVar7.g = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar2);
                            }
                            hVar7.g.add(str12);
                        }
                    }
                    i3++;
                    i2 = i6;
                }
                return (h) gVar.t();
            }
        }));
    }

    @Override // com.google.android.libraries.navigation.internal.xp.l
    public final bj d() {
        bi biVar = new bi();
        final al alVar = this.a;
        biVar.a = new bd() { // from class: com.google.android.libraries.navigation.internal.ma.y
            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj, Object obj2) throws RemoteException {
                int i = al.a;
                ((com.google.android.libraries.navigation.internal.mb.h) ((com.google.android.libraries.navigation.internal.mb.i) obj).u()).g(new ah((com.google.android.libraries.navigation.internal.me.aa) obj2));
            }
        };
        biVar.b = new com.google.android.libraries.navigation.internal.lc.d[]{com.google.android.libraries.navigation.internal.ma.n.i};
        biVar.b();
        return g(alVar.g(biVar.a()));
    }

    @Override // com.google.android.libraries.navigation.internal.xp.l
    public final bj e(aq aqVar) throws Throwable {
        final String str;
        BufferedReader bufferedReader;
        final al alVar = this.a;
        final com.google.android.libraries.navigation.internal.le.aq aqVarB = com.google.android.libraries.navigation.internal.le.ar.b(aqVar, alVar.h, ContextChain.TAG_INFRA);
        if (com.google.android.libraries.navigation.internal.ll.j.a == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                com.google.android.libraries.navigation.internal.ll.j.a = Application.getProcessName();
            } else {
                int iMyPid = com.google.android.libraries.navigation.internal.ll.j.b;
                if (iMyPid == 0) {
                    iMyPid = Process.myPid();
                    com.google.android.libraries.navigation.internal.ll.j.b = iMyPid;
                }
                String strTrim = null;
                strTrim = null;
                strTrim = null;
                BufferedReader bufferedReader2 = null;
                if (iMyPid > 0) {
                    try {
                        String strJ = com.google.android.libraries.navigation.internal.b.b.j(iMyPid, "/proc/", "/cmdline");
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            bufferedReader = new BufferedReader(new FileReader(strJ));
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            try {
                                String line = bufferedReader.readLine();
                                be.j(line);
                                strTrim = line.trim();
                            } catch (IOException unused) {
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader;
                                com.google.android.libraries.navigation.internal.ll.h.a(bufferedReader2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            throw th2;
                        }
                    } catch (IOException unused2) {
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    com.google.android.libraries.navigation.internal.ll.h.a(bufferedReader);
                }
                com.google.android.libraries.navigation.internal.ll.j.a = strTrim;
            }
        }
        String str2 = com.google.android.libraries.navigation.internal.ll.j.a;
        if (str2 == null) {
            str = "__PH_INTERNAL__NO_PROCESS__";
        } else {
            str = str2 + "|" + System.identityHashCode(com.google.android.libraries.navigation.internal.mb.i.class);
        }
        bd bdVar = new bd() { // from class: com.google.android.libraries.navigation.internal.ma.aa
            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj, Object obj2) throws RemoteException {
                int i = al.a;
                ((com.google.android.libraries.navigation.internal.mb.h) ((com.google.android.libraries.navigation.internal.mb.i) obj).u()).h(str, new aj(aqVarB));
            }
        };
        bd bdVar2 = new bd() { // from class: com.google.android.libraries.navigation.internal.ma.ab
            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj, Object obj2) {
                int i = al.a;
            }
        };
        bb bbVar = new bb();
        bbVar.c = aqVarB;
        bbVar.a = bdVar;
        bbVar.b = bdVar2;
        bbVar.d = new com.google.android.libraries.navigation.internal.lc.d[]{com.google.android.libraries.navigation.internal.ma.n.d};
        bbVar.e = false;
        return g(alVar.h(bbVar.a()));
    }

    @Override // com.google.android.libraries.navigation.internal.xp.l
    public final bj f(String str, int i, String[] strArr) {
        ar.q(str);
        return g(this.a.b(str, i, strArr));
    }
}
