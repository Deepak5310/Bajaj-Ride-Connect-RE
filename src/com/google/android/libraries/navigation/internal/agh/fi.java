package com.google.android.libraries.navigation.internal.agh;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fi extends fm implements hl {
    final /* synthetic */ fp a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fi(fp fpVar) {
        super(fpVar);
        this.a = fpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.fm
    public final /* bridge */ /* synthetic */ fm a(int i, int i2, boolean z) {
        return new fi(this.a, i, i2, z);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hl
    /* JADX INFO: renamed from: aP */
    public final /* bridge */ /* synthetic */ hl trySplit() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.fm
    public final /* bridge */ /* synthetic */ void c(Object obj, int i) {
        ((LongConsumer) obj).accept(this.a.a[i]);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.f ? 257 : 321;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hl
    public final /* synthetic */ gk d() {
        return hk.d();
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        hk.b(this, consumer);
    }

    @Override // java.util.Spliterator.OfLong
    public final /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        super.forEachRemaining((Object) longConsumer);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return d();
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return hk.c(this, consumer);
    }

    @Override // java.util.Spliterator.OfLong
    public final /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return super.tryAdvance((Object) longConsumer);
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
        return (Spliterator.OfLong) super.e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fi(fp fpVar, int i, int i2, boolean z) {
        super(fpVar, i, i2, z);
        this.a = fpVar;
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return (Spliterator.OfPrimitive) super.e();
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return (Spliterator) super.e();
    }
}
