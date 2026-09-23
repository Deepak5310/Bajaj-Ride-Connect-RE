package com.mappls.sdk.traffic.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.mappls.sdk.traffic.db.dao.a;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BeaconDatabase extends RoomDatabase {
    private static BeaconDatabase a;

    public static BeaconDatabase a(Context context) {
        if (a == null) {
            a = (BeaconDatabase) Room.inMemoryDatabaseBuilder(context.getApplicationContext(), BeaconDatabase.class).build();
        }
        return a;
    }

    public abstract a a();
}
