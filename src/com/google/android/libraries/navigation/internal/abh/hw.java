package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.datatransport.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hw implements Runnable {
    public final List a = new ArrayList();
    public boolean b;
    public final Executor c;
    public int d;
    private final hu e;
    private com.google.android.libraries.navigation.internal.zp.ay f;
    private final hv g;
    private final hr h;

    public hw(hu huVar, hr hrVar, Executor executor, hv hvVar) {
        new ArrayList();
        this.b = false;
        com.google.android.libraries.navigation.internal.abf.s.a(true, "Delay cannot be 0");
        this.e = huVar;
        this.h = hrVar;
        this.c = executor;
        this.g = hvVar;
    }

    /* JADX WARN: Code duplicated, block: B:159:0x0345  */
    /* JADX WARN: Code duplicated, block: B:76:0x0196  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ab  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        int size;
        com.google.android.libraries.navigation.internal.abx.b[] bVarArr;
        int i;
        int i2;
        com.google.android.libraries.navigation.internal.zp.ay ayVar;
        int i3;
        try {
            Thread.sleep(2000L);
            if (this.f == null) {
                hq hqVar = (hq) this.e;
                Context context = hqVar.a;
                String str = ht.a;
                com.google.android.libraries.navigation.internal.lc.al alVarA = com.google.android.libraries.navigation.internal.lc.al.a(context);
                com.google.android.libraries.navigation.internal.lc.h hVar = com.google.android.libraries.navigation.internal.lc.h.a;
                com.google.android.libraries.navigation.internal.zp.ar arVar = (com.google.android.libraries.navigation.internal.zp.ar) com.google.android.libraries.navigation.internal.zp.ay.a.q();
                boolean zC = com.google.android.libraries.navigation.internal.afu.g.c();
                com.google.android.libraries.navigation.internal.wx.c cVar = hqVar.d;
                if (zC) {
                    try {
                        String str2 = (String) cVar.a().get();
                        if (!str2.isEmpty()) {
                            com.google.android.libraries.navigation.internal.aeu.a aVar = (com.google.android.libraries.navigation.internal.aeu.a) com.google.android.libraries.navigation.internal.aeu.b.a.q();
                            if (!aVar.b.H()) {
                                aVar.v();
                            }
                            com.google.android.libraries.navigation.internal.aeu.b bVar = (com.google.android.libraries.navigation.internal.aeu.b) aVar.b;
                            str2.getClass();
                            bVar.b |= 4;
                            bVar.c = str2;
                            if (!arVar.b.H()) {
                                arVar.v();
                            }
                            com.google.android.libraries.navigation.internal.zp.ay ayVar2 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                            com.google.android.libraries.navigation.internal.aeu.b bVar2 = (com.google.android.libraries.navigation.internal.aeu.b) aVar.t();
                            bVar2.getClass();
                            ayVar2.x = bVar2;
                            ayVar2.b |= 1073741824;
                        }
                    } catch (InterruptedException | ExecutionException unused) {
                        com.google.android.libraries.navigation.internal.abf.p.f(ht.a, 6);
                    }
                }
                if (!arVar.b.H()) {
                    arVar.v();
                }
                com.google.android.libraries.navigation.internal.zp.ay ayVar3 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                ayVar3.b |= 2;
                ayVar3.d = BuildConfig.VERSION_NAME;
                if (!arVar.b.H()) {
                    arVar.v();
                }
                ea eaVar = hqVar.e;
                com.google.android.libraries.navigation.internal.zp.ay ayVar4 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                ayVar4.b |= 1;
                ayVar4.c = 1;
                if (eaVar != null) {
                    String strA = eaVar.a();
                    if (!arVar.b.H()) {
                        arVar.v();
                    }
                    com.google.android.libraries.navigation.internal.zp.ay ayVar5 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                    strA.getClass();
                    ayVar5.b |= 4194304;
                    ayVar5.t = strA;
                }
                String str3 = hqVar.b;
                com.google.android.libraries.navigation.internal.afu.d.d();
                int iHashCode = str3.hashCode();
                if (iHashCode != 71) {
                    if (iHashCode != 72) {
                        if (iHashCode != 76) {
                            if (iHashCode == 80 && str3.equals("P")) {
                                int i4 = com.google.android.libraries.navigation.internal.zp.av.g;
                                if (!arVar.b.H()) {
                                    arVar.v();
                                }
                                com.google.android.libraries.navigation.internal.zp.ay ayVar6 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                                int i5 = i4 - 1;
                                if (i4 == 0) {
                                    throw null;
                                }
                                ayVar6.e = i5;
                                ayVar6.b |= 4;
                            } else {
                                i2 = com.google.android.libraries.navigation.internal.zp.av.a;
                                if (!arVar.b.H()) {
                                    arVar.v();
                                }
                                ayVar = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                                i3 = i2 - 1;
                                if (i2 != 0) {
                                    throw null;
                                }
                                ayVar.e = i3;
                                ayVar.b |= 4;
                            }
                        } else if (str3.equals("L")) {
                            int i6 = com.google.android.libraries.navigation.internal.zp.av.h;
                            if (!arVar.b.H()) {
                                arVar.v();
                            }
                            com.google.android.libraries.navigation.internal.zp.ay ayVar7 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                            int i7 = i6 - 1;
                            if (i6 == 0) {
                                throw null;
                            }
                            ayVar7.e = i7;
                            ayVar7.b |= 4;
                        } else {
                            i2 = com.google.android.libraries.navigation.internal.zp.av.a;
                            if (!arVar.b.H()) {
                                arVar.v();
                            }
                            ayVar = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                            i3 = i2 - 1;
                            if (i2 != 0) {
                                throw null;
                            }
                            ayVar.e = i3;
                            ayVar.b |= 4;
                        }
                    } else if (str3.equals("H")) {
                        int i8 = com.google.android.libraries.navigation.internal.zp.av.i;
                        if (!arVar.b.H()) {
                            arVar.v();
                        }
                        com.google.android.libraries.navigation.internal.zp.ay ayVar8 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                        int i9 = i8 - 1;
                        if (i8 == 0) {
                            throw null;
                        }
                        ayVar8.e = i9;
                        ayVar8.b |= 4;
                    } else {
                        i2 = com.google.android.libraries.navigation.internal.zp.av.a;
                        if (!arVar.b.H()) {
                            arVar.v();
                        }
                        ayVar = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                        i3 = i2 - 1;
                        if (i2 != 0) {
                            throw null;
                        }
                        ayVar.e = i3;
                        ayVar.b |= 4;
                    }
                } else if (str3.equals("G")) {
                    int i10 = com.google.android.libraries.navigation.internal.zp.av.b;
                    if (!arVar.b.H()) {
                        arVar.v();
                    }
                    com.google.android.libraries.navigation.internal.zp.ay ayVar9 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                    int i11 = i10 - 1;
                    if (i10 == 0) {
                        throw null;
                    }
                    ayVar9.e = i11;
                    ayVar9.b |= 4;
                } else {
                    i2 = com.google.android.libraries.navigation.internal.zp.av.a;
                    if (!arVar.b.H()) {
                        arVar.v();
                    }
                    ayVar = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                    i3 = i2 - 1;
                    if (i2 != 0) {
                        throw null;
                    }
                    ayVar.e = i3;
                    ayVar.b |= 4;
                }
                String packageName = context.getPackageName();
                PackageInfo packageInfoA = com.google.android.libraries.navigation.internal.abg.x.b.a(context, packageName);
                if (!arVar.b.H()) {
                    arVar.v();
                }
                com.google.android.libraries.navigation.internal.zp.ay ayVar10 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                packageName.getClass();
                ayVar10.b |= 8;
                ayVar10.f = packageName;
                int i12 = packageInfoA.versionCode;
                if (!arVar.b.H()) {
                    arVar.v();
                }
                com.google.android.libraries.navigation.internal.zp.ay ayVar11 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                ayVar11.b |= 16;
                ayVar11.g = i12;
                String strB = com.google.android.libraries.navigation.internal.abf.d.a.b(context, packageName);
                if (!arVar.b.H()) {
                    arVar.v();
                }
                com.google.android.libraries.navigation.internal.zp.ay ayVar12 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                ayVar12.b |= 256;
                ayVar12.j = strB;
                if (com.google.android.libraries.navigation.internal.abf.e.b) {
                    int i13 = com.google.android.libraries.navigation.internal.zp.at.d;
                    if (!arVar.b.H()) {
                        arVar.v();
                    }
                    com.google.android.libraries.navigation.internal.zp.ay ayVar13 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                    int i14 = i13 - 1;
                    if (i13 == 0) {
                        throw null;
                    }
                    ayVar13.k = i14;
                    ayVar13.b |= 512;
                } else if (com.google.android.libraries.navigation.internal.abf.e.a) {
                    int i15 = com.google.android.libraries.navigation.internal.zp.at.c;
                    if (!arVar.b.H()) {
                        arVar.v();
                    }
                    com.google.android.libraries.navigation.internal.zp.ay ayVar14 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                    int i16 = i15 - 1;
                    if (i15 == 0) {
                        throw null;
                    }
                    ayVar14.k = i16;
                    ayVar14.b |= 512;
                } else if (com.google.android.libraries.navigation.internal.afu.d.e() && com.google.android.libraries.navigation.internal.abf.e.c) {
                    int i17 = com.google.android.libraries.navigation.internal.zp.at.g;
                    if (!arVar.b.H()) {
                        arVar.v();
                    }
                    com.google.android.libraries.navigation.internal.zp.ay ayVar15 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                    int i18 = i17 - 1;
                    if (i17 == 0) {
                        throw null;
                    }
                    ayVar15.k = i18;
                    ayVar15.b |= 512;
                } else if (com.google.android.libraries.navigation.internal.afu.d.e() && com.google.android.libraries.navigation.internal.abf.e.d) {
                    int i19 = com.google.android.libraries.navigation.internal.zp.at.h;
                    if (!arVar.b.H()) {
                        arVar.v();
                    }
                    com.google.android.libraries.navigation.internal.zp.ay ayVar16 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                    int i20 = i19 - 1;
                    if (i19 == 0) {
                        throw null;
                    }
                    ayVar16.k = i20;
                    ayVar16.b |= 512;
                } else if (com.google.android.libraries.navigation.internal.afu.d.e() && com.google.android.libraries.navigation.internal.abf.e.e) {
                    int i21 = com.google.android.libraries.navigation.internal.zp.at.f;
                    if (!arVar.b.H()) {
                        arVar.v();
                    }
                    com.google.android.libraries.navigation.internal.zp.ay ayVar17 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                    int i22 = i21 - 1;
                    if (i21 == 0) {
                        throw null;
                    }
                    ayVar17.k = i22;
                    ayVar17.b |= 512;
                } else {
                    int i23 = com.google.android.libraries.navigation.internal.zp.at.b;
                    if (!arVar.b.H()) {
                        arVar.v();
                    }
                    com.google.android.libraries.navigation.internal.zp.ay ayVar18 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                    int i24 = i23 - 1;
                    if (i23 == 0) {
                        throw null;
                    }
                    ayVar18.k = i24;
                    ayVar18.b |= 512;
                }
                boolean zB = alVarA.b(packageName);
                if (!arVar.b.H()) {
                    arVar.v();
                }
                com.google.android.libraries.navigation.internal.zp.ay ayVar19 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                ayVar19.b |= 2048;
                ayVar19.l = zB;
                if (!arVar.b.H()) {
                    arVar.v();
                }
                com.google.android.libraries.navigation.internal.zp.ay ayVar20 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                ayVar20.b |= 32;
                ayVar20.h = 0;
                int iA = com.google.android.libraries.navigation.internal.lc.ak.a(context);
                if (!arVar.b.H()) {
                    arVar.v();
                }
                com.google.android.libraries.navigation.internal.zp.ay ayVar21 = (com.google.android.libraries.navigation.internal.zp.ay) arVar.b;
                ayVar21.b |= 64;
                ayVar21.i = iA;
                this.f = (com.google.android.libraries.navigation.internal.zp.ay) arVar.t();
            }
            synchronized (this) {
                size = this.a.size();
                bVarArr = new com.google.android.libraries.navigation.internal.abx.b[size];
                this.a.toArray(bVarArr);
                this.a.clear();
                i = this.d;
                this.d = 0;
                com.google.android.libraries.navigation.internal.afu.d.q();
                this.b = false;
            }
            if (i != 0) {
                com.google.android.libraries.navigation.internal.zp.bc bcVar = this.f.u;
                if (bcVar == null) {
                    bcVar = com.google.android.libraries.navigation.internal.zp.bc.a;
                }
                int iA2 = com.google.android.libraries.navigation.internal.zp.bb.a(bcVar.c);
                if (iA2 == 0) {
                    iA2 = com.google.android.libraries.navigation.internal.zp.bb.a;
                }
                if (iA2 != i) {
                    com.google.android.libraries.navigation.internal.zp.bc bcVar2 = this.f.u;
                    if (bcVar2 == null) {
                        bcVar2 = com.google.android.libraries.navigation.internal.zp.bc.a;
                    }
                    com.google.android.libraries.navigation.internal.zp.ay ayVar22 = this.f;
                    com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) ayVar22.aH(5, null);
                    bbVar.x(ayVar22);
                    com.google.android.libraries.navigation.internal.zp.ar arVar2 = (com.google.android.libraries.navigation.internal.zp.ar) bbVar;
                    com.google.android.libraries.navigation.internal.ael.bb bbVar2 = (com.google.android.libraries.navigation.internal.ael.bb) bcVar2.aH(5, null);
                    bbVar2.x(bcVar2);
                    com.google.android.libraries.navigation.internal.zp.az azVar = (com.google.android.libraries.navigation.internal.zp.az) bbVar2;
                    if (!azVar.b.H()) {
                        azVar.v();
                    }
                    com.google.android.libraries.navigation.internal.zp.bc bcVar3 = (com.google.android.libraries.navigation.internal.zp.bc) azVar.b;
                    bcVar3.c = i - 1;
                    bcVar3.b |= 8;
                    if (!arVar2.b.H()) {
                        arVar2.v();
                    }
                    com.google.android.libraries.navigation.internal.zp.ay ayVar23 = (com.google.android.libraries.navigation.internal.zp.ay) arVar2.b;
                    com.google.android.libraries.navigation.internal.zp.bc bcVar4 = (com.google.android.libraries.navigation.internal.zp.bc) azVar.t();
                    bcVar4.getClass();
                    ayVar23.u = bcVar4;
                    ayVar23.b |= 8388608;
                    this.f = (com.google.android.libraries.navigation.internal.zp.ay) arVar2.t();
                }
            }
            HashMap map = new HashMap();
            for (int i25 = 0; i25 < size; i25++) {
                com.google.android.libraries.navigation.internal.abx.b bVar3 = bVarArr[i25];
                com.google.android.libraries.navigation.internal.zp.ar arVar3 = (com.google.android.libraries.navigation.internal.zp.ar) map.get(bVar3);
                if (arVar3 != null) {
                    int i26 = ((com.google.android.libraries.navigation.internal.zp.ay) arVar3.b).c + 1;
                    if (!arVar3.b.H()) {
                        arVar3.v();
                    }
                    com.google.android.libraries.navigation.internal.zp.ay ayVar24 = (com.google.android.libraries.navigation.internal.zp.ay) arVar3.b;
                    ayVar24.b |= 1;
                    ayVar24.c = i26;
                } else {
                    com.google.android.libraries.navigation.internal.zp.ay ayVar25 = this.f;
                    com.google.android.libraries.navigation.internal.ael.bb bbVar3 = (com.google.android.libraries.navigation.internal.ael.bb) ayVar25.aH(5, null);
                    bbVar3.x(ayVar25);
                    com.google.android.libraries.navigation.internal.zp.ar arVar4 = (com.google.android.libraries.navigation.internal.zp.ar) bbVar3;
                    if (!arVar4.b.H()) {
                        arVar4.v();
                    }
                    com.google.android.libraries.navigation.internal.zp.ay ayVar26 = (com.google.android.libraries.navigation.internal.zp.ay) arVar4.b;
                    com.google.android.libraries.navigation.internal.zp.ay ayVar27 = com.google.android.libraries.navigation.internal.zp.ay.a;
                    ayVar26.m = bVar3.fX;
                    ayVar26.b |= 8192;
                    map.put(bVar3, arVar4);
                }
            }
            ArrayList<com.google.android.libraries.navigation.internal.zp.ay> arrayList = new ArrayList();
            Iterator it2 = map.values().iterator();
            while (it2.hasNext()) {
                arrayList.add((com.google.android.libraries.navigation.internal.zp.ay) ((com.google.android.libraries.navigation.internal.zp.ar) it2.next()).t());
            }
            com.google.android.libraries.navigation.internal.afu.d.q();
            hr hrVar = this.h;
            String str4 = ht.a;
            final com.google.android.libraries.navigation.internal.zp.aa aaVar = new com.google.android.libraries.navigation.internal.zp.aa();
            for (final com.google.android.libraries.navigation.internal.zp.ay ayVar28 : arrayList) {
                com.google.android.libraries.navigation.internal.me.w wVar = (com.google.android.libraries.navigation.internal.me.w) ht.b.get();
                if (ht.b != null) {
                    final com.google.android.libraries.navigation.internal.ky.o oVar = hrVar.b;
                    final Context context2 = hrVar.a;
                    wVar.j(new com.google.android.libraries.navigation.internal.me.u() { // from class: com.google.android.libraries.navigation.internal.abh.hp
                        @Override // com.google.android.libraries.navigation.internal.me.u
                        public final void d(Object obj) {
                            String str5 = ht.a;
                            if (!((com.google.android.libraries.navigation.internal.mf.o) obj).a()) {
                                com.google.android.libraries.navigation.internal.abf.p.f(ht.a, 4);
                                return;
                            }
                            com.google.android.libraries.navigation.internal.mn.c cVar2 = aaVar;
                            Context context3 = context2;
                            com.google.android.libraries.navigation.internal.zp.ay ayVar29 = ayVar28;
                            com.google.android.libraries.navigation.internal.ky.o oVar2 = oVar;
                            com.google.android.libraries.navigation.internal.mq.b bVar4 = new com.google.android.libraries.navigation.internal.mq.b(context3, new com.google.android.libraries.navigation.internal.mn.l(cVar2));
                            com.google.android.libraries.navigation.internal.lh.be.j(ayVar29);
                            com.google.android.libraries.navigation.internal.ky.n nVar = new com.google.android.libraries.navigation.internal.ky.n(oVar2, ayVar29);
                            nVar.f478n = bVar4;
                            nVar.c();
                            com.google.android.libraries.navigation.internal.abf.p.f(ht.a, 4);
                        }
                    });
                }
            }
        } catch (InterruptedException unused2) {
            synchronized (this) {
                this.b = false;
            }
        }
    }
}
