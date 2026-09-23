package com.google.android.libraries.navigation.internal.fq;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements ComponentCallbacks2 {
    final /* synthetic */ f a;

    public c(f fVar) {
        this.a = fVar;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        onTrimMemory(80);
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i >= 80) {
            this.a.b(e.COMPLETE);
            return;
        }
        if (i >= 60) {
            this.a.b(e.MODERATE);
            return;
        }
        if (i >= 40) {
            this.a.b(e.BACKGROUND);
            return;
        }
        if (i >= 20) {
            this.a.b(e.UI_HIDDEN);
            return;
        }
        if (i >= 15) {
            this.a.b(e.RUNNING_CRITICAL);
        } else if (i >= 10) {
            this.a.b(e.RUNNING_LOW);
        } else if (i >= 5) {
            this.a.b(e.RUNNING_MODERATE);
        }
    }
}
