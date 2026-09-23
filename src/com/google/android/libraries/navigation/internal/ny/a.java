package com.google.android.libraries.navigation.internal.ny;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.libraries.navigation.internal.ky.ab;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements ab {
    @Override // com.google.android.libraries.navigation.internal.ky.ab
    public final long a(long j) {
        if (j < 0) {
            return 0L;
        }
        if (j < 128) {
            return j;
        }
        if (j >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        int i = (int) j;
        return i & ((-1) << (25 - Integer.numberOfLeadingZeros(i)));
    }
}
