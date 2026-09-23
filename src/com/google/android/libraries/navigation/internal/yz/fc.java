package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class fc implements Serializable {
    private static final long serialVersionUID = 0;
    private final Object a;
    private final Object b;

    public fc(fd fdVar) {
        Object[] objArr = new Object[fdVar.size()];
        Object[] objArr2 = new Object[fdVar.size()];
        nn nnVarListIterator = fdVar.entrySet().listIterator();
        int i = 0;
        while (nnVarListIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) nnVarListIterator.next();
            objArr[i] = entry.getKey();
            objArr2[i] = entry.getValue();
            i++;
        }
        this.a = objArr;
        this.b = objArr2;
    }

    public ez a(int i) {
        return new ez(i);
    }

    final Object readResolve() {
        Object obj = this.a;
        if (obj instanceof fy) {
            fy fyVar = (fy) obj;
            ek ekVar = (ek) this.b;
            ez ezVarA = a(fyVar.size());
            nn nnVarListIterator = fyVar.listIterator();
            nn nnVarListIterator2 = ekVar.listIterator();
            while (nnVarListIterator.hasNext()) {
                ezVarA.f(nnVarListIterator.next(), nnVarListIterator2.next());
            }
            return ezVarA.d();
        }
        Object obj2 = this.b;
        Object[] objArr = (Object[]) obj;
        ez ezVarA2 = a(objArr.length);
        for (int i = 0; i < objArr.length; i++) {
            ezVarA2.f(objArr[i], ((Object[]) obj2)[i]);
        }
        return ezVarA2.d();
    }
}
