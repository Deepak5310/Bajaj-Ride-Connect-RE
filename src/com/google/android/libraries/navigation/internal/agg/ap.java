package com.google.android.libraries.navigation.internal.agg;

import com.drew.metadata.avi.AviDirectory;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ap extends an implements fh {
    final /* synthetic */ aq a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(aq aqVar) {
        super(aqVar);
        this.a = aqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.an
    public final /* bridge */ /* synthetic */ an a(int i, int i2, boolean z) {
        return new ap(this.a, i, i2, z);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fh
    /* JADX INFO: renamed from: aM */
    public final /* bridge */ /* synthetic */ fh trySplit() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.an
    public final /* bridge */ /* synthetic */ void c(Object obj, int i) {
        ((IntConsumer) obj).accept(this.a.b[i]);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        if (this.f) {
            return 256;
        }
        return AviDirectory.TAG_DATETIME_ORIGINAL;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fh
    public final /* synthetic */ void d() {
        fg.c();
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        fg.a(this, consumer);
    }

    @Override // java.util.Spliterator.OfInt
    public final /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        super.forEachRemaining((Object) intConsumer);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        d();
        return null;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return fg.b(this, consumer);
    }

    @Override // java.util.Spliterator.OfInt
    public final /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return super.tryAdvance((Object) intConsumer);
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
        return (Spliterator.OfInt) super.e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(aq aqVar, int i, int i2, boolean z) {
        super(aqVar, i, i2, z);
        this.a = aqVar;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return (Spliterator.OfPrimitive) super.e();
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return (Spliterator) super.e();
    }
}
