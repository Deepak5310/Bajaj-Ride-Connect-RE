package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.navigation.internal.lh.be;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class PolylineOptions extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new t();
    private final List a;
    private float b;
    private int c;
    private float d;
    private boolean e;
    private boolean f;
    private boolean g;
    private Cap h;
    private Cap i;
    private int j;
    private List k;
    private List l;

    public PolylineOptions() {
        this.b = 10.0f;
        this.c = ViewCompat.MEASURED_STATE_MASK;
        this.d = 0.0f;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = new ButtCap();
        this.i = new ButtCap();
        this.j = 0;
        this.k = null;
        this.l = new ArrayList();
        this.a = new ArrayList();
    }

    public final List a() {
        ArrayList arrayList = new ArrayList(this.l.size());
        for (StyleSpan styleSpan : this.l) {
            StrokeStyle.Builder builder = new StrokeStyle.Builder(styleSpan.getStyle());
            builder.a = this.b;
            builder.d = this.e;
            arrayList.add(new StyleSpan(builder.build(), styleSpan.getSegments()));
        }
        return arrayList;
    }

    public PolylineOptions add(LatLng latLng) {
        this.a.add(latLng);
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        Iterator<LatLng> it2 = iterable.iterator();
        while (it2.hasNext()) {
            this.a.add(it2.next());
        }
        return this;
    }

    public PolylineOptions addAllSpans(Iterable<StyleSpan> iterable) {
        Iterator<StyleSpan> it2 = iterable.iterator();
        while (it2.hasNext()) {
            addSpan(it2.next());
        }
        return this;
    }

    public PolylineOptions addSpan(StyleSpan styleSpan) {
        this.l.add(styleSpan);
        return this;
    }

    public PolylineOptions clickable(boolean z) {
        this.g = z;
        return this;
    }

    public PolylineOptions color(int i) {
        this.c = i;
        return this;
    }

    public PolylineOptions endCap(Cap cap) {
        be.k(cap, "endCap must not be null");
        this.i = cap;
        return this;
    }

    public PolylineOptions geodesic(boolean z) {
        this.f = z;
        return this;
    }

    public int getColor() {
        return this.c;
    }

    public Cap getEndCap() {
        return this.i.a();
    }

    public int getJointType() {
        return this.j;
    }

    public List<PatternItem> getPattern() {
        List list = this.k;
        if (list != null) {
            return new ArrayList(list);
        }
        return null;
    }

    public List<LatLng> getPoints() {
        return new ArrayList(this.a);
    }

    public Cap getStartCap() {
        return this.h.a();
    }

    public float getWidth() {
        return this.b;
    }

    public float getZIndex() {
        return this.d;
    }

    public boolean isClickable() {
        return this.g;
    }

    public boolean isGeodesic() {
        return this.f;
    }

    public boolean isVisible() {
        return this.e;
    }

    public PolylineOptions jointType(int i) {
        this.j = i;
        return this;
    }

    public PolylineOptions pattern(List<PatternItem> list) {
        this.k = list;
        return this;
    }

    public PolylineOptions startCap(Cap cap) {
        be.k(cap, "startCap must not be null");
        this.h = cap;
        return this;
    }

    public PolylineOptions visible(boolean z) {
        this.e = z;
        return this;
    }

    public PolylineOptions width(float f) {
        this.b = f;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.v(parcel, 2, getPoints());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 3, getWidth());
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 4, getColor());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 5, getZIndex());
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 6, isVisible());
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 7, isGeodesic());
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 8, isClickable());
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 9, getStartCap(), i);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 10, getEndCap(), i);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 11, getJointType());
        com.google.android.libraries.navigation.internal.li.d.v(parcel, 12, getPattern());
        com.google.android.libraries.navigation.internal.li.d.v(parcel, 13, a());
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public PolylineOptions zIndex(float f) {
        this.d = f;
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        Collections.addAll(this.a, latLngArr);
        return this;
    }

    public PolylineOptions addSpan(StyleSpan... styleSpanArr) {
        for (StyleSpan styleSpan : styleSpanArr) {
            addSpan(styleSpan);
        }
        return this;
    }

    public PolylineOptions(List list, float f, int i, float f2, boolean z, boolean z2, boolean z3, Cap cap, Cap cap2, int i2, List list2, List list3) {
        this.b = 10.0f;
        this.c = ViewCompat.MEASURED_STATE_MASK;
        this.d = 0.0f;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = new ButtCap();
        this.i = new ButtCap();
        this.j = 0;
        this.k = null;
        this.l = new ArrayList();
        this.a = list;
        this.b = f;
        this.c = i;
        this.d = f2;
        this.e = z;
        this.f = z2;
        this.g = z3;
        if (cap != null) {
            this.h = cap;
        }
        if (cap2 != null) {
            this.i = cap2;
        }
        this.j = i2;
        this.k = list2;
        if (list3 != null) {
            this.l = list3;
        }
    }
}
