package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ex extends fs implements ho {
    private static final long serialVersionUID = 0;

    public ex(fd fdVar, int i) {
        super(fdVar, i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
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
            int i5 = ev.d;
            eq eqVar = new eq();
            for (int i6 = 0; i6 < i4; i6++) {
                eqVar.h(Objects.requireNonNull(objectInputStream.readObject()));
            }
            ezVar.f(objRequireNonNull, eqVar.g());
            i2 += i4;
        }
        try {
            fq.a.b(this, ezVar.d());
            fq.b.a(this, i2);
        } catch (IllegalArgumentException e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        mg.e(this, objectOutputStream);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ho
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final ev c(Object obj) {
        ev evVar = (ev) this.map.get(obj);
        if (evVar != null) {
            return evVar;
        }
        int i = ev.d;
        return lv.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fs, com.google.android.libraries.navigation.internal.yz.kd
    @Deprecated
    public final /* bridge */ /* synthetic */ Collection d(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ho
    @Deprecated
    /* JADX INFO: renamed from: h */
    public final /* bridge */ /* synthetic */ List d(Object obj) {
        throw null;
    }
}
