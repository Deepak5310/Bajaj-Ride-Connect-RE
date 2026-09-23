package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.az;
import com.google.android.libraries.navigation.internal.lh.be;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class PatternItem extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<PatternItem> CREATOR = new p();
    public final int a;
    public final Float b;

    public PatternItem(int i, Float f) {
        boolean z = true;
        if (i != 1 && (f == null || f.floatValue() < 0.0f)) {
            z = false;
        }
        be.b(z, "Invalid PatternItem: type=" + i + " length=" + f);
        this.a = i;
        this.b = f;
    }

    static List a(List list) {
        PatternItem dash;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            PatternItem dot = (PatternItem) it2.next();
            if (dot == null) {
                dot = null;
            } else {
                int i = dot.a;
                if (i == 0) {
                    dash = new Dash(dot.b.floatValue());
                } else if (i == 1) {
                    dot = new Dot();
                } else if (i == 2) {
                    dash = new Gap(dot.b.floatValue());
                }
                dot = dash;
            }
            arrayList.add(dot);
        }
        return arrayList;
    }

    public static PatternItem[] b(List list) {
        if (list == null) {
            return null;
        }
        PatternItem[] patternItemArr = (PatternItem[]) list.toArray(new PatternItem[list.size()]);
        for (PatternItem patternItem : patternItemArr) {
        }
        return patternItemArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        return this.a == patternItem.a && az.a(this.b, patternItem.b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), this.b});
    }

    public String toString() {
        return "[PatternItem: type=" + this.a + " length=" + this.b + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 2, i2);
        com.google.android.libraries.navigation.internal.li.d.m(parcel, 3, this.b);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
