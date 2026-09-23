package com.google.android.libraries.navigation.internal.wy;

import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private static a d;
    public final c a;
    public final c b;
    public final c c;

    private a() {
        b bVar = new b();
        bVar.b(new int[]{1, 2});
        this.a = bVar.a();
        b bVar2 = new b();
        bVar2.b(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65});
        this.b = bVar2.a();
        b bVar3 = new b();
        bVar3.b(new int[]{1, 2, 3});
        this.c = bVar3.a();
    }

    public static a a() {
        if (d == null) {
            d = new a();
        }
        return d;
    }

    public static int c(ArrayList arrayList, int i) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Integer num = (Integer) arrayList.get(i2);
                if (num != null && num.intValue() <= i) {
                    return num.intValue();
                }
            }
        }
        return 0;
    }

    public final ArrayList b(int i) {
        return this.c.a(i);
    }
}
