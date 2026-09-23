package com.google.android.libraries.navigation.internal.aac;

import com.google.maps.android.BuildConfig;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import org.apache.commons.lang3.StringUtils;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d<V> extends com.google.android.libraries.navigation.internal.aad.a implements bj<V> {
    private static final Object a;
    static final boolean k;
    static final bi l;
    public static final a m;
    public volatile e listeners;
    public volatile Object value;
    public volatile k waiters;

    /* JADX INFO: compiled from: PG */
    abstract class a {
        public abstract e a(d dVar, e eVar);

        public abstract k b(d dVar, k kVar);

        public abstract void c(k kVar, k kVar2);

        public abstract void d(k kVar, Thread thread);

        public abstract boolean e(d dVar, e eVar, e eVar2);

        public abstract boolean f(d dVar, Object obj, Object obj2);

        public abstract boolean g(d dVar, k kVar, k kVar2);
    }

    /* JADX INFO: compiled from: PG */
    final class b extends a {
        final AtomicReferenceFieldUpdater<k, Thread> a;
        final AtomicReferenceFieldUpdater<k, k> b;
        final AtomicReferenceFieldUpdater<? super d<?>, k> c;
        final AtomicReferenceFieldUpdater<? super d<?>, e> d;
        final AtomicReferenceFieldUpdater<? super d<?>, Object> e;

        public b(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final e a(d dVar, e eVar) {
            return this.d.getAndSet(dVar, eVar);
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final k b(d dVar, k kVar) {
            return this.c.getAndSet(dVar, kVar);
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final void c(k kVar, k kVar2) {
            this.b.lazySet(kVar, kVar2);
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final void d(k kVar, Thread thread) {
            this.a.lazySet(kVar, thread);
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final boolean e(d dVar, e eVar, e eVar2) {
            return com.google.android.libraries.navigation.internal.aac.e.a(this.d, dVar, eVar, eVar2);
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final boolean f(d dVar, Object obj, Object obj2) {
            return com.google.android.libraries.navigation.internal.aac.e.a(this.e, dVar, obj, obj2);
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final boolean g(d dVar, k kVar, k kVar2) {
            return com.google.android.libraries.navigation.internal.aac.e.a(this.c, dVar, kVar, kVar2);
        }
    }

    /* JADX INFO: compiled from: PG */
    final class c {
        static final c a;
        static final c b;
        final boolean c;
        final Throwable d;

        static {
            if (d.k) {
                b = null;
                a = null;
            } else {
                b = new c(false, null);
                a = new c(true, null);
            }
        }

        public c(boolean z, Throwable th) {
            this.c = z;
            this.d = th;
        }
    }

    /* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.aac.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PG */
    final class C0030d {
        static final C0030d a = new C0030d(new Throwable() { // from class: com.google.android.libraries.navigation.internal.aac.d.d.1
            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable b;

        public C0030d(Throwable th) {
            com.google.android.libraries.navigation.internal.yx.ar.q(th);
            this.b = th;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class e {
        static final e a = new e();
        final Runnable b;
        final Executor c;
        e next;

        public e() {
            this.b = null;
            this.c = null;
        }

        public e(Runnable runnable, Executor executor) {
            this.b = runnable;
            this.c = executor;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class f<V> implements Runnable {
        final d<V> a;
        final bj<? extends V> b;

        public f(d dVar, bj bjVar) {
            this.a = dVar;
            this.b = bjVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = d.m;
            if (this.a.value != this) {
                return;
            }
            bj<? extends V> bjVar = this.b;
            if (d.m.f(this.a, this, d.j(bjVar))) {
                d.m(this.a, false);
            }
        }
    }

    /* JADX INFO: compiled from: PG */
    final class g extends a {
        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final e a(d dVar, e eVar) {
            e eVar2;
            synchronized (dVar) {
                eVar2 = dVar.listeners;
                if (eVar2 != eVar) {
                    dVar.listeners = eVar;
                }
            }
            return eVar2;
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final k b(d dVar, k kVar) {
            k kVar2;
            synchronized (dVar) {
                kVar2 = dVar.waiters;
                if (kVar2 != kVar) {
                    dVar.waiters = kVar;
                }
            }
            return kVar2;
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final void c(k kVar, k kVar2) {
            kVar.next = kVar2;
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final void d(k kVar, Thread thread) {
            kVar.thread = thread;
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final boolean e(d dVar, e eVar, e eVar2) {
            synchronized (dVar) {
                if (dVar.listeners != eVar) {
                    return false;
                }
                dVar.listeners = eVar2;
                return true;
            }
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final boolean f(d dVar, Object obj, Object obj2) {
            synchronized (dVar) {
                if (dVar.value != obj) {
                    return false;
                }
                dVar.value = obj2;
                return true;
            }
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final boolean g(d dVar, k kVar, k kVar2) {
            synchronized (dVar) {
                if (dVar.waiters != kVar) {
                    return false;
                }
                dVar.waiters = kVar2;
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: PG */
    interface h<V> extends bj<V> {
    }

    /* JADX INFO: compiled from: PG */
    abstract class i<V> extends d<V> implements h<V> {
    }

    /* JADX INFO: compiled from: PG */
    final class j extends a {
        static final Unsafe a;
        static final long b;
        static final long c;
        static final long d;
        static final long e;
        static final long f;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.libraries.navigation.internal.aac.d.j.1
                    @Override // java.security.PrivilegedExceptionAction
                    public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
            try {
                c = unsafe.objectFieldOffset(d.class.getDeclaredField("waiters"));
                b = unsafe.objectFieldOffset(d.class.getDeclaredField("listeners"));
                d = unsafe.objectFieldOffset(d.class.getDeclaredField("value"));
                e = unsafe.objectFieldOffset(k.class.getDeclaredField("thread"));
                f = unsafe.objectFieldOffset(k.class.getDeclaredField("next"));
                a = unsafe;
            } catch (NoSuchFieldException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final e a(d dVar, e eVar) {
            e eVar2;
            do {
                eVar2 = dVar.listeners;
                if (eVar == eVar2) {
                    break;
                }
            } while (!e(dVar, eVar2, eVar));
            return eVar2;
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final k b(d dVar, k kVar) {
            k kVar2;
            do {
                kVar2 = dVar.waiters;
                if (kVar == kVar2) {
                    break;
                }
            } while (!g(dVar, kVar2, kVar));
            return kVar2;
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final void c(k kVar, k kVar2) {
            a.putObject(kVar, f, kVar2);
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final void d(k kVar, Thread thread) {
            a.putObject(kVar, e, thread);
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final boolean e(d dVar, e eVar, e eVar2) {
            return com.google.android.libraries.navigation.internal.aac.f.a(a, dVar, b, eVar, eVar2);
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final boolean f(d dVar, Object obj, Object obj2) {
            return com.google.android.libraries.navigation.internal.aac.f.a(a, dVar, d, obj, obj2);
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d.a
        public final boolean g(d dVar, k kVar, k kVar2) {
            return com.google.android.libraries.navigation.internal.aac.f.a(a, dVar, c, kVar, kVar2);
        }
    }

    /* JADX INFO: compiled from: PG */
    final class k {
        static final k a = new k(null);
        volatile k next;
        volatile Thread thread;

        public k() {
            d.m.d(this, Thread.currentThread());
        }

        public k(byte[] bArr) {
        }

        final void a(k kVar) {
            d.m.c(this, kVar);
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        a gVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        k = z;
        l = new bi(d.class);
        try {
            gVar = new j();
            th2 = null;
            th = null;
        } catch (Error | Exception e2) {
            try {
                th = null;
                th2 = e2;
                gVar = new b(AtomicReferenceFieldUpdater.newUpdater(k.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(k.class, k.class, "next"), AtomicReferenceFieldUpdater.newUpdater(d.class, k.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(d.class, e.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "value"));
            } catch (Error | Exception e3) {
                th = e3;
                th2 = e2;
                gVar = new g();
            }
        }
        m = gVar;
        if (th != null) {
            bi biVar = l;
            biVar.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            biVar.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "AtomicReferenceFieldUpdaterAtomicHelper is broken!", th);
        }
        a = new Object();
    }

    protected d() {
    }

    private static Object f(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private final void g(StringBuilder sb) {
        try {
            Object objF = f(this);
            sb.append("SUCCESS, result=[");
            if (objF == null) {
                sb.append(BuildConfig.TRAVIS);
            } else if (objF == this) {
                sb.append("this future");
            } else {
                sb.append(objF.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objF)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        } catch (Exception e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private final void h(StringBuilder sb) {
        String strConcat;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof f) {
            sb.append(", setFuture=[");
            i(sb, ((f) obj).b);
            sb.append("]");
        } else {
            try {
                strConcat = com.google.android.libraries.navigation.internal.yx.aq.a(ao());
            } catch (Exception | StackOverflowError e2) {
                strConcat = "Exception thrown from implementation: ".concat(String.valueOf(String.valueOf(e2.getClass())));
            }
            if (strConcat != null) {
                sb.append(", info=[");
                sb.append(strConcat);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            g(sb);
        }
    }

    private final void i(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (Exception | StackOverflowError e2) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e2.getClass());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object j(bj bjVar) {
        Throwable thK;
        if (bjVar instanceof h) {
            Object cVar = ((d) bjVar).value;
            if (cVar instanceof c) {
                c cVar2 = (c) cVar;
                if (cVar2.c) {
                    Throwable th = cVar2.d;
                    cVar = th != null ? new c(false, th) : c.b;
                }
            }
            return Objects.requireNonNull(cVar);
        }
        if ((bjVar instanceof com.google.android.libraries.navigation.internal.aad.a) && (thK = ((com.google.android.libraries.navigation.internal.aad.a) bjVar).k()) != null) {
            return new C0030d(thK);
        }
        boolean zIsCancelled = bjVar.isCancelled();
        if ((!k) && zIsCancelled) {
            return Objects.requireNonNull(c.b);
        }
        try {
            Object objF = f(bjVar);
            if (!zIsCancelled) {
                return objF == null ? a : objF;
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(bjVar)));
        } catch (Error e2) {
            e = e2;
            return new C0030d(e);
        } catch (CancellationException e3) {
            return !zIsCancelled ? new C0030d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(String.valueOf(bjVar))), e3)) : new c(false, e3);
        } catch (ExecutionException e4) {
            return zIsCancelled ? new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(String.valueOf(bjVar))), e4)) : new C0030d(e4.getCause());
        } catch (Exception e5) {
            e = e5;
            return new C0030d(e);
        }
    }

    public static void m(d dVar, boolean z) {
        e eVar = null;
        while (true) {
            for (k kVarB = m.b(dVar, k.a); kVarB != null; kVarB = kVarB.next) {
                Thread thread = kVarB.thread;
                if (thread != null) {
                    kVarB.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            if (z) {
                dVar.n();
            }
            dVar.b();
            e eVar2 = eVar;
            e eVarA = m.a(dVar, e.a);
            e eVar3 = eVar2;
            while (eVarA != null) {
                e eVar4 = eVarA.next;
                eVarA.next = eVar3;
                eVar3 = eVarA;
                eVarA = eVar4;
            }
            while (eVar3 != null) {
                eVar = eVar3.next;
                Runnable runnable = (Runnable) Objects.requireNonNull(eVar3.b);
                if (runnable instanceof f) {
                    f fVar = (f) runnable;
                    dVar = fVar.a;
                    if (dVar.value == fVar) {
                        if (m.f(dVar, fVar, j(fVar.b))) {
                            z = false;
                        }
                    } else {
                        continue;
                    }
                } else {
                    q(runnable, (Executor) Objects.requireNonNull(eVar3.c));
                }
                eVar3 = eVar;
            }
            return;
        }
    }

    private static void q(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e2) {
            l.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e2);
        }
    }

    private final void r(k kVar) {
        kVar.thread = null;
        while (true) {
            k kVar2 = this.waiters;
            if (kVar2 != k.a) {
                k kVar3 = null;
                while (kVar2 != null) {
                    k kVar4 = kVar2.next;
                    if (kVar2.thread != null) {
                        kVar3 = kVar2;
                    } else if (kVar3 != null) {
                        kVar3.next = kVar4;
                        if (kVar3.thread == null) {
                        }
                    } else if (!m.g(this, kVar2, kVar4)) {
                    }
                    kVar2 = kVar4;
                }
                return;
            }
            return;
        }
    }

    private static final Object s(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            Throwable th = ((c) obj).d;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof C0030d) {
            throw new ExecutionException(((C0030d) obj).b);
        }
        if (obj == a) {
            return null;
        }
        return obj;
    }

    public boolean aA(bj bjVar) {
        C0030d c0030d;
        com.google.android.libraries.navigation.internal.yx.ar.q(bjVar);
        Object obj = this.value;
        if (obj == null) {
            if (bjVar.isDone()) {
                if (!m.f(this, null, j(bjVar))) {
                    return false;
                }
                m(this, false);
                return true;
            }
            f fVar = new f(this, bjVar);
            if (m.f(this, null, fVar)) {
                try {
                    bjVar.l(fVar, ac.INSTANCE);
                } catch (Throwable th) {
                    try {
                        c0030d = new C0030d(th);
                    } catch (Error | Exception unused) {
                        c0030d = C0030d.a;
                    }
                    m.f(this, fVar, c0030d);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            bjVar.cancel(((c) obj).c);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String ao() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public boolean ap(Throwable th) {
        com.google.android.libraries.navigation.internal.yx.ar.q(th);
        if (!m.f(this, null, new C0030d(th))) {
            return false;
        }
        m(this, false);
        return true;
    }

    protected void b() {
    }

    public boolean cancel(boolean z) {
        Object objRequireNonNull;
        Object obj = this.value;
        if (!(obj instanceof f) && !(obj == null)) {
            return false;
        }
        if (k) {
            objRequireNonNull = new c(z, new CancellationException("Future.cancel() was called."));
        } else {
            objRequireNonNull = Objects.requireNonNull(z ? c.a : c.b);
        }
        d<V> dVar = this;
        boolean z2 = false;
        while (true) {
            if (m.f(dVar, obj, objRequireNonNull)) {
                m(dVar, z);
                if (obj instanceof f) {
                    bj<? extends V> bjVar = ((f) obj).b;
                    if (bjVar instanceof h) {
                        dVar = (d) bjVar;
                        obj = dVar.value;
                        if ((obj == null) | (obj instanceof f)) {
                            z2 = true;
                        }
                    } else {
                        bjVar.cancel(z);
                    }
                }
                return true;
            }
            obj = dVar.value;
            if (!(obj instanceof f)) {
                return z2;
            }
        }
    }

    protected boolean d(Object obj) {
        if (obj == null) {
            obj = a;
        }
        if (!m.f(this, null, obj)) {
            return false;
        }
        m(this, false);
        return true;
    }

    public Object get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof f))) {
            return s(obj2);
        }
        k kVar = this.waiters;
        if (kVar != k.a) {
            k kVar2 = new k();
            do {
                kVar2.a(kVar);
                if (m.g(this, kVar, kVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            r(kVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof f))));
                    return s(obj);
                }
                kVar = this.waiters;
            } while (kVar != k.a);
        }
        return s(Objects.requireNonNull(this.value));
    }

    public boolean isCancelled() {
        return this.value instanceof c;
    }

    public boolean isDone() {
        Object obj = this.value;
        return (obj != null) & (!(obj instanceof f));
    }

    @Override // com.google.android.libraries.navigation.internal.aad.a
    public final Throwable k() {
        if (!(this instanceof h)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof C0030d) {
            return ((C0030d) obj).b;
        }
        return null;
    }

    public void l(Runnable runnable, Executor executor) {
        e eVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(runnable, "Runnable was null.");
        com.google.android.libraries.navigation.internal.yx.ar.r(executor, "Executor was null.");
        if (!isDone() && (eVar = this.listeners) != e.a) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.next = eVar;
                if (m.e(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.listeners;
                }
            } while (eVar != e.a);
        }
        q(runnable, executor);
    }

    protected void n() {
    }

    final void o(Future future) {
        if ((future != null) && isCancelled()) {
            future.cancel(p());
        }
    }

    protected final boolean p() {
        Object obj = this.value;
        return (obj instanceof c) && ((c) obj).c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            g(sb);
        } else {
            h(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    public Object get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z = true;
            if ((obj != null) & (!(obj instanceof f))) {
                return s(obj);
            }
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                k kVar = this.waiters;
                if (kVar != k.a) {
                    k kVar2 = new k();
                    while (true) {
                        kVar2.a(kVar);
                        if (m.g(this, kVar, kVar2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (Thread.interrupted()) {
                                    r(kVar2);
                                    throw new InterruptedException();
                                }
                                Object obj2 = this.value;
                                if ((obj2 != null) && (!(obj2 instanceof f))) {
                                    return s(obj2);
                                }
                                nanos = jNanoTime - System.nanoTime();
                            } while (nanos >= 1000);
                            r(kVar2);
                            break;
                        }
                        kVar = this.waiters;
                        if (kVar == k.a) {
                        }
                    }
                }
                return s(Objects.requireNonNull(this.value));
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if (!((obj3 != null) & (!(obj3 instanceof f)))) {
                    if (!Thread.interrupted()) {
                        nanos = jNanoTime - System.nanoTime();
                    } else {
                        throw new InterruptedException();
                    }
                } else {
                    return s(obj3);
                }
            }
            String string = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String strConcat = "Waited " + j2 + StringUtils.SPACE + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String strConcat2 = strConcat.concat(" (plus ");
                long j3 = -nanos;
                long jConvert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit.toNanos(jConvert);
                if (jConvert != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (jConvert > 0) {
                    String strConcat3 = strConcat2 + jConvert + StringUtils.SPACE + lowerCase;
                    if (z) {
                        strConcat3 = strConcat3.concat(",");
                    }
                    strConcat2 = String.valueOf(strConcat3).concat(StringUtils.SPACE);
                }
                if (z) {
                    strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
                }
                strConcat = String.valueOf(strConcat2).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(strConcat).concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(strConcat + " for " + string);
        }
        throw new InterruptedException();
    }
}
