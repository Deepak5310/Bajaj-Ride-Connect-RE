package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class cr {
    public static boolean a(dy dyVar, ez ezVar) {
        if (ezVar == ez.HIDDEN) {
            return false;
        }
        if (ezVar == ez.DEFAULT) {
            return true;
        }
        if (ezVar != ez.SATELLITE_NO_BASEMAP) {
            return ((ezVar == ez.SATELLITE_HYBRID || ezVar == ez.TERRAIN) && dyVar == dy.INDOOR_PASS) ? false : true;
        }
        int iOrdinal = dyVar.ordinal();
        return iOrdinal == 0 || iOrdinal == 10 || iOrdinal == 13 || iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 5 || iOrdinal == 6 || iOrdinal == 7;
    }
}
