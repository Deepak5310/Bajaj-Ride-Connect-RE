package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.hj;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class af extends an implements hj {
    final /* synthetic */ aq a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(aq aqVar) {
        super(aqVar);
        this.a = aqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.an
    public final /* bridge */ /* synthetic */ an a(int i, int i2, boolean z) {
        return new af(this.a, i, i2, z);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hj
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ hj trySplit() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.an
    public final /* bridge */ /* synthetic */ void c(Object obj, int i) {
        ((Consumer) obj).accept(new ak(this.a, i));
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
    public af(aq aqVar, int i, int i2, boolean z) {
        super(aqVar, i, i2, z);
        this.a = aqVar;
    }
}
