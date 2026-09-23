package com.google.android.libraries.navigation.internal.hz;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public final ContentResolver a;

    public e(Context context) {
        this.a = context.getContentResolver();
    }

    public final Cursor a(Uri uri, String[] strArr, String[] strArr2) throws c, b {
        a aVar = new a(this, uri, strArr, strArr2);
        try {
            e eVar = aVar.a;
            return eVar.a.query(aVar.b, aVar.c, aVar.d, aVar.e, null);
        } catch (SQLiteException e) {
            throw new c(e);
        } catch (SecurityException e2) {
            e = e2;
            throw new b(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new b(e);
        }
    }
}
