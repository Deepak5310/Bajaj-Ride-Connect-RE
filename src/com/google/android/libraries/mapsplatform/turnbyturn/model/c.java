package com.google.android.libraries.mapsplatform.turnbyturn.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class c extends LaneDirection.Builder {
    private Boolean a;
    private int b;
    private byte c;

    @Override // com.google.android.libraries.mapsplatform.turnbyturn.model.LaneDirection.Builder
    public final LaneDirection build() {
        Boolean bool;
        if (this.c == 1 && (bool = this.a) != null) {
            return new d(bool, this.b);
        }
        StringBuilder sb = new StringBuilder();
        if (this.a == null) {
            sb.append(" isRecommended");
        }
        if (this.c == 0) {
            sb.append(" laneShape");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.mapsplatform.turnbyturn.model.LaneDirection.Builder
    public final LaneDirection.Builder setIsRecommended(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null isRecommended");
        }
        this.a = bool;
        return this;
    }

    @Override // com.google.android.libraries.mapsplatform.turnbyturn.model.LaneDirection.Builder
    public final LaneDirection.Builder setLaneShape(int i) {
        this.b = i;
        this.c = (byte) 1;
        return this;
    }
}
