package com.google.android.libraries.navigation.internal.kh;

import com.google.android.libraries.navigation.internal.yz.ew;
import com.google.android.libraries.navigation.internal.yz.ex;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q {
    private final ConcurrentMap a = new ConcurrentHashMap();

    final ex a() {
        ew ewVar = new ew();
        for (String str : this.a.keySet()) {
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.a.get(str);
            for (com.google.android.libraries.navigation.internal.ke.c cVar = (com.google.android.libraries.navigation.internal.ke.c) concurrentLinkedQueue.poll(); cVar != null; cVar = (com.google.android.libraries.navigation.internal.ke.c) concurrentLinkedQueue.poll()) {
                ewVar.b(str, cVar);
            }
        }
        return ewVar.a();
    }

    final void b(String str, com.google.android.libraries.navigation.internal.ke.c cVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.a.get(str);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            ConcurrentLinkedQueue concurrentLinkedQueue2 = (ConcurrentLinkedQueue) this.a.putIfAbsent(str, concurrentLinkedQueue);
            if (concurrentLinkedQueue2 != null) {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
        }
        concurrentLinkedQueue.add(cVar);
        if (concurrentLinkedQueue.size() > 10000) {
            concurrentLinkedQueue.poll();
        }
    }
}
