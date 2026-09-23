package com.google.android.libraries.navigation.internal.fq;

import com.google.android.libraries.navigation.internal.km.ac;
import com.google.android.libraries.navigation.internal.km.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
enum e {
    COMPLETE(0.0f),
    MODERATE(0.5f),
    BACKGROUND(1.0f),
    UI_HIDDEN(1.0f),
    RUNNING_CRITICAL(0.0f),
    RUNNING_LOW(0.5f),
    RUNNING_MODERATE(0.7f),
    THRESHOLD_REACHED(0.8f);

    public final float i;

    static {
        ac acVar = an.a;
    }

    e(float f) {
        this.i = f;
    }
}
