package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes6.dex */
public final class ApiClientModule_ProvidesFirebaseAppFactory implements Factory<FirebaseApp> {
    private final ApiClientModule module;

    public ApiClientModule_ProvidesFirebaseAppFactory(ApiClientModule apiClientModule) {
        this.module = apiClientModule;
    }

    @Override // javax.inject.Provider
    public FirebaseApp get() {
        return providesFirebaseApp(this.module);
    }

    public static ApiClientModule_ProvidesFirebaseAppFactory create(ApiClientModule apiClientModule) {
        return new ApiClientModule_ProvidesFirebaseAppFactory(apiClientModule);
    }

    public static FirebaseApp providesFirebaseApp(ApiClientModule apiClientModule) {
        return (FirebaseApp) Preconditions.checkNotNullFromProvides(apiClientModule.providesFirebaseApp());
    }
}
