package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Quirks {
    private final List<Quirk> mQuirks;

    public Quirks(List<Quirk> list) {
        this.mQuirks = new ArrayList(list);
    }

    public <T extends Quirk> T get(Class<T> cls) {
        Iterator<Quirk> it2 = this.mQuirks.iterator();
        while (it2.hasNext()) {
            T t = (T) it2.next();
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public boolean contains(Class<? extends Quirk> cls) {
        Iterator<Quirk> it2 = this.mQuirks.iterator();
        while (it2.hasNext()) {
            if (cls.isAssignableFrom(it2.next().getClass())) {
                return true;
            }
        }
        return false;
    }
}
