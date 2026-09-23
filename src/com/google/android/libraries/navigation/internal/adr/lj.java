package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum lj implements com.google.android.libraries.navigation.internal.ael.bm {
    ENTITY_TYPE_MY_LOCATION(0),
    ENTITY_TYPE_HOME(1),
    ENTITY_TYPE_WORK(2),
    ENTITY_TYPE_AD(3),
    ENTITY_TYPE_DEFAULT(4),
    ENTITY_TYPE_NICKNAME(5),
    ENTITY_TYPE_CONTACT(6);

    public final int h;

    lj(int i2) {
        this.h = i2;
    }

    public static lj b(int i2) {
        switch (i2) {
            case 0:
                return ENTITY_TYPE_MY_LOCATION;
            case 1:
                return ENTITY_TYPE_HOME;
            case 2:
                return ENTITY_TYPE_WORK;
            case 3:
                return ENTITY_TYPE_AD;
            case 4:
                return ENTITY_TYPE_DEFAULT;
            case 5:
                return ENTITY_TYPE_NICKNAME;
            case 6:
                return ENTITY_TYPE_CONTACT;
            default:
                return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.h;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.h);
    }
}
