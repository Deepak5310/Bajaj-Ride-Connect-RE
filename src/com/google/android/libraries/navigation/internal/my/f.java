package com.google.android.libraries.navigation.internal.my;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class f {
    private final Map a = new HashMap();
    private final Map b = new WeakHashMap();
    private final ReferenceQueue c = new ReferenceQueue();

    private final void d() {
        while (true) {
            Reference referencePoll = this.c.poll();
            if (referencePoll == null) {
                return;
            }
            Object objRemove = this.b.remove(referencePoll);
            if (objRemove != null) {
                this.a.remove(objRemove);
            }
        }
    }

    protected abstract Reference a(Object obj, ReferenceQueue referenceQueue);

    public final Object b(Object obj) {
        d();
        Reference reference = (Reference) this.a.get(obj);
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public final void c(Object obj, Object obj2) {
        d();
        Reference reference = (Reference) this.a.get(obj);
        if (reference != null) {
            this.b.remove(reference);
        }
        Reference referenceA = a(obj2, this.c);
        this.a.put(obj, referenceA);
        this.b.put(referenceA, obj);
    }
}
