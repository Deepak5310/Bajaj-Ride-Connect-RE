package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {
    final Comparator<? super T> comparator;

    public MergerBiFunction(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0037, code lost:
    
        r3 = null;
     */
    @Override // io.reactivex.functions.BiFunction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<T> apply(List<T> list, List<T> list2) throws Exception {
        int size = list.size() + list2.size();
        if (size == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator<T> it2 = list.iterator();
        Iterator<T> it3 = list2.iterator();
        T next = it2.hasNext() ? it2.next() : null;
        if (it3.hasNext()) {
            T next2 = it3.next();
            while (next != null && next2 != null) {
                if (this.comparator.compare(next, next2) < 0) {
                    arrayList.add(next);
                    next = it2.hasNext() ? it2.next() : null;
                } else {
                    arrayList.add(next2);
                    next2 = it3.hasNext() ? it3.next() : null;
                }
            }
            if (next != null) {
                arrayList.add(next);
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            } else {
                arrayList.add(next2);
                while (it3.hasNext()) {
                    arrayList.add(it3.next());
                }
            }
            return arrayList;
        }
    }
}
