package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yx.ah;
import com.google.android.libraries.navigation.internal.yx.at;
import com.google.android.libraries.navigation.internal.yx.au;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ac implements WildcardType, Serializable {
    private static final long serialVersionUID = 0;
    private final ev a;
    private final ev b;

    public ac(Type[] typeArr, Type[] typeArr2) {
        ad.e(typeArr, "lower bound for wildcard");
        ad.e(typeArr2, "upper bound for wildcard");
        this.a = w.e.a(typeArr);
        this.b = w.e.a(typeArr2);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (hx.i(this.a, Arrays.asList(wildcardType.getLowerBounds())) && hx.i(this.b, Arrays.asList(wildcardType.getUpperBounds()))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        return ad.f(this.a);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return ad.f(this.b);
    }

    public final int hashCode() {
        ev evVar = this.b;
        return evVar.hashCode() ^ this.a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("?");
        int i = 0;
        while (true) {
            ev evVar = this.a;
            if (i >= ((lv) evVar).c) {
                break;
            }
            Type type = (Type) evVar.get(i);
            sb.append(" super ");
            sb.append(w.e.b(type));
            i++;
        }
        ev evVar2 = this.b;
        ah ahVar = ad.a;
        for (Type type2 : gs.a(evVar2, new au(new at(Object.class)))) {
            sb.append(" extends ");
            sb.append(w.e.b(type2));
        }
        return sb.toString();
    }
}
