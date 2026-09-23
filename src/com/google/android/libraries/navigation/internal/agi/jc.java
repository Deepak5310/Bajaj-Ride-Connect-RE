package com.google.android.libraries.navigation.internal.agi;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class jc extends jk implements hj {
    final /* synthetic */ jn a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jc(jn jnVar) {
        super(jnVar);
        this.a = jnVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.jk
    public final /* bridge */ /* synthetic */ jk a(int i, int i2, boolean z) {
        return new jc(this.a, i, i2, z);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hj
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ hj trySplit() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agi.jk
    public final /* bridge */ /* synthetic */ void c(Object obj, int i) {
        obj.accept(new jh(this.a, i));
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.f ? 1 : 65;
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.e(consumer);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return super.f(consumer);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return (Spliterator) super.d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jc(jn jnVar, int i, int i2, boolean z) {
        super(jnVar, i, i2, z);
        this.a = jnVar;
    }
}
