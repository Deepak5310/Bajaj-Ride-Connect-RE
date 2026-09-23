package com.bajajconnect.music;

import android.content.ComponentName;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class MediaAppDetails implements Parcelable {
    public static final Parcelable.Creator<MediaAppDetails> CREATOR = new Parcelable.Creator<MediaAppDetails>() { // from class: com.bajajconnect.music.MediaAppDetails.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaAppDetails createFromParcel(Parcel parcel) {
            return new MediaAppDetails(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaAppDetails[] newArray(int i) {
            return new MediaAppDetails[i];
        }
    };
    public final String appName;
    public Bitmap banner;
    public final ComponentName componentName;
    public final String packageName;
    public final MediaSessionCompat.Token sessionToken;
    public boolean supportsAuto;
    public boolean supportsAutomotive;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MediaAppDetails(String str, String str2, Bitmap bitmap, Bitmap bitmap2, MediaSessionCompat.Token token) {
        this.supportsAutomotive = false;
        this.supportsAuto = false;
        this.packageName = str;
        this.appName = str2;
        this.sessionToken = token;
        this.banner = bitmap2;
        this.componentName = null;
    }

    public MediaAppDetails(PackageItemInfo packageItemInfo, PackageManager packageManager, Resources resources, MediaSession.Token token) {
        this.supportsAutomotive = false;
        this.supportsAuto = false;
        String str = packageItemInfo.packageName;
        this.packageName = str;
        this.appName = packageItemInfo.loadLabel(packageManager).toString();
        if (token != null) {
            this.componentName = null;
            this.sessionToken = MediaSessionCompat.Token.fromToken(token);
        } else {
            this.componentName = new ComponentName(packageItemInfo.packageName, packageItemInfo.name);
            this.sessionToken = null;
        }
        try {
            FeatureInfo[] featureInfoArr = packageManager.getPackageInfo(str, 16384).reqFeatures;
            this.supportsAutomotive = false;
            if (featureInfoArr != null) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    if (featureInfo.name != null && featureInfo.name.equals("android.hardware.type.automotive")) {
                        this.supportsAutomotive = true;
                        break;
                    }
                }
            }
            Bundle bundle = packageManager.getApplicationInfo(this.packageName, 128).metaData;
            if (bundle == null || !bundle.containsKey("com.google.android.gms.car.application")) {
                return;
            }
            this.supportsAuto = true;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("MediaAppDetails", "package name not found" + this.packageName);
        }
    }

    public MediaAppDetails(PackageItemInfo packageItemInfo, PackageManager packageManager, Resources resources) {
        this(packageItemInfo, packageManager, resources, null);
    }

    private MediaAppDetails(Parcel parcel) {
        this.supportsAutomotive = false;
        this.supportsAuto = false;
        this.packageName = parcel.readString();
        this.appName = parcel.readString();
        this.sessionToken = (MediaSessionCompat.Token) parcel.readParcelable(MediaAppDetails.class.getClassLoader());
        this.componentName = (ComponentName) parcel.readParcelable(MediaAppDetails.class.getClassLoader());
        this.supportsAuto = parcel.readInt() == 1;
        this.supportsAutomotive = parcel.readInt() == 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.packageName);
        parcel.writeString(this.appName);
        parcel.writeParcelable(this.sessionToken, i);
        parcel.writeParcelable(this.componentName, i);
        parcel.writeInt(this.supportsAuto ? 1 : 0);
        parcel.writeInt(this.supportsAutomotive ? 1 : 0);
    }
}
