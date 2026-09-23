package com.google.firebase.inappmessaging.model;

import com.google.firebase.inappmessaging.dagger.internal.Factory;

/* JADX INFO: loaded from: classes6.dex */
public final class ProtoMarshallerClient_Factory implements Factory<ProtoMarshallerClient> {
    @Override // javax.inject.Provider
    public ProtoMarshallerClient get() {
        return newInstance();
    }

    public static ProtoMarshallerClient_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ProtoMarshallerClient newInstance() {
        return new ProtoMarshallerClient();
    }

    private static final class InstanceHolder {
        private static final ProtoMarshallerClient_Factory INSTANCE = new ProtoMarshallerClient_Factory();

        private InstanceHolder() {
        }
    }
}
