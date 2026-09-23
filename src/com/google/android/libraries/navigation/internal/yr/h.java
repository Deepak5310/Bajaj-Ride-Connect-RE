package com.google.android.libraries.navigation.internal.yr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        com.google.android.libraries.navigation.internal.xx.c.c();
        ae aeVar = new ae();
        Thread threadCurrentThread = Thread.currentThread();
        synchronized (i.c) {
            i.c.put(threadCurrentThread, aeVar);
        }
        return aeVar;
    }
}
