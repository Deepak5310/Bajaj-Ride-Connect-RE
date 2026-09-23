package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class gc<K, V> extends fs<K, V> implements mh<K, V> {
    private static final long serialVersionUID = 0;
    private transient fy a;
    private final transient fy<V> emptySet;

    public gc(fd fdVar, int i) {
        super(fdVar, i);
        this.emptySet = E(null);
    }

    private static fy E(Comparator comparator) {
        return comparator == null ? mb.a : gl.H(comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            throw new InvalidObjectException(com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid key count "));
        }
        ez ezVar = new ez();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object objRequireNonNull = Objects.requireNonNull(objectInputStream.readObject());
            int i4 = objectInputStream.readInt();
            if (i4 <= 0) {
                throw new InvalidObjectException(com.google.android.libraries.navigation.internal.b.b.b(i4, "Invalid value count "));
            }
            fw fwVar = comparator == null ? new fw() : new gj(comparator);
            for (int i5 = 0; i5 < i4; i5++) {
                fwVar.c(Objects.requireNonNull(objectInputStream.readObject()));
            }
            fy fyVarI = fwVar.i();
            if (fyVarI.size() != i4) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key ".concat(String.valueOf(String.valueOf(objRequireNonNull))));
            }
            ezVar.f(objRequireNonNull, fyVarI);
            i2 += i4;
        }
        try {
            fq.a.b(this, ezVar.d());
            fq.b.a(this, i2);
            gb.a.b(this, E(comparator));
        } catch (IllegalArgumentException e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        fy<V> fyVar = this.emptySet;
        objectOutputStream.writeObject(fyVar instanceof gl ? ((gl) fyVar).a : null);
        mg.e(this, objectOutputStream);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.mh
    @Deprecated
    public final /* bridge */ /* synthetic */ Set D(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fs
    public final /* bridge */ /* synthetic */ ek a(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fs, com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final fy u() {
        fy fyVar = this.a;
        if (fyVar != null) {
            return fyVar;
        }
        ga gaVar = new ga(this);
        this.a = gaVar;
        return gaVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fs, com.google.android.libraries.navigation.internal.yz.kd
    public final /* bridge */ /* synthetic */ Collection c(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fs, com.google.android.libraries.navigation.internal.yz.kd
    @Deprecated
    public final /* bridge */ /* synthetic */ Collection d(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.mh
    /* JADX INFO: renamed from: g */
    public final /* bridge */ /* synthetic */ Set u() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.mh
    /* JADX INFO: renamed from: h */
    public final /* bridge */ /* synthetic */ Set c(Object obj) {
        throw null;
    }
}
