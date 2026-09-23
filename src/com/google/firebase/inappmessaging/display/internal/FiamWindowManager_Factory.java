package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

/* JADX INFO: loaded from: classes6.dex */
public final class FiamWindowManager_Factory implements Factory<FiamWindowManager> {
    @Override // javax.inject.Provider
    public FiamWindowManager get() {
        return newInstance();
    }

    public static FiamWindowManager_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FiamWindowManager newInstance() {
        return new FiamWindowManager();
    }

    private static final class InstanceHolder {
        private static final FiamWindowManager_Factory INSTANCE = new FiamWindowManager_Factory();

        private InstanceHolder() {
        }
    }
}
