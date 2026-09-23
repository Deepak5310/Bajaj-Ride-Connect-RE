package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class at extends as {
    @Override // com.google.android.libraries.navigation.internal.ael.as
    public final int a(Map.Entry entry) {
        return ((bg) entry.getKey()).b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.as
    public final av b(Object obj) {
        return ((be) obj).w;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.as
    public final av c(Object obj) {
        return ((be) obj).g();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.as
    public final Object d(ar arVar, cy cyVar, int i) {
        return arVar.a(cyVar, i);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.as
    public final Object e(Object obj, dl dlVar, Object obj2, ar arVar, av avVar, Object obj3, ef efVar) throws IOException {
        Object objValueOf;
        Object objK;
        bh bhVar = (bh) obj2;
        int iA = bhVar.a();
        if (bhVar.b() != es.ENUM) {
            switch (bhVar.b()) {
                case DOUBLE:
                    objValueOf = Double.valueOf(dlVar.a());
                    break;
                case FLOAT:
                    objValueOf = Float.valueOf(dlVar.b());
                    break;
                case INT64:
                    objValueOf = Long.valueOf(dlVar.k());
                    break;
                case UINT64:
                    objValueOf = Long.valueOf(dlVar.n());
                    break;
                case INT32:
                    objValueOf = Integer.valueOf(dlVar.f());
                    break;
                case FIXED64:
                    objValueOf = Long.valueOf(dlVar.j());
                    break;
                case FIXED32:
                    objValueOf = Integer.valueOf(dlVar.e());
                    break;
                case BOOL:
                    objValueOf = Boolean.valueOf(dlVar.O());
                    break;
                case STRING:
                    objValueOf = dlVar.u();
                    break;
                case GROUP:
                    if (!bhVar.f()) {
                        Object objK2 = avVar.k(bhVar.d);
                        if (objK2 instanceof bi) {
                            dr drVarB = di.a.b(objK2);
                            if (!((bi) objK2).H()) {
                                Object objE = drVarB.e();
                                drVarB.g(objE, objK2);
                                avVar.m(bhVar.d, objE);
                                objK2 = objE;
                            }
                            dlVar.w(objK2, drVarB, arVar);
                            return obj3;
                        }
                    }
                    Class<?> cls = bhVar.c.getClass();
                    ad adVar = (ad) dlVar;
                    adVar.N(3);
                    objValueOf = adVar.r(di.a.a(cls), arVar);
                    break;
                case MESSAGE:
                    if (!bhVar.f()) {
                        Object objK3 = avVar.k(bhVar.d);
                        if (objK3 instanceof bi) {
                            dr drVarB2 = di.a.b(objK3);
                            if (!((bi) objK3).H()) {
                                Object objE2 = drVarB2.e();
                                drVarB2.g(objE2, objK3);
                                avVar.m(bhVar.d, objE2);
                                objK3 = objE2;
                            }
                            dlVar.x(objK3, drVarB2, arVar);
                            return obj3;
                        }
                    }
                    objValueOf = dlVar.t(bhVar.c.getClass(), arVar);
                    break;
                case BYTES:
                    objValueOf = dlVar.o();
                    break;
                case UINT32:
                    objValueOf = Integer.valueOf(dlVar.i());
                    break;
                case ENUM:
                    throw new IllegalStateException("Shouldn't reach here.");
                case SFIXED32:
                    objValueOf = Integer.valueOf(dlVar.g());
                    break;
                case SFIXED64:
                    objValueOf = Long.valueOf(dlVar.l());
                    break;
                case SINT32:
                    objValueOf = Integer.valueOf(dlVar.h());
                    break;
                case SINT64:
                    objValueOf = Long.valueOf(dlVar.m());
                    break;
                default:
                    objValueOf = null;
                    break;
            }
        } else {
            int iF = dlVar.f();
            if (bhVar.d.a.a(iF) == null) {
                return dt.l(obj, iA, iF, obj3, efVar);
            }
            objValueOf = Integer.valueOf(iF);
        }
        if (bhVar.f()) {
            avVar.l(bhVar.d, objValueOf);
        } else {
            int iOrdinal = bhVar.b().ordinal();
            if ((iOrdinal == 9 || iOrdinal == 10) && (objK = avVar.k(bhVar.d)) != null) {
                Charset charset = ca.a;
                objValueOf = ((cy) objK).aI().l((cy) objValueOf).u();
            }
            avVar.m(bhVar.d, objValueOf);
        }
        return obj3;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.as
    public final void f(Object obj) {
        b(obj).e();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.as
    public final void g(dl dlVar, Object obj, ar arVar, av avVar) throws IOException {
        bh bhVar = (bh) obj;
        avVar.m(bhVar.d, dlVar.t(bhVar.c.getClass(), arVar));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.as
    public final void h(x xVar, Object obj, ar arVar, av avVar) throws IOException {
        bh bhVar = (bh) obj;
        cx cxVarAG = bhVar.c.aG();
        ac acVarK = xVar.k();
        cxVarAG.o(acVarK, arVar);
        avVar.m(bhVar.d, cxVarAG.u());
        acVarK.z(0);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.as
    public final void i(ev evVar, Map.Entry entry) throws IOException {
        bg bgVar = (bg) entry.getKey();
        if (!bgVar.d) {
            es esVar = es.DOUBLE;
            switch (bgVar.c) {
                case DOUBLE:
                    evVar.c(bgVar.b, ((Double) entry.getValue()).doubleValue());
                    break;
                case FLOAT:
                    evVar.h(bgVar.b, ((Float) entry.getValue()).floatValue());
                    break;
                case INT64:
                    evVar.k(bgVar.b, ((Long) entry.getValue()).longValue());
                    break;
                case UINT64:
                    evVar.u(bgVar.b, ((Long) entry.getValue()).longValue());
                    break;
                case INT32:
                    evVar.j(bgVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case FIXED64:
                    evVar.g(bgVar.b, ((Long) entry.getValue()).longValue());
                    break;
                case FIXED32:
                    evVar.f(bgVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case BOOL:
                    evVar.a(bgVar.b, ((Boolean) entry.getValue()).booleanValue());
                    break;
                case STRING:
                    evVar.s(bgVar.b, (String) entry.getValue());
                    break;
                case GROUP:
                    evVar.i(bgVar.b, entry.getValue(), di.a.a(entry.getValue().getClass()));
                    break;
                case MESSAGE:
                    evVar.l(bgVar.b, entry.getValue(), di.a.a(entry.getValue().getClass()));
                    break;
                case BYTES:
                    evVar.b(bgVar.b, (x) entry.getValue());
                    break;
                case UINT32:
                    evVar.t(bgVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case ENUM:
                    evVar.j(bgVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED32:
                    evVar.n(bgVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED64:
                    evVar.o(bgVar.b, ((Long) entry.getValue()).longValue());
                    break;
                case SINT32:
                    evVar.p(bgVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case SINT64:
                    evVar.q(bgVar.b, ((Long) entry.getValue()).longValue());
                    break;
            }
        }
        es esVar2 = es.DOUBLE;
        switch (bgVar.c) {
            case DOUBLE:
                dt.q(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
            case FLOAT:
                dt.u(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
            case INT64:
                dt.x(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
            case UINT64:
                dt.F(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
            case INT32:
                dt.w(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
            case FIXED64:
                dt.t(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
            case FIXED32:
                dt.s(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
            case BOOL:
                dt.o(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
            case STRING:
                dt.D(bgVar.b, (List) entry.getValue(), evVar);
                break;
            case GROUP:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    dt.v(bgVar.b, (List) entry.getValue(), evVar, di.a.a(list.get(0).getClass()));
                    break;
                }
                break;
            case MESSAGE:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    dt.y(bgVar.b, (List) entry.getValue(), evVar, di.a.a(list2.get(0).getClass()));
                    break;
                }
                break;
            case BYTES:
                dt.p(bgVar.b, (List) entry.getValue(), evVar);
                break;
            case UINT32:
                dt.E(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
            case ENUM:
                dt.w(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
            case SFIXED32:
                dt.z(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
            case SFIXED64:
                dt.A(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
            case SINT32:
                dt.B(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
            case SINT64:
                dt.C(bgVar.b, (List) entry.getValue(), evVar, false);
                break;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.as
    public final boolean j(cy cyVar) {
        return cyVar instanceof be;
    }
}
