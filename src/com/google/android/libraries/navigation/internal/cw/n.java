package com.google.android.libraries.navigation.internal.cw;

import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum n {
    UPDATE_FREQUENCY_NONE(0),
    UPDATE_FREQUENCY_SLOW(15),
    UPDATE_FREQUENCY_FAST(30);

    public final Duration d;

    n(int i) {
        this.d = i == 0 ? Duration.ZERO : Duration.ofSeconds(1L).dividedBy(i);
    }
}
