package com.google.android.libraries.navigation.internal.nh;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.ky.n;
import com.google.android.libraries.navigation.internal.ky.p;
import com.google.android.libraries.navigation.internal.ld.ab;
import com.google.android.libraries.navigation.internal.ld.l;
import com.google.android.libraries.navigation.internal.me.ah;
import com.google.android.libraries.navigation.internal.me.w;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements p {
    private final fd a;

    public e(fd fdVar) {
        this.a = fdVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ky.p
    public final w a(n nVar) {
        if (!this.a.containsKey(nVar.h)) {
            return ah.a(new l(ab.c));
        }
        Transport transport = (Transport) this.a.get(nVar.h);
        cy cyVar = nVar.m;
        ar.b(true, "LogEventBuilder must have a valid payload");
        transport.schedule(Event.ofData(cyVar.k()), new TransportScheduleCallback() { // from class: com.google.android.libraries.navigation.internal.nh.d
            @Override // com.google.android.datatransport.TransportScheduleCallback
            public final void onSchedule(Exception exc) {
            }
        });
        return ah.b(null);
    }
}
