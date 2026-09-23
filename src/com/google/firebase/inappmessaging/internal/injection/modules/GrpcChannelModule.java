package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import javax.inject.Named;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes6.dex */
@Module
public class GrpcChannelModule {
    @Provides
    @Singleton
    @Named("host")
    public String providesServiceHost() {
        return "firebaseinappmessaging.googleapis.com";
    }

    @Provides
    @Singleton
    public Channel providesGrpcChannel(@Named("host") String str) {
        return ManagedChannelBuilder.forTarget(str).build();
    }
}
