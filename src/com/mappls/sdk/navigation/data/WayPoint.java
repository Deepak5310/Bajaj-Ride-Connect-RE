package com.mappls.sdk.navigation.data;

import com.mappls.sdk.navigation.h;

/* JADX INFO: loaded from: classes4.dex */
public class WayPoint {
    Double entryLatitude;
    Double entryLongitude;
    int index;
    int indexOnPath;
    Double latitude;
    Double longitude;
    String mapplsPin;
    String spokenName;
    String visualName;

    public WayPoint() {
    }

    public WayPoint(double d, double d2, double d3, double d4, String str, String str2) {
        this.entryLatitude = Double.valueOf(d);
        this.entryLongitude = Double.valueOf(d2);
        this.latitude = Double.valueOf(d3);
        this.longitude = Double.valueOf(d4);
        this.visualName = str;
        this.spokenName = str2;
    }

    public WayPoint(double d, double d2, String str) {
        this.entryLatitude = Double.valueOf(d);
        this.entryLongitude = Double.valueOf(d2);
        this.latitude = Double.valueOf(d);
        this.longitude = Double.valueOf(d2);
        this.visualName = str;
        this.spokenName = str;
    }

    public WayPoint(double d, double d2, String str, String str2) {
        this.entryLatitude = Double.valueOf(d);
        this.entryLongitude = Double.valueOf(d2);
        this.latitude = Double.valueOf(d);
        this.longitude = Double.valueOf(d2);
        this.visualName = str;
        this.spokenName = str2;
    }

    public WayPoint(String str, String str2) {
        if (str.contains(",")) {
            this.entryLongitude = Double.valueOf(Double.parseDouble(str.split(",")[0]));
            this.entryLatitude = Double.valueOf(Double.parseDouble(str.split(",")[1]));
        } else {
            this.mapplsPin = str;
        }
        this.visualName = str2;
        this.spokenName = str2;
    }

    public WayPoint(String str, String str2, String str3) {
        if (str.contains(",")) {
            this.entryLongitude = Double.valueOf(Double.parseDouble(str.split(",")[0]));
            Double dValueOf = Double.valueOf(Double.parseDouble(str.split(",")[1]));
            this.entryLatitude = dValueOf;
            this.latitude = dValueOf;
            this.longitude = this.entryLongitude;
        } else {
            this.mapplsPin = str;
        }
        this.visualName = str2;
        this.spokenName = str3;
    }

    public Double getEntryLatitude() {
        return this.entryLatitude;
    }

    public Double getEntryLongitude() {
        return this.entryLongitude;
    }

    public int getIndex() {
        return this.index;
    }

    public int getIndexOnPath() {
        return this.indexOnPath;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public String getMapplsPin() {
        return this.mapplsPin;
    }

    public String getSpokenName() {
        return this.spokenName;
    }

    public String getVisualName() {
        return this.visualName;
    }

    public String getVisualValue() {
        StringBuilder sb;
        Double d;
        if (this.mapplsPin != null) {
            sb = new StringBuilder();
            sb.append(this.mapplsPin);
        } else {
            if (this.entryLatitude != null) {
                sb = new StringBuilder();
                sb.append(this.entryLatitude);
                sb.append(",");
                d = this.entryLongitude;
            } else {
                if (this.latitude == null) {
                    return toString();
                }
                sb = new StringBuilder();
                sb.append(this.latitude);
                sb.append(",");
                d = this.longitude;
            }
            sb.append(d);
        }
        sb.append(";");
        sb.append(this.spokenName);
        sb.append(";");
        sb.append(this.visualName);
        return sb.toString();
    }

    public boolean isValidCoordinates() {
        return this.mapplsPin == null;
    }

    public WayPoint setEntryLatitude(double d) {
        this.mapplsPin = null;
        this.entryLatitude = Double.valueOf(d);
        return this;
    }

    public WayPoint setEntryLongitude(double d) {
        this.mapplsPin = null;
        this.entryLongitude = Double.valueOf(d);
        return this;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setIndexOnPath(int i) {
        this.indexOnPath = i;
    }

    public WayPoint setLatitude(Double d) {
        this.latitude = d;
        return this;
    }

    public WayPoint setLongitude(Double d) {
        this.longitude = d;
        return this;
    }

    public void setMapplsPin(String str) {
        if (!str.contains(",")) {
            this.mapplsPin = str;
        } else {
            this.entryLongitude = Double.valueOf(Double.parseDouble(str.split(",")[0]));
            this.entryLatitude = Double.valueOf(Double.parseDouble(str.split(",")[1]));
        }
    }

    public void setSpokenName(String str) {
        this.spokenName = str;
    }

    public WayPoint setVisualName(String str) {
        this.visualName = str;
        return this;
    }

    public String toString() {
        StringBuilder sbA = h.a("WayPoint{mapplsPin='");
        sbA.append(this.mapplsPin);
        sbA.append('\'');
        sbA.append(", entryLatitude=");
        sbA.append(this.entryLatitude);
        sbA.append(", entryLongitude=");
        sbA.append(this.entryLongitude);
        sbA.append(", latitude=");
        sbA.append(this.latitude);
        sbA.append(", longitude=");
        sbA.append(this.longitude);
        sbA.append(", visualName='");
        sbA.append(this.visualName);
        sbA.append('\'');
        sbA.append(", spokenName='");
        sbA.append(this.spokenName);
        sbA.append('\'');
        sbA.append(", index=");
        sbA.append(this.index);
        sbA.append(", indexOnPath=");
        sbA.append(this.indexOnPath);
        sbA.append('}');
        return sbA.toString();
    }
}
