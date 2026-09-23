package com.google.android.libraries.navigation.internal.abh;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements LifecycleOwner {
    public static final /* synthetic */ int e = 0;
    public final LifecycleRegistry a = new LifecycleRegistry(this);
    public int b = 0;
    com.google.android.libraries.navigation.internal.yx.br c;
    com.google.android.libraries.navigation.internal.wd.g d;

    public final void a() {
        com.google.android.libraries.navigation.internal.abf.ah.a().execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.k
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
            }
        });
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.a;
    }
}
