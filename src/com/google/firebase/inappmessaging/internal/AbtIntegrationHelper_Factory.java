package com.google.firebase.inappmessaging.internal;

import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes6.dex */
public final class AbtIntegrationHelper_Factory implements Factory<AbtIntegrationHelper> {
    private final Provider<FirebaseABTesting> abTestingProvider;
    private final Provider<Executor> blockingExecutorProvider;

    public AbtIntegrationHelper_Factory(Provider<FirebaseABTesting> provider, Provider<Executor> provider2) {
        this.abTestingProvider = provider;
        this.blockingExecutorProvider = provider2;
    }

    @Override // javax.inject.Provider
    public AbtIntegrationHelper get() {
        return newInstance(this.abTestingProvider.get(), this.blockingExecutorProvider.get());
    }

    public static AbtIntegrationHelper_Factory create(Provider<FirebaseABTesting> provider, Provider<Executor> provider2) {
        return new AbtIntegrationHelper_Factory(provider, provider2);
    }

    public static AbtIntegrationHelper newInstance(FirebaseABTesting firebaseABTesting, Executor executor) {
        return new AbtIntegrationHelper(firebaseABTesting, executor);
    }
}
