package com.google.android.libraries.navigation.internal.ld;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.iid.InstanceID;
import com.google.android.libraries.navigation.internal.lh.ay;
import com.google.android.libraries.navigation.internal.lh.az;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab extends com.google.android.libraries.navigation.internal.li.a implements Parcelable, y {
    public final int f;
    public final String g;
    public final PendingIntent h;
    public final com.google.android.libraries.navigation.internal.lc.a i;
    public static final ab a = new ab(0);
    public static final ab b = new ab(14);
    public static final ab c = new ab(8);
    public static final ab d = new ab(15);
    public static final ab e = new ab(16);
    public static final Parcelable.Creator<ab> CREATOR = new ac();

    public ab(int i) {
        this(i, null);
    }

    public ab(int i, String str, PendingIntent pendingIntent, com.google.android.libraries.navigation.internal.lc.a aVar) {
        this.f = i;
        this.g = str;
        this.h = pendingIntent;
        this.i = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ld.y
    public final ab a() {
        return this;
    }

    public final boolean b() {
        return this.f <= 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ab)) {
            return false;
        }
        ab abVar = (ab) obj;
        return this.f == abVar.f && az.a(this.g, abVar.g) && az.a(this.h, abVar.h) && az.a(this.i, abVar.i);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f), this.g, this.h, this.i});
    }

    public final String toString() {
        ay ayVar = new ay(this);
        String strB = this.g;
        if (strB == null) {
            int i = this.f;
            switch (i) {
                case -1:
                    strB = "SUCCESS_CACHE";
                    break;
                case 0:
                    strB = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    strB = com.google.android.libraries.navigation.internal.b.b.b(i, "unknown status code: ");
                    break;
                case 2:
                    strB = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    strB = "SERVICE_DISABLED";
                    break;
                case 4:
                    strB = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    strB = "INVALID_ACCOUNT";
                    break;
                case 6:
                    strB = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    strB = "NETWORK_ERROR";
                    break;
                case 8:
                    strB = "INTERNAL_ERROR";
                    break;
                case 10:
                    strB = "DEVELOPER_ERROR";
                    break;
                case 13:
                    strB = "ERROR";
                    break;
                case 14:
                    strB = "INTERRUPTED";
                    break;
                case 15:
                    strB = InstanceID.ERROR_TIMEOUT;
                    break;
                case 16:
                    strB = "CANCELED";
                    break;
                case 17:
                    strB = "API_NOT_CONNECTED";
                    break;
                case 18:
                    strB = "DEAD_CLIENT";
                    break;
                case 19:
                    strB = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    strB = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    strB = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    strB = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        ayVar.a("statusCode", strB);
        ayVar.a("resolution", this.h);
        return ayVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, i2);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 2, this.g);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 3, this.h, i);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 4, this.i, i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public ab(int i, String str) {
        this(i, str, null);
    }

    public ab(int i, String str, byte[] bArr) {
        this(i, str, null, null);
    }
}
