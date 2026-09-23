package com.mappls.sdk.plugins.places.autocomplete.data.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mappls.sdk.plugins.places.autocomplete.data.SearchHistoryDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements com.mappls.sdk.plugins.places.autocomplete.data.dao.a {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<com.mappls.sdk.plugins.places.autocomplete.data.entity.a> b;
    private final SharedSQLiteStatement c;

    final class a implements Callable<List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a>> {
        final /* synthetic */ RoomSQLiteQuery a;

        a(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        public final List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a> call() {
            Cursor cursorQuery = DBUtil.query(d.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "placeId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "eLocation");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "place_name");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "place_address");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "alternate_name");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new com.mappls.sdk.plugins.places.autocomplete.data.entity.a(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), com.mappls.sdk.plugins.places.autocomplete.data.converter.a.a(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2)), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), (cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3))).longValue()));
                }
                return arrayList;
            } finally {
                cursorQuery.close();
            }
        }

        protected final void finalize() {
            this.a.release();
        }
    }

    final class b implements Callable<List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a>> {
        final /* synthetic */ RoomSQLiteQuery a;

        b(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        public final List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a> call() {
            Cursor cursorQuery = DBUtil.query(d.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "placeId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "eLocation");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "place_name");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "place_address");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "alternate_name");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new com.mappls.sdk.plugins.places.autocomplete.data.entity.a(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), com.mappls.sdk.plugins.places.autocomplete.data.converter.a.a(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2)), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), (cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3))).longValue()));
                }
                return arrayList;
            } finally {
                cursorQuery.close();
            }
        }

        protected final void finalize() {
            this.a.release();
        }
    }

    public d(SearchHistoryDatabase searchHistoryDatabase) {
        this.a = searchHistoryDatabase;
        this.b = new com.mappls.sdk.plugins.places.autocomplete.data.dao.b(searchHistoryDatabase);
        this.c = new c(searchHistoryDatabase);
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.data.dao.a
    public final LiveData<List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a>> a(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM searchhistory WHERE place_name LIKE '%' || ? || '%' OR place_address LIKE '%' || ? || '%' OR placeId LIKE '%' || ? || '%' order by timestamp desc", 3);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, str);
        }
        return this.a.getInvalidationTracker().createLiveData(new String[]{"searchhistory"}, false, new b(roomSQLiteQueryAcquire));
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.data.dao.a
    public final void a() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.c.acquire();
        try {
            this.a.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.a.setTransactionSuccessful();
                this.a.endTransaction();
                this.c.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.a.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.c.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.data.dao.a
    public final void a(com.mappls.sdk.plugins.places.autocomplete.data.entity.a aVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(aVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.data.dao.a
    public final LiveData<List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a>> getAll() {
        return this.a.getInvalidationTracker().createLiveData(new String[]{"searchhistory"}, false, new a(RoomSQLiteQuery.acquire("SELECT * FROM searchhistory order by timestamp desc", 0)));
    }
}
