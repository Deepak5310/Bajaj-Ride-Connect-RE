package com.google.android.libraries.navigation.internal.fr;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Process;
import com.google.android.libraries.navigation.internal.acd.ml;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.cg;
import com.google.android.libraries.navigation.internal.afl.t;
import com.google.android.libraries.navigation.internal.db.as;
import com.google.android.libraries.navigation.internal.km.v;
import com.google.android.libraries.navigation.internal.yx.ao;
import com.google.android.libraries.navigation.internal.yz.cz;
import com.google.android.libraries.navigation.internal.zr.ak;
import com.google.android.libraries.navigation.internal.zr.am;
import com.google.android.libraries.navigation.internal.zr.ba;
import com.google.android.libraries.navigation.internal.zr.be;
import com.google.android.libraries.navigation.internal.zr.df;
import com.google.android.libraries.navigation.internal.zr.dg;
import com.google.android.libraries.navigation.internal.zr.s;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements e {
    private static final long a = TrafficStats.getUidRxBytes(Process.myUid());
    private static final long b = TrafficStats.getUidTxBytes(Process.myUid());
    private static final SimpleDateFormat c = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    private final Context d;
    private final com.google.android.libraries.navigation.internal.mj.a e;
    private final l f;
    private final com.google.android.libraries.navigation.internal.afo.a g;
    private final com.google.android.libraries.navigation.internal.kl.a h;
    private final int k;
    private final IntentFilter m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final o f432n;
    private com.google.android.libraries.navigation.internal.cy.f o;
    private final cz q;
    private final com.google.android.libraries.navigation.internal.kc.a s;
    private long i = 0;
    private long j = 0;
    private int r = 1;
    private c l = new c(false, 0, 6);
    private int p = 0;

    public h(Context context, com.google.android.libraries.navigation.internal.mj.a aVar, l lVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.kc.a aVar3, com.google.android.libraries.navigation.internal.kl.a aVar4) {
        this.d = context;
        this.e = aVar;
        this.f = lVar;
        this.g = aVar2;
        this.s = aVar3;
        this.h = aVar4;
        this.k = context.getApplicationInfo().uid;
        new b(this);
        new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION);
        this.f432n = new o();
        new r(this);
        IntentFilter intentFilter = new IntentFilter();
        this.m = intentFilter;
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        this.o = null;
        this.q = new cz(10);
    }

    @Override // com.google.android.libraries.navigation.internal.fr.e
    public final l a() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.fr.e
    public final void c(as asVar, long j) {
        this.f432n.f(asVar, j);
    }

    @Override // com.google.android.libraries.navigation.internal.fr.e
    public final void d(com.google.android.libraries.navigation.internal.cy.f fVar) {
        this.o = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.fr.e
    public final synchronized void e(com.google.android.libraries.navigation.internal.afl.l lVar, be beVar) {
        int iA;
        bb bbVar = (bb) beVar.aH(5, null);
        bbVar.x(beVar);
        com.google.android.libraries.navigation.internal.zr.bb bbVar2 = (com.google.android.libraries.navigation.internal.zr.bb) bbVar;
        if (this.f432n.g()) {
            ak akVarB = this.f432n.b();
            if (!bbVar2.b.H()) {
                bbVar2.v();
            }
            be beVar2 = (be) bbVar2.b;
            be beVar3 = be.a;
            akVarB.getClass();
            beVar2.f = akVarB;
            beVar2.b |= 8;
            ak akVarC = this.f432n.c();
            if (!bbVar2.b.H()) {
                bbVar2.v();
            }
            be beVar4 = (be) bbVar2.b;
            akVarC.getClass();
            beVar4.g = akVarC;
            beVar4.b |= 16;
            am amVarD = this.f432n.d();
            if (!bbVar2.b.H()) {
                bbVar2.v();
            }
            be beVar5 = (be) bbVar2.b;
            amVarD.getClass();
            beVar5.h = amVarD;
            beVar5.b |= 32;
            float fA = this.f432n.a();
            if (!bbVar2.b.H()) {
                bbVar2.v();
            }
            be beVar6 = (be) bbVar2.b;
            beVar6.b |= 64;
            beVar6.i = fA;
            this.f432n.e();
        }
        com.google.android.libraries.navigation.internal.cy.f fVar = this.o;
        int iB = -1;
        if (fVar != null) {
            int i = fVar.a;
            if (i == -1 || (iA = ba.a(i)) == 0) {
                iA = ba.e;
            }
            if (!bbVar2.b.H()) {
                bbVar2.v();
            }
            be beVar7 = (be) bbVar2.b;
            be beVar8 = be.a;
            int i2 = iA - 1;
            if (iA == 0) {
                throw null;
            }
            beVar7.j = i2;
            beVar7.b |= 128;
        } else {
            int i3 = ba.e;
            if (!bbVar2.b.H()) {
                bbVar2.v();
            }
            be beVar9 = (be) bbVar2.b;
            be beVar10 = be.a;
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            beVar9.j = i4;
            beVar9.b |= 128;
        }
        try {
            iB = this.f.c.b();
        } catch (SecurityException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(513)).p("Failed to read from GServices. Missing READ_GSERVICES permission?");
        }
        if (iB >= 0) {
            if (!bbVar2.b.H()) {
                bbVar2.v();
            }
            be beVar11 = (be) bbVar2.b;
            beVar11.b |= 2048;
            beVar11.k = iB;
        }
        List listH = this.f.h();
        if (!bbVar2.b.H()) {
            bbVar2.v();
        }
        be beVar12 = (be) bbVar2.b;
        bz bzVar = beVar12.l;
        if (!bzVar.c()) {
            beVar12.l = bi.A(bzVar);
        }
        com.google.android.libraries.navigation.internal.mj.a aVar = this.e;
        com.google.android.libraries.navigation.internal.kc.a aVar2 = this.s;
        com.google.android.libraries.navigation.internal.ael.b.m(listH, beVar12.l);
        aVar2.a(new com.google.android.libraries.navigation.internal.ke.d(aVar, lVar, null, null, (be) bbVar2.t()));
    }

    @Override // com.google.android.libraries.navigation.internal.fr.e
    public final synchronized void f(int i) {
        if (i != this.p) {
            com.google.android.libraries.navigation.internal.kl.a aVar = this.h;
            v vVar = v.AUTO_PAN_MODE_ENABLED;
            aVar.l();
            this.p = i;
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x0179 A[Catch: all -> 0x01c8, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x000b, B:14:0x0029, B:16:0x0036, B:18:0x0040, B:19:0x0043, B:21:0x004b, B:34:0x0083, B:36:0x008e, B:37:0x0091, B:40:0x00a1, B:42:0x00ac, B:43:0x00af, B:44:0x00bb, B:46:0x00d2, B:47:0x00d5, B:49:0x00f7, B:50:0x00fa, B:52:0x011c, B:53:0x011f, B:55:0x0144, B:56:0x0147, B:58:0x0168, B:59:0x016b, B:61:0x0179, B:63:0x0182, B:64:0x0189, B:66:0x0191, B:22:0x0054, B:23:0x0055, B:26:0x0060, B:28:0x0064, B:30:0x006c, B:31:0x006f, B:13:0x0025, B:9:0x001d), top: B:74:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0182 A[Catch: all -> 0x01c8, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x000b, B:14:0x0029, B:16:0x0036, B:18:0x0040, B:19:0x0043, B:21:0x004b, B:34:0x0083, B:36:0x008e, B:37:0x0091, B:40:0x00a1, B:42:0x00ac, B:43:0x00af, B:44:0x00bb, B:46:0x00d2, B:47:0x00d5, B:49:0x00f7, B:50:0x00fa, B:52:0x011c, B:53:0x011f, B:55:0x0144, B:56:0x0147, B:58:0x0168, B:59:0x016b, B:61:0x0179, B:63:0x0182, B:64:0x0189, B:66:0x0191, B:22:0x0054, B:23:0x0055, B:26:0x0060, B:28:0x0064, B:30:0x006c, B:31:0x006f, B:13:0x0025, B:9:0x001d), top: B:74:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0191 A[Catch: all -> 0x01c8, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x000b, B:14:0x0029, B:16:0x0036, B:18:0x0040, B:19:0x0043, B:21:0x004b, B:34:0x0083, B:36:0x008e, B:37:0x0091, B:40:0x00a1, B:42:0x00ac, B:43:0x00af, B:44:0x00bb, B:46:0x00d2, B:47:0x00d5, B:49:0x00f7, B:50:0x00fa, B:52:0x011c, B:53:0x011f, B:55:0x0144, B:56:0x0147, B:58:0x0168, B:59:0x016b, B:61:0x0179, B:63:0x0182, B:64:0x0189, B:66:0x0191, B:22:0x0054, B:23:0x0055, B:26:0x0060, B:28:0x0064, B:30:0x006c, B:31:0x006f, B:13:0x0025, B:9:0x001d), top: B:74:0x0001 }] */
    @Override // com.google.android.libraries.navigation.internal.fr.e
    public final synchronized void g() {
        dg dgVar;
        c cVarA = this.f.a();
        if (cVarA != null) {
            int i = this.k;
            long uidRxBytes = TrafficStats.getUidRxBytes(i);
            long j = -1;
            long uidTxBytes = TrafficStats.getUidTxBytes(i);
            long j2 = uidRxBytes == -1 ? -1L : uidRxBytes - a;
            if (uidTxBytes != -1) {
                j = uidTxBytes - b;
            }
            df dfVar = (df) dg.a.q();
            if (cVarA.a) {
                c cVarA2 = this.f.a();
                if (cVarA2 == null) {
                    dfVar = null;
                } else {
                    int i2 = cVarA2.b;
                    if (i2 != 0) {
                        if (!dfVar.b.H()) {
                            dfVar.v();
                        }
                        dg dgVar2 = (dg) dfVar.b;
                        dgVar2.c = i2 - 1;
                        dgVar2.b |= 1;
                    }
                }
                if (dfVar != null) {
                    com.google.android.libraries.navigation.internal.kl.a aVar = this.h;
                    v vVar = v.AUTO_PAN_MODE_ENABLED;
                    aVar.l();
                }
                dgVar = dfVar != null ? (dg) dfVar.t() : null;
                if (!this.l.equals(cVarA)) {
                    this.s.a(new com.google.android.libraries.navigation.internal.ke.d(this.e, com.google.android.libraries.navigation.internal.afl.l.NETWORK_TYPE_CHANGED, null, dgVar, null));
                    this.q.add(new ao(c.format(new Date(this.e.f().toEpochMilli())), dgVar));
                    this.l = cVarA;
                }
            } else {
                int i3 = ml.b;
                if (!dfVar.b.H()) {
                    dfVar.v();
                }
                dg dgVar3 = (dg) dfVar.b;
                int i4 = i3 - 1;
                if (i3 == 0) {
                    throw null;
                }
                dgVar3.c = i4;
                dgVar3.b |= 1;
            }
            if (j2 >= 0) {
                int i5 = ((int) j2) / 1024;
                if (!dfVar.b.H()) {
                    dfVar.v();
                }
                dg dgVar4 = (dg) dfVar.b;
                dgVar4.b |= 128;
                dgVar4.d = i5;
            }
            if (j >= 0) {
                int i6 = ((int) j) / 1024;
                if (!dfVar.b.H()) {
                    dfVar.v();
                }
                dg dgVar5 = (dg) dfVar.b;
                dgVar5.b |= 256;
                dgVar5.e = i6;
            }
            long jA = ((com.google.android.libraries.navigation.internal.fw.v) this.g.a()).a() / 1024;
            if (!dfVar.b.H()) {
                dfVar.v();
            }
            dg dgVar6 = (dg) dfVar.b;
            dgVar6.b |= 512;
            dgVar6.f = (int) jA;
            long jB = ((com.google.android.libraries.navigation.internal.fw.v) this.g.a()).b() / 1024;
            if (!dfVar.b.H()) {
                dfVar.v();
            }
            dg dgVar7 = (dg) dfVar.b;
            dgVar7.b |= 1024;
            dgVar7.g = (int) jB;
            double dC = ((com.google.android.libraries.navigation.internal.fw.v) this.g.a()).c();
            if (!dfVar.b.H()) {
                dfVar.v();
            }
            dg dgVar8 = (dg) dfVar.b;
            dgVar8.b |= 2048;
            dgVar8.h = (int) (dC / 1024.0d);
            int iE = (int) ((com.google.android.libraries.navigation.internal.fw.v) this.g.a()).e();
            if (!dfVar.b.H()) {
                dfVar.v();
            }
            dg dgVar9 = (dg) dfVar.b;
            dgVar9.b |= 4096;
            dgVar9.i = iE;
            int iD = (int) ((com.google.android.libraries.navigation.internal.fw.v) this.g.a()).d();
            if (!dfVar.b.H()) {
                dfVar.v();
            }
            dg dgVar10 = (dg) dfVar.b;
            dgVar10.b |= 8192;
            dgVar10.j = iD;
            if (dfVar != null) {
                com.google.android.libraries.navigation.internal.kl.a aVar2 = this.h;
                v vVar2 = v.AUTO_PAN_MODE_ENABLED;
                aVar2.l();
            }
            if (dfVar != null) {
            }
            if (!this.l.equals(cVarA)) {
                this.s.a(new com.google.android.libraries.navigation.internal.ke.d(this.e, com.google.android.libraries.navigation.internal.afl.l.NETWORK_TYPE_CHANGED, null, dgVar, null));
                this.q.add(new ao(c.format(new Date(this.e.f().toEpochMilli())), dgVar));
                this.l = cVarA;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fr.e
    public final synchronized void h(int i) {
        int i2;
        if (i == this.r) {
            return;
        }
        Context context = this.d;
        com.google.android.libraries.navigation.internal.zr.r rVar = (com.google.android.libraries.navigation.internal.zr.r) s.a.q();
        Intent intentA = a.a(context);
        if (intentA != null) {
            int intExtra = (intentA.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0) * 100) / intentA.getIntExtra("scale", 1);
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar = (s) rVar.b;
            sVar.b |= 4;
            sVar.e = intExtra;
        }
        if (i == 3) {
            int i3 = t.b;
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar2 = (s) rVar.b;
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            sVar2.c = i4;
            sVar2.b |= 1;
            if (intentA != null) {
                int intExtra2 = intentA.getIntExtra("plugged", -1);
                if (intExtra2 == 1) {
                    i2 = cg.b;
                } else if (intExtra2 != 2) {
                    i2 = intExtra2 != 4 ? cg.a : cg.d;
                } else {
                    i2 = cg.c;
                }
                if (i2 == cg.a) {
                    i2 = cg.c;
                }
                if (!rVar.b.H()) {
                    rVar.v();
                }
                s sVar3 = (s) rVar.b;
                int i5 = i2 - 1;
                if (i2 == 0) {
                    throw null;
                }
                sVar3.d = i5;
                sVar3.b |= 2;
            }
        } else {
            int i6 = t.d;
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar4 = (s) rVar.b;
            int i7 = i6 - 1;
            if (i6 == 0) {
                throw null;
            }
            sVar4.c = i7;
            sVar4.b |= 1;
            int i8 = cg.a;
            if (!rVar.b.H()) {
                rVar.v();
            }
            s sVar5 = (s) rVar.b;
            int i9 = i8 - 1;
            if (i8 == 0) {
                throw null;
            }
            sVar5.d = i9;
            sVar5.b |= 2;
        }
        this.s.a(new com.google.android.libraries.navigation.internal.ke.d(this.e, com.google.android.libraries.navigation.internal.afl.l.CHARGING_STATE_CHANGED, (s) rVar.t(), null, null));
        this.r = i;
    }

    @Override // com.google.android.libraries.navigation.internal.fr.e
    public final void b(boolean z) {
        long j = this.i;
        if (z) {
            if (j == 0) {
                this.i = this.e.a();
            }
        } else {
            if (j != 0) {
                this.j = Math.max(this.j, this.e.a() - this.i);
            }
            this.i = 0L;
        }
    }
}
