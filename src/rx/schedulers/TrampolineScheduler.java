package rx.schedulers;

import rx.Scheduler;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class TrampolineScheduler extends Scheduler {
    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return null;
    }

    private TrampolineScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
