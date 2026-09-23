package com.google.android.libraries.navigation.internal.yy;

/* JADX WARN: Enum visitor error
java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.nodes.MethodNode.getBasicBlocks()" is null
	at jadx.core.dex.visitors.EnumVisitor.searchEnumSuperCtrInsn(EnumVisitor.java:495)
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:473)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class aa {
    public static final aa a;
    public static final aa b;
    public static final aa c;
    public static final aa d;
    public static final aa e;
    public static final aa f;
    public static final aa g;
    public static final aa h;
    static final aa[] i;
    private static final /* synthetic */ aa[] j;

    static {
        aa aaVar = new aa("STRONG", 0);
        a = aaVar;
        aa aaVar2 = new aa() { // from class: com.google.android.libraries.navigation.internal.yy.u
            @Override // com.google.android.libraries.navigation.internal.yy.aa
            public final bj a(ao aoVar, bj bjVar, bj bjVar2, Object obj) {
                bj bjVarA = super.a(aoVar, bjVar, bjVar2, obj);
                c(bjVar, bjVarA);
                return bjVarA;
            }
        };
        b = aaVar2;
        aa aaVar3 = new aa() { // from class: com.google.android.libraries.navigation.internal.yy.v
            @Override // com.google.android.libraries.navigation.internal.yy.aa
            public final bj a(ao aoVar, bj bjVar, bj bjVar2, Object obj) {
                bj bjVarA = super.a(aoVar, bjVar, bjVar2, obj);
                d(bjVar, bjVarA);
                return bjVarA;
            }
        };
        c = aaVar3;
        aa aaVar4 = new aa() { // from class: com.google.android.libraries.navigation.internal.yy.w
            @Override // com.google.android.libraries.navigation.internal.yy.aa
            public final bj a(ao aoVar, bj bjVar, bj bjVar2, Object obj) {
                bj bjVarA = super.a(aoVar, bjVar, bjVar2, obj);
                c(bjVar, bjVarA);
                d(bjVar, bjVarA);
                return bjVarA;
            }
        };
        d = aaVar4;
        aa aaVar5 = new aa("WEAK", 4);
        e = aaVar5;
        aa aaVar6 = new aa() { // from class: com.google.android.libraries.navigation.internal.yy.x
            @Override // com.google.android.libraries.navigation.internal.yy.aa
            public final bj a(ao aoVar, bj bjVar, bj bjVar2, Object obj) {
                bj bjVarA = super.a(aoVar, bjVar, bjVar2, obj);
                c(bjVar, bjVarA);
                return bjVarA;
            }
        };
        f = aaVar6;
        aa aaVar7 = new aa() { // from class: com.google.android.libraries.navigation.internal.yy.y
            @Override // com.google.android.libraries.navigation.internal.yy.aa
            public final bj a(ao aoVar, bj bjVar, bj bjVar2, Object obj) {
                bj bjVarA = super.a(aoVar, bjVar, bjVar2, obj);
                d(bjVar, bjVarA);
                return bjVarA;
            }
        };
        g = aaVar7;
        aa aaVar8 = new aa() { // from class: com.google.android.libraries.navigation.internal.yy.z
            @Override // com.google.android.libraries.navigation.internal.yy.aa
            public final bj a(ao aoVar, bj bjVar, bj bjVar2, Object obj) {
                bj bjVarA = super.a(aoVar, bjVar, bjVar2, obj);
                c(bjVar, bjVarA);
                d(bjVar, bjVarA);
                return bjVarA;
            }
        };
        h = aaVar8;
        j = new aa[]{aaVar, aaVar2, aaVar3, aaVar4, aaVar5, aaVar6, aaVar7, aaVar8};
        i = new aa[]{aaVar, aaVar2, aaVar3, aaVar4, aaVar5, aaVar6, aaVar7, aaVar8};
    }

    public aa(String str, int i2) {
        super(str, i2);
    }

    static final void c(bj bjVar, bj bjVar2) {
        bjVar2.k(bjVar.b());
        bi.d(bjVar.h(), bjVar2);
        bi.d(bjVar2, bjVar.f());
        bi.f(bjVar);
    }

    static final void d(bj bjVar, bj bjVar2) {
        bjVar2.q(bjVar.c());
        bi.e(bjVar.i(), bjVar2);
        bi.e(bjVar2, bjVar.g());
        bi.g(bjVar);
    }

    public static aa[] values() {
        return (aa[]) j.clone();
    }

    public bj a(ao aoVar, bj bjVar, bj bjVar2, Object obj) {
        return b(aoVar, obj, bjVar.a(), bjVar2);
    }

    final bj b(ao aoVar, Object obj, int i2, bj bjVar) {
        switch (ordinal()) {
            case 0:
                return new at(obj, i2, bjVar);
            case 1:
                return new ar(obj, i2, bjVar);
            case 2:
                return new av(obj, i2, bjVar);
            case 3:
                return new as(obj, i2, bjVar);
            case 4:
                return new bb(aoVar.h, obj, i2, bjVar);
            case 5:
                return new az(aoVar.h, obj, i2, bjVar);
            case 6:
                return new bd(aoVar.h, obj, i2, bjVar);
            case 7:
                return new ba(aoVar.h, obj, i2, bjVar);
            default:
                throw null;
        }
    }
}
