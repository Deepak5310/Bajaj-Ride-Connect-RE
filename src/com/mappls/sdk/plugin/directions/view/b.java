package com.mappls.sdk.plugin.directions.view;

import android.graphics.Canvas;
import android.graphics.PointF;
import androidx.core.util.Pair;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final b a = new b();
    public static final Map b = new a();
    public static final Set c = new d();
    public static final Set d = new c();
    public static final Set e = new C0109b();

    public static final class a extends HashMap {
        a() {
            put(new Pair("merge", null), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda0
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.a(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair("off ramp", null), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda2
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.b(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair("fork", null), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda3
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.m(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair("roundabout", null), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda4
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.n(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair("roundabout turn", null), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda5
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.o(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair("rotary", null), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda6
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.p(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair("exit rotary", null), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda7
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.q(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair("arrive", null), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda8
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.r(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair("arrive", "right"), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda9
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.s(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair("arrive", "left"), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda10
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.t(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair(null, "slight right"), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda11
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.c(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair(null, "right"), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda12
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.d(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair(null, "sharp right"), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda13
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.e(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair(null, "slight left"), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda14
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.f(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair(null, "left"), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda15
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.g(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair(null, "sharp left"), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda16
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.h(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair(null, "uturn"), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda17
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.i(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair(null, "straight"), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda18
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.j(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair(null, "straight_21"), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda19
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.k(canvas, num, num2, pointF, f);
                }
            });
            put(new Pair(null, null), new com.mappls.sdk.plugin.directions.view.a() { // from class: com.mappls.sdk.plugin.directions.view.b$a$$ExternalSyntheticLambda1
                @Override // com.mappls.sdk.plugin.directions.view.a
                public final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
                    b.a.l(canvas, num, num2, pointF, f);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue();
            Intrinsics.checkNotNull(num2);
            com.mappls.sdk.plugin.directions.view.c.b(canvas, iIntValue, num2.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue();
            Intrinsics.checkNotNull(num2);
            com.mappls.sdk.plugin.directions.view.c.c(canvas, iIntValue, num2.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.f(canvas, num.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.d(canvas, num.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.e(canvas, num.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.f(canvas, num.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.d(canvas, num.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.e(canvas, num.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.c(canvas, num.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.g(canvas, num.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.h(canvas, num.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.g(canvas, num.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue();
            Intrinsics.checkNotNull(num2);
            com.mappls.sdk.plugin.directions.view.c.a(canvas, iIntValue, num2.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue();
            Intrinsics.checkNotNull(num2);
            int iIntValue2 = num2.intValue();
            Intrinsics.checkNotNull(f);
            com.mappls.sdk.plugin.directions.view.c.a(canvas, iIntValue, iIntValue2, pointF, f.floatValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue();
            Intrinsics.checkNotNull(num2);
            int iIntValue2 = num2.intValue();
            Intrinsics.checkNotNull(f);
            com.mappls.sdk.plugin.directions.view.c.a(canvas, iIntValue, iIntValue2, pointF, f.floatValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.i(canvas, num.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue();
            Intrinsics.checkNotNull(num2);
            int iIntValue2 = num2.intValue();
            Intrinsics.checkNotNull(f);
            com.mappls.sdk.plugin.directions.view.c.a(canvas, iIntValue, iIntValue2, pointF, f.floatValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.a(canvas, num.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.b(canvas, num.intValue(), pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(Canvas canvas, Integer num, Integer num2, PointF pointF, Float f) {
            Intrinsics.checkNotNull(num);
            com.mappls.sdk.plugin.directions.view.c.b(canvas, num.intValue(), pointF);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof Pair) {
                return a((Pair) obj);
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof com.mappls.sdk.plugin.directions.view.a) {
                return a((com.mappls.sdk.plugin.directions.view.a) obj);
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set entrySet() {
            return a();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof Pair) {
                return b((Pair) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof Pair) ? obj2 : a((Pair) obj, (com.mappls.sdk.plugin.directions.view.a) obj2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set keySet() {
            return b();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof Pair) {
                return c((Pair) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return c();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection values() {
            return d();
        }

        public /* bridge */ boolean a(Pair pair) {
            return super.containsKey(pair);
        }

        public /* bridge */ com.mappls.sdk.plugin.directions.view.a b(Pair pair) {
            return (com.mappls.sdk.plugin.directions.view.a) super.get(pair);
        }

        public /* bridge */ int c() {
            return super.size();
        }

        public /* bridge */ Collection d() {
            return super.values();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof Pair) && (obj2 instanceof com.mappls.sdk.plugin.directions.view.a)) {
                return b((Pair) obj, (com.mappls.sdk.plugin.directions.view.a) obj2);
            }
            return false;
        }

        public /* bridge */ boolean a(com.mappls.sdk.plugin.directions.view.a aVar) {
            return super.containsValue(aVar);
        }

        public /* bridge */ Set b() {
            return super.keySet();
        }

        public /* bridge */ com.mappls.sdk.plugin.directions.view.a c(Pair pair) {
            return (com.mappls.sdk.plugin.directions.view.a) super.remove(pair);
        }

        public /* bridge */ Set a() {
            return super.entrySet();
        }

        public /* bridge */ boolean b(Pair pair, com.mappls.sdk.plugin.directions.view.a aVar) {
            return super.remove(pair, aVar);
        }

        public /* bridge */ com.mappls.sdk.plugin.directions.view.a a(Pair pair, com.mappls.sdk.plugin.directions.view.a aVar) {
            return (com.mappls.sdk.plugin.directions.view.a) super.getOrDefault(pair, aVar);
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.plugin.directions.view.b$b, reason: collision with other inner class name */
    public static final class C0109b extends HashSet {
        C0109b() {
            add("off ramp");
            add("merge");
            add("fork");
            add("roundabout");
            add("roundabout turn");
            add("rotary");
            add("exit rotary");
        }

        public /* bridge */ boolean a(String str) {
            return super.contains(str);
        }

        public /* bridge */ boolean b(String str) {
            return super.remove(str);
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return a((String) obj);
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ int size() {
            return a();
        }

        public /* bridge */ int a() {
            return super.size();
        }
    }

    public static final class c extends HashSet {
        c() {
            add("roundabout");
            add("roundabout turn");
        }

        public /* bridge */ boolean a(String str) {
            return super.contains(str);
        }

        public /* bridge */ boolean b(String str) {
            return super.remove(str);
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return a((String) obj);
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ int size() {
            return a();
        }

        public /* bridge */ int a() {
            return super.size();
        }
    }

    public static final class d extends HashSet {
        d() {
            add("slight left");
            add("left");
            add("sharp left");
            add("uturn");
        }

        public /* bridge */ boolean a(String str) {
            return super.contains(str);
        }

        public /* bridge */ boolean b(String str) {
            return super.remove(str);
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return a((String) obj);
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ int size() {
            return a();
        }

        public /* bridge */ int a() {
            return super.size();
        }
    }

    private b() {
    }

    public static final float a(float f) {
        float f2 = 0.0f;
        if (f >= 0.0f) {
            f2 = 360.0f;
            if (f <= 360.0f) {
                return f;
            }
        }
        return f2;
    }

    public static final boolean a(String str, String str2, String str3) {
        boolean zAreEqual = Intrinsics.areEqual("left", str3);
        boolean zContains = CollectionsKt.contains(d, str);
        boolean z = (str2 == null || StringsKt.isBlank(str2) || !StringsKt.contains$default((CharSequence) "uturn", (CharSequence) str2, false, 2, (Object) null)) ? false : true;
        boolean zContains2 = CollectionsKt.contains(c, str2);
        if (Intrinsics.areEqual(str, "depart") && str2 == null) {
            return true;
        }
        if (zContains) {
            zContains2 = zAreEqual;
        }
        if (zAreEqual && z) {
            return !zContains2;
        }
        return zContains2;
    }
}
