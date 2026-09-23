package com.google.android.libraries.navigation.internal.xe;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dz implements com.google.android.libraries.navigation.internal.fw.a {
    final /* synthetic */ ea a;
    final /* synthetic */ ef b;

    public dz(ea eaVar, ef efVar) {
        this.b = efVar;
        this.a = eaVar;
    }

    @Override // com.google.android.libraries.navigation.internal.fw.a
    public final void a() {
        boolean z;
        this.a.c(this.b, 0);
        com.google.android.libraries.navigation.internal.xf.b bVar = this.a.d;
        long jB = bVar.a.b(com.google.android.libraries.navigation.internal.iv.ab.bh, 0L);
        Instant instantF = bVar.b.f();
        boolean z2 = true;
        if (jB == 0) {
            z = true;
        } else {
            ZoneId zoneIdOf = ZoneId.of("America/Los_Angeles");
            LocalDateTime localDateTime = Instant.ofEpochMilli(jB).atZone(zoneIdOf).toLocalDateTime();
            LocalDateTime localDateTime2 = instantF.atZone(zoneIdOf).toLocalDateTime();
            boolean z3 = (localDateTime.getYear() == localDateTime2.getYear() && localDateTime.getMonth() == localDateTime2.getMonth()) ? false : true;
            z = z3 || localDateTime.getDayOfMonth() != localDateTime2.getDayOfMonth();
            z2 = z3;
        }
        final com.google.android.libraries.navigation.internal.xf.a aVar = new com.google.android.libraries.navigation.internal.xf.a(z, z2, instantF.toEpochMilli());
        this.a.d.a.r(com.google.android.libraries.navigation.internal.iv.ab.bh, aVar.c);
        final ea eaVar = this.a;
        eaVar.b.S().execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xe.dw
            @Override // java.lang.Runnable
            public final void run() {
                ea eaVar2 = eaVar;
                eaVar2.e.a(com.google.android.libraries.navigation.internal.zp.n.Da);
                com.google.android.libraries.navigation.internal.xf.a aVar2 = aVar;
                if (aVar2.a) {
                    eaVar2.e.a(com.google.android.libraries.navigation.internal.zp.n.Db);
                }
                if (aVar2.b) {
                    eaVar2.e.a(com.google.android.libraries.navigation.internal.zp.n.Dc);
                }
            }
        });
    }
}
