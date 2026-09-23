package com.google.android.libraries.navigation.internal.agh;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fe extends fm implements com.google.android.libraries.navigation.internal.agi.hj {
    final /* synthetic */ fp a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fe(fp fpVar) {
        super(fpVar);
        this.a = fpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.fm
    public final /* bridge */ /* synthetic */ fm a(int i, int i2, boolean z) {
        return new fe(this.a, i, i2, z);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hj
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agi.hj trySplit() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.fm
    public final /* bridge */ /* synthetic */ void c(Object obj, int i) {
        ((Consumer) obj).accept(new fj(this.a, i));
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
    public fe(fp fpVar, int i, int i2, boolean z) {
        super(fpVar, i, i2, z);
        this.a = fpVar;
    }
}
