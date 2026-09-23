package com.google.android.libraries.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public interface OfflineListener {

    /* JADX INFO: compiled from: PG */
    public enum OfflineState {
        NONE,
        ONGOING,
        PAUSED,
        CANCELLING
    }

    void updateState(OfflineState offlineState, int i);
}
