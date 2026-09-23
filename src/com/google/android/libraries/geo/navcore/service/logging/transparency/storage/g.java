package com.google.android.libraries.geo.navcore.service.logging.transparency.storage;

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
/* JADX INFO: loaded from: classes2.dex */
final class g extends RoomOpenDelegate {
    final /* synthetic */ TripTransparencyDatabase_Impl a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TripTransparencyDatabase_Impl tripTransparencyDatabase_Impl) {
        super(3, "298e763b959b1189be5980f6a65d39a7", "4fc94d398779a721574c993309e0c0bc");
        this.a = tripTransparencyDatabase_Impl;
    }

    public final void createAllTables(SQLiteConnection sQLiteConnection) {
        SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `recent_sensor_observations_count` (`sensor_observation_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sensor_observation_type` TEXT NOT NULL, `timestamp_ms` INTEGER NOT NULL)");
        SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_recent_sensor_observations_count_timestamp_ms` ON `recent_sensor_observations_count` (`timestamp_ms`)");
        SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `recent_signs_count` (`sign_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sign_type` TEXT NOT NULL, `timestamp_ms` INTEGER NOT NULL)");
        SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_recent_signs_count_timestamp_ms` ON `recent_signs_count` (`timestamp_ms`)");
        SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `recorded_sensor_observation_event` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `recorded_time_millis` INTEGER NOT NULL, `observation_size_bytes` INTEGER NOT NULL)");
        SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_recorded_sensor_observation_event_recorded_time_millis` ON `recorded_sensor_observation_event` (`recorded_time_millis`)");
        SQLite.execSQL(sQLiteConnection, RoomMasterTable.CREATE_QUERY);
        SQLite.execSQL(sQLiteConnection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '298e763b959b1189be5980f6a65d39a7')");
    }

    public final void dropAllTables(SQLiteConnection sQLiteConnection) {
        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `recent_sensor_observations_count`");
        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `recent_signs_count`");
        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `recorded_sensor_observation_event`");
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
        map.put("sensor_observation_id", new TableInfo.Column("sensor_observation_id", "INTEGER", true, 1, null, 1));
        map.put("sensor_observation_type", new TableInfo.Column("sensor_observation_type", "TEXT", true, 0, null, 1));
        map.put("timestamp_ms", new TableInfo.Column("timestamp_ms", "INTEGER", true, 0, null, 1));
        HashSet hashSet = new HashSet(0);
        HashSet hashSet2 = new HashSet(1);
        hashSet2.add(new TableInfo.Index("index_recent_sensor_observations_count_timestamp_ms", false, Arrays.asList("timestamp_ms"), Arrays.asList("ASC")));
        TableInfo tableInfo = new TableInfo("recent_sensor_observations_count", map, hashSet, hashSet2);
        TableInfo tableInfo2 = TableInfo.read(sQLiteConnection, "recent_sensor_observations_count");
        if (!tableInfo.equals(tableInfo2)) {
            return new RoomOpenDelegate.ValidationResult(false, "recent_sensor_observations_count(com.google.android.libraries.geo.navcore.service.logging.transparency.storage.RecentSensorObservationsCount).\n Expected:\n" + tableInfo.toString() + "\n Found:\n" + String.valueOf(tableInfo2));
        }
        HashMap map2 = new HashMap(3);
        map2.put("sign_id", new TableInfo.Column("sign_id", "INTEGER", true, 1, null, 1));
        map2.put("sign_type", new TableInfo.Column("sign_type", "TEXT", true, 0, null, 1));
        map2.put("timestamp_ms", new TableInfo.Column("timestamp_ms", "INTEGER", true, 0, null, 1));
        HashSet hashSet3 = new HashSet(0);
        HashSet hashSet4 = new HashSet(1);
        hashSet4.add(new TableInfo.Index("index_recent_signs_count_timestamp_ms", false, Arrays.asList("timestamp_ms"), Arrays.asList("ASC")));
        TableInfo tableInfo3 = new TableInfo("recent_signs_count", map2, hashSet3, hashSet4);
        TableInfo tableInfo4 = TableInfo.read(sQLiteConnection, "recent_signs_count");
        if (!tableInfo3.equals(tableInfo4)) {
            return new RoomOpenDelegate.ValidationResult(false, "recent_signs_count(com.google.android.libraries.geo.navcore.service.logging.transparency.storage.RecentSignsCount).\n Expected:\n" + tableInfo3.toString() + "\n Found:\n" + String.valueOf(tableInfo4));
        }
        HashMap map3 = new HashMap(3);
        map3.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
        map3.put("recorded_time_millis", new TableInfo.Column("recorded_time_millis", "INTEGER", true, 0, null, 1));
        map3.put("observation_size_bytes", new TableInfo.Column("observation_size_bytes", "INTEGER", true, 0, null, 1));
        HashSet hashSet5 = new HashSet(0);
        HashSet hashSet6 = new HashSet(1);
        hashSet6.add(new TableInfo.Index("index_recorded_sensor_observation_event_recorded_time_millis", false, Arrays.asList("recorded_time_millis"), Arrays.asList("ASC")));
        TableInfo tableInfo5 = new TableInfo("recorded_sensor_observation_event", map3, hashSet5, hashSet6);
        TableInfo tableInfo6 = TableInfo.read(sQLiteConnection, "recorded_sensor_observation_event");
        if (tableInfo5.equals(tableInfo6)) {
            return new RoomOpenDelegate.ValidationResult(true, (String) null);
        }
        return new RoomOpenDelegate.ValidationResult(false, "recorded_sensor_observation_event(com.google.android.libraries.geo.navcore.service.logging.transparency.storage.RecordedSensorObservationEvent).\n Expected:\n" + tableInfo5.toString() + "\n Found:\n" + String.valueOf(tableInfo6));
    }
}
