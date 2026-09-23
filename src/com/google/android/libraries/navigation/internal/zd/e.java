package com.google.android.libraries.navigation.internal.zd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import kotlin.text.Typography;
import okio.Utf8;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements com.google.android.libraries.navigation.internal.zb.ab {
    private static final Set d = new HashSet(Arrays.asList(Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class));
    public final StringBuilder b;
    public boolean c = false;
    private final String e = "[CONTEXT ";
    public final String a = " ]";

    public e(StringBuilder sb) {
        this.b = sb;
    }

    private static int b(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < ' ' || cCharAt == '\"' || cCharAt == '\\') {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.zb.ab
    public final void a(String str, Object obj) {
        if (this.c) {
            this.b.append(' ');
        } else {
            StringBuilder sb = this.b;
            if (sb.length() > 0) {
                sb.append((sb.length() > 1000 || sb.indexOf("\n") != -1) ? '\n' : ' ');
            }
            this.b.append(this.e);
            this.c = true;
        }
        StringBuilder sb2 = this.b;
        sb2.append(str);
        sb2.append('=');
        if (obj == null) {
            sb2.append(true);
            return;
        }
        if (d.contains(obj.getClass())) {
            sb2.append(obj);
            return;
        }
        sb2.append(Typography.quote);
        String string = obj.toString();
        int i = 0;
        int iB = b(string, 0);
        while (iB != -1) {
            sb2.append((CharSequence) string, i, iB);
            i = iB + 1;
            char cCharAt = string.charAt(iB);
            if (cCharAt == '\t') {
                cCharAt = 't';
            } else if (cCharAt == '\n') {
                cCharAt = 'n';
            } else if (cCharAt != '\r') {
                if (cCharAt != '\"' && cCharAt != '\\') {
                    sb2.append(Utf8.REPLACEMENT_CHARACTER);
                }
                iB = b(string, i);
            } else {
                cCharAt = 'r';
            }
            sb2.append("\\");
            sb2.append(cCharAt);
            iB = b(string, i);
        }
        sb2.append((CharSequence) string, i, string.length());
        sb2.append(Typography.quote);
    }
}
