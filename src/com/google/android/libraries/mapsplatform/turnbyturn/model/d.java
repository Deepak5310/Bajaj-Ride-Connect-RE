package com.google.android.libraries.mapsplatform.turnbyturn.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class d extends LaneDirection {
    private final Boolean a;
    private final int b;

    public d(Boolean bool, int i) {
        this.a = bool;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LaneDirection) {
            LaneDirection laneDirection = (LaneDirection) obj;
            if (this.a.equals(laneDirection.isRecommended()) && this.b == laneDirection.laneShape()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b;
    }

    @Override // com.google.android.libraries.mapsplatform.turnbyturn.model.LaneDirection
    public final Boolean isRecommended() {
        return this.a;
    }

    @Override // com.google.android.libraries.mapsplatform.turnbyturn.model.LaneDirection
    public final int laneShape() {
        return this.b;
    }

    public final String toString() {
        return "LaneDirection{isRecommended=" + this.a + ", laneShape=" + this.b + "}";
    }
}
