package com.google.android.libraries.navigation.internal.pb;

import android.animation.TypeEvaluator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class u implements TypeEvaluator {
    @Override // android.animation.TypeEvaluator
    public final /* bridge */ /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
        com.google.android.libraries.navigation.internal.oe.x xVar = (com.google.android.libraries.navigation.internal.oe.x) obj2;
        return f == 1.0f ? xVar : ((com.google.android.libraries.navigation.internal.oe.x) obj).B(xVar, f);
    }
}
