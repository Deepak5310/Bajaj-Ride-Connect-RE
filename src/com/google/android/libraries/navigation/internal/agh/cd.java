package com.google.android.libraries.navigation.internal.agh;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class cd {
    @Deprecated
    public static com.google.android.libraries.navigation.internal.agi.hd a(ce ceVar) {
        return ceVar.u();
    }

    @Deprecated
    public static /* bridge */ /* synthetic */ Object b(ce ceVar, Object obj, BiFunction biFunction) {
        ceVar.i((Long) obj, biFunction);
        return null;
    }

    @Deprecated
    public static /* bridge */ /* synthetic */ Object c(ce ceVar, Object obj, Function function) {
        ceVar.j((Long) obj, function);
        return null;
    }

    @Deprecated
    public static /* bridge */ /* synthetic */ Object d(ce ceVar, Object obj, BiFunction biFunction) {
        ceVar.k((Long) obj, biFunction);
        return null;
    }

    @Deprecated
    public static /* bridge */ /* synthetic */ Object f(ce ceVar, Object obj, Object obj2, BiFunction biFunction) {
        ceVar.m((Long) obj, (Long) obj2, biFunction);
        return null;
    }

    @Deprecated
    public static /* bridge */ /* synthetic */ Object h(ce ceVar, Object obj, Object obj2) {
        ceVar.o((Long) obj, (Long) obj2);
        return null;
    }

    @Deprecated
    public static /* bridge */ /* synthetic */ Object j(ce ceVar, Object obj, Object obj2) {
        ceVar.q((Long) obj, (Long) obj2);
        return null;
    }

    public static void l(ce ceVar, final BiConsumer biConsumer) {
        com.google.android.libraries.navigation.internal.agi.hd hdVarU = ceVar.u();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agh.cb
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                cp cpVar = (cp) obj;
                biConsumer.accept(Long.valueOf(cpVar.a()), Long.valueOf(cpVar.b()));
            }
        };
        if (hdVarU instanceof cq) {
            ((cq) hdVarU).d(consumer);
        } else {
            hdVarU.forEach(consumer);
        }
    }

    @Deprecated
    public static boolean m(ce ceVar, Object obj) {
        if (obj == null) {
            return false;
        }
        return ceVar.r(((Long) obj).longValue());
    }

    @Deprecated
    public static Long n() {
        cc.a();
        return null;
    }

    @Deprecated
    public static Long o() {
        cc.a();
        return null;
    }

    @Deprecated
    public static Long p() {
        cc.a();
        return null;
    }

    @Deprecated
    public static Long q() {
        cc.a();
        return null;
    }

    @Deprecated
    public static Long r() {
        cc.a();
        return null;
    }

    @Deprecated
    public static Long s() {
        cc.a();
        return null;
    }

    @Deprecated
    public static void t() {
        cc.a();
    }

    @Deprecated
    public static Long u() {
        cc.a();
        return null;
    }

    @Deprecated
    public static void v() {
        cc.a();
    }
}
