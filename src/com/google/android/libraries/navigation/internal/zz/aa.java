package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aa {
    private final GenericDeclaration a;
    private final String b;
    private final ev c;

    public aa(GenericDeclaration genericDeclaration, String str, Type[] typeArr) {
        ad.e(typeArr, "bound for type variable");
        ar.q(genericDeclaration);
        this.a = genericDeclaration;
        ar.q(str);
        this.b = str;
        this.c = ev.p(typeArr);
    }

    public final boolean equals(Object obj) {
        if (!x.a) {
            if (obj instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) obj;
                if (this.b.equals(typeVariable.getName()) && this.a.equals(typeVariable.getGenericDeclaration())) {
                    return true;
                }
            }
            return false;
        }
        if (obj != null && Proxy.isProxyClass(obj.getClass()) && (Proxy.getInvocationHandler(obj) instanceof ab)) {
            ab abVar = (ab) Proxy.getInvocationHandler(obj);
            int i = ab.b;
            aa aaVar = abVar.a;
            if (this.b.equals(aaVar.b) && this.a.equals(aaVar.a) && hx.i(this.c, aaVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.b;
        return str.hashCode() ^ this.a.hashCode();
    }

    public final String toString() {
        return this.b;
    }
}
