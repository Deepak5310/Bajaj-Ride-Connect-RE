package com.google.android.libraries.navigation.internal.agi;

import com.drew.metadata.avi.AviDirectory;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dt extends dr implements com.google.android.libraries.navigation.internal.agh.hl {
    final /* synthetic */ du a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dt(du duVar) {
        super(duVar);
        this.a = duVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dr
    public final /* bridge */ /* synthetic */ dr a(int i, int i2, boolean z) {
        return new dt(this.a, i, i2, z);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hl
    /* JADX INFO: renamed from: aP */
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agh.hl trySplit() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dr
    public final /* bridge */ /* synthetic */ void c(Object obj, int i) {
        ((LongConsumer) obj).accept(this.a.c[i]);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        if (this.f) {
            return 256;
        }
        return AviDirectory.TAG_DATETIME_ORIGINAL;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hl
    public final /* synthetic */ com.google.android.libraries.navigation.internal.agh.gk d() {
        return com.google.android.libraries.navigation.internal.agh.hk.d();
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.google.android.libraries.navigation.internal.agh.hk.b(this, consumer);
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
        return com.google.android.libraries.navigation.internal.agh.hk.c(this, consumer);
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
    public dt(du duVar, int i, int i2, boolean z) {
        super(duVar, i, i2, z);
        this.a = duVar;
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
