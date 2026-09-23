package com.google.android.libraries.mapsplatform.turnbyturn.model;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class b extends Lane {
    private final List a;

    public b(List list) {
        this.a = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Lane) {
            return this.a.equals(((Lane) obj).laneDirections());
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @Override // com.google.android.libraries.mapsplatform.turnbyturn.model.Lane
    public final List<LaneDirection> laneDirections() {
        return this.a;
    }

    public final String toString() {
        return "Lane{laneDirections=" + String.valueOf(this.a) + "}";
    }
}
