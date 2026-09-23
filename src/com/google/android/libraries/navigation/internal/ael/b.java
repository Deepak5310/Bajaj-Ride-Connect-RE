package com.google.android.libraries.navigation.internal.ael;

import com.google.android.libraries.navigation.internal.ael.b;
import com.google.android.libraries.navigation.internal.ael.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b<MessageType extends c<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> implements cx {
    private static void c(List list, int i) {
        String str = "Element at index " + (list.size() - i) + " is null.";
        int size = list.size();
        while (true) {
            size--;
            if (size < i) {
                throw new NullPointerException(str);
            }
            list.remove(size);
        }
    }

    public static void m(Iterable iterable, List list) {
        ca.e(iterable);
        if (iterable instanceof cj) {
            List listA = ((cj) iterable).a();
            cj cjVar = (cj) list;
            int size = list.size();
            for (Object obj : listA) {
                if (obj == null) {
                    String str = "Element at index " + (cjVar.size() - size) + " is null.";
                    int size2 = cjVar.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            throw new NullPointerException(str);
                        }
                        cjVar.remove(size2);
                    }
                } else if (obj instanceof x) {
                    cjVar.b();
                } else if (obj instanceof byte[]) {
                    x.t((byte[]) obj);
                    cjVar.b();
                } else {
                    cjVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof dh) {
            list.addAll((Collection) iterable);
            return;
        }
        if (iterable instanceof Collection) {
            int size3 = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size3);
            } else if (list instanceof dj) {
                ((dj) list).d(list.size() + size3);
            }
        }
        int size4 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj2 : iterable) {
                if (obj2 == null) {
                    c(list, size4);
                }
                list.add(obj2);
            }
            return;
        }
        List list2 = (List) iterable;
        int size5 = list2.size();
        for (int i = 0; i < size5; i++) {
            Object obj3 = list2.get(i);
            if (obj3 == null) {
                c(list, size4);
            }
            list.add(obj3);
        }
    }

    @Override // 
    public abstract b j();

    protected abstract b k(c cVar);

    @Override // com.google.android.libraries.navigation.internal.ael.cx
    public final /* bridge */ /* synthetic */ cx l(cy cyVar) {
        if (al().getClass().isInstance(cyVar)) {
            return k((c) cyVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    /* JADX INFO: renamed from: n */
    public abstract void o(ac acVar, ar arVar) throws IOException;

    @Override // com.google.android.libraries.navigation.internal.ael.cx
    public /* bridge */ /* synthetic */ void o(ac acVar, ar arVar) throws IOException {
        throw null;
    }
}
