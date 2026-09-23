package com.mappls.sdk.navigation;

/* JADX INFO: loaded from: classes4.dex */
public class NavLocation {
    private float mAccuracy;
    private double mAltitude;
    private float mBearing;
    private float mDistance;
    private boolean mHasAccuracy;
    private boolean mHasAltitude;
    private boolean mHasBearing;
    private boolean mHasSpeed;
    private float mInitialBearing;
    private double mLat1;
    private double mLat2;
    private double mLatitude;
    private double mLon1;
    private double mLon2;
    private double mLongitude;
    private String mProvider;
    private float[] mResults;
    private float mSpeed;
    private long mTime;

    public NavLocation(NavLocation navLocation) {
        this.mTime = 0L;
        this.mLatitude = 0.0d;
        this.mLongitude = 0.0d;
        this.mHasAltitude = false;
        this.mAltitude = 0.0d;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasBearing = false;
        this.mBearing = 0.0f;
        this.mHasAccuracy = false;
        this.mAccuracy = 0.0f;
        this.mLat1 = 0.0d;
        this.mLon1 = 0.0d;
        this.mLat2 = 0.0d;
        this.mLon2 = 0.0d;
        this.mDistance = 0.0f;
        this.mInitialBearing = 0.0f;
        this.mResults = new float[2];
        set(navLocation);
    }

    public NavLocation(String str) {
        this.mTime = 0L;
        this.mLatitude = 0.0d;
        this.mLongitude = 0.0d;
        this.mHasAltitude = false;
        this.mAltitude = 0.0d;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasBearing = false;
        this.mBearing = 0.0f;
        this.mHasAccuracy = false;
        this.mAccuracy = 0.0f;
        this.mLat1 = 0.0d;
        this.mLon1 = 0.0d;
        this.mLat2 = 0.0d;
        this.mLon2 = 0.0d;
        this.mDistance = 0.0f;
        this.mInitialBearing = 0.0f;
        this.mResults = new float[2];
        this.mProvider = str;
    }

    private static void computeDistanceAndBearing(double d, double d2, double d3, double d4, float[] fArr) {
        double d5;
        double d6;
        float fA = (float) com.mappls.sdk.navigation.util.d.a(d, d2, d3, d4);
        double d7 = (0.017453292519943295d * d4) - (d2 * 0.017453292519943295d);
        double dAtan = Math.atan(Math.tan(d * 0.017453292519943295d) * 0.996647189328169d);
        double dAtan2 = Math.atan(Math.tan(d3 * 0.017453292519943295d) * 0.996647189328169d);
        double dCos = Math.cos(dAtan);
        double dCos2 = Math.cos(dAtan2);
        double dSin = Math.sin(dAtan);
        double dSin2 = Math.sin(dAtan2);
        double d8 = dCos * dCos2;
        double d9 = dSin * dSin2;
        double d10 = d7;
        double d11 = 0.0d;
        double dAtan3 = 0.0d;
        double d12 = 0.0d;
        double dCos3 = 0.0d;
        double dSin3 = 0.0d;
        int i = 0;
        while (true) {
            if (i >= 20) {
                d5 = dSin;
                d6 = dSin2;
                break;
            }
            dCos3 = Math.cos(d10);
            dSin3 = Math.sin(d10);
            double d13 = dCos2 * dSin3;
            double d14 = (dCos * dSin2) - ((dSin * dCos2) * dCos3);
            d5 = dSin;
            double dSqrt = Math.sqrt((d14 * d14) + (d13 * d13));
            d6 = dSin2;
            double d15 = (d8 * dCos3) + d9;
            dAtan3 = Math.atan2(dSqrt, d15);
            double d16 = dSqrt == 0.0d ? 0.0d : (d8 * dSin3) / dSqrt;
            double d17 = 1.0d - (d16 * d16);
            double d18 = d17 == 0.0d ? 0.0d : d15 - ((d9 * 2.0d) / d17);
            double d19 = 0.006739496756586903d * d17;
            double d20 = ((((((320.0d - (175.0d * d19)) * d19) - 768.0d) * d19) + 4096.0d) * (d19 / 16384.0d)) + 1.0d;
            double d21 = (((((74.0d - (47.0d * d19)) * d19) - 128.0d) * d19) + 256.0d) * (d19 / 1024.0d);
            double d22 = (((4.0d - (d17 * 3.0d)) * 0.0033528106718309896d) + 4.0d) * 2.0955066698943685E-4d * d17;
            double d23 = d18 * d18;
            double d24 = ((((((d23 * 2.0d) - 1.0d) * d15) - (((d23 * 4.0d) - 3.0d) * ((((dSqrt * 4.0d) * dSqrt) - 3.0d) * ((d21 / 6.0d) * d18)))) * (d21 / 4.0d)) + d18) * d21 * dSqrt;
            double d25 = ((((((((2.0d * d18) * d18) - 1.0d) * d22 * d15) + d18) * dSqrt * d22) + dAtan3) * (1.0d - d22) * 0.0033528106718309896d * d16) + d7;
            if (Math.abs((d25 - d10) / d25) < 1.0E-12d) {
                d12 = d24;
                d11 = d20;
                break;
            }
            i++;
            dSin = d5;
            dSin2 = d6;
            d10 = d25;
            d12 = d24;
            d11 = d20;
        }
        fArr[0] = (float) (6356752.3142d * d11 * (dAtan3 - d12));
        if (fArr.length > 1) {
            double d26 = dCos * d6;
            double d27 = d5;
            fArr[1] = (float) (((double) ((float) Math.atan2(dCos2 * dSin3, d26 - ((d27 * dCos2) * dCos3)))) * 57.29577951308232d);
            if (fArr.length > 2) {
                fArr[2] = (float) (((double) ((float) Math.atan2(dCos * dSin3, (d26 * dCos3) + ((-d27) * dCos2)))) * 57.29577951308232d);
            }
        }
        fArr[0] = fA;
    }

    public static void distanceBetween(double d, double d2, double d3, double d4, float[] fArr) {
        if (fArr == null || fArr.length < 1) {
            throw new IllegalArgumentException("results is null or has length < 1");
        }
        computeDistanceAndBearing(d, d2, d3, d4, fArr);
    }

    public float bearingTo(NavLocation navLocation) {
        float f;
        synchronized (this.mResults) {
            double d = this.mLatitude;
            if (d != this.mLat1 || this.mLongitude != this.mLon1 || navLocation.mLatitude != this.mLat2 || navLocation.mLongitude != this.mLon2) {
                computeDistanceAndBearing(d, this.mLongitude, navLocation.mLatitude, navLocation.mLongitude, this.mResults);
                this.mLat1 = this.mLatitude;
                this.mLon1 = this.mLongitude;
                this.mLat2 = navLocation.mLatitude;
                this.mLon2 = navLocation.mLongitude;
                float[] fArr = this.mResults;
                this.mDistance = fArr[0];
                this.mInitialBearing = fArr[1];
            }
            f = this.mInitialBearing;
        }
        return f;
    }

    public float distanceTo(NavLocation navLocation) {
        float f;
        synchronized (this.mResults) {
            double d = this.mLatitude;
            if (d != this.mLat1 || this.mLongitude != this.mLon1 || navLocation.mLatitude != this.mLat2 || navLocation.mLongitude != this.mLon2) {
                computeDistanceAndBearing(d, this.mLongitude, navLocation.mLatitude, navLocation.mLongitude, this.mResults);
                this.mLat1 = this.mLatitude;
                this.mLon1 = this.mLongitude;
                this.mLat2 = navLocation.mLatitude;
                this.mLon2 = navLocation.mLongitude;
                float[] fArr = this.mResults;
                this.mDistance = fArr[0];
                this.mInitialBearing = fArr[1];
            }
            f = this.mDistance;
        }
        return f;
    }

    public float getAccuracy() {
        return this.mAccuracy;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public float getBearing() {
        return this.mBearing;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public String getProvider() {
        return this.mProvider;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public long getTime() {
        return this.mTime;
    }

    public boolean hasAccuracy() {
        return this.mHasAccuracy;
    }

    public boolean hasAltitude() {
        return this.mHasAltitude;
    }

    public boolean hasBearing() {
        return this.mHasBearing;
    }

    public boolean hasSpeed() {
        return this.mHasSpeed;
    }

    public void removeAccuracy() {
        this.mAccuracy = 0.0f;
        this.mHasAccuracy = false;
    }

    public void removeAltitude() {
        this.mAltitude = 0.0d;
        this.mHasAltitude = false;
    }

    public void removeBearing() {
        this.mBearing = 0.0f;
        this.mHasBearing = false;
    }

    public void removeSpeed() {
        this.mSpeed = 0.0f;
        this.mHasSpeed = false;
    }

    public void reset() {
        this.mProvider = null;
        this.mTime = 0L;
        this.mLatitude = 0.0d;
        this.mLongitude = 0.0d;
        this.mHasAltitude = false;
        this.mAltitude = 0.0d;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasBearing = false;
        this.mBearing = 0.0f;
        this.mHasAccuracy = false;
        this.mAccuracy = 0.0f;
    }

    public void set(NavLocation navLocation) {
        this.mProvider = navLocation.mProvider;
        this.mTime = navLocation.mTime;
        this.mLatitude = navLocation.mLatitude;
        this.mLongitude = navLocation.mLongitude;
        this.mHasAltitude = navLocation.mHasAltitude;
        this.mAltitude = navLocation.mAltitude;
        this.mHasSpeed = navLocation.mHasSpeed;
        this.mSpeed = navLocation.mSpeed;
        this.mHasBearing = navLocation.mHasBearing;
        this.mBearing = navLocation.mBearing;
        this.mHasAccuracy = navLocation.mHasAccuracy;
        this.mAccuracy = navLocation.mAccuracy;
    }

    public void setAccuracy(float f) {
        this.mAccuracy = f;
        this.mHasAccuracy = true;
    }

    public void setAltitude(double d) {
        this.mAltitude = d;
        this.mHasAltitude = true;
    }

    public void setBearing(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        while (f >= 360.0f) {
            f -= 360.0f;
        }
        this.mBearing = f;
        this.mHasBearing = true;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }

    public void setProvider(String str) {
        this.mProvider = str;
    }

    public void setSpeed(float f) {
        this.mSpeed = f;
        this.mHasSpeed = true;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public String toString() {
        StringBuilder sbA = h.a("Location[mProvider=");
        sbA.append(this.mProvider);
        sbA.append(",mTime=");
        sbA.append(this.mTime);
        sbA.append(",mLatitude=");
        sbA.append(this.mLatitude);
        sbA.append(",mLongitude=");
        sbA.append(this.mLongitude);
        sbA.append(",mHasAltitude=");
        sbA.append(this.mHasAltitude);
        sbA.append(",mAltitude=");
        sbA.append(this.mAltitude);
        sbA.append(",mHasSpeed=");
        sbA.append(this.mHasSpeed);
        sbA.append(",mSpeed=");
        sbA.append(this.mSpeed);
        sbA.append(",mHasBearing=");
        sbA.append(this.mHasBearing);
        sbA.append(",mBearing=");
        sbA.append(this.mBearing);
        sbA.append(",mHasAccuracy=");
        sbA.append(this.mHasAccuracy);
        sbA.append(",mAccuracy=");
        sbA.append(this.mAccuracy);
        return sbA.toString();
    }
}
