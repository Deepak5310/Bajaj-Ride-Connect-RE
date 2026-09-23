package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

/* JADX INFO: loaded from: classes6.dex */
public final class RenewableTimer_Factory implements Factory<RenewableTimer> {
    @Override // javax.inject.Provider
    public RenewableTimer get() {
        return newInstance();
    }

    public static RenewableTimer_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RenewableTimer newInstance() {
        return new RenewableTimer();
    }

    private static final class InstanceHolder {
        private static final RenewableTimer_Factory INSTANCE = new RenewableTimer_Factory();

        private InstanceHolder() {
        }
    }
}
