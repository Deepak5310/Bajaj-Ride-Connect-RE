package com.google.android.libraries.places.internal;

import com.google.maps.android.BuildConfig;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import org.apache.commons.lang3.StringUtils;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzahe<V> extends zzahs implements zzaho<V> {
    static final boolean zza;
    private static final Logger zzb;
    private static final zza zzc;
    private static final Object zzd;

    @CheckForNull
    private volatile zzd listeners;

    @CheckForNull
    private volatile Object value;

    @CheckForNull
    private volatile zzj waiters;

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    abstract class zza {
        /* synthetic */ zza(zzahd zzahdVar) {
        }

        abstract zzd zza(zzahe zzaheVar, zzd zzdVar);

        abstract zzj zzb(zzahe zzaheVar, zzj zzjVar);

        abstract void zzc(zzj zzjVar, @CheckForNull zzj zzjVar2);

        abstract void zzd(zzj zzjVar, Thread thread);

        abstract boolean zze(zzahe zzaheVar, @CheckForNull zzd zzdVar, zzd zzdVar2);

        abstract boolean zzf(zzahe zzaheVar, @CheckForNull Object obj, Object obj2);

        abstract boolean zzg(zzahe zzaheVar, @CheckForNull zzj zzjVar, @CheckForNull zzj zzjVar2);
    }

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    final class zzb {

        @CheckForNull
        static final zzb zza;

        @CheckForNull
        static final zzb zzb;
        final boolean zzc;

        @CheckForNull
        final Throwable zzd;

        static {
            if (zzahe.zza) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zzb(false, null);
                zza = new zzb(true, null);
            }
        }

        zzb(boolean z, @CheckForNull Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.libraries.places.internal.zzahe.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    final class zzd {
        static final zzd zza = new zzd();

        @CheckForNull
        zzd next;

        @CheckForNull
        final Runnable zzb;

        @CheckForNull
        final Executor zzc;

        zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzj, Thread> zza;
        final AtomicReferenceFieldUpdater<zzj, zzj> zzb;
        final AtomicReferenceFieldUpdater<zzahe, zzj> zzc;
        final AtomicReferenceFieldUpdater<zzahe, zzd> zzd;
        final AtomicReferenceFieldUpdater<zzahe, Object> zze;

        zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super(null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final zzd zza(zzahe zzaheVar, zzd zzdVar) {
            return this.zzd.getAndSet(zzaheVar, zzdVar);
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final zzj zzb(zzahe zzaheVar, zzj zzjVar) {
            return this.zzc.getAndSet(zzaheVar, zzjVar);
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final void zzc(zzj zzjVar, @CheckForNull zzj zzjVar2) {
            this.zzb.lazySet(zzjVar, zzjVar2);
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final void zzd(zzj zzjVar, Thread thread) {
            this.zza.lazySet(zzjVar, thread);
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final boolean zze(zzahe zzaheVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return zzahf.zza(this.zzd, zzaheVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final boolean zzf(zzahe zzaheVar, @CheckForNull Object obj, Object obj2) {
            return zzahf.zza(this.zze, zzaheVar, obj, obj2);
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final boolean zzg(zzahe zzaheVar, @CheckForNull zzj zzjVar, @CheckForNull zzj zzjVar2) {
            return zzahf.zza(this.zzc, zzaheVar, zzjVar, zzjVar2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    final class zzf<V> implements Runnable {
        final zzahe<V> zza;
        final zzaho<? extends V> zzb;

        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    final class zzg extends zza {
        private zzg() {
            super(null);
        }

        /* synthetic */ zzg(zzahg zzahgVar) {
            super(null);
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final zzd zza(zzahe zzaheVar, zzd zzdVar) {
            zzd zzdVar2;
            synchronized (zzaheVar) {
                zzdVar2 = zzaheVar.listeners;
                if (zzdVar2 != zzdVar) {
                    zzaheVar.listeners = zzdVar;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final zzj zzb(zzahe zzaheVar, zzj zzjVar) {
            zzj zzjVar2;
            synchronized (zzaheVar) {
                zzjVar2 = zzaheVar.waiters;
                if (zzjVar2 != zzjVar) {
                    zzaheVar.waiters = zzjVar;
                }
            }
            return zzjVar2;
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final void zzc(zzj zzjVar, @CheckForNull zzj zzjVar2) {
            zzjVar.next = zzjVar2;
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final void zzd(zzj zzjVar, Thread thread) {
            zzjVar.thread = thread;
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final boolean zze(zzahe zzaheVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            synchronized (zzaheVar) {
                if (zzaheVar.listeners != zzdVar) {
                    return false;
                }
                zzaheVar.listeners = zzdVar2;
                return true;
            }
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final boolean zzf(zzahe zzaheVar, @CheckForNull Object obj, Object obj2) {
            synchronized (zzaheVar) {
                if (zzaheVar.value != obj) {
                    return false;
                }
                zzaheVar.value = obj2;
                return true;
            }
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final boolean zzg(zzahe zzaheVar, @CheckForNull zzj zzjVar, @CheckForNull zzj zzjVar2) {
            synchronized (zzaheVar) {
                if (zzaheVar.waiters != zzjVar) {
                    return false;
                }
                zzaheVar.waiters = zzjVar2;
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    interface zzh<V> extends zzaho<V> {
    }

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    final class zzi extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e) {
                    throw new RuntimeException("Could not initialize intrinsics", e.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.libraries.places.internal.zzahe.zzi.1
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
                zzc = unsafe.objectFieldOffset(zzahe.class.getDeclaredField("waiters"));
                zzb = unsafe.objectFieldOffset(zzahe.class.getDeclaredField("listeners"));
                zzd = unsafe.objectFieldOffset(zzahe.class.getDeclaredField("value"));
                zze = unsafe.objectFieldOffset(zzj.class.getDeclaredField("thread"));
                zzf = unsafe.objectFieldOffset(zzj.class.getDeclaredField("next"));
                zza = unsafe;
            } catch (NoSuchFieldException e2) {
                throw new RuntimeException(e2);
            } catch (RuntimeException e3) {
                throw e3;
            }
        }

        private zzi() {
            super(null);
        }

        /* synthetic */ zzi(zzahi zzahiVar) {
            super(null);
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final zzd zza(zzahe zzaheVar, zzd zzdVar) {
            zzd zzdVar2;
            do {
                zzdVar2 = zzaheVar.listeners;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zze(zzaheVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final zzj zzb(zzahe zzaheVar, zzj zzjVar) {
            zzj zzjVar2;
            do {
                zzjVar2 = zzaheVar.waiters;
                if (zzjVar == zzjVar2) {
                    break;
                }
            } while (!zzg(zzaheVar, zzjVar2, zzjVar));
            return zzjVar2;
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final void zzc(zzj zzjVar, @CheckForNull zzj zzjVar2) {
            zza.putObject(zzjVar, zzf, zzjVar2);
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final void zzd(zzj zzjVar, Thread thread) {
            zza.putObject(zzjVar, zze, thread);
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final boolean zze(zzahe zzaheVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return zzahh.zza(zza, zzaheVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final boolean zzf(zzahe zzaheVar, @CheckForNull Object obj, Object obj2) {
            return zzahh.zza(zza, zzaheVar, zzd, obj, obj2);
        }

        @Override // com.google.android.libraries.places.internal.zzahe.zza
        final boolean zzg(zzahe zzaheVar, @CheckForNull zzj zzjVar, @CheckForNull zzj zzjVar2) {
            return zzahh.zza(zza, zzaheVar, zzc, zzjVar, zzjVar2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    final class zzj {
        static final zzj zza = new zzj(false);

        @CheckForNull
        volatile zzj next;

        @CheckForNull
        volatile Thread thread;

        zzj() {
            zzahe.zzc.zzd(this, Thread.currentThread());
        }

        zzj(boolean z) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zzgVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        zza = z;
        zzb = Logger.getLogger(zzahe.class.getName());
        Object[] objArr = 0;
        try {
            zzgVar = new zzi(null);
            th2 = null;
            th = null;
        } catch (Error | RuntimeException e) {
            try {
                th2 = e;
                zzgVar = new zze(AtomicReferenceFieldUpdater.newUpdater(zzj.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzj.class, zzj.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zzahe.class, zzj.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzahe.class, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzahe.class, Object.class, "value"));
                th = null;
            } catch (Error | RuntimeException e2) {
                th = e2;
                th2 = e;
                zzgVar = new zzg(objArr == true ? 1 : 0);
            }
        }
        zzc = zzgVar;
        if (th != null) {
            Logger logger = zzb;
            logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        zzd = new Object();
    }

    protected zzahe() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Object zzn(zzaho zzahoVar) {
        Throwable thZzf;
        if (zzahoVar instanceof zzh) {
            Object zzbVar = ((zzahe) zzahoVar).value;
            if (zzbVar instanceof zzb) {
                zzb zzbVar2 = (zzb) zzbVar;
                if (zzbVar2.zzc) {
                    Throwable th = zzbVar2.zzd;
                    zzbVar = th != null ? new zzb(false, th) : zzb.zzb;
                }
            }
            zzbVar.getClass();
            return zzbVar;
        }
        if ((zzahoVar instanceof zzahs) && (thZzf = ((zzahs) zzahoVar).zzf()) != null) {
            return new zzc(thZzf);
        }
        boolean zIsCancelled = zzahoVar.isCancelled();
        if ((!zza) && zIsCancelled) {
            zzb zzbVar3 = zzb.zzb;
            zzbVar3.getClass();
            return zzbVar3;
        }
        try {
            Object objZzo = zzo(zzahoVar);
            if (!zIsCancelled) {
                return objZzo == null ? zzd : objZzo;
            }
            return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(zzahoVar)));
        } catch (Error e) {
            e = e;
            return new zzc(e);
        } catch (CancellationException e2) {
            return !zIsCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(String.valueOf(zzahoVar))), e2)) : new zzb(false, e2);
        } catch (RuntimeException e3) {
            e = e3;
            return new zzc(e);
        } catch (ExecutionException e4) {
            return zIsCancelled ? new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(String.valueOf(zzahoVar))), e4)) : new zzc(e4.getCause());
        }
    }

    private static Object zzo(Future future) throws ExecutionException {
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

    private final void zzp(StringBuilder sb) {
        try {
            Object objZzo = zzo(this);
            sb.append("SUCCESS, result=[");
            if (objZzo == null) {
                sb.append(BuildConfig.TRAVIS);
            } else if (objZzo == this) {
                sb.append("this future");
            } else {
                sb.append(objZzo.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objZzo)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    private final void zzq(StringBuilder sb) {
        String strConcat;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb.append(", setFuture=[");
            zzr(sb, ((zzf) obj).zzb);
            sb.append("]");
        } else {
            try {
                strConcat = zzlb.zza(zze());
            } catch (RuntimeException | StackOverflowError e) {
                strConcat = "Exception thrown from implementation: ".concat(String.valueOf(String.valueOf(e.getClass())));
            }
            if (strConcat != null) {
                sb.append(", info=[");
                sb.append(strConcat);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            zzp(sb);
        }
    }

    private final void zzr(StringBuilder sb, @CheckForNull Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        }
    }

    private static void zzs(zzahe zzaheVar, boolean z) {
        zzd zzdVar = null;
        while (true) {
            for (zzj zzjVarZzb = zzc.zzb(zzaheVar, zzj.zza); zzjVarZzb != null; zzjVarZzb = zzjVarZzb.next) {
                Thread thread = zzjVarZzb.thread;
                if (thread != null) {
                    zzjVarZzb.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            if (z) {
                zzaheVar.zzk();
            }
            zzd zzdVar2 = zzdVar;
            zzd zzdVarZza = zzc.zza(zzaheVar, zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zzdVarZza != null) {
                zzd zzdVar4 = zzdVarZza.next;
                zzdVarZza.next = zzdVar3;
                zzdVar3 = zzdVarZza;
                zzdVarZza = zzdVar4;
            }
            while (zzdVar3 != null) {
                Runnable runnable = zzdVar3.zzb;
                zzdVar = zzdVar3.next;
                runnable.getClass();
                if (runnable instanceof zzf) {
                    zzf zzfVar = (zzf) runnable;
                    zzaheVar = zzfVar.zza;
                    if (zzaheVar.value == zzfVar) {
                        if (zzc.zzf(zzaheVar, zzfVar, zzn(zzfVar.zzb))) {
                            z = false;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = zzdVar3.zzc;
                    executor.getClass();
                    zzt(runnable, executor);
                }
                zzdVar3 = zzdVar;
            }
            return;
        }
    }

    private static void zzt(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            zzb.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e);
        }
    }

    private final void zzu(zzj zzjVar) {
        zzjVar.thread = null;
        while (true) {
            zzj zzjVar2 = this.waiters;
            if (zzjVar2 != zzj.zza) {
                zzj zzjVar3 = null;
                while (zzjVar2 != null) {
                    zzj zzjVar4 = zzjVar2.next;
                    if (zzjVar2.thread != null) {
                        zzjVar3 = zzjVar2;
                    } else if (zzjVar3 != null) {
                        zzjVar3.next = zzjVar4;
                        if (zzjVar3.thread == null) {
                        }
                    } else if (!zzc.zzg(this, zzjVar2, zzjVar4)) {
                    }
                    zzjVar2 = zzjVar4;
                }
                return;
            }
            return;
        }
    }

    private static final Object zzv(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzd) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        zzb zzbVar;
        Object obj = this.value;
        if (!(obj instanceof zzf) && !(obj == null)) {
            return false;
        }
        if (zza) {
            zzbVar = new zzb(z, new CancellationException("Future.cancel() was called."));
        } else {
            zzbVar = z ? zzb.zza : zzb.zzb;
            zzbVar.getClass();
        }
        zzahe<V> zzaheVar = this;
        boolean z2 = false;
        while (true) {
            if (zzc.zzf(zzaheVar, obj, zzbVar)) {
                zzs(zzaheVar, z);
                if (obj instanceof zzf) {
                    zzaho<? extends V> zzahoVar = ((zzf) obj).zzb;
                    if (zzahoVar instanceof zzh) {
                        zzaheVar = (zzahe) zzahoVar;
                        obj = zzaheVar.value;
                        if ((obj == null) | (obj instanceof zzf)) {
                            z2 = true;
                        }
                    } else {
                        zzahoVar.cancel(z);
                    }
                }
                return true;
            }
            obj = zzaheVar.value;
            if (!(obj instanceof zzf)) {
                return z2;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof zzf))) {
            return zzv(obj2);
        }
        zzj zzjVar = this.waiters;
        if (zzjVar != zzj.zza) {
            zzj zzjVar2 = new zzj();
            do {
                zza zzaVar = zzc;
                zzaVar.zzc(zzjVar2, zzjVar);
                if (zzaVar.zzg(this, zzjVar, zzjVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zzu(zzjVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof zzf))));
                    return zzv(obj);
                }
                zzjVar = this.waiters;
            } while (zzjVar != zzj.zza);
        }
        Object obj3 = this.value;
        obj3.getClass();
        return zzv(obj3);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof zzb;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.value;
        return (obj != null) & (!(obj instanceof zzf));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.value instanceof zzb) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzp(sb);
        } else {
            zzq(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    @CheckForNull
    protected String zze() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzahs
    @CheckForNull
    protected final Throwable zzf() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    @Override // com.google.android.libraries.places.internal.zzaho
    public final void zzj(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzkt.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listeners) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzc.zze(this, zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listeners;
                }
            } while (zzdVar != zzd.zza);
        }
        zzt(runnable, executor);
    }

    protected void zzk() {
    }

    protected boolean zzl(Object obj) {
        if (obj == null) {
            obj = zzd;
        }
        if (!zzc.zzf(this, null, obj)) {
            return false;
        }
        zzs(this, false);
        return true;
    }

    protected boolean zzm(Throwable th) {
        if (!zzc.zzf(this, null, new zzc(th))) {
            return false;
        }
        zzs(this, false);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z = true;
            if ((obj != null) & (!(obj instanceof zzf))) {
                return zzv(obj);
            }
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzj zzjVar = this.waiters;
                if (zzjVar != zzj.zza) {
                    zzj zzjVar2 = new zzj();
                    while (true) {
                        zza zzaVar = zzc;
                        zzaVar.zzc(zzjVar2, zzjVar);
                        if (zzaVar.zzg(this, zzjVar, zzjVar2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (Thread.interrupted()) {
                                    zzu(zzjVar2);
                                    throw new InterruptedException();
                                }
                                Object obj2 = this.value;
                                if (!((obj2 != null) & (!(obj2 instanceof zzf)))) {
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    return zzv(obj2);
                                }
                            } while (nanos >= 1000);
                            zzu(zzjVar2);
                            break;
                        }
                        zzjVar = this.waiters;
                        if (zzjVar == zzj.zza) {
                        }
                    }
                }
                Object obj3 = this.value;
                obj3.getClass();
                return zzv(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.value;
                if (!((obj4 != null) & (!(obj4 instanceof zzf)))) {
                    if (!Thread.interrupted()) {
                        nanos = jNanoTime - System.nanoTime();
                    } else {
                        throw new InterruptedException();
                    }
                } else {
                    return zzv(obj4);
                }
            }
            String string = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String strConcat = "Waited " + j + StringUtils.SPACE + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String strConcat2 = strConcat.concat(" (plus ");
                long j2 = -nanos;
                long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(jConvert);
                if (jConvert != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (jConvert > 0) {
                    String strConcat3 = strConcat2 + jConvert + StringUtils.SPACE + lowerCase;
                    if (z) {
                        strConcat3 = strConcat3.concat(",");
                    }
                    strConcat2 = strConcat3.concat(StringUtils.SPACE);
                }
                if (z) {
                    strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
                }
                strConcat = strConcat2.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(strConcat + " for " + string);
        }
        throw new InterruptedException();
    }
}
