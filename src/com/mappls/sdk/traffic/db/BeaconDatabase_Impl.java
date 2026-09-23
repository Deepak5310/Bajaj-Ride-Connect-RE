package com.mappls.sdk.traffic.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.BV.LinearGradient.LinearGradientManager;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.mappls.sdk.traffic.db.dao.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class BeaconDatabase_Impl extends BeaconDatabase {
    private volatile b b;

    final class a extends RoomOpenHelper.Delegate {
        a() {
            super(1);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `locations` (`time` TEXT NOT NULL, `longitude` REAL NOT NULL, `latitude` REAL NOT NULL, `speed` REAL NOT NULL, `heading` REAL NOT NULL, `deviceType` TEXT, `engineState` INTEGER NOT NULL, `altitude` REAL NOT NULL, PRIMARY KEY(`time`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '83874013c8c25fadd1f9f4cbfb9aeb63')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `locations`");
            List list = ((RoomDatabase) BeaconDatabase_Impl.this).mCallbacks;
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ((RoomDatabase.Callback) it2.next()).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            List list = ((RoomDatabase) BeaconDatabase_Impl.this).mCallbacks;
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ((RoomDatabase.Callback) it2.next()).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) BeaconDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
            BeaconDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            List list = ((RoomDatabase) BeaconDatabase_Impl.this).mCallbacks;
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ((RoomDatabase.Callback) it2.next()).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap map = new HashMap(8);
            map.put("time", new TableInfo.Column("time", "TEXT", true, 1, null, 1));
            map.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, 1));
            map.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, 1));
            map.put("speed", new TableInfo.Column("speed", "REAL", true, 0, null, 1));
            map.put("heading", new TableInfo.Column("heading", "REAL", true, 0, null, 1));
            map.put("deviceType", new TableInfo.Column("deviceType", "TEXT", false, 0, null, 1));
            map.put("engineState", new TableInfo.Column("engineState", "INTEGER", true, 0, null, 1));
            map.put(SavingTrackHelper.TRACK_COL_ALTITUDE, new TableInfo.Column(SavingTrackHelper.TRACK_COL_ALTITUDE, "REAL", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo(LinearGradientManager.PROP_LOCATIONS, map, new HashSet(0), new HashSet(0));
            TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, LinearGradientManager.PROP_LOCATIONS);
            if (tableInfo.equals(tableInfo2)) {
                return new RoomOpenHelper.ValidationResult(true, null);
            }
            return new RoomOpenHelper.ValidationResult(false, "locations(com.mappls.sdk.traffic.db.ProbeLocation).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
        }
    }

    @Override // com.mappls.sdk.traffic.db.BeaconDatabase
    public final com.mappls.sdk.traffic.db.dao.a a() {
        b bVar;
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b == null) {
                this.b = new b(this);
            }
            bVar = this.b;
        }
        return bVar;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        try {
            beginTransaction();
            writableDatabase.execSQL("DELETE FROM `locations`");
            setTransactionSuccessful();
        } finally {
            endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), LinearGradientManager.PROP_LOCATIONS);
    }

    @Override // androidx.room.RoomDatabase
    protected final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(), "83874013c8c25fadd1f9f4cbfb9aeb63", "2dc40ac97f6d90307297d77e6cce2b5c")).build());
    }

    @Override // androidx.room.RoomDatabase
    public final List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public final Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected final Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(com.mappls.sdk.traffic.db.dao.a.class, Collections.emptyList());
        return map;
    }
}
