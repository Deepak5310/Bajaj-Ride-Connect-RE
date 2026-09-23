package com.google.android.libraries.navigation.internal.hj;

import kotlin.Deprecated;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.google.android.libraries.navigation.internal.hj.f[], still in use, count: 1, list:
  (r0v1 com.google.android.libraries.navigation.internal.hj.f[]) from 0x002e: INVOKE (r0v1 com.google.android.libraries.navigation.internal.hj.f[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated(message = "Check equality against the sentinel values or type against GoogleAccount/IncognitoAccount.")
public final class f {
    UNKNOWN,
    GOOGLE,
    INCOGNITO,
    SIGNED_OUT;

    static {
        EnumEntriesKt.enumEntries(fVarArr);
    }

    private f() {
        super(str, i);
    }

    public static f[] values() {
        return (f[]) e.clone();
    }
}
