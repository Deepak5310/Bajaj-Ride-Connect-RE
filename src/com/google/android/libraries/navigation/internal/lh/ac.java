package com.google.android.libraries.navigation.internal.lh;

import android.content.ComponentName;
import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac {
    public static final Uri a = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    public final String b;
    public final String c;
    public final int d;
    public final boolean e;
    private final ComponentName f;

    public ac(String str, String str2, int i, boolean z) {
        be.h(str);
        this.b = str;
        be.h("com.google.android.gms");
        this.c = "com.google.android.gms";
        this.f = null;
        this.d = ad.a;
        this.e = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ac)) {
            return false;
        }
        ac acVar = (ac) obj;
        if (az.a(this.b, acVar.b) && az.a(this.c, acVar.c)) {
            ComponentName componentName = acVar.f;
            if (az.a(null, null)) {
                int i = acVar.d;
                if (this.e == acVar.e) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, null, Integer.valueOf(ad.a), Boolean.valueOf(this.e)});
    }

    public final String toString() {
        return this.b;
    }
}
