package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hb implements gs {
    int a;
    int b = -1;
    int c;
    boolean d;
    fv e;
    final /* synthetic */ hd f;

    public hb(hd hdVar) {
        this.f = hdVar;
        this.a = hdVar.d;
        this.c = hdVar.g;
        this.d = hdVar.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        gr.c(this, consumer);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c != 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ Long next() {
        return gr.a(this);
    }

    @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final long nextLong() {
        int i;
        long j;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.c--;
        if (this.d) {
            this.d = false;
            hd hdVar = this.f;
            int i2 = hdVar.d;
            this.b = i2;
            return hdVar.a[i2];
        }
        long[] jArr = this.f.a;
        do {
            i = this.a - 1;
            this.a = i;
            if (i < 0) {
                this.b = Integer.MIN_VALUE;
                return this.e.m((-i) - 1);
            }
            j = jArr[i];
        } while (j == 0);
        this.b = i;
        return j;
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        long j;
        int i2 = this.b;
        if (i2 == -1) {
            throw new IllegalStateException();
        }
        hd hdVar = this.f;
        int i3 = hdVar.d;
        if (i2 == i3) {
            hdVar.c = false;
            hdVar.a[i3] = 0;
        } else {
            int i4 = this.a;
            if (i4 < 0) {
                hdVar.l(this.e.m((-i4) - 1));
                this.b = -1;
                return;
            }
            long[] jArr = hdVar.a;
            loop0: while (true) {
                int i5 = i2 + 1;
                int i6 = this.f.b;
                while (true) {
                    i = i6 & i5;
                    j = jArr[i];
                    if (j != 0) {
                        hd hdVar2 = this.f;
                        int iG = (int) com.google.android.libraries.navigation.internal.agc.e.g(j);
                        i5 = hdVar2.b;
                        int i7 = iG & i5;
                        if (i2 > i) {
                            if (i2 >= i7 && i7 > i) {
                                break;
                            } else {
                                i6 = i + 1;
                            }
                        } else if (i2 >= i7 || i7 > i) {
                            break;
                        } else {
                            i6 = i + 1;
                        }
                    } else {
                        break loop0;
                    }
                }
                if (i < i2) {
                    if (this.e == null) {
                        this.e = new fv(2);
                    }
                    this.e.c(jArr[i]);
                }
                jArr[i2] = j;
                i2 = i;
            }
            jArr[i2] = 0;
        }
        this.f.g--;
        this.b = -1;
    }

    @Override // java.util.PrimitiveIterator
    public final void forEachRemaining(LongConsumer longConsumer) {
        hd hdVar = this.f;
        long[] jArr = hdVar.a;
        if (this.d) {
            this.d = false;
            int i = hdVar.d;
            this.b = i;
            longConsumer.accept(jArr[i]);
            this.c--;
        }
        while (this.c != 0) {
            int i2 = this.a - 1;
            this.a = i2;
            if (i2 < 0) {
                this.b = Integer.MIN_VALUE;
                longConsumer.accept(this.e.m((-i2) - 1));
                this.c--;
            } else {
                long j = jArr[i2];
                if (j != 0) {
                    this.b = i2;
                    longConsumer.accept(j);
                    this.c--;
                }
            }
        }
    }
}
