package com.google.android.libraries.navigation.internal.ael;

import com.adobe.internal.xmp.options.PropertyOptions;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.CharCompanionObject;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class db<T> implements dr<T> {
    private static final int[] a = new int[0];
    private static final Unsafe b = em.l();
    private final int[] c;
    private final Object[] d;
    private final int e;
    private final int f;
    private final cy g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int[] k;
    private final int l;
    private final int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ef f244n;
    private final as o;
    private final de p;
    private final ck q;
    private final ct r;

    private db(int[] iArr, Object[] objArr, int i, int i2, cy cyVar, boolean z, int[] iArr2, int i3, int i4, de deVar, ck ckVar, ef efVar, as asVar, ct ctVar) {
        this.c = iArr;
        this.d = objArr;
        this.e = i;
        this.f = i2;
        this.i = cyVar instanceof bi;
        this.h = asVar != null && asVar.j(cyVar);
        this.j = false;
        this.k = iArr2;
        this.l = i3;
        this.m = i4;
        this.p = deVar;
        this.q = ckVar;
        this.f244n = efVar;
        this.o = asVar;
        this.g = cyVar;
        this.r = ctVar;
    }

    private final Object A(Object obj, int i, Object obj2, ef efVar, Object obj3) {
        bo boVarY;
        int iP = p(i);
        Object objJ = em.j(obj, w(v(i)));
        if (objJ == null || (boVarY = y(i)) == null) {
            return obj2;
        }
        Map mapC = ct.c(objJ);
        cq cqVarB = ct.b(B(i));
        Iterator it2 = mapC.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            if (!boVarY.a(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = efVar.c(obj3);
                }
                int iA = cr.a(cqVarB, entry.getKey(), entry.getValue());
                x xVar = x.b;
                t tVar = new t(iA);
                try {
                    cr.b(tVar.a, cqVarB, entry.getKey(), entry.getValue());
                    efVar.k(obj2, iP, tVar.a());
                    it2.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    private final Object B(int i) {
        int i2 = i / 3;
        return this.d[i2 + i2];
    }

    private final Object C(Object obj, int i) {
        dr drVarZ = z(i);
        long jW = w(v(i));
        if (!Q(obj, i)) {
            return drVarZ.e();
        }
        Object object = b.getObject(obj, jW);
        if (T(object)) {
            return object;
        }
        Object objE = drVarZ.e();
        if (object != null) {
            drVarZ.g(objE, object);
        }
        return objE;
    }

    private final Object D(Object obj, int i, int i2) {
        dr drVarZ = z(i2);
        if (!U(obj, i, i2)) {
            return drVarZ.e();
        }
        Object object = b.getObject(obj, w(v(i2)));
        if (T(object)) {
            return object;
        }
        Object objE = drVarZ.e();
        if (object != null) {
            drVarZ.g(objE, object);
        }
        return objE;
    }

    private static Field E(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void F(Object obj) {
        if (!T(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void G(Object obj, Object obj2, int i) {
        if (Q(obj2, i)) {
            long jW = w(v(i));
            Unsafe unsafe = b;
            Object object = unsafe.getObject(obj2, jW);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + p(i) + " is present but null: " + obj2.toString());
            }
            dr drVarZ = z(i);
            if (!Q(obj, i)) {
                if (T(object)) {
                    Object objE = drVarZ.e();
                    drVarZ.g(objE, object);
                    unsafe.putObject(obj, jW, objE);
                } else {
                    unsafe.putObject(obj, jW, object);
                }
                J(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jW);
            if (!T(object2)) {
                Object objE2 = drVarZ.e();
                drVarZ.g(objE2, object2);
                unsafe.putObject(obj, jW, objE2);
                object2 = objE2;
            }
            drVarZ.g(object2, object);
        }
    }

    private final void H(Object obj, Object obj2, int i) {
        int iP = p(i);
        if (U(obj2, iP, i)) {
            long jW = w(v(i));
            Unsafe unsafe = b;
            Object object = unsafe.getObject(obj2, jW);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + p(i) + " is present but null: " + obj2.toString());
            }
            dr drVarZ = z(i);
            if (!U(obj, iP, i)) {
                if (T(object)) {
                    Object objE = drVarZ.e();
                    drVarZ.g(objE, object);
                    unsafe.putObject(obj, jW, objE);
                } else {
                    unsafe.putObject(obj, jW, object);
                }
                K(obj, iP, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jW);
            if (!T(object2)) {
                Object objE2 = drVarZ.e();
                drVarZ.g(objE2, object2);
                unsafe.putObject(obj, jW, objE2);
                object2 = objE2;
            }
            drVarZ.g(object2, object);
        }
    }

    private final void I(Object obj, int i, dl dlVar) throws IOException {
        if (P(i)) {
            em.w(obj, w(i), dlVar.v());
        } else if (this.i) {
            em.w(obj, w(i), dlVar.u());
        } else {
            em.w(obj, w(i), dlVar.o());
        }
    }

    private final void J(Object obj, int i) {
        int iS = s(i);
        long j = 1048575 & iS;
        if (j == 1048575) {
            return;
        }
        em.u(obj, j, (1 << (iS >>> 20)) | em.f(obj, j));
    }

    private final void K(Object obj, int i, int i2) {
        em.u(obj, s(i2) & 1048575, i);
    }

    private final void L(Object obj, int i, Object obj2) {
        b.putObject(obj, w(v(i)), obj2);
        J(obj, i);
    }

    private final void M(Object obj, int i, int i2, Object obj2) {
        b.putObject(obj, w(v(i2)), obj2);
        K(obj, i, i2);
    }

    private final void N(ev evVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            cq cqVarB = ct.b(B(i2));
            Map mapA = ct.a(obj);
            aj ajVar = (aj) evVar;
            ai aiVar = ajVar.a;
            for (Map.Entry entry : mapA.entrySet()) {
                ajVar.a.u(i, 2);
                ajVar.a.w(cr.a(cqVarB, entry.getKey(), entry.getValue()));
                cr.b(ajVar.a, cqVarB, entry.getKey(), entry.getValue());
            }
        }
    }

    private final boolean O(Object obj, Object obj2, int i) {
        return Q(obj, i) == Q(obj2, i);
    }

    private static boolean P(int i) {
        return (i & PropertyOptions.DELETE_EXISTING) != 0;
    }

    private final boolean Q(Object obj, int i) {
        int iS = s(i);
        long j = 1048575 & iS;
        if (j != 1048575) {
            return (em.f(obj, j) & (1 << (iS >>> 20))) != 0;
        }
        int iV = v(i);
        long jW = w(iV);
        switch (u(iV)) {
            case 0:
                return Double.doubleToRawLongBits(em.d(obj, jW)) != 0;
            case 1:
                return Float.floatToRawIntBits(em.e(obj, jW)) != 0;
            case 2:
                return em.h(obj, jW) != 0;
            case 3:
                return em.h(obj, jW) != 0;
            case 4:
                return em.f(obj, jW) != 0;
            case 5:
                return em.h(obj, jW) != 0;
            case 6:
                return em.f(obj, jW) != 0;
            case 7:
                return em.y(obj, jW);
            case 8:
                Object objJ = em.j(obj, jW);
                if (objJ instanceof String) {
                    return !((String) objJ).isEmpty();
                }
                if (objJ instanceof x) {
                    return !x.b.equals(objJ);
                }
                throw new IllegalArgumentException();
            case 9:
                return em.j(obj, jW) != null;
            case 10:
                return !x.b.equals(em.j(obj, jW));
            case 11:
                return em.f(obj, jW) != 0;
            case 12:
                return em.f(obj, jW) != 0;
            case 13:
                return em.f(obj, jW) != 0;
            case 14:
                return em.h(obj, jW) != 0;
            case 15:
                return em.f(obj, jW) != 0;
            case 16:
                return em.h(obj, jW) != 0;
            case 17:
                return em.j(obj, jW) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean R(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return Q(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean S(Object obj, int i, dr drVar) {
        return drVar.l(em.j(obj, w(i)));
    }

    private static boolean T(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof bi) {
            return ((bi) obj).H();
        }
        return true;
    }

    private final boolean U(Object obj, int i, int i2) {
        return em.f(obj, (long) (s(i2) & 1048575)) == i;
    }

    private static boolean V(Object obj, long j) {
        return ((Boolean) em.j(obj, j)).booleanValue();
    }

    private static final int W(byte[] bArr, int i, int i2, es esVar, Class cls, h hVar) throws IOException {
        int i3;
        es esVar2 = es.DOUBLE;
        switch (esVar) {
            case DOUBLE:
                i3 = i + 8;
                hVar.c = Double.valueOf(i.a(bArr, i));
                break;
            case FLOAT:
                i3 = i + 4;
                hVar.c = Float.valueOf(i.b(bArr, i));
                break;
            case INT64:
            case UINT64:
                int iP = i.p(bArr, i, hVar);
                hVar.c = Long.valueOf(hVar.b);
                return iP;
            case INT32:
            case UINT32:
            case ENUM:
                int iM = i.m(bArr, i, hVar);
                hVar.c = Integer.valueOf(hVar.a);
                return iM;
            case FIXED64:
            case SFIXED64:
                i3 = i + 8;
                hVar.c = Long.valueOf(i.t(bArr, i));
                break;
            case FIXED32:
            case SFIXED32:
                i3 = i + 4;
                hVar.c = Integer.valueOf(i.e(bArr, i));
                break;
            case BOOL:
                int iP2 = i.p(bArr, i, hVar);
                hVar.c = Boolean.valueOf(hVar.b != 0);
                return iP2;
            case STRING:
                return i.k(bArr, i, hVar);
            case GROUP:
            default:
                throw new RuntimeException("unsupported field type.");
            case MESSAGE:
                return i.g(di.a.a(cls), bArr, i, i2, hVar);
            case BYTES:
                return i.c(bArr, i, hVar);
            case SINT32:
                int iM2 = i.m(bArr, i, hVar);
                hVar.c = Integer.valueOf(ac.H(hVar.a));
                return iM2;
            case SINT64:
                int iP3 = i.p(bArr, i, hVar);
                hVar.c = Long.valueOf(ac.I(hVar.b));
                return iP3;
        }
        return i3;
    }

    private static final void X(int i, Object obj, ev evVar) throws IOException {
        if (obj instanceof String) {
            evVar.s(i, (String) obj);
        } else {
            evVar.b(i, (x) obj);
        }
    }

    private static final void Y(ef efVar, Object obj, ev evVar) throws IOException {
        efVar.q(efVar.d(obj), evVar);
    }

    static eg d(Object obj) {
        bi biVar = (bi) obj;
        eg egVar = biVar.an;
        if (egVar != eg.a) {
            return egVar;
        }
        eg egVar2 = new eg();
        biVar.an = egVar2;
        return egVar2;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0261  */
    /* JADX WARN: Code duplicated, block: B:125:0x0264  */
    /* JADX WARN: Code duplicated, block: B:128:0x027b  */
    /* JADX WARN: Code duplicated, block: B:129:0x027e  */
    /* JADX WARN: Code duplicated, block: B:166:0x033f  */
    /* JADX WARN: Code duplicated, block: B:180:0x038e  */
    /* JADX WARN: Code duplicated, block: B:183:0x0395  */
    static db m(cv cvVar, de deVar, ck ckVar, ef efVar, as asVar, ct ctVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldE;
        int i22;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Object obj;
        Field fieldE2;
        int i28;
        Object obj2;
        Field fieldE3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        if (!(cvVar instanceof dk)) {
            throw null;
        }
        dk dkVar = (dk) cvVar;
        String str = dkVar.b;
        int length = str.length();
        char c = 55296;
        if (str.charAt(0) >= 55296) {
            int i33 = 1;
            while (true) {
                i = i33 + 1;
                if (str.charAt(i33) < 55296) {
                    break;
                }
                i33 = i;
            }
        } else {
            i = 1;
        }
        int i34 = i + 1;
        int iCharAt3 = str.charAt(i);
        if (iCharAt3 >= 55296) {
            int i35 = iCharAt3 & 8191;
            int i36 = 13;
            while (true) {
                i32 = i34 + 1;
                cCharAt13 = str.charAt(i34);
                if (cCharAt13 < 55296) {
                    break;
                }
                i35 |= (cCharAt13 & 8191) << i36;
                i36 += 13;
                i34 = i32;
            }
            iCharAt3 = i35 | (cCharAt13 << i36);
            i34 = i32;
        }
        if (iCharAt3 == 0) {
            i4 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i2 = 0;
            i5 = 0;
            i3 = 0;
            iArr = a;
            i6 = 0;
        } else {
            int i37 = i34 + 1;
            int iCharAt4 = str.charAt(i34);
            if (iCharAt4 >= 55296) {
                int i38 = iCharAt4 & 8191;
                int i39 = 13;
                while (true) {
                    i14 = i37 + 1;
                    cCharAt8 = str.charAt(i37);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt8 & 8191) << i39;
                    i39 += 13;
                    i37 = i14;
                }
                iCharAt4 = i38 | (cCharAt8 << i39);
                i37 = i14;
            }
            int i40 = i37 + 1;
            int iCharAt5 = str.charAt(i37);
            if (iCharAt5 >= 55296) {
                int i41 = iCharAt5 & 8191;
                int i42 = 13;
                while (true) {
                    i13 = i40 + 1;
                    cCharAt7 = str.charAt(i40);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt7 & 8191) << i42;
                    i42 += 13;
                    i40 = i13;
                }
                iCharAt5 = i41 | (cCharAt7 << i42);
                i40 = i13;
            }
            int i43 = i40 + 1;
            int iCharAt6 = str.charAt(i40);
            if (iCharAt6 >= 55296) {
                int i44 = iCharAt6 & 8191;
                int i45 = 13;
                while (true) {
                    i12 = i43 + 1;
                    cCharAt6 = str.charAt(i43);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt6 & 8191) << i45;
                    i45 += 13;
                    i43 = i12;
                }
                iCharAt6 = i44 | (cCharAt6 << i45);
                i43 = i12;
            }
            int i46 = i43 + 1;
            int iCharAt7 = str.charAt(i43);
            if (iCharAt7 >= 55296) {
                int i47 = iCharAt7 & 8191;
                int i48 = 13;
                while (true) {
                    i11 = i46 + 1;
                    cCharAt5 = str.charAt(i46);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt5 & 8191) << i48;
                    i48 += 13;
                    i46 = i11;
                }
                iCharAt7 = i47 | (cCharAt5 << i48);
                i46 = i11;
            }
            int i49 = i46 + 1;
            iCharAt = str.charAt(i46);
            if (iCharAt >= 55296) {
                int i50 = iCharAt & 8191;
                int i51 = 13;
                while (true) {
                    i10 = i49 + 1;
                    cCharAt4 = str.charAt(i49);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt4 & 8191) << i51;
                    i51 += 13;
                    i49 = i10;
                }
                iCharAt = i50 | (cCharAt4 << i51);
                i49 = i10;
            }
            int i52 = i49 + 1;
            iCharAt2 = str.charAt(i49);
            if (iCharAt2 >= 55296) {
                int i53 = iCharAt2 & 8191;
                int i54 = 13;
                while (true) {
                    i9 = i52 + 1;
                    cCharAt3 = str.charAt(i52);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt3 & 8191) << i54;
                    i54 += 13;
                    i52 = i9;
                }
                iCharAt2 = i53 | (cCharAt3 << i54);
                i52 = i9;
            }
            int i55 = i52 + 1;
            int iCharAt8 = str.charAt(i52);
            if (iCharAt8 >= 55296) {
                int i56 = iCharAt8 & 8191;
                int i57 = 13;
                while (true) {
                    i8 = i55 + 1;
                    cCharAt2 = str.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i55 = i8;
                }
                iCharAt8 = i56 | (cCharAt2 << i57);
                i55 = i8;
            }
            int i58 = i55 + 1;
            int iCharAt9 = str.charAt(i55);
            if (iCharAt9 >= 55296) {
                int i59 = iCharAt9 & 8191;
                int i60 = 13;
                while (true) {
                    i7 = i58 + 1;
                    cCharAt = str.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i7;
                }
                iCharAt9 = i59 | (cCharAt << i60);
                i58 = i7;
            }
            int i61 = iCharAt4 + iCharAt4 + iCharAt5;
            int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i2 = iCharAt6;
            i3 = iCharAt9;
            i4 = i61;
            iArr = iArr2;
            i5 = iCharAt7;
            i6 = iCharAt4;
            i34 = i58;
        }
        Object[] objArr = dkVar.c;
        cy cyVar = dkVar.a;
        Unsafe unsafe = b;
        Class<?> cls = cyVar.getClass();
        int i62 = i3 + iCharAt2;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr2 = new Object[i63];
        int i64 = i3;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i34 < length) {
            int i68 = i34 + 1;
            int iCharAt10 = str.charAt(i34);
            if (iCharAt10 >= c) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i31 = i70 + 1;
                    cCharAt12 = str.charAt(i70);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i31;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i15 = i31;
            } else {
                i15 = i68;
            }
            int i72 = i15 + 1;
            int iCharAt11 = str.charAt(i15);
            if (iCharAt11 >= c) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i30 = i74 + 1;
                    cCharAt11 = str.charAt(i74);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i30;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i16 = i30;
            } else {
                i16 = i72;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i67] = i66;
                i67++;
            }
            int i76 = iCharAt11 & 255;
            int i77 = length;
            if (i76 >= 51) {
                int i78 = i16 + 1;
                int iCharAt12 = str.charAt(i16);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i79 = 13;
                    int i80 = iCharAt12 & 8191;
                    int i81 = i78;
                    while (true) {
                        i29 = i81 + 1;
                        cCharAt10 = str.charAt(i81);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i80 |= (cCharAt10 & 8191) << i79;
                        i79 += 13;
                        i81 = i29;
                        c2 = 55296;
                    }
                    iCharAt12 = i80 | (cCharAt10 << i79);
                    i25 = i29;
                } else {
                    i25 = i78;
                }
                int i82 = i25;
                int i83 = i76 - 51;
                if (i83 == 9 || i83 == 17) {
                    i17 = i2;
                    i26 = i4 + 1;
                    int i84 = i66 / 3;
                    objArr2[i84 + i84 + 1] = objArr[i4];
                } else {
                    if (i83 == 12) {
                        int i85 = iCharAt11 & 2048;
                        i17 = i2;
                        if (dkVar.c() == 1 || i85 != 0) {
                            i26 = i4 + 1;
                            int i86 = i66 / 3;
                            objArr2[i86 + i86 + 1] = objArr[i4];
                        }
                    } else {
                        i17 = i2;
                    }
                    int i87 = iCharAt11 & 2048;
                    i27 = iCharAt12 + iCharAt12;
                    obj = objArr[i27];
                    if (obj instanceof Field) {
                        fieldE2 = (Field) obj;
                    } else {
                        fieldE2 = E(cls, (String) obj);
                        objArr[i27] = fieldE2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldE2);
                    i28 = i27 + 1;
                    obj2 = objArr[i28];
                    if (obj2 instanceof Field) {
                        fieldE3 = (Field) obj2;
                    } else {
                        fieldE3 = E(cls, (String) obj2);
                        objArr[i28] = fieldE3;
                    }
                    i21 = iObjectFieldOffset3;
                    i18 = i4;
                    i20 = i87;
                    dkVar = dkVar;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldE3);
                    i16 = i82;
                    str = str;
                    i19 = 0;
                }
                i4 = i26;
                int i88 = iCharAt11 & 2048;
                i27 = iCharAt12 + iCharAt12;
                obj = objArr[i27];
                if (obj instanceof Field) {
                    fieldE2 = (Field) obj;
                } else {
                    fieldE2 = E(cls, (String) obj);
                    objArr[i27] = fieldE2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldE2);
                i28 = i27 + 1;
                obj2 = objArr[i28];
                if (obj2 instanceof Field) {
                    fieldE3 = (Field) obj2;
                } else {
                    fieldE3 = E(cls, (String) obj2);
                    objArr[i28] = fieldE3;
                }
                i21 = iObjectFieldOffset4;
                i18 = i4;
                i20 = i88;
                dkVar = dkVar;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldE3);
                i16 = i82;
                str = str;
                i19 = 0;
            } else {
                i17 = i2;
                i18 = i4 + 1;
                int i89 = iCharAt11 & 2048;
                Field fieldE4 = E(cls, (String) objArr[i4]);
                if (i76 == 9 || i76 == 17) {
                    dkVar = dkVar;
                    int i90 = i66 / 3;
                    objArr2[i90 + i90 + 1] = fieldE4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i24 = i4 + 2;
                            i23 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            dkVar = dkVar;
                            if (dkVar.c() == 1 || i89 != 0) {
                                i24 = i4 + 2;
                                int i91 = i66 / 3;
                                objArr2[i91 + i91 + 1] = objArr[i18];
                                i18 = i24;
                            }
                        } else if (i76 == 50) {
                            int i92 = i4 + 2;
                            int i93 = i64 + 1;
                            iArr[i64] = i66;
                            int i94 = i66 / 3;
                            int i95 = i94 + i94;
                            objArr2[i95] = objArr[i18];
                            if (i89 != 0) {
                                i18 = i4 + 3;
                                objArr2[i95 + 1] = objArr[i92];
                                i64 = i93;
                                dkVar = dkVar;
                            } else {
                                i18 = i92;
                                i64 = i93;
                                dkVar = dkVar;
                            }
                        } else {
                            dkVar = dkVar;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldE4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) != 0 || i76 > 17) {
                            i19 = 0;
                        } else {
                            int i96 = i16 + 1;
                            int iCharAt13 = str.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i97 = iCharAt13 & 8191;
                                int i98 = 13;
                                while (true) {
                                    i22 = i96 + 1;
                                    cCharAt9 = str.charAt(i96);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i97 |= (cCharAt9 & 8191) << i98;
                                    i98 += 13;
                                    i96 = i22;
                                }
                                iCharAt13 = i97 | (cCharAt9 << i98);
                                i96 = i22;
                            }
                            int i99 = i6 + i6 + (iCharAt13 / 32);
                            Object obj3 = objArr[i99];
                            int i100 = i96;
                            if (obj3 instanceof Field) {
                                fieldE = (Field) obj3;
                            } else {
                                fieldE = E(cls, (String) obj3);
                                objArr[i99] = fieldE;
                            }
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldE);
                            i19 = iCharAt13 % 32;
                            i16 = i100;
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i20 = i89;
                        i21 = iObjectFieldOffset;
                    } else {
                        i23 = 1;
                        i24 = i4 + 2;
                    }
                    int i101 = i66 / 3;
                    objArr2[i101 + i101 + i23] = objArr[i18];
                    i18 = i24;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldE4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) != 0) {
                        i19 = 0;
                    } else {
                        i19 = 0;
                    }
                    if (i76 >= 18) {
                        iArr[i65] = iObjectFieldOffset;
                        i65++;
                    }
                    i20 = i89;
                    i21 = iObjectFieldOffset;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldE4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) != 0) {
                    i19 = 0;
                } else {
                    i19 = 0;
                }
                if (i76 >= 18) {
                    iArr[i65] = iObjectFieldOffset;
                    i65++;
                }
                i20 = i89;
                i21 = iObjectFieldOffset;
            }
            int i102 = i66 + 1;
            iArr3[i66] = iCharAt10;
            int i103 = i66 + 2;
            Unsafe unsafe2 = unsafe;
            iArr3[i102] = (i20 != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt11 & 512) != 0 ? PropertyOptions.DELETE_EXISTING : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i76 << 20) | i21;
            i66 += 3;
            iArr3[i103] = (i19 << 20) | iObjectFieldOffset2;
            str = str;
            i34 = i16;
            length = i77;
            unsafe = unsafe2;
            dkVar = dkVar;
            i4 = i18;
            i5 = i5;
            i2 = i17;
            c = 55296;
        }
        return new db(iArr3, objArr2, i2, i5, dkVar.a, false, iArr, i3, i62, deVar, ckVar, efVar, asVar, ctVar);
    }

    private static double n(Object obj, long j) {
        return ((Double) em.j(obj, j)).doubleValue();
    }

    private static float o(Object obj, long j) {
        return ((Float) em.j(obj, j)).floatValue();
    }

    private final int p(int i) {
        return this.c[i];
    }

    private static int q(Object obj, long j) {
        return ((Integer) em.j(obj, j)).intValue();
    }

    private final int r(int i) {
        if (i < this.e || i > this.f) {
            return -1;
        }
        return t(i, 0);
    }

    private final int s(int i) {
        return this.c[i + 2];
    }

    private final int t(int i, int i2) {
        int length = (this.c.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int iP = p(i4);
            if (i == iP) {
                return i4;
            }
            if (i < iP) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int u(int i) {
        return (i >>> 20) & 255;
    }

    private final int v(int i) {
        return this.c[i + 1];
    }

    private static long w(int i) {
        return i & 1048575;
    }

    private static long x(Object obj, long j) {
        return ((Long) em.j(obj, j)).longValue();
    }

    private final bo y(int i) {
        int i2 = i / 3;
        return (bo) this.d[i2 + i2 + 1];
    }

    private final dr z(int i) {
        Object[] objArr = this.d;
        int i2 = i / 3;
        int i3 = i2 + i2;
        dr drVar = (dr) objArr[i3];
        if (drVar != null) {
            return drVar;
        }
        dr drVarA = di.a.a((Class) objArr[i3 + 1]);
        this.d[i3] = drVarA;
        return drVarA;
    }

    /* JADX WARN: Code duplicated, block: B:131:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:150:0x036a  */
    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final int a(Object obj) {
        int i;
        int i2;
        int i3;
        int iAo;
        int iE;
        int size;
        int size2;
        int iJ;
        int iU;
        int iU2;
        int iU3;
        int iU4;
        int iU5;
        int iW;
        int iE2;
        Unsafe unsafe = b;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < this.c.length) {
            int iV = v(i7);
            int iU6 = u(iV);
            int iP = p(i7);
            int i9 = this.c[i7 + 2];
            int i10 = i9 & i4;
            if (iU6 <= 17) {
                if (i10 != i5) {
                    i6 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i = i5;
                i2 = i6;
                i3 = 1 << (i9 >>> 20);
            } else {
                i = i5;
                i2 = i6;
                i3 = 0;
            }
            long jW = w(iV);
            if (iU6 >= ax.DOUBLE_LIST_PACKED.Z) {
                int i11 = ax.SINT64_LIST_PACKED.Z;
            }
            switch (iU6) {
                case 0:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.ao(iP);
                        i8 += iAo;
                    }
                    break;
                case 1:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.ar(iP);
                        i8 += iAo;
                    }
                    break;
                case 2:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.H(iP, unsafe.getLong(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 3:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.X(iP, unsafe.getLong(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 4:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.F(iP, unsafe.getInt(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 5:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.aq(iP);
                        i8 += iAo;
                    }
                    break;
                case 6:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.ap(iP);
                        i8 += iAo;
                    }
                    break;
                case 7:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.an(iP);
                        i8 += iAo;
                    }
                    break;
                case 8:
                    if (R(obj, i7, i, i2, i3)) {
                        Object object = unsafe.getObject(obj, jW);
                        iAo = object instanceof x ? ai.B(iP, (x) object) : ai.S(iP, (String) object);
                        i8 += iAo;
                    }
                    break;
                case 9:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = dt.f(iP, unsafe.getObject(obj, jW), z(i7));
                        i8 += iAo;
                    }
                    break;
                case 10:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.B(iP, (x) unsafe.getObject(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 11:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.V(iP, unsafe.getInt(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 12:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.D(iP, unsafe.getInt(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 13:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.as(iP);
                        i8 += iAo;
                    }
                    break;
                case 14:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.at(iP);
                        i8 += iAo;
                    }
                    break;
                case 15:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.O(iP, unsafe.getInt(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 16:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.Q(iP, unsafe.getLong(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 17:
                    if (R(obj, i7, i, i2, i3)) {
                        iAo = ai.E(iP, (cy) unsafe.getObject(obj, jW), z(i7));
                        i8 += iAo;
                    }
                    break;
                case 18:
                    iAo = dt.I(iP, (List) unsafe.getObject(obj, jW));
                    i8 += iAo;
                    break;
                case 19:
                    iAo = dt.H(iP, (List) unsafe.getObject(obj, jW));
                    i8 += iAo;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, jW);
                    ef efVar = dt.a;
                    if (list.size() == 0) {
                        iU4 = 0;
                    } else {
                        iE = dt.e(list);
                        size = list.size() * ai.U(iP);
                        iU4 = iE + size;
                    }
                    i8 += iU4;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, jW);
                    ef efVar2 = dt.a;
                    size2 = list2.size();
                    if (size2 == 0) {
                        iAo = 0;
                    } else {
                        iJ = dt.j(list2);
                        iU = ai.U(iP);
                        iAo = iJ + (size2 * iU);
                    }
                    i8 += iAo;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, jW);
                    ef efVar3 = dt.a;
                    size2 = list3.size();
                    if (size2 == 0) {
                        iAo = 0;
                    } else {
                        iJ = dt.d(list3);
                        iU = ai.U(iP);
                        iAo = iJ + (size2 * iU);
                    }
                    i8 += iAo;
                    break;
                case 23:
                    iAo = dt.I(iP, (List) unsafe.getObject(obj, jW));
                    i8 += iAo;
                    break;
                case 24:
                    iAo = dt.H(iP, (List) unsafe.getObject(obj, jW));
                    i8 += iAo;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, jW);
                    ef efVar4 = dt.a;
                    int size3 = list4.size();
                    if (size3 == 0) {
                        iAo = 0;
                    } else {
                        iAo = size3 * ai.an(iP);
                    }
                    i8 += iAo;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, jW);
                    ef efVar5 = dt.a;
                    int size4 = list5.size();
                    if (size4 == 0) {
                        iU2 = 0;
                    } else {
                        iU2 = ai.U(iP) * size4;
                        if (list5 instanceof cj) {
                            cj cjVar = (cj) list5;
                            for (int i12 = 0; i12 < size4; i12++) {
                                Object objC = cjVar.c();
                                iU2 += objC instanceof x ? ai.C((x) objC) : ai.T((String) objC);
                            }
                        } else {
                            for (int i13 = 0; i13 < size4; i13++) {
                                Object obj2 = list5.get(i13);
                                iU2 += obj2 instanceof x ? ai.C((x) obj2) : ai.T((String) obj2);
                            }
                        }
                    }
                    i8 += iU2;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, jW);
                    dr drVarZ = z(i7);
                    ef efVar6 = dt.a;
                    int size5 = list6.size();
                    if (size5 == 0) {
                        iU3 = 0;
                    } else {
                        iU3 = ai.U(iP) * size5;
                        for (int i14 = 0; i14 < size5; i14++) {
                            Object obj3 = list6.get(i14);
                            iU3 += obj3 instanceof ci ? ai.J((ci) obj3) : ai.M((cy) obj3, drVarZ);
                        }
                    }
                    i8 += iU3;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, jW);
                    ef efVar7 = dt.a;
                    int size6 = list7.size();
                    if (size6 == 0) {
                        iU4 = 0;
                    } else {
                        iU4 = size6 * ai.U(iP);
                        for (int i15 = 0; i15 < list7.size(); i15++) {
                            iU4 += ai.C((x) list7.get(i15));
                        }
                    }
                    i8 += iU4;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, jW);
                    ef efVar8 = dt.a;
                    size2 = list8.size();
                    if (size2 == 0) {
                        iAo = 0;
                    } else {
                        iJ = dt.i(list8);
                        iU = ai.U(iP);
                        iAo = iJ + (size2 * iU);
                    }
                    i8 += iAo;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, jW);
                    ef efVar9 = dt.a;
                    size2 = list9.size();
                    if (size2 == 0) {
                        iAo = 0;
                    } else {
                        iJ = dt.a(list9);
                        iU = ai.U(iP);
                        iAo = iJ + (size2 * iU);
                    }
                    i8 += iAo;
                    break;
                case 31:
                    iAo = dt.H(iP, (List) unsafe.getObject(obj, jW));
                    i8 += iAo;
                    break;
                case 32:
                    iAo = dt.I(iP, (List) unsafe.getObject(obj, jW));
                    i8 += iAo;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, jW);
                    ef efVar10 = dt.a;
                    size2 = list10.size();
                    if (size2 == 0) {
                        iAo = 0;
                    } else {
                        iJ = dt.g(list10);
                        iU = ai.U(iP);
                        iAo = iJ + (size2 * iU);
                    }
                    i8 += iAo;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, jW);
                    ef efVar11 = dt.a;
                    size2 = list11.size();
                    if (size2 == 0) {
                        iAo = 0;
                    } else {
                        iJ = dt.h(list11);
                        iU = ai.U(iP);
                        iAo = iJ + (size2 * iU);
                    }
                    i8 += iAo;
                    break;
                case 35:
                    size = dt.c((List) unsafe.getObject(obj, jW));
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 36:
                    size = dt.b((List) unsafe.getObject(obj, jW));
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 37:
                    size = dt.e((List) unsafe.getObject(obj, jW));
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 38:
                    size = dt.j((List) unsafe.getObject(obj, jW));
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 39:
                    size = dt.d((List) unsafe.getObject(obj, jW));
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 40:
                    size = dt.c((List) unsafe.getObject(obj, jW));
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 41:
                    size = dt.b((List) unsafe.getObject(obj, jW));
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, jW);
                    ef efVar12 = dt.a;
                    size = list12.size();
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 43:
                    size = dt.i((List) unsafe.getObject(obj, jW));
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 44:
                    size = dt.a((List) unsafe.getObject(obj, jW));
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 45:
                    size = dt.b((List) unsafe.getObject(obj, jW));
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 46:
                    size = dt.c((List) unsafe.getObject(obj, jW));
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 47:
                    size = dt.g((List) unsafe.getObject(obj, jW));
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 48:
                    size = dt.h((List) unsafe.getObject(obj, jW));
                    if (size > 0) {
                        iU5 = ai.U(iP);
                        iW = ai.W(size);
                        iE = iU5 + iW;
                        iU4 = iE + size;
                        i8 += iU4;
                    }
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, jW);
                    dr drVarZ2 = z(i7);
                    ef efVar13 = dt.a;
                    int size7 = list13.size();
                    if (size7 == 0) {
                        iE2 = 0;
                    } else {
                        iE2 = 0;
                        for (int i16 = 0; i16 < size7; i16++) {
                            iE2 += ai.E(iP, (cy) list13.get(i16), drVarZ2);
                        }
                    }
                    i8 += iE2;
                    break;
                case 50:
                    iAo = ct.d(iP, unsafe.getObject(obj, jW), B(i7));
                    i8 += iAo;
                    break;
                case 51:
                    if (U(obj, iP, i7)) {
                        iAo = ai.ao(iP);
                        i8 += iAo;
                    }
                    break;
                case 52:
                    if (U(obj, iP, i7)) {
                        iAo = ai.ar(iP);
                        i8 += iAo;
                    }
                    break;
                case 53:
                    if (U(obj, iP, i7)) {
                        iAo = ai.H(iP, x(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 54:
                    if (U(obj, iP, i7)) {
                        iAo = ai.X(iP, x(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 55:
                    if (U(obj, iP, i7)) {
                        iAo = ai.F(iP, q(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 56:
                    if (U(obj, iP, i7)) {
                        iAo = ai.aq(iP);
                        i8 += iAo;
                    }
                    break;
                case 57:
                    if (U(obj, iP, i7)) {
                        iAo = ai.ap(iP);
                        i8 += iAo;
                    }
                    break;
                case 58:
                    if (U(obj, iP, i7)) {
                        iAo = ai.an(iP);
                        i8 += iAo;
                    }
                    break;
                case 59:
                    if (U(obj, iP, i7)) {
                        Object object2 = unsafe.getObject(obj, jW);
                        iAo = object2 instanceof x ? ai.B(iP, (x) object2) : ai.S(iP, (String) object2);
                        i8 += iAo;
                    }
                    break;
                case 60:
                    if (U(obj, iP, i7)) {
                        iAo = dt.f(iP, unsafe.getObject(obj, jW), z(i7));
                        i8 += iAo;
                    }
                    break;
                case 61:
                    if (U(obj, iP, i7)) {
                        iAo = ai.B(iP, (x) unsafe.getObject(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 62:
                    if (U(obj, iP, i7)) {
                        iAo = ai.V(iP, q(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 63:
                    if (U(obj, iP, i7)) {
                        iAo = ai.D(iP, q(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 64:
                    if (U(obj, iP, i7)) {
                        iAo = ai.as(iP);
                        i8 += iAo;
                    }
                    break;
                case 65:
                    if (U(obj, iP, i7)) {
                        iAo = ai.at(iP);
                        i8 += iAo;
                    }
                    break;
                case 66:
                    if (U(obj, iP, i7)) {
                        iAo = ai.O(iP, q(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 67:
                    if (U(obj, iP, i7)) {
                        iAo = ai.Q(iP, x(obj, jW));
                        i8 += iAo;
                    }
                    break;
                case 68:
                    if (U(obj, iP, i7)) {
                        iAo = ai.E(iP, (cy) unsafe.getObject(obj, jW), z(i7));
                        i8 += iAo;
                    }
                    break;
            }
            i7 += 3;
            i5 = i;
            i6 = i2;
            i4 = 1048575;
        }
        ef efVar14 = this.f244n;
        int iA = i8 + efVar14.a(efVar14.d(obj));
        if (!this.h) {
            return iA;
        }
        av avVarB = this.o.b(obj);
        int i17 = avVarB.b.b;
        int iJ2 = 0;
        for (int i18 = 0; i18 < i17; i18++) {
            dv dvVar = (dv) avVarB.b.d(i18);
            iJ2 += av.j((bg) dvVar.a, dvVar.b);
        }
        for (Map.Entry entry : avVarB.b.a()) {
            iJ2 += av.j((bg) entry.getKey(), entry.getValue());
        }
        return iA + iJ2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final int b(Object obj) {
        int i;
        int iB;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.c.length; i4 += 3) {
            int iV = v(i4);
            int iP = p(i4);
            long jW = w(iV);
            int iHashCode = 37;
            switch (u(iV)) {
                case 0:
                    i = i3 * 53;
                    iB = ca.b(Double.doubleToLongBits(em.d(obj, jW)));
                    i3 = i + iB;
                    break;
                case 1:
                    i = i3 * 53;
                    iB = Float.floatToIntBits(em.e(obj, jW));
                    i3 = i + iB;
                    break;
                case 2:
                    i = i3 * 53;
                    iB = ca.b(em.h(obj, jW));
                    i3 = i + iB;
                    break;
                case 3:
                    i = i3 * 53;
                    iB = ca.b(em.h(obj, jW));
                    i3 = i + iB;
                    break;
                case 4:
                    i = i3 * 53;
                    iB = em.f(obj, jW);
                    i3 = i + iB;
                    break;
                case 5:
                    i = i3 * 53;
                    iB = ca.b(em.h(obj, jW));
                    i3 = i + iB;
                    break;
                case 6:
                    i = i3 * 53;
                    iB = em.f(obj, jW);
                    i3 = i + iB;
                    break;
                case 7:
                    i = i3 * 53;
                    iB = ca.a(em.y(obj, jW));
                    i3 = i + iB;
                    break;
                case 8:
                    i = i3 * 53;
                    iB = ((String) em.j(obj, jW)).hashCode();
                    i3 = i + iB;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object objJ = em.j(obj, jW);
                    if (objJ != null) {
                        iHashCode = objJ.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iB = em.j(obj, jW).hashCode();
                    i3 = i + iB;
                    break;
                case 11:
                    i = i3 * 53;
                    iB = em.f(obj, jW);
                    i3 = i + iB;
                    break;
                case 12:
                    i = i3 * 53;
                    iB = em.f(obj, jW);
                    i3 = i + iB;
                    break;
                case 13:
                    i = i3 * 53;
                    iB = em.f(obj, jW);
                    i3 = i + iB;
                    break;
                case 14:
                    i = i3 * 53;
                    iB = ca.b(em.h(obj, jW));
                    i3 = i + iB;
                    break;
                case 15:
                    i = i3 * 53;
                    iB = em.f(obj, jW);
                    i3 = i + iB;
                    break;
                case 16:
                    i = i3 * 53;
                    iB = ca.b(em.h(obj, jW));
                    i3 = i + iB;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object objJ2 = em.j(obj, jW);
                    if (objJ2 != null) {
                        iHashCode = objJ2.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i3 * 53;
                    iB = em.j(obj, jW).hashCode();
                    i3 = i + iB;
                    break;
                case 50:
                    i = i3 * 53;
                    iB = em.j(obj, jW).hashCode();
                    i3 = i + iB;
                    break;
                case 51:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = ca.b(Double.doubleToLongBits(n(obj, jW)));
                        i3 = i + iB;
                    }
                    break;
                case 52:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = Float.floatToIntBits(o(obj, jW));
                        i3 = i + iB;
                    }
                    break;
                case 53:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = ca.b(x(obj, jW));
                        i3 = i + iB;
                    }
                    break;
                case 54:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = ca.b(x(obj, jW));
                        i3 = i + iB;
                    }
                    break;
                case 55:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = q(obj, jW);
                        i3 = i + iB;
                    }
                    break;
                case 56:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = ca.b(x(obj, jW));
                        i3 = i + iB;
                    }
                    break;
                case 57:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = q(obj, jW);
                        i3 = i + iB;
                    }
                    break;
                case 58:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = ca.a(V(obj, jW));
                        i3 = i + iB;
                    }
                    break;
                case 59:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = ((String) em.j(obj, jW)).hashCode();
                        i3 = i + iB;
                    }
                    break;
                case 60:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = em.j(obj, jW).hashCode();
                        i3 = i + iB;
                    }
                    break;
                case 61:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = em.j(obj, jW).hashCode();
                        i3 = i + iB;
                    }
                    break;
                case 62:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = q(obj, jW);
                        i3 = i + iB;
                    }
                    break;
                case 63:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = q(obj, jW);
                        i3 = i + iB;
                    }
                    break;
                case 64:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = q(obj, jW);
                        i3 = i + iB;
                    }
                    break;
                case 65:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = ca.b(x(obj, jW));
                        i3 = i + iB;
                    }
                    break;
                case 66:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = q(obj, jW);
                        i3 = i + iB;
                    }
                    break;
                case 67:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = ca.b(x(obj, jW));
                        i3 = i + iB;
                    }
                    break;
                case 68:
                    if (U(obj, iP, i4)) {
                        i = i3 * 53;
                        iB = em.j(obj, jW).hashCode();
                        i3 = i + iB;
                    }
                    break;
            }
        }
        int iHashCode2 = (i3 * 53) + this.f244n.d(obj).hashCode();
        return this.h ? (iHashCode2 * 53) + this.o.b(obj).hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:413:0x09d0 A[PHI: r7 r8 r9 r11 r12 r14 r30 r31
      0x09d0: PHI (r7v34 int) = (r7v11 int), (r7v12 int), (r7v13 int), (r7v22 int), (r7v27 int), (r7v32 int), (r7v38 int) binds: [B:408:0x09b0, B:375:0x0903, B:348:0x087e, B:200:0x05b3, B:249:0x0693, B:141:0x0440, B:124:0x03bb] A[DONT_GENERATE, DONT_INLINE]
      0x09d0: PHI (r8v87 int) = (r8v40 int), (r8v41 int), (r8v42 int), (r8v66 int), (r8v74 int), (r8v81 int), (r8v89 int) binds: [B:408:0x09b0, B:375:0x0903, B:348:0x087e, B:200:0x05b3, B:249:0x0693, B:141:0x0440, B:124:0x03bb] A[DONT_GENERATE, DONT_INLINE]
      0x09d0: PHI (r9v76 java.lang.String) = 
      (r9v36 java.lang.String)
      (r9v37 java.lang.String)
      (r9v38 java.lang.String)
      (r9v61 java.lang.String)
      (r9v69 java.lang.String)
      (r9v74 java.lang.String)
      (r9v78 java.lang.String)
     binds: [B:408:0x09b0, B:375:0x0903, B:348:0x087e, B:200:0x05b3, B:249:0x0693, B:141:0x0440, B:124:0x03bb] A[DONT_GENERATE, DONT_INLINE]
      0x09d0: PHI (r11v57 com.google.android.libraries.navigation.internal.ael.h) = 
      (r11v27 com.google.android.libraries.navigation.internal.ael.h)
      (r11v31 com.google.android.libraries.navigation.internal.ael.h)
      (r11v32 com.google.android.libraries.navigation.internal.ael.h)
      (r11v43 com.google.android.libraries.navigation.internal.ael.h)
      (r11v50 com.google.android.libraries.navigation.internal.ael.h)
      (r11v55 com.google.android.libraries.navigation.internal.ael.h)
      (r11v60 com.google.android.libraries.navigation.internal.ael.h)
     binds: [B:408:0x09b0, B:375:0x0903, B:348:0x087e, B:200:0x05b3, B:249:0x0693, B:141:0x0440, B:124:0x03bb] A[DONT_GENERATE, DONT_INLINE]
      0x09d0: PHI (r12v39 com.google.android.libraries.navigation.internal.ael.db<T>) = 
      (r12v19 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v20 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v21 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v31 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v33 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v37 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v42 com.google.android.libraries.navigation.internal.ael.db<T>)
     binds: [B:408:0x09b0, B:375:0x0903, B:348:0x087e, B:200:0x05b3, B:249:0x0693, B:141:0x0440, B:124:0x03bb] A[DONT_GENERATE, DONT_INLINE]
      0x09d0: PHI (r14v44 int) = (r14v18 int), (r14v19 int), (r14v20 int), (r14v33 int), (r14v37 int), (r14v41 int), (r14v46 int) binds: [B:408:0x09b0, B:375:0x0903, B:348:0x087e, B:200:0x05b3, B:249:0x0693, B:141:0x0440, B:124:0x03bb] A[DONT_GENERATE, DONT_INLINE]
      0x09d0: PHI (r30v35 sun.misc.Unsafe) = 
      (r30v10 sun.misc.Unsafe)
      (r30v11 sun.misc.Unsafe)
      (r30v12 sun.misc.Unsafe)
      (r30v21 sun.misc.Unsafe)
      (r30v28 sun.misc.Unsafe)
      (r30v33 sun.misc.Unsafe)
      (r30v37 sun.misc.Unsafe)
     binds: [B:408:0x09b0, B:375:0x0903, B:348:0x087e, B:200:0x05b3, B:249:0x0693, B:141:0x0440, B:124:0x03bb] A[DONT_GENERATE, DONT_INLINE]
      0x09d0: PHI (r31v25 int) = (r31v2 int), (r31v3 int), (r31v4 int), (r31v13 int), (r31v18 int), (r31v23 int), (r31v27 int) binds: [B:408:0x09b0, B:375:0x0903, B:348:0x087e, B:200:0x05b3, B:249:0x0693, B:141:0x0440, B:124:0x03bb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:415:0x09d3  */
    /* JADX WARN: Code duplicated, block: B:416:0x09e3  */
    /* JADX WARN: Code duplicated, block: B:535:0x0dc1 A[PHI: r3 r7 r8 r10 r11 r12 r19 r26
      0x0dc1: PHI (r3v119 int) = 
      (r3v95 int)
      (r3v96 int)
      (r3v97 int)
      (r3v98 int)
      (r3v99 int)
      (r3v100 int)
      (r3v101 int)
      (r3v102 int)
      (r3v107 int)
      (r3v111 int)
      (r31v28 int)
     binds: [B:533:0x0dae, B:530:0x0d8c, B:527:0x0d6a, B:524:0x0d48, B:521:0x0d26, B:518:0x0d03, B:511:0x0cd8, B:497:0x0c93, B:495:0x0c7c, B:477:0x0bde, B:465:0x0b48] A[DONT_GENERATE, DONT_INLINE]
      0x0dc1: PHI (r7v75 java.lang.Object) = 
      (r7v55 java.lang.Object)
      (r7v56 java.lang.Object)
      (r7v57 java.lang.Object)
      (r7v58 java.lang.Object)
      (r7v59 java.lang.Object)
      (r7v60 java.lang.Object)
      (r7v61 java.lang.Object)
      (r7v62 java.lang.Object)
      (r7v65 java.lang.Object)
      (r7v69 java.lang.Object)
      (r34v0 java.lang.Object A[IMMUTABLE_TYPE, METHOD_ARGUMENT])
     binds: [B:533:0x0dae, B:530:0x0d8c, B:527:0x0d6a, B:524:0x0d48, B:521:0x0d26, B:518:0x0d03, B:511:0x0cd8, B:497:0x0c93, B:495:0x0c7c, B:477:0x0bde, B:465:0x0b48] A[DONT_GENERATE, DONT_INLINE]
      0x0dc1: PHI (r8v120 int) = 
      (r8v93 int)
      (r8v94 int)
      (r8v95 int)
      (r8v96 int)
      (r8v97 int)
      (r8v98 int)
      (r8v99 int)
      (r8v100 int)
      (r8v105 int)
      (r8v111 int)
      (r8v121 int)
     binds: [B:533:0x0dae, B:530:0x0d8c, B:527:0x0d6a, B:524:0x0d48, B:521:0x0d26, B:518:0x0d03, B:511:0x0cd8, B:497:0x0c93, B:495:0x0c7c, B:477:0x0bde, B:465:0x0b48] A[DONT_GENERATE, DONT_INLINE]
      0x0dc1: PHI (r10v78 com.google.android.libraries.navigation.internal.ael.h) = 
      (r10v50 com.google.android.libraries.navigation.internal.ael.h)
      (r10v51 com.google.android.libraries.navigation.internal.ael.h)
      (r10v52 com.google.android.libraries.navigation.internal.ael.h)
      (r10v53 com.google.android.libraries.navigation.internal.ael.h)
      (r10v54 com.google.android.libraries.navigation.internal.ael.h)
      (r10v55 com.google.android.libraries.navigation.internal.ael.h)
      (r10v56 com.google.android.libraries.navigation.internal.ael.h)
      (r10v57 com.google.android.libraries.navigation.internal.ael.h)
      (r10v62 com.google.android.libraries.navigation.internal.ael.h)
      (r10v69 com.google.android.libraries.navigation.internal.ael.h)
      (r11v61 com.google.android.libraries.navigation.internal.ael.h)
     binds: [B:533:0x0dae, B:530:0x0d8c, B:527:0x0d6a, B:524:0x0d48, B:521:0x0d26, B:518:0x0d03, B:511:0x0cd8, B:497:0x0c93, B:495:0x0c7c, B:477:0x0bde, B:465:0x0b48] A[DONT_GENERATE, DONT_INLINE]
      0x0dc1: PHI (r11v88 int) = 
      (r11v64 int)
      (r11v65 int)
      (r11v66 int)
      (r11v67 int)
      (r11v68 int)
      (r11v69 int)
      (r11v70 int)
      (r11v71 int)
      (r11v74 int)
      (r11v81 int)
      (r19v31 int)
     binds: [B:533:0x0dae, B:530:0x0d8c, B:527:0x0d6a, B:524:0x0d48, B:521:0x0d26, B:518:0x0d03, B:511:0x0cd8, B:497:0x0c93, B:495:0x0c7c, B:477:0x0bde, B:465:0x0b48] A[DONT_GENERATE, DONT_INLINE]
      0x0dc1: PHI (r12v78 com.google.android.libraries.navigation.internal.ael.db<T>) = 
      (r12v57 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v58 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v59 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v60 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v61 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v62 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v63 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v64 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v67 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v71 com.google.android.libraries.navigation.internal.ael.db<T>)
      (r12v79 com.google.android.libraries.navigation.internal.ael.db<T>)
     binds: [B:533:0x0dae, B:530:0x0d8c, B:527:0x0d6a, B:524:0x0d48, B:521:0x0d26, B:518:0x0d03, B:511:0x0cd8, B:497:0x0c93, B:495:0x0c7c, B:477:0x0bde, B:465:0x0b48] A[DONT_GENERATE, DONT_INLINE]
      0x0dc1: PHI (r19v47 java.lang.String) = 
      (r19v32 java.lang.String)
      (r19v33 java.lang.String)
      (r19v34 java.lang.String)
      (r19v35 java.lang.String)
      (r19v36 java.lang.String)
      (r19v37 java.lang.String)
      (r19v38 java.lang.String)
      (r19v39 java.lang.String)
      (r19v41 java.lang.String)
      (r19v43 java.lang.String)
      (r19v48 java.lang.String)
     binds: [B:533:0x0dae, B:530:0x0d8c, B:527:0x0d6a, B:524:0x0d48, B:521:0x0d26, B:518:0x0d03, B:511:0x0cd8, B:497:0x0c93, B:495:0x0c7c, B:477:0x0bde, B:465:0x0b48] A[DONT_GENERATE, DONT_INLINE]
      0x0dc1: PHI (r26v25 int) = 
      (r26v9 int)
      (r26v10 int)
      (r26v11 int)
      (r26v12 int)
      (r26v13 int)
      (r26v14 int)
      (r26v15 int)
      (r26v16 int)
      (r26v18 int)
      (r26v20 int)
      (r9v83 int)
     binds: [B:533:0x0dae, B:530:0x0d8c, B:527:0x0d6a, B:524:0x0d48, B:521:0x0d26, B:518:0x0d03, B:511:0x0cd8, B:497:0x0c93, B:495:0x0c7c, B:477:0x0bde, B:465:0x0b48] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:550:0x0e30  */
    /* JADX WARN: Code duplicated, block: B:620:0x0dc4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:0x0dd6 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: TypeSearchVarInfo not found in map for var: r2v44 java.lang.Object
    	at jadx.core.dex.visitors.typeinference.TypeSearchState.getVarInfo(TypeSearchState.java:34)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.lambda$resolveIndependentVariables$1(TypeSearch.java:173)
    	at java.base/java.util.stream.MatchOps$1MatchSink.accept(Unknown Source)
    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.test(Unknown Source)
    	at java.base/java.util.stream.MatchOps$1MatchSink.accept(Unknown Source)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(Unknown Source)
    	at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
    	at java.base/java.util.stream.MatchOps$MatchOp.evaluateSequential(Unknown Source)
     */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r11v90 */
    /* JADX WARN: Type inference failed for: r11v92 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r9v54 */
    /* JADX WARN: Type inference failed for: r9v55, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v56, types: [java.lang.Object] */
    final int c(Object obj, byte[] bArr, int i, int i2, int i3, h hVar) throws IOException {
        String str;
        Unsafe unsafe;
        db<T> dbVar;
        int i4;
        int i5;
        int i6;
        int iN;
        int i7;
        int i8;
        int i9;
        h hVar2;
        int i10;
        db<T> dbVar2;
        int i11;
        int i12;
        db<T> dbVar3;
        byte b2;
        db<T> dbVar4;
        int i13;
        int i14;
        int i15;
        int iP;
        int i16;
        byte b3;
        int i17;
        bz bzVar;
        int i18;
        int i19;
        int i20;
        String str2;
        int i21;
        ?? r9;
        int i22;
        int iO;
        int i23;
        int iM;
        String str3;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        h hVar3;
        String str4;
        int iC;
        int i30;
        int i31;
        h hVar4;
        String str5;
        int iM2;
        db<T> dbVar5 = this;
        obj = obj;
        byte[] bArr2 = bArr;
        i2 = i2;
        i3 = i3;
        h hVar5 = hVar;
        F(obj);
        Unsafe unsafe2 = b;
        int iL = i;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        int i35 = -1;
        int i36 = 1048575;
        while (true) {
            if (iL < i2) {
                int i37 = iL + 1;
                int i38 = bArr2[iL];
                if (i38 < 0) {
                    iN = i.n(i38, bArr2, i37, hVar5);
                    i6 = hVar5.a;
                } else {
                    i6 = i38;
                    iN = i37;
                }
                int i39 = i6 >>> 3;
                int iT = i39 > i35 ? (i39 < dbVar5.e || i39 > dbVar5.f) ? -1 : dbVar5.t(i39, i32 / 3) : dbVar5.r(i39);
                if (iT != -1) {
                    int i40 = i6 & 7;
                    int[] iArr = dbVar5.c;
                    int i41 = i6;
                    int i42 = iArr[iT + 1];
                    str = "Failed to parse the message.";
                    int iU = u(i42);
                    long jW = w(i42);
                    if (iU <= 17) {
                        int i43 = iArr[iT + 2];
                        int i44 = 1 << (i43 >>> 20);
                        char c = CharCompanionObject.MAX_VALUE;
                        int i45 = i43 & 1048575;
                        if (i45 != i36) {
                            if (i36 != 1048575) {
                                unsafe2.putInt(obj, i36, i34);
                            }
                            i34 = i45 == 1048575 ? 0 : unsafe2.getInt(obj, i45);
                            i9 = i45;
                        } else {
                            i9 = i36;
                        }
                        switch (iU) {
                            case 0:
                                b2 = -1;
                                dbVar4 = this;
                                iN = iN;
                                i13 = iT;
                                c = 65535;
                                i14 = i41 == true ? 1 : 0;
                                if (i40 == 1) {
                                    iL = iN + 8;
                                    i34 |= i44;
                                    em.s(obj, jW, i.a(bArr2, iN));
                                    i33 = i14;
                                    dbVar5 = dbVar4;
                                    i32 = i13;
                                    i35 = i39;
                                    i36 = i9;
                                } else {
                                    this = dbVar4;
                                    unsafe2 = unsafe2;
                                    hVar5 = hVar5;
                                    i34 = i34;
                                    i16 = i13;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                            case 1:
                                b2 = -1;
                                dbVar4 = this;
                                iN = iN;
                                i13 = iT;
                                c = 65535;
                                i14 = i41 == true ? 1 : 0;
                                if (i40 == 5) {
                                    iL = iN + 4;
                                    i34 |= i44;
                                    em.t(obj, jW, i.b(bArr2, iN));
                                    i33 = i14;
                                    dbVar5 = dbVar4;
                                    i32 = i13;
                                    i35 = i39;
                                    i36 = i9;
                                } else {
                                    this = dbVar4;
                                    unsafe2 = unsafe2;
                                    hVar5 = hVar5;
                                    i34 = i34;
                                    i16 = i13;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                            case 2:
                            case 3:
                                b2 = -1;
                                dbVar4 = this;
                                iN = iN;
                                i13 = iT;
                                c = 65535;
                                i14 = i41 == true ? 1 : 0;
                                if (i40 == 0) {
                                    i15 = i44 | i34;
                                    iP = i.p(bArr2, iN, hVar5);
                                    unsafe2.putLong(obj, jW, hVar5.b);
                                    i33 = i14;
                                    dbVar5 = dbVar4;
                                    i32 = i13;
                                    i34 = i15;
                                    iL = iP;
                                    i35 = i39;
                                    i36 = i9;
                                } else {
                                    this = dbVar4;
                                    unsafe2 = unsafe2;
                                    hVar5 = hVar5;
                                    i34 = i34;
                                    i16 = i13;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                            case 4:
                            case 11:
                                b2 = -1;
                                dbVar4 = this;
                                iN = iN;
                                i13 = iT;
                                c = 65535;
                                i14 = i41 == true ? 1 : 0;
                                if (i40 == 0) {
                                    i34 |= i44;
                                    iL = i.m(bArr2, iN, hVar5);
                                    unsafe2.putInt(obj, jW, hVar5.a);
                                    i33 = i14;
                                    dbVar5 = dbVar4;
                                    i32 = i13;
                                    i35 = i39;
                                    i36 = i9;
                                } else {
                                    this = dbVar4;
                                    unsafe2 = unsafe2;
                                    hVar5 = hVar5;
                                    i34 = i34;
                                    i16 = i13;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                            case 5:
                            case 14:
                                b2 = -1;
                                dbVar4 = this;
                                iN = iN;
                                i13 = iT;
                                c = 65535;
                                i14 = i41 == true ? 1 : 0;
                                if (i40 == 1) {
                                    iP = iN + 8;
                                    i15 = i44 | i34;
                                    unsafe2.putLong(obj, jW, i.t(bArr2, iN));
                                    i33 = i14;
                                    dbVar5 = dbVar4;
                                    i32 = i13;
                                    i34 = i15;
                                    iL = iP;
                                    i35 = i39;
                                    i36 = i9;
                                } else {
                                    this = dbVar4;
                                    unsafe2 = unsafe2;
                                    hVar5 = hVar5;
                                    i34 = i34;
                                    i16 = i13;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                            case 6:
                            case 13:
                                b2 = -1;
                                dbVar4 = this;
                                iN = iN;
                                i13 = iT;
                                c = 65535;
                                i14 = i41 == true ? 1 : 0;
                                if (i40 == 5) {
                                    iL = iN + 4;
                                    i34 |= i44;
                                    unsafe2.putInt(obj, jW, i.e(bArr2, iN));
                                    i33 = i14;
                                    dbVar5 = dbVar4;
                                    i32 = i13;
                                    i35 = i39;
                                    i36 = i9;
                                } else {
                                    this = dbVar4;
                                    unsafe2 = unsafe2;
                                    hVar5 = hVar5;
                                    i34 = i34;
                                    i16 = i13;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                            case 7:
                                b2 = -1;
                                dbVar4 = this;
                                iN = iN;
                                i13 = iT;
                                c = 65535;
                                i14 = i41 == true ? 1 : 0;
                                if (i40 == 0) {
                                    i34 |= i44;
                                    iL = i.p(bArr2, iN, hVar5);
                                    em.o(obj, jW, hVar5.b != 0);
                                    i33 = i14;
                                    dbVar5 = dbVar4;
                                    i32 = i13;
                                    i35 = i39;
                                    i36 = i9;
                                } else {
                                    this = dbVar4;
                                    unsafe2 = unsafe2;
                                    hVar5 = hVar5;
                                    i34 = i34;
                                    i16 = i13;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                            case 8:
                                b2 = -1;
                                dbVar4 = this;
                                iN = iN;
                                i13 = iT;
                                c = 65535;
                                i14 = i41 == true ? 1 : 0;
                                if (i40 == 2) {
                                    i34 |= i44;
                                    iL = P(i42) ? i.k(bArr2, iN, hVar5) : i.j(bArr2, iN, hVar5);
                                    unsafe2.putObject(obj, jW, hVar5.c);
                                    i33 = i14;
                                    dbVar5 = dbVar4;
                                    i32 = i13;
                                    i35 = i39;
                                    i36 = i9;
                                } else {
                                    this = dbVar4;
                                    unsafe2 = unsafe2;
                                    hVar5 = hVar5;
                                    i34 = i34;
                                    i16 = i13;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                            case 9:
                                b2 = -1;
                                dbVar4 = this;
                                i13 = iT;
                                i14 = i41 == true ? 1 : 0;
                                if (i40 == 2) {
                                    Object objC = dbVar4.C(obj, i13);
                                    iL = i.r(objC, dbVar4.z(i13), bArr, iN, i2, hVar);
                                    dbVar4.L(obj, i13, objC);
                                    i33 = i14 == true ? 1 : 0;
                                    dbVar5 = dbVar4;
                                    i32 = i13;
                                    i34 = i44 | i34;
                                    i35 = i39;
                                    i36 = i9;
                                } else {
                                    iN = iN;
                                    this = dbVar4;
                                    unsafe2 = unsafe2;
                                    hVar5 = hVar5;
                                    i34 = i34;
                                    i16 = i13;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                            case 10:
                                b2 = -1;
                                dbVar4 = this;
                                i13 = iT;
                                i14 = i41 == true ? 1 : 0;
                                if (i40 == 2) {
                                    i34 |= i44;
                                    iL = i.c(bArr2, iN, hVar5);
                                    unsafe2.putObject(obj, jW, hVar5.c);
                                    i33 = i14;
                                    dbVar5 = dbVar4;
                                    i32 = i13;
                                    i35 = i39;
                                    i36 = i9;
                                } else {
                                    iN = iN;
                                    this = dbVar4;
                                    unsafe2 = unsafe2;
                                    hVar5 = hVar5;
                                    i34 = i34;
                                    i16 = i13;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                            case 12:
                                i13 = iT;
                                i14 = i41 == true ? 1 : 0;
                                b3 = -1;
                                if (i40 == 0) {
                                    iL = i.m(bArr2, iN, hVar5);
                                    int i46 = hVar5.a;
                                    dbVar4 = this;
                                    bo boVarY = dbVar4.y(i13);
                                    if ((i42 & Integer.MIN_VALUE) == 0 || boVarY == null || boVarY.a(i46)) {
                                        i34 |= i44;
                                        unsafe2.putInt(obj, jW, i46);
                                    } else {
                                        d(obj).e(i14 == true ? 1 : 0, Long.valueOf(i46));
                                    }
                                    i33 = i14;
                                    dbVar5 = dbVar4;
                                    i32 = i13;
                                    i35 = i39;
                                    i36 = i9;
                                } else {
                                    this = this;
                                    iN = iN;
                                    i34 = i34;
                                    i16 = i13;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                            case 15:
                                i14 = i41 == true ? 1 : 0;
                                b3 = -1;
                                if (i40 == 0) {
                                    i34 |= i44;
                                    iL = i.m(bArr2, iN, hVar5);
                                    unsafe2.putInt(obj, jW, ac.H(hVar5.a));
                                    i33 = i14 == true ? 1 : 0;
                                    i32 = iT;
                                    i35 = i39;
                                    i36 = i9;
                                    dbVar5 = this;
                                } else {
                                    i16 = iT;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                            case 16:
                                if (i40 == 0) {
                                    int iP2 = i.p(bArr2, iN, hVar5);
                                    unsafe2.putLong(obj, jW, ac.I(hVar5.b));
                                    i33 = i41 == true ? 1 : 0;
                                    i34 |= i44;
                                    iL = iP2;
                                    i32 = iT;
                                    i35 = i39;
                                    i36 = i9;
                                    dbVar5 = this;
                                } else {
                                    i14 = i41 == true ? 1 : 0;
                                    b3 = -1;
                                    i16 = iT;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                            default:
                                b2 = -1;
                                dbVar4 = this;
                                iN = iN;
                                i13 = iT;
                                c = 65535;
                                i14 = i41 == true ? 1 : 0;
                                if (i40 == 3) {
                                    Object objC2 = dbVar4.C(obj, i13);
                                    int iQ = i.q(objC2, dbVar4.z(i13), bArr, iN, i2, (i39 << 3) | 4, hVar);
                                    dbVar4.L(obj, i13, objC2);
                                    i2 = i2;
                                    i3 = i3;
                                    hVar5 = hVar5;
                                    unsafe2 = unsafe2;
                                    i33 = i14 == true ? 1 : 0;
                                    iL = iQ;
                                    i35 = i39;
                                    i36 = i9;
                                    dbVar5 = dbVar4;
                                    i32 = i13;
                                    i34 |= i44;
                                } else {
                                    this = dbVar4;
                                    unsafe2 = unsafe2;
                                    hVar5 = hVar5;
                                    i34 = i34;
                                    i16 = i13;
                                    hVar2 = hVar5;
                                    dbVar2 = this;
                                    i7 = iN;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i5 = i14;
                                    i8 = i34;
                                    i11 = i39;
                                    i3 = i3;
                                }
                                break;
                        }
                    } else {
                        i8 = i34;
                        i9 = i36;
                        Unsafe unsafe3 = unsafe2;
                        int i47 = iN;
                        db<T> dbVar6 = dbVar5;
                        h hVar6 = hVar5;
                        int i48 = i41 == true ? 1 : 0;
                        int i49 = i39;
                        if (iU != 27) {
                            if (iU <= 49) {
                                long j = i42;
                                unsafe = unsafe3;
                                Unsafe unsafe4 = b;
                                bz bzVar2 = (bz) unsafe4.getObject(obj, jW);
                                if (bzVar2.c()) {
                                    bzVar = bzVar2;
                                } else {
                                    int size = bzVar2.size();
                                    bz bzVarE = bzVar2.e(size + size);
                                    unsafe4.putObject(obj, jW, bzVarE);
                                    bzVar = bzVarE;
                                }
                                switch (iU) {
                                    case 18:
                                    case 35:
                                        i2 = i2;
                                        i47 = i47;
                                        i49 = i49;
                                        str = str;
                                        unsafe = unsafe;
                                        i18 = iT;
                                        dbVar2 = this;
                                        if (i40 != 2) {
                                            if (i40 == 1) {
                                                iL = i47 + 8;
                                                int i50 = i.a;
                                                ak akVar = (ak) bzVar;
                                                akVar.h(i.a(bArr2, i47));
                                                while (true) {
                                                    if (iL < i2) {
                                                        hVar6 = hVar;
                                                        int iM3 = i.m(bArr2, iL, hVar6);
                                                        if (i48 == hVar6.a) {
                                                            akVar.h(i.a(bArr2, iM3));
                                                            iL = iM3 + 8;
                                                        }
                                                    }
                                                }
                                            } else {
                                                hVar6 = hVar;
                                                iL = i47;
                                            }
                                            if (iL == i47) {
                                                hVar6 = hVar6;
                                                i7 = iL;
                                                i10 = i18;
                                                str = str;
                                                hVar2 = hVar6;
                                                i11 = i49;
                                                obj = obj;
                                                i5 = i48 == true ? 1 : 0;
                                                i3 = i3;
                                            } else {
                                                hVar6 = hVar6;
                                                i3 = i3;
                                                i33 = i48 == true ? 1 : 0;
                                                i32 = i18;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i35 = i49;
                                                obj = obj;
                                                hVar5 = hVar6;
                                            }
                                            unsafe2 = unsafe;
                                        } else {
                                            ak akVar2 = (ak) bzVar;
                                            iL = i.m(bArr2, i47, hVar6);
                                            int i51 = hVar6.a;
                                            int i52 = iL + i51;
                                            if (i52 > bArr2.length) {
                                                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            int i53 = akVar2.c + (i51 / 8);
                                            int length = akVar2.b.length;
                                            if (i53 > length) {
                                                if (length == 0) {
                                                    akVar2.b = new double[Math.max(i53, 10)];
                                                } else {
                                                    while (length < i53) {
                                                        length = ak.f(length);
                                                    }
                                                    akVar2.b = Arrays.copyOf(akVar2.b, length);
                                                }
                                            }
                                            while (iL < i52) {
                                                akVar2.h(i.a(bArr2, iL));
                                                iL += 8;
                                            }
                                            if (iL != i52) {
                                                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        hVar6 = hVar;
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                    case 19:
                                    case 36:
                                        i2 = i2;
                                        hVar6 = hVar6;
                                        i47 = i47;
                                        i49 = i49;
                                        str = str;
                                        unsafe = unsafe;
                                        i18 = iT;
                                        dbVar2 = this;
                                        if (i40 == 2) {
                                            ay ayVar = (ay) bzVar;
                                            iL = i.m(bArr2, i47, hVar6);
                                            int i54 = hVar6.a;
                                            int i55 = iL + i54;
                                            if (i55 > bArr2.length) {
                                                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            int i56 = ayVar.c + (i54 / 4);
                                            int length2 = ayVar.b.length;
                                            if (i56 > length2) {
                                                if (length2 == 0) {
                                                    ayVar.b = new float[Math.max(i56, 10)];
                                                } else {
                                                    while (length2 < i56) {
                                                        length2 = ay.f(length2);
                                                    }
                                                    ayVar.b = Arrays.copyOf(ayVar.b, length2);
                                                }
                                            }
                                            while (iL < i55) {
                                                ayVar.h(i.b(bArr2, iL));
                                                iL += 4;
                                            }
                                            if (iL != i55) {
                                                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        } else if (i40 == 5) {
                                            iL = i47 + 4;
                                            int i57 = i.a;
                                            ay ayVar2 = (ay) bzVar;
                                            ayVar2.h(i.b(bArr2, i47));
                                            while (iL < i2) {
                                                int iM4 = i.m(bArr2, iL, hVar6);
                                                if (i48 == hVar6.a) {
                                                    ayVar2.h(i.b(bArr2, iM4));
                                                    iL = iM4 + 4;
                                                }
                                            }
                                        } else {
                                            iL = i47;
                                        }
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        i2 = i2;
                                        hVar6 = hVar6;
                                        i47 = i47;
                                        i49 = i49;
                                        str = str;
                                        unsafe = unsafe;
                                        i18 = iT;
                                        dbVar2 = this;
                                        if (i40 == 2) {
                                            int i58 = i.a;
                                            cm cmVar = (cm) bzVar;
                                            iL = i.m(bArr2, i47, hVar6);
                                            int i59 = hVar6.a + iL;
                                            while (iL < i59) {
                                                iL = i.p(bArr2, iL, hVar6);
                                                cmVar.f(hVar6.b);
                                            }
                                            if (iL != i59) {
                                                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        } else if (i40 == 0) {
                                            int i60 = i.a;
                                            cm cmVar2 = (cm) bzVar;
                                            iL = i.p(bArr2, i47, hVar6);
                                            cmVar2.f(hVar6.b);
                                            while (iL < i2) {
                                                int iM5 = i.m(bArr2, iL, hVar6);
                                                if (i48 == hVar6.a) {
                                                    iL = i.p(bArr2, iM5, hVar6);
                                                    cmVar2.f(hVar6.b);
                                                }
                                            }
                                        } else {
                                            iL = i47;
                                        }
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        i19 = i2;
                                        hVar6 = hVar6;
                                        i20 = i47;
                                        i49 = i49;
                                        str2 = str;
                                        unsafe = unsafe;
                                        i18 = iT;
                                        dbVar2 = this;
                                        if (i40 == 2) {
                                            i21 = i.i(bArr2, i20, bzVar, hVar6);
                                            i47 = i20;
                                            iL = i21;
                                            str = str2;
                                            i2 = i19;
                                        } else if (i40 == 0) {
                                            i47 = i20;
                                            str = str2;
                                            i2 = i19;
                                            iL = i.o(i48 == true ? 1 : 0, bArr, i47, i2, bzVar, hVar);
                                        } else {
                                            i47 = i20;
                                            str = str2;
                                            i2 = i19;
                                            iL = i47;
                                        }
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        i19 = i2;
                                        hVar6 = hVar6;
                                        i20 = i47;
                                        i49 = i49;
                                        str2 = str;
                                        unsafe = unsafe;
                                        i18 = iT;
                                        dbVar2 = this;
                                        if (i40 != 2) {
                                            if (i40 == 1) {
                                                i21 = i20 + 8;
                                                int i61 = i.a;
                                                cm cmVar3 = (cm) bzVar;
                                                cmVar3.f(i.t(bArr2, i20));
                                                while (i21 < i19) {
                                                    int iM6 = i.m(bArr2, i21, hVar6);
                                                    if (i48 == hVar6.a) {
                                                        cmVar3.f(i.t(bArr2, iM6));
                                                        i21 = iM6 + 8;
                                                    }
                                                }
                                            }
                                            i47 = i20;
                                            str = str2;
                                            i2 = i19;
                                            iL = i47;
                                            if (iL == i47) {
                                                hVar6 = hVar6;
                                                i7 = iL;
                                                i10 = i18;
                                                str = str;
                                                hVar2 = hVar6;
                                                i11 = i49;
                                                obj = obj;
                                                i5 = i48 == true ? 1 : 0;
                                                i3 = i3;
                                            } else {
                                                hVar6 = hVar6;
                                                i3 = i3;
                                                i33 = i48 == true ? 1 : 0;
                                                i32 = i18;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i35 = i49;
                                                obj = obj;
                                                hVar5 = hVar6;
                                            }
                                            unsafe2 = unsafe;
                                        } else {
                                            cm cmVar4 = (cm) bzVar;
                                            i21 = i.m(bArr2, i20, hVar6);
                                            int i62 = hVar6.a;
                                            int i63 = i21 + i62;
                                            if (i63 > bArr2.length) {
                                                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            int i64 = cmVar4.c + (i62 / 8);
                                            int length3 = cmVar4.b.length;
                                            if (i64 > length3) {
                                                if (length3 == 0) {
                                                    cmVar4.b = new long[Math.max(i64, 10)];
                                                } else {
                                                    while (length3 < i64) {
                                                        length3 = cm.g(length3);
                                                    }
                                                    cmVar4.b = Arrays.copyOf(cmVar4.b, length3);
                                                }
                                            }
                                            while (i21 < i63) {
                                                cmVar4.f(i.t(bArr2, i21));
                                                i21 += 8;
                                                i63 = i63;
                                            }
                                            if (i21 != i63) {
                                                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i47 = i20;
                                        iL = i21;
                                        str = str2;
                                        i2 = i19;
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        i19 = i2;
                                        hVar6 = hVar6;
                                        i20 = i47;
                                        i49 = i49;
                                        str2 = str;
                                        unsafe = unsafe;
                                        i18 = iT;
                                        dbVar2 = this;
                                        if (i40 != 2) {
                                            if (i40 == 5) {
                                                i21 = i20 + 4;
                                                int i65 = i.a;
                                                bj bjVar = (bj) bzVar;
                                                bjVar.i(i.e(bArr2, i20));
                                                while (i21 < i19) {
                                                    int iM7 = i.m(bArr2, i21, hVar6);
                                                    if (i48 == hVar6.a) {
                                                        bjVar.i(i.e(bArr2, iM7));
                                                        i21 = iM7 + 4;
                                                    }
                                                }
                                            }
                                            i47 = i20;
                                            str = str2;
                                            i2 = i19;
                                            iL = i47;
                                            if (iL == i47) {
                                                hVar6 = hVar6;
                                                i7 = iL;
                                                i10 = i18;
                                                str = str;
                                                hVar2 = hVar6;
                                                i11 = i49;
                                                obj = obj;
                                                i5 = i48 == true ? 1 : 0;
                                                i3 = i3;
                                            } else {
                                                hVar6 = hVar6;
                                                i3 = i3;
                                                i33 = i48 == true ? 1 : 0;
                                                i32 = i18;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i35 = i49;
                                                obj = obj;
                                                hVar5 = hVar6;
                                            }
                                            unsafe2 = unsafe;
                                        } else {
                                            bj bjVar2 = (bj) bzVar;
                                            i21 = i.m(bArr2, i20, hVar6);
                                            int i66 = hVar6.a;
                                            int i67 = i21 + i66;
                                            if (i67 > bArr2.length) {
                                                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            int i68 = bjVar2.c + (i66 / 4);
                                            int length4 = bjVar2.b.length;
                                            if (i68 > length4) {
                                                if (length4 == 0) {
                                                    bjVar2.b = new int[Math.max(i68, 10)];
                                                } else {
                                                    while (length4 < i68) {
                                                        length4 = bj.f(length4);
                                                    }
                                                    bjVar2.b = Arrays.copyOf(bjVar2.b, length4);
                                                }
                                            }
                                            while (i21 < i67) {
                                                bjVar2.i(i.e(bArr2, i21));
                                                i21 += 4;
                                            }
                                            if (i21 != i67) {
                                                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i47 = i20;
                                        iL = i21;
                                        str = str2;
                                        i2 = i19;
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                    case 25:
                                    case 42:
                                        i19 = i2;
                                        hVar6 = hVar6;
                                        i20 = i47;
                                        i49 = i49;
                                        str2 = str;
                                        unsafe = unsafe;
                                        i18 = iT;
                                        dbVar2 = this;
                                        if (i40 != 2) {
                                            if (i40 == 0) {
                                                int i69 = i.a;
                                                m mVar = (m) bzVar;
                                                i21 = i.p(bArr2, i20, hVar6);
                                                mVar.f(hVar6.b != 0);
                                                while (i21 < i19) {
                                                    int iM8 = i.m(bArr2, i21, hVar6);
                                                    if (i48 == hVar6.a) {
                                                        i21 = i.p(bArr2, iM8, hVar6);
                                                        mVar.f(hVar6.b != 0);
                                                    }
                                                }
                                            }
                                            i47 = i20;
                                            str = str2;
                                            i2 = i19;
                                            iL = i47;
                                            if (iL == i47) {
                                                hVar6 = hVar6;
                                                i7 = iL;
                                                i10 = i18;
                                                str = str;
                                                hVar2 = hVar6;
                                                i11 = i49;
                                                obj = obj;
                                                i5 = i48 == true ? 1 : 0;
                                                i3 = i3;
                                            } else {
                                                hVar6 = hVar6;
                                                i3 = i3;
                                                i33 = i48 == true ? 1 : 0;
                                                i32 = i18;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i35 = i49;
                                                obj = obj;
                                                hVar5 = hVar6;
                                            }
                                            unsafe2 = unsafe;
                                        } else {
                                            int i70 = i.a;
                                            m mVar2 = (m) bzVar;
                                            i21 = i.m(bArr2, i20, hVar6);
                                            int i71 = hVar6.a + i21;
                                            while (i21 < i71) {
                                                i21 = i.p(bArr2, i21, hVar6);
                                                mVar2.f(hVar6.b != 0);
                                            }
                                            if (i21 != i71) {
                                                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i47 = i20;
                                        iL = i21;
                                        str = str2;
                                        i2 = i19;
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                    case 26:
                                        i19 = i2;
                                        hVar6 = hVar6;
                                        i20 = i47;
                                        i49 = i49;
                                        str2 = str;
                                        unsafe = unsafe;
                                        i18 = iT;
                                        dbVar2 = this;
                                        if (i40 == 2) {
                                            if ((j & 536870912) == 0) {
                                                i21 = i.m(bArr2, i20, hVar6);
                                                int i72 = hVar6.a;
                                                if (i72 < 0) {
                                                    throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i72 == 0) {
                                                    r9 = r2;
                                                    bzVar.add(r9);
                                                } else {
                                                    r9 = r2;
                                                    bzVar.add(new String(bArr2, i21, i72, ca.a));
                                                    i21 += i72;
                                                }
                                                while (i21 < i19) {
                                                    int iM9 = i.m(bArr2, i21, hVar6);
                                                    if (i48 == hVar6.a) {
                                                        i21 = i.m(bArr2, iM9, hVar6);
                                                        int i73 = hVar6.a;
                                                        if (i73 < 0) {
                                                            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i73 == 0) {
                                                            bzVar.add(r9);
                                                        } else {
                                                            bzVar.add(new String(bArr2, i21, i73, ca.a));
                                                            i21 += i73;
                                                        }
                                                    }
                                                }
                                            } else {
                                                i21 = i.m(bArr2, i20, hVar6);
                                                int i74 = hVar6.a;
                                                if (i74 < 0) {
                                                    throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i74 == 0) {
                                                    bzVar.add("");
                                                } else {
                                                    int i75 = i21 + i74;
                                                    if (!er.i(bArr2, i21, i75)) {
                                                        throw new cc("Protocol message had invalid UTF-8.");
                                                    }
                                                    bzVar.add(new String(bArr2, i21, i74, ca.a));
                                                    i21 = i75;
                                                }
                                                while (i21 < i19) {
                                                    int iM10 = i.m(bArr2, i21, hVar6);
                                                    if (i48 == hVar6.a) {
                                                        i21 = i.m(bArr2, iM10, hVar6);
                                                        int i76 = hVar6.a;
                                                        if (i76 < 0) {
                                                            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i76 == 0) {
                                                            bzVar.add("");
                                                        } else {
                                                            int i77 = i21 + i76;
                                                            if (!er.i(bArr2, i21, i77)) {
                                                                throw new cc("Protocol message had invalid UTF-8.");
                                                            }
                                                            bzVar.add(new String(bArr2, i21, i76, ca.a));
                                                            i21 = i77;
                                                        }
                                                    }
                                                }
                                            }
                                            i47 = i20;
                                            iL = i21;
                                            str = str2;
                                            i2 = i19;
                                            if (iL == i47) {
                                                hVar6 = hVar6;
                                                i7 = iL;
                                                i10 = i18;
                                                str = str;
                                                hVar2 = hVar6;
                                                i11 = i49;
                                                obj = obj;
                                                i5 = i48 == true ? 1 : 0;
                                                i3 = i3;
                                            } else {
                                                hVar6 = hVar6;
                                                i3 = i3;
                                                i33 = i48 == true ? 1 : 0;
                                                i32 = i18;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i35 = i49;
                                                obj = obj;
                                                hVar5 = hVar6;
                                            }
                                            unsafe2 = unsafe;
                                        }
                                        i47 = i20;
                                        str = str2;
                                        i2 = i19;
                                        iL = i47;
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                    case 27:
                                        this = this;
                                        i19 = i2;
                                        hVar6 = hVar6;
                                        i47 = i47;
                                        unsafe = unsafe;
                                        i22 = iT;
                                        if (i40 == 2) {
                                            i49 = i49;
                                            i18 = i22;
                                            int iH = i.h(this.z(i22), i48 == true ? 1 : 0, bArr, i47, i2, bzVar, hVar);
                                            dbVar2 = this;
                                            str = str;
                                            i2 = i19;
                                            i47 = i47;
                                            iL = iH;
                                        } else {
                                            i49 = i49;
                                            i18 = i22;
                                            i2 = i19;
                                            i47 = i47;
                                            dbVar2 = this;
                                            str = str;
                                            iL = i47;
                                        }
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                    case 28:
                                        this = this;
                                        i19 = i2;
                                        hVar6 = hVar6;
                                        i47 = i47;
                                        unsafe = unsafe;
                                        i22 = iT;
                                        if (i40 == 2) {
                                            iL = i.m(bArr2, i47, hVar6);
                                            int i78 = hVar6.a;
                                            if (i78 < 0) {
                                                throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i78 > bArr2.length - iL) {
                                                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            if (i78 == 0) {
                                                bzVar.add(x.b);
                                            } else {
                                                bzVar.add(x.u(bArr2, iL, i78));
                                                iL += i78;
                                            }
                                            while (iL < i19) {
                                                int iM11 = i.m(bArr2, iL, hVar6);
                                                if (i48 != hVar6.a) {
                                                    i18 = i22;
                                                    i2 = i19;
                                                    i47 = i47;
                                                    dbVar2 = this;
                                                    str = str;
                                                    if (iL == i47) {
                                                        hVar6 = hVar6;
                                                        i7 = iL;
                                                        i10 = i18;
                                                        str = str;
                                                        hVar2 = hVar6;
                                                        i11 = i49;
                                                        obj = obj;
                                                        i5 = i48 == true ? 1 : 0;
                                                        i3 = i3;
                                                    } else {
                                                        hVar6 = hVar6;
                                                        i3 = i3;
                                                        i33 = i48 == true ? 1 : 0;
                                                        i32 = i18;
                                                        dbVar5 = dbVar2;
                                                        i34 = i8;
                                                        i36 = i9;
                                                        i35 = i49;
                                                        obj = obj;
                                                        hVar5 = hVar6;
                                                    }
                                                    unsafe2 = unsafe;
                                                    break;
                                                } else {
                                                    iL = i.m(bArr2, iM11, hVar6);
                                                    int i79 = hVar6.a;
                                                    if (i79 < 0) {
                                                        throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i79 > bArr2.length - iL) {
                                                        throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    if (i79 == 0) {
                                                        bzVar.add(x.b);
                                                    } else {
                                                        bzVar.add(x.u(bArr2, iL, i79));
                                                        iL += i79;
                                                    }
                                                }
                                            }
                                            i18 = i22;
                                            i2 = i19;
                                            i47 = i47;
                                            dbVar2 = this;
                                            str = str;
                                            if (iL == i47) {
                                                hVar6 = hVar6;
                                                i7 = iL;
                                                i10 = i18;
                                                str = str;
                                                hVar2 = hVar6;
                                                i11 = i49;
                                                obj = obj;
                                                i5 = i48 == true ? 1 : 0;
                                                i3 = i3;
                                            } else {
                                                hVar6 = hVar6;
                                                i3 = i3;
                                                i33 = i48 == true ? 1 : 0;
                                                i32 = i18;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i35 = i49;
                                                obj = obj;
                                                hVar5 = hVar6;
                                            }
                                            unsafe2 = unsafe;
                                        }
                                        i49 = i49;
                                        i18 = i22;
                                        i2 = i19;
                                        i47 = i47;
                                        dbVar2 = this;
                                        str = str;
                                        iL = i47;
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                    case 30:
                                    case 44:
                                        i19 = i2;
                                        if (i40 == 2) {
                                            iO = i.i(bArr2, i47, bzVar, hVar6);
                                        } else if (i40 != 0) {
                                            i18 = iT;
                                            dbVar2 = this;
                                            i2 = i19;
                                            iL = i47;
                                            if (iL == i47) {
                                                hVar6 = hVar6;
                                                i7 = iL;
                                                i10 = i18;
                                                str = str;
                                                hVar2 = hVar6;
                                                i11 = i49;
                                                obj = obj;
                                                i5 = i48 == true ? 1 : 0;
                                                i3 = i3;
                                            } else {
                                                hVar6 = hVar6;
                                                i3 = i3;
                                                i33 = i48 == true ? 1 : 0;
                                                i32 = i18;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i35 = i49;
                                                obj = obj;
                                                hVar5 = hVar6;
                                            }
                                            unsafe2 = unsafe;
                                        } else {
                                            iO = i.o(i48 == true ? 1 : 0, bArr, i47, i2, bzVar, hVar);
                                        }
                                        dt.k(obj, i49, bzVar, y(iT), null, this.f244n);
                                        i18 = iT;
                                        iL = iO;
                                        i2 = i19;
                                        i47 = i47;
                                        dbVar2 = this;
                                        str = str;
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                    case 33:
                                    case 47:
                                        i19 = i2;
                                        i23 = iT;
                                        if (i40 == 2) {
                                            int i80 = i.a;
                                            bj bjVar3 = (bj) bzVar;
                                            iM = i.m(bArr2, i47, hVar6);
                                            int i81 = hVar6.a + iM;
                                            while (iM < i81) {
                                                iM = i.m(bArr2, iM, hVar6);
                                                bjVar3.i(ac.H(hVar6.a));
                                            }
                                            if (iM != i81) {
                                                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        } else if (i40 != 0) {
                                            i18 = i23;
                                            dbVar2 = this;
                                            i2 = i19;
                                            iL = i47;
                                            if (iL == i47) {
                                                hVar6 = hVar6;
                                                i7 = iL;
                                                i10 = i18;
                                                str = str;
                                                hVar2 = hVar6;
                                                i11 = i49;
                                                obj = obj;
                                                i5 = i48 == true ? 1 : 0;
                                                i3 = i3;
                                            } else {
                                                hVar6 = hVar6;
                                                i3 = i3;
                                                i33 = i48 == true ? 1 : 0;
                                                i32 = i18;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i35 = i49;
                                                obj = obj;
                                                hVar5 = hVar6;
                                            }
                                            unsafe2 = unsafe;
                                            break;
                                        } else {
                                            int i82 = i.a;
                                            bj bjVar4 = (bj) bzVar;
                                            iM = i.m(bArr2, i47, hVar6);
                                            bjVar4.i(ac.H(hVar6.a));
                                            while (iM < i19) {
                                                int iM12 = i.m(bArr2, iM, hVar6);
                                                if (i48 == hVar6.a) {
                                                    iM = i.m(bArr2, iM12, hVar6);
                                                    bjVar4.i(ac.H(hVar6.a));
                                                }
                                            }
                                        }
                                        hVar6 = hVar6;
                                        iL = iM;
                                        i47 = i47;
                                        i49 = i49;
                                        i18 = i23;
                                        str = str;
                                        unsafe = unsafe;
                                        dbVar2 = this;
                                        i2 = i19;
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                    case 34:
                                    case 48:
                                        if (i40 == 2) {
                                            int i83 = i.a;
                                            cm cmVar5 = (cm) bzVar;
                                            int iM13 = i.m(bArr2, i47, hVar6);
                                            int i84 = hVar6.a + iM13;
                                            while (iM13 < i84) {
                                                iM13 = i.p(bArr2, iM13, hVar6);
                                                cmVar5.f(ac.I(hVar6.b));
                                            }
                                            if (iM13 != i84) {
                                                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            i2 = i2;
                                            hVar6 = hVar6;
                                            iL = iM13;
                                            i47 = i47;
                                            i49 = i49;
                                            str = str;
                                            unsafe = unsafe;
                                            i18 = iT;
                                            dbVar2 = this;
                                        } else if (i40 == 0) {
                                            int i85 = i.a;
                                            cm cmVar6 = (cm) bzVar;
                                            iM = i.p(bArr2, i47, hVar6);
                                            cmVar6.f(ac.I(hVar6.b));
                                            i19 = i2;
                                            i23 = iT;
                                            while (iM < i19) {
                                                int iM14 = i.m(bArr2, iM, hVar6);
                                                if (i48 == hVar6.a) {
                                                    iM = i.p(bArr2, iM14, hVar6);
                                                    cmVar6.f(ac.I(hVar6.b));
                                                } else {
                                                    hVar6 = hVar6;
                                                    iL = iM;
                                                    i47 = i47;
                                                    i49 = i49;
                                                    i18 = i23;
                                                    str = str;
                                                    unsafe = unsafe;
                                                    dbVar2 = this;
                                                    i2 = i19;
                                                }
                                            }
                                            hVar6 = hVar6;
                                            iL = iM;
                                            i47 = i47;
                                            i49 = i49;
                                            i18 = i23;
                                            str = str;
                                            unsafe = unsafe;
                                            dbVar2 = this;
                                            i2 = i19;
                                        } else {
                                            i2 = i2;
                                            hVar6 = hVar6;
                                            i47 = i47;
                                            i49 = i49;
                                            str = str;
                                            unsafe = unsafe;
                                            i18 = iT;
                                            dbVar2 = this;
                                            iL = i47;
                                        }
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                    default:
                                        i2 = i2;
                                        hVar6 = hVar6;
                                        i47 = i47;
                                        i49 = i49;
                                        str = str;
                                        unsafe = unsafe;
                                        i18 = iT;
                                        dbVar2 = this;
                                        if (i40 == 3) {
                                            dr drVarZ = dbVar2.z(i18);
                                            int i86 = ((i48 == true ? 1 : 0) & (-8)) | 4;
                                            iL = i.f(drVarZ, bArr, i47, i2, i86, hVar);
                                            bzVar.add(hVar6.c);
                                            while (iL < i2) {
                                                int iM15 = i.m(bArr2, iL, hVar6);
                                                if (i48 == hVar6.a) {
                                                    iL = i.f(drVarZ, bArr, iM15, i2, i86, hVar);
                                                    bzVar.add(hVar6.c);
                                                }
                                            }
                                        } else {
                                            iL = i47;
                                        }
                                        if (iL == i47) {
                                            hVar6 = hVar6;
                                            i7 = iL;
                                            i10 = i18;
                                            str = str;
                                            hVar2 = hVar6;
                                            i11 = i49;
                                            obj = obj;
                                            i5 = i48 == true ? 1 : 0;
                                            i3 = i3;
                                        } else {
                                            hVar6 = hVar6;
                                            i3 = i3;
                                            i33 = i48 == true ? 1 : 0;
                                            i32 = i18;
                                            dbVar5 = dbVar2;
                                            i34 = i8;
                                            i36 = i9;
                                            i35 = i49;
                                            obj = obj;
                                            hVar5 = hVar6;
                                        }
                                        unsafe2 = unsafe;
                                        break;
                                }
                            } else {
                                unsafe = unsafe3;
                                i11 = i49;
                                int i87 = i2;
                                hVar2 = hVar6;
                                if (iU != 50) {
                                    i10 = iT;
                                    i5 = i48 == true ? 1 : 0;
                                    Unsafe unsafe5 = b;
                                    long j2 = iArr[i10 + 2] & 1048575;
                                    switch (iU) {
                                        case 51:
                                            i27 = i47;
                                            i10 = i10;
                                            hVar2 = hVar2;
                                            i5 = i5 == true ? 1 : 0;
                                            i11 = i11;
                                            obj = obj;
                                            str = str;
                                            dbVar2 = this;
                                            if (i40 == 1) {
                                                iL = i27 + 8;
                                                unsafe5.putObject(obj, jW, Double.valueOf(i.a(bArr2, i27)));
                                                unsafe5.putInt(obj, j2, i11);
                                            } else {
                                                iL = i27;
                                            }
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                        case 52:
                                            i27 = i47;
                                            i10 = i10;
                                            hVar2 = hVar2;
                                            i5 = i5 == true ? 1 : 0;
                                            i11 = i11;
                                            obj = obj;
                                            str = str;
                                            dbVar2 = this;
                                            if (i40 == 5) {
                                                iL = i27 + 4;
                                                unsafe5.putObject(obj, jW, Float.valueOf(i.b(bArr2, i27)));
                                                unsafe5.putInt(obj, j2, i11);
                                            } else {
                                                iL = i27;
                                            }
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            i27 = i47;
                                            i10 = i10;
                                            hVar2 = hVar2;
                                            i5 = i5 == true ? 1 : 0;
                                            i11 = i11;
                                            obj = obj;
                                            str = str;
                                            dbVar2 = this;
                                            if (i40 == 0) {
                                                iL = i.p(bArr2, i27, hVar2);
                                                unsafe5.putObject(obj, jW, Long.valueOf(hVar2.b));
                                                unsafe5.putInt(obj, j2, i11);
                                            } else {
                                                iL = i27;
                                            }
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            i27 = i47;
                                            i10 = i10;
                                            hVar2 = hVar2;
                                            i5 = i5 == true ? 1 : 0;
                                            i11 = i11;
                                            obj = obj;
                                            str = str;
                                            dbVar2 = this;
                                            if (i40 == 0) {
                                                iL = i.m(bArr2, i27, hVar2);
                                                unsafe5.putObject(obj, jW, Integer.valueOf(hVar2.a));
                                                unsafe5.putInt(obj, j2, i11);
                                            } else {
                                                iL = i27;
                                            }
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                        case 56:
                                        case 65:
                                            i27 = i47;
                                            i10 = i10;
                                            hVar2 = hVar2;
                                            i5 = i5 == true ? 1 : 0;
                                            i11 = i11;
                                            obj = obj;
                                            str = str;
                                            dbVar2 = this;
                                            if (i40 == 1) {
                                                iL = i27 + 8;
                                                unsafe5.putObject(obj, jW, Long.valueOf(i.t(bArr2, i27)));
                                                unsafe5.putInt(obj, j2, i11);
                                            } else {
                                                iL = i27;
                                            }
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            i27 = i47;
                                            i10 = i10;
                                            hVar2 = hVar2;
                                            i5 = i5 == true ? 1 : 0;
                                            i11 = i11;
                                            obj = obj;
                                            str = str;
                                            dbVar2 = this;
                                            if (i40 == 5) {
                                                iL = i27 + 4;
                                                unsafe5.putObject(obj, jW, Integer.valueOf(i.e(bArr2, i27)));
                                                unsafe5.putInt(obj, j2, i11);
                                            } else {
                                                iL = i27;
                                            }
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                        case 58:
                                            i27 = i47;
                                            i10 = i10;
                                            hVar2 = hVar2;
                                            i5 = i5 == true ? 1 : 0;
                                            i11 = i11;
                                            obj = obj;
                                            str = str;
                                            dbVar2 = this;
                                            if (i40 == 0) {
                                                iL = i.p(bArr2, i27, hVar2);
                                                unsafe5.putObject(obj, jW, Boolean.valueOf(hVar2.b != 0));
                                                unsafe5.putInt(obj, j2, i11);
                                            } else {
                                                iL = i27;
                                            }
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                        case 59:
                                            i27 = i47;
                                            i10 = i10;
                                            hVar2 = hVar2;
                                            i5 = i5 == true ? 1 : 0;
                                            i11 = i11;
                                            obj = obj;
                                            str = str;
                                            dbVar2 = this;
                                            if (i40 == 2) {
                                                int iM16 = i.m(bArr2, i27, hVar2);
                                                int i88 = hVar2.a;
                                                if (i88 == 0) {
                                                    unsafe5.putObject(obj, jW, "");
                                                } else {
                                                    int i89 = iM16 + i88;
                                                    if ((i42 & PropertyOptions.DELETE_EXISTING) != 0 && !er.i(bArr2, iM16, i89)) {
                                                        throw new cc("Protocol message had invalid UTF-8.");
                                                    }
                                                    unsafe5.putObject(obj, jW, new String(bArr2, iM16, i88, ca.a));
                                                    iM16 = i89;
                                                }
                                                unsafe5.putInt(obj, j2, i11);
                                                iL = iM16;
                                            } else {
                                                iL = i27;
                                            }
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                        case 60:
                                            i28 = i47;
                                            i29 = i10;
                                            hVar3 = hVar2;
                                            str4 = str;
                                            i5 = i5 == true ? 1 : 0;
                                            i11 = i11;
                                            dbVar2 = this;
                                            obj = obj;
                                            if (i40 == 2) {
                                                Object objD = dbVar2.D(obj, i11, i29);
                                                hVar2 = hVar3;
                                                iL = i.r(objD, dbVar2.z(i29), bArr, i28, i2, hVar);
                                                dbVar2.M(obj, i11, i29, objD);
                                                i10 = i29;
                                                str = str4;
                                                i27 = i28;
                                            } else {
                                                hVar2 = hVar3;
                                                i10 = i29;
                                                str = str4;
                                                i27 = i28;
                                                iL = i27;
                                            }
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                        case 61:
                                            i28 = i47;
                                            i29 = i10;
                                            hVar3 = hVar2;
                                            str4 = str;
                                            i5 = i5 == true ? 1 : 0;
                                            i11 = i11;
                                            dbVar2 = this;
                                            obj = obj;
                                            if (i40 == 2) {
                                                iC = i.c(bArr2, i28, hVar3);
                                                unsafe5.putObject(obj, jW, hVar3.c);
                                                unsafe5.putInt(obj, j2, i11);
                                                hVar2 = hVar3;
                                                iL = iC;
                                                i10 = i29;
                                                str = str4;
                                                i27 = i28;
                                                if (iL != i27) {
                                                    i11 = i11;
                                                    str = str;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i35 = i11;
                                                    i33 = i5 == true ? 1 : 0;
                                                    dbVar5 = dbVar2;
                                                    i34 = i8;
                                                    i36 = i9;
                                                    i32 = i10;
                                                    unsafe2 = unsafe;
                                                    hVar5 = hVar2;
                                                } else {
                                                    i11 = i11;
                                                    str = str;
                                                    i3 = i3;
                                                    i7 = iL;
                                                }
                                            }
                                            hVar2 = hVar3;
                                            i10 = i29;
                                            str = str4;
                                            i27 = i28;
                                            iL = i27;
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                        case 63:
                                            i28 = i47;
                                            i29 = i10;
                                            hVar3 = hVar2;
                                            str4 = str;
                                            i11 = i11;
                                            dbVar2 = this;
                                            obj = obj;
                                            if (i40 == 0) {
                                                iC = i.m(bArr2, i28, hVar3);
                                                int i90 = hVar3.a;
                                                bo boVarY2 = dbVar2.y(i29);
                                                if (boVarY2 == null || boVarY2.a(i90)) {
                                                    i5 = i5 == true ? 1 : 0;
                                                    unsafe5.putObject(obj, jW, Integer.valueOf(i90));
                                                    unsafe5.putInt(obj, j2, i11);
                                                } else {
                                                    eg egVarD = d(obj);
                                                    Long lValueOf = Long.valueOf(i90);
                                                    i5 = i5 == true ? 1 : 0;
                                                    egVarD.e(i5 == true ? 1 : 0, lValueOf);
                                                }
                                                hVar2 = hVar3;
                                                iL = iC;
                                                i10 = i29;
                                                str = str4;
                                                i27 = i28;
                                                if (iL != i27) {
                                                    i11 = i11;
                                                    str = str;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i35 = i11;
                                                    i33 = i5 == true ? 1 : 0;
                                                    dbVar5 = dbVar2;
                                                    i34 = i8;
                                                    i36 = i9;
                                                    i32 = i10;
                                                    unsafe2 = unsafe;
                                                    hVar5 = hVar2;
                                                } else {
                                                    i11 = i11;
                                                    str = str;
                                                    i3 = i3;
                                                    i7 = iL;
                                                }
                                            } else {
                                                i5 = i5 == true ? 1 : 0;
                                                hVar2 = hVar3;
                                                i10 = i29;
                                                str = str4;
                                                i27 = i28;
                                                iL = i27;
                                                if (iL != i27) {
                                                    i11 = i11;
                                                    str = str;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i35 = i11;
                                                    i33 = i5 == true ? 1 : 0;
                                                    dbVar5 = dbVar2;
                                                    i34 = i8;
                                                    i36 = i9;
                                                    i32 = i10;
                                                    unsafe2 = unsafe;
                                                    hVar5 = hVar2;
                                                } else {
                                                    i11 = i11;
                                                    str = str;
                                                    i3 = i3;
                                                    i7 = iL;
                                                }
                                            }
                                            break;
                                        case 66:
                                            i30 = i47;
                                            i31 = i10;
                                            hVar4 = hVar2;
                                            str5 = str;
                                            i11 = i11;
                                            dbVar2 = this;
                                            obj = obj;
                                            if (i40 == 0) {
                                                iM2 = i.m(bArr2, i30, hVar4);
                                                unsafe5.putObject(obj, jW, Integer.valueOf(ac.H(hVar4.a)));
                                                unsafe5.putInt(obj, j2, i11);
                                                hVar2 = hVar4;
                                                iL = iM2;
                                                i10 = i31;
                                                i5 = i5 == true ? 1 : 0;
                                                i27 = i30;
                                                str = str5;
                                                if (iL != i27) {
                                                    i11 = i11;
                                                    str = str;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i35 = i11;
                                                    i33 = i5 == true ? 1 : 0;
                                                    dbVar5 = dbVar2;
                                                    i34 = i8;
                                                    i36 = i9;
                                                    i32 = i10;
                                                    unsafe2 = unsafe;
                                                    hVar5 = hVar2;
                                                } else {
                                                    i11 = i11;
                                                    str = str;
                                                    i3 = i3;
                                                    i7 = iL;
                                                }
                                            }
                                            hVar2 = hVar4;
                                            i10 = i31;
                                            i5 = i5 == true ? 1 : 0;
                                            i27 = i30;
                                            str = str5;
                                            iL = i27;
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                        case 67:
                                            i30 = i47;
                                            i31 = i10;
                                            hVar4 = hVar2;
                                            str5 = str;
                                            i11 = i11;
                                            dbVar2 = this;
                                            obj = obj;
                                            if (i40 == 0) {
                                                iM2 = i.p(bArr2, i30, hVar4);
                                                unsafe5.putObject(obj, jW, Long.valueOf(ac.I(hVar4.b)));
                                                unsafe5.putInt(obj, j2, i11);
                                                hVar2 = hVar4;
                                                iL = iM2;
                                                i10 = i31;
                                                i5 = i5 == true ? 1 : 0;
                                                i27 = i30;
                                                str = str5;
                                                if (iL != i27) {
                                                    i11 = i11;
                                                    str = str;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i35 = i11;
                                                    i33 = i5 == true ? 1 : 0;
                                                    dbVar5 = dbVar2;
                                                    i34 = i8;
                                                    i36 = i9;
                                                    i32 = i10;
                                                    unsafe2 = unsafe;
                                                    hVar5 = hVar2;
                                                } else {
                                                    i11 = i11;
                                                    str = str;
                                                    i3 = i3;
                                                    i7 = iL;
                                                }
                                            }
                                            hVar2 = hVar4;
                                            i10 = i31;
                                            i5 = i5 == true ? 1 : 0;
                                            i27 = i30;
                                            str = str5;
                                            iL = i27;
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                        case 68:
                                            if (i40 == 3) {
                                                int i91 = (i5 == true ? 1 : 0) & (-8);
                                                i11 = i11;
                                                obj = obj;
                                                Object objD2 = D(obj, i11, i10);
                                                int iQ2 = i.q(objD2, z(i10), bArr, i47, i2, i91 | 4, hVar);
                                                M(obj, i11, i10, objD2);
                                                hVar2 = hVar2;
                                                dbVar2 = this;
                                                i10 = i10;
                                                iL = iQ2;
                                                i5 = i5 == true ? 1 : 0;
                                                i27 = i47;
                                            } else {
                                                i27 = i47;
                                                str = str;
                                                dbVar2 = this;
                                                iL = i27;
                                            }
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                        default:
                                            i27 = i47;
                                            str = str;
                                            dbVar2 = this;
                                            iL = i27;
                                            if (iL != i27) {
                                                i11 = i11;
                                                str = str;
                                                i2 = i2;
                                                i3 = i3;
                                                i35 = i11;
                                                i33 = i5 == true ? 1 : 0;
                                                dbVar5 = dbVar2;
                                                i34 = i8;
                                                i36 = i9;
                                                i32 = i10;
                                                unsafe2 = unsafe;
                                                hVar5 = hVar2;
                                            } else {
                                                i11 = i11;
                                                str = str;
                                                i3 = i3;
                                                i7 = iL;
                                            }
                                            break;
                                    }
                                } else if (i40 == 2) {
                                    Unsafe unsafe6 = b;
                                    Object objB = B(iT);
                                    Object object = unsafe6.getObject(obj, jW);
                                    if (ct.e(object)) {
                                        Object objG = ct.g();
                                        ct.f(objG, object);
                                        unsafe6.putObject(obj, jW, objG);
                                        object = objG;
                                    }
                                    cq cqVarB = ct.b(objB);
                                    Map mapC = ct.c(object);
                                    int iM17 = i.m(bArr2, i47, hVar2);
                                    int i92 = hVar2.a;
                                    if (i92 < 0 || i92 > i87 - iM17) {
                                        throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                    }
                                    int i93 = iM17 + i92;
                                    Object obj2 = cqVarB.b;
                                    Object obj3 = cqVarB.d;
                                    while (iM17 < i93) {
                                        int iN2 = iM17 + 1;
                                        int i94 = bArr2[iM17];
                                        if (i94 < 0) {
                                            iN2 = i.n(i94, bArr2, iN2, hVar2);
                                            i94 = hVar2.a;
                                        }
                                        int i95 = i94 >>> 3;
                                        int i96 = i47;
                                        int i97 = i94 & 7;
                                        Object obj4 = obj3;
                                        if (i95 != 1) {
                                            if (i95 != 2) {
                                                str3 = str;
                                                i24 = i96;
                                                i25 = i48;
                                                i26 = i87;
                                                iM17 = i.s(i94, bArr2, iN2, i26, hVar2);
                                                obj3 = obj4;
                                            } else {
                                                es esVar = cqVarB.c;
                                                if (i97 == esVar.t) {
                                                    str3 = str;
                                                    i24 = i96;
                                                    i25 = i48;
                                                    i26 = i87;
                                                    iM17 = W(bArr, iN2, i2, esVar, cqVarB.d.getClass(), hVar);
                                                    obj3 = hVar2.c;
                                                } else {
                                                    str3 = str;
                                                    i24 = i96;
                                                    i25 = i48;
                                                    i26 = i87;
                                                }
                                            }
                                            i87 = i26;
                                            i47 = i24;
                                            i48 = i25;
                                            str = str3;
                                        } else {
                                            str3 = str;
                                            i24 = i96;
                                            i25 = i48;
                                            i26 = i87;
                                            es esVar2 = cqVarB.a;
                                            if (i97 == esVar2.t) {
                                                iM17 = W(bArr, iN2, i2, esVar2, null, hVar);
                                                Object obj5 = hVar2.c;
                                                i87 = i26;
                                                i47 = i24;
                                                obj3 = obj4;
                                                i48 = i25 == true ? 1 : 0;
                                                obj2 = obj5;
                                            }
                                            str = str3;
                                        }
                                        iM17 = i.s(i94, bArr2, iN2, i26, hVar2);
                                        obj3 = obj4;
                                        i87 = i26;
                                        i47 = i24;
                                        i48 = i25;
                                        str = str3;
                                    }
                                    int i98 = i47;
                                    Object obj6 = obj3;
                                    str = str;
                                    int i99 = i48;
                                    int i100 = i87;
                                    if (iM17 != i93) {
                                        throw new cc(str);
                                    }
                                    mapC.put(obj2, obj6);
                                    if (i93 != i98) {
                                        obj = obj;
                                        i2 = i100;
                                        i32 = iT;
                                        hVar5 = hVar2;
                                        iL = i93;
                                        i34 = i8;
                                        i33 = i99 == true ? 1 : 0;
                                        i36 = i9;
                                        unsafe2 = unsafe;
                                        i35 = i11;
                                        dbVar5 = this;
                                        i3 = i3;
                                    } else {
                                        i10 = iT;
                                        hVar2 = hVar2;
                                        i7 = i93;
                                        i5 = i99 == true ? 1 : 0;
                                        i11 = i11;
                                        str = str;
                                        dbVar2 = this;
                                    }
                                } else {
                                    i17 = iT;
                                    i7 = i47;
                                    i10 = i17;
                                    hVar2 = hVar2;
                                    i5 = i48 == true ? 1 : 0;
                                    i11 = i11;
                                    str = str;
                                    dbVar2 = this;
                                }
                            }
                        } else if (i40 == 2) {
                            bz bzVarE2 = (bz) unsafe3.getObject(obj, jW);
                            if (!bzVarE2.c()) {
                                int size2 = bzVarE2.size();
                                bzVarE2 = bzVarE2.e(size2 == 0 ? 10 : size2 + size2);
                                unsafe3.putObject(obj, jW, bzVarE2);
                            }
                            int iH2 = i.h(dbVar6.z(iT), i48 == true ? 1 : 0, bArr, i47, i2, bzVarE2, hVar);
                            i2 = i2;
                            i3 = i3;
                            hVar5 = hVar6;
                            i35 = i49;
                            unsafe2 = unsafe3;
                            i33 = i48 == true ? 1 : 0;
                            iL = iH2;
                            i36 = i9;
                            dbVar5 = dbVar6;
                            i32 = iT;
                            i34 = i8;
                        } else {
                            hVar2 = hVar6;
                            i17 = iT;
                            unsafe = unsafe3;
                            i11 = i49;
                            i7 = i47;
                            i10 = i17;
                            hVar2 = hVar2;
                            i5 = i48 == true ? 1 : 0;
                            i11 = i11;
                            str = str;
                            dbVar2 = this;
                        }
                    }
                } else {
                    i7 = iN;
                    i8 = i34;
                    i9 = i36;
                    str = "Failed to parse the message.";
                    unsafe = unsafe2;
                    hVar2 = hVar5;
                    i10 = 0;
                    i5 = i6;
                    dbVar2 = dbVar5;
                    i11 = i39;
                    i3 = i3;
                }
                if (i5 != i3 || i3 == 0) {
                    if (dbVar2.h) {
                        ar arVar = hVar2.d;
                        ar arVar2 = ar.a;
                        di diVar = di.a;
                        if (arVar != ar.a) {
                            cy cyVar = dbVar2.g;
                            ef efVar = dbVar2.f244n;
                            ar arVar3 = hVar2.d;
                            int i101 = i.a;
                            bh bhVarA = arVar3.a(cyVar, i11);
                            if (bhVarA == null) {
                                iL = i.l((i5 == true ? 1 : 0) == true ? 1 : 0, bArr, i7, i2, d(obj), hVar);
                                i12 = i5 == true ? 1 : 0;
                                dbVar3 = dbVar2;
                            } else {
                                be beVar = (be) obj;
                                beVar.g();
                                ?? r8 = i5 == true ? 1 : 0;
                                i12 = i5 == true ? 1 : 0;
                                iL = i.d(r8 == true ? 1 : 0, bArr, i7, i2, beVar, bhVarA, efVar, hVar);
                                dbVar3 = dbVar2;
                            }
                        } else {
                            i12 = i5 == true ? 1 : 0;
                            dbVar3 = dbVar2;
                            iL = i.l(i12 == true ? 1 : 0, bArr, i7, i2, d(obj), hVar);
                        }
                    } else {
                        i12 = i5 == true ? 1 : 0;
                        dbVar3 = dbVar2;
                        iL = i.l(i12 == true ? 1 : 0, bArr, i7, i2, d(obj), hVar);
                    }
                    bArr2 = bArr;
                    i2 = i2;
                    hVar5 = hVar;
                    i3 = i3;
                    dbVar5 = dbVar3;
                    i34 = i8;
                    i35 = i11;
                    i33 = i12;
                    i36 = i9;
                    i32 = i10;
                    unsafe2 = unsafe;
                } else {
                    i4 = i7;
                    dbVar = dbVar2;
                    i34 = i8;
                    i36 = i9;
                }
            } else {
                str = "Failed to parse the message.";
                unsafe = unsafe2;
                dbVar = dbVar5;
                i3 = i3;
                i4 = iL;
                i5 = i33;
            }
        }
        if (i36 != 1048575) {
            unsafe.putInt(obj, i36, i34);
        }
        Object objA = null;
        for (int i102 = dbVar.l; i102 < dbVar.m; i102++) {
            objA = A(obj, dbVar.k[i102], objA, dbVar.f244n, obj);
        }
        if (objA != null) {
            dbVar.f244n.n(obj, objA);
        }
        if (i3 != 0) {
            String str6 = str;
            if (i4 > i2 || i5 != i3) {
                throw new cc(str6);
            }
        } else if (i4 != i2) {
            throw new cc(str);
        }
        return i4;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final Object e() {
        return de.a(this.g);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0072  */
    /* JADX WARN: Code duplicated, block: B:41:0x007f A[SYNTHETIC] */
    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final void f(Object obj) {
        if (T(obj)) {
            if (obj instanceof bi) {
                bi biVar = (bi) obj;
                biVar.am = (biVar.am & Integer.MIN_VALUE) | Integer.MAX_VALUE;
                biVar.ak = 0;
                biVar.E();
            }
            int[] iArr = this.c;
            for (int i = 0; i < iArr.length; i += 3) {
                int iV = v(i);
                long jW = w(iV);
                int iU = u(iV);
                if (iU != 9) {
                    if (iU != 60 && iU != 68) {
                        switch (iU) {
                            case 17:
                                if (Q(obj, i)) {
                                    z(i).f(b.getObject(obj, jW));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                ck.b(obj, jW);
                                break;
                            case 50:
                                Unsafe unsafe = b;
                                Object object = unsafe.getObject(obj, jW);
                                if (object != null) {
                                    ct.h(object);
                                    unsafe.putObject(obj, jW, object);
                                }
                                break;
                        }
                    } else if (U(obj, p(i), i)) {
                        z(i).f(b.getObject(obj, jW));
                    }
                } else if (Q(obj, i)) {
                    z(i).f(b.getObject(obj, jW));
                }
            }
            this.f244n.m(obj);
            if (this.h) {
                this.o.f(obj);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final void g(Object obj, Object obj2) {
        F(obj);
        obj2.getClass();
        for (int i = 0; i < this.c.length; i += 3) {
            int iV = v(i);
            long jW = w(iV);
            int iP = p(i);
            switch (u(iV)) {
                case 0:
                    if (Q(obj2, i)) {
                        em.s(obj, jW, em.d(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 1:
                    if (Q(obj2, i)) {
                        em.t(obj, jW, em.e(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 2:
                    if (Q(obj2, i)) {
                        em.v(obj, jW, em.h(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 3:
                    if (Q(obj2, i)) {
                        em.v(obj, jW, em.h(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 4:
                    if (Q(obj2, i)) {
                        em.u(obj, jW, em.f(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 5:
                    if (Q(obj2, i)) {
                        em.v(obj, jW, em.h(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 6:
                    if (Q(obj2, i)) {
                        em.u(obj, jW, em.f(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 7:
                    if (Q(obj2, i)) {
                        em.o(obj, jW, em.y(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 8:
                    if (Q(obj2, i)) {
                        em.w(obj, jW, em.j(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 9:
                    G(obj, obj2, i);
                    break;
                case 10:
                    if (Q(obj2, i)) {
                        em.w(obj, jW, em.j(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 11:
                    if (Q(obj2, i)) {
                        em.u(obj, jW, em.f(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 12:
                    if (Q(obj2, i)) {
                        em.u(obj, jW, em.f(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 13:
                    if (Q(obj2, i)) {
                        em.u(obj, jW, em.f(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 14:
                    if (Q(obj2, i)) {
                        em.v(obj, jW, em.h(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 15:
                    if (Q(obj2, i)) {
                        em.u(obj, jW, em.f(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 16:
                    if (Q(obj2, i)) {
                        em.v(obj, jW, em.h(obj2, jW));
                        J(obj, i);
                    }
                    break;
                case 17:
                    G(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    ck.c(obj, obj2, jW);
                    break;
                case 50:
                    ef efVar = dt.a;
                    em.w(obj, jW, ct.f(em.j(obj, jW), em.j(obj2, jW)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (U(obj2, iP, i)) {
                        em.w(obj, jW, em.j(obj2, jW));
                        K(obj, iP, i);
                    }
                    break;
                case 60:
                    H(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (U(obj2, iP, i)) {
                        em.w(obj, jW, em.j(obj2, jW));
                        K(obj, iP, i);
                    }
                    break;
                case 68:
                    H(obj, obj2, i);
                    break;
            }
        }
        dt.n(this.f244n, obj, obj2);
        if (this.h) {
            dt.m(this.o, obj, obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:244:0x08b8 A[Catch: all -> 0x08a9, TryCatch #8 {all -> 0x08a9, blocks: (B:231:0x088a, B:242:0x08b3, B:244:0x08b8, B:245:0x08bd), top: B:282:0x088a }] */
    /* JADX WARN: Code duplicated, block: B:250:0x08cb A[LOOP:3: B:248:0x08c7->B:250:0x08cb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:252:0x08df  */
    /* JADX WARN: Code duplicated, block: B:262:0x08f4 A[LOOP:2: B:260:0x08f0->B:262:0x08f4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:264:0x0908  */
    /* JADX WARN: Code duplicated, block: B:312:0x0308 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:317:0x08c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:401:0x0302 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:416:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final void h(Object obj, dl dlVar, ar arVar) throws Throwable {
        Object obj2;
        Object obj3;
        ef efVar;
        int i;
        Object objA;
        Object objA2;
        ef efVar2;
        ef efVar3;
        Object obj4;
        ar arVar2;
        dl dlVar2;
        as asVar;
        int i2;
        Object obj5;
        ef efVar4;
        Object obj6;
        Object obj7 = obj;
        dl dlVar3 = dlVar;
        ar arVar3 = arVar;
        arVar.getClass();
        F(obj);
        ef efVar5 = this.f244n;
        as asVar2 = this.o;
        Object objC = null;
        av avVarC = null;
        while (true) {
            try {
                int iC = dlVar.c();
                int iR = r(iC);
                int i3 = Integer.MAX_VALUE;
                if (iR >= 0) {
                    efVar2 = efVar5;
                    obj3 = obj7;
                    try {
                        int iV = v(iR);
                        try {
                            int i4 = 2;
                            int i5 = 1;
                            switch (u(iV)) {
                                case 0:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    em.s(obj3, w(iV), dlVar.a());
                                    J(obj3, iR);
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 1:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    em.t(obj3, w(iV), dlVar.b());
                                    J(obj3, iR);
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 2:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    em.v(obj3, w(iV), dlVar.k());
                                    J(obj3, iR);
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 3:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    em.v(obj3, w(iV), dlVar.n());
                                    J(obj3, iR);
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 4:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    em.u(obj3, w(iV), dlVar.f());
                                    J(obj3, iR);
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 5:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    em.v(obj3, w(iV), dlVar.j());
                                    J(obj3, iR);
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 6:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    em.u(obj3, w(iV), dlVar.e());
                                    J(obj3, iR);
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 7:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    em.o(obj3, w(iV), dlVar.O());
                                    J(obj3, iR);
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 8:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    I(obj3, iV, dlVar2);
                                    J(obj3, iR);
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 9:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    cy cyVar = (cy) C(obj3, iR);
                                    dlVar2.x(cyVar, z(iR), arVar2);
                                    L(obj3, iR, cyVar);
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 10:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    em.w(obj3, w(iV), dlVar.o());
                                    J(obj3, iR);
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 11:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    em.u(obj3, w(iV), dlVar.i());
                                    J(obj3, iR);
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 12:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    asVar = asVar2;
                                    int iD = dlVar.d();
                                    bo boVarY = y(iR);
                                    if (boVarY == null || boVarY.a(iD)) {
                                        efVar = efVar2;
                                        em.u(obj3, w(iV), iD);
                                        J(obj3, iR);
                                        objC = obj5;
                                    } else {
                                        efVar = efVar2;
                                        objC = dt.l(obj3, iC, iD, obj5, efVar);
                                    }
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 13:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    em.u(obj3, w(iV), dlVar.g());
                                    J(obj3, iR);
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 14:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    em.v(obj3, w(iV), dlVar.l());
                                    J(obj3, iR);
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 15:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    em.u(obj3, w(iV), dlVar.h());
                                    J(obj3, iR);
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 16:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    em.v(obj3, w(iV), dlVar.m());
                                    J(obj3, iR);
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 17:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    cy cyVar2 = (cy) C(obj3, iR);
                                    dlVar2.w(cyVar2, z(iR), arVar2);
                                    L(obj3, iR, cyVar2);
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 18:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.z(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 19:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.D(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 20:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.F(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 21:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.M(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 22:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.E(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 23:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.C(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 24:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.B(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 25:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.y(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 26:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    if (P(iV)) {
                                        ((ad) dlVar2).K(ck.d(obj3, w(iV)), true);
                                    } else {
                                        ((ad) dlVar2).K(ck.d(obj3, w(iV)), false);
                                    }
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 27:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dr drVarZ = z(iR);
                                    List listD = ck.d(obj3, w(iV));
                                    int i6 = ((ad) dlVar2).b;
                                    if (eu.b(i6) != 2) {
                                        throw new cb();
                                    }
                                    while (true) {
                                        listD.add(((ad) dlVar2).s(drVarZ, arVar2));
                                        if (!((ad) dlVar2).a.C() && ((ad) dlVar2).c == 0) {
                                            int iM = ((ad) dlVar2).a.m();
                                            if (iM != i6) {
                                                ((ad) dlVar2).c = iM;
                                            }
                                        }
                                    }
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                    break;
                                case 28:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    List listD2 = ck.d(obj3, w(iV));
                                    if (eu.b(((ad) dlVar2).b) != 2) {
                                        throw new cb();
                                    }
                                    while (true) {
                                        listD2.add(((ad) dlVar2).o());
                                        if (!((ad) dlVar2).a.C()) {
                                            int iM2 = ((ad) dlVar2).a.m();
                                            if (iM2 != ((ad) dlVar2).b) {
                                                ((ad) dlVar2).c = iM2;
                                            }
                                        }
                                    }
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                    break;
                                case 29:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.L(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 30:
                                    arVar2 = arVar;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    List listD3 = ck.d(obj3, w(iV));
                                    dlVar2.A(listD3);
                                    objC = dt.k(obj, iC, listD3, y(iR), objC, efVar4);
                                    asVar2 = asVar;
                                    obj7 = obj3;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar4;
                                    break;
                                case 31:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.G(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 32:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.H(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 33:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.I(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 34:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.J(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 35:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.z(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 36:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.D(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 37:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.F(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 38:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.M(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 39:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.E(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 40:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.C(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 41:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.B(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 42:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.y(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 43:
                                    arVar2 = arVar;
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar4 = efVar2;
                                    asVar = asVar2;
                                    dlVar2.L(ck.d(obj3, w(iV)));
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 44:
                                    arVar2 = arVar;
                                    efVar4 = efVar2;
                                    List listD4 = ck.d(obj3, w(iV));
                                    dlVar3.A(listD4);
                                    obj2 = objC;
                                    asVar = asVar2;
                                    dlVar2 = dlVar3;
                                    try {
                                        objC = dt.k(obj, iC, listD4, y(iR), obj2, efVar4);
                                        asVar2 = asVar;
                                        obj7 = obj3;
                                        arVar3 = arVar2;
                                        dlVar3 = dlVar2;
                                        efVar5 = efVar4;
                                    } catch (cb unused) {
                                        efVar = efVar4;
                                        objC = obj2;
                                        efVar.s();
                                        if (objC == null) {
                                            objC = efVar.c(obj3);
                                        }
                                        if (!efVar.r(objC, dlVar2, 0)) {
                                            objA2 = objC;
                                            for (i2 = this.l; i2 < this.m; i2++) {
                                                objA2 = A(obj, this.k[i2], objA2, efVar, obj);
                                            }
                                            if (objA2 != null) {
                                                efVar.n(obj3, objA2);
                                            }
                                        }
                                        asVar2 = asVar;
                                        arVar3 = arVar2;
                                        dlVar3 = dlVar2;
                                        efVar5 = efVar;
                                        obj7 = obj3;
                                    } catch (Throwable th) {
                                        th = th;
                                        efVar = efVar4;
                                        objC = obj2;
                                        objA = objC;
                                        for (i = this.l; i < this.m; i++) {
                                            objA = A(obj, this.k[i], objA, efVar, obj);
                                        }
                                        if (objA != null) {
                                            efVar.n(obj3, objA);
                                        }
                                        throw th;
                                    }
                                    break;
                                case 45:
                                    arVar2 = arVar;
                                    efVar4 = efVar2;
                                    obj6 = null;
                                    dlVar3.G(ck.d(obj3, w(iV)));
                                    obj5 = objC;
                                    asVar = asVar2;
                                    dlVar2 = dlVar3;
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 46:
                                    arVar2 = arVar;
                                    efVar4 = efVar2;
                                    obj6 = null;
                                    dlVar3.H(ck.d(obj3, w(iV)));
                                    obj5 = objC;
                                    asVar = asVar2;
                                    dlVar2 = dlVar3;
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 47:
                                    arVar2 = arVar;
                                    efVar4 = efVar2;
                                    obj6 = null;
                                    dlVar3.I(ck.d(obj3, w(iV)));
                                    obj5 = objC;
                                    asVar = asVar2;
                                    dlVar2 = dlVar3;
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 48:
                                    arVar2 = arVar;
                                    efVar4 = efVar2;
                                    obj6 = null;
                                    dlVar3.J(ck.d(obj3, w(iV)));
                                    obj5 = objC;
                                    asVar = asVar2;
                                    dlVar2 = dlVar3;
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 49:
                                    arVar2 = arVar;
                                    efVar4 = efVar2;
                                    obj6 = null;
                                    long jW = w(iV);
                                    dr drVarZ2 = z(iR);
                                    List listD5 = ck.d(obj3, jW);
                                    int i7 = ((ad) dlVar3).b;
                                    if (eu.b(i7) != 3) {
                                        throw new cb();
                                    }
                                    while (true) {
                                        listD5.add(((ad) dlVar3).r(drVarZ2, arVar2));
                                        if (!((ad) dlVar3).a.C() && ((ad) dlVar3).c == 0) {
                                            int iM3 = ((ad) dlVar3).a.m();
                                            if (iM3 != i7) {
                                                ((ad) dlVar3).c = iM3;
                                            }
                                        }
                                    }
                                    obj5 = objC;
                                    asVar = asVar2;
                                    dlVar2 = dlVar3;
                                    efVar = efVar4;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                    break;
                                case 50:
                                    arVar2 = arVar;
                                    try {
                                        Object objB = B(iR);
                                        efVar4 = efVar2;
                                        try {
                                            try {
                                                long jW2 = w(v(iR));
                                                Object objJ = em.j(obj3, jW2);
                                                if (objJ == null) {
                                                    objJ = ct.g();
                                                    em.w(obj3, jW2, objJ);
                                                } else if (ct.e(objJ)) {
                                                    Object objG = ct.g();
                                                    ct.f(objG, objJ);
                                                    em.w(obj3, jW2, objG);
                                                    objJ = objG;
                                                }
                                                Map mapC = ct.c(objJ);
                                                cq cqVarB = ct.b(objB);
                                                ((ad) dlVar3).N(2);
                                                int iE = ((ad) dlVar3).a.e(((ad) dlVar3).a.n());
                                                Object objQ = cqVarB.b;
                                                Object objQ2 = cqVarB.d;
                                                while (true) {
                                                    try {
                                                        int iC2 = ((ad) dlVar3).c();
                                                        if (iC2 != i3 && !((ad) dlVar3).a.C()) {
                                                            if (iC2 == i5) {
                                                                try {
                                                                    objQ = ((ad) dlVar3).q(cqVarB.a, null, null);
                                                                } catch (cb unused2) {
                                                                    if (((ad) dlVar3).P()) {
                                                                        throw new cc("Unable to parse map entry.");
                                                                    }
                                                                }
                                                            } else if (iC2 != i4) {
                                                                try {
                                                                    if (!((ad) dlVar3).P()) {
                                                                        throw new cc("Unable to parse map entry.");
                                                                    }
                                                                } catch (cb unused3) {
                                                                    try {
                                                                        if (((ad) dlVar3).P()) {
                                                                            throw new cc("Unable to parse map entry.");
                                                                        }
                                                                    } catch (Throwable th2) {
                                                                        th = th2;
                                                                        ((ad) dlVar3).a.A(iE);
                                                                        throw th;
                                                                    }
                                                                }
                                                            } else {
                                                                objQ2 = ((ad) dlVar3).q(cqVarB.c, cqVarB.d.getClass(), arVar2);
                                                            }
                                                            i3 = Integer.MAX_VALUE;
                                                            i4 = 2;
                                                            i5 = 1;
                                                        }
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                    }
                                                }
                                                obj6 = null;
                                                mapC.put(objQ, objQ2);
                                                try {
                                                    ((ad) dlVar3).a.A(iE);
                                                    obj5 = objC;
                                                    asVar = asVar2;
                                                    dlVar2 = dlVar3;
                                                    efVar = efVar4;
                                                    objC = obj5;
                                                } catch (cb unused4) {
                                                    obj2 = objC;
                                                    asVar = asVar2;
                                                    dlVar2 = dlVar3;
                                                    efVar = efVar4;
                                                    objC = obj2;
                                                    efVar.s();
                                                    if (objC == null) {
                                                        objC = efVar.c(obj3);
                                                    }
                                                    if (!efVar.r(objC, dlVar2, 0)) {
                                                        objA2 = objC;
                                                        while (i2 < this.m) {
                                                            objA2 = A(obj, this.k[i2], objA2, efVar, obj);
                                                        }
                                                        if (objA2 != null) {
                                                            efVar.n(obj3, objA2);
                                                        }
                                                    }
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                obj2 = objC;
                                                efVar = efVar4;
                                                objC = obj2;
                                                objA = objC;
                                                while (i < this.m) {
                                                    objA = A(obj, this.k[i], objA, efVar, obj);
                                                }
                                                if (objA != null) {
                                                    efVar.n(obj3, objA);
                                                }
                                                throw th;
                                            }
                                        } catch (cb unused5) {
                                            obj2 = objC;
                                            asVar = asVar2;
                                            dlVar2 = dlVar3;
                                            efVar = efVar4;
                                            objC = obj2;
                                            efVar.s();
                                            if (objC == null) {
                                                objC = efVar.c(obj3);
                                            }
                                            if (!efVar.r(objC, dlVar2, 0)) {
                                                objA2 = objC;
                                                while (i2 < this.m) {
                                                    objA2 = A(obj, this.k[i2], objA2, efVar, obj);
                                                }
                                                if (objA2 != null) {
                                                    efVar.n(obj3, objA2);
                                                }
                                            }
                                        }
                                        asVar2 = asVar;
                                        arVar3 = arVar2;
                                        dlVar3 = dlVar2;
                                        efVar5 = efVar;
                                        obj7 = obj3;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        efVar4 = efVar2;
                                    }
                                    break;
                                case 51:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), Double.valueOf(dlVar.a()));
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 52:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), Float.valueOf(dlVar.b()));
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 53:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), Long.valueOf(dlVar.k()));
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 54:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), Long.valueOf(dlVar.n()));
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 55:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), Integer.valueOf(dlVar.f()));
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 56:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), Long.valueOf(dlVar.j()));
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 57:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), Integer.valueOf(dlVar.e()));
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 58:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), Boolean.valueOf(dlVar.O()));
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 59:
                                    arVar2 = arVar;
                                    I(obj3, iV, dlVar3);
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 60:
                                    arVar2 = arVar;
                                    cy cyVar3 = (cy) D(obj3, iC, iR);
                                    dlVar3.x(cyVar3, z(iR), arVar2);
                                    M(obj3, iC, iR, cyVar3);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 61:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), dlVar.o());
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 62:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), Integer.valueOf(dlVar.i()));
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 63:
                                    arVar2 = arVar;
                                    int iD2 = dlVar.d();
                                    bo boVarY2 = y(iR);
                                    if (boVarY2 == null || boVarY2.a(iD2)) {
                                        em.w(obj3, w(iV), Integer.valueOf(iD2));
                                        K(obj3, iC, iR);
                                        obj5 = objC;
                                        dlVar2 = dlVar3;
                                        efVar = efVar2;
                                        asVar = asVar2;
                                        objC = obj5;
                                        asVar2 = asVar;
                                        arVar3 = arVar2;
                                        dlVar3 = dlVar2;
                                        efVar5 = efVar;
                                        obj7 = obj3;
                                    } else {
                                        objC = dt.l(obj3, iC, iD2, objC, efVar2);
                                        efVar5 = efVar2;
                                        obj7 = obj3;
                                        arVar3 = arVar2;
                                    }
                                    break;
                                case 64:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), Integer.valueOf(dlVar.g()));
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 65:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), Long.valueOf(dlVar.l()));
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 66:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), Integer.valueOf(dlVar.h()));
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 67:
                                    arVar2 = arVar;
                                    em.w(obj3, w(iV), Long.valueOf(dlVar.m()));
                                    K(obj3, iC, iR);
                                    obj5 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    objC = obj5;
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                case 68:
                                    cy cyVar4 = (cy) D(obj3, iC, iR);
                                    arVar2 = arVar;
                                    try {
                                        dlVar3.w(cyVar4, z(iR), arVar2);
                                        M(obj3, iC, iR, cyVar4);
                                        obj5 = objC;
                                        dlVar2 = dlVar3;
                                        efVar = efVar2;
                                        asVar = asVar2;
                                        objC = obj5;
                                    } catch (cb unused6) {
                                        obj2 = objC;
                                        dlVar2 = dlVar3;
                                        efVar = efVar2;
                                        asVar = asVar2;
                                        objC = obj2;
                                        efVar.s();
                                        if (objC == null) {
                                            objC = efVar.c(obj3);
                                        }
                                        if (!efVar.r(objC, dlVar2, 0)) {
                                            objA2 = objC;
                                            while (i2 < this.m) {
                                                objA2 = A(obj, this.k[i2], objA2, efVar, obj);
                                            }
                                            if (objA2 != null) {
                                                efVar.n(obj3, objA2);
                                            }
                                        }
                                    }
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                                default:
                                    arVar2 = arVar;
                                    obj2 = objC;
                                    dlVar2 = dlVar3;
                                    efVar = efVar2;
                                    asVar = asVar2;
                                    if (obj2 == null) {
                                        try {
                                            objC = efVar.c(obj3);
                                        } catch (cb unused7) {
                                            objC = obj2;
                                            efVar.s();
                                            if (objC == null) {
                                                objC = efVar.c(obj3);
                                            }
                                            if (!efVar.r(objC, dlVar2, 0)) {
                                                objA2 = objC;
                                                while (i2 < this.m) {
                                                    objA2 = A(obj, this.k[i2], objA2, efVar, obj);
                                                }
                                                if (objA2 != null) {
                                                    efVar.n(obj3, objA2);
                                                }
                                            }
                                            asVar2 = asVar;
                                            arVar3 = arVar2;
                                            dlVar3 = dlVar2;
                                            efVar5 = efVar;
                                            obj7 = obj3;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            objC = obj2;
                                        }
                                    } else {
                                        objC = obj2;
                                    }
                                    try {
                                        try {
                                            if (!efVar.r(objC, dlVar2, 0)) {
                                                objA2 = objC;
                                                for (int i8 = this.l; i8 < this.m; i8++) {
                                                    objA2 = A(obj, this.k[i8], objA2, efVar, obj);
                                                }
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                        }
                                    } catch (cb unused8) {
                                        efVar.s();
                                        if (objC == null) {
                                            objC = efVar.c(obj3);
                                        }
                                        if (!efVar.r(objC, dlVar2, 0)) {
                                            objA2 = objC;
                                            while (i2 < this.m) {
                                                objA2 = A(obj, this.k[i2], objA2, efVar, obj);
                                            }
                                            if (objA2 != null) {
                                                efVar.n(obj3, objA2);
                                            }
                                        }
                                    }
                                    asVar2 = asVar;
                                    arVar3 = arVar2;
                                    dlVar3 = dlVar2;
                                    efVar5 = efVar;
                                    obj7 = obj3;
                                    break;
                            }
                        } catch (cb unused9) {
                            arVar2 = arVar;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        obj2 = objC;
                        efVar = efVar2;
                        objC = obj2;
                        objA = objC;
                        while (i < this.m) {
                            objA = A(obj, this.k[i], objA, efVar, obj);
                        }
                        if (objA != null) {
                            efVar.n(obj3, objA);
                        }
                        throw th;
                    }
                } else if (iC == Integer.MAX_VALUE) {
                    objA2 = objC;
                    for (int i9 = this.l; i9 < this.m; i9++) {
                        objA2 = A(obj, this.k[i9], objA2, efVar5, obj);
                    }
                    obj3 = obj7;
                    efVar = efVar5;
                } else {
                    try {
                        Object objD = !this.h ? null : asVar2.d(arVar3, this.g, iC);
                        if (objD != null) {
                            if (avVarC == null) {
                                avVarC = asVar2.c(obj7);
                            }
                            av avVar = avVarC;
                            efVar3 = efVar5;
                            obj4 = obj7;
                            try {
                                objC = asVar2.e(obj, dlVar, objD, arVar, avVar, objC, efVar3);
                                avVarC = avVar;
                            } catch (Throwable th9) {
                                th = th9;
                                efVar = efVar3;
                                obj2 = objC;
                                obj3 = obj4;
                                objC = obj2;
                                objA = objC;
                                while (i < this.m) {
                                    objA = A(obj, this.k[i], objA, efVar, obj);
                                }
                                if (objA != null) {
                                    efVar.n(obj3, objA);
                                }
                                throw th;
                            }
                        } else {
                            efVar3 = efVar5;
                            obj4 = obj7;
                            try {
                                efVar3.s();
                                if (objC == null) {
                                    objC = efVar3.c(obj4);
                                }
                                try {
                                    if (!efVar3.r(objC, dlVar3, 0)) {
                                        int i10 = this.l;
                                        objA2 = objC;
                                        while (i10 < this.m) {
                                            ef efVar6 = efVar3;
                                            objA2 = A(obj, this.k[i10], objA2, efVar6, obj);
                                            i10++;
                                            efVar3 = efVar6;
                                            obj4 = obj4;
                                        }
                                        obj3 = obj4;
                                        efVar = efVar3;
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    obj3 = obj4;
                                    efVar = efVar3;
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                efVar2 = efVar3;
                                obj3 = obj4;
                                obj2 = objC;
                                efVar = efVar2;
                                objC = obj2;
                            }
                        }
                        efVar5 = efVar3;
                        obj7 = obj4;
                        arVar3 = arVar;
                    } catch (Throwable th12) {
                        th = th12;
                        efVar2 = efVar5;
                        obj3 = obj7;
                    }
                }
            } catch (Throwable th13) {
                th = th13;
                obj2 = objC;
                obj3 = obj7;
                efVar = efVar5;
            }
            objA = objC;
            while (i < this.m) {
                objA = A(obj, this.k[i], objA, efVar, obj);
            }
            if (objA != null) {
                efVar.n(obj3, objA);
            }
            throw th;
        }
        if (objA2 != null) {
            efVar.n(obj3, objA2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final void i(Object obj, byte[] bArr, int i, int i2, h hVar) throws IOException {
        c(obj, bArr, i, i2, 0, hVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final void j(Object obj, ev evVar) throws IOException {
        Map.Entry entry;
        Iterator it2;
        int i;
        Map.Entry entry2;
        int i2;
        int[] iArr;
        Map.Entry entry3;
        boolean z;
        if (this.h) {
            av avVarB = this.o.b(obj);
            if (avVarB.h()) {
                entry = null;
                it2 = null;
            } else {
                Iterator itD = avVarB.d();
                entry = (Map.Entry) itD.next();
                it2 = itD;
            }
        } else {
            entry = null;
            it2 = null;
        }
        int[] iArr2 = this.c;
        Unsafe unsafe = b;
        int i3 = 1048575;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < iArr2.length) {
            int iV = v(i6);
            int iP = p(i6);
            int iU = u(iV);
            if (iU <= 17) {
                int i7 = this.c[i6 + 2];
                int i8 = i7 & i3;
                if (i8 != i4) {
                    i5 = i8 == i3 ? 0 : unsafe.getInt(obj, i8);
                    i4 = i8;
                } else {
                    entry = entry;
                }
                int i9 = 1 << (i7 >>> 20);
                i = i4;
                i2 = i9;
                entry2 = entry;
            } else {
                i = i4;
                entry2 = entry;
                i2 = 0;
            }
            int i10 = i5;
            while (entry2 != null && this.o.a(entry2) <= iP) {
                this.o.i(evVar, entry2);
                entry2 = it2.hasNext() ? (Map.Entry) it2.next() : null;
            }
            long jW = w(iV);
            switch (iU) {
                case 0:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.c(iP, em.d(obj, jW));
                    }
                    break;
                case 1:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.h(iP, em.e(obj, jW));
                    }
                    break;
                case 2:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.k(iP, unsafe.getLong(obj, jW));
                    }
                    break;
                case 3:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.u(iP, unsafe.getLong(obj, jW));
                    }
                    break;
                case 4:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.j(iP, unsafe.getInt(obj, jW));
                    }
                    break;
                case 5:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.g(iP, unsafe.getLong(obj, jW));
                    }
                    break;
                case 6:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.f(iP, unsafe.getInt(obj, jW));
                    }
                    break;
                case 7:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.a(iP, em.y(obj, jW));
                    }
                    break;
                case 8:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        X(iP, unsafe.getObject(obj, jW), evVar);
                    }
                    break;
                case 9:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.l(iP, unsafe.getObject(obj, jW), z(i6));
                    }
                    break;
                case 10:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.b(iP, (x) unsafe.getObject(obj, jW));
                    }
                    break;
                case 11:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.t(iP, unsafe.getInt(obj, jW));
                    }
                    break;
                case 12:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.e(iP, unsafe.getInt(obj, jW));
                    }
                    break;
                case 13:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.n(iP, unsafe.getInt(obj, jW));
                    }
                    break;
                case 14:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.o(iP, unsafe.getLong(obj, jW));
                    }
                    break;
                case 15:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.p(iP, unsafe.getInt(obj, jW));
                    }
                    break;
                case 16:
                    iArr = iArr2;
                    entry3 = entry2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.q(iP, unsafe.getLong(obj, jW));
                    }
                    break;
                case 17:
                    entry3 = entry2;
                    iArr = iArr2;
                    if (R(obj, i6, i, i10, i2)) {
                        evVar.i(iP, unsafe.getObject(obj, jW), z(i6));
                    }
                    break;
                case 18:
                    z = false;
                    dt.q(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 19:
                    z = false;
                    dt.u(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 20:
                    z = false;
                    dt.x(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 21:
                    z = false;
                    dt.F(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 22:
                    z = false;
                    dt.w(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 23:
                    z = false;
                    dt.t(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 24:
                    z = false;
                    dt.s(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 25:
                    z = false;
                    dt.o(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 26:
                    dt.D(p(i6), (List) unsafe.getObject(obj, jW), evVar);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 27:
                    dt.y(p(i6), (List) unsafe.getObject(obj, jW), evVar, z(i6));
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 28:
                    dt.p(p(i6), (List) unsafe.getObject(obj, jW), evVar);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 29:
                    z = false;
                    dt.E(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 30:
                    z = false;
                    dt.r(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 31:
                    z = false;
                    dt.z(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 32:
                    z = false;
                    dt.A(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 33:
                    z = false;
                    dt.B(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 34:
                    z = false;
                    dt.C(p(i6), (List) unsafe.getObject(obj, jW), evVar, false);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 35:
                    dt.q(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 36:
                    dt.u(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 37:
                    dt.x(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 38:
                    dt.F(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 39:
                    dt.w(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 40:
                    dt.t(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 41:
                    dt.s(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 42:
                    dt.o(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 43:
                    dt.E(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 44:
                    dt.r(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 45:
                    dt.z(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 46:
                    dt.A(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 47:
                    dt.B(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 48:
                    dt.C(p(i6), (List) unsafe.getObject(obj, jW), evVar, true);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 49:
                    dt.v(p(i6), (List) unsafe.getObject(obj, jW), evVar, z(i6));
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 50:
                    N(evVar, iP, unsafe.getObject(obj, jW), i6);
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 51:
                    if (U(obj, iP, i6)) {
                        evVar.c(iP, n(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 52:
                    if (U(obj, iP, i6)) {
                        evVar.h(iP, o(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 53:
                    if (U(obj, iP, i6)) {
                        evVar.k(iP, x(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 54:
                    if (U(obj, iP, i6)) {
                        evVar.u(iP, x(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 55:
                    if (U(obj, iP, i6)) {
                        evVar.j(iP, q(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 56:
                    if (U(obj, iP, i6)) {
                        evVar.g(iP, x(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 57:
                    if (U(obj, iP, i6)) {
                        evVar.f(iP, q(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 58:
                    if (U(obj, iP, i6)) {
                        evVar.a(iP, V(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 59:
                    if (U(obj, iP, i6)) {
                        X(iP, unsafe.getObject(obj, jW), evVar);
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 60:
                    if (U(obj, iP, i6)) {
                        evVar.l(iP, unsafe.getObject(obj, jW), z(i6));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 61:
                    if (U(obj, iP, i6)) {
                        evVar.b(iP, (x) unsafe.getObject(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 62:
                    if (U(obj, iP, i6)) {
                        evVar.t(iP, q(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 63:
                    if (U(obj, iP, i6)) {
                        evVar.e(iP, q(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 64:
                    if (U(obj, iP, i6)) {
                        evVar.n(iP, q(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 65:
                    if (U(obj, iP, i6)) {
                        evVar.o(iP, x(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 66:
                    if (U(obj, iP, i6)) {
                        evVar.p(iP, q(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 67:
                    if (U(obj, iP, i6)) {
                        evVar.q(iP, x(obj, jW));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                case 68:
                    if (U(obj, iP, i6)) {
                        evVar.i(iP, unsafe.getObject(obj, jW), z(i6));
                    }
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
                default:
                    iArr = iArr2;
                    entry3 = entry2;
                    break;
            }
            i6 += 3;
            i4 = i;
            entry = entry3;
            i5 = i10;
            iArr2 = iArr;
            i3 = 1048575;
        }
        while (entry != null) {
            this.o.i(evVar, entry);
            entry = it2.hasNext() ? (Map.Entry) it2.next() : null;
        }
        Y(this.f244n, obj, evVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final boolean k(Object obj, Object obj2) {
        boolean zG;
        for (int i = 0; i < this.c.length; i += 3) {
            int iV = v(i);
            long jW = w(iV);
            switch (u(iV)) {
                case 0:
                    if (!O(obj, obj2, i) || Double.doubleToLongBits(em.d(obj, jW)) != Double.doubleToLongBits(em.d(obj2, jW))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!O(obj, obj2, i) || Float.floatToIntBits(em.e(obj, jW)) != Float.floatToIntBits(em.e(obj2, jW))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!O(obj, obj2, i) || em.h(obj, jW) != em.h(obj2, jW)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!O(obj, obj2, i) || em.h(obj, jW) != em.h(obj2, jW)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!O(obj, obj2, i) || em.f(obj, jW) != em.f(obj2, jW)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!O(obj, obj2, i) || em.h(obj, jW) != em.h(obj2, jW)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!O(obj, obj2, i) || em.f(obj, jW) != em.f(obj2, jW)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!O(obj, obj2, i) || em.y(obj, jW) != em.y(obj2, jW)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!O(obj, obj2, i) || !dt.G(em.j(obj, jW), em.j(obj2, jW))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!O(obj, obj2, i) || !dt.G(em.j(obj, jW), em.j(obj2, jW))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!O(obj, obj2, i) || !dt.G(em.j(obj, jW), em.j(obj2, jW))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!O(obj, obj2, i) || em.f(obj, jW) != em.f(obj2, jW)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!O(obj, obj2, i) || em.f(obj, jW) != em.f(obj2, jW)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!O(obj, obj2, i) || em.f(obj, jW) != em.f(obj2, jW)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!O(obj, obj2, i) || em.h(obj, jW) != em.h(obj2, jW)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!O(obj, obj2, i) || em.f(obj, jW) != em.f(obj2, jW)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!O(obj, obj2, i) || em.h(obj, jW) != em.h(obj2, jW)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!O(obj, obj2, i) || !dt.G(em.j(obj, jW), em.j(obj2, jW))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zG = dt.G(em.j(obj, jW), em.j(obj2, jW));
                    break;
                case 50:
                    zG = dt.G(em.j(obj, jW), em.j(obj2, jW));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jS = s(i) & 1048575;
                    if (em.f(obj, jS) != em.f(obj2, jS) || !dt.G(em.j(obj, jW), em.j(obj2, jW))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zG) {
                return false;
            }
        }
        if (!this.f244n.d(obj).equals(this.f244n.d(obj2))) {
            return false;
        }
        if (this.h) {
            return this.o.b(obj).equals(this.o.b(obj2));
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:52:0x00db  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f1 A[LOOP:2: B:53:0x00e0->B:58:0x00f1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x00f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x010e A[SYNTHETIC] */
    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final boolean l(Object obj) {
        int i;
        int i2;
        List list;
        dr drVarZ;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.l) {
            int i7 = this.k[i5];
            int iP = p(i7);
            int iV = v(i7);
            int i8 = this.c[i7 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i6) {
                if (i9 != 1048575) {
                    i4 = b.getInt(obj, i9);
                }
                i2 = i4;
                i = i9;
            } else {
                i = i6;
                i2 = i4;
            }
            if ((268435456 & iV) != 0 && !R(obj, i7, i, i2, i10)) {
                return false;
            }
            int iU = u(iV);
            if (iU == 9 || iU == 17) {
                if (R(obj, i7, i, i2, i10) && !S(obj, iV, z(i7))) {
                    return false;
                }
            } else if (iU == 27) {
                list = (List) em.j(obj, w(iV));
                if (list.isEmpty()) {
                    continue;
                } else {
                    drVarZ = z(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!drVarZ.l(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iU == 60 || iU == 68) {
                if (U(obj, iP, i7) && !S(obj, iV, z(i7))) {
                    return false;
                }
            } else if (iU == 49) {
                list = (List) em.j(obj, w(iV));
                if (list.isEmpty()) {
                    drVarZ = z(i7);
                    while (i3 < list.size()) {
                        if (!drVarZ.l(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iU != 50) {
                continue;
            } else {
                Map mapA = ct.a(em.j(obj, w(iV)));
                if (!mapA.isEmpty() && ct.b(B(i7)).c.s == et.MESSAGE) {
                    dr drVarA = null;
                    for (Object obj2 : mapA.values()) {
                        if (drVarA == null) {
                            drVarA = di.a.a(obj2.getClass());
                        }
                        if (!drVarA.l(obj2)) {
                            return false;
                        }
                    }
                }
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.h || this.o.b(obj).i();
    }
}
