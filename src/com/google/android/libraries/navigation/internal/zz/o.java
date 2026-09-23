package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.fy;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class o extends a implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;
    public final Type a;
    private transient f b;

    public o() {
        Type typeA = a();
        this.a = typeA;
        ar.o(!(typeA instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", typeA);
    }

    public static final o e(Type type) {
        h hVar = new h(type);
        if (hVar.d().isInterface()) {
            return null;
        }
        return hVar;
    }

    public static final ev f(Type[] typeArr) {
        int i = ev.d;
        eq eqVar = new eq();
        for (Type type : typeArr) {
            h hVar = new h(type);
            if (hVar.d().isInterface()) {
                eqVar.h(hVar);
            }
        }
        return eqVar.g();
    }

    public final fy b() {
        fw fwVar = new fw();
        new g(fwVar).f(this.a);
        return fwVar.i();
    }

    public final o c(Type type) {
        f fVar = this.b;
        if (fVar == null) {
            Type type2 = this.a;
            f fVar2 = new f();
            ar.q(type2);
            b bVar = new b();
            bVar.f(type2);
            Map map = bVar.a;
            d dVar = fVar2.a;
            fd fdVarJ = fd.j(map);
            ez ezVar = new ez();
            ezVar.b(dVar.c);
            Iterator it2 = fdVarJ.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                e eVar = (e) entry.getKey();
                Type type3 = (Type) entry.getValue();
                ar.f(!eVar.b(type3), "Type variable %s bound to itself", eVar);
                ezVar.f(eVar, type3);
            }
            f fVar3 = new f(new d(ezVar.d()));
            this.b = fVar3;
            fVar = fVar3;
        }
        h hVar = new h(fVar.a(type));
        hVar.b = this.b;
        return hVar;
    }

    public final Class d() {
        return (Class) b().listIterator().next();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            return this.a.equals(((o) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return ad.b(this.a);
    }

    protected Object writeReplace() {
        return new h(new f().a(this.a));
    }

    public o(Type type) {
        ar.q(type);
        this.a = type;
    }
}
