package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

/* JADX INFO: loaded from: classes5.dex */
public final class BackpressureDrainManager extends AtomicLong implements Producer {
    private static final long serialVersionUID = 2826241102729529449L;
    final BackpressureQueueCallback actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    public interface BackpressureQueueCallback {
        boolean accept(Object obj);

        void complete(Throwable th);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(BackpressureQueueCallback backpressureQueueCallback) {
        this.actual = backpressureQueueCallback;
    }

    public boolean isTerminated() {
        return this.terminated;
    }

    public void terminate() {
        this.terminated = true;
    }

    public void terminate(Throwable th) {
        if (this.terminated) {
            return;
        }
        this.exception = th;
        this.terminated = true;
    }

    public void terminateAndDrain() throws Throwable {
        this.terminated = true;
        drain();
    }

    public void terminateAndDrain(Throwable th) throws Throwable {
        if (this.terminated) {
            return;
        }
        this.exception = th;
        this.terminated = true;
        drain();
    }

    @Override // rx.Producer
    public void request(long j) throws Throwable {
        boolean z;
        long j2;
        if (j == 0) {
            return;
        }
        while (true) {
            long j3 = get();
            boolean z2 = true;
            z = j3 == 0;
            if (j3 == Long.MAX_VALUE) {
                break;
            }
            if (j == Long.MAX_VALUE) {
                j2 = j;
            } else {
                j2 = j3 <= Long.MAX_VALUE - j ? j3 + j : Long.MAX_VALUE;
                z2 = z;
            }
            if (compareAndSet(j3, j2)) {
                z = z2;
                break;
            }
        }
        if (z) {
            drain();
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0031 A[Catch: all -> 0x0085, TRY_ENTER, TryCatch #2 {all -> 0x0085, blocks: (B:10:0x0012, B:26:0x0037, B:16:0x001f, B:24:0x0031, B:59:0x0078), top: B:80:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0078 A[Catch: all -> 0x0085, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0085, blocks: (B:10:0x0012, B:26:0x0037, B:16:0x001f, B:24:0x0031, B:59:0x0078), top: B:80:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x007f A[LOOP:1: B:12:0x0015->B:62:0x007f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:90:0x007e A[SYNTHETIC] */
    public void drain() throws Throwable {
        Object objPoll;
        synchronized (this) {
            if (this.emitting) {
                return;
            }
            boolean z = true;
            this.emitting = true;
            boolean z2 = this.terminated;
            long j = get();
            try {
                BackpressureQueueCallback backpressureQueueCallback = this.actual;
                while (true) {
                    int i = 0;
                    while (true) {
                        try {
                            if (j <= 0 && !z2) {
                                break;
                            }
                            if (z2) {
                                if (backpressureQueueCallback.peek() != null) {
                                    if (j == 0) {
                                        break;
                                    }
                                    objPoll = backpressureQueueCallback.poll();
                                    if (objPoll != null) {
                                        break;
                                    }
                                    if (backpressureQueueCallback.accept(objPoll)) {
                                        return;
                                    }
                                    j--;
                                    i++;
                                } else {
                                    backpressureQueueCallback.complete(this.exception);
                                    return;
                                }
                            } else {
                                objPoll = backpressureQueueCallback.poll();
                                if (objPoll != null) {
                                    break;
                                }
                                if (backpressureQueueCallback.accept(objPoll)) {
                                    return;
                                }
                                j--;
                                i++;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (!z) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    }
                    try {
                        synchronized (this) {
                            try {
                                z2 = this.terminated;
                                boolean z3 = backpressureQueueCallback.peek() != null;
                                if (get() != Long.MAX_VALUE) {
                                    long jAddAndGet = addAndGet(-i);
                                    if ((jAddAndGet != 0 && z3) || (z2 && !z3)) {
                                        j = jAddAndGet;
                                    }
                                    this.emitting = false;
                                    return;
                                }
                                if (!z3 && !z2) {
                                    this.emitting = false;
                                    return;
                                }
                                j = Long.MAX_VALUE;
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                z = false;
            }
        }
    }
}
