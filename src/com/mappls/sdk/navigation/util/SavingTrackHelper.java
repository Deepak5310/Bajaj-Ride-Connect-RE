package com.mappls.sdk.navigation.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.DateFormat;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.NavigationFormatter;
import com.mappls.sdk.navigation.NavigationLocationProvider;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.gpx.GPXDataModel;
import com.mappls.sdk.navigation.gpx.GPXUtilities;
import com.mappls.sdk.navigation.gpx.GpxSelectionHelper;
import com.mappls.sdk.navigation.n;
import com.mappls.sdk.navigation.q;
import com.mappls.sdk.navigation.s;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SavingTrackHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "tracks";
    public static final int DATABASE_VERSION = 5;
    public static final String IS_SYNCED = "is_synced";
    public static final String POINT_COL_CATEGORY = "category";
    public static final String POINT_COL_COLOR = "color";
    public static final String POINT_COL_DATE = "date";
    public static final String POINT_COL_DESCRIPTION = "description";
    public static final String POINT_COL_LAT = "lat";
    public static final String POINT_COL_LON = "lon";
    public static final String POINT_COL_NAME = "pname";
    public static final String POINT_NAME = "point";
    public static final String SQL_CREATE_TABLE_TRACKS = "CREATE TABLE IF NOT EXISTS tracks_table ( _id INTEGER PRIMARY KEY AUTOINCREMENT, track_id INTEGER NOT NULL, track_name TEXT NOT NULL, gpx_path TEXT NOT NULL, is_synced TEXT DEFAULT '0'  );";
    public static final String TRACK_COL_ALTITUDE = "altitude";
    public static final String TRACK_COL_DATE = "date";
    public static final String TRACK_COL_HDOP = "hdop";
    public static final String TRACK_COL_LAT = "lat";
    public static final String TRACK_COL_LON = "lon";
    public static final String TRACK_COL_SPEED = "speed";
    public static final String TRACK_ID = "track_id";
    public static final String TRACK_NAME = "track";
    public static final String TRACK_NAME_FIELD = "track_name";
    public static final String TRACK_PATH = "gpx_path";
    public static final String TRACK_TABLE_NAME = "tracks_table";
    private String addTrackScript;
    private final Context ctx;
    private GpxSelectionHelper.SelectedGpxFile currentTrack;
    private float distance;
    private long duration;
    private String insertPointsScript;
    private LatLng lastPoint;
    private long lastTimeUpdated;
    private int points;
    private String updateScript;

    public SavingTrackHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 5);
        this.lastTimeUpdated = 0L;
        this.distance = 0.0f;
        this.duration = 0L;
        this.ctx = context;
        GpxSelectionHelper.SelectedGpxFile selectedGpxFile = new GpxSelectionHelper.SelectedGpxFile();
        this.currentTrack = selectedGpxFile;
        selectedGpxFile.setShowCurrentTrack(true);
        GPXUtilities.GPXFile gPXFile = new GPXUtilities.GPXFile();
        gPXFile.showCurrentTrack = true;
        this.currentTrack.setGpxFile(gPXFile);
        prepareCurrentTrackForRecording();
        this.updateScript = "INSERT INTO track (lat, lon, altitude, speed, hdop, date) VALUES (?, ?, ?, ?, ?, ?)";
        this.addTrackScript = "INSERT INTO tracks_table (track_id, track_name, gpx_path, is_synced) VALUES (?, ?, ?, ?)";
        this.insertPointsScript = "INSERT INTO point VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    private void addTrackPoint(GPXUtilities.g gVar, boolean z, long j) {
        List<GPXUtilities.f> modifiablePointsToDisplay = this.currentTrack.getModifiablePointsToDisplay();
        GPXUtilities.Track track = this.currentTrack.getGpxFile().tracks.get(0);
        if (modifiablePointsToDisplay.size() == 0 || z) {
            modifiablePointsToDisplay.add(new GPXUtilities.f());
        }
        if (track.segments.size() == 0 || z) {
            track.segments.add(new GPXUtilities.f());
        }
        if (gVar != null) {
            modifiablePointsToDisplay.get(modifiablePointsToDisplay.size() - 1).a.add(gVar);
            List<GPXUtilities.f> list = track.segments;
            list.get(list.size() - 1).a.add(gVar);
        }
        this.currentTrack.getModifiableGpxFile().modifiedTime = j;
    }

    private void collectDBPoints(SQLiteDatabase sQLiteDatabase, Map<String, GPXUtilities.GPXFile> map) {
        GPXUtilities.GPXFile gPXFile;
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT lat,lon,date,description,pname,category,color FROM point ORDER BY date ASC", null);
        if (cursorRawQuery.moveToFirst()) {
            do {
                GPXUtilities.g gVar = new GPXUtilities.g();
                gVar.a = cursorRawQuery.getDouble(0);
                gVar.b = cursorRawQuery.getDouble(1);
                long j = cursorRawQuery.getLong(2);
                gVar.h = j;
                gVar.f = cursorRawQuery.getString(3);
                gVar.c = cursorRawQuery.getString(4);
                gVar.e = cursorRawQuery.getString(5);
                int i = cursorRawQuery.getInt(6);
                if (i != 0) {
                    gVar.setColor(i);
                }
                String str = gVar.c;
                if (str != null && str.length() > 4) {
                    String str2 = gVar.c;
                    if (str2.charAt(str2.length() - 4) == '.') {
                        gVar.d = gVar.c;
                    }
                }
                String string = DateFormat.format("yyyy-MM-dd", j).toString();
                if (map.containsKey(string)) {
                    gPXFile = map.get(string);
                } else {
                    GPXUtilities.GPXFile gPXFile2 = new GPXUtilities.GPXFile();
                    map.put(string, gPXFile2);
                    gPXFile = gPXFile2;
                }
                gPXFile.points.add(gVar);
            } while (cursorRawQuery.moveToNext());
        }
        cursorRawQuery.close();
    }

    private void collectDBTracks(SQLiteDatabase sQLiteDatabase, Map<String, GPXUtilities.GPXFile> map) {
        GPXUtilities.Track track = null;
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT lat,lon,altitude,speed,hdop,date FROM track ORDER BY date ASC", null);
        if (cursorRawQuery.moveToFirst()) {
            long j = 0;
            GPXUtilities.f fVar = null;
            long j2 = 0;
            while (true) {
                GPXUtilities.g gVar = new GPXUtilities.g();
                boolean z = false;
                gVar.a = cursorRawQuery.getDouble(0);
                gVar.b = cursorRawQuery.getDouble(1);
                gVar.i = cursorRawQuery.getDouble(2);
                gVar.j = cursorRawQuery.getDouble(3);
                gVar.k = cursorRawQuery.getDouble(4);
                long j3 = cursorRawQuery.getLong(5);
                gVar.h = j3;
                long jAbs = Math.abs(j3 - j2);
                if (gVar.a == 0.0d && gVar.b == 0.0d) {
                    z = true;
                }
                if (track != null && !z && (jAbs < 360000 || jAbs < j * 10)) {
                    fVar.a.add(gVar);
                } else if (track == null || jAbs >= 7200000) {
                    track = new GPXUtilities.Track();
                    fVar = new GPXUtilities.f();
                    track.segments.add(fVar);
                    if (!z) {
                        fVar.a.add(gVar);
                    }
                    String string = DateFormat.format("yyyy-MM-dd", j3).toString();
                    if (map.containsKey(string)) {
                        map.get(string).tracks.add(track);
                    } else {
                        GPXUtilities.GPXFile gPXFile = new GPXUtilities.GPXFile();
                        gPXFile.tracks.add(track);
                        map.put(string, gPXFile);
                    }
                } else {
                    fVar = new GPXUtilities.f();
                    if (!z) {
                        fVar.a.add(gVar);
                    }
                    track.segments.add(fVar);
                }
                if (!cursorRawQuery.moveToNext()) {
                    break;
                }
                j = jAbs;
                j2 = j3;
            }
        }
        cursorRawQuery.close();
    }

    private ArrayList<GPXDataModel> collectGPXTracks(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT track_id,track_name,gpx_path,is_synced FROM tracks_table", null);
        ArrayList<GPXDataModel> arrayList = new ArrayList<>();
        if (cursorRawQuery.moveToFirst()) {
            do {
                GPXDataModel gPXDataModel = new GPXDataModel();
                gPXDataModel.setTrackID(cursorRawQuery.getInt(0));
                gPXDataModel.setIsSynced(cursorRawQuery.getString(3));
                gPXDataModel.setTrackName(cursorRawQuery.getString(1));
                GPXUtilities.GPXFile gPXFileLoadGPXFile = GPXUtilities.loadGPXFile(this.ctx, cursorRawQuery.getString(2));
                try {
                    ArrayList<LatLng> arrayList2 = new ArrayList<>();
                    Iterator<GPXUtilities.Track> it2 = gPXFileLoadGPXFile.tracks.iterator();
                    while (it2.hasNext()) {
                        Iterator<GPXUtilities.f> it3 = it2.next().segments.iterator();
                        while (it3.hasNext()) {
                            for (GPXUtilities.g gVar : it3.next().a) {
                                arrayList2.add(new LatLng(gVar.getLatitude(), gVar.getLongitude()));
                            }
                        }
                    }
                    gPXDataModel.setTrackPath(arrayList2);
                } catch (Exception e) {
                    NavigationLogger.d(e);
                }
                arrayList.add(gPXDataModel);
                GPXUtilities.GPXTrackAnalysis analysis = gPXFileLoadGPXFile.getAnalysis(gPXFileLoadGPXFile.modifiedTime);
                gPXDataModel.setMaxSpeed(NavigationFormatter.getFormattedSpeed(analysis.maxSpeed, this.ctx));
                gPXDataModel.setAverageSpeed(NavigationFormatter.getFormattedSpeed(analysis.avgSpeed, this.ctx));
                if (analysis.timeSpan > 0) {
                    gPXDataModel.setTimeMoving(a.a((int) (analysis.timeMoving / 1000), NavigationContext.getNavigationContext().a()));
                }
                gPXDataModel.setDistance(NavigationFormatter.getFormattedDistance(analysis.totalDistanceMoving, this.ctx));
                gPXDataModel.setStartTime(this.ctx.getString(R.string.mappls_gpx_start_time, Long.valueOf(analysis.startTime)));
                gPXDataModel.setEndTime(this.ctx.getString(R.string.mappls_gpx_start_time, Long.valueOf(analysis.endTime)));
            } while (cursorRawQuery.moveToNext());
        }
        cursorRawQuery.close();
        return arrayList;
    }

    private void createTableForGPXTrack(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SQL_CREATE_TABLE_TRACKS);
    }

    private void createTableForPoints(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE point (lat double, lon double, date long, description text, pname text, category text, color long)");
        } catch (RuntimeException e) {
            NavigationLogger.d(e);
        }
    }

    private void createTableForTrack(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE track (lat double, lon double, altitude double, speed double, hdop double, date long )");
    }

    private synchronized void execWithClose(String str, Object[] objArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase != null) {
            try {
                writableDatabase.execSQL(str, objArr);
            } catch (Throwable th) {
                writableDatabase.close();
                throw th;
            }
        }
        if (writableDatabase != null) {
            writableDatabase.close();
        }
    }

    private void prepareCurrentTrackForRecording() {
        if (this.currentTrack.getModifiableGpxFile().tracks.size() == 0) {
            this.currentTrack.getModifiableGpxFile().tracks.add(new GPXUtilities.Track());
        }
        while (this.currentTrack.getPointsToDisplay().size() < this.currentTrack.getModifiableGpxFile().tracks.size()) {
            this.currentTrack.getModifiablePointsToDisplay().add(new GPXUtilities.f());
        }
    }

    public void clearPreviousData() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase != null && writableDatabase.isOpen()) {
            try {
                writableDatabase.execSQL("DELETE FROM track WHERE date <= ?", new Object[]{Long.valueOf(System.currentTimeMillis())});
                writableDatabase.execSQL("DELETE FROM point WHERE date <= ?", new Object[]{Long.valueOf(System.currentTimeMillis())});
                writableDatabase.close();
            } catch (Throwable th) {
                writableDatabase.close();
                throw th;
            }
        }
        this.distance = 0.0f;
        this.points = 0;
        this.duration = 0L;
        this.currentTrack.getModifiableGpxFile().points.clear();
        this.currentTrack.getModifiableGpxFile().tracks.clear();
        this.currentTrack.getModifiablePointsToDisplay().clear();
        this.currentTrack.getModifiableGpxFile().modifiedTime = System.currentTimeMillis();
        prepareCurrentTrackForRecording();
    }

    public Map<String, GPXUtilities.GPXFile> collectRecordedData() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase != null && readableDatabase.isOpen()) {
            try {
                collectDBPoints(readableDatabase, linkedHashMap);
                collectDBTracks(readableDatabase, linkedHashMap);
            } finally {
                readableDatabase.close();
            }
        }
        return linkedHashMap;
    }

    public void deletePointData(GPXUtilities.g gVar) {
        this.currentTrack.getModifiableGpxFile().points.remove(gVar);
        this.currentTrack.getModifiableGpxFile().modifiedTime = System.currentTimeMillis();
        this.points--;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Double.valueOf(gVar.a));
        arrayList.add(Double.valueOf(gVar.b));
        arrayList.add(Long.valueOf(gVar.h));
        StringBuilder sb = new StringBuilder("DELETE FROM point WHERE lat=? AND lon=? AND date=?");
        if (gVar.f != null) {
            sb.append(" AND description=?");
            arrayList.add(gVar.f);
        } else {
            sb.append(" AND description IS NULL");
        }
        if (gVar.c != null) {
            sb.append(" AND pname=?");
            arrayList.add(gVar.c);
        } else {
            sb.append(" AND pname IS NULL");
        }
        if (gVar.e != null) {
            sb.append(" AND category=?");
            arrayList.add(gVar.e);
        } else {
            sb.append(" AND category IS NULL");
        }
        execWithClose(sb.toString(), arrayList.toArray());
    }

    public GPXUtilities.GPXFile getCurrentGpx() {
        return this.currentTrack.getGpxFile();
    }

    public GpxSelectionHelper.SelectedGpxFile getCurrentTrack() {
        return this.currentTrack;
    }

    public float getDistance() {
        return this.distance;
    }

    public long getDuration() {
        return this.duration;
    }

    public ArrayList<GPXDataModel> getGPXTracks() {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null || !readableDatabase.isOpen()) {
            return null;
        }
        try {
            return collectGPXTracks(readableDatabase);
        } finally {
            readableDatabase.close();
        }
    }

    public boolean getIsRecording() {
        if (q.a() != null) {
            return NavigationContext.getNavigationContext().k().x.get().booleanValue() || (NavigationContext.getNavigationContext().k().A.get().booleanValue() && NavigationContext.getNavigationContext().h().q());
        }
        return false;
    }

    public long getLastTimeUpdated() {
        return this.lastTimeUpdated;
    }

    public long getLastTrackPointTime() {
        long j = 0;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT date FROM track ORDER BY date DESC", null);
                    j = cursorRawQuery.moveToFirst() ? cursorRawQuery.getLong(0) : 0L;
                    cursorRawQuery.close();
                } finally {
                    writableDatabase.close();
                }
            }
        } catch (RuntimeException e) {
            NavigationLogger.e(e);
        }
        return j;
    }

    public int getPoints() {
        return this.points;
    }

    public synchronized boolean hasDataToSave() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    Cursor cursorQuery = writableDatabase.query(false, TRACK_NAME, new String[0], null, null, null, null, null, null);
                    boolean zMoveToFirst = cursorQuery.moveToFirst();
                    cursorQuery.close();
                    if (zMoveToFirst) {
                        writableDatabase.close();
                        return true;
                    }
                    Cursor cursorQuery2 = writableDatabase.query(false, "point", new String[]{"lat", "lon"}, null, null, null, null, null, null);
                    boolean zMoveToFirst2 = cursorQuery2.moveToFirst();
                    while (zMoveToFirst2 && cursorQuery2.getDouble(0) == 0.0d && cursorQuery2.getDouble(1) == 0.0d) {
                        if (!cursorQuery2.moveToNext()) {
                            zMoveToFirst2 = false;
                            break;
                        }
                    }
                    cursorQuery2.close();
                    if (zMoveToFirst2) {
                        writableDatabase.close();
                        return true;
                    }
                    writableDatabase.close();
                } catch (Throwable th) {
                    writableDatabase.close();
                    throw th;
                }
            }
            return false;
        } catch (RuntimeException e) {
            NavigationLogger.d(e);
            return false;
        }
    }

    public void insertData(double d, double d2, double d3, double d4, double d5, long j, s sVar) {
        LatLng latLng;
        execWithClose(this.updateScript, new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Long.valueOf(j)});
        LatLng latLng2 = this.lastPoint;
        boolean z = true;
        if (latLng2 == null || j - this.lastTimeUpdated > 180000) {
            latLng = new LatLng(d, d2);
        } else {
            float[] fArr = new float[1];
            NavLocation.distanceBetween(d, d2, latLng2.getLatitude(), this.lastPoint.getLongitude(), fArr);
            long j2 = this.lastTimeUpdated;
            if (j2 > 0 && j > j2) {
                this.duration = (j - j2) + this.duration;
            }
            z = false;
            this.distance += fArr[0];
            latLng = new LatLng(d, d2);
        }
        this.lastPoint = latLng;
        this.lastTimeUpdated = j;
        addTrackPoint(new GPXUtilities.g(d, d2, j, d3, d4, d5), z, j);
    }

    public GPXUtilities.g insertPointData(double d, double d2, long j, String str, String str2, String str3, int i) {
        GPXUtilities.g gVar = new GPXUtilities.g(d, d2, j, Double.NaN, 0.0d, Double.NaN);
        gVar.c = str2;
        gVar.e = str3;
        gVar.f = str;
        if (i != 0) {
            gVar.setColor(i);
        }
        this.currentTrack.getModifiableGpxFile().points.add(gVar);
        this.currentTrack.getModifiableGpxFile().modifiedTime = j;
        this.points++;
        execWithClose(this.insertPointsScript, new Object[]{Double.valueOf(d), Double.valueOf(d2), Long.valueOf(j), str, str2, str3, Integer.valueOf(i)});
        return gVar;
    }

    public void loadGpxFromDatabase() {
        Map<String, GPXUtilities.GPXFile> mapCollectRecordedData = collectRecordedData();
        this.currentTrack.getModifiableGpxFile().tracks.clear();
        for (Map.Entry<String, GPXUtilities.GPXFile> entry : mapCollectRecordedData.entrySet()) {
            this.currentTrack.getModifiableGpxFile().points.addAll(entry.getValue().points);
            this.currentTrack.getModifiableGpxFile().tracks.addAll(entry.getValue().tracks);
        }
        this.currentTrack.processPoints();
        prepareCurrentTrackForRecording();
        GPXUtilities.GPXTrackAnalysis analysis = this.currentTrack.getModifiableGpxFile().getAnalysis(System.currentTimeMillis());
        this.distance = analysis.totalDistance;
        this.points = analysis.wptPoints;
        this.duration = analysis.timeSpan;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createTableForTrack(sQLiteDatabase);
        createTableForPoints(sQLiteDatabase);
        createTableForGPXTrack(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public synchronized List<String> saveDataToGpx(File file) {
        return saveDataToGpx(null, file);
    }

    public synchronized List<String> saveDataToGpx(String str, File file) {
        ArrayList arrayList = new ArrayList();
        file.mkdirs();
        if (file.getParentFile().canWrite() && file.exists()) {
            Map<String, GPXUtilities.GPXFile> mapCollectRecordedData = collectRecordedData();
            for (String str2 : mapCollectRecordedData.keySet()) {
                File file2 = new File(file, n.a(str2, ".gpx"));
                if (!mapCollectRecordedData.get(str2).isEmpty()) {
                    String str3 = str2 + "_" + new SimpleDateFormat("HH-mm_EEE", Locale.US).format(new Date(mapCollectRecordedData.get(str2).findPointToShow().h));
                    File file3 = new File(file, n.a(str3, ".gpx"));
                    int i = 1;
                    while (file3.exists()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str3);
                        sb.append("_");
                        i++;
                        sb.append(i);
                        sb.append(".gpx");
                        file3 = new File(file, sb.toString());
                    }
                    file2 = file3;
                }
                execWithClose(this.addTrackScript, new Object[]{"0", str != null ? str : "", GPXUtilities.asString(mapCollectRecordedData.get(str2), this.ctx), 0});
                String strWriteGpxFile = GPXUtilities.writeGpxFile(file2, mapCollectRecordedData.get(str2), this.ctx);
                if (strWriteGpxFile != null) {
                    arrayList.add(strWriteGpxFile);
                    return arrayList;
                }
            }
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase != null && arrayList.isEmpty() && writableDatabase.isOpen()) {
            try {
                writableDatabase.execSQL("DELETE FROM track WHERE date <= ?", new Object[]{Long.valueOf(System.currentTimeMillis())});
                writableDatabase.execSQL("DELETE FROM point WHERE date <= ?", new Object[]{Long.valueOf(System.currentTimeMillis())});
                writableDatabase.close();
            } catch (Throwable th) {
                writableDatabase.close();
                throw th;
            }
        }
        this.distance = 0.0f;
        this.points = 0;
        this.duration = 0L;
        this.currentTrack.getModifiableGpxFile().points.clear();
        this.currentTrack.getModifiableGpxFile().tracks.clear();
        this.currentTrack.getModifiablePointsToDisplay().clear();
        this.currentTrack.getModifiableGpxFile().modifiedTime = System.currentTimeMillis();
        prepareCurrentTrackForRecording();
        return arrayList;
    }

    public void startNewSegment() {
        this.lastTimeUpdated = 0L;
        this.lastPoint = null;
        execWithClose(this.updateScript, new Object[]{0, 0, 0, 0, 0, Long.valueOf(System.currentTimeMillis())});
        addTrackPoint(null, true, System.currentTimeMillis());
    }

    public void updateLocation(NavLocation navLocation) {
        LatLng latLng;
        long jCurrentTimeMillis = System.currentTimeMillis();
        s sVarK = NavigationContext.getNavigationContext().k();
        boolean z = false;
        if (NavigationLocationProvider.isPointAccurateForRouting(navLocation) && NavigationLocationProvider.isNotSimulatedLocation(navLocation) && q.a() != null) {
            boolean z2 = (sVarK.A.get().booleanValue() && jCurrentTimeMillis - this.lastTimeUpdated > ((long) sVarK.e0.get().intValue()) && NavigationContext.getNavigationContext().h().q()) || (sVarK.x.get().booleanValue() && jCurrentTimeMillis - this.lastTimeUpdated > ((long) sVarK.y.get().intValue()));
            float fFloatValue = sVarK.h0.get().floatValue();
            if (fFloatValue > 0.0f && (latLng = this.lastPoint) != null && d.a(latLng, navLocation.getLatitude(), navLocation.getLongitude()) < fFloatValue) {
                z2 = false;
            }
            float fFloatValue2 = sVarK.f0.get().floatValue();
            if (fFloatValue2 > 0.0f && (!navLocation.hasAccuracy() || navLocation.getAccuracy() < fFloatValue2)) {
                z2 = false;
            }
            float fFloatValue3 = sVarK.g0.get().floatValue();
            if (fFloatValue3 <= 0.0f || (navLocation.hasSpeed() && navLocation.getSpeed() >= fFloatValue3)) {
                z = z2;
            }
        }
        if (z) {
            insertData(navLocation.getLatitude(), navLocation.getLongitude(), navLocation.getAltitude(), navLocation.getSpeed(), navLocation.getAccuracy(), jCurrentTimeMillis, sVarK);
            NavigationContext.getNavigationContext().getNotificationHelper().refreshNotification(com.mappls.sdk.navigation.notifications.a.EnumC0097a.GPX);
        }
    }

    public void updatePointData(GPXUtilities.g gVar, double d, double d2, long j, String str, String str2, String str3, int i) {
        this.currentTrack.getModifiableGpxFile().modifiedTime = j;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Double.valueOf(d));
        arrayList.add(Double.valueOf(d2));
        arrayList.add(Long.valueOf(j));
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(str3);
        arrayList.add(Integer.valueOf(i));
        arrayList.add(Double.valueOf(gVar.a));
        arrayList.add(Double.valueOf(gVar.b));
        arrayList.add(Long.valueOf(gVar.h));
        StringBuilder sb = new StringBuilder("UPDATE point SET lat=?, lon=?, date=?, description=?, pname=?, category=?, color=? WHERE lat=? AND lon=? AND date=?");
        if (gVar.f != null) {
            sb.append(" AND description=?");
            arrayList.add(gVar.f);
        } else {
            sb.append(" AND description IS NULL");
        }
        if (gVar.c != null) {
            sb.append(" AND pname=?");
            arrayList.add(gVar.c);
        } else {
            sb.append(" AND pname IS NULL");
        }
        if (gVar.e != null) {
            sb.append(" AND category=?");
            arrayList.add(gVar.e);
        } else {
            sb.append(" AND category IS NULL");
        }
        execWithClose(sb.toString(), arrayList.toArray());
        gVar.a = d;
        gVar.b = d2;
        gVar.h = j;
        gVar.f = str;
        gVar.c = str2;
        gVar.e = str3;
        if (i != 0) {
            gVar.setColor(i);
        }
    }
}
