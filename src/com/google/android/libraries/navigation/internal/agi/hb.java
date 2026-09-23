package com.google.android.libraries.navigation.internal.agi;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hb implements hj {
    int a;
    final int b;
    int c;
    boolean d;
    boolean e;
    final /* synthetic */ hc f;

    public hb(hc hcVar) {
        this.f = hcVar;
        this.a = 0;
        this.b = hcVar.d;
        this.c = 0;
        this.d = hcVar.c;
        this.e = false;
    }

    public hb(hc hcVar, int i, int i2, boolean z) {
        this.f = hcVar;
        this.c = 0;
        this.a = i;
        this.b = i2;
        this.d = z;
        this.e = true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hj
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ hj trySplit() {
        throw null;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.e ? 1 : 65;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        if (!this.e) {
            return this.f.g - this.c;
        }
        hc hcVar = this.f;
        return Math.min(hcVar.g - this.c, ((long) ((((double) hcVar.a()) / ((double) this.f.d)) * ((double) (this.b - this.a)))) + (this.d ? 1L : 0L));
    }

    @Override // java.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        if (this.d) {
            this.d = false;
            this.c++;
            hc hcVar = this.f;
            consumer.accept(hcVar.a[hcVar.d]);
            return true;
        }
        Object[] objArr = this.f.a;
        while (true) {
            int i = this.a;
            if (i >= this.b) {
                return false;
            }
            int i2 = i + 1;
            Object obj = objArr[i];
            if (obj != null) {
                this.c++;
                this.a = i2;
                consumer.accept(obj);
                return true;
            }
            this.a = i2;
        }
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        int i;
        int i2 = this.b;
        int i3 = this.a;
        if (i3 >= i2 - 1 || (i = (i2 - i3) >> 1) <= 1) {
            return null;
        }
        int i4 = i + i3;
        hb hbVar = new hb(this.f, i3, i4, this.d);
        this.a = i4;
        this.d = false;
        this.e = true;
        return hbVar;
    }

    @Override // java.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        hc hcVar = this.f;
        Object[] objArr = hcVar.a;
        if (this.d) {
            this.d = false;
            consumer.accept(objArr[hcVar.d]);
            this.c++;
        }
        while (true) {
            int i = this.a;
            if (i >= this.b) {
                return;
            }
            Object obj = objArr[i];
            if (obj != null) {
                consumer.accept(obj);
                this.c++;
            }
            this.a++;
        }
    }
}
