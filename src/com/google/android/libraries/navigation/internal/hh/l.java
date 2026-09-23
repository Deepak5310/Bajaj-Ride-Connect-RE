package com.google.android.libraries.navigation.internal.hh;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import com.drew.metadata.iptc.IptcDirectory;
import com.google.android.libraries.navigation.internal.hx.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class l implements j {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.hh.l");
    private final k b;

    public l(Application application) {
        this.b = new k(application);
    }

    @Override // com.google.android.libraries.navigation.internal.hh.j
    public final void a(u uVar, byte[] bArr) {
        ap.GMM_STORAGE.f();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_key_pri", uVar.a.a());
        contentValues.put("_key_sec", uVar.b);
        contentValues.put("_data", bArr);
        if (this.b.getWritableDatabase().replaceOrThrow("gmm_storage_table", null, contentValues) == -1) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(IptcDirectory.TAG_IMAGE_ORIENTATION)).s("replaceOrThrow of %s failed", uVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.hh.j
    public final byte[] b(u uVar) {
        Cursor cursorQuery = this.b.getReadableDatabase().query("gmm_storage_table", new String[]{"_data"}, "_key_pri = ? AND _key_sec = ?", new String[]{uVar.a.a(), uVar.b}, null, null, null);
        try {
            try {
                try {
                    byte[] blob = cursorQuery.moveToNext() ? cursorQuery.getBlob(0) : null;
                    cursorQuery.close();
                    return blob;
                } catch (SQLiteException e) {
                    Object obj = uVar;
                    if (!Build.TYPE.equals("eng") && !Build.TYPE.equals("userdebug")) {
                        obj = uVar;
                        obj = "<stripped>";
                    }
                    obj = uVar;
                    SQLiteException sQLiteException = new SQLiteException(String.format("Failed to read from GmmStorage for key %s", obj), e);
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(645)).o();
                    throw sQLiteException;
                }
            } catch (IllegalStateException e2) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(644)).s("Tried to read %s Record may have exceeded the 2MB SQLite row limit. See b/64893655.  Please upload your gmm_storage.db to the bug!", uVar);
                throw e2;
            }
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.hh.j
    public final void c(u uVar) {
        this.b.getWritableDatabase().delete("gmm_storage_table", "_key_pri = ? AND _key_sec = ?", new String[]{uVar.a.a(), uVar.b});
    }
}
