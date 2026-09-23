package com.google.android.apps.gmm.location.rawgnssmeasurements.storage;

import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class a extends RoomOpenDelegate {
    final /* synthetic */ RawGnssLoggingDatabase_Impl a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(RawGnssLoggingDatabase_Impl rawGnssLoggingDatabase_Impl) {
        super(1, "546a1cd5287d2cd8ec70d28aac4ea9ac", "adeb0b8fd58061d09c2a03a6449e0630");
        this.a = rawGnssLoggingDatabase_Impl;
    }

    public final void createAllTables(SQLiteConnection sQLiteConnection) {
        SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `recorded_raw_gnss_measurement_event` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `recorded_system_unix_time_millis` INTEGER NOT NULL, `observation_size_bytes` INTEGER NOT NULL)");
        SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_recorded_raw_gnss_measurement_event_recorded_system_unix_time_millis` ON `recorded_raw_gnss_measurement_event` (`recorded_system_unix_time_millis`)");
        SQLite.execSQL(sQLiteConnection, RoomMasterTable.CREATE_QUERY);
        SQLite.execSQL(sQLiteConnection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '546a1cd5287d2cd8ec70d28aac4ea9ac')");
    }

    public final void dropAllTables(SQLiteConnection sQLiteConnection) {
        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `recorded_raw_gnss_measurement_event`");
    }

    public final void onCreate(SQLiteConnection sQLiteConnection) {
    }

    public final void onOpen(SQLiteConnection sQLiteConnection) {
        this.a.internalInitInvalidationTracker(sQLiteConnection);
    }

    public final void onPostMigrate(SQLiteConnection sQLiteConnection) {
    }

    public final void onPreMigrate(SQLiteConnection sQLiteConnection) {
        DBUtil.dropFtsSyncTriggers(sQLiteConnection);
    }

    public final RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection sQLiteConnection) {
        HashMap map = new HashMap(3);
        map.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
        map.put("recorded_system_unix_time_millis", new TableInfo.Column("recorded_system_unix_time_millis", "INTEGER", true, 0, null, 1));
        map.put("observation_size_bytes", new TableInfo.Column("observation_size_bytes", "INTEGER", true, 0, null, 1));
        HashSet hashSet = new HashSet(0);
        HashSet hashSet2 = new HashSet(1);
        hashSet2.add(new TableInfo.Index("index_recorded_raw_gnss_measurement_event_recorded_system_unix_time_millis", false, Arrays.asList("recorded_system_unix_time_millis"), Arrays.asList("ASC")));
        TableInfo tableInfo = new TableInfo("recorded_raw_gnss_measurement_event", map, hashSet, hashSet2);
        TableInfo tableInfo2 = TableInfo.read(sQLiteConnection, "recorded_raw_gnss_measurement_event");
        if (tableInfo.equals(tableInfo2)) {
            return new RoomOpenDelegate.ValidationResult(true, (String) null);
        }
        return new RoomOpenDelegate.ValidationResult(false, "recorded_raw_gnss_measurement_event(com.google.android.apps.gmm.location.rawgnssmeasurements.storage.RecordedRawGnssMeasurementEvent).\n Expected:\n" + tableInfo.toString() + "\n Found:\n" + String.valueOf(tableInfo2));
    }
}
