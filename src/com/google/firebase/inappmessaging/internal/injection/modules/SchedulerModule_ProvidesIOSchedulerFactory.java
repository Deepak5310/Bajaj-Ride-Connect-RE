package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import io.reactivex.Scheduler;

/* JADX INFO: loaded from: classes6.dex */
public final class SchedulerModule_ProvidesIOSchedulerFactory implements Factory<Scheduler> {
    private final SchedulerModule module;

    public SchedulerModule_ProvidesIOSchedulerFactory(SchedulerModule schedulerModule) {
        this.module = schedulerModule;
    }

    @Override // javax.inject.Provider
    public Scheduler get() {
        return providesIOScheduler(this.module);
    }

    public static SchedulerModule_ProvidesIOSchedulerFactory create(SchedulerModule schedulerModule) {
        return new SchedulerModule_ProvidesIOSchedulerFactory(schedulerModule);
    }

    public static Scheduler providesIOScheduler(SchedulerModule schedulerModule) {
        return (Scheduler) Preconditions.checkNotNullFromProvides(schedulerModule.providesIOScheduler());
    }
}
