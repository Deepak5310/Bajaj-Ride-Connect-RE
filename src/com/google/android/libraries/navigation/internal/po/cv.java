package com.google.android.libraries.navigation.internal.po;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cv {
    public final Object a = new Object();
    public final List b = new ArrayList();
    public final List c = new ArrayList();
    public List d = new ArrayList();
    public List e = new ArrayList();
    public final AtomicBoolean f = new AtomicBoolean(false);
    public final com.google.android.libraries.navigation.internal.ol.ad g = new cu(this);
    final /* synthetic */ dh h;

    public cv(dh dhVar) {
        this.h = dhVar;
    }

    public final void a(Runnable runnable) {
        synchronized (this.a) {
            this.b.add(runnable);
        }
    }
}
