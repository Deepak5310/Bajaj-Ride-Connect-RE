package com.google.android.libraries.navigation.internal.agi;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ax extends bf implements hj {
    final /* synthetic */ bi a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(bi biVar) {
        super(biVar);
        this.a = biVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bf
    public final /* bridge */ /* synthetic */ bf aT(int i, int i2, boolean z) {
        return new ax(this.a, i, i2, z);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hj
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ hj trySplit() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bf
    public final /* bridge */ /* synthetic */ void c(Object obj, int i) {
        ((Consumer) obj).accept(new bc(this.a, i));
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
        return (Spliterator) super.d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(bi biVar, int i, int i2, boolean z) {
        super(biVar, i, i2, z);
        this.a = biVar;
    }
}
