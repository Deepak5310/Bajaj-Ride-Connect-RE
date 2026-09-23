package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mb extends fy {
    public static final mb a;
    private static final Object[] d;
    final transient Object[] b;
    final transient Object[] c;
    private final transient int e;
    private final transient int f;
    private final transient int g;

    static {
        Object[] objArr = new Object[0];
        d = objArr;
        a = new mb(objArr, 0, objArr, 0, 0);
    }

    public mb(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.b = objArr;
        this.e = i;
        this.c = objArr2;
        this.f = i2;
        this.g = i3;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final int a(Object[] objArr, int i) {
        System.arraycopy(this.b, 0, objArr, i, this.g);
        return i + this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final int b() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final int c() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.c;
            if (objArr.length != 0) {
                int iB = eh.b(obj);
                while (true) {
                    int i = iB & this.f;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iB = i + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: e */
    public final nn listIterator() {
        return d().iterator();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final boolean f() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final Object[] g() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy
    public final boolean i() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy
    public final ev k() {
        return ev.l(this.b, this.g);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return super.writeReplace();
    }
}
