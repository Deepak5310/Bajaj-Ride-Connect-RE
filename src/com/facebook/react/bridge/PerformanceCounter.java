package com.facebook.react.bridge;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
interface PerformanceCounter {
    Map<String, Long> getPerformanceCounters();

    void profileNextBatch();
}
