package com.mappls.sdk.plugins.places.autocomplete.data;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
final class a extends RoomDatabase.Callback {
    final /* synthetic */ Context a;

    a(Context context) {
        this.a = context;
    }

    @Override // androidx.room.RoomDatabase.Callback
    public final void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onCreate(supportSQLiteDatabase);
        SearchHistoryDatabase.a(SearchHistoryDatabase.a(this.a));
    }
}
