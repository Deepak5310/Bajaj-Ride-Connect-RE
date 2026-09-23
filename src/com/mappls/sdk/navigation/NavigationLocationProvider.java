package com.mappls.sdk.navigation;

import android.content.Context;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import androidx.core.app.ActivityCompat;
import androidx.work.WorkRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.iface.LocationChangedListener;
import com.mappls.sdk.navigation.util.GPSInfo;
import com.mappls.sdk.services.api.MapplsApiConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationLocationProvider implements SensorEventListener {
    private static float ACCURACY_FOR_GPX_AND_ROUTING = 25.0f;
    private static final long AGPS_TO_REDOWNLOAD = 57600000;
    private static final int GPS_DIST_REQUEST = 0;
    private static final int GPS_TIMEOUT_REQUEST = 0;
    private static final int INTERVAL_TO_CLEAR_SET_LOCATION = 30000;
    private static final float KALMAN_COEFFICIENT = 0.04f;
    private static final long LOST_LOCATION_CHECK_DELAY = 18000;
    private static final int LOST_LOCATION_MSG_ID = 5001;
    private static final int NOT_SWITCH_TO_NETWORK_WHEN_GPS_LOST_MS = 12000;
    public static final int REQUEST_LOCATION_PERMISSION = 100;
    private static final int RUN_SIMULATE_LOCATION_MSG_ID = 5003;
    private static final String SIMULATED_PROVIDER = "mapmyindia";
    private static final long START_LOCATION_SIMULATION_DELAY = 2000;
    private static final int START_SIMULATE_LOCATION_MSG_ID = 5002;
    private static final boolean USE_KALMAN_FILTER = false;
    private s.t<Boolean> USE_FILTER_FOR_COMPASS;
    private s.t<Boolean> USE_MAGNETIC_FIELD_SENSOR_COMPASS;

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private Context f706app;
    private int currentScreenOrientation;
    private boolean gpsSignalLost;
    private GpsStatus.Listener gpsStatusListener;
    private p locationSimulation;
    private LocationChangedListener mLocationChangedListener;
    private s settings;
    float avgValSin = 0.0f;
    float avgValCos = 0.0f;
    float lastValSin = 0.0f;
    float lastValCos = 0.0f;
    private List<WeakReference<LocationChangedListener>> locationChangedListeners = new LinkedList();
    private long lastTimeGPSLocationFixed = 0;
    private boolean sensorRegistered = false;
    private float[] mGravs = new float[3];
    private float[] mGeoMags = new float[3];
    private float previousCorrectionValue = 360.0f;
    private float[] previousCompassValuesA = new float[50];
    private float[] previousCompassValuesB = new float[50];
    private int previousCompassIndA = 0;
    private int previousCompassIndB = 0;
    private boolean inUpdateValue = false;
    private Float heading = null;
    private Location lastLocation = null;
    private NavLocation location = null;
    private NavLocation acceptedLocation = null;
    private GPSInfo gpsInfo = new GPSInfo();
    private List<e> locationListeners = new ArrayList();
    private List<d> compassListeners = new ArrayList();
    private float[] mRotationM = new float[9];
    private LocationListener gpsListener = new a();
    private LinkedList<LocationListener> networkListeners = new LinkedList<>();

    final class a implements LocationListener {
        a() {
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            if (location != null) {
                NavigationLocationProvider.this.lastTimeGPSLocationFixed = location.getTime();
            }
            if (NavigationLocationProvider.this.locationSimulation.a()) {
                return;
            }
            NavigationLocationProvider navigationLocationProvider = NavigationLocationProvider.this;
            navigationLocationProvider.setLocation(NavigationLocationProvider.convertLocation(location, navigationLocationProvider.f706app));
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    final class b implements GpsStatus.Listener {
        private GpsStatus a;
        final /* synthetic */ LocationManager b;

        b(LocationManager locationManager) {
            this.b = locationManager;
        }

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int i) {
            GpsStatus gpsStatus = this.b.getGpsStatus(this.a);
            this.a = gpsStatus;
            NavigationLocationProvider.this.updateGPSInfo(gpsStatus);
            NavigationLocationProvider navigationLocationProvider = NavigationLocationProvider.this;
            navigationLocationProvider.updateLocation(navigationLocationProvider.location);
        }
    }

    final class c implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ com.mappls.sdk.navigation.routing.d b;

        c(long j, com.mappls.sdk.navigation.routing.d dVar) {
            this.a = j;
            this.b = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NavLocation lastKnownLocation = NavigationLocationProvider.this.getLastKnownLocation();
            if (lastKnownLocation == null || lastKnownLocation.getTime() <= this.a) {
                NavigationLocationProvider.this.gpsSignalLost = true;
                if (this.b.q() && this.b.h() > 0) {
                    if (NavigationLocationProvider.this.mLocationChangedListener != null) {
                        NavigationLocationProvider.this.mLocationChangedListener.onGPSConnectionChanged(false);
                    }
                    if (NavigationLocationProvider.this.locationChangedListeners != null) {
                        Iterator it2 = NavigationLocationProvider.this.locationChangedListeners.iterator();
                        while (it2.hasNext()) {
                            LocationChangedListener locationChangedListener = (LocationChangedListener) ((WeakReference) it2.next()).get();
                            if (locationChangedListener == null) {
                                it2.remove();
                            } else {
                                locationChangedListener.onGPSConnectionChanged(false);
                            }
                        }
                    }
                }
                NavigationLocationProvider.this.setLocation(null);
            }
        }
    }

    public interface d {
        void a();
    }

    public interface e {
        void a();
    }

    private class f implements LocationListener {
        private f() {
        }

        /* synthetic */ f(NavigationLocationProvider navigationLocationProvider, int i) {
            this();
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            if (NavigationLocationProvider.this.useOnlyGPS() || NavigationLocationProvider.this.locationSimulation.a()) {
                return;
            }
            NavigationLocationProvider navigationLocationProvider = NavigationLocationProvider.this;
            navigationLocationProvider.setLocation(NavigationLocationProvider.convertLocation(location, navigationLocationProvider.f706app));
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public NavigationLocationProvider(Context context) {
        this.f706app = context;
        s sVarK = NavigationContext.getNavigationContext().k();
        this.settings = sVarK;
        this.USE_MAGNETIC_FIELD_SENSOR_COMPASS = sVarK.f714n;
        this.USE_FILTER_FOR_COMPASS = sVarK.o;
        this.locationSimulation = new p(context, this);
    }

    private float calcGeoMagneticCorrection(float f2) {
        if (this.previousCorrectionValue == 360.0f && getLastKnownLocation() != null) {
            NavLocation lastKnownLocation = getLastKnownLocation();
            this.previousCorrectionValue = new GeomagneticField((float) lastKnownLocation.getLatitude(), (float) lastKnownLocation.getLongitude(), (float) lastKnownLocation.getAltitude(), System.currentTimeMillis()).getDeclination();
        }
        float f3 = this.previousCorrectionValue;
        return f3 != 360.0f ? f2 + f3 : f2;
    }

    private float calcScreenOrientationCorrection(float f2) {
        int i = this.currentScreenOrientation;
        if (i == 1) {
            return f2 + 90.0f;
        }
        if (i == 2) {
            return f2 + 180.0f;
        }
        return i == 3 ? f2 - 90.0f : f2;
    }

    public static NavLocation convertLocation(Location location) {
        if (location == null) {
            return null;
        }
        NavLocation navLocation = new NavLocation(location.getProvider());
        navLocation.setLatitude(location.getLatitude());
        navLocation.setLongitude(location.getLongitude());
        navLocation.setTime(location.getTime());
        if (location.hasAccuracy()) {
            navLocation.setAccuracy(location.getAccuracy());
        }
        if (location.hasSpeed()) {
            navLocation.setSpeed(location.getSpeed());
        }
        if (location.hasAltitude()) {
            navLocation.setAltitude(location.getAltitude());
        }
        if (location.hasBearing()) {
            navLocation.setBearing(location.getBearing());
        }
        return navLocation;
    }

    public static NavLocation convertLocation(Location location, Context context) {
        if (location == null) {
            return null;
        }
        NavLocation navLocation = new NavLocation(location.getProvider());
        navLocation.setLatitude(location.getLatitude());
        navLocation.setLongitude(location.getLongitude());
        navLocation.setTime(location.getTime());
        if (location.hasAccuracy()) {
            navLocation.setAccuracy(location.getAccuracy());
        }
        if (location.hasSpeed()) {
            navLocation.setSpeed(location.getSpeed());
        }
        if (location.hasAltitude()) {
            navLocation.setAltitude(location.getAltitude());
        }
        if (location.hasBearing()) {
            navLocation.setBearing(location.getBearing());
        }
        return navLocation;
    }

    private void enhanceLocation(NavLocation navLocation) {
        if (navLocation == null || !isRunningOnEmulator()) {
            return;
        }
        updateSpeedEmulator(navLocation);
    }

    private void filterCompassValue() {
        if (this.heading == null && this.previousCompassIndA == 0) {
            Arrays.fill(this.previousCompassValuesA, this.lastValSin);
            Arrays.fill(this.previousCompassValuesB, this.lastValCos);
            this.avgValSin = this.lastValSin;
            this.avgValCos = this.lastValCos;
            return;
        }
        float[] fArr = this.previousCompassValuesA;
        int length = fArr.length;
        int i = (this.previousCompassIndA + 1) % length;
        this.previousCompassIndA = i;
        int i2 = (this.previousCompassIndB + 1) % length;
        this.previousCompassIndB = i2;
        float f2 = this.avgValSin;
        float f3 = -fArr[i];
        float f4 = this.lastValSin;
        float f5 = length;
        this.avgValSin = ((f3 + f4) / f5) + f2;
        fArr[i] = f4;
        float f6 = this.avgValCos;
        float[] fArr2 = this.previousCompassValuesB;
        float f7 = -fArr2[i2];
        float f8 = this.lastValCos;
        this.avgValCos = ((f7 + f8) / f5) + f6;
        fArr2[i2] = f8;
    }

    private float getAngle(float f2, float f3) {
        float fAtan2 = (float) ((Math.atan2(f2, f3) * 180.0d) / 3.141592653589793d);
        while (fAtan2 < -180.0f) {
            fAtan2 += 360.0f;
        }
        while (fAtan2 > 180.0f) {
            fAtan2 -= 360.0f;
        }
        return fAtan2;
    }

    private GpsStatus.Listener getGpsStatusListener(LocationManager locationManager) {
        b bVar = new b(locationManager);
        this.gpsStatusListener = bVar;
        return bVar;
    }

    public static boolean isLocationPermissionAvailable(Context context) {
        return ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static boolean isNotSimulatedLocation(NavLocation navLocation) {
        if (navLocation != null) {
            return !SIMULATED_PROVIDER.equals(navLocation.getProvider());
        }
        return true;
    }

    public static boolean isPointAccurateForRouting(NavLocation navLocation) {
        if (MapplsNavigationHelper.getInstance().getOdometerSpeed() < 0) {
            return navLocation != null && (!navLocation.hasAccuracy() || navLocation.getAccuracy() < ACCURACY_FOR_GPX_AND_ROUTING);
        }
        if (navLocation == null) {
            return false;
        }
        return (!navLocation.hasAccuracy() || navLocation.getAccuracy() < ACCURACY_FOR_GPX_AND_ROUTING) && (MapplsNavigationHelper.getInstance().getMinimumVehicleSpeed() < 0 || (MapplsNavigationHelper.getInstance().getOdometerSpeed() >= 0 ? MapplsNavigationHelper.getInstance().getOdometerSpeed() : (int) navLocation.getSpeed()) >= MapplsNavigationHelper.getInstance().getMinimumVehicleSpeed());
    }

    private boolean isRunningOnEmulator() {
        return Build.DEVICE.equals("generic");
    }

    public static Location revertLocation(NavLocation navLocation, Context context) {
        if (navLocation == null) {
            return null;
        }
        Location location = new Location(navLocation.getProvider());
        location.setLatitude(navLocation.getLatitude());
        location.setLongitude(navLocation.getLongitude());
        location.setTime(navLocation.getTime());
        if (navLocation.hasAccuracy()) {
            location.setAccuracy(navLocation.getAccuracy());
        }
        if (navLocation.hasSpeed()) {
            location.setSpeed(navLocation.getSpeed());
        }
        if (navLocation.hasAltitude()) {
            location.setAltitude(navLocation.getAltitude());
        }
        if (navLocation.hasBearing()) {
            location.setBearing(navLocation.getBearing());
        }
        return location;
    }

    private void scheduleCheckIfGpsLost(NavLocation navLocation) {
        if (this.locationSimulation.a()) {
            this.gpsSignalLost = false;
            return;
        }
        com.mappls.sdk.navigation.routing.d dVar = NavigationContext.getNavigationContext().l;
        if (navLocation != null) {
            long time = navLocation.getTime();
            NavigationContext navigationContext = NavigationContext.getNavigationContext();
            Message messageObtain = Message.obtain(navigationContext.g, new l(navigationContext, new c(time, dVar)));
            messageObtain.what = LOST_LOCATION_MSG_ID;
            navigationContext.g.removeMessages(LOST_LOCATION_MSG_ID);
            navigationContext.g.sendMessageDelayed(messageObtain, LOST_LOCATION_CHECK_DELAY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocation(NavLocation navLocation) {
        if (navLocation == null) {
            updateGPSInfo(null);
        }
        if (navLocation != null && this.gpsSignalLost) {
            this.gpsSignalLost = false;
            com.mappls.sdk.navigation.routing.d dVar = NavigationContext.getNavigationContext().l;
            if (dVar.q() && dVar.h() > 0) {
                LocationChangedListener locationChangedListener = this.mLocationChangedListener;
                if (locationChangedListener != null) {
                    locationChangedListener.onGPSConnectionChanged(true);
                }
                List<WeakReference<LocationChangedListener>> list = this.locationChangedListeners;
                if (list != null) {
                    Iterator<WeakReference<LocationChangedListener>> it2 = list.iterator();
                    while (it2.hasNext()) {
                        LocationChangedListener locationChangedListener2 = it2.next().get();
                        if (locationChangedListener2 == null) {
                            it2.remove();
                        } else {
                            locationChangedListener2.onGPSConnectionChanged(true);
                        }
                    }
                }
            }
        }
        enhanceLocation(navLocation);
        scheduleCheckIfGpsLost(navLocation);
        com.mappls.sdk.navigation.routing.d dVar2 = NavigationContext.getNavigationContext().l;
        if (navLocation != null) {
            NavigationContext.getNavigationContext().h.updateLocation(navLocation);
            Iterator it3 = q.b().iterator();
            while (it3.hasNext()) {
                ((q) it3.next()).d();
            }
        }
        if (dVar2.q()) {
            StringBuilder sbA = h.a("isPointAccurateForRouting(location) = ");
            sbA.append(isPointAccurateForRouting(navLocation));
            NavigationLogger.d(sbA.toString(), new Object[0]);
            if (navLocation == null || isPointAccurateForRouting(navLocation)) {
                navLocation = dVar2.a(navLocation, this.settings.v.get().booleanValue());
                LocationChangedListener locationChangedListener3 = this.mLocationChangedListener;
                if (locationChangedListener3 != null) {
                    locationChangedListener3.onLocationChanged(revertLocation(navLocation, this.f706app));
                }
                List<WeakReference<LocationChangedListener>> list2 = this.locationChangedListeners;
                if (list2 != null) {
                    Iterator<WeakReference<LocationChangedListener>> it4 = list2.iterator();
                    while (it4.hasNext()) {
                        LocationChangedListener locationChangedListener4 = it4.next().get();
                        if (locationChangedListener4 == null) {
                            it4.remove();
                        } else {
                            locationChangedListener4.onLocationChanged(revertLocation(navLocation, this.f706app));
                        }
                    }
                }
            }
        } else if ((dVar2.u() && this.settings.m() == null) || getLocationSimulation().a()) {
            dVar2.a(navLocation, false);
        }
        NavigationContext.getNavigationContext().r.b();
        this.location = navLocation;
        updateLocation(navLocation);
    }

    private void stopLocationRequests() {
        LocationManager locationManager = (LocationManager) this.f706app.getSystemService(FirebaseAnalytics.Param.LOCATION);
        locationManager.removeGpsStatusListener(this.gpsStatusListener);
        LocationListener locationListenerPoll = this.gpsListener;
        while (true) {
            locationManager.removeUpdates(locationListenerPoll);
            if (this.networkListeners.isEmpty()) {
                return;
            } else {
                locationListenerPoll = this.networkListeners.poll();
            }
        }
    }

    private void updateCompassVal() {
        this.heading = Float.valueOf(getAngle(this.avgValSin, this.avgValCos));
        for (d dVar : this.compassListeners) {
            this.heading.floatValue();
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGPSInfo(GpsStatus gpsStatus) {
        int i;
        int i2;
        boolean z = false;
        if (gpsStatus != null) {
            Iterator<GpsSatellite> it2 = gpsStatus.getSatellites().iterator();
            i = 0;
            i2 = 0;
            while (it2.hasNext()) {
                i++;
                if (it2.next().usedInFix()) {
                    i2++;
                    z = true;
                }
            }
        } else {
            i = 0;
            i2 = 0;
        }
        GPSInfo gPSInfo = this.gpsInfo;
        gPSInfo.fixed = z;
        gPSInfo.foundSatellites = i;
        gPSInfo.usedSatellites = i2;
        LocationChangedListener locationChangedListener = this.mLocationChangedListener;
        if (locationChangedListener != null) {
            locationChangedListener.onSatelliteInfoChanged(gPSInfo);
        }
        List<WeakReference<LocationChangedListener>> list = this.locationChangedListeners;
        if (list != null) {
            Iterator<WeakReference<LocationChangedListener>> it3 = list.iterator();
            while (it3.hasNext()) {
                LocationChangedListener locationChangedListener2 = it3.next().get();
                if (locationChangedListener2 == null) {
                    it3.remove();
                } else {
                    locationChangedListener2.onSatelliteInfoChanged(this.gpsInfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocation(NavLocation navLocation) {
        Iterator<e> it2 = this.locationListeners.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    private void updateSpeedEmulator(NavLocation navLocation) {
        if (navLocation == null || navLocation.distanceTo(navLocation) <= 3.0f) {
            return;
        }
        float fDistanceTo = navLocation.distanceTo(navLocation);
        long time = navLocation.getTime() - navLocation.getTime();
        float f2 = time == 0 ? 0.0f : (fDistanceTo * 1000.0f) / time;
        if (f2 > 100.0f) {
            f2 = 100.0f;
        }
        navLocation.setSpeed(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean useOnlyGPS() {
        if (!NavigationContext.getNavigationContext().l.q() && System.currentTimeMillis() - this.lastTimeGPSLocationFixed >= 12000) {
            return isRunningOnEmulator();
        }
        return true;
    }

    public void addCompassListener(d dVar) {
        if (this.compassListeners.contains(dVar)) {
            return;
        }
        this.compassListeners.add(dVar);
    }

    public void addLocationChangeListener(LocationChangedListener locationChangedListener) {
        this.locationChangedListeners.add(new WeakReference<>(locationChangedListener));
    }

    public void addLocationListener(e eVar) {
        if (this.locationListeners.contains(eVar)) {
            return;
        }
        this.locationListeners.add(eVar);
    }

    public boolean checkGPSEnabled(Context context) {
        boolean zIsProviderEnabled;
        boolean zIsProviderEnabled2;
        LocationManager locationManager = (LocationManager) this.f706app.getSystemService(FirebaseAnalytics.Param.LOCATION);
        try {
            zIsProviderEnabled = locationManager.isProviderEnabled("gps");
        } catch (Exception e2) {
            NavigationLogger.e(e2);
            zIsProviderEnabled = false;
        }
        try {
            zIsProviderEnabled2 = locationManager.isProviderEnabled("network");
        } catch (Exception e3) {
            NavigationLogger.e(e3);
            zIsProviderEnabled2 = false;
        }
        return zIsProviderEnabled || zIsProviderEnabled2;
    }

    public void checkIfLastKnownLocationIsValid() {
        NavLocation lastKnownLocation = getLastKnownLocation();
        if (lastKnownLocation == null || System.currentTimeMillis() - lastKnownLocation.getTime() <= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            return;
        }
        setLocation(null);
    }

    public NavLocation getFirstTimeRunDefaultLocation() {
        LocationManager locationManager;
        List<String> providers;
        if (!isLocationPermissionAvailable(this.f706app) || (providers = (locationManager = (LocationManager) this.f706app.getSystemService(FirebaseAnalytics.Param.LOCATION)).getProviders(true)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(providers);
        int iIndexOf = arrayList.indexOf("passive");
        if (iIndexOf > -1) {
            arrayList.add(0, (String) arrayList.remove(iIndexOf));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            NavLocation navLocationConvertLocation = convertLocation(locationManager.getLastKnownLocation((String) it2.next()), this.f706app);
            if (navLocationConvertLocation != null) {
                return navLocationConvertLocation;
            }
        }
        return null;
    }

    public GPSInfo getGPSInfo() {
        return this.gpsInfo;
    }

    public synchronized Float getHeading() {
        return this.heading;
    }

    public NavLocation getLastKnownLocation() {
        return this.location;
    }

    public Location getLastLocation() {
        return this.lastLocation;
    }

    public p getLocationSimulation() {
        return this.locationSimulation;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0045 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:12:0x0010, B:21:0x0022, B:25:0x0037, B:27:0x0045, B:29:0x0049, B:31:0x004d, B:36:0x005a, B:41:0x006f, B:43:0x009f, B:45:0x00ab, B:44:0x00a3, B:22:0x0027, B:23:0x002f), top: B:55:0x0010, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x009f A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:12:0x0010, B:21:0x0022, B:25:0x0037, B:27:0x0045, B:29:0x0049, B:31:0x004d, B:36:0x005a, B:41:0x006f, B:43:0x009f, B:45:0x00ab, B:44:0x00a3, B:22:0x0027, B:23:0x002f), top: B:55:0x0010, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00a3 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:12:0x0010, B:21:0x0022, B:25:0x0037, B:27:0x0045, B:29:0x0049, B:31:0x004d, B:36:0x005a, B:41:0x006f, B:43:0x009f, B:45:0x00ab, B:44:0x00a3, B:22:0x0027, B:23:0x002f), top: B:55:0x0010, outer: #1 }] */
    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float degrees;
        float[] fArr;
        float[] fArr2;
        if (this.inUpdateValue) {
            return;
        }
        synchronized (this) {
            if (this.sensorRegistered) {
                this.inUpdateValue = true;
                try {
                    int type = sensorEvent.sensor.getType();
                    if (type != 1) {
                        if (type == 2) {
                            System.arraycopy(sensorEvent.values, 0, this.mGeoMags, 0, 3);
                        } else {
                            if (type != 3) {
                                this.inUpdateValue = false;
                                return;
                            }
                            degrees = sensorEvent.values[0];
                        }
                        if (this.USE_MAGNETIC_FIELD_SENSOR_COMPASS.get().booleanValue()) {
                            fArr = this.mGravs;
                            if (fArr != null || (fArr2 = this.mGeoMags) == null) {
                                this.inUpdateValue = false;
                                return;
                            } else {
                                if (!SensorManager.getRotationMatrix(this.mRotationM, null, fArr, fArr2)) {
                                    this.inUpdateValue = false;
                                    return;
                                }
                                degrees = (float) Math.toDegrees(SensorManager.getOrientation(this.mRotationM, new float[3])[0]);
                            }
                        }
                        double dCalcGeoMagneticCorrection = (float) (((double) (calcGeoMagneticCorrection(calcScreenOrientationCorrection(degrees)) / 180.0f)) * 3.141592653589793d);
                        this.lastValSin = (float) Math.sin(dCalcGeoMagneticCorrection);
                        this.lastValCos = (float) Math.cos(dCalcGeoMagneticCorrection);
                        if (this.USE_FILTER_FOR_COMPASS.get().booleanValue()) {
                            filterCompassValue();
                        } else {
                            this.avgValSin = this.lastValSin;
                            this.avgValCos = this.lastValCos;
                        }
                        updateCompassVal();
                        this.inUpdateValue = false;
                    }
                    System.arraycopy(sensorEvent.values, 0, this.mGravs, 0, 3);
                    degrees = 0.0f;
                    if (this.USE_MAGNETIC_FIELD_SENSOR_COMPASS.get().booleanValue()) {
                        fArr = this.mGravs;
                        if (fArr != null) {
                        }
                        this.inUpdateValue = false;
                        return;
                    }
                    double dCalcGeoMagneticCorrection2 = (float) (((double) (calcGeoMagneticCorrection(calcScreenOrientationCorrection(degrees)) / 180.0f)) * 3.141592653589793d);
                    this.lastValSin = (float) Math.sin(dCalcGeoMagneticCorrection2);
                    this.lastValCos = (float) Math.cos(dCalcGeoMagneticCorrection2);
                    if (this.USE_FILTER_FOR_COMPASS.get().booleanValue()) {
                        filterCompassValue();
                    } else {
                        this.avgValSin = this.lastValSin;
                        this.avgValCos = this.lastValCos;
                    }
                    updateCompassVal();
                    this.inUpdateValue = false;
                } catch (Throwable th) {
                    this.inUpdateValue = false;
                    throw th;
                }
            }
        }
    }

    public void pauseAllUpdates() {
        stopLocationRequests();
        registerOrUnregisterCompassListener(false);
    }

    public void reDownloadAGPS() {
        if (System.currentTimeMillis() - ((Long) NavigationContext.getNavigationContext().k().u0.get()).longValue() <= AGPS_TO_REDOWNLOAD || !NavigationContext.getNavigationContext().k().a(true)) {
            return;
        }
        try {
            LocationManager locationManager = (LocationManager) this.f706app.getSystemService(FirebaseAnalytics.Param.LOCATION);
            locationManager.sendExtraCommand("gps", "delete_aiding_data", null);
            Bundle bundle = new Bundle();
            locationManager.sendExtraCommand("gps", "force_xtra_injection", bundle);
            locationManager.sendExtraCommand("gps", "force_time_injection", bundle);
            NavigationContext.getNavigationContext().k().u0.set(Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e2) {
            NavigationContext.getNavigationContext().k().u0.set(0L);
            NavigationLogger.d(e2);
        }
    }

    public synchronized void registerOrUnregisterCompassListener(boolean z) {
        boolean z2 = this.sensorRegistered;
        if (z2 && !z) {
            NavigationLogger.d("Disable sensor", new Object[0]);
            ((SensorManager) this.f706app.getSystemService("sensor")).unregisterListener(this);
            this.sensorRegistered = false;
            this.heading = null;
        } else if (!z2 && z) {
            NavigationLogger.d("Enable sensor", new Object[0]);
            SensorManager sensorManager = (SensorManager) this.f706app.getSystemService("sensor");
            if (this.USE_MAGNETIC_FIELD_SENSOR_COMPASS.get().booleanValue()) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                if (defaultSensor == null || !sensorManager.registerListener(this, defaultSensor, 2)) {
                    NavigationLogger.d("Sensor accelerometer could not be enabled", new Object[0]);
                }
                Sensor defaultSensor2 = sensorManager.getDefaultSensor(2);
                if (defaultSensor2 == null || !sensorManager.registerListener(this, defaultSensor2, 2)) {
                    NavigationLogger.d("Sensor magnetic field could not be enabled", new Object[0]);
                }
            } else {
                Sensor defaultSensor3 = sensorManager.getDefaultSensor(3);
                if (defaultSensor3 == null || !sensorManager.registerListener(this, defaultSensor3, 2)) {
                    NavigationLogger.d("Sensor orientation could not be enabled", new Object[0]);
                }
            }
            this.sensorRegistered = true;
        }
    }

    public void removeCompassListener(d dVar) {
        this.compassListeners.remove(dVar);
    }

    public void removeLocationChangeListener(LocationChangedListener locationChangedListener) {
        Iterator<WeakReference<LocationChangedListener>> it2 = this.locationChangedListeners.iterator();
        while (it2.hasNext()) {
            LocationChangedListener locationChangedListener2 = it2.next().get();
            if (locationChangedListener2 == null || locationChangedListener == locationChangedListener2) {
                it2.remove();
            }
        }
    }

    public void removeLocationListener(e eVar) {
        this.locationListeners.remove(eVar);
    }

    public void resumeAllUpdates() {
        LocationManager locationManager = (LocationManager) this.f706app.getSystemService(FirebaseAnalytics.Param.LOCATION);
        reDownloadAGPS();
        if (isLocationPermissionAvailable(this.f706app)) {
            locationManager.addGpsStatusListener(getGpsStatusListener(locationManager));
            int i = 0;
            try {
                locationManager.requestLocationUpdates("gps", 0L, 0.0f, this.gpsListener);
            } catch (IllegalArgumentException e2) {
                NavigationLogger.d(e2, "GPS location provider not available", new Object[0]);
            }
            List<String> providers = locationManager.getProviders(true);
            if (providers == null) {
                return;
            }
            for (String str : providers) {
                if (str != null && !str.equals("gps")) {
                    try {
                        f fVar = new f(this, i);
                        locationManager.requestLocationUpdates(str, 0L, 0.0f, fVar);
                        this.networkListeners.add(fVar);
                    } catch (IllegalArgumentException e3) {
                        NavigationLogger.d(e3, n.a(str, " location provider not available"), new Object[0]);
                    }
                }
            }
        }
    }

    public void setAccuracyForGpxAndRouting(int i) {
        ACCURACY_FOR_GPX_AND_ROUTING = i;
    }

    @Deprecated
    public void setLocationChangedListener(LocationChangedListener locationChangedListener) {
        this.mLocationChangedListener = locationChangedListener;
    }

    void setLocationFromService(Location location, NavLocation navLocation, boolean z) {
        if (this.locationSimulation.a()) {
            return;
        }
        if (z) {
            scheduleCheckIfGpsLost(navLocation);
        }
        MapplsApiConfiguration.getInstance().setLocation(location);
        if (MapplsLMSManager.isInitialised()) {
            MapplsLMSManager.getInstance().setCurrentLocation(location);
        }
        this.location = navLocation;
        this.lastLocation = location;
        if (location != null) {
            try {
                if (com.mappls.sdk.traffic.a.b() != null) {
                    com.mappls.sdk.traffic.a.b().a(location);
                }
            } catch (Exception e2) {
                NavigationLogger.e(e2);
            }
        }
        setLocation(navLocation);
    }

    public void setLocationFromSimulation(NavLocation navLocation) {
        setLocation(navLocation);
        NavigationContext.getNavigationContext().setCurrentLocation(revertLocation(navLocation, this.f706app));
    }

    public void setSatelliteInfo(GPSInfo gPSInfo) {
        this.gpsInfo = gPSInfo;
        LocationChangedListener locationChangedListener = this.mLocationChangedListener;
        if (locationChangedListener != null) {
            locationChangedListener.onSatelliteInfoChanged(gPSInfo);
        }
        List<WeakReference<LocationChangedListener>> list = this.locationChangedListeners;
        if (list != null) {
            Iterator<WeakReference<LocationChangedListener>> it2 = list.iterator();
            while (it2.hasNext()) {
                LocationChangedListener locationChangedListener2 = it2.next().get();
                if (locationChangedListener2 == null) {
                    it2.remove();
                } else {
                    locationChangedListener2.onSatelliteInfoChanged(gPSInfo);
                }
            }
        }
    }

    public void updateScreenOrientation(int i) {
        this.currentScreenOrientation = i;
    }
}
