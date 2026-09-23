package com.google.android.libraries.geo.navcore.service.logging.transparency.storage;

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
/* JADX INFO: loaded from: classes2.dex */
public final class TripTransparencyDatabase_Impl extends TripTransparencyDatabase {
    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.performClear(false, new String[]{"recent_sensor_observations_count", "recent_signs_count", "recorded_sensor_observation_event"});
    }

    @Override // androidx.room.RoomDatabase
    protected final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "recent_sensor_observations_count", "recent_signs_count", "recorded_sensor_observation_event");
    }

    protected final /* synthetic */ RoomOpenDelegateMarker createOpenDelegate() {
        return new g(this);
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
        map.put(b.class, Collections.emptyList());
        map.put(d.class, Collections.emptyList());
        map.put(f.class, Collections.emptyList());
        return map;
    }
}
