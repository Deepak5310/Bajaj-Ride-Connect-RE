package com.mappls.sdk.traffic.api;

import com.mappls.sdk.navigation.h;
import com.mappls.sdk.navigation.n;
import com.mappls.sdk.traffic.model.BeaconPacket;

/* JADX INFO: loaded from: classes4.dex */
final class a extends MapplsBeacon {
    private final String a;
    private final String b;
    private final BeaconPacket c;

    /* JADX INFO: renamed from: com.mappls.sdk.traffic.api.a$a, reason: collision with other inner class name */
    static final class C0117a extends MapplsBeacon.Builder {
        private String a;
        private String b;
        private BeaconPacket c;

        C0117a() {
        }

        @Override // com.mappls.sdk.traffic.api.MapplsBeacon.Builder
        final MapplsBeacon autoBuild() {
            String strA = this.a == null ? n.a("", " baseUrl") : "";
            if (this.c == null) {
                strA = n.a(strA, " beaconPacket");
            }
            if (strA.isEmpty()) {
                return new a(this.a, this.b, this.c, 0);
            }
            throw new IllegalStateException(n.a("Missing required properties:", strA));
        }

        @Override // com.mappls.sdk.traffic.api.MapplsBeacon.Builder
        public final MapplsBeacon.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.a = str;
            return this;
        }

        @Override // com.mappls.sdk.traffic.api.MapplsBeacon.Builder
        public final MapplsBeacon.Builder beaconKey(String str) {
            this.b = str;
            return this;
        }

        @Override // com.mappls.sdk.traffic.api.MapplsBeacon.Builder
        public final MapplsBeacon.Builder beaconPacket(BeaconPacket beaconPacket) {
            if (beaconPacket == null) {
                throw new NullPointerException("Null beaconPacket");
            }
            this.c = beaconPacket;
            return this;
        }
    }

    private a(String str, String str2, BeaconPacket beaconPacket) {
        this.a = str;
        this.b = str2;
        this.c = beaconPacket;
    }

    /* synthetic */ a(String str, String str2, BeaconPacket beaconPacket, int i) {
        this(str, str2, beaconPacket);
    }

    @Override // com.mappls.sdk.traffic.api.MapplsBeacon
    final String a() {
        return this.b;
    }

    @Override // com.mappls.sdk.traffic.api.MapplsBeacon
    final BeaconPacket b() {
        return this.c;
    }

    @Override // com.mappls.sdk.traffic.api.MapplsBeacon, com.mappls.sdk.services.api.MapplsService
    protected final String baseUrl() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsBeacon)) {
            return false;
        }
        MapplsBeacon mapplsBeacon = (MapplsBeacon) obj;
        return this.a.equals(mapplsBeacon.baseUrl()) && ((str = this.b) != null ? str.equals(mapplsBeacon.a()) : mapplsBeacon.a() == null) && this.c.equals(mapplsBeacon.b());
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.b;
        return ((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        StringBuilder sbA = h.a("MapplsBeacon{baseUrl=");
        sbA.append(this.a);
        sbA.append(", beaconKey=");
        sbA.append(this.b);
        sbA.append(", beaconPacket=");
        sbA.append(this.c);
        sbA.append("}");
        return sbA.toString();
    }
}
