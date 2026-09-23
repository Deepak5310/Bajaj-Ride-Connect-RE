package com.google.android.libraries.mapsplatform.turnbyturn.model;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class a extends Lane.Builder {
    private List a;

    @Override // com.google.android.libraries.mapsplatform.turnbyturn.model.Lane.Builder
    public final Lane build() {
        List list = this.a;
        if (list != null) {
            return new b(list);
        }
        throw new IllegalStateException("Missing required properties: laneDirections");
    }

    @Override // com.google.android.libraries.mapsplatform.turnbyturn.model.Lane.Builder
    public final Lane.Builder setLaneDirections(List<LaneDirection> list) {
        if (list == null) {
            throw new NullPointerException("Null laneDirections");
        }
        this.a = list;
        return this;
    }
}
