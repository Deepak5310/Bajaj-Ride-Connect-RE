package com.mappls.sdk.direction.ui.model;

import com.mappls.sdk.geojson.Point;

/* JADX INFO: loaded from: classes6.dex */
public class StopModel {
    public static int TYPE_BLANK = 3;
    public static int TYPE_CURRENT_LOCATION = 0;
    public static int TYPE_STOP = 1;
    private int locationType;
    private String mapplsPin;
    private String placeAddress;
    private String placeName;
    private double latitude = 0.0d;
    private double longitude = 0.0d;
    private double entryLatitude = 0.0d;
    private double entryLongitude = 0.0d;

    public Point getEntryLocation() {
        double d = this.entryLatitude;
        if (d == 0.0d) {
            return null;
        }
        double d2 = this.entryLongitude;
        if (d2 == 0.0d) {
            return null;
        }
        return Point.fromLngLat(d2, d);
    }

    public Point getLocation() {
        double d = this.latitude;
        if (d == 0.0d) {
            return null;
        }
        double d2 = this.longitude;
        if (d2 == 0.0d) {
            return null;
        }
        return Point.fromLngLat(d2, d);
    }

    public int getLocationType() {
        return this.locationType;
    }

    public String getMapplsPin() {
        return this.mapplsPin;
    }

    public String getPlaceAddress() {
        return this.placeAddress;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public String getVisualValue() {
        StringBuilder sb;
        String str;
        if (this.latitude != 0.0d) {
            sb = new StringBuilder();
            sb.append(this.latitude);
            sb.append(",");
            sb.append(this.longitude);
            sb.append(";");
            sb.append(this.locationType == TYPE_CURRENT_LOCATION ? "Current Location" : this.placeName);
            sb.append(";");
            if (this.locationType == TYPE_CURRENT_LOCATION) {
                str = "";
            }
            sb.append(str);
            return sb.toString();
        }
        if (this.mapplsPin == null) {
            return toString();
        }
        sb = new StringBuilder();
        sb.append(this.mapplsPin);
        sb.append(";");
        sb.append(this.placeName);
        sb.append(";");
        str = this.placeAddress;
        sb.append(str);
        return sb.toString();
    }

    public void setEntryLocation(Point point) {
        double dLongitude;
        if (point != null) {
            this.entryLatitude = point.latitude();
            dLongitude = point.longitude();
        } else {
            dLongitude = 0.0d;
            this.entryLatitude = 0.0d;
        }
        this.entryLongitude = dLongitude;
    }

    public void setLocation(Point point) {
        double dLongitude;
        if (point != null) {
            this.latitude = point.latitude();
            dLongitude = point.longitude();
        } else {
            dLongitude = 0.0d;
            this.latitude = 0.0d;
        }
        this.longitude = dLongitude;
    }

    public void setLocationType(int i) {
        this.locationType = i;
    }

    public void setMapplsPin(String str) {
        this.mapplsPin = str;
    }

    public void setPlaceAddress(String str) {
        this.placeAddress = str;
    }

    public void setPlaceName(String str) {
        this.placeName = str;
    }
}
