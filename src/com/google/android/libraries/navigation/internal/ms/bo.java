package com.google.android.libraries.navigation.internal.ms;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import androidx.tracing.Trace;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bo implements co {
    public static final Class[] a;
    public static final Class[] b;
    public static final Class[] c;
    private static final Method d;
    private static final Method e;
    private static final Method f;
    private static final SimpleArrayMap g = new SimpleArrayMap();
    private final Context h;
    private final com.google.android.libraries.navigation.internal.my.a i;

    static {
        try {
            Method declaredMethod = ViewGroup.class.getDeclaredMethod("generateDefaultLayoutParams", null);
            d = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = ViewGroup.class.getDeclaredMethod("generateLayoutParams", ViewGroup.LayoutParams.class);
            e = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = ViewGroup.class.getDeclaredMethod("checkLayoutParams", ViewGroup.LayoutParams.class);
            f = declaredMethod3;
            declaredMethod3.setAccessible(true);
            a = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
            b = new Class[]{Context.class, AttributeSet.class};
            c = new Class[]{Context.class};
        } catch (NoSuchMethodException e2) {
            throw new com.google.android.libraries.navigation.internal.yx.cb(e2);
        }
    }

    public bo(Context context, com.google.android.libraries.navigation.internal.my.a aVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(context);
        this.h = context;
        this.i = aVar;
    }

    private static Object e(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new com.google.android.libraries.navigation.internal.yx.cb(e2);
        } catch (InvocationTargetException e3) {
            throw new com.google.android.libraries.navigation.internal.yx.cb(e3);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ms.co
    public final Context a(Integer num, ViewGroup viewGroup) {
        Context context = (viewGroup == null || viewGroup.getContext() == null) ? this.h : viewGroup.getContext();
        return num != null ? new ContextThemeWrapper(context, 0) : context;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.co
    public final View b(int i, Integer num, ViewGroup viewGroup, boolean z) {
        View viewInflate = LayoutInflater.from(a(num, viewGroup)).inflate(i, viewGroup, z);
        return (viewGroup == null || !z) ? viewInflate : viewGroup.getChildAt(viewGroup.getChildCount() - 1);
    }

    @Override // com.google.android.libraries.navigation.internal.ms.co
    public final void c(ViewGroup viewGroup, View view, boolean z) {
        if (viewGroup == null) {
            return;
        }
        if (z) {
            viewGroup.addView(view);
        }
        if (view.getParent() != viewGroup && (view.getParent() instanceof ViewGroup)) {
            viewGroup = (ViewGroup) view.getParent();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = layoutParams == null ? (ViewGroup.LayoutParams) e(d, viewGroup, new Object[0]) : layoutParams;
        if (!((Boolean) e(f, viewGroup, layoutParams2)).booleanValue()) {
            layoutParams2 = (ViewGroup.LayoutParams) e(e, viewGroup, layoutParams2);
        }
        if (layoutParams != layoutParams2) {
            view.setLayoutParams(layoutParams2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0061 A[Catch: all -> 0x00c9, TryCatch #2 {all -> 0x00c9, blocks: (B:13:0x0033, B:15:0x0037, B:16:0x003f, B:18:0x0047, B:19:0x0061, B:21:0x0065, B:22:0x006d, B:24:0x0075, B:25:0x0086, B:27:0x008a, B:28:0x0092, B:30:0x009a, B:35:0x00b3, B:36:0x00c8), top: B:51:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0065 A[Catch: all -> 0x00c9, TryCatch #2 {all -> 0x00c9, blocks: (B:13:0x0033, B:15:0x0037, B:16:0x003f, B:18:0x0047, B:19:0x0061, B:21:0x0065, B:22:0x006d, B:24:0x0075, B:25:0x0086, B:27:0x008a, B:28:0x0092, B:30:0x009a, B:35:0x00b3, B:36:0x00c8), top: B:51:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0075 A[Catch: all -> 0x00c9, TryCatch #2 {all -> 0x00c9, blocks: (B:13:0x0033, B:15:0x0037, B:16:0x003f, B:18:0x0047, B:19:0x0061, B:21:0x0065, B:22:0x006d, B:24:0x0075, B:25:0x0086, B:27:0x008a, B:28:0x0092, B:30:0x009a, B:35:0x00b3, B:36:0x00c8), top: B:51:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0086 A[Catch: all -> 0x00c9, TryCatch #2 {all -> 0x00c9, blocks: (B:13:0x0033, B:15:0x0037, B:16:0x003f, B:18:0x0047, B:19:0x0061, B:21:0x0065, B:22:0x006d, B:24:0x0075, B:25:0x0086, B:27:0x008a, B:28:0x0092, B:30:0x009a, B:35:0x00b3, B:36:0x00c8), top: B:51:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x008a A[Catch: all -> 0x00c9, TryCatch #2 {all -> 0x00c9, blocks: (B:13:0x0033, B:15:0x0037, B:16:0x003f, B:18:0x0047, B:19:0x0061, B:21:0x0065, B:22:0x006d, B:24:0x0075, B:25:0x0086, B:27:0x008a, B:28:0x0092, B:30:0x009a, B:35:0x00b3, B:36:0x00c8), top: B:51:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x009a A[Catch: all -> 0x00c9, TRY_LEAVE, TryCatch #2 {all -> 0x00c9, blocks: (B:13:0x0033, B:15:0x0037, B:16:0x003f, B:18:0x0047, B:19:0x0061, B:21:0x0065, B:22:0x006d, B:24:0x0075, B:25:0x0086, B:27:0x008a, B:28:0x0092, B:30:0x009a, B:35:0x00b3, B:36:0x00c8), top: B:51:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00b3 A[Catch: all -> 0x00c9, TRY_ENTER, TryCatch #2 {all -> 0x00c9, blocks: (B:13:0x0033, B:15:0x0037, B:16:0x003f, B:18:0x0047, B:19:0x0061, B:21:0x0065, B:22:0x006d, B:24:0x0075, B:25:0x0086, B:27:0x008a, B:28:0x0092, B:30:0x009a, B:35:0x00b3, B:36:0x00c8), top: B:51:0x0033 }] */
    @Override // com.google.android.libraries.navigation.internal.ms.co
    public final View d(Class cls, int i, Integer num, ViewGroup viewGroup, boolean z) {
        bn bnVar;
        View viewB;
        Context contextA = a(num, viewGroup);
        com.google.android.libraries.navigation.internal.yx.ar.q(contextA);
        Class cls2 = (Class) this.i.a.get(cls);
        if (cls2 != null) {
            cls = cls2;
        }
        SimpleArrayMap simpleArrayMap = g;
        synchronized (simpleArrayMap) {
            bnVar = (bn) simpleArrayMap.get(cls);
            if (bnVar == null) {
                bnVar = new bn(cls);
                simpleArrayMap.put(cls, bnVar);
            }
        }
        cd cdVarA = ce.a("DefaultViewFactory.newInstance ", bnVar.d);
        if (i != 0) {
            try {
                if (bnVar.a == null) {
                    bnVar.a = bnVar.a(a);
                }
                if (bnVar.a.g()) {
                    viewB = bn.b((Constructor) bnVar.a.c(), contextA, null, 0, Integer.valueOf(i));
                } else {
                    if (bnVar.b == null) {
                        bnVar.b = bnVar.a(b);
                    }
                    if (bnVar.b.g()) {
                        viewB = bn.b((Constructor) bnVar.b.c(), contextA, null);
                    } else {
                        if (bnVar.c == null) {
                            bnVar.c = bnVar.a(c);
                        }
                        if (bnVar.c.g()) {
                            throw new com.google.android.libraries.navigation.internal.yx.cb("Could not create instance of ".concat(String.valueOf(String.valueOf(bnVar.d))));
                        }
                        viewB = bn.b((Constructor) bnVar.c.c(), contextA);
                    }
                }
            } catch (Throwable th) {
                if (cdVarA != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } else {
            if (bnVar.b == null) {
                bnVar.b = bnVar.a(b);
            }
            if (bnVar.b.g()) {
                viewB = bn.b((Constructor) bnVar.b.c(), contextA, null);
            } else {
                if (bnVar.c == null) {
                    bnVar.c = bnVar.a(c);
                }
                if (bnVar.c.g()) {
                    throw new com.google.android.libraries.navigation.internal.yx.cb("Could not create instance of ".concat(String.valueOf(String.valueOf(bnVar.d))));
                }
                viewB = bn.b((Constructor) bnVar.c.c(), contextA);
            }
        }
        if (cdVarA != null) {
            Trace.endSection();
        }
        c(viewGroup, viewB, z);
        return viewB;
    }
}
