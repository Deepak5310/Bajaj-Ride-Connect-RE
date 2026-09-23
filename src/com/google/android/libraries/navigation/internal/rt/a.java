package com.google.android.libraries.navigation.internal.rt;

import com.google.android.libraries.geo.navcore.decoration.impl.DecorationApiImpl;
import com.google.android.libraries.geo.navcore.decoration.jni.DecorationCppInstance;
import com.google.android.libraries.navigation.internal.afr.f;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public a(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        DecorationCppInstance decorationCppInstance = (DecorationCppInstance) this.a.a();
        DecorationApiImpl decorationApiImpl = new DecorationApiImpl();
        decorationApiImpl.a = decorationApiImpl.nativeAllocateAndSubscribe(decorationCppInstance.a);
        return decorationApiImpl;
    }
}
