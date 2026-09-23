package com.google.android.libraries.navigation.internal.agd;

import java.util.Comparator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class as implements be {
    int a;
    final int b;
    int c;
    boolean d;
    boolean e;
    final /* synthetic */ at f;

    public as(at atVar) {
        this.f = atVar;
        this.a = 0;
        this.b = atVar.d;
        this.c = 0;
        this.d = atVar.c;
        this.e = false;
    }

    public as(at atVar, int i, int i2, boolean z) {
        this.f = atVar;
        this.c = 0;
        this.a = i;
        this.b = i2;
        this.d = z;
        this.e = true;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.be
    /* JADX INFO: renamed from: aL */
    public final /* bridge */ /* synthetic */ be trySplit() {
        throw null;
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final as trySplit() {
        int i;
        int i2 = this.b;
        int i3 = this.a;
        if (i3 >= i2 - 1 || (i = (i2 - i3) >> 1) <= 1) {
            return null;
        }
        int i4 = i + i3;
        as asVar = new as(this.f, i3, i4, this.d);
        this.a = i4;
        this.d = false;
        this.e = true;
        return asVar;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.e ? 257 : 321;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.be
    public final /* synthetic */ z d() {
        return bd.d();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        if (!this.e) {
            return this.f.g - this.c;
        }
        at atVar = this.f;
        return Math.min(atVar.g - this.c, ((long) ((((double) atVar.l()) / ((double) this.f.d)) * ((double) (this.b - this.a)))) + (this.d ? 1L : 0L));
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        at atVar = this.f;
        ai aiVar = (ai) obj;
        byte[] bArr = atVar.a;
        if (this.d) {
            this.d = false;
            aiVar.c(bArr[atVar.d]);
            this.c++;
        }
        while (true) {
            int i = this.a;
            if (i >= this.b) {
                return;
            }
            byte b = bArr[i];
            if (b != 0) {
                aiVar.c(b);
                this.c++;
            }
            this.a++;
        }
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        bd.b(this, consumer);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return d();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        ai aiVar = (ai) obj;
        if (this.d) {
            this.d = false;
            this.c++;
            at atVar = this.f;
            aiVar.c(atVar.a[atVar.d]);
        } else {
            byte[] bArr = this.f.a;
            while (true) {
                int i = this.a;
                if (i >= this.b) {
                    return false;
                }
                int i2 = i + 1;
                byte b = bArr[i];
                if (b != 0) {
                    this.c++;
                    this.a = i2;
                    aiVar.c(b);
                } else {
                    this.a = i2;
                }
            }
        }
        return true;
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return bd.c(this, consumer);
    }
}
