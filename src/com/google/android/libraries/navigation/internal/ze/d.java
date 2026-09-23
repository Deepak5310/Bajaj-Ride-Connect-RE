package com.google.android.libraries.navigation.internal.ze;

import android.os.Build;
import com.google.android.libraries.navigation.internal.zb.t;
import com.google.android.libraries.navigation.internal.zd.ag;
import com.google.android.libraries.navigation.internal.zd.ah;
import dalvik.system.VMStack;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends ah {
    private static final boolean a = a.a();
    private static final boolean b;
    private static final ag c;

    /* JADX INFO: compiled from: PG */
    final class a {
        a() {
        }

        static boolean a() {
            return d.t();
        }
    }

    static {
        boolean z = true;
        if (Build.FINGERPRINT != null && !"robolectric".equals(Build.FINGERPRINT)) {
            z = false;
        }
        b = z;
        c = new ag() { // from class: com.google.android.libraries.navigation.internal.ze.d.1
            @Override // com.google.android.libraries.navigation.internal.zd.ag
            public t a(Class<?> cls, int i) {
                return t.a;
            }

            @Override // com.google.android.libraries.navigation.internal.zd.ag
            public String b(Class<? extends com.google.android.libraries.navigation.internal.zb.a<?>> cls) {
                StackTraceElement stackTraceElementA;
                if (d.a) {
                    try {
                        if (cls.equals(d.p())) {
                            return VMStack.getStackClass2().getName();
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!d.b || (stackTraceElementA = com.google.android.libraries.navigation.internal.zj.a.a(cls, 1)) == null) {
                    return null;
                }
                return stackTraceElementA.getClassName();
            }
        };
    }

    static Class<?> p() {
        return VMStack.getStackClass2();
    }

    static String q() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean t() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", null);
            return a.class.getName().equals(q());
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ah
    protected com.google.android.libraries.navigation.internal.zd.j e(String str) {
        char cCharAt;
        if (i.d.get() != null) {
            return ((c) i.d.get()).a(str);
        }
        int length = str.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
            cCharAt = str.charAt(length);
            if (cCharAt == '$') {
                str = str.replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);
                break;
            }
        } while (cCharAt != '.');
        i iVar = new i(str);
        g.a.offer(iVar);
        if (i.d.get() != null) {
            while (true) {
                i iVar2 = (i) g.a.poll();
                if (iVar2 == null) {
                    break;
                }
                iVar2.e = ((c) i.d.get()).a(iVar2.a());
            }
            i.e();
        }
        return iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ah
    protected ag h() {
        return c;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ah
    protected com.google.android.libraries.navigation.internal.zg.a j() {
        return j.a;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ah
    protected String m() {
        return "platform: Android";
    }
}
