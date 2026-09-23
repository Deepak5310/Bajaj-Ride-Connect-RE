package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av {
    public static final av a = new av(null);
    final dy b = new du();
    public boolean c;
    public boolean d;

    private av() {
    }

    static int a(es esVar, int i, Object obj) {
        int iU = ai.U(i);
        if (esVar == es.GROUP) {
            ca.d((cy) obj);
            iU += iU;
        }
        et etVar = et.INT;
        int iY = 4;
        switch (esVar) {
            case DOUBLE:
                iY = 8;
                return iU + iY;
            case FLOAT:
                return iU + iY;
            case INT64:
                iY = ai.Y(((Long) obj).longValue());
                return iU + iY;
            case UINT64:
                iY = ai.Y(((Long) obj).longValue());
                return iU + iY;
            case INT32:
                iY = ai.G(((Integer) obj).intValue());
                return iU + iY;
            case FIXED64:
                iY = 8;
                return iU + iY;
            case FIXED32:
                return iU + iY;
            case BOOL:
                ((Boolean) obj).booleanValue();
                iY = 1;
                return iU + iY;
            case STRING:
                iY = obj instanceof x ? ai.C((x) obj) : ai.T((String) obj);
                return iU + iY;
            case GROUP:
                iY = ((cy) obj).p();
                return iU + iY;
            case MESSAGE:
                iY = obj instanceof ch ? ai.J((ch) obj) : ai.L((cy) obj);
                return iU + iY;
            case BYTES:
                iY = obj instanceof x ? ai.C((x) obj) : ai.K(((byte[]) obj).length);
                return iU + iY;
            case UINT32:
                iY = ai.W(((Integer) obj).intValue());
                return iU + iY;
            case ENUM:
                iY = obj instanceof bm ? ai.G(((bm) obj).a()) : ai.G(((Integer) obj).intValue());
                return iU + iY;
            case SFIXED32:
                return iU + iY;
            case SFIXED64:
                iY = 8;
                return iU + iY;
            case SINT32:
                iY = ai.P(((Integer) obj).intValue());
                return iU + iY;
            case SINT64:
                iY = ai.R(((Long) obj).longValue());
                return iU + iY;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    static void g(ai aiVar, es esVar, int i, Object obj) throws IOException {
        if (esVar == es.GROUP) {
            cy cyVar = (cy) obj;
            ca.d(cyVar);
            aiVar.u(i, 3);
            aiVar.ai(cyVar);
            aiVar.u(i, 4);
            return;
        }
        aiVar.u(i, esVar.t);
        et etVar = et.INT;
        switch (esVar) {
            case DOUBLE:
                aiVar.af(((Double) obj).doubleValue());
                break;
            case FLOAT:
                aiVar.ah(((Float) obj).floatValue());
                break;
            case INT64:
                aiVar.y(((Long) obj).longValue());
                break;
            case UINT64:
                aiVar.y(((Long) obj).longValue());
                break;
            case INT32:
                aiVar.n(((Integer) obj).intValue());
                break;
            case FIXED64:
                aiVar.l(((Long) obj).longValue());
                break;
            case FIXED32:
                aiVar.j(((Integer) obj).intValue());
                break;
            case BOOL:
                aiVar.ax(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case STRING:
                if (!(obj instanceof x)) {
                    aiVar.t((String) obj);
                } else {
                    aiVar.aA((x) obj);
                }
                break;
            case GROUP:
                aiVar.ai((cy) obj);
                break;
            case MESSAGE:
                aiVar.p((cy) obj);
                break;
            case BYTES:
                if (!(obj instanceof x)) {
                    byte[] bArr = (byte[]) obj;
                    aiVar.z(bArr, bArr.length);
                } else {
                    aiVar.aA((x) obj);
                }
                break;
            case UINT32:
                aiVar.w(((Integer) obj).intValue());
                break;
            case ENUM:
                if (!(obj instanceof bm)) {
                    aiVar.n(((Integer) obj).intValue());
                } else {
                    aiVar.n(((bm) obj).a());
                }
                break;
            case SFIXED32:
                aiVar.j(((Integer) obj).intValue());
                break;
            case SFIXED64:
                aiVar.l(((Long) obj).longValue());
                break;
            case SINT32:
                aiVar.ak(((Integer) obj).intValue());
                break;
            case SINT64:
                aiVar.am(((Long) obj).longValue());
                break;
        }
    }

    public static int j(bg bgVar, Object obj) {
        es esVarB = bgVar.b();
        int iA = bgVar.a();
        if (!bgVar.d()) {
            return a(esVarB, iA, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int iA2 = 0;
        for (int i = 0; i < size; i++) {
            iA2 += a(esVarB, iA, list.get(i));
        }
        return iA2;
    }

    private static Object o(Object obj) {
        if (obj instanceof dd) {
            return ((dd) obj).e();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private static boolean p(Map.Entry entry) {
        bg bgVar = (bg) entry.getKey();
        if (bgVar.c() != et.MESSAGE) {
            return true;
        }
        if (!bgVar.d()) {
            return q(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!q(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean q(Object obj) {
        if (obj instanceof cz) {
            return ((cz) obj).am();
        }
        if (obj instanceof ch) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void r(bg bgVar, Object obj) {
        boolean z;
        bgVar.b();
        ca.e(obj);
        es esVar = es.DOUBLE;
        et etVar = et.INT;
        switch (r0.s) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bgVar.a()), bgVar.b().s, obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bgVar.a()), bgVar.b().s, obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bgVar.a()), bgVar.b().s, obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bgVar.a()), bgVar.b().s, obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bgVar.a()), bgVar.b().s, obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bgVar.a()), bgVar.b().s, obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof x) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bgVar.a()), bgVar.b().s, obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof bm)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bgVar.a()), bgVar.b().s, obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof cy) || (obj instanceof ch)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bgVar.a()), bgVar.b().s, obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bgVar.a()), bgVar.b().s, obj.getClass().getName()));
        }
    }

    public final int b(Map.Entry entry) {
        int iV;
        int iU;
        bg bgVar = (bg) entry.getKey();
        Object value = entry.getValue();
        if (bgVar.c() != et.MESSAGE || bgVar.d()) {
            return j(bgVar, value);
        }
        if (value instanceof ch) {
            int iA = ((bg) entry.getKey()).a();
            int iU2 = ai.U(1);
            iV = iU2 + iU2 + ai.V(2, iA);
            iU = ai.I(3, (ch) value);
        } else {
            int iA2 = ((bg) entry.getKey()).a();
            int iU3 = ai.U(1);
            iV = iU3 + iU3 + ai.V(2, iA2);
            iU = ai.U(3) + ai.L((cy) value);
        }
        return iV + iU;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final av clone() {
        av avVar = new av();
        int i = this.b.b;
        for (int i2 = 0; i2 < i; i2++) {
            dv dvVar = (dv) this.b.d(i2);
            avVar.m((bg) dvVar.a, dvVar.b);
        }
        for (Map.Entry entry : this.b.a()) {
            avVar.m((bg) entry.getKey(), entry.getValue());
        }
        avVar.d = this.d;
        return avVar;
    }

    public final Iterator d() {
        if (h()) {
            return Collections.emptyIterator();
        }
        return this.d ? new cg(this.b.entrySet().iterator()) : this.b.entrySet().iterator();
    }

    public final void e() {
        if (this.c) {
            return;
        }
        int i = this.b.b;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = ((dv) this.b.d(i2)).b;
            if (obj instanceof bi) {
                ((bi) obj).D();
            }
        }
        Iterator it2 = this.b.a().iterator();
        while (it2.hasNext()) {
            Object value = ((Map.Entry) it2.next()).getValue();
            if (value instanceof bi) {
                ((bi) value).D();
            }
        }
        dy dyVar = this.b;
        if (!dyVar.d) {
            for (int i3 = 0; i3 < dyVar.b; i3++) {
                Map.Entry entryD = dyVar.d(i3);
                dv dvVar = (dv) entryD;
                if (((bg) dvVar.a).d()) {
                    entryD.setValue(Collections.unmodifiableList((List) dvVar.b));
                }
            }
            for (Map.Entry entry : dyVar.a()) {
                if (((bg) entry.getKey()).d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        if (!dyVar.d) {
            dyVar.c = dyVar.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(dyVar.c);
            dyVar.e = dyVar.e.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(dyVar.e);
            dyVar.d = true;
        }
        this.c = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof av) {
            return this.b.equals(((av) obj).b);
        }
        return false;
    }

    public final void f(Map.Entry entry) {
        cy cyVarT;
        bg bgVar = (bg) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof ch;
        if (bgVar.d()) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object objK = k(bgVar);
            List list = (List) value;
            int size = list.size();
            if (objK == null) {
                objK = new ArrayList(size);
            }
            List list2 = (List) objK;
            for (int i = 0; i < size; i++) {
                list2.add(o(list.get(i)));
            }
            this.b.put(bgVar, objK);
            return;
        }
        if (bgVar.c() != et.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.b.put(bgVar, o(value));
            return;
        }
        Object objK2 = k(bgVar);
        if (objK2 == null) {
            this.b.put(bgVar, o(value));
            if (z) {
                this.d = true;
                return;
            }
            return;
        }
        if (z) {
            throw null;
        }
        if (objK2 instanceof dd) {
            cyVarT = bg.f();
        } else {
            cyVarT = bg.e(((cy) objK2).aI(), (cy) value).t();
        }
        this.b.put(bgVar, cyVarT);
    }

    final boolean h() {
        return this.b.isEmpty();
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final boolean i() {
        int i = this.b.b;
        for (int i2 = 0; i2 < i; i2++) {
            if (!p(this.b.d(i2))) {
                return false;
            }
        }
        Iterator it2 = this.b.a().iterator();
        while (it2.hasNext()) {
            if (!p((Map.Entry) it2.next())) {
                return false;
            }
        }
        return true;
    }

    public final Object k(bg bgVar) {
        Object obj = this.b.get(bgVar);
        if (!(obj instanceof ch)) {
            return obj;
        }
        throw null;
    }

    public final void l(bg bgVar, Object obj) {
        List arrayList;
        if (!bgVar.d) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        r(bgVar, obj);
        Object objK = k(bgVar);
        if (objK == null) {
            arrayList = new ArrayList();
            this.b.put(bgVar, arrayList);
        } else {
            arrayList = (List) objK;
        }
        arrayList.add(obj);
    }

    public final void m(bg bgVar, Object obj) {
        if (!bgVar.d()) {
            r(bgVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                r(bgVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof ch) {
            this.d = true;
        }
        this.b.put(bgVar, obj);
    }

    public final boolean n(bg bgVar) {
        if (bgVar.d) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.b.get(bgVar) != null;
    }

    private av(byte[] bArr) {
        e();
        e();
    }
}
