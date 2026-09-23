package com.google.android.libraries.navigation.internal.agi;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dj extends dr implements hj {
    final /* synthetic */ du a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(du duVar) {
        super(duVar);
        this.a = duVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dr
    public final /* bridge */ /* synthetic */ dr a(int i, int i2, boolean z) {
        return new dj(this.a, i, i2, z);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hj
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ hj trySplit() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dr
    public final /* bridge */ /* synthetic */ void c(Object obj, int i) {
        ((Consumer) obj).accept(new Cdo(this.a, i));
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.f ? 1 : 65;
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
    public dj(du duVar, int i, int i2, boolean z) {
        super(duVar, i, i2, z);
        this.a = duVar;
    }
}
