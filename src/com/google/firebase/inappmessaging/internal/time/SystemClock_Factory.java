package com.google.firebase.inappmessaging.internal.time;

import com.google.firebase.inappmessaging.dagger.internal.Factory;

/* JADX INFO: loaded from: classes6.dex */
public final class SystemClock_Factory implements Factory<SystemClock> {
    @Override // javax.inject.Provider
    public SystemClock get() {
        return newInstance();
    }

    public static SystemClock_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SystemClock newInstance() {
        return new SystemClock();
    }

    private static final class InstanceHolder {
        private static final SystemClock_Factory INSTANCE = new SystemClock_Factory();

        private InstanceHolder() {
        }
    }
}
