package com.google.android.libraries.navigation.internal.agi;

import com.drew.metadata.avi.AviDirectory;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bh extends bf implements com.google.android.libraries.navigation.internal.agf.ao {
    final /* synthetic */ bi a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(bi biVar) {
        super(biVar);
        this.a = biVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.ao
    public final /* synthetic */ com.google.android.libraries.navigation.internal.agf.o a() {
        return com.google.android.libraries.navigation.internal.agf.an.d();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bf
    public final /* bridge */ /* synthetic */ bf aT(int i, int i2, boolean z) {
        return new bh(this.a, i, i2, z);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bf
    public final /* bridge */ /* synthetic */ void c(Object obj, int i) {
        ((com.google.android.libraries.navigation.internal.agf.s) obj).c(this.a.b[i]);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        if (this.f) {
            return 256;
        }
        return AviDirectory.TAG_DATETIME_ORIGINAL;
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.google.android.libraries.navigation.internal.agf.an.b(this, consumer);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return a();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return com.google.android.libraries.navigation.internal.agf.an.c(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return (Spliterator.OfPrimitive) super.d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(bi biVar, int i, int i2, boolean z) {
        super(biVar, i, i2, z);
        this.a = biVar;
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return (Spliterator) super.d();
    }
}
