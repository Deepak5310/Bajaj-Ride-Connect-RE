package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private static final String a = "c";
    private final aa b;
    private LatLngBounds c;
    private float d;
    private float e;

    public c() {
        aa aaVar = aa.a;
        com.google.android.libraries.navigation.internal.abf.s.k(aaVar, "cameraUtils");
        this.b = aaVar;
        this.c = null;
        this.d = 2.0f;
        this.e = 21.0f;
    }

    private static double i(double d, double d2, double d3) {
        return Math.max(Math.min(d, d3), d2);
    }

    private static double j(double d, double d2) {
        double dAbs = Math.abs(d - d2);
        return dAbs < 180.0d ? dAbs : 360.0d - dAbs;
    }

    private static float k(float f, float f2, float f3) {
        return Math.max(Math.min(f, f3), f2);
    }

    private final float l(float f, LatLng latLng, boolean z, com.google.android.libraries.navigation.internal.abf.ak akVar, double d) {
        float fP = p(m(f), z, akVar, d);
        h(latLng);
        return k(fP, 2.0f, 21.0f);
    }

    private final synchronized float m(float f) {
        return k(f, this.d, this.e);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x007e A[Catch: all -> 0x025d, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x001e, B:8:0x0036, B:16:0x0053, B:18:0x007e, B:27:0x00ad, B:29:0x00c1, B:33:0x00ca, B:35:0x00f5, B:36:0x00f9, B:41:0x0119, B:47:0x0128, B:53:0x0155, B:57:0x01b3, B:59:0x01c1, B:68:0x0224, B:70:0x0239, B:72:0x023f, B:77:0x0247, B:63:0x01d2, B:65:0x01e4, B:56:0x0199, B:39:0x0101, B:40:0x0106, B:21:0x0086, B:25:0x00a8, B:24:0x009e, B:26:0x00ab), top: B:83:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0080  */
    /* JADX WARN: Code duplicated, block: B:21:0x0086 A[Catch: all -> 0x025d, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x001e, B:8:0x0036, B:16:0x0053, B:18:0x007e, B:27:0x00ad, B:29:0x00c1, B:33:0x00ca, B:35:0x00f5, B:36:0x00f9, B:41:0x0119, B:47:0x0128, B:53:0x0155, B:57:0x01b3, B:59:0x01c1, B:68:0x0224, B:70:0x0239, B:72:0x023f, B:77:0x0247, B:63:0x01d2, B:65:0x01e4, B:56:0x0199, B:39:0x0101, B:40:0x0106, B:21:0x0086, B:25:0x00a8, B:24:0x009e, B:26:0x00ab), top: B:83:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0096  */
    /* JADX WARN: Code duplicated, block: B:24:0x009e A[Catch: all -> 0x025d, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x001e, B:8:0x0036, B:16:0x0053, B:18:0x007e, B:27:0x00ad, B:29:0x00c1, B:33:0x00ca, B:35:0x00f5, B:36:0x00f9, B:41:0x0119, B:47:0x0128, B:53:0x0155, B:57:0x01b3, B:59:0x01c1, B:68:0x0224, B:70:0x0239, B:72:0x023f, B:77:0x0247, B:63:0x01d2, B:65:0x01e4, B:56:0x0199, B:39:0x0101, B:40:0x0106, B:21:0x0086, B:25:0x00a8, B:24:0x009e, B:26:0x00ab), top: B:83:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00ab A[Catch: all -> 0x025d, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x001e, B:8:0x0036, B:16:0x0053, B:18:0x007e, B:27:0x00ad, B:29:0x00c1, B:33:0x00ca, B:35:0x00f5, B:36:0x00f9, B:41:0x0119, B:47:0x0128, B:53:0x0155, B:57:0x01b3, B:59:0x01c1, B:68:0x0224, B:70:0x0239, B:72:0x023f, B:77:0x0247, B:63:0x01d2, B:65:0x01e4, B:56:0x0199, B:39:0x0101, B:40:0x0106, B:21:0x0086, B:25:0x00a8, B:24:0x009e, B:26:0x00ab), top: B:83:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f5 A[Catch: all -> 0x025d, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x001e, B:8:0x0036, B:16:0x0053, B:18:0x007e, B:27:0x00ad, B:29:0x00c1, B:33:0x00ca, B:35:0x00f5, B:36:0x00f9, B:41:0x0119, B:47:0x0128, B:53:0x0155, B:57:0x01b3, B:59:0x01c1, B:68:0x0224, B:70:0x0239, B:72:0x023f, B:77:0x0247, B:63:0x01d2, B:65:0x01e4, B:56:0x0199, B:39:0x0101, B:40:0x0106, B:21:0x0086, B:25:0x00a8, B:24:0x009e, B:26:0x00ab), top: B:83:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:39:0x0101 A[Catch: all -> 0x025d, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x001e, B:8:0x0036, B:16:0x0053, B:18:0x007e, B:27:0x00ad, B:29:0x00c1, B:33:0x00ca, B:35:0x00f5, B:36:0x00f9, B:41:0x0119, B:47:0x0128, B:53:0x0155, B:57:0x01b3, B:59:0x01c1, B:68:0x0224, B:70:0x0239, B:72:0x023f, B:77:0x0247, B:63:0x01d2, B:65:0x01e4, B:56:0x0199, B:39:0x0101, B:40:0x0106, B:21:0x0086, B:25:0x00a8, B:24:0x009e, B:26:0x00ab), top: B:83:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0106 A[Catch: all -> 0x025d, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x001e, B:8:0x0036, B:16:0x0053, B:18:0x007e, B:27:0x00ad, B:29:0x00c1, B:33:0x00ca, B:35:0x00f5, B:36:0x00f9, B:41:0x0119, B:47:0x0128, B:53:0x0155, B:57:0x01b3, B:59:0x01c1, B:68:0x0224, B:70:0x0239, B:72:0x023f, B:77:0x0247, B:63:0x01d2, B:65:0x01e4, B:56:0x0199, B:39:0x0101, B:40:0x0106, B:21:0x0086, B:25:0x00a8, B:24:0x009e, B:26:0x00ab), top: B:83:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x011f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0127  */
    /* JADX WARN: Code duplicated, block: B:49:0x0149  */
    /* JADX WARN: Code duplicated, block: B:52:0x0154  */
    /* JADX WARN: Code duplicated, block: B:55:0x0198  */
    /* JADX WARN: Code duplicated, block: B:56:0x0199 A[Catch: all -> 0x025d, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x001e, B:8:0x0036, B:16:0x0053, B:18:0x007e, B:27:0x00ad, B:29:0x00c1, B:33:0x00ca, B:35:0x00f5, B:36:0x00f9, B:41:0x0119, B:47:0x0128, B:53:0x0155, B:57:0x01b3, B:59:0x01c1, B:68:0x0224, B:70:0x0239, B:72:0x023f, B:77:0x0247, B:63:0x01d2, B:65:0x01e4, B:56:0x0199, B:39:0x0101, B:40:0x0106, B:21:0x0086, B:25:0x00a8, B:24:0x009e, B:26:0x00ab), top: B:83:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x01c1 A[Catch: all -> 0x025d, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x001e, B:8:0x0036, B:16:0x0053, B:18:0x007e, B:27:0x00ad, B:29:0x00c1, B:33:0x00ca, B:35:0x00f5, B:36:0x00f9, B:41:0x0119, B:47:0x0128, B:53:0x0155, B:57:0x01b3, B:59:0x01c1, B:68:0x0224, B:70:0x0239, B:72:0x023f, B:77:0x0247, B:63:0x01d2, B:65:0x01e4, B:56:0x0199, B:39:0x0101, B:40:0x0106, B:21:0x0086, B:25:0x00a8, B:24:0x009e, B:26:0x00ab), top: B:83:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01d2 A[Catch: all -> 0x025d, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x001e, B:8:0x0036, B:16:0x0053, B:18:0x007e, B:27:0x00ad, B:29:0x00c1, B:33:0x00ca, B:35:0x00f5, B:36:0x00f9, B:41:0x0119, B:47:0x0128, B:53:0x0155, B:57:0x01b3, B:59:0x01c1, B:68:0x0224, B:70:0x0239, B:72:0x023f, B:77:0x0247, B:63:0x01d2, B:65:0x01e4, B:56:0x0199, B:39:0x0101, B:40:0x0106, B:21:0x0086, B:25:0x00a8, B:24:0x009e, B:26:0x00ab), top: B:83:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01e4 A[Catch: all -> 0x025d, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x001e, B:8:0x0036, B:16:0x0053, B:18:0x007e, B:27:0x00ad, B:29:0x00c1, B:33:0x00ca, B:35:0x00f5, B:36:0x00f9, B:41:0x0119, B:47:0x0128, B:53:0x0155, B:57:0x01b3, B:59:0x01c1, B:68:0x0224, B:70:0x0239, B:72:0x023f, B:77:0x0247, B:63:0x01d2, B:65:0x01e4, B:56:0x0199, B:39:0x0101, B:40:0x0106, B:21:0x0086, B:25:0x00a8, B:24:0x009e, B:26:0x00ab), top: B:83:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0220  */
    /* JADX WARN: Code duplicated, block: B:70:0x0239 A[Catch: all -> 0x025d, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x001e, B:8:0x0036, B:16:0x0053, B:18:0x007e, B:27:0x00ad, B:29:0x00c1, B:33:0x00ca, B:35:0x00f5, B:36:0x00f9, B:41:0x0119, B:47:0x0128, B:53:0x0155, B:57:0x01b3, B:59:0x01c1, B:68:0x0224, B:70:0x0239, B:72:0x023f, B:77:0x0247, B:63:0x01d2, B:65:0x01e4, B:56:0x0199, B:39:0x0101, B:40:0x0106, B:21:0x0086, B:25:0x00a8, B:24:0x009e, B:26:0x00ab), top: B:83:0x0009 }] */
    private final synchronized CameraPosition n(CameraPosition cameraPosition, double d, com.google.android.libraries.navigation.internal.abf.ak akVar, boolean z, double d2) {
        double d3;
        double d4;
        float fP;
        float f;
        float f2;
        float fMin;
        boolean z2;
        double dAbs;
        double dAbs2;
        double dMin;
        int height;
        boolean z3;
        double dPow;
        boolean z4;
        double dLog;
        double dI;
        LatLng latLng;
        double d5;
        LatLng latLng2;
        float fL;
        com.google.android.libraries.navigation.internal.abf.s.c(!Float.isNaN(cameraPosition.zoom));
        LatLng latLng3 = cameraPosition.target;
        double d6 = latLng3.longitude;
        double degrees = latLng3.latitude;
        LatLngBounds latLngBounds = this.c;
        if (latLngBounds != null) {
            LatLng latLng4 = latLngBounds.southwest;
            LatLng latLng5 = latLngBounds.northeast;
            degrees = i(degrees, latLng4.latitude, latLng5.latitude);
            d3 = d6;
            if (!o(latLngBounds, d3)) {
                double d7 = latLng5.longitude;
                double dJ = j(d7, d3);
                double d8 = latLng4.longitude;
                d4 = dJ <= j(d8, d3) ? d7 : d8;
                degrees = degrees;
            }
            float fM = m(cameraPosition.zoom);
            com.google.android.libraries.navigation.internal.abf.s.c(!Float.isNaN(fM));
            fP = p(fM, z, akVar, d2);
            com.google.android.libraries.navigation.internal.abf.s.c(!Float.isNaN(fP));
            f = ((float) d) / 2.0f;
            if (fP >= 16.0f) {
                f2 = 82.5f - f;
            } else {
                if (fP > 14.0f) {
                    fMin = Math.min(((((-14.0f) + fP) * 30.0f) / 2.0f) + 60.0f, 82.5f);
                } else if (fP > 10.0f) {
                    fMin = ((((-10.0f) + fP) * 15.0f) / 4.0f) + 45.0f;
                } else {
                    f2 = 45.0f - f;
                }
                f2 = fMin - f;
            }
            float f3 = cameraPosition.tilt;
            float f4 = cameraPosition.bearing;
            float fK = k(f3, 0.0f, f2);
            com.google.android.libraries.navigation.internal.abf.s.k(akVar, "view");
            if (akVar.getWidth() > 0 || akVar.getHeight() <= 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            com.google.android.libraries.navigation.internal.abf.s.b(z2, "Illegal view size: %s", akVar);
            double d9 = f4;
            dAbs = Math.abs(Math.cos(Math.toRadians(d9)));
            dAbs2 = Math.abs(Math.sin(Math.toRadians(d9)));
            if (dAbs < 1.0E-6d) {
                if (dAbs2 < 1.0E-6d) {
                    height = akVar.getHeight();
                } else {
                    dMin = Math.min(((double) akVar.getHeight()) / dAbs, ((double) akVar.getWidth()) / dAbs2);
                }
                double d10 = dMin / d2;
                if (fP >= 0.0f || fP >= 50.0f) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                com.google.android.libraries.navigation.internal.abf.s.b(z3, "Unsupported zoom level: %s", Float.valueOf(fP));
                dPow = d10 / (Math.pow(2.0d, fP) * 256.0d);
                if (degrees > -90.0d || degrees >= 90.0d) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                com.google.android.libraries.navigation.internal.abf.s.b(z4, "Invalid latitude from [-90, 90]: %s", Double.valueOf(degrees));
                dLog = Math.log(Math.tan((Math.toRadians(degrees) * 0.5d) + 0.7853981633974483d)) / 3.141592653589793d;
                double dI2 = i(1.0d - dPow, 0.0d, 1.0d);
                dI = i(dLog, -dI2, dI2);
                if (dI == dLog) {
                    double dAtan = Math.atan(Math.exp(dI * 3.141592653589793d)) - 0.7853981633974483d;
                    degrees = Math.toDegrees(dAtan + dAtan);
                }
                latLng = cameraPosition.target;
                if (Math.abs(degrees - latLng.latitude) <= 1.0E-6d || Math.abs(d4 - latLng.longitude) > 1.0E-6d) {
                    d5 = d4;
                    LatLng latLng6 = new LatLng(degrees, d5);
                    if (com.google.android.libraries.navigation.internal.abf.p.f(a, 2)) {
                        com.google.android.libraries.navigation.internal.abf.aj.f(this).a("dest.lat", cameraPosition.target.latitude).a("dest.lng", cameraPosition.target.longitude).a("screenPercent", dPow).a("rawY", dLog).a("clampedY", dI).a("clampedLatitude", degrees).a("clampedLongitude", d5);
                    }
                    latLng2 = latLng6;
                } else {
                    latLng2 = latLng;
                    fK = fK;
                }
                fL = l(fP, latLng2, z, akVar, d2);
                if (!latLng2.equals(cameraPosition.target) && fL == cameraPosition.zoom && fK == cameraPosition.tilt) {
                    return cameraPosition;
                }
                CameraPosition.Builder builder = new CameraPosition.Builder(cameraPosition);
                builder.target(latLng2);
                builder.zoom(fL);
                builder.tilt(fK);
                return builder.build();
            }
            height = akVar.getWidth();
            dMin = height;
            double d11 = dMin / d2;
            if (fP >= 0.0f) {
                z3 = false;
            } else {
                z3 = false;
            }
            com.google.android.libraries.navigation.internal.abf.s.b(z3, "Unsupported zoom level: %s", Float.valueOf(fP));
            dPow = d11 / (Math.pow(2.0d, fP) * 256.0d);
            if (degrees > -90.0d) {
                z4 = false;
            } else {
                z4 = false;
            }
            com.google.android.libraries.navigation.internal.abf.s.b(z4, "Invalid latitude from [-90, 90]: %s", Double.valueOf(degrees));
            dLog = Math.log(Math.tan((Math.toRadians(degrees) * 0.5d) + 0.7853981633974483d)) / 3.141592653589793d;
            double dI3 = i(1.0d - dPow, 0.0d, 1.0d);
            dI = i(dLog, -dI3, dI3);
            if (dI == dLog) {
                double dAtan2 = Math.atan(Math.exp(dI * 3.141592653589793d)) - 0.7853981633974483d;
                degrees = Math.toDegrees(dAtan2 + dAtan2);
            }
            latLng = cameraPosition.target;
            if (Math.abs(degrees - latLng.latitude) <= 1.0E-6d) {
                d5 = d4;
                LatLng latLng7 = new LatLng(degrees, d5);
                if (com.google.android.libraries.navigation.internal.abf.p.f(a, 2)) {
                    com.google.android.libraries.navigation.internal.abf.aj.f(this).a("dest.lat", cameraPosition.target.latitude).a("dest.lng", cameraPosition.target.longitude).a("screenPercent", dPow).a("rawY", dLog).a("clampedY", dI).a("clampedLatitude", degrees).a("clampedLongitude", d5);
                }
                latLng2 = latLng7;
            } else {
                d5 = d4;
                LatLng latLng8 = new LatLng(degrees, d5);
                if (com.google.android.libraries.navigation.internal.abf.p.f(a, 2)) {
                    com.google.android.libraries.navigation.internal.abf.aj.f(this).a("dest.lat", cameraPosition.target.latitude).a("dest.lng", cameraPosition.target.longitude).a("screenPercent", dPow).a("rawY", dLog).a("clampedY", dI).a("clampedLatitude", degrees).a("clampedLongitude", d5);
                }
                latLng2 = latLng8;
            }
            fL = l(fP, latLng2, z, akVar, d2);
            if (!latLng2.equals(cameraPosition.target)) {
            }
            CameraPosition.Builder builder2 = new CameraPosition.Builder(cameraPosition);
            builder2.target(latLng2);
            builder2.zoom(fL);
            builder2.tilt(fK);
            return builder2.build();
        }
        d3 = d6;
        d4 = d3;
        float fM2 = m(cameraPosition.zoom);
        com.google.android.libraries.navigation.internal.abf.s.c(!Float.isNaN(fM2));
        fP = p(fM2, z, akVar, d2);
        com.google.android.libraries.navigation.internal.abf.s.c(!Float.isNaN(fP));
        f = ((float) d) / 2.0f;
        if (fP >= 16.0f) {
            f2 = 82.5f - f;
        } else {
            if (fP > 14.0f) {
                fMin = Math.min(((((-14.0f) + fP) * 30.0f) / 2.0f) + 60.0f, 82.5f);
            } else if (fP > 10.0f) {
                fMin = ((((-10.0f) + fP) * 15.0f) / 4.0f) + 45.0f;
            } else {
                f2 = 45.0f - f;
            }
            f2 = fMin - f;
        }
        float f5 = cameraPosition.tilt;
        float f6 = cameraPosition.bearing;
        float fK2 = k(f5, 0.0f, f2);
        com.google.android.libraries.navigation.internal.abf.s.k(akVar, "view");
        if (akVar.getWidth() > 0) {
            z2 = false;
        } else {
            z2 = false;
        }
        com.google.android.libraries.navigation.internal.abf.s.b(z2, "Illegal view size: %s", akVar);
        double d12 = f6;
        dAbs = Math.abs(Math.cos(Math.toRadians(d12)));
        dAbs2 = Math.abs(Math.sin(Math.toRadians(d12)));
        if (dAbs < 1.0E-6d) {
            if (dAbs2 < 1.0E-6d) {
                height = akVar.getHeight();
            } else {
                dMin = Math.min(((double) akVar.getHeight()) / dAbs, ((double) akVar.getWidth()) / dAbs2);
            }
            double d13 = dMin / d2;
            if (fP >= 0.0f) {
                z3 = false;
            } else {
                z3 = false;
            }
            com.google.android.libraries.navigation.internal.abf.s.b(z3, "Unsupported zoom level: %s", Float.valueOf(fP));
            dPow = d13 / (Math.pow(2.0d, fP) * 256.0d);
            if (degrees > -90.0d) {
                z4 = false;
            } else {
                z4 = false;
            }
            com.google.android.libraries.navigation.internal.abf.s.b(z4, "Invalid latitude from [-90, 90]: %s", Double.valueOf(degrees));
            dLog = Math.log(Math.tan((Math.toRadians(degrees) * 0.5d) + 0.7853981633974483d)) / 3.141592653589793d;
            double dI4 = i(1.0d - dPow, 0.0d, 1.0d);
            dI = i(dLog, -dI4, dI4);
            if (dI == dLog) {
                double dAtan3 = Math.atan(Math.exp(dI * 3.141592653589793d)) - 0.7853981633974483d;
                degrees = Math.toDegrees(dAtan3 + dAtan3);
            }
            latLng = cameraPosition.target;
            if (Math.abs(degrees - latLng.latitude) <= 1.0E-6d) {
                d5 = d4;
                LatLng latLng9 = new LatLng(degrees, d5);
                if (com.google.android.libraries.navigation.internal.abf.p.f(a, 2)) {
                    com.google.android.libraries.navigation.internal.abf.aj.f(this).a("dest.lat", cameraPosition.target.latitude).a("dest.lng", cameraPosition.target.longitude).a("screenPercent", dPow).a("rawY", dLog).a("clampedY", dI).a("clampedLatitude", degrees).a("clampedLongitude", d5);
                }
                latLng2 = latLng9;
            } else {
                d5 = d4;
                LatLng latLng10 = new LatLng(degrees, d5);
                if (com.google.android.libraries.navigation.internal.abf.p.f(a, 2)) {
                    com.google.android.libraries.navigation.internal.abf.aj.f(this).a("dest.lat", cameraPosition.target.latitude).a("dest.lng", cameraPosition.target.longitude).a("screenPercent", dPow).a("rawY", dLog).a("clampedY", dI).a("clampedLatitude", degrees).a("clampedLongitude", d5);
                }
                latLng2 = latLng10;
            }
            fL = l(fP, latLng2, z, akVar, d2);
            if (!latLng2.equals(cameraPosition.target)) {
            }
            CameraPosition.Builder builder3 = new CameraPosition.Builder(cameraPosition);
            builder3.target(latLng2);
            builder3.zoom(fL);
            builder3.tilt(fK2);
            return builder3.build();
        }
        height = akVar.getWidth();
        dMin = height;
        double d14 = dMin / d2;
        if (fP >= 0.0f) {
            z3 = false;
        } else {
            z3 = false;
        }
        com.google.android.libraries.navigation.internal.abf.s.b(z3, "Unsupported zoom level: %s", Float.valueOf(fP));
        dPow = d14 / (Math.pow(2.0d, fP) * 256.0d);
        if (degrees > -90.0d) {
            z4 = false;
        } else {
            z4 = false;
        }
        com.google.android.libraries.navigation.internal.abf.s.b(z4, "Invalid latitude from [-90, 90]: %s", Double.valueOf(degrees));
        dLog = Math.log(Math.tan((Math.toRadians(degrees) * 0.5d) + 0.7853981633974483d)) / 3.141592653589793d;
        double dI5 = i(1.0d - dPow, 0.0d, 1.0d);
        dI = i(dLog, -dI5, dI5);
        if (dI == dLog) {
            double dAtan4 = Math.atan(Math.exp(dI * 3.141592653589793d)) - 0.7853981633974483d;
            degrees = Math.toDegrees(dAtan4 + dAtan4);
        }
        latLng = cameraPosition.target;
        if (Math.abs(degrees - latLng.latitude) <= 1.0E-6d) {
            d5 = d4;
            LatLng latLng11 = new LatLng(degrees, d5);
            if (com.google.android.libraries.navigation.internal.abf.p.f(a, 2)) {
                com.google.android.libraries.navigation.internal.abf.aj.f(this).a("dest.lat", cameraPosition.target.latitude).a("dest.lng", cameraPosition.target.longitude).a("screenPercent", dPow).a("rawY", dLog).a("clampedY", dI).a("clampedLatitude", degrees).a("clampedLongitude", d5);
            }
            latLng2 = latLng11;
        } else {
            d5 = d4;
            LatLng latLng12 = new LatLng(degrees, d5);
            if (com.google.android.libraries.navigation.internal.abf.p.f(a, 2)) {
                com.google.android.libraries.navigation.internal.abf.aj.f(this).a("dest.lat", cameraPosition.target.latitude).a("dest.lng", cameraPosition.target.longitude).a("screenPercent", dPow).a("rawY", dLog).a("clampedY", dI).a("clampedLatitude", degrees).a("clampedLongitude", d5);
            }
            latLng2 = latLng12;
        }
        fL = l(fP, latLng2, z, akVar, d2);
        if (!latLng2.equals(cameraPosition.target)) {
        }
        CameraPosition.Builder builder4 = new CameraPosition.Builder(cameraPosition);
        builder4.target(latLng2);
        builder4.zoom(fL);
        builder4.tilt(fK2);
        return builder4.build();
    }

    private static synchronized boolean o(LatLngBounds latLngBounds, double d) {
        double d2 = latLngBounds.southwest.longitude;
        double d3 = latLngBounds.northeast.longitude;
        if (d2 <= d3) {
            return d2 <= d && d <= d3;
        }
        return d2 <= d || d <= d3;
    }

    private static float p(float f, boolean z, com.google.android.libraries.navigation.internal.abf.ak akVar, double d) {
        if (!z) {
            return f;
        }
        double width = akVar.getWidth();
        double height = akVar.getHeight();
        com.google.android.libraries.navigation.internal.abf.s.l(width, "screenWidthPx is 0");
        com.google.android.libraries.navigation.internal.abf.s.l(height, "screenHeightPx is 0");
        com.google.android.libraries.navigation.internal.abf.s.l(d, "screenDensity is 0");
        return Math.max(f, (float) Math.ceil(aa.a(1073741824, (int) (((double) ((int) Math.ceil(Math.hypot(width, height)))) + (256.0d * d)), d)));
    }

    public final synchronized float a(float f, LatLng latLng, be beVar) {
        return l(f, latLng, beVar.x(), beVar.k(), beVar.a);
    }

    public final CameraPosition b(CameraPosition cameraPosition, aw awVar) {
        double dA = awVar.a();
        com.google.android.libraries.navigation.internal.abf.ak akVarG = awVar.g();
        awVar.j();
        return n(cameraPosition, dA, akVarG, awVar.a.x(), awVar.b());
    }

    public final CameraPosition c(CameraPosition cameraPosition, be beVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(beVar, "worldModelState");
        return n(cameraPosition, beVar.a(), beVar.k(), beVar.x(), beVar.a);
    }

    public final synchronized void d() {
        this.d = 2.0f;
        this.e = 21.0f;
    }

    public final synchronized void e(LatLngBounds latLngBounds) {
        this.c = latLngBounds;
    }

    public final synchronized void f(float f) {
        float fK = k(f, 2.0f, 21.0f);
        this.e = fK;
        this.d = Math.min(fK, this.d);
    }

    public final synchronized void g(float f) {
        float fK = k(f, 2.0f, 21.0f);
        this.d = fK;
        this.e = Math.max(fK, this.e);
    }

    public final void h(LatLng latLng) {
        com.google.android.libraries.navigation.internal.abf.s.k(latLng, "latLng");
    }
}
