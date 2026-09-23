package com.google.android.libraries.navigation.internal.kh;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.no;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k implements com.google.android.libraries.navigation.internal.gg.e {
    final o a;
    final /* synthetic */ l b;

    public k(l lVar, o oVar) {
        this.b = lVar;
        this.a = oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        com.google.android.libraries.navigation.internal.nj.i.a();
        t tVar = this.b.a;
        if (tVar.c.d) {
            i iVar2 = tVar.c;
            if (!iVar2.e.getAndSet(true)) {
                try {
                    SQLiteDatabase sQLiteDatabaseA = iVar2.b.a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        try {
                            i.d(sQLiteDatabaseA);
                            sQLiteDatabaseA.setTransactionSuccessful();
                            iVar2.d = false;
                            sQLiteDatabaseA.endTransaction();
                            if (sQLiteDatabaseA != null) {
                                sQLiteDatabaseA.close();
                            }
                        } catch (Throwable th) {
                            sQLiteDatabaseA.endTransaction();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                } catch (Exception unused) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 780)).p("Exception while trying to reset ue3 db, won't try again");
                }
            }
        }
        if (tVar.c.d) {
            return;
        }
        o oVar2 = this.a;
        i iVar3 = tVar.c;
        boolean z = iVar3.d;
        b bVar = (b) oVar2;
        com.google.android.libraries.navigation.internal.hj.i iVar4 = bVar.a;
        ev evVar = bVar.b;
        if (!z) {
            try {
                SQLiteDatabase sQLiteDatabaseA2 = iVar3.b.a();
                try {
                    sQLiteDatabaseA2.beginTransaction();
                    try {
                        no it2 = evVar.iterator();
                        while (it2.hasNext()) {
                            com.google.android.libraries.navigation.internal.ke.c cVar = (com.google.android.libraries.navigation.internal.ke.c) it2.next();
                            long epochMilli = iVar3.c.f().minusMillis(iVar3.c.a() - cVar.c).toEpochMilli();
                            String strB = i.b(iVar4);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("user_account_id", strB);
                            contentValues.put("ue3", cVar.e().m());
                            contentValues.put("timestamp", Long.valueOf(epochMilli));
                            sQLiteDatabaseA2.insert("userevent3_table", null, contentValues);
                        }
                        sQLiteDatabaseA2.setTransactionSuccessful();
                        sQLiteDatabaseA2.endTransaction();
                        if (sQLiteDatabaseA2 != null) {
                            sQLiteDatabaseA2.close();
                        }
                    } catch (Throwable th4) {
                        sQLiteDatabaseA2.endTransaction();
                        throw th4;
                    }
                } catch (Throwable th5) {
                    if (sQLiteDatabaseA2 != null) {
                        try {
                            sQLiteDatabaseA2.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            } catch (Exception unused2) {
                iVar3.d = true;
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 781)).p("FailedEventsDatabase saveEvents failed");
            }
        }
        evVar.size();
        if (iVar4.b()) {
            return;
        }
        iVar4.c();
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        com.google.android.libraries.navigation.internal.hj.i iVar2 = ((b) this.a).a;
        if (iVar2.f()) {
            this.b.e(iVar2);
        } else {
            this.b.d();
        }
    }
}
