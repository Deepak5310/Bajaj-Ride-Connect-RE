package com.google.android.libraries.navigation.internal.qu;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bf {
    AtomicInteger a = new AtomicInteger();
    AtomicInteger b = new AtomicInteger();
    AtomicInteger c = new AtomicInteger();
    AtomicInteger d = new AtomicInteger();
    AtomicInteger e = new AtomicInteger();
    AtomicInteger f = new AtomicInteger();
    AtomicInteger g = new AtomicInteger();
    AtomicInteger h = new AtomicInteger();
    AtomicInteger i = new AtomicInteger();
    AtomicInteger j = new AtomicInteger();
    AtomicInteger k = new AtomicInteger();

    public final String toString() {
        return "Items loaded from sql disk cache: " + this.a.get() + ", items loaded from offroad: " + this.b.get() + ", items requested from network: " + this.c.get() + ", items from resourceManager's cache: " + this.d.get() + ", items received from network: " + this.e.get() + ", items failed from network: " + this.f.get() + ", total items requested: " + this.g.get() + ", items requested but had null url: " + this.h.get() + ", total items notified: " + this.i.get() + ", futures completed: " + this.j.get() + ", futures failed: " + this.k.get();
    }
}
