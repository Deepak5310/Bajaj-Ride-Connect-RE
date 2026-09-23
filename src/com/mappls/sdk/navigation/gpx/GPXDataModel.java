package com.mappls.sdk.navigation.gpx;

import android.os.Parcel;
import android.os.Parcelable;
import com.mappls.sdk.maps.geometry.LatLng;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class GPXDataModel implements Parcelable {
    public static final Parcelable.Creator<GPXDataModel> CREATOR = new a();
    String altitudeRange;
    String averageAltitude;
    String averageSpeed;
    String distance;
    String endTime;
    String isSynced;
    String maxSpeed;
    String startTime;
    String timeMoving;
    long trackID;
    String trackName;
    ArrayList<LatLng> trackPath;

    final class a implements Parcelable.Creator<GPXDataModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GPXDataModel createFromParcel(Parcel parcel) {
            return new GPXDataModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final GPXDataModel[] newArray(int i) {
            return new GPXDataModel[i];
        }
    }

    public GPXDataModel() {
        this.trackName = null;
        this.trackID = 0L;
        this.trackPath = new ArrayList<>();
        this.isSynced = null;
        this.distance = null;
        this.startTime = null;
        this.endTime = null;
        this.timeMoving = null;
        this.averageAltitude = null;
        this.altitudeRange = null;
        this.averageSpeed = null;
        this.maxSpeed = null;
    }

    protected GPXDataModel(Parcel parcel) {
        this.trackName = null;
        this.trackID = 0L;
        this.trackPath = new ArrayList<>();
        this.isSynced = null;
        this.distance = null;
        this.startTime = null;
        this.endTime = null;
        this.timeMoving = null;
        this.averageAltitude = null;
        this.altitudeRange = null;
        this.averageSpeed = null;
        this.maxSpeed = null;
        this.trackName = parcel.readString();
        this.trackID = parcel.readLong();
        if (parcel.readByte() == 1) {
            ArrayList<LatLng> arrayList = new ArrayList<>();
            this.trackPath = arrayList;
            parcel.readList(arrayList, LatLng.class.getClassLoader());
        } else {
            this.trackPath = null;
        }
        this.isSynced = parcel.readString();
        this.distance = parcel.readString();
        this.startTime = parcel.readString();
        this.endTime = parcel.readString();
        this.timeMoving = parcel.readString();
        this.averageAltitude = parcel.readString();
        this.altitudeRange = parcel.readString();
        this.averageSpeed = parcel.readString();
        this.maxSpeed = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAltitudeRange() {
        return this.altitudeRange;
    }

    public String getAverageAltitude() {
        return this.averageAltitude;
    }

    public String getAverageSpeed() {
        return this.averageSpeed;
    }

    public String getDistance() {
        return this.distance;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getIsSynced() {
        return this.isSynced;
    }

    public String getMaxSpeed() {
        return this.maxSpeed;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getTimeMoving() {
        return this.timeMoving;
    }

    public long getTrackID() {
        return this.trackID;
    }

    public String getTrackName() {
        return this.trackName;
    }

    public ArrayList<LatLng> getTrackPath() {
        return this.trackPath;
    }

    public void setAltitudeRange(String str) {
        this.altitudeRange = str;
    }

    public void setAverageAltitude(String str) {
        this.averageAltitude = str;
    }

    public void setAverageSpeed(String str) {
        this.averageSpeed = str;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setIsSynced(String str) {
        this.isSynced = str;
    }

    public void setMaxSpeed(String str) {
        this.maxSpeed = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setTimeMoving(String str) {
        this.timeMoving = str;
    }

    public void setTrackID(long j) {
        this.trackID = j;
    }

    public void setTrackName(String str) {
        this.trackName = str;
    }

    public void setTrackPath(ArrayList<LatLng> arrayList) {
        this.trackPath = arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.trackName);
        parcel.writeLong(this.trackID);
        if (this.trackPath == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this.trackPath);
        }
        parcel.writeString(this.isSynced);
        parcel.writeString(this.distance);
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        parcel.writeString(this.timeMoving);
        parcel.writeString(this.averageAltitude);
        parcel.writeString(this.altitudeRange);
        parcel.writeString(this.averageSpeed);
        parcel.writeString(this.maxSpeed);
    }
}
