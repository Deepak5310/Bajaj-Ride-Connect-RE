package com.google.android.libraries.navigation.internal.cx;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.libraries.navigation.internal.aac.bn;
import java.util.concurrent.TimeUnit;
import kotlin.text.Typography;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r implements Runnable {
    private static final Uri f = Uri.parse("content://com.google.settings/partner");
    private static final String[] g = {"value"};
    private static final String[] h = {"use_location_for_services"};
    public final Context a;
    public final bn b;
    public boolean c;
    volatile boolean d;
    public final p e;
    private final com.google.android.libraries.navigation.internal.cw.c i = new com.google.android.libraries.navigation.internal.cw.c();
    private final com.google.android.libraries.navigation.internal.ia.e j;

    public r(Context context, bn bnVar, p pVar, com.google.android.libraries.navigation.internal.ia.e eVar) {
        this.a = context.getApplicationContext();
        this.b = bnVar;
        this.e = pVar;
        this.j = eVar;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    /* JADX WARN: Code duplicated, block: B:22:0x004c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x004e A[Catch: Exception -> 0x0052, TRY_LEAVE, TryCatch #3 {Exception -> 0x0052, blocks: (B:7:0x0009, B:12:0x002d, B:23:0x004e, B:21:0x004b, B:20:0x0048, B:9:0x001c, B:11:0x0022, B:17:0x0043), top: B:47:0x0009, inners: #0, #1 }] */
    @Override // java.lang.Runnable
    public final void run() {
        int iC;
        int iB;
        int iD;
        if (this.d) {
            if (this.c) {
                try {
                    Cursor cursorA = new com.google.android.libraries.navigation.internal.hz.e(this.a).a(f, g, h);
                    if (cursorA != null) {
                        try {
                            if (cursorA.moveToNext()) {
                                boolean zEquals = "1".equals(cursorA.getString(0));
                                cursorA.close();
                                if (zEquals) {
                                    p pVar = this.e;
                                    iC = pVar.c();
                                    iB = pVar.b();
                                    iD = pVar.d();
                                }
                            } else if (cursorA != null) {
                                cursorA.close();
                            }
                        } catch (Throwable th) {
                            try {
                                cursorA.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } else if (cursorA != null) {
                        cursorA.close();
                    }
                } catch (Exception unused) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(Typography.nbsp)).p("Failed to get 'Use Location for Services' setting");
                }
                iC = com.google.android.libraries.navigation.internal.cw.b.e;
                iB = com.google.android.libraries.navigation.internal.cw.b.e;
                iD = iB;
            } else {
                p pVar2 = this.e;
                iC = pVar2.c();
                iB = pVar2.b();
                iD = pVar2.d();
            }
            com.google.android.libraries.navigation.internal.cw.c cVar = this.i;
            boolean zB = cVar.b();
            synchronized (cVar) {
                this.i.a = iC;
                this.i.b = iB;
                this.i.c = iD;
            }
            if (zB && !this.i.b()) {
                this.j.a(new com.google.android.libraries.navigation.internal.db.s(null));
            }
            this.j.a(new com.google.android.libraries.navigation.internal.cw.f(this.i));
            this.b.schedule(this, 5000L, TimeUnit.MILLISECONDS);
        }
    }
}
