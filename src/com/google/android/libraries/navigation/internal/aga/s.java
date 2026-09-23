package com.google.android.libraries.navigation.internal.aga;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface s extends Closeable {
    u a(SocketAddress socketAddress, r rVar, com.google.android.libraries.navigation.internal.afx.g gVar);

    Collection b();

    ScheduledExecutorService c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
