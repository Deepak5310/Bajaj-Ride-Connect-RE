package com.google.android.libraries.navigation.internal.lu;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<f> CREATOR = new g();
    public final float a;
    public final float b;
    public final long c;
    public final byte d;
    public final float e;
    public final float f;
    private final float[] g;

    public f(float[] fArr, float f, float f2, long j, byte b, float f3, float f4) {
        ar.b(fArr != null && fArr.length == 4, "Input attitude array should be of length 4.");
        ar.b((Float.isNaN(fArr[0]) || Float.isNaN(fArr[1]) || Float.isNaN(fArr[2]) || Float.isNaN(fArr[3])) ? false : true, "Input attitude cannot contain NaNs.");
        ar.a(j >= 0);
        this.g = fArr;
        float f5 = f % 360.0f;
        this.a = f5 < 0.0f ? f5 + 360.0f : f5;
        this.b = c(f2);
        this.e = f3;
        this.f = c(f4);
        this.c = j;
        this.d = (byte) (((byte) (((byte) (b | Ascii.DLE)) | 4)) | 8);
    }

    private static float c(float f) {
        return Math.max(0.0f, Math.min(f, 180.0f));
    }

    public final boolean a() {
        return (this.d & SignedBytes.MAX_POWER_OF_TWO) != 0;
    }

    public final boolean b() {
        return (this.d & 32) != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Float.compare(this.a, fVar.a) == 0 && Float.compare(this.b, fVar.b) == 0 && (b() == fVar.b() && (!b() || Float.compare(this.e, fVar.e) == 0)) && (a() == fVar.a() && (!a() || Float.compare(this.f, fVar.f) == 0)) && this.c == fVar.c && Arrays.equals(this.g, fVar.g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a), Float.valueOf(this.b), Float.valueOf(this.f), Long.valueOf(this.c), this.g, Byte.valueOf(this.d)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceOrientation[attitude=");
        sb.append(Arrays.toString(this.g));
        sb.append(", headingDegrees=");
        sb.append(this.a);
        sb.append(", headingErrorDegrees=");
        sb.append(this.b);
        if (a()) {
            sb.append(", conservativeHeadingErrorDegrees=");
            sb.append(this.f);
        }
        sb.append(", elapsedRealtimeNs=");
        sb.append(this.c);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        float[] fArr = this.g;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        float[] fArr2 = (float[]) fArr.clone();
        if (fArr2 != null) {
            int iB = com.google.android.libraries.navigation.internal.li.d.b(parcel, 1);
            parcel.writeFloatArray(fArr2);
            com.google.android.libraries.navigation.internal.li.d.c(parcel, iB);
        }
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 4, this.a);
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 5, this.b);
        com.google.android.libraries.navigation.internal.li.d.i(parcel, 6, this.c);
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 7, this.d);
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 8, this.e);
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 9, this.f);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
