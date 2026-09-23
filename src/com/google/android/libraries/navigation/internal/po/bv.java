package com.google.android.libraries.navigation.internal.po;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bv {
    private static final com.google.android.libraries.navigation.internal.ol.y e = new bu();
    public volatile com.google.android.libraries.navigation.internal.yx.an a = com.google.android.libraries.navigation.internal.yx.a.a;
    public volatile com.google.android.libraries.navigation.internal.ol.x b = new com.google.android.libraries.navigation.internal.ol.x() { // from class: com.google.android.libraries.navigation.internal.po.bt
        @Override // com.google.android.libraries.navigation.internal.ol.x
        public final com.google.android.libraries.navigation.internal.ol.at a(List list, com.google.android.libraries.navigation.internal.oe.x xVar) {
            return null;
        }
    };
    public volatile com.google.android.libraries.navigation.internal.ol.y c = e;
    public volatile int[] d = new int[0];

    public final synchronized void a(com.google.android.libraries.navigation.internal.ol.x xVar) {
        this.b = xVar;
    }

    public final synchronized void b(com.google.android.libraries.navigation.internal.ol.y yVar) {
        this.c = yVar;
    }

    public final synchronized void c(int[] iArr) {
        this.d = iArr;
    }
}
