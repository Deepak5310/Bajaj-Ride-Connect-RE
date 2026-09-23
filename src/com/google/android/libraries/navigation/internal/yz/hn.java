package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hn extends an implements Serializable, ho {
    private static final long serialVersionUID = 0;
    public transient hk a;
    public transient hk b;
    public transient Map c;
    public transient int d;
    public transient int e;

    public hn() {
        this(12);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.c = new cg();
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            t(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.d);
        for (Map.Entry entry : u()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    public final boolean A() {
        return this.a == null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    public final /* bridge */ /* synthetic */ boolean C(Object obj, Object obj2) {
        throw null;
    }

    public final hk a(Object obj, Object obj2, hk hkVar) {
        hk hkVar2 = new hk(obj, obj2);
        if (this.a == null) {
            this.b = hkVar2;
            this.a = hkVar2;
            this.c.put(obj, new hj(hkVar2));
            this.e++;
        } else if (hkVar == null) {
            ((hk) Objects.requireNonNull(this.b)).c = hkVar2;
            hkVar2.d = this.b;
            this.b = hkVar2;
            hj hjVar = (hj) this.c.get(obj);
            if (hjVar == null) {
                this.c.put(obj, new hj(hkVar2));
                this.e++;
            } else {
                hjVar.c++;
                hk hkVar3 = hjVar.b;
                hkVar3.e = hkVar2;
                hkVar2.f = hkVar3;
                hjVar.b = hkVar2;
            }
        } else {
            hj hjVar2 = (hj) Objects.requireNonNull((hj) this.c.get(obj));
            hjVar2.c++;
            hkVar2.d = hkVar.d;
            hkVar2.f = hkVar.f;
            hkVar2.c = hkVar;
            hkVar2.e = hkVar;
            hk hkVar4 = hkVar.f;
            if (hkVar4 == null) {
                hjVar2.a = hkVar2;
            } else {
                hkVar4.e = hkVar2;
            }
            hk hkVar5 = hkVar.d;
            if (hkVar5 == null) {
                this.a = hkVar2;
            } else {
                hkVar5.c = hkVar2;
            }
            hkVar.d = hkVar2;
            hkVar.f = hkVar2;
        }
        this.d++;
        return hkVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final List u() {
        return (List) super.u();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final /* synthetic */ Collection c(Object obj) {
        return new hd(this, obj);
    }

    public final void e(Object obj) {
        hb.e(new hm(this, obj));
    }

    public final void f(hk hkVar) {
        hk hkVar2 = hkVar.d;
        if (hkVar2 != null) {
            hkVar2.c = hkVar.c;
        } else {
            this.a = hkVar.c;
        }
        hk hkVar3 = hkVar.c;
        if (hkVar3 != null) {
            hkVar3.d = hkVar2;
        } else {
            this.b = hkVar2;
        }
        if (hkVar.f == null && hkVar.e == null) {
            ((hj) Objects.requireNonNull((hj) this.c.remove(hkVar.a))).c = 0;
            this.e++;
        } else {
            hj hjVar = (hj) Objects.requireNonNull((hj) this.c.get(hkVar.a));
            hjVar.c--;
            hk hkVar4 = hkVar.f;
            if (hkVar4 == null) {
                hjVar.a = (hk) Objects.requireNonNull(hkVar.e);
            } else {
                hkVar4.e = hkVar.e;
            }
            hk hkVar5 = hkVar.e;
            if (hkVar5 == null) {
                hjVar.b = (hk) Objects.requireNonNull(hkVar.f);
            } else {
                hkVar5.f = hkVar.f;
            }
        }
        this.d--;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ho
    /* JADX INFO: renamed from: g */
    public final List c(Object obj) {
        return new hd(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final List d(Object obj) {
        List listUnmodifiableList = Collections.unmodifiableList(hx.c(new hm(this, obj)));
        e(obj);
        return listUnmodifiableList;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final int i() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final /* synthetic */ Collection j() {
        return new he(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final /* synthetic */ Collection k() {
        return new hh(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final Iterator l() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final Map o() {
        return new km(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final Set p() {
        return new hf(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final void q() {
        this.a = null;
        this.b = null;
        this.c.clear();
        this.d = 0;
        this.e++;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final boolean s(Object obj) {
        return this.c.containsKey(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    public final boolean t(Object obj, Object obj2) {
        a(obj, obj2, null);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    public final /* bridge */ /* synthetic */ boolean y(Object obj, Object obj2) {
        throw null;
    }

    public hn(int i) {
        this.c = new cc(i);
    }

    public hn(kd kdVar) {
        this(kdVar.x().size());
        B(kdVar);
    }
}
