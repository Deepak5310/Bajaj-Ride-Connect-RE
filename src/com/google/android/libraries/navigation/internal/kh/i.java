package com.google.android.libraries.navigation.internal.kh;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public static final String[] a = {"_id", "user_account_id", "ue3", "timestamp"};
    public final com.google.android.libraries.navigation.internal.ix.b b;
    public final com.google.android.libraries.navigation.internal.mj.a c;
    public volatile boolean d = false;
    public final AtomicBoolean e = new AtomicBoolean(false);

    public i(Context context, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.c = aVar;
        this.b = new g(context);
    }

    public static String b(com.google.android.libraries.navigation.internal.hj.i iVar) {
        return iVar.b() ? "" : iVar.c();
    }

    public static void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table userevent3_table(_id integer primary key autoincrement, user_account_id text not null, ue3 blob not null, timestamp bigint not null); ");
        sQLiteDatabase.execSQL("create index account_timestamp_idx on userevent3_table(user_account_id, timestamp);");
    }

    public static void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS userevent3_table;");
        c(sQLiteDatabase);
    }

    public final ev a(com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        Object objG;
        if (this.d) {
            int i = ev.d;
            return lv.a;
        }
        int i2 = ev.d;
        eq eqVar = new eq();
        try {
            SQLiteDatabase sQLiteDatabaseA = this.b.a();
            try {
                sQLiteDatabaseA.beginTransaction();
                try {
                    Cursor cursor = (Cursor) aaVar.ak(sQLiteDatabaseA);
                    try {
                        int count = cursor.getCount();
                        ArrayList arrayList = new ArrayList(count);
                        if (count == 0) {
                            sQLiteDatabaseA.setTransactionSuccessful();
                            ev evVarG = eqVar.g();
                            if (cursor != null) {
                                cursor.close();
                            }
                            sQLiteDatabaseA.endTransaction();
                            if (sQLiteDatabaseA != null) {
                                sQLiteDatabaseA.close();
                            }
                            return evVarG;
                        }
                        cursor.moveToFirst();
                        for (long j = 0; j < count; j++) {
                            int i3 = cursor.getInt(cursor.getColumnIndex("_id"));
                            String string = cursor.getString(cursor.getColumnIndex("user_account_id"));
                            byte[] blob = cursor.getBlob(cursor.getColumnIndex("ue3"));
                            long j2 = cursor.getLong(cursor.getColumnIndex("timestamp"));
                            com.google.android.libraries.navigation.internal.ke.o oVar = null;
                            dg dgVar = (dg) pe.a.aH(7, null);
                            if (blob == null) {
                                objG = null;
                            } else {
                                try {
                                    objG = dgVar.g(blob);
                                } catch (cc unused) {
                                    objG = null;
                                }
                            }
                            pe peVar = (pe) objG;
                            if (peVar != null) {
                                long jA = this.c.a();
                                oVar = new com.google.android.libraries.navigation.internal.ke.o(peVar, jA, jA - this.c.f().minusMillis(j2).toEpochMilli());
                                String str = peVar.e;
                                if (!str.isEmpty()) {
                                    oVar.h(str);
                                }
                            } else {
                                hx.d("message=gmm.UserEvent3");
                            }
                            an anVarI = an.i(oVar);
                            arrayList.add(Integer.toString(i3));
                            if (anVarI.g()) {
                                eqVar.h(new a(string, (com.google.android.libraries.navigation.internal.ke.c) anVarI.c()));
                            }
                            cursor.moveToNext();
                        }
                        StringBuilder sb = new StringBuilder("_id = ? ");
                        for (int i4 = 1; i4 < arrayList.size(); i4++) {
                            sb.append(" OR _id = ? ");
                        }
                        sQLiteDatabaseA.delete("userevent3_table", sb.toString(), (String[]) arrayList.toArray(new String[0]));
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (cursor != null) {
                            cursor.close();
                        }
                        sQLiteDatabaseA.endTransaction();
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.close();
                        }
                        return eqVar.g();
                    } catch (Throwable th) {
                        if (cursor == null) {
                            throw th;
                        }
                        try {
                            cursor.close();
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
                return eqVar.g();
            }
        } catch (Exception unused2) {
            this.d = true;
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 778)).p("FailedEventsDatabase recoverFreshEvents failed");
        }
    }
}
