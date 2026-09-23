package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class bi {
    public static final Comparator a = new Comparator() { // from class: com.google.android.libraries.geo.mapcore.internal.model.bg
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int iIntValue;
            int iIntValue2;
            Map.Entry entry = (Map.Entry) obj;
            Map.Entry entry2 = (Map.Entry) obj2;
            Integer num = (Integer) entry.getValue();
            Integer num2 = (Integer) entry2.getValue();
            if (num.equals(num2)) {
                iIntValue = ((Integer) entry.getKey()).intValue();
                iIntValue2 = ((Integer) entry2.getKey()).intValue();
            } else {
                iIntValue = num.intValue();
                iIntValue2 = num2.intValue();
            }
            return iIntValue - iIntValue2;
        }
    };
    public static final Comparator b = new Comparator() { // from class: com.google.android.libraries.geo.mapcore.internal.model.bh
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Map.Entry entry = (Map.Entry) obj;
            Map.Entry entry2 = (Map.Entry) obj2;
            Integer num = (Integer) entry.getValue();
            Integer num2 = (Integer) entry2.getValue();
            if (!num.equals(num2)) {
                return num2.intValue() - num.intValue();
            }
            return ((Integer) entry2.getKey()).intValue() - ((Integer) entry.getKey()).intValue();
        }
    };
    public final List c = new ArrayList();
    public final List d = new ArrayList();
    final List e = new ArrayList();

    public final void a(int i, int i2, int i3, boolean z) {
        List list = (List) this.e.get(i);
        list.add(i2, Integer.valueOf(i3));
        list.add(i2, Integer.valueOf(z ? bj.b : -bj.b));
    }
}
