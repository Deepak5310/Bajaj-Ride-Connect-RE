package com.google.android.libraries.navigation.internal.agi;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class bq {
    @Deprecated
    public static hd a(bs bsVar) {
        return bsVar.p();
    }

    @Deprecated
    public static /* bridge */ /* synthetic */ Object d(bs bsVar, Object obj, Object obj2, BiFunction biFunction) {
        bsVar.h(obj, (Integer) obj2, biFunction);
        return null;
    }

    @Deprecated
    public static /* bridge */ /* synthetic */ Object f(bs bsVar, Object obj, Object obj2) {
        bsVar.j(obj, (Integer) obj2);
        return null;
    }

    @Deprecated
    public static /* bridge */ /* synthetic */ Object h(bs bsVar, Object obj, Object obj2) {
        bsVar.l(obj, (Integer) obj2);
        return null;
    }

    public static void j(bs bsVar, final BiConsumer biConsumer) {
        hd hdVarP = bsVar.p();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agi.bo
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                br brVar = (br) obj;
                biConsumer.accept(brVar.getKey(), Integer.valueOf(brVar.a()));
            }
        };
        if (hdVarP instanceof ce) {
            ((ce) hdVarP).d(consumer);
        } else {
            hdVarP.forEach(consumer);
        }
    }

    public static void k() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static Integer l() {
        bp.a();
        return null;
    }

    @Deprecated
    public static Integer m() {
        bp.a();
        return null;
    }

    @Deprecated
    public static Integer n() {
        bp.a();
        return null;
    }

    @Deprecated
    public static void o() {
        bp.a();
    }

    @Deprecated
    public static Integer p() {
        bp.a();
        return null;
    }

    @Deprecated
    public static void q() {
        bp.a();
    }
}
