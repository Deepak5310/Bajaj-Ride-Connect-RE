package com.google.android.libraries.geo.mapcore.internal.store.diskcache;

import androidx.core.internal.view.SupportMenu;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends IOException {
    public final int a;

    public d() {
        super("Failed to create sqlite disk cache directory");
        this.a = 0;
    }

    public d(Throwable th) {
        int i;
        super(th);
        int i2 = 0;
        if ((th instanceof com.google.android.apps.gmm.jni.util.c) && (i = ((com.google.android.apps.gmm.jni.util.c) th).b) >= 65536 && i < 81920) {
            i2 = i + SupportMenu.CATEGORY_MASK;
        }
        this.a = i2;
    }
}
