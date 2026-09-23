package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public enum cn implements af {
    POLYLINE_DEACTIVATED(180001),
    POLYLINE_DEACTIVATED_WITH_STAMPS(180001),
    POLYLINE_DIMMED(180002),
    POLYLINE(180010),
    POLYLINE_OVERLAY,
    POLYLINE_MEASLES,
    STEP_ARROW_OVERLAY(180012),
    DISTANCE_TOOL_POLYLINE,
    DISTANCE_TOOL_MEASLE;

    public static final int j = cg.b + cg.values().length;
    public final int k;

    cn() {
        this(180010);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final int a() {
        return j + ordinal();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final int b() {
        return ordinal();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final dy c() {
        return dy.POLYLINE_PASS;
    }

    cn(int i) {
        this.k = i;
    }
}
