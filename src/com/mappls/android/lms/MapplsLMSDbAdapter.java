package com.mappls.android.lms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.mappls.android.util.MPLog;
import com.mappls.android.util.MessageEncryptor;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
class MapplsLMSDbAdapter {
    private static final String ANONYMOUS_PEOPLE_TIME_INDEX;
    public static final int AUTOMATIC_DATA_COLUMN_INDEX = 3;
    public static final int CREATED_AT_COLUMN_INDEX = 2;
    private static final String CREATE_ANONYMOUS_PEOPLE_TABLE;
    private static final String CREATE_EVENTS_TABLE;
    private static final String CREATE_FCM_EVENTS_TABLE;
    private static final String CREATE_GROUPS_TABLE;
    private static final String CREATE_PEOPLE_TABLE;
    private static final String DATABASE_NAME = "mappls_svgsfse";
    private static final int DATABASE_VERSION = 10;
    public static final int DATA_COLUMN_INDEX = 1;
    public static final int DB_OUT_OF_MEMORY_ERROR = -2;
    public static final int DB_UNDEFINED_CODE = -3;
    public static final int DB_UPDATE_ERROR = -1;
    private static final String EVENTS_TIME_INDEX;
    private static final String FCM_EVENTS_TIME_INDEX;
    private static final String GROUPS_TIME_INDEX;
    public static final int ID_COLUMN_INDEX = 0;
    public static final String KEY_AUTOMATIC_DATA = "automatic_data";
    public static final String KEY_CREATED_AT = "created_at";
    public static final String KEY_DATA = "data";
    public static final String KEY_TOKEN = "token";
    private static final String LOGTAG = "MapplsLMSAPI.Database";
    private static final String PEOPLE_TIME_INDEX;
    public static final int TOKEN_COLUMN_INDEX = 4;
    private static final Map<Context, MapplsLMSDbAdapter> sInstances = new HashMap();
    private final MPDatabaseHelper mDb;

    class MPDatabaseHelper extends SQLiteOpenHelper {
        private final MapplsLMSConfig mConfig;
        private final File mDatabaseFile;

        MPDatabaseHelper(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 10);
            this.mDatabaseFile = context.getDatabasePath(str);
            this.mConfig = MapplsLMSConfig.getInstance(context);
        }

        public boolean aboveMemThreshold() {
            if (this.mDatabaseFile.exists()) {
                return this.mDatabaseFile.length() > Math.max(this.mDatabaseFile.getUsableSpace(), (long) this.mConfig.getMinimumDatabaseLimit()) || this.mDatabaseFile.length() > ((long) this.mConfig.getMaximumDatabaseLimit());
            }
            return false;
        }

        public void deleteDatabase() {
            close();
            this.mDatabaseFile.delete();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            MPLog.v(MapplsLMSDbAdapter.LOGTAG, "Creating a new Mappls Analytics events DB");
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.CREATE_EVENTS_TABLE);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.CREATE_FCM_EVENTS_TABLE);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.CREATE_PEOPLE_TABLE);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.CREATE_GROUPS_TABLE);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.CREATE_ANONYMOUS_PEOPLE_TABLE);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.EVENTS_TIME_INDEX);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.FCM_EVENTS_TIME_INDEX);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.PEOPLE_TIME_INDEX);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.GROUPS_TIME_INDEX);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.ANONYMOUS_PEOPLE_TIME_INDEX);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            MPLog.v(MapplsLMSDbAdapter.LOGTAG, "Upgrading app, replacing Mappls LMS events DB");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.EVENTS.getName());
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.FCM_EVENTS.getName());
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.PEOPLE.getName());
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.GROUPS.getName());
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.ANONYMOUS_PEOPLE.getName());
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.CREATE_EVENTS_TABLE);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.CREATE_FCM_EVENTS_TABLE);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.CREATE_PEOPLE_TABLE);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.CREATE_GROUPS_TABLE);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.CREATE_ANONYMOUS_PEOPLE_TABLE);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.EVENTS_TIME_INDEX);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.FCM_EVENTS_TIME_INDEX);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.PEOPLE_TIME_INDEX);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.GROUPS_TIME_INDEX);
            sQLiteDatabase.execSQL(MapplsLMSDbAdapter.ANONYMOUS_PEOPLE_TIME_INDEX);
        }
    }

    public enum Table {
        EVENTS("events"),
        FCM_EVENTS("fcm_events"),
        PEOPLE("people"),
        ANONYMOUS_PEOPLE("anonymous_people"),
        GROUPS("groups");

        private final String mTableName;

        Table(String str) {
            this.mTableName = str;
        }

        public String getName() {
            return this.mTableName;
        }
    }

    static {
        StringBuilder sb = new StringBuilder("CREATE TABLE ");
        Table table = Table.EVENTS;
        sb.append(table.getName());
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL, created_at INTEGER NOT NULL, automatic_data INTEGER DEFAULT 0, token STRING NOT NULL DEFAULT '')");
        CREATE_EVENTS_TABLE = sb.toString();
        CREATE_FCM_EVENTS_TABLE = "CREATE TABLE " + Table.FCM_EVENTS.getName() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL, created_at INTEGER NOT NULL, automatic_data INTEGER DEFAULT 0, token STRING NOT NULL DEFAULT '')";
        StringBuilder sb2 = new StringBuilder("CREATE TABLE ");
        Table table2 = Table.PEOPLE;
        sb2.append(table2.getName());
        sb2.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL, created_at INTEGER NOT NULL, automatic_data INTEGER DEFAULT 0, token STRING NOT NULL DEFAULT '')");
        CREATE_PEOPLE_TABLE = sb2.toString();
        StringBuilder sb3 = new StringBuilder("CREATE TABLE ");
        Table table3 = Table.GROUPS;
        sb3.append(table3.getName());
        sb3.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL, created_at INTEGER NOT NULL, automatic_data INTEGER DEFAULT 0, token STRING NOT NULL DEFAULT '')");
        CREATE_GROUPS_TABLE = sb3.toString();
        StringBuilder sb4 = new StringBuilder("CREATE TABLE ");
        Table table4 = Table.ANONYMOUS_PEOPLE;
        sb4.append(table4.getName());
        sb4.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL, created_at INTEGER NOT NULL, automatic_data INTEGER DEFAULT 0, token STRING NOT NULL DEFAULT '')");
        CREATE_ANONYMOUS_PEOPLE_TABLE = sb4.toString();
        EVENTS_TIME_INDEX = "CREATE INDEX IF NOT EXISTS time_idx ON " + table.getName() + " (created_at);";
        FCM_EVENTS_TIME_INDEX = "CREATE INDEX IF NOT EXISTS time_idx ON " + table.getName() + " (created_at);";
        PEOPLE_TIME_INDEX = "CREATE INDEX IF NOT EXISTS time_idx ON " + table2.getName() + " (created_at);";
        GROUPS_TIME_INDEX = "CREATE INDEX IF NOT EXISTS time_idx ON " + table3.getName() + " (created_at);";
        ANONYMOUS_PEOPLE_TIME_INDEX = "CREATE INDEX IF NOT EXISTS time_idx ON " + table4.getName() + " (created_at);";
    }

    public MapplsLMSDbAdapter(Context context) {
        this(context, DATABASE_NAME);
    }

    public MapplsLMSDbAdapter(Context context, String str) {
        this.mDb = new MPDatabaseHelper(context, str);
    }

    public static MapplsLMSDbAdapter getInstance(Context context) {
        MapplsLMSDbAdapter mapplsLMSDbAdapter;
        Map<Context, MapplsLMSDbAdapter> map = sInstances;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (map.containsKey(applicationContext)) {
                mapplsLMSDbAdapter = map.get(applicationContext);
            } else {
                mapplsLMSDbAdapter = new MapplsLMSDbAdapter(applicationContext);
                map.put(applicationContext, mapplsLMSDbAdapter);
            }
        }
        return mapplsLMSDbAdapter;
    }

    protected boolean aboveMemThreshold() {
        return this.mDb.aboveMemThreshold();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0085 A[PHI: r1
      0x0085: PHI (r1v5 android.database.Cursor) = (r1v4 android.database.Cursor), (r1v7 android.database.Cursor) binds: [B:14:0x006e, B:23:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int addJSON(String str, String str2, Table table) throws Throwable {
        Cursor cursorRawQuery;
        if (aboveMemThreshold()) {
            MPLog.e(LOGTAG, "There is not enough space left on the device or the data was over the maximum size limit so it was discarded");
            return -2;
        }
        String name = table.getName();
        Cursor cursor = null;
        cursor = null;
        ?? r1 = 0;
        try {
            try {
                try {
                    SQLiteDatabase writableDatabase = this.mDb.getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("data", str);
                    contentValues.put(KEY_CREATED_AT, Long.valueOf(System.currentTimeMillis()));
                    contentValues.put(KEY_TOKEN, str2);
                    writableDatabase.insert(name, null, contentValues);
                    cursorRawQuery = writableDatabase.rawQuery("SELECT COUNT(*) FROM " + name + " WHERE token=?", new String[]{str2});
                    try {
                        cursorRawQuery.moveToFirst();
                        int i = cursorRawQuery.getInt(0);
                        cursorRawQuery.close();
                        this.mDb.close();
                        return i;
                    } catch (SQLiteException unused) {
                        MPLog.e(LOGTAG, "Could not add Mappls Analytics data to table");
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        } else {
                            cursor = cursorRawQuery;
                        }
                        this.mDb.deleteDatabase();
                        if (cursor != null) {
                            cursor.close();
                        }
                        this.mDb.close();
                        return -1;
                    } catch (OutOfMemoryError unused2) {
                        cursor = cursorRawQuery;
                        MPLog.e(LOGTAG, "Out of memory when adding Mappls Analytics data to table");
                        if (cursor != null) {
                            cursor.close();
                        }
                        this.mDb.close();
                        return -1;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (r1 != 0) {
                        r1.close();
                    }
                    this.mDb.close();
                    throw th;
                }
            } catch (SQLiteException unused3) {
                cursorRawQuery = null;
            } catch (OutOfMemoryError unused4) {
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = str;
        }
    }

    public void cleanupAllEvents(Table table, String str) {
        String name = table.getName();
        try {
            try {
                this.mDb.getWritableDatabase().delete(name, "token = '" + str + "'", null);
            } catch (SQLiteException e) {
                MPLog.e(LOGTAG, "Could not clean timed-out Mappls Analytics records from " + name + ". Re-initializing database.", e);
                this.mDb.deleteDatabase();
            }
        } finally {
            this.mDb.close();
        }
    }

    public void cleanupEvents(long j, Table table) {
        String name = table.getName();
        try {
            try {
                this.mDb.getWritableDatabase().delete(name, "created_at <= " + j, null);
            } catch (SQLiteException e) {
                MPLog.e(LOGTAG, "Could not clean timed-out Mappls Analytics records from " + name + ". Re-initializing database.", e);
                this.mDb.deleteDatabase();
            }
        } finally {
            this.mDb.close();
        }
    }

    public void cleanupEvents(String str, Table table, String str2) {
        String name = table.getName();
        try {
            try {
                this.mDb.getWritableDatabase().delete(name, new StringBuffer("_id <= " + str + " AND token = '" + str2 + "'").toString(), null);
            } catch (SQLiteException e) {
                MPLog.e(LOGTAG, "Could not clean sent Mappls Analytics records from " + name + ". Re-initializing database.", e);
                this.mDb.deleteDatabase();
            } catch (Exception e2) {
                MPLog.e(LOGTAG, "Unknown exception. Could not clean sent Mappls Analytics records from " + name + ".Re-initializing database.", e2);
                this.mDb.deleteDatabase();
            }
        } finally {
            this.mDb.close();
        }
    }

    public void deleteDB() {
        this.mDb.deleteDatabase();
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0136  */
    /* JADX WARN: Code duplicated, block: B:52:0x013b  */
    /* JADX WARN: Code duplicated, block: B:63:0x0153  */
    /* JADX WARN: Code duplicated, block: B:65:0x0158  */
    /* JADX WARN: Multi-variable type inference failed */
    public String[] generateDataString(Table table, String str) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursorRawQuery2;
        Object objValueOf;
        String string;
        String string2;
        String str2;
        String name = table.getName();
        SQLiteDatabase readableDatabase = this.mDb.getReadableDatabase();
        Cursor cursor = null;
        try {
            StringBuffer stringBuffer = new StringBuffer("SELECT * FROM " + name + " WHERE token = ? ");
            StringBuffer stringBuffer2 = new StringBuffer("SELECT COUNT(*) FROM " + name + " WHERE token = ? ");
            StringBuilder sb = new StringBuilder("ORDER BY created_at ASC LIMIT ");
            sb.append(Integer.toString(this.mDb.mConfig.getFlushBatchSize()));
            stringBuffer.append(sb.toString());
            cursorRawQuery2 = readableDatabase.rawQuery(stringBuffer.toString(), new String[]{str});
            try {
                cursorRawQuery = readableDatabase.rawQuery(stringBuffer2.toString(), new String[]{str});
                try {
                    try {
                        cursorRawQuery.moveToFirst();
                        int i = 0;
                        objValueOf = String.valueOf(cursorRawQuery.getInt(0));
                        try {
                            JSONArray jSONArray = new JSONArray();
                            string2 = null;
                            while (cursorRawQuery2.moveToNext()) {
                                if (cursorRawQuery2.isLast()) {
                                    string2 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("_id") >= 0 ? cursorRawQuery2.getColumnIndex("_id") : i);
                                }
                                try {
                                    JSONObject jSONObject = new JSONObject(MessageEncryptor.offlineDecryptMessage(cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("data") >= 0 ? cursorRawQuery2.getColumnIndex("data") : 1)));
                                    if (jSONObject.has("properties")) {
                                        JSONObject jSONObject2 = jSONObject.getJSONObject("properties");
                                        jSONObject.remove("properties");
                                        Iterator<String> itKeys = jSONObject2.keys();
                                        while (itKeys.hasNext()) {
                                            String next = itKeys.next();
                                            jSONObject.put(next, jSONObject2.get(next));
                                        }
                                    }
                                    jSONArray.put(jSONObject);
                                } catch (JSONException unused) {
                                }
                                i = 0;
                            }
                            string = jSONArray.length() > 0 ? jSONArray.toString() : null;
                            this.mDb.close();
                            cursorRawQuery2.close();
                            cursorRawQuery.close();
                            str2 = objValueOf;
                        } catch (SQLiteException e) {
                            e = e;
                            MPLog.e(LOGTAG, "Could not pull records for Mappls Analytics out of database " + name + ". Waiting to send.", e);
                            this.mDb.close();
                            if (cursorRawQuery2 != null) {
                                cursorRawQuery2.close();
                            }
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            string = null;
                            string2 = null;
                            str2 = objValueOf;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        objValueOf = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery2;
                    this.mDb.close();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
                objValueOf = cursorRawQuery;
                MPLog.e(LOGTAG, "Could not pull records for Mappls Analytics out of database " + name + ". Waiting to send.", e);
                this.mDb.close();
                if (cursorRawQuery2 != null) {
                    cursorRawQuery2.close();
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                string = null;
                string2 = null;
                str2 = objValueOf;
                if (string2 != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursorRawQuery = null;
                cursor = cursorRawQuery2;
                this.mDb.close();
                if (cursor != null) {
                    cursor.close();
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorRawQuery2 = null;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            cursorRawQuery = null;
            this.mDb.close();
            if (cursor != null) {
                cursor.close();
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
        if (string2 != null || string == null) {
            return null;
        }
        return new String[]{string2, string, str2};
    }

    public File getDatabaseFile() {
        return this.mDb.mDatabaseFile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    int pushAnonymousUpdatesToPeopleDb(String str, String str2) throws Throwable {
        Cursor cursorRawQuery;
        if (aboveMemThreshold()) {
            MPLog.e(LOGTAG, "There is not enough space left on the device or the data was over the maximum size limit so it was discarded");
            return -2;
        }
        ?? r7 = 0;
        r7 = 0;
        Cursor cursor = null;
        int i = -1;
        try {
            try {
                try {
                    SQLiteDatabase writableDatabase = this.mDb.getWritableDatabase();
                    cursorRawQuery = writableDatabase.rawQuery(new StringBuffer("SELECT * FROM " + Table.ANONYMOUS_PEOPLE.getName() + " WHERE token = ?").toString(), new String[]{str});
                    try {
                        writableDatabase.beginTransaction();
                        while (cursorRawQuery.moveToNext()) {
                            try {
                                try {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(KEY_CREATED_AT, Long.valueOf(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(KEY_CREATED_AT) >= 0 ? cursorRawQuery.getColumnIndex(KEY_CREATED_AT) : 2)));
                                    contentValues.put(KEY_AUTOMATIC_DATA, Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(KEY_AUTOMATIC_DATA) >= 0 ? cursorRawQuery.getColumnIndex(KEY_AUTOMATIC_DATA) : 3)));
                                    contentValues.put(KEY_TOKEN, cursorRawQuery.getString(cursorRawQuery.getColumnIndex(KEY_TOKEN) >= 0 ? cursorRawQuery.getColumnIndex(KEY_TOKEN) : 4));
                                    JSONObject jSONObject = new JSONObject(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("data") >= 0 ? cursorRawQuery.getColumnIndex("data") : 1));
                                    jSONObject.put("$distinct_id", str2);
                                    contentValues.put("data", jSONObject.toString());
                                    writableDatabase.insert(Table.PEOPLE.getName(), null, contentValues);
                                    int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("_id") >= 0 ? cursorRawQuery.getColumnIndex("_id") : 0);
                                    writableDatabase.delete(Table.ANONYMOUS_PEOPLE.getName(), "_id = " + i2, null);
                                    i++;
                                } catch (JSONException unused) {
                                }
                            } catch (Throwable th) {
                                writableDatabase.endTransaction();
                                throw th;
                            }
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        cursorRawQuery.close();
                    } catch (SQLiteException e) {
                        e = e;
                        MPLog.e(LOGTAG, "Could not push anonymous updates records from " + Table.ANONYMOUS_PEOPLE.getName() + ". Re-initializing database.", e);
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        } else {
                            cursor = cursorRawQuery;
                        }
                        this.mDb.deleteDatabase();
                        r7 = cursor;
                        if (cursor != null) {
                            cursor.close();
                            r7 = cursor;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r7 != 0) {
                        r7.close();
                    }
                    this.mDb.close();
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorRawQuery = null;
            }
            this.mDb.close();
            return i;
        } catch (Throwable th3) {
            th = th3;
            r7 = str;
        }
    }

    int rewriteEventDataWithProperties(Map<String, String> map, String str) throws Throwable {
        Cursor cursorRawQuery;
        if (aboveMemThreshold()) {
            MPLog.e(LOGTAG, "There is not enough space left on the device or the data was over the maximum size limit so it was discarded");
            return -2;
        }
        int i = 0;
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase writableDatabase = this.mDb.getWritableDatabase();
                cursorRawQuery = writableDatabase.rawQuery(new StringBuffer("SELECT * FROM " + Table.EVENTS.getName() + " WHERE token = ?").toString(), new String[]{str});
                try {
                    try {
                        writableDatabase.beginTransaction();
                        int i2 = 0;
                        while (cursorRawQuery.moveToNext()) {
                            try {
                                try {
                                    try {
                                        ContentValues contentValues = new ContentValues();
                                        JSONObject jSONObject = new JSONObject(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("data") >= 0 ? cursorRawQuery.getColumnIndex("data") : 1));
                                        JSONObject jSONObject2 = jSONObject.getJSONObject("properties");
                                        for (Map.Entry<String, String> entry : map.entrySet()) {
                                            jSONObject2.put(entry.getKey(), entry.getValue());
                                        }
                                        jSONObject.put("properties", jSONObject2);
                                        contentValues.put("data", jSONObject.toString());
                                        int i3 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("_id") >= 0 ? cursorRawQuery.getColumnIndex("_id") : 0);
                                        writableDatabase.update(Table.EVENTS.getName(), contentValues, "_id = " + i3, null);
                                        i2++;
                                    } catch (JSONException unused) {
                                    }
                                } catch (SQLiteException e) {
                                    e = e;
                                    i = i2;
                                    MPLog.e(LOGTAG, "Could not re-write events history. Re-initializing database.", e);
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    } else {
                                        cursor = cursorRawQuery;
                                    }
                                    this.mDb.deleteDatabase();
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    this.mDb.close();
                                    return i;
                                }
                            } catch (Throwable th) {
                                writableDatabase.endTransaction();
                                throw th;
                            }
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        cursorRawQuery.close();
                        this.mDb.close();
                        return i2;
                    } catch (SQLiteException e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorRawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    this.mDb.close();
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
