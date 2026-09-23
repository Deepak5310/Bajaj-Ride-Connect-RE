package com.google.android.libraries.navigation.internal.tk;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BuildCompat;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nt.t;
import com.google.android.libraries.navigation.internal.tj.u;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h implements t {
    final /* synthetic */ l a;

    public h(l lVar) {
        this.a = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        CharSequence charSequenceY;
        Drawable drawableA;
        CharSequence charSequenceSubSequence;
        u uVar = (u) mVar.c();
        if (uVar == null) {
            q qVar = this.a.c;
            ar.q(qVar);
            qVar.a();
            return;
        }
        l lVar = this.a;
        if (lVar.h) {
            return;
        }
        final q qVar2 = lVar.c;
        ar.q(qVar2);
        Context applicationContext = qVar2.d.getApplicationContext();
        com.google.android.libraries.navigation.internal.ut.d dVarA = qVar2.g.a(applicationContext, uVar, new com.google.android.libraries.navigation.internal.ut.d.a() { // from class: com.google.android.libraries.navigation.internal.tk.o
            @Override // com.google.android.libraries.navigation.internal.ut.d.a
            public final int a() {
                return qVar2.o;
            }
        }, true);
        if (dVarA == null) {
            qVar2.a();
            return;
        }
        dVarA.b();
        CharSequence charSequenceX = dVarA.x();
        if (charSequenceX == null) {
            qVar2.a();
            return;
        }
        NotificationCompat.Builder visibility = new NotificationCompat.Builder(qVar2.d.getApplicationContext()).setContentTitle(charSequenceX).setSmallIcon(com.google.android.libraries.navigation.internal.dw.c.m).setVisibility(1);
        Intent intent = qVar2.f600n.c;
        Bitmap bitmapB = null;
        NotificationCompat.Builder localOnly = visibility.setContentIntent(intent != null ? PendingIntent.getActivity(qVar2.d, 0, intent, q.b) : null).setVibrate(q.c).setPriority(1).setLocalOnly(true);
        if (dVarA.y() != null) {
            charSequenceY = dVarA.y();
            if (charSequenceY == null) {
                charSequenceSubSequence = null;
            } else {
                int iIndexOf = TextUtils.indexOf(charSequenceY, '\n');
                charSequenceSubSequence = iIndexOf < 0 ? charSequenceY : charSequenceY.subSequence(0, iIndexOf);
            }
            localOnly.setContentText(charSequenceSubSequence).setStyle(new NotificationCompat.BigTextStyle().bigText(charSequenceY));
        } else {
            charSequenceY = null;
        }
        if (dVarA instanceof com.google.android.libraries.navigation.internal.ut.a) {
            com.google.android.libraries.navigation.internal.ut.a aVar = (com.google.android.libraries.navigation.internal.ut.a) dVarA;
            com.google.android.libraries.navigation.internal.ut.d.b bVarE = aVar.e();
            com.google.android.libraries.navigation.internal.ut.d.b bVarO = aVar.o();
            if (bVarE != null && bVarO != null) {
                localOnly.addAction(com.google.android.libraries.navigation.internal.f.d.h, bVarO.i().b(applicationContext).toString(), qVar2.j);
                localOnly.addAction(com.google.android.libraries.navigation.internal.f.d.f, bVarE.i().b(applicationContext).toString(), qVar2.i);
            }
        }
        ah ahVarK = dVarA.k();
        if (ahVarK != null && (drawableA = ahVarK.a(applicationContext)) != null) {
            int iE = com.google.android.libraries.navigation.internal.tn.m.a.e(qVar2.e.b);
            bitmapB = com.google.android.libraries.navigation.internal.gw.f.b(drawableA, iE, iE, Bitmap.Config.ARGB_8888);
            localOnly.setLargeIcon(bitmapB);
        }
        com.google.android.libraries.navigation.internal.e.a aVar2 = new com.google.android.libraries.navigation.internal.e.a();
        aVar2.a = charSequenceX;
        aVar2.b = charSequenceY == null ? "" : charSequenceY.toString();
        aVar2.c = bitmapB;
        com.google.android.libraries.navigation.internal.aq.m mVar2 = qVar2.h;
        int i = com.google.android.libraries.navigation.internal.adu.m.NAVIGATION_PROMPTS.eU;
        mVar2.b();
        qVar2.p = dVarA;
        if (BuildCompat.isAtLeastO()) {
            qVar2.l.a();
            com.google.android.libraries.navigation.internal.ee.u uVarA = qVar2.m.a(com.google.android.libraries.navigation.internal.adu.m.NAVIGATION_PROMPTS.eU);
            if (uVarA == null) {
                return;
            }
            String strC = uVarA.a().c(1);
            if (strC != null) {
                localOnly.setChannelId(strC);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) q.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1824)).p("ChannelId for the prompt notification type should be non null.");
                localOnly.setChannelId("OtherChannel");
            }
        }
        qVar2.f.notify(com.google.android.libraries.navigation.internal.adu.m.NAVIGATION_PROMPTS.eU, localOnly.build());
    }
}
