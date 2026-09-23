package com.mappls.sdk.navigation;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.data.LocationPoint;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class w {
    private s c;
    private com.mappls.sdk.navigation.routing.d d;
    private Context f;
    private ArrayList a = new ArrayList();
    private a b = null;
    private ArrayList e = new ArrayList();

    public static class a implements LocationPoint {
        public final LatLng a;
        public final String b;
        public int c;
        public boolean d;
        public boolean e;
        private com.mappls.sdk.navigation.data.a f;

        public a(LatLng latLng, com.mappls.sdk.navigation.data.a aVar) {
            this.a = latLng;
            this.f = aVar;
            this.b = null;
        }

        public a(String str, com.mappls.sdk.navigation.data.a aVar) {
            this.f = aVar;
            if (str.contains(",")) {
                this.a = new LatLng(Double.parseDouble(str.split(",")[1]), Double.parseDouble(str.split(",")[0]));
                this.b = null;
            } else {
                this.b = str;
                this.a = null;
            }
        }

        public a(String str, com.mappls.sdk.navigation.data.a aVar, int i) {
            this.f = aVar;
            this.c = i;
            this.d = true;
            if (str.contains(",")) {
                this.a = new LatLng(Double.parseDouble(str.split(",")[1]), Double.parseDouble(str.split(",")[0]));
                this.b = null;
            } else {
                this.b = str;
                this.a = null;
            }
        }

        public final String a() {
            com.mappls.sdk.navigation.data.a aVar = this.f;
            return aVar == null ? "" : aVar.e();
        }

        public final double b() {
            com.mappls.sdk.navigation.data.a aVar = this.f;
            return aVar == null ? this.a.getLatitude() : aVar.c();
        }

        public final double c() {
            com.mappls.sdk.navigation.data.a aVar = this.f;
            return aVar == null ? this.a.getLongitude() : aVar.d();
        }

        public final String d() {
            com.mappls.sdk.navigation.data.a aVar = this.f;
            return aVar == null ? "" : aVar.f();
        }

        public final String e() {
            StringBuilder sb;
            String strD;
            if (this.a != null) {
                sb = new StringBuilder();
                sb.append(this.a.getLatitude());
                sb.append(",");
                sb.append(this.a.getLongitude());
                sb.append(";");
                strD = a();
            } else {
                sb = new StringBuilder();
                sb.append(this.b);
                sb.append(";");
                strD = d();
            }
            sb.append(strD);
            return sb.toString();
        }

        public final boolean equals(Object obj) {
            String str;
            LatLng latLng;
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.e != aVar.e || this.d != aVar.d || this.c != aVar.c) {
                    return false;
                }
                LatLng latLng2 = this.a;
                if (latLng2 != null && (latLng = aVar.a) != null) {
                    return latLng2.equals(latLng);
                }
                String str2 = this.b;
                if (str2 != null && (str = aVar.b) != null) {
                    return str2.equalsIgnoreCase(str);
                }
            }
            return false;
        }

        @Override // com.mappls.sdk.navigation.data.LocationPoint
        public final double getLatitude() {
            return this.a.getLatitude();
        }

        @Override // com.mappls.sdk.navigation.data.LocationPoint
        public final double getLongitude() {
            return this.a.getLongitude();
        }

        @Override // com.mappls.sdk.navigation.data.LocationPoint
        public final com.mappls.sdk.navigation.data.a getPointDescription(Context context) {
            if (!this.d) {
                return new com.mappls.sdk.navigation.data.a(FirebaseAnalytics.Param.DESTINATION, context.getString(R.string.mappls_destination_point, ""), a());
            }
            return new com.mappls.sdk.navigation.data.a(FirebaseAnalytics.Param.DESTINATION, (this.c + 1) + ". " + context.getString(R.string.mappls_intermediate_point, ""), a());
        }

        public final int hashCode() {
            LatLng latLng = this.a;
            return ((((((latLng != null ? latLng.hashCode() : this.b.hashCode()) * 31) + this.c) * 31) + (this.e ? 10 : 20)) * 31) + (this.d ? 100 : 200);
        }
    }

    public w(Context context) {
        new ArrayList();
        this.f = context;
        this.c = NavigationContext.getNavigationContext().k();
        this.d = NavigationContext.getNavigationContext().h();
        g();
    }

    private void a() {
        ArrayList<LatLng> arrayList = new ArrayList();
        Iterator it2 = this.a.iterator();
        while (it2.hasNext()) {
            arrayList.add(((a) it2.next()).a);
        }
        for (LatLng latLng : arrayList) {
        }
    }

    private void g() {
        String strL = this.c.l();
        this.b = strL != null ? new a(strL, this.c.k()) : null;
        LatLng latLngM = this.c.m();
        com.mappls.sdk.navigation.data.a aVarN = this.c.n();
        if (latLngM != null) {
            new a(latLngM, aVarN).e = true;
        }
        this.a.clear();
        ArrayList arrayListI = this.c.i();
        ArrayList arrayListB = this.c.b(arrayListI.size());
        for (int i = 0; i < arrayListI.size(); i++) {
            this.a.add(new a((String) arrayListI.get(i), com.mappls.sdk.navigation.data.a.a((String) arrayListB.get(i), (String) arrayListI.get(i)), i));
        }
        NavigationContext.getNavigationContext().b.getClass();
    }

    public final void a(int i, boolean z) {
        int i2 = 0;
        if (i < 0) {
            this.c.c();
            this.b = null;
            int size = this.a.size();
            if (size > 0) {
                int i3 = size - 1;
                this.c.a(i3);
                a aVar = (a) this.a.remove(i3);
                this.b = aVar;
                aVar.d = false;
                this.c.a(aVar.getLatitude(), this.b.getLongitude(), this.b.f);
            }
        } else {
            this.c.a(i);
            LatLng latLng = ((a) this.a.remove(i)).a;
            Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                ((a) it2.next()).c = i2;
                i2++;
            }
        }
        b(z);
    }

    public final void a(LatLng latLng, int i, com.mappls.sdk.navigation.data.a aVar) {
        if (aVar.g() && com.mappls.sdk.navigation.util.a.a(aVar.e())) {
            aVar.a(com.mappls.sdk.navigation.data.a.a(this.f));
        }
        this.c.b(latLng.getLatitude(), latLng.getLongitude(), aVar, i);
        g();
        b(true);
    }

    public final void a(ArrayList arrayList) {
        this.c.b();
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                com.mappls.sdk.navigation.data.a aVar = new com.mappls.sdk.navigation.data.a(FirebaseAnalytics.Param.DESTINATION, ((com.mappls.sdk.navigation.data.a) arrayList.get(i)).f());
                aVar.b(((com.mappls.sdk.navigation.data.a) arrayList.get(i)).f());
                this.c.a(((com.mappls.sdk.navigation.data.a) arrayList.get(i)).a(), ((com.mappls.sdk.navigation.data.a) arrayList.get(i)).b(), aVar, i);
            }
            g();
            b(true);
        }
    }

    public final void a(ArrayList arrayList, int i) {
        if (arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                com.mappls.sdk.navigation.data.a aVar = new com.mappls.sdk.navigation.data.a(FirebaseAnalytics.Param.DESTINATION, ((com.mappls.sdk.navigation.data.a) arrayList.get(i2)).f());
                aVar.b(((com.mappls.sdk.navigation.data.a) arrayList.get(i2)).f());
                this.c.a(((com.mappls.sdk.navigation.data.a) arrayList.get(i2)).a(), ((com.mappls.sdk.navigation.data.a) arrayList.get(i2)).b(), aVar, i + i2);
            }
            g();
            b(true);
        }
    }

    public final void a(boolean z) {
        a();
        this.c.b();
        this.c.c();
        this.c.d();
        if (z) {
            this.c.a();
        }
        this.b = null;
        this.a.clear();
        g();
        b(false);
    }

    public final void b() {
        a();
        this.c.c();
        this.c.b();
        this.a.clear();
        g();
        b(false);
    }

    public final void b(boolean z) {
        if (z && (this.d.s() || this.d.t() || this.d.q() || this.d.u())) {
            LatLng latLngM = this.c.m();
            NavLocation lastKnownLocation = NavigationContext.getNavigationContext().getLocationProvider().getLastKnownLocation();
            this.a.clear();
            ArrayList arrayListI = this.c.i();
            ArrayList arrayListB = this.c.b(arrayListI.size());
            for (int i = 0; i < arrayListI.size(); i++) {
                this.a.add(new a((String) arrayListI.get(i), com.mappls.sdk.navigation.data.a.a((String) arrayListB.get(i), (String) arrayListI.get(i)), i));
            }
            ArrayList arrayList = new ArrayList();
            if (this.c.o0.get().booleanValue()) {
                Iterator it2 = this.a.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((a) it2.next()).a);
                }
            }
            if ((!this.d.q() || lastKnownLocation == null) && latLngM != null) {
                NavLocation navLocation = new NavLocation("map");
                navLocation.setLatitude(latLngM.getLatitude());
                navLocation.setLongitude(latLngM.getLongitude());
                this.d.a(this.c.l(), arrayList, navLocation);
            } else {
                this.d.a(this.c.l(), arrayList, lastKnownLocation);
            }
        }
        Iterator it3 = this.e.iterator();
        while (it3.hasNext()) {
            ((v) it3.next()).a(null);
        }
    }

    public final ArrayList c() {
        return this.a;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        if (this.c.o0.get().booleanValue()) {
            Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                arrayList.add((a) it2.next());
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a);
        a aVar = this.b;
        if (aVar != null) {
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public final a f() {
        return this.b;
    }

    public final void a(String str, boolean z, com.mappls.sdk.navigation.data.a aVar) {
        a aVar2;
        if (str != null) {
            if (aVar.g() && com.mappls.sdk.navigation.util.a.a(aVar.e())) {
                aVar.a(com.mappls.sdk.navigation.data.a.a(this.f));
            }
            if (-1 > this.a.size() && (aVar2 = this.b) != null) {
                String str2 = aVar2.b;
                s sVar = this.c;
                if (str2 == null) {
                    sVar.a(aVar2.getLatitude(), aVar2.getLongitude(), aVar2.f, this.a.size());
                } else {
                    sVar.a(str2, aVar2.f, this.a.size());
                }
            }
            this.c.a(str, aVar);
        } else {
            a();
            this.c.c();
            this.c.b();
        }
        g();
        b(z);
    }

    public final void a(LatLng latLng, boolean z, int i, com.mappls.sdk.navigation.data.a aVar) {
        a aVar2;
        if (aVar.g() && com.mappls.sdk.navigation.util.a.a(aVar.e())) {
            aVar.a(com.mappls.sdk.navigation.data.a.a(this.f));
        }
        if (i < 0 || i > this.a.size()) {
            if (i > this.a.size() && (aVar2 = this.b) != null) {
                this.c.a(aVar2.getLatitude(), aVar2.getLongitude(), aVar2.f, this.a.size());
            }
            this.c.a(latLng.getLatitude(), latLng.getLongitude(), aVar);
        } else {
            this.c.a(latLng.getLatitude(), latLng.getLongitude(), aVar, i);
        }
        g();
        b(z);
    }
}
