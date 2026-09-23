package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes6.dex */
public final class GrpcChannelModule_ProvidesServiceHostFactory implements Factory<String> {
    private final GrpcChannelModule module;

    public GrpcChannelModule_ProvidesServiceHostFactory(GrpcChannelModule grpcChannelModule) {
        this.module = grpcChannelModule;
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesServiceHost(this.module);
    }

    public static GrpcChannelModule_ProvidesServiceHostFactory create(GrpcChannelModule grpcChannelModule) {
        return new GrpcChannelModule_ProvidesServiceHostFactory(grpcChannelModule);
    }

    public static String providesServiceHost(GrpcChannelModule grpcChannelModule) {
        return (String) Preconditions.checkNotNullFromProvides(grpcChannelModule.providesServiceHost());
    }
}
