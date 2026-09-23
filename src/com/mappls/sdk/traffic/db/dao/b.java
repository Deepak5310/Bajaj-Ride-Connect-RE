package com.mappls.sdk.traffic.db.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.mappls.sdk.traffic.db.ProbeLocation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.mappls.sdk.traffic.db.dao.a {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<ProbeLocation> b;
    private final EntityDeletionOrUpdateAdapter<ProbeLocation> c;

    final class a extends EntityInsertionAdapter<ProbeLocation> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        protected final void bind(SupportSQLiteStatement supportSQLiteStatement, ProbeLocation probeLocation) {
            ProbeLocation probeLocation2 = probeLocation;
            if (probeLocation2.getTime() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, probeLocation2.getTime());
            }
            supportSQLiteStatement.bindDouble(2, probeLocation2.getLongitude());
            supportSQLiteStatement.bindDouble(3, probeLocation2.getLatitude());
            supportSQLiteStatement.bindDouble(4, probeLocation2.getSpeed());
            supportSQLiteStatement.bindDouble(5, probeLocation2.getHeading());
            if (probeLocation2.getDeviceType() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, probeLocation2.getDeviceType());
            }
            supportSQLiteStatement.bindLong(7, probeLocation2.getEngineState());
            supportSQLiteStatement.bindDouble(8, probeLocation2.getAltitude());
        }

        @Override // androidx.room.SharedSQLiteStatement
        protected final String createQuery() {
            return "INSERT OR REPLACE INTO `locations` (`time`,`longitude`,`latitude`,`speed`,`heading`,`deviceType`,`engineState`,`altitude`) VALUES (?,?,?,?,?,?,?,?)";
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.traffic.db.dao.b$b, reason: collision with other inner class name */
    final class C0118b extends EntityDeletionOrUpdateAdapter<ProbeLocation> {
        C0118b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        protected final void bind(SupportSQLiteStatement supportSQLiteStatement, ProbeLocation probeLocation) {
            ProbeLocation probeLocation2 = probeLocation;
            if (probeLocation2.getTime() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, probeLocation2.getTime());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        protected final String createQuery() {
            return "DELETE FROM `locations` WHERE `time` = ?";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new C0118b(roomDatabase);
    }

    @Override // com.mappls.sdk.traffic.db.dao.a
    public final ArrayList a() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM locations ORDER BY time DESC LIMIT 20", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "longitude");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latitude");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "speed");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "heading");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceType");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "engineState");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SavingTrackHelper.TRACK_COL_ALTITUDE);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                ProbeLocation probeLocation = new ProbeLocation();
                probeLocation.setTime(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                probeLocation.setLongitude(cursorQuery.getDouble(columnIndexOrThrow2));
                probeLocation.setLatitude(cursorQuery.getDouble(columnIndexOrThrow3));
                probeLocation.setSpeed(cursorQuery.getFloat(columnIndexOrThrow4));
                probeLocation.setHeading(cursorQuery.getFloat(columnIndexOrThrow5));
                probeLocation.setDeviceType(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                probeLocation.setEngineState(cursorQuery.getInt(columnIndexOrThrow7));
                probeLocation.setAltitude(cursorQuery.getDouble(columnIndexOrThrow8));
                arrayList.add(probeLocation);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.mappls.sdk.traffic.db.dao.a
    public final void a(List<ProbeLocation> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.mappls.sdk.traffic.db.dao.a
    public final void b(List<ProbeLocation> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
