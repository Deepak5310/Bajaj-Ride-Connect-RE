package com.google.android.libraries.navigation.internal.rt;

import com.google.android.libraries.geo.navcore.decoration.jni.DecorationCppInstance;
import com.google.android.libraries.navigation.internal.afr.f;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements f {
    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* synthetic */ Object a() {
        DecorationCppInstance decorationCppInstance = new DecorationCppInstance();
        decorationCppInstance.a = decorationCppInstance.nativeAllocate();
        return decorationCppInstance;
    }
}
