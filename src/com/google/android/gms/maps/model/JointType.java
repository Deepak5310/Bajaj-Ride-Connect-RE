package com.google.android.gms.maps.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class JointType {
    public static final int BEVEL = 1;
    public static final int DEFAULT = 0;
    public static final int ROUND = 2;

    private JointType() {
    }

    public static boolean a(int i) {
        return i == 0 || i == 1 || i == 2;
    }
}
