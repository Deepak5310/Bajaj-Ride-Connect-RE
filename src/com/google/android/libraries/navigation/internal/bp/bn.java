package com.google.android.libraries.navigation.internal.bp;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bn {
    public final String a;
    public final List b;
    public final com.google.android.libraries.navigation.internal.ael.x c;

    public bn(String str, List list, com.google.android.libraries.navigation.internal.ael.x xVar) {
        this.a = str;
        this.b = list;
        this.c = xVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[text: ");
        sb.append(this.a);
        sb.append(" cannedMessages(");
        for (ac acVar : this.b) {
            sb.append(StringUtils.SPACE);
            sb.append(acVar);
        }
        sb.append(" )]");
        return sb.toString();
    }
}
