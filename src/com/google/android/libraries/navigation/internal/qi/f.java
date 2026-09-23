package com.google.android.libraries.navigation.internal.qi;

import com.google.android.libraries.geo.mapcore.internal.model.aq;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.abh.bj;
import com.google.android.libraries.navigation.internal.oe.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class f {
    public static f g(ap apVar, cg cgVar, aq aqVar, com.google.android.libraries.navigation.internal.rq.a aVar, Integer num, bj bjVar) {
        return new b(apVar, cgVar, aVar, aqVar, num.intValue(), null);
    }

    public abstract int a();

    public abstract ap b();

    public abstract aq c();

    public abstract cg d();

    public abstract com.google.android.libraries.navigation.internal.rq.a e();

    public abstract bj f();

    public abstract int hashCode();
}
