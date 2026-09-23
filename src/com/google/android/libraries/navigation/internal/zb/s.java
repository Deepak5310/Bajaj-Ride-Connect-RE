package com.google.android.libraries.navigation.internal.zb;

import androidx.exifinterface.media.ExifInterface;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class s extends t {
    private final int d;
    private int f = 0;
    private final String b = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
    private final String c = "a";
    private final String e = "PG";

    public s(int i) {
        this.d = i;
    }

    @Override // com.google.android.libraries.navigation.internal.zb.t
    public final int a() {
        return (char) this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.zb.t
    public final String b() {
        return this.b.replace('/', ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @Override // com.google.android.libraries.navigation.internal.zb.t
    public final String c() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.zb.t
    public final String d() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (this.c.equals(sVar.c) && this.d == sVar.d) {
                String str = sVar.b;
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((this.c.hashCode() + 4867) * 31) + this.d;
        this.f = iHashCode;
        return iHashCode;
    }
}
