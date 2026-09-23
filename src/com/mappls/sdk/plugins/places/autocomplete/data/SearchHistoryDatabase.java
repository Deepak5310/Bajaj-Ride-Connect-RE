package com.mappls.sdk.plugins.places.autocomplete.data;

import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SearchHistoryDatabase extends RoomDatabase {
    private static SearchHistoryDatabase b;
    private final MutableLiveData<Boolean> a = new MutableLiveData<>();

    private static class a extends AsyncTask<Void, Void, Void> {
        private final SearchHistoryDatabase a;
        private com.mappls.sdk.plugins.places.autocomplete.data.entity.a b;
        private boolean c;

        a(SearchHistoryDatabase searchHistoryDatabase) {
            this.c = true;
            this.a = searchHistoryDatabase;
        }

        a(SearchHistoryDatabase searchHistoryDatabase, com.mappls.sdk.plugins.places.autocomplete.data.entity.a aVar) {
            this.b = aVar;
            this.a = searchHistoryDatabase;
        }

        @Override // android.os.AsyncTask
        protected final Void doInBackground(Void[] voidArr) {
            if (this.c) {
                this.a.b().a();
                return null;
            }
            this.a.b().a(this.b);
            return null;
        }
    }

    static void a(SearchHistoryDatabase searchHistoryDatabase) {
        searchHistoryDatabase.a.postValue(Boolean.TRUE);
    }

    public static void a(SearchHistoryDatabase searchHistoryDatabase, com.mappls.sdk.plugins.places.autocomplete.data.entity.a aVar) {
        new a(searchHistoryDatabase, aVar).execute(new Void[0]);
    }

    public static void b(SearchHistoryDatabase searchHistoryDatabase) {
        new a(searchHistoryDatabase).execute(new Void[0]);
    }

    public final MutableLiveData a() {
        return this.a;
    }

    public abstract com.mappls.sdk.plugins.places.autocomplete.data.dao.a b();

    public static SearchHistoryDatabase a(Context context) {
        if (b == null) {
            Context applicationContext = context.getApplicationContext();
            SearchHistoryDatabase searchHistoryDatabase = (SearchHistoryDatabase) Room.databaseBuilder(applicationContext, SearchHistoryDatabase.class, "com.mappls.sdk.plugins.places.database").fallbackToDestructiveMigration().addCallback(new com.mappls.sdk.plugins.places.autocomplete.data.a(applicationContext)).build();
            b = searchHistoryDatabase;
            Context applicationContext2 = context.getApplicationContext();
            searchHistoryDatabase.getClass();
            if (applicationContext2.getDatabasePath("com.mappls.sdk.plugins.places.database").exists()) {
                searchHistoryDatabase.a.postValue(Boolean.TRUE);
            }
        }
        return b;
    }
}
