package com.google.android.libraries.navigation.internal.ael;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ba implements cw {
    public static final ba a = new ba();

    private ba() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cw
    public final cv a(Class cls) {
        if (!bi.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            Class clsAsSubclass = cls.asSubclass(bi.class);
            bi biVar = (bi) bi.al.get(clsAsSubclass);
            if (biVar == null) {
                try {
                    Class.forName(clsAsSubclass.getName(), true, clsAsSubclass.getClassLoader());
                    biVar = (bi) bi.al.get(clsAsSubclass);
                } catch (ClassNotFoundException e) {
                    throw new IllegalStateException("Class initialization cannot fail.", e);
                }
            }
            if (biVar == null) {
                biVar = (bi) ((bi) em.i(clsAsSubclass)).aH(6, null);
                if (biVar == null) {
                    throw new IllegalStateException();
                }
                bi.al.put(clsAsSubclass, biVar);
            }
            return (cv) biVar.aH(3, null);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cw
    public final boolean b(Class cls) {
        return bi.class.isAssignableFrom(cls);
    }
}
