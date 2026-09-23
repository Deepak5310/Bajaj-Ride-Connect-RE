package com.mappls.sdk.maps.util;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultStyle implements Parcelable {
    public static final Parcelable.Creator<DefaultStyle> CREATOR = new Parcelable.Creator<DefaultStyle>() { // from class: com.mappls.sdk.maps.util.DefaultStyle.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultStyle createFromParcel(Parcel parcel) {
            return new DefaultStyle(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultStyle[] newArray(int i) {
            return new DefaultStyle[i];
        }
    };
    private String name;
    private String url;
    private int version;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DefaultStyle(String str, String str2, int i) {
        setUrl(str);
        setName(str2);
        setVersion(i);
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public int getVersion() {
        return this.version;
    }

    protected DefaultStyle(Parcel parcel) {
        setUrl(parcel.readString());
        setName(parcel.readString());
        setVersion(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.name);
        parcel.writeInt(this.version);
    }
}
