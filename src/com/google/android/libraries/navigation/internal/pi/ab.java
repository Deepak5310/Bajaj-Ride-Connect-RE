package com.google.android.libraries.navigation.internal.pi;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab {
    public final Deque a = new ConcurrentLinkedDeque();

    public final String toString() {
        return "MapTapListenerCollection{listeners=" + this.a.toString() + "}";
    }
}
