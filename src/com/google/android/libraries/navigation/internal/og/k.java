package com.google.android.libraries.navigation.internal.og;

import android.animation.TypeEvaluator;
import com.google.android.libraries.navigation.internal.oe.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k implements TypeEvaluator {
    @Override // android.animation.TypeEvaluator
    public final /* bridge */ /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
        x xVar = (x) obj2;
        return f == 1.0f ? xVar : ((x) obj).B(xVar, f);
    }
}
