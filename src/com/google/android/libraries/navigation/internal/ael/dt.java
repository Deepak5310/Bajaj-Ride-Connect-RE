package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dt {
    public static final ef a;
    private static final ef b;

    static {
        di diVar = di.a;
        b = null;
        a = new eh();
    }

    public static void A(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof cm)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.k(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += 8;
            }
            ajVar.a.w(i3);
            while (i2 < list.size()) {
                ajVar.a.l(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        cm cmVar = (cm) list;
        if (!z) {
            while (i2 < cmVar.c) {
                ((aj) evVar).a.k(i, cmVar.a(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < cmVar.c; i6++) {
            cmVar.a(i6);
            i5 += 8;
        }
        ajVar2.a.w(i5);
        while (i2 < cmVar.c) {
            ajVar2.a.l(cmVar.a(i2));
            i2++;
        }
    }

    public static void B(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof bj)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.aj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int iP = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iP += ai.P(((Integer) list.get(i3)).intValue());
            }
            ajVar.a.w(iP);
            while (i2 < list.size()) {
                ajVar.a.ak(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        bj bjVar = (bj) list;
        if (!z) {
            while (i2 < bjVar.c) {
                ((aj) evVar).a.aj(i, bjVar.d(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int iP2 = 0;
        for (int i4 = 0; i4 < bjVar.c; i4++) {
            iP2 += ai.P(bjVar.d(i4));
        }
        ajVar2.a.w(iP2);
        while (i2 < bjVar.c) {
            ajVar2.a.ak(bjVar.d(i2));
            i2++;
        }
    }

    public static void C(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof cm)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.al(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int iR = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iR += ai.R(((Long) list.get(i3)).longValue());
            }
            ajVar.a.w(iR);
            while (i2 < list.size()) {
                ajVar.a.am(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        cm cmVar = (cm) list;
        if (!z) {
            while (i2 < cmVar.c) {
                ((aj) evVar).a.al(i, cmVar.a(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int iR2 = 0;
        for (int i4 = 0; i4 < cmVar.c; i4++) {
            iR2 += ai.R(cmVar.a(i4));
        }
        ajVar2.a.w(iR2);
        while (i2 < cmVar.c) {
            ajVar2.a.am(cmVar.a(i2));
            i2++;
        }
    }

    public static void D(int i, List list, ev evVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof cj)) {
            while (i2 < list.size()) {
                ((aj) evVar).a.s(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        cj cjVar = (cj) list;
        while (i2 < list.size()) {
            Object objC = cjVar.c();
            if (objC instanceof String) {
                ((aj) evVar).a.s(i, (String) objC);
            } else {
                ((aj) evVar).a.az(i, (x) objC);
            }
            i2++;
        }
    }

    public static void E(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof bj)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.v(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int iW = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iW += ai.W(((Integer) list.get(i3)).intValue());
            }
            ajVar.a.w(iW);
            while (i2 < list.size()) {
                ajVar.a.w(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        bj bjVar = (bj) list;
        if (!z) {
            while (i2 < bjVar.c) {
                ((aj) evVar).a.v(i, bjVar.d(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int iW2 = 0;
        for (int i4 = 0; i4 < bjVar.c; i4++) {
            iW2 += ai.W(bjVar.d(i4));
        }
        ajVar2.a.w(iW2);
        while (i2 < bjVar.c) {
            ajVar2.a.w(bjVar.d(i2));
            i2++;
        }
    }

    public static void F(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof cm)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.x(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int iY = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iY += ai.Y(((Long) list.get(i3)).longValue());
            }
            ajVar.a.w(iY);
            while (i2 < list.size()) {
                ajVar.a.y(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        cm cmVar = (cm) list;
        if (!z) {
            while (i2 < cmVar.c) {
                ((aj) evVar).a.x(i, cmVar.a(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int iY2 = 0;
        for (int i4 = 0; i4 < cmVar.c; i4++) {
            iY2 += ai.Y(cmVar.a(i4));
        }
        ajVar2.a.w(iY2);
        while (i2 < cmVar.c) {
            ajVar2.a.y(cmVar.a(i2));
            i2++;
        }
    }

    static boolean G(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int H(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * ai.ap(i);
    }

    static int I(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * ai.aq(i);
    }

    static int a(List list) {
        int iG;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bj) {
            bj bjVar = (bj) list;
            iG = 0;
            while (i < size) {
                iG += ai.G(bjVar.d(i));
                i++;
            }
        } else {
            iG = 0;
            while (i < size) {
                iG += ai.G(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iG;
    }

    static int b(List list) {
        return list.size() * 4;
    }

    static int c(List list) {
        return list.size() * 8;
    }

    static int d(List list) {
        int iG;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bj) {
            bj bjVar = (bj) list;
            iG = 0;
            while (i < size) {
                iG += ai.G(bjVar.d(i));
                i++;
            }
        } else {
            iG = 0;
            while (i < size) {
                iG += ai.G(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iG;
    }

    static int e(List list) {
        int iY;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cm) {
            cm cmVar = (cm) list;
            iY = 0;
            while (i < size) {
                iY += ai.Y(cmVar.a(i));
                i++;
            }
        } else {
            iY = 0;
            while (i < size) {
                iY += ai.Y(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iY;
    }

    static int f(int i, Object obj, dr drVar) {
        return obj instanceof ci ? ai.I(i, (ci) obj) : ai.U(i) + ai.M((cy) obj, drVar);
    }

    static int g(List list) {
        int iP;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bj) {
            bj bjVar = (bj) list;
            iP = 0;
            while (i < size) {
                iP += ai.P(bjVar.d(i));
                i++;
            }
        } else {
            iP = 0;
            while (i < size) {
                iP += ai.P(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iP;
    }

    static int h(List list) {
        int iR;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cm) {
            cm cmVar = (cm) list;
            iR = 0;
            while (i < size) {
                iR += ai.R(cmVar.a(i));
                i++;
            }
        } else {
            iR = 0;
            while (i < size) {
                iR += ai.R(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iR;
    }

    static int i(List list) {
        int iW;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bj) {
            bj bjVar = (bj) list;
            iW = 0;
            while (i < size) {
                iW += ai.W(bjVar.d(i));
                i++;
            }
        } else {
            iW = 0;
            while (i < size) {
                iW += ai.W(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iW;
    }

    static int j(List list) {
        int iY;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cm) {
            cm cmVar = (cm) list;
            iY = 0;
            while (i < size) {
                iY += ai.Y(cmVar.a(i));
                i++;
            }
        } else {
            iY = 0;
            while (i < size) {
                iY += ai.Y(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iY;
    }

    static Object k(Object obj, int i, List list, bo boVar, Object obj2, ef efVar) {
        if (boVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (boVar.a(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj2 = l(obj, i, iIntValue, obj2, efVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                int iIntValue2 = ((Integer) it2.next()).intValue();
                if (!boVar.a(iIntValue2)) {
                    obj2 = l(obj, i, iIntValue2, obj2, efVar);
                    it2.remove();
                }
            }
        }
        return obj2;
    }

    static Object l(Object obj, int i, int i2, Object obj2, ef efVar) {
        if (obj2 == null) {
            obj2 = efVar.c(obj);
        }
        efVar.l(obj2, i, i2);
        return obj2;
    }

    static void m(as asVar, Object obj, Object obj2) {
        av avVarB = asVar.b(obj2);
        if (avVarB.h()) {
            return;
        }
        av avVarC = asVar.c(obj);
        int i = avVarB.b.b;
        for (int i2 = 0; i2 < i; i2++) {
            avVarC.f(avVarB.b.d(i2));
        }
        Iterator it2 = avVarB.b.a().iterator();
        while (it2.hasNext()) {
            avVarC.f((Map.Entry) it2.next());
        }
    }

    static void n(ef efVar, Object obj, Object obj2) {
        efVar.o(obj, efVar.e(efVar.d(obj), efVar.d(obj2)));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void o(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof m)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.ay(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            ajVar.a.w(i3);
            while (i2 < list.size()) {
                ajVar.a.ax(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        m mVar = (m) list;
        if (!z) {
            while (i2 < mVar.b) {
                ((aj) evVar).a.ay(i, mVar.g(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < mVar.b; i6++) {
            mVar.g(i6);
            i5++;
        }
        ajVar2.a.w(i5);
        while (i2 < mVar.b) {
            ajVar2.a.ax(mVar.g(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void p(int i, List list, ev evVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((aj) evVar).a.az(i, (x) list.get(i2));
        }
    }

    public static void q(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof ak)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.ae(i, ((Double) list.get(i2)).doubleValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += 8;
            }
            ajVar.a.w(i3);
            while (i2 < list.size()) {
                ajVar.a.af(((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        ak akVar = (ak) list;
        if (!z) {
            while (i2 < akVar.c) {
                ((aj) evVar).a.ae(i, akVar.d(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < akVar.c; i6++) {
            akVar.d(i6);
            i5 += 8;
        }
        ajVar2.a.w(i5);
        while (i2 < akVar.c) {
            ajVar2.a.af(akVar.d(i2));
            i2++;
        }
    }

    public static void r(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof bj)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.m(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int iG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iG += ai.G(((Integer) list.get(i3)).intValue());
            }
            ajVar.a.w(iG);
            while (i2 < list.size()) {
                ajVar.a.n(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        bj bjVar = (bj) list;
        if (!z) {
            while (i2 < bjVar.c) {
                ((aj) evVar).a.m(i, bjVar.d(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int iG2 = 0;
        for (int i4 = 0; i4 < bjVar.c; i4++) {
            iG2 += ai.G(bjVar.d(i4));
        }
        ajVar2.a.w(iG2);
        while (i2 < bjVar.c) {
            ajVar2.a.n(bjVar.d(i2));
            i2++;
        }
    }

    public static void s(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof bj)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.i(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += 4;
            }
            ajVar.a.w(i3);
            while (i2 < list.size()) {
                ajVar.a.j(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        bj bjVar = (bj) list;
        if (!z) {
            while (i2 < bjVar.c) {
                ((aj) evVar).a.i(i, bjVar.d(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < bjVar.c; i6++) {
            bjVar.d(i6);
            i5 += 4;
        }
        ajVar2.a.w(i5);
        while (i2 < bjVar.c) {
            ajVar2.a.j(bjVar.d(i2));
            i2++;
        }
    }

    public static void t(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof cm)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.k(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += 8;
            }
            ajVar.a.w(i3);
            while (i2 < list.size()) {
                ajVar.a.l(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        cm cmVar = (cm) list;
        if (!z) {
            while (i2 < cmVar.c) {
                ((aj) evVar).a.k(i, cmVar.a(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < cmVar.c; i6++) {
            cmVar.a(i6);
            i5 += 8;
        }
        ajVar2.a.w(i5);
        while (i2 < cmVar.c) {
            ajVar2.a.l(cmVar.a(i2));
            i2++;
        }
    }

    public static void u(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof ay)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.ag(i, ((Float) list.get(i2)).floatValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += 4;
            }
            ajVar.a.w(i3);
            while (i2 < list.size()) {
                ajVar.a.ah(((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        ay ayVar = (ay) list;
        if (!z) {
            while (i2 < ayVar.c) {
                ((aj) evVar).a.ag(i, ayVar.d(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < ayVar.c; i6++) {
            ayVar.d(i6);
            i5 += 4;
        }
        ajVar2.a.w(i5);
        while (i2 < ayVar.c) {
            ajVar2.a.ah(ayVar.d(i2));
            i2++;
        }
    }

    public static void v(int i, List list, ev evVar, dr drVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((aj) evVar).i(i, list.get(i2), drVar);
        }
    }

    public static void w(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof bj)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.m(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int iG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iG += ai.G(((Integer) list.get(i3)).intValue());
            }
            ajVar.a.w(iG);
            while (i2 < list.size()) {
                ajVar.a.n(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        bj bjVar = (bj) list;
        if (!z) {
            while (i2 < bjVar.c) {
                ((aj) evVar).a.m(i, bjVar.d(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int iG2 = 0;
        for (int i4 = 0; i4 < bjVar.c; i4++) {
            iG2 += ai.G(bjVar.d(i4));
        }
        ajVar2.a.w(iG2);
        while (i2 < bjVar.c) {
            ajVar2.a.n(bjVar.d(i2));
            i2++;
        }
    }

    public static void x(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof cm)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.x(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int iY = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iY += ai.Y(((Long) list.get(i3)).longValue());
            }
            ajVar.a.w(iY);
            while (i2 < list.size()) {
                ajVar.a.y(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        cm cmVar = (cm) list;
        if (!z) {
            while (i2 < cmVar.c) {
                ((aj) evVar).a.x(i, cmVar.a(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int iY2 = 0;
        for (int i4 = 0; i4 < cmVar.c; i4++) {
            iY2 += ai.Y(cmVar.a(i4));
        }
        ajVar2.a.w(iY2);
        while (i2 < cmVar.c) {
            ajVar2.a.y(cmVar.a(i2));
            i2++;
        }
    }

    public static void y(int i, List list, ev evVar, dr drVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((aj) evVar).l(i, list.get(i2), drVar);
        }
    }

    public static void z(int i, List list, ev evVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!(list instanceof bj)) {
            if (!z) {
                while (i2 < list.size()) {
                    ((aj) evVar).a.i(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            aj ajVar = (aj) evVar;
            ajVar.a.u(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += 4;
            }
            ajVar.a.w(i3);
            while (i2 < list.size()) {
                ajVar.a.j(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        bj bjVar = (bj) list;
        if (!z) {
            while (i2 < bjVar.c) {
                ((aj) evVar).a.i(i, bjVar.d(i2));
                i2++;
            }
            return;
        }
        aj ajVar2 = (aj) evVar;
        ajVar2.a.u(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < bjVar.c; i6++) {
            bjVar.d(i6);
            i5 += 4;
        }
        ajVar2.a.w(i5);
        while (i2 < bjVar.c) {
            ajVar2.a.j(bjVar.d(i2));
            i2++;
        }
    }
}
