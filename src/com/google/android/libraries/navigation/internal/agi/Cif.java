package com.google.android.libraries.navigation.internal.agi;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.agi.if, reason: invalid class name */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class Cif extends in implements hj {
    final /* synthetic */ iq a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cif(iq iqVar) {
        super(iqVar);
        this.a = iqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.in
    public final /* bridge */ /* synthetic */ in a(int i, int i2, boolean z) {
        return new Cif(this.a, i, i2, z);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hj
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ hj trySplit() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.in
    public final /* bridge */ /* synthetic */ void c(Object obj, int i) {
        ((Consumer) obj).accept(new ik(this.a, i));
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
    public Cif(iq iqVar, int i, int i2, boolean z) {
        super(iqVar, i, i2, z);
        this.a = iqVar;
    }
}
