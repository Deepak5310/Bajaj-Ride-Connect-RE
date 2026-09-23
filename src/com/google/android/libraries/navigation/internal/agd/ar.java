package com.google.android.libraries.navigation.internal.agd;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ar implements al {
    int a;
    int b = -1;
    int c;
    boolean d;
    p e;
    final /* synthetic */ at f;

    public ar(at atVar) {
        this.f = atVar;
        this.a = atVar.d;
        this.c = atVar.g;
        this.d = atVar.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.al, com.google.android.libraries.navigation.internal.agd.aq
    public final /* synthetic */ Byte a() {
        return ak.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.al
    public final byte c() {
        int i;
        byte b;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.c--;
        if (this.d) {
            this.d = false;
            at atVar = this.f;
            int i2 = atVar.d;
            this.b = i2;
            return atVar.a[i2];
        }
        byte[] bArr = this.f.a;
        do {
            i = this.a - 1;
            this.a = i;
            if (i < 0) {
                this.b = Integer.MIN_VALUE;
                return this.e.l((-i) - 1);
            }
            b = bArr[i];
        } while (b == 0);
        this.b = i;
        return b;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        ak.d(this, consumer);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c != 0;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return a();
    }

    @Override // java.util.Iterator
    public final void remove() {
        byte b;
        int i = this.b;
        if (i == -1) {
            throw new IllegalStateException();
        }
        at atVar = this.f;
        int i2 = atVar.d;
        if (i == i2) {
            atVar.c = false;
            atVar.a[i2] = 0;
        } else {
            int i3 = this.a;
            if (i3 < 0) {
                atVar.k(this.e.l((-i3) - 1));
                this.b = -1;
                return;
            }
            byte[] bArr = atVar.a;
            loop0: while (true) {
                int i4 = this.f.b & (i + 1);
                while (true) {
                    b = bArr[i4];
                    if (b != 0) {
                        at atVar2 = this.f;
                        int iE = com.google.android.libraries.navigation.internal.agc.e.e(b);
                        int i5 = atVar2.b;
                        int i6 = iE & i5;
                        if (i > i4) {
                            if (i >= i6 && i6 > i4) {
                                break;
                            } else {
                                i4 = (i4 + 1) & i5;
                            }
                        } else if (i >= i6 || i6 > i4) {
                            break;
                        } else {
                            i4 = (i4 + 1) & i5;
                        }
                    } else {
                        break loop0;
                    }
                }
                if (i4 < i) {
                    if (this.e == null) {
                        this.e = new p(null);
                    }
                    this.e.c(bArr[i4]);
                }
                bArr[i] = b;
                i = i4;
            }
            bArr[i] = 0;
        }
        this.f.g--;
        this.b = -1;
    }

    @Override // java.util.PrimitiveIterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void forEachRemaining(ai aiVar) {
        at atVar = this.f;
        byte[] bArr = atVar.a;
        if (this.d) {
            this.d = false;
            int i = atVar.d;
            this.b = i;
            aiVar.c(bArr[i]);
            this.c--;
        }
        while (this.c != 0) {
            int i2 = this.a - 1;
            this.a = i2;
            if (i2 < 0) {
                this.b = Integer.MIN_VALUE;
                aiVar.c(this.e.l((-i2) - 1));
                this.c--;
            } else {
                byte b = bArr[i2];
                if (b != 0) {
                    this.b = i2;
                    aiVar.c(b);
                    this.c--;
                }
            }
        }
    }
}
