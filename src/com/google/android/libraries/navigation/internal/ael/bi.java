package com.google.android.libraries.navigation.internal.ael;

import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class bi<MessageType extends bi<MessageType, BuilderType>, BuilderType extends bb<MessageType, BuilderType>> extends c<MessageType, BuilderType> {
    public static final Map al = new ConcurrentHashMap();
    public int am = -1;
    protected eg an = eg.a;

    public static bz A(bz bzVar) {
        int size = bzVar.size();
        return bzVar.e(size + size);
    }

    static Object C(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static void F(Class cls, bi biVar) {
        biVar.E();
        al.put(cls, biVar);
    }

    public static final boolean G(bi biVar, boolean z) {
        byte bByteValue = ((Byte) biVar.aH(1, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zL = di.a.b(biVar).l(biVar);
        if (z) {
            biVar.aH(2, true == zL ? biVar : null);
        }
        return zL;
    }

    public static void I(bi biVar) throws cc {
        if (biVar != null && !biVar.am()) {
            throw new ee().a();
        }
    }

    public static bh J(cy cyVar, cy cyVar2, int i, es esVar, Class cls) {
        return new bh(cyVar, dj.b, cyVar2, new bg(null, i, esVar, true));
    }

    public static bh s(ap apVar) {
        return (bh) apVar;
    }

    public static bh t(cy cyVar, Object obj, cy cyVar2, bn bnVar, int i, es esVar, Class cls) {
        return new bh(cyVar, obj, cyVar2, new bg(bnVar, i, esVar, false));
    }

    public static bi v(bi biVar, byte[] bArr, int i, int i2, ar arVar) throws cc {
        if (i2 == 0) {
            return biVar;
        }
        bi biVarU = biVar.u();
        try {
            dr drVarB = di.a.b(biVarU);
            drVarB.i(biVarU, bArr, i, i + i2, new h(arVar));
            drVarB.f(biVarU);
            return biVarU;
        } catch (cc e) {
            if (e.a) {
                throw new cc(e);
            }
            throw e;
        } catch (ee e2) {
            throw e2.a();
        } catch (IOException e3) {
            if (e3.getCause() instanceof cc) {
                throw ((cc) e3.getCause());
            }
            throw new cc(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public static bq w(bq bqVar) {
        int size = bqVar.size();
        return bqVar.e(size + size);
    }

    public static bt x(bt btVar) {
        int size = btVar.size();
        return btVar.e(size + size);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cy
    public final dg B() {
        return (dg) aH(7, null);
    }

    protected final void D() {
        di.a.b(this).f(this);
        E();
    }

    final void E() {
        this.am &= Integer.MAX_VALUE;
    }

    public final boolean H() {
        return (this.am & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cy
    public final /* synthetic */ cx aG() {
        return (bb) aH(5, null);
    }

    public abstract Object aH(int i, Object obj);

    @Override // com.google.android.libraries.navigation.internal.ael.cy
    public final /* synthetic */ cx aI() {
        bb bbVar = (bb) aH(5, null);
        bbVar.x(this);
        return bbVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cy
    public final void aJ(ai aiVar) throws IOException {
        dr drVarB = di.a.b(this);
        aj ajVar = aiVar.f;
        if (ajVar == null) {
            ajVar = new aj(aiVar);
        }
        drVarB.j(this, ajVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cz
    public final /* synthetic */ cy al() {
        return (bi) aH(6, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cz
    public final boolean am() {
        return G(this, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return di.a.b(this).k(this, (bi) obj);
        }
        return false;
    }

    public final int hashCode() {
        if (H()) {
            return n();
        }
        int i = this.ak;
        if (i != 0) {
            return i;
        }
        int iN = n();
        this.ak = iN;
        return iN;
    }

    public final int n() {
        return di.a.b(this).b(this);
    }

    public final int o(dr drVar) {
        return drVar == null ? di.a.b(this).a(this) : drVar.a(this);
    }

    public final bb q() {
        return (bb) aH(5, null);
    }

    public final bb r(bi biVar) {
        bb bbVarQ = q();
        bbVarQ.x(biVar);
        return bbVarQ;
    }

    public final String toString() {
        String string = super.toString();
        int i = da.a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        da.b(this, sb, 0);
        return sb.toString();
    }

    public final bi u() {
        return (bi) aH(4, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.c
    public final int j(dr drVar) {
        if (H()) {
            int iO = o(drVar);
            if (iO >= 0) {
                return iO;
            }
            throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO, "serialized size must be non-negative, was "));
        }
        int i = this.am & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iO2 = o(drVar);
        if (iO2 < 0) {
            throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO2, "serialized size must be non-negative, was "));
        }
        this.am = (this.am & Integer.MIN_VALUE) | iO2;
        return iO2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cy
    public final int p() {
        int iO;
        if (H()) {
            iO = o(null);
            if (iO < 0) {
                throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO, "serialized size must be non-negative, was "));
            }
        } else {
            iO = this.am & Integer.MAX_VALUE;
            if (iO == Integer.MAX_VALUE) {
                iO = o(null);
                if (iO < 0) {
                    throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO, "serialized size must be non-negative, was "));
                }
                this.am = (this.am & Integer.MIN_VALUE) | iO;
            }
        }
        return iO;
    }
}
