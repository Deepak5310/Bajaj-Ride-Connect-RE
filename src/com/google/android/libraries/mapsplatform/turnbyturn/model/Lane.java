package com.google.android.libraries.mapsplatform.turnbyturn.model;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Lane {

    /* JADX INFO: compiled from: PG */
    public static abstract class Builder {
        public abstract Lane build();

        public abstract Builder setLaneDirections(List<LaneDirection> list);
    }

    public static Builder builder() {
        return new a();
    }

    public abstract List<LaneDirection> laneDirections();
}
