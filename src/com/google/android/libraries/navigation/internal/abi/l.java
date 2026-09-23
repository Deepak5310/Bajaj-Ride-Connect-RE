package com.google.android.libraries.navigation.internal.abi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class l {
    private final int a;

    public l(int i) {
        this.a = i;
    }

    public abstract float a();

    public abstract float b();

    public final String toString() {
        StringBuilder sb = new StringBuilder("ScaleEvent{eventType=");
        int i = this.a;
        if (i == 0) {
            sb.append("EVENT_TYPE_ON_SCALING");
        } else if (i == 1) {
            sb.append("EVENT_TYPE_ON_SCALE_BEGIN");
        } else if (i != 2) {
            sb.append("EVENT_TYPE_ON_TWO_FINGER_TAP");
        } else {
            sb.append("EVENT_TYPE_ON_SCALE_END");
        }
        sb.append('}');
        return sb.toString();
    }
}
