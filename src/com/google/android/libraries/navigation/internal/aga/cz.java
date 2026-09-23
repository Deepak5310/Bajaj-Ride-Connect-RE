package com.google.android.libraries.navigation.internal.aga;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cz extends ar {
    private static final ReferenceQueue b = new ReferenceQueue();
    private static final ConcurrentMap c = new ConcurrentHashMap();
    public static final Logger a = Logger.getLogger(cz.class.getName());

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cz(com.google.android.libraries.navigation.internal.afx.bd bdVar) {
        super(bdVar);
        ReferenceQueue referenceQueue = b;
        ConcurrentMap concurrentMap = c;
        new cy(this, bdVar, referenceQueue, concurrentMap);
    }
}
