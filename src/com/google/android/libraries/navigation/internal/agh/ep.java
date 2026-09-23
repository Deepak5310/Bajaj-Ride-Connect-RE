package com.google.android.libraries.navigation.internal.agh;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ep extends en implements com.google.android.libraries.navigation.internal.agi.hj {
    final /* synthetic */ eq a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ep(eq eqVar) {
        super(eqVar);
        this.a = eqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.en
    public final /* bridge */ /* synthetic */ en a(int i, int i2, boolean z) {
        return new ep(this.a, i, i2, z);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hj
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agi.hj trySplit() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.en
    public final /* bridge */ /* synthetic */ void c(Object obj, int i) {
        ((Consumer) obj).accept(this.a.b[i]);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.f ? 0 : 64;
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return super.tryAdvance((Object) consumer);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return (Spliterator) super.e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ep(eq eqVar, int i, int i2, boolean z) {
        super(eqVar, i, i2, z);
        this.a = eqVar;
    }
}
