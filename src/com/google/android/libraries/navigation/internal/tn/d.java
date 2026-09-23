package com.google.android.libraries.navigation.internal.tn;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.hf.u;
import com.google.android.libraries.navigation.internal.yx.ar;
import j$.util.DesugarTimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.DateTimeZone;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private static final long[] c = {0};
    public final AtomicReference a = new AtomicReference();
    public final com.google.android.libraries.navigation.internal.wa.g b;
    private final com.google.android.libraries.navigation.internal.tp.d d;
    private final Service e;
    private final m f;
    private final bn g;
    private final com.google.android.libraries.navigation.internal.afo.a h;
    private final com.google.android.libraries.navigation.internal.mj.a i;
    private p j;
    private com.google.android.libraries.navigation.internal.tj.j k;
    private com.google.android.libraries.navigation.internal.bl.d.a l;
    private Bitmap m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.wa.c f601n;
    private final q o;

    public d(Intent intent, com.google.android.libraries.navigation.internal.tp.d dVar, Service service, com.google.android.libraries.navigation.internal.wa.c cVar, com.google.android.libraries.navigation.internal.wa.g gVar, m mVar, q qVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.mj.a aVar2, com.google.android.libraries.navigation.internal.tj.j jVar, com.google.android.libraries.navigation.internal.bl.d.a aVar3, Bitmap bitmap, bn bnVar) {
        this.d = dVar;
        this.e = service;
        this.f601n = cVar;
        this.b = gVar;
        this.f = mVar;
        this.i = aVar2;
        this.o = qVar;
        this.j = mVar.a(jVar);
        this.k = jVar;
        this.h = aVar;
        this.l = aVar3;
        this.m = bitmap;
        this.g = bnVar;
        ar.q(com.google.android.libraries.navigation.internal.xv.a.b(service, intent, com.google.android.libraries.navigation.internal.xv.a.a | 134217728));
    }

    private final String d(int i, CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence2)) {
            return this.e.getApplicationContext().getResources().getString(i, charSequence, charSequence2);
        }
        if (true == TextUtils.isEmpty(charSequence)) {
            charSequence = charSequence2;
        }
        return charSequence.toString();
    }

    private final String e() {
        b bVar = (b) this.j;
        CharSequence charSequence = bVar.d;
        CharSequence charSequence2 = bVar.c;
        CharSequence charSequence3 = bVar.g;
        return (TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(charSequence2) || TextUtils.isEmpty(charSequence3)) ? "" : this.e.getApplicationContext().getResources().getString(com.google.android.libraries.navigation.internal.dw.h.f, charSequence, charSequence2, charSequence3);
    }

    public final void a(boolean z, long j, boolean z2, PendingIntent pendingIntent) {
        c(z, z2, pendingIntent);
    }

    public final void c(boolean z, boolean z2, PendingIntent pendingIntent) {
        NotificationCompat.Builder localOnly = new NotificationCompat.Builder(this.e.getApplicationContext()).setSmallIcon(com.google.android.libraries.navigation.internal.dw.c.v).setOngoing(true).setLocalOnly(true);
        if (Build.VERSION.SDK_INT >= 28) {
            localOnly.setCategory("navigation");
        }
        if (pendingIntent != null) {
            localOnly.setContentIntent(pendingIntent);
        }
        localOnly.setPriority(2);
        localOnly.setGroup("navigation_status_notification_group");
        if (z) {
            localOnly.setVibrate(c);
        }
        localOnly.setOnlyAlertOnce(!z2);
        this.k.c();
        localOnly.setVisibility(1);
        if (Build.VERSION.SDK_INT >= 26) {
            b bVar = (b) this.j;
            CharSequence charSequence = bVar.j;
            CharSequence charSequence2 = bVar.k;
            localOnly.setContentTitle(charSequence);
            localOnly.setContentText(charSequence2);
            localOnly.setSubText(e());
            localOnly.setColor(this.f601n.a());
            localOnly.setColorized(true);
            Bitmap bitmap = this.m;
            if (bitmap != null) {
                localOnly.setLargeIcon(bitmap);
            }
            q.a(this.j, this.k.c());
            if (this.d.a(localOnly, z ? 1 : 0)) {
                this.b.c(localOnly.build());
                return;
            }
            return;
        }
        Notification notificationBuild = localOnly.build();
        com.google.android.libraries.navigation.internal.tp.i iVar = new com.google.android.libraries.navigation.internal.tp.i(this.e);
        int i = com.google.android.libraries.navigation.internal.dw.h.g;
        b bVar2 = (b) this.j;
        CharSequence charSequenceD = d(i, bVar2.j, bVar2.l);
        if (TextUtils.isEmpty(charSequenceD)) {
            charSequenceD = ((b) this.j).k;
        }
        iVar.a.setTextViewText(com.google.android.libraries.navigation.internal.dw.d.e, charSequenceD);
        int i2 = com.google.android.libraries.navigation.internal.dw.h.h;
        b bVar3 = (b) this.j;
        iVar.a.setTextViewText(com.google.android.libraries.navigation.internal.dw.d.f, d(i2, bVar3.a, bVar3.g));
        iVar.a(this.f601n.a());
        iVar.c(this.m);
        notificationBuild.contentView = iVar.a;
        com.google.android.libraries.navigation.internal.tp.g gVar = new com.google.android.libraries.navigation.internal.tp.g(this.e);
        gVar.a(((b) this.j).j);
        com.google.android.libraries.navigation.internal.tp.j.c(gVar.a, com.google.android.libraries.navigation.internal.dw.d.k, ((b) this.j).k);
        com.google.android.libraries.navigation.internal.tp.j.c(gVar.a, com.google.android.libraries.navigation.internal.dw.d.m, e());
        com.google.android.libraries.navigation.internal.tp.j.a(gVar.a, com.google.android.libraries.navigation.internal.dw.d.v, this.f601n.a());
        com.google.android.libraries.navigation.internal.tp.j.b(gVar.a, com.google.android.libraries.navigation.internal.dw.d.l, this.m);
        gVar.a.setViewVisibility(com.google.android.libraries.navigation.internal.dw.d.w, 8);
        gVar.a.setViewVisibility(com.google.android.libraries.navigation.internal.dw.d.u, 8);
        notificationBuild.bigContentView = gVar.a;
        com.google.android.libraries.navigation.internal.tp.h hVar = new com.google.android.libraries.navigation.internal.tp.h(this.e);
        hVar.a.setTextViewText(com.google.android.libraries.navigation.internal.dw.d.a, ((b) this.j).j);
        hVar.a.setTextViewText(com.google.android.libraries.navigation.internal.dw.d.b, ((b) this.j).l);
        com.google.android.libraries.navigation.internal.tp.j.a(hVar.a, com.google.android.libraries.navigation.internal.dw.d.c, this.f601n.a());
        com.google.android.libraries.navigation.internal.tp.j.b(hVar.a, com.google.android.libraries.navigation.internal.dw.d.d, this.m);
        notificationBuild.headsUpContentView = hVar.a;
        this.b.c(notificationBuild);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x008f  */
    /* JADX WARN: Code duplicated, block: B:38:0x00eb A[ORIG_RETURN, RETURN] */
    public final void b(com.google.android.libraries.navigation.internal.tj.j jVar, com.google.android.libraries.navigation.internal.bl.d.a aVar, Bitmap bitmap, boolean z, long j, boolean z2, PendingIntent pendingIntent) {
        DateTimeZone dateTimeZoneForID;
        com.google.android.libraries.navigation.internal.tj.j jVar2 = this.k;
        if (jVar.h == jVar2.h && com.google.android.libraries.navigation.internal.up.b.b(jVar) == com.google.android.libraries.navigation.internal.up.b.b(jVar2) && (!com.google.android.libraries.navigation.internal.up.b.b(jVar) || !com.google.android.libraries.navigation.internal.up.b.b(jVar2) || com.google.android.libraries.navigation.internal.up.b.a(jVar) == com.google.android.libraries.navigation.internal.up.b.a(jVar2))) {
            com.google.android.libraries.navigation.internal.se.b bVarC = jVar.c();
            com.google.android.libraries.navigation.internal.se.b bVarC2 = jVar2.c();
            bg bgVar = bVarC.b;
            if (bgVar.Y == bVarC2.b.Y) {
                int iC = bVarC.c();
                int iC2 = bVarC2.c();
                if (u.d(iC, iC2)) {
                    bm.a aVar2 = bgVar.O;
                    int i = bVarC.k;
                    int i2 = bVarC2.k;
                    com.google.android.libraries.navigation.internal.hf.c cVar = (com.google.android.libraries.navigation.internal.hf.c) this.h.a();
                    bm.a aVarB = cVar.b(aVar2);
                    com.google.android.libraries.navigation.internal.hf.i iVarA = cVar.a(i, aVarB, true);
                    com.google.android.libraries.navigation.internal.hf.i iVarA2 = cVar.a(i2, aVarB, true);
                    if (iVarA == null && iVarA2 == null) {
                        if (jVar.e() == jVar2.e()) {
                            dateTimeZoneForID = DateTimeZone.forID(DesugarTimeZone.getTimeZone(bgVar.M().getId()).getID());
                            if (u.a(((long) iC) + this.i.f().getEpochSecond(), dateTimeZoneForID).equals(u.a(((long) iC2) + this.i.f().getEpochSecond(), dateTimeZoneForID))) {
                                return;
                            }
                        }
                    } else if (iVarA != null && iVarA2 != null) {
                        if (((com.google.android.libraries.navigation.internal.hf.a) iVarA).a == ((com.google.android.libraries.navigation.internal.hf.a) iVarA2).a && iVarA.d().equals(iVarA2.d())) {
                            if (jVar.e() == jVar2.e() && bVarC.c == bVarC2.c) {
                                dateTimeZoneForID = DateTimeZone.forID(DesugarTimeZone.getTimeZone(bgVar.M().getId()).getID());
                                if (u.a(((long) iC) + this.i.f().getEpochSecond(), dateTimeZoneForID).equals(u.a(((long) iC2) + this.i.f().getEpochSecond(), dateTimeZoneForID))) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        p pVarA = this.f.a(jVar);
        if (pVarA.equals(this.j) && aVar == this.l) {
            return;
        }
        this.k = jVar;
        this.j = pVarA;
        this.l = aVar;
        this.m = bitmap;
        c(z, z2, pendingIntent);
    }
}
