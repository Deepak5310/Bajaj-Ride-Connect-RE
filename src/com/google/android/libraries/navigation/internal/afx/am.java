package com.google.android.libraries.navigation.internal.afx;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am {
    private List a;
    private final c b = c.a;
    private Object[][] c = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

    public final ao a() {
        return new ao(this.a, this.b, this.c);
    }

    public final void b(an anVar, Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.r(anVar, "key");
        int length = 0;
        while (true) {
            Object[][] objArr = this.c;
            if (length >= objArr.length) {
                length = -1;
                break;
            } else if (anVar.equals(objArr[length][0])) {
                break;
            } else {
                length++;
            }
        }
        if (length == -1) {
            Object[][] objArr2 = this.c;
            int length2 = objArr2.length;
            Object[][] objArr3 = (Object[][]) Array.newInstance((Class<?>) Object.class, length2 + 1, 2);
            System.arraycopy(objArr2, 0, objArr3, 0, length2);
            this.c = objArr3;
            length = objArr3.length - 1;
        }
        this.c[length] = new Object[]{anVar, obj};
    }

    public final void c(List list) {
        com.google.android.libraries.navigation.internal.yx.ar.b(!list.isEmpty(), "addrs is empty");
        this.a = Collections.unmodifiableList(new ArrayList(list));
    }
}
