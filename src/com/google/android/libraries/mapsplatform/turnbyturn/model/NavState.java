package com.google.android.libraries.mapsplatform.turnbyturn.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface NavState {
    public static final int ENROUTE = 1;
    public static final int REROUTING = 2;
    public static final int STOPPED = 3;
    public static final int UNKNOWN = 0;
}
