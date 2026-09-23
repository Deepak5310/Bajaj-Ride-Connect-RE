package com.google.android.libraries.navigation.internal.kh;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.nn;
import j$.time.Duration;
import j$.time.Instant;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;

    public ad(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final t a() {
        com.google.android.libraries.navigation.internal.mj.a aVar = (com.google.android.libraries.navigation.internal.mj.a) this.a.a();
        bn bnVarA = ((com.google.android.libraries.navigation.internal.nj.b) this.b).a();
        com.google.android.libraries.navigation.internal.iz.n nVar = (com.google.android.libraries.navigation.internal.iz.n) this.c.a();
        final t tVar = new t(aVar, com.google.android.libraries.navigation.internal.afr.e.c(this.d), ((j) this.e).a());
        nVar.d(new Runnable() { // from class: com.google.android.libraries.navigation.internal.kh.ac
            /* JADX WARN: Code duplicated, block: B:61:0x010a A[LOOP:0: B:59:0x0104->B:61:0x010a, LOOP_END] */
            @Override // java.lang.Runnable
            public final void run() {
                fd fdVarD;
                nn nnVarListIterator;
                com.google.android.libraries.navigation.internal.nj.i.a();
                t tVar2 = tVar;
                Instant instantF = tVar2.a.f();
                com.google.android.libraries.navigation.internal.nk.p pVar = ((com.google.android.libraries.navigation.internal.nk.s) tVar2.b.a()).a().e;
                if (pVar == null) {
                    pVar = com.google.android.libraries.navigation.internal.nk.p.a;
                }
                long epochMilli = instantF.minus(Duration.ofMinutes(pVar.f490n)).toEpochMilli();
                i iVar = tVar2.c;
                ez ezVar = new ez();
                try {
                    SQLiteDatabase sQLiteDatabaseA = iVar.b.a();
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        try {
                            Cursor cursorQuery = sQLiteDatabaseA.query(true, "userevent3_table", new String[]{"user_account_id"}, "1 = 1", null, null, null, null, null);
                            try {
                                int count = cursorQuery.getCount();
                                ArrayList<String> arrayList = new ArrayList(count);
                                if (count == 0) {
                                    sQLiteDatabaseA.setTransactionSuccessful();
                                    fdVarD = ezVar.d();
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    sQLiteDatabaseA.endTransaction();
                                    if (sQLiteDatabaseA != null) {
                                        sQLiteDatabaseA.close();
                                    }
                                } else {
                                    cursorQuery.moveToFirst();
                                    for (long j = 0; j < count; j++) {
                                        arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("user_account_id")));
                                        cursorQuery.moveToNext();
                                    }
                                    for (String str : arrayList) {
                                        int iDelete = sQLiteDatabaseA.delete("userevent3_table", "user_account_id = ? AND timestamp <= ?", new String[]{str, Long.toString(epochMilli)});
                                        if (iDelete > 0) {
                                            ezVar.f(str, Integer.valueOf(iDelete));
                                        }
                                    }
                                    sQLiteDatabaseA.setTransactionSuccessful();
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    sQLiteDatabaseA.endTransaction();
                                    if (sQLiteDatabaseA != null) {
                                        sQLiteDatabaseA.close();
                                    }
                                    fdVarD = ezVar.d();
                                }
                                nnVarListIterator = fdVarD.entrySet().listIterator();
                                while (nnVarListIterator.hasNext()) {
                                    Map.Entry entry = (Map.Entry) nnVarListIterator.next();
                                    tVar2.d.b((String) entry.getKey(), new com.google.android.libraries.navigation.internal.ke.f(((Integer) entry.getValue()).intValue(), tVar2.a));
                                }
                            } catch (Throwable th) {
                                if (cursorQuery == null) {
                                    throw th;
                                }
                                try {
                                    cursorQuery.close();
                                    throw th;
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            sQLiteDatabaseA.endTransaction();
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        if (sQLiteDatabaseA == null) {
                            throw th4;
                        }
                        try {
                            sQLiteDatabaseA.close();
                            throw th4;
                        } catch (Throwable th5) {
                            th4.addSuppressed(th5);
                            throw th4;
                        }
                        fdVarD = ezVar.d();
                        nnVarListIterator = fdVarD.entrySet().listIterator();
                        while (nnVarListIterator.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) nnVarListIterator.next();
                            tVar2.d.b((String) entry2.getKey(), new com.google.android.libraries.navigation.internal.ke.f(((Integer) entry2.getValue()).intValue(), tVar2.a));
                        }
                    }
                } catch (Exception unused) {
                    iVar.d = true;
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 779)).p("FailedEventsDatabase clearExpired failed");
                }
            }
        }, bnVarA, com.google.android.libraries.navigation.internal.iz.m.ON_STARTUP_FULLY_COMPLETE);
        return tVar;
    }
}
