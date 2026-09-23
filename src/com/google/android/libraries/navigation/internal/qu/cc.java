package com.google.android.libraries.navigation.internal.qu;

import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cc implements Runnable {
    final /* synthetic */ ce a;

    public cc(ce ceVar) {
        this.a = ceVar;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0038 A[Catch: all -> 0x008a, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x008a, blocks: (B:12:0x001c, B:20:0x0038, B:58:0x0089, B:57:0x0086, B:54:0x0081, B:13:0x0026, B:14:0x0028, B:35:0x0058, B:37:0x005e, B:40:0x006b, B:48:0x007a, B:47:0x0077, B:51:0x007d), top: B:84:0x001c, inners: #2, #7 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x004a A[Catch: all -> 0x0052, TryCatch #1 {, blocks: (B:23:0x003e, B:25:0x0046, B:28:0x0050, B:27:0x004a), top: B:77:0x003e }] */
    /* JADX WARN: Code duplicated, block: B:66:0x009a A[Catch: all -> 0x00a2, TryCatch #0 {, blocks: (B:62:0x008e, B:64:0x0096, B:67:0x00a0, B:66:0x009a), top: B:75:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:75:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
    
        r1 = r5.a;
        r2 = r1.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005c, code lost:
    
        if (r2 == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005e, code lost:
    
        r1 = com.google.android.libraries.navigation.internal.nw.e.c("Cache commit pass ", r1.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0066, code lost:
    
        r2.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0069, code lost:
    
        if (r1 == null) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        androidx.tracing.Trace.endSection();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006f, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0070, code lost:
    
        if (r1 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0072, code lost:
    
        androidx.tracing.Trace.endSection();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0076, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0077, code lost:
    
        r2.addSuppressed(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x007a, code lost:
    
        throw r2;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        int i;
        ce ceVar;
        int i2;
        synchronized (this.a) {
            if (this.a.e == cd.b || this.a.e == cd.c) {
                this.a.e = cd.e;
                try {
                    com.google.android.libraries.navigation.internal.nw.d dVarC = com.google.android.libraries.navigation.internal.nw.e.c("Cache commit run ", this.a.a);
                    while (true) {
                        try {
                            synchronized (this.a) {
                                ceVar = this.a;
                                int i3 = ceVar.e;
                                int i4 = cd.d;
                                if (i3 == i4) {
                                    break;
                                } else {
                                    ceVar.e = i4;
                                }
                                synchronized (this.a) {
                                    i = this.a.e;
                                    if (i != cd.d || i == cd.e) {
                                        this.a.e = cd.a;
                                    }
                                    throw th;
                                }
                            }
                            if (dVarC != null) {
                                Trace.endSection();
                            }
                            synchronized (this.a) {
                                i2 = this.a.e;
                                if (i2 != cd.d || i2 == cd.e) {
                                    this.a.e = cd.a;
                                }
                            }
                        } catch (Throwable th) {
                            if (dVarC != null) {
                                try {
                                    Trace.endSection();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    }
                    ceVar.e = cd.a;
                    if (dVarC != null) {
                        Trace.endSection();
                    }
                    synchronized (this.a) {
                        i2 = this.a.e;
                        if (i2 != cd.d) {
                            this.a.e = cd.a;
                        } else {
                            this.a.e = cd.a;
                        }
                    }
                } catch (Throwable th3) {
                    synchronized (this.a) {
                        i = this.a.e;
                        if (i != cd.d) {
                            this.a.e = cd.a;
                        } else {
                            this.a.e = cd.a;
                        }
                        throw th3;
                    }
                }
            }
        }
    }
}
