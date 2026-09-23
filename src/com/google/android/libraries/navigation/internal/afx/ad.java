package com.google.android.libraries.navigation.internal.afx;

import com.mappls.sdk.navigation.util.SavingTrackHelper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad {
    public String a;
    public ae b;
    public al c;
    private Long d;

    public final af a() {
        com.google.android.libraries.navigation.internal.yx.ar.r(this.a, SavingTrackHelper.POINT_COL_DESCRIPTION);
        com.google.android.libraries.navigation.internal.yx.ar.r(this.b, "severity");
        com.google.android.libraries.navigation.internal.yx.ar.r(this.d, "timestampNanos");
        com.google.android.libraries.navigation.internal.yx.ar.l(true, "at least one of channelRef and subchannelRef must be null");
        return new af(this.a, this.b, this.d.longValue(), this.c);
    }

    public final void b(long j) {
        this.d = Long.valueOf(j);
    }
}
