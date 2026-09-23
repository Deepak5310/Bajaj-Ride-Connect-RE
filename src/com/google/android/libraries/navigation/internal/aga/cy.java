package com.google.android.libraries.navigation.internal.aga;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cy extends WeakReference {
    private static final boolean a = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", "true"));
    private static final RuntimeException b;
    private final ReferenceQueue c;
    private final ConcurrentMap d;
    private final String e;
    private final Reference f;
    private final AtomicBoolean g;

    static {
        RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
        runtimeException.setStackTrace(new StackTraceElement[0]);
        b = runtimeException;
    }

    public cy(cz czVar, com.google.android.libraries.navigation.internal.afx.bd bdVar, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
        super(czVar, referenceQueue);
        this.g = new AtomicBoolean();
        this.f = new SoftReference(a ? new RuntimeException("ManagedChannel allocation site") : b);
        this.e = bdVar.toString();
        this.c = referenceQueue;
        this.d = concurrentMap;
        concurrentMap.put(this, this);
        a(referenceQueue);
    }

    static void a(ReferenceQueue referenceQueue) {
        while (true) {
            cy cyVar = (cy) referenceQueue.poll();
            if (cyVar == null) {
                return;
            }
            RuntimeException runtimeException = (RuntimeException) cyVar.f.get();
            cyVar.b();
            if (!cyVar.g.get()) {
                Level level = Level.SEVERE;
                if (cz.a.isLoggable(level)) {
                    LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was garbage collected without being shut down! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow()");
                    logRecord.setLoggerName(cz.a.getName());
                    logRecord.setParameters(new Object[]{cyVar.e});
                    logRecord.setThrown(runtimeException);
                    cz.a.log(logRecord);
                }
            }
        }
    }

    private final void b() {
        super.clear();
        this.d.remove(this);
        this.f.clear();
    }

    @Override // java.lang.ref.Reference
    public final void clear() {
        b();
        a(this.c);
    }
}
