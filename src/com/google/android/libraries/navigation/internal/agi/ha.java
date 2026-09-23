package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ha implements gi {
    int a;
    int b = -1;
    int c;
    boolean d;
    fz e;
    final /* synthetic */ hc f;

    public ha(hc hcVar) {
        this.f = hcVar;
        this.a = hcVar.d;
        this.c = hcVar.g;
        this.d = hcVar.c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c != 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i;
        Object obj;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.c--;
        if (this.d) {
            this.d = false;
            hc hcVar = this.f;
            int i2 = hcVar.d;
            this.b = i2;
            return hcVar.a[i2];
        }
        Object[] objArr = this.f.a;
        do {
            i = this.a - 1;
            this.a = i;
            if (i < 0) {
                this.b = Integer.MIN_VALUE;
                return this.e.get((-i) - 1);
            }
            obj = objArr[i];
        } while (obj == null);
        this.b = i;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        Object obj;
        int i = this.b;
        if (i == -1) {
            throw new IllegalStateException();
        }
        hc hcVar = this.f;
        int i2 = hcVar.d;
        if (i == i2) {
            hcVar.c = false;
            hcVar.a[i2] = null;
        } else {
            int i3 = this.a;
            if (i3 < 0) {
                hcVar.remove(this.e.set((-i3) - 1, null));
                this.b = -1;
                return;
            }
            Object[] objArr = hcVar.a;
            loop0: while (true) {
                int i4 = this.f.b & (i + 1);
                while (true) {
                    obj = objArr[i4];
                    if (obj != null) {
                        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode());
                        int i5 = this.f.b;
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
                        this.e = new fz((byte[]) null);
                    }
                    this.e.add(objArr[i4]);
                }
                objArr[i] = obj;
                i = i4;
            }
            objArr[i] = null;
        }
        this.f.g--;
        this.b = -1;
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        hc hcVar = this.f;
        Object[] objArr = hcVar.a;
        if (this.d) {
            this.d = false;
            int i = hcVar.d;
            this.b = i;
            consumer.accept(objArr[i]);
            this.c--;
        }
        while (this.c != 0) {
            int i2 = this.a - 1;
            this.a = i2;
            if (i2 < 0) {
                this.b = Integer.MIN_VALUE;
                consumer.accept(this.e.get((-i2) - 1));
                this.c--;
            } else {
                Object obj = objArr[i2];
                if (obj != null) {
                    this.b = i2;
                    consumer.accept(obj);
                    this.c--;
                }
            }
        }
    }
}
