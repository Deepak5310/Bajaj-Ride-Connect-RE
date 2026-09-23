package com.google.android.libraries.navigation.internal.ix;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b extends SQLiteOpenHelper {
    public b(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
    }

    public final SQLiteDatabase a() throws a {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException e) {
            throw new a(e);
        }
    }
}
