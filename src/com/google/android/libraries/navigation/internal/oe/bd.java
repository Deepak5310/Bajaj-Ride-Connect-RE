package com.google.android.libraries.navigation.internal.oe;

import com.adobe.internal.xmp.options.PropertyOptions;
import java.util.Arrays;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bd extends be {
    public ai a;
    public final x b;
    public final x c;
    private int d;
    private int e;
    private int g;
    private volatile x h;
    private volatile x i;
    private volatile x j;
    private volatile x k;
    private volatile x l;
    private volatile x m;

    public bd(ai aiVar) {
        x xVar = new x();
        this.b = xVar;
        x xVar2 = new x();
        this.c = xVar2;
        h(xVar, xVar2, aiVar);
    }

    private final void h(x xVar, x xVar2, ai aiVar) {
        this.a = aiVar;
        x xVar3 = aiVar.a;
        int i = xVar3.a;
        x xVar4 = aiVar.b;
        if (i < 0) {
            this.d = -i;
        } else {
            int i2 = xVar4.a;
            if (i2 > 1073741824) {
                this.d = 1073741824 - i2;
            }
        }
        xVar3.Q(xVar);
        xVar4.Q(xVar2);
        this.f = xVar.a > xVar2.a;
        int i3 = xVar3.a;
        int i4 = this.d;
        this.e = i3 + i4;
        this.g = xVar4.a + i4;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.be
    public final int a() {
        return this.f ? 6 : 4;
    }

    public final void b(ai aiVar) {
        h(this.b, this.c, aiVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.be
    public final x c(int i) {
        if (i == 0) {
            if (this.h == null) {
                this.h = new x(this.c.a, this.b.b);
            }
            return this.h;
        }
        if (i == 1) {
            return this.c;
        }
        if (i != 2) {
            if (i == 3) {
                return this.b;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        if (this.i == null) {
            this.i = new x(this.b.a, this.c.b);
        }
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.be
    public final bd d() {
        return this;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bd)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        bd bdVar = (bd) obj;
        return this.b.equals(bdVar.b) && this.c.equals(bdVar.c) && this.a.equals(bdVar.a);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.be
    public final boolean g(x xVar) {
        int i;
        int i2 = (xVar.a + this.d) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        return i2 >= this.e && i2 <= this.g && (i = xVar.b) >= this.b.b && i <= this.c.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.a});
    }

    @Override // com.google.android.libraries.navigation.internal.oe.be
    public final boolean k(aj ajVar) {
        if (!this.f) {
            return this.a.b(ajVar);
        }
        if (!(ajVar instanceof ai)) {
            return super.k(ajVar);
        }
        x xVar = this.b;
        int i = xVar.b;
        ai aiVar = (ai) ajVar;
        x xVar2 = aiVar.b;
        if (i > xVar2.b) {
            return false;
        }
        x xVar3 = this.c;
        int i2 = xVar3.b;
        x xVar4 = aiVar.a;
        if (i2 < xVar4.b) {
            return false;
        }
        int i3 = xVar.a;
        int i4 = xVar2.a;
        return (i3 <= i4 && xVar4.a < 536870912) || (i4 >= -536870912 && xVar3.a >= xVar4.a);
    }

    public final String toString() {
        x xVar = this.c;
        return "[" + this.b.toString() + "," + xVar.toString() + "]";
    }

    @Override // com.google.android.libraries.navigation.internal.oe.be
    public final void e(int i, x[] xVarArr) {
        if (!this.f) {
            xVarArr[0] = c(i);
            xVarArr[1] = c((i + 1) % 4);
            return;
        }
        if (i == 0) {
            xVarArr[0] = c(0);
            xVarArr[1] = c(1);
            return;
        }
        if (i == 1) {
            xVarArr[0] = c(1);
            if (this.j == null) {
                this.j = new x(-536870913, this.c.b);
            }
            xVarArr[1] = this.j;
            return;
        }
        if (i == 2) {
            if (this.k == null) {
                this.k = new x(PropertyOptions.DELETE_EXISTING, this.c.b);
            }
            xVarArr[0] = this.k;
            xVarArr[1] = c(2);
            return;
        }
        if (i == 3) {
            xVarArr[0] = c(2);
            xVarArr[1] = c(3);
            return;
        }
        if (i == 4) {
            xVarArr[0] = c(3);
            if (this.l == null) {
                this.l = new x(PropertyOptions.DELETE_EXISTING, this.b.b);
            }
            xVarArr[1] = this.l;
            return;
        }
        if (i != 5) {
            return;
        }
        if (this.m == null) {
            this.m = new x(-536870913, this.b.b);
        }
        xVarArr[0] = this.m;
        xVarArr[1] = c(0);
    }
}
