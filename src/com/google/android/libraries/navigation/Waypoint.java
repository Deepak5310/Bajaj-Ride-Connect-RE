package com.google.android.libraries.navigation;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.navigation.internal.adr.lj;
import com.google.android.libraries.navigation.internal.adr.lm;
import com.google.android.libraries.navigation.internal.adr.ln;
import com.google.android.libraries.navigation.internal.bp.cj;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.maps.api.android.lib6.common.apiexception.ApiExpectedException;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalArgumentException;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalStateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class Waypoint {
    public static final Pattern a = Pattern.compile("0x[0-9a-fA-F]{16}");
    public static final ln b;
    private final ck c;

    /* JADX INFO: compiled from: PG */
    public static final class Builder {
        private String a;
        private String b;
        private com.google.android.libraries.navigation.internal.oe.r c;
        private boolean d;
        private int e;
        private boolean f;

        public Builder() {
            this.d = false;
            this.e = -1;
        }

        public Builder(Waypoint waypoint) {
            this.d = false;
            this.e = -1;
            this.a = waypoint.getTitle();
            if (waypoint.getPlaceId() != null && !waypoint.getPlaceId().isEmpty()) {
                this.b = waypoint.getPlaceId();
            }
            if (waypoint.getPosition() != null) {
                this.c = new com.google.android.libraries.navigation.internal.oe.r(waypoint.getPosition().latitude, waypoint.getPosition().longitude);
            }
            this.d = waypoint.getPreferSameSideOfRoad();
            this.e = waypoint.getPreferredHeading();
            this.f = waypoint.getVehicleStopover();
        }

        public Waypoint build() {
            try {
                cj cjVarM = ck.M();
                com.google.android.libraries.navigation.internal.oe.r rVar = this.c;
                if (rVar == null && this.b == null) {
                    throw new ApiIllegalStateException("Either a latLng position or a placeIdString must be specified.");
                }
                if (rVar != null) {
                    ((com.google.android.libraries.navigation.internal.bp.t) cjVarM).c = rVar;
                }
                if (this.b != null) {
                    if (Waypoint.a.matcher(this.b).matches()) {
                        com.google.android.libraries.navigation.internal.zk.e eVarJ = new com.google.android.libraries.navigation.internal.zk.d(com.google.android.libraries.navigation.internal.zy.p.c(this.b.substring(2), 16)).j();
                        ((com.google.android.libraries.navigation.internal.bp.t) cjVarM).c = new com.google.android.libraries.navigation.internal.oe.r(eVarJ.a(), eVarJ.b());
                    } else {
                        ((com.google.android.libraries.navigation.internal.bp.t) cjVarM).d = this.b;
                    }
                }
                String str = this.a;
                ((com.google.android.libraries.navigation.internal.bp.t) cjVarM).f = str;
                if (!com.google.android.libraries.navigation.internal.yx.aq.c(str)) {
                    cjVarM.m(lj.ENTITY_TYPE_NICKNAME);
                }
                if (this.e != -1) {
                    cjVarM.s(true);
                    cjVarM.t(this.e);
                } else {
                    cjVarM.s(this.d);
                }
                cjVarM.u();
                if (this.f) {
                    cjVarM.q(com.google.android.libraries.navigation.internal.hc.a.a(Waypoint.b));
                }
                return new Waypoint(cjVarM.B());
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setLatLng(double d, double d2) {
            try {
                if (this.b != null) {
                    throw new ApiIllegalArgumentException("A placeId has already been set.");
                }
                this.c = new com.google.android.libraries.navigation.internal.oe.r(d, d2);
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setPlaceIdString(String str) throws UnsupportedPlaceIdException {
            try {
                if (this.c != null) {
                    throw new ApiIllegalArgumentException("A lat/lng position has already been set.");
                }
                if (str.isEmpty()) {
                    throw new UnsupportedPlaceIdException();
                }
                this.b = str;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setPreferSameSideOfRoad(boolean z) {
            try {
                this.d = z;
                this.e = -1;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setPreferredHeading(int i) throws InvalidSegmentHeadingException {
            try {
                if (i < 0 || i >= 360) {
                    throw new InvalidSegmentHeadingException();
                }
                this.e = i;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setTitle(String str) {
            try {
                this.a = str;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setVehicleStopover(boolean z) {
            try {
                this.f = z;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }
    }

    /* JADX INFO: compiled from: PG */
    public static class InvalidSegmentHeadingException extends Exception implements ApiExpectedException {
        public InvalidSegmentHeadingException() {
            super("ERROR: Unable to create waypoint. Invalid segment heading. Segment heading should be a degree in [0,360)");
        }
    }

    /* JADX INFO: compiled from: PG */
    public static class UnsupportedPlaceIdException extends Exception implements ApiExpectedException {
        public UnsupportedPlaceIdException() {
            super("ERROR: Unable to create waypoint. Unsupported place ID.");
        }
    }

    static {
        lm lmVar = (lm) ln.a.q();
        if (!lmVar.b.H()) {
            lmVar.v();
        }
        ln lnVar = (ln) lmVar.b;
        lnVar.b |= 1;
        lnVar.c = true;
        if (!lmVar.b.H()) {
            lmVar.v();
        }
        ln lnVar2 = (ln) lmVar.b;
        lnVar2.b |= 2;
        lnVar2.d = true;
        if (!lmVar.b.H()) {
            lmVar.v();
        }
        ln lnVar3 = (ln) lmVar.b;
        lnVar3.b |= 4;
        lnVar3.e = true;
        if (!lmVar.b.H()) {
            lmVar.v();
        }
        ln lnVar4 = (ln) lmVar.b;
        lnVar4.b |= 8;
        lnVar4.f = true;
        b = (ln) lmVar.t();
    }

    public Waypoint(ck ckVar) {
        try {
            this.c = ckVar;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Deprecated
    public static Waypoint b(double d, double d2, String str) {
        try {
            cj cjVarM = ck.M();
            ((com.google.android.libraries.navigation.internal.bp.t) cjVarM).c = new com.google.android.libraries.navigation.internal.oe.r(d, d2);
            ((com.google.android.libraries.navigation.internal.bp.t) cjVarM).f = str;
            if (!com.google.android.libraries.navigation.internal.yx.aq.c(str)) {
                cjVarM.m(lj.ENTITY_TYPE_NICKNAME);
            }
            cjVarM.u();
            return new Waypoint(cjVarM.B());
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static Builder builder() {
        try {
            return new Builder();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Deprecated
    public static Waypoint c(String str, String str2) throws UnsupportedPlaceIdException {
        try {
            if (str.isEmpty()) {
                throw new UnsupportedPlaceIdException();
            }
            if (a.matcher(str).matches()) {
                com.google.android.libraries.navigation.internal.zk.e eVarJ = new com.google.android.libraries.navigation.internal.zk.d(com.google.android.libraries.navigation.internal.zy.n.a(str.substring(2)).b).j();
                cj cjVarM = ck.M();
                ((com.google.android.libraries.navigation.internal.bp.t) cjVarM).c = new com.google.android.libraries.navigation.internal.oe.r(eVarJ.a(), eVarJ.b());
                ((com.google.android.libraries.navigation.internal.bp.t) cjVarM).f = str2;
                cjVarM.u();
                return new Waypoint(cjVarM.B());
            }
            cj cjVarM2 = ck.M();
            ((com.google.android.libraries.navigation.internal.bp.t) cjVarM2).d = str;
            ((com.google.android.libraries.navigation.internal.bp.t) cjVarM2).f = str2;
            if (!com.google.android.libraries.navigation.internal.yx.aq.c(str2)) {
                cjVarM2.m(lj.ENTITY_TYPE_NICKNAME);
            }
            cjVarM2.u();
            return new Waypoint(cjVarM2.B());
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static ev d(List list) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(((Waypoint) it2.next()).a());
            }
            return ev.o(arrayList);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static Builder toBuilder(Waypoint waypoint) {
        try {
            return new Builder(waypoint);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public final ck a() {
        try {
            return this.c;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean equals(Object obj) {
        try {
            if (!(obj instanceof Waypoint)) {
                return false;
            }
            ck ckVarA = a();
            ck ckVarA2 = ((Waypoint) obj).a();
            return com.google.android.libraries.navigation.internal.yx.am.a(ckVarA.y(), ckVarA2.y()) && com.google.android.libraries.navigation.internal.yx.am.a(ckVarA.n(), ckVarA2.n()) && com.google.android.libraries.navigation.internal.yx.am.a(ckVarA.w(), ckVarA2.w());
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public String getPlaceId() {
        try {
            return this.c.w();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public LatLng getPosition() {
        try {
            if (this.c.n() != null) {
                return new LatLng(this.c.n().a, this.c.n().b);
            }
            return null;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean getPreferSameSideOfRoad() {
        try {
            return this.c.C();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int getPreferredHeading() {
        try {
            return this.c.b();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public String getTitle() {
        try {
            return this.c.V();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean getVehicleStopover() {
        try {
            ln lnVarT = this.c.T();
            if (lnVarT == null) {
                return false;
            }
            ln lnVar = b;
            if (lnVar.c == lnVarT.c) {
                boolean z = lnVar.d;
                boolean z2 = lnVarT.d;
                if (z == z2 && lnVar.e == z2 && lnVar.f == lnVarT.f) {
                    return true;
                }
            }
            return false;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(new Object[]{this.c.n(), this.c.w(), this.c.y()});
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public String toString() {
        try {
            return String.format(Locale.US, "Title: %s; PlaceId: %s; %s", getTitle(), getPlaceId(), getPosition() == null ? "Position: null" : String.format(Locale.US, "Position(Lat/Lng): (%f, %f)", Double.valueOf(getPosition().latitude), Double.valueOf(getPosition().longitude)));
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
