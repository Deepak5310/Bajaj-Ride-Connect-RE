package com.google.android.libraries.navigation.internal.iz;

import com.google.android.libraries.navigation.internal.aac.ca;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public volatile ca a = new ca();

    public j() {
        this.a.d(true);
    }

    public final synchronized void a() {
        if (this.a.isDone()) {
            return;
        }
        this.a.d(true);
    }
}
