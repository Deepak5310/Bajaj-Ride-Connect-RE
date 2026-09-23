package com.google.android.libraries.navigation.internal.xe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.io.File;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f extends BroadcastReceiver {
    final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0037  */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        byte b;
        com.google.android.libraries.navigation.internal.ia.a aVar;
        switch (intent.getAction()) {
            case "com.google.android.libraries.navigation.EVENT_TRACK_STOP_RECORDING":
                b = 2;
                break;
            case "com.google.android.libraries.navigation.EVENT_TRACK_START_RECORDING":
                b = 1;
                break;
            case "com.google.android.libraries.navigation.EVENT_TRACK_HANDSHAKE_DRIVER":
                b = 0;
                break;
            case "com.google.android.libraries.navigation.EVENT_TRACK_COLLECT_DUMP":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            this.a.e = true;
            g gVar = this.a;
            gVar.b.sendBroadcast(gVar.b("com.google.android.libraries.navigation.EVENT_TRACK_HANDSHAKE_NAV"));
            return;
        }
        if (b == 1) {
            int intExtra = intent.getIntExtra("RECORDING_LIMIT_EXTRA", 1);
            if (intExtra != 2) {
                aVar = intExtra != 3 ? com.google.android.libraries.navigation.internal.ia.a.DEFAULT : com.google.android.libraries.navigation.internal.ia.a.HUGE;
            } else {
                aVar = com.google.android.libraries.navigation.internal.ia.a.SMALL;
            }
            this.a.a.d(aVar);
            this.a.a.g(3);
            return;
        }
        if (b == 2) {
            this.a.a.g(1);
        } else {
            if (b != 3) {
                return;
            }
            final g gVar2 = this.a;
            Objects.requireNonNull(gVar2);
            gVar2.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xe.e
                @Override // java.lang.Runnable
                public final void run() {
                    g gVar3 = gVar2;
                    File fileA = gVar3.g.a(gVar3.a.b());
                    if (fileA == null) {
                        gVar3.b.sendBroadcast(gVar3.b("com.google.android.libraries.navigation.EVENT_TRACK_DUMP_COLLECTED_FAILURE"));
                        return;
                    }
                    Intent intentB = gVar3.b("com.google.android.libraries.navigation.EVENT_TRACK_DUMP_COLLECTED");
                    intentB.putExtra("filePath", fileA.getAbsolutePath());
                    gVar3.b.sendBroadcast(intentB);
                }
            });
        }
    }
}
