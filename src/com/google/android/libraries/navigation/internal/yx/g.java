package com.google.android.libraries.navigation.internal.yx;

import java.util.Objects;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'a' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class g {
    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    private static final /* synthetic */ g[] f;
    private final s g;
    private final String h;

    static {
        final m mVar = new m('-');
        g gVar = new g(mVar) { // from class: com.google.android.libraries.navigation.internal.yx.d
        };
        a = gVar;
        final m mVar2 = new m('_');
        g gVar2 = new g(mVar2) { // from class: com.google.android.libraries.navigation.internal.yx.e
        };
        b = gVar2;
        g gVar3 = new g("LOWER_CAMEL", 2, new l('A', 'Z'), "");
        c = gVar3;
        g gVar4 = new g("UPPER_CAMEL", 3, new l('A', 'Z'), "");
        d = gVar4;
        final m mVar3 = new m('_');
        g gVar5 = new g(mVar3) { // from class: com.google.android.libraries.navigation.internal.yx.f
            @Override // com.google.android.libraries.navigation.internal.yx.g
            public final String a(g gVar6, String str) {
                if (gVar6 == a) {
                    return c.a(str.replace('_', '-'));
                }
                return gVar6 == b ? c.a(str) : super.a(gVar6, str);
            }
        };
        e = gVar5;
        f = new g[]{gVar, gVar2, gVar3, gVar4, gVar5};
    }

    public g(String str, int i, s sVar, String str2) {
        super(str, i);
        this.g = sVar;
        this.h = str2;
    }

    private static String c(String str) {
        int i;
        if (str.isEmpty()) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (c.d(cCharAt)) {
            i = cCharAt;
            i = cCharAt ^ ' ';
        }
        i = cCharAt;
        return ((char) i) + c.a(str.substring(1));
    }

    public static g[] values() {
        return (g[]) f.clone();
    }

    public String a(g gVar, String str) {
        StringBuilder sb = null;
        int iD = -1;
        int length = 0;
        while (true) {
            iD = this.g.d(str, iD + 1);
            if (iD == -1) {
                break;
            }
            if (length == 0) {
                sb = new StringBuilder(str.length() + (gVar.h.length() * 4));
                sb.append(gVar.b(str.substring(0, iD)));
            } else {
                ((StringBuilder) Objects.requireNonNull(sb)).append(gVar.b(str.substring(length, iD)));
            }
            sb.append(gVar.h);
            length = this.h.length() + iD;
        }
        if (length == 0) {
            return gVar.b(str);
        }
        StringBuilder sb2 = (StringBuilder) Objects.requireNonNull(sb);
        sb2.append(gVar.b(str.substring(length)));
        return sb2.toString();
    }

    final String b(String str) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return c.a(str);
        }
        if (iOrdinal == 1) {
            return c.a(str);
        }
        if (iOrdinal == 2) {
            return c(str);
        }
        if (iOrdinal == 3) {
            return c(str);
        }
        if (iOrdinal == 4) {
            return c.b(str);
        }
        throw null;
    }
}
