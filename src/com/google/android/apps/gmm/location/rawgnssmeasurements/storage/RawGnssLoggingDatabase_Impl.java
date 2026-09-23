package com.google.android.apps.gmm.location.rawgnssmeasurements.storage;

import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegateMarker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class RawGnssLoggingDatabase_Impl extends RawGnssLoggingDatabase {
    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.performClear(false, new String[]{"recorded_raw_gnss_measurement_event"});
    }

    @Override // androidx.room.RoomDatabase
    protected final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "recorded_raw_gnss_measurement_event");
    }

    protected final /* synthetic */ RoomOpenDelegateMarker createOpenDelegate() {
        return new a(this);
    }

    @Override // androidx.room.RoomDatabase
    public final List getAutoMigrations(Map map) {
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public final Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected final Map getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(c.class, Collections.emptyList());
        return map;
    }
}
