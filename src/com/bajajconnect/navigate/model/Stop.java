package com.bajajconnect.navigate.model;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bajajconnect.navigate.utils.Validator;
import com.mappls.sdk.maps.geometry.LatLng;

/* JADX INFO: loaded from: classes3.dex */
public class Stop implements Parcelable {
    private boolean changeable;
    private String mAddress;
    private Location mEntryLocation;
    private Location mLocation;
    private String mName;
    private int mSiteId;
    private String placeId;
    private String type;
    public static final Parcelable.Creator<Stop> CREATOR = new Parcelable.Creator<Stop>() { // from class: com.bajajconnect.navigate.model.Stop.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Stop createFromParcel(Parcel parcel) {
            return new Stop(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Stop[] newArray(int i) {
            return new Stop[i];
        }
    };
    public static String TYPE_MY_LOCATION = "Your current location";
    public static String TYPE_STOP = "Stop";
    private static String NAME_RE = "[^\\p{Alnum}\\(\\)\\s]";

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Stop() {
        this.changeable = true;
        this.type = TYPE_STOP;
    }

    public Stop(String str) {
        this.changeable = true;
        this.type = TYPE_STOP;
        setName(str);
    }

    public Stop(String str, Location location) {
        this.changeable = true;
        this.type = TYPE_STOP;
        setName(str);
        this.mLocation = location;
    }

    public Stop(String str, double d, double d2) {
        this.changeable = true;
        this.type = TYPE_STOP;
        setName(str);
        Location location = new Location("Mappls");
        this.mLocation = location;
        location.setLatitude(d);
        this.mLocation.setLongitude(d2);
    }

    public Stop(Stop stop) {
        this.changeable = true;
        this.type = TYPE_STOP;
        this.mName = stop.getName();
        this.mLocation = stop.getLocation();
        this.mSiteId = stop.getSiteId();
        this.mAddress = stop.getmAddress();
        this.placeId = stop.getPlaceId();
    }

    protected Stop(Parcel parcel) {
        this.changeable = true;
        this.type = TYPE_STOP;
        this.mName = parcel.readString();
        this.mAddress = parcel.readString();
        this.mLocation = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.mEntryLocation = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.mSiteId = parcel.readInt();
        this.placeId = parcel.readString();
        this.changeable = parcel.readByte() != 0;
        this.type = parcel.readString();
    }

    public static boolean looksValid(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.getTrimmedLength(str) == 0) {
            return false;
        }
        return !str.matches(NAME_RE);
    }

    public void refreshModel(Stop stop) {
        this.mName = stop.getName();
        this.mLocation = stop.getLocation();
        this.mSiteId = stop.getSiteId();
        this.mAddress = stop.getmAddress();
        this.placeId = stop.getPlaceId();
        this.mEntryLocation = stop.getELocation();
        this.type = stop.getType();
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public boolean isChangeable() {
        return this.changeable;
    }

    public void setChangeable(boolean z) {
        this.changeable = z;
    }

    public LatLng getGeoPoint() {
        try {
            Location location = this.mEntryLocation;
            if (location != null && location.getLatitude() != 0.0d && this.mEntryLocation.getLongitude() != 0.0d) {
                return new LatLng(this.mEntryLocation.getLatitude(), this.mEntryLocation.getLongitude());
            }
            return new LatLng(this.mLocation.getLatitude(), this.mLocation.getLongitude());
        } catch (Exception e) {
            e.printStackTrace();
            return new LatLng(0.0d, 0.0d);
        }
    }

    public LatLng getLatLng() {
        try {
            return new LatLng(this.mLocation.getLatitude(), this.mLocation.getLongitude());
        } catch (Exception unused) {
            return new LatLng(0.0d, 0.0d);
        }
    }

    public LatLng getELatLng() {
        try {
            return new LatLng(this.mEntryLocation.getLatitude(), this.mEntryLocation.getLongitude());
        } catch (Exception unused) {
            return new LatLng(0.0d, 0.0d);
        }
    }

    public boolean equals(Object obj) {
        try {
            Stop stop = (Stop) obj;
            return stop.getLocation().distanceTo(getLocation()) < 5.0f || !(TextUtils.isEmpty(stop.getPlaceId()) || TextUtils.isEmpty(getPlaceId()) || !stop.getPlaceId().equalsIgnoreCase(getPlaceId()));
        } catch (Exception unused) {
            return false;
        }
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public boolean hasName() {
        return !TextUtils.isEmpty(this.mName);
    }

    public void setLocation(int i, int i2) {
        Location location = new Location("Mappls");
        this.mLocation = location;
        location.setLatitude(((double) i) / 1000000.0d);
        this.mLocation.setLongitude(((double) i2) / 1000000.0d);
    }

    public void setLocation(double d, double d2) {
        Location location = new Location("Mappls");
        this.mLocation = location;
        location.setLatitude(d);
        this.mLocation.setLongitude(d2);
    }

    public void setELocation(double d, double d2) {
        Location location = new Location("EMappls");
        this.mEntryLocation = location;
        location.setLatitude(d);
        this.mEntryLocation.setLongitude(d2);
    }

    public Location getELocation() {
        return this.mEntryLocation;
    }

    public Location getLocation() {
        return this.mLocation;
    }

    public void setLocation(Location location) {
        this.mLocation = location;
    }

    public boolean isMyLocation() {
        return hasName() && this.type.equals(TYPE_MY_LOCATION);
    }

    public int getSiteId() {
        return this.mSiteId;
    }

    public void setSiteId(int i) {
        this.mSiteId = i;
    }

    public boolean looksValid() {
        return hasName();
    }

    public String getmAddress() {
        return this.mAddress;
    }

    public void setmAddress(String str) {
        this.mAddress = str;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public void setPlaceId(String str) {
        this.placeId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mAddress);
        parcel.writeParcelable(this.mLocation, i);
        parcel.writeParcelable(this.mEntryLocation, i);
        parcel.writeInt(this.mSiteId);
        parcel.writeString(this.placeId);
        parcel.writeByte(this.changeable ? (byte) 1 : (byte) 0);
        parcel.writeString(this.type);
    }

    public String getDisplayName() {
        if (!TextUtils.isEmpty(getName())) {
            return getName();
        }
        if (!TextUtils.isEmpty(getmAddress())) {
            return getmAddress();
        }
        if (!Validator.isValidLatLng(getLatLng().getLatitude(), getLatLng().getLongitude())) {
            return "";
        }
        return getLatLng().getLatitude() + ", " + getLatLng().getLongitude();
    }

    public boolean isValid() {
        return Validator.isValidLatLng(getLatLng()) || Validator.isValidEloc(getPlaceId());
    }

    public String toString() {
        return this.placeId;
    }
}
