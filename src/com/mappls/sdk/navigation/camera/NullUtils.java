package com.mappls.sdk.navigation.camera;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NullUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001aS\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00022\b\u0010\b\u001a\u0004\u0018\u0001H\u00072\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00010\tH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001ai\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000b\"\u0004\b\u0003\u0010\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00022\b\u0010\b\u001a\u0004\u0018\u0001H\u00072\b\u0010\f\u001a\u0004\u0018\u0001H\u000b2\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00010\rH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u007f\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000b\"\u0004\b\u0003\u0010\u000f\"\u0004\b\u0004\u0010\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00022\b\u0010\b\u001a\u0004\u0018\u0001H\u00072\b\u0010\f\u001a\u0004\u0018\u0001H\u000b2\b\u0010\u0010\u001a\u0004\u0018\u0001H\u000f2$\u0010\u0004\u001a \u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00010\u0011H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0095\u0001\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000b\"\u0004\b\u0003\u0010\u000f\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00022\b\u0010\b\u001a\u0004\u0018\u0001H\u00072\b\u0010\f\u001a\u0004\u0018\u0001H\u000b2\b\u0010\u0010\u001a\u0004\u0018\u0001H\u000f2\b\u0010\u0014\u001a\u0004\u0018\u0001H\u00132*\u0010\u0004\u001a&\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00010\u0015H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a«\u0001\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000b\"\u0004\b\u0003\u0010\u000f\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0017\"\u0004\b\u0006\u0010\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00022\b\u0010\b\u001a\u0004\u0018\u0001H\u00072\b\u0010\f\u001a\u0004\u0018\u0001H\u000b2\b\u0010\u0010\u001a\u0004\u0018\u0001H\u000f2\b\u0010\u0014\u001a\u0004\u0018\u0001H\u00132\b\u0010\u0018\u001a\u0004\u0018\u0001H\u001720\u0010\u0004\u001a,\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00010\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001aÁ\u0001\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000b\"\u0004\b\u0003\u0010\u000f\"\u0004\b\u0004\u0010\u0013\"\u0004\b\u0005\u0010\u0017\"\u0004\b\u0006\u0010\u001b\"\u0004\b\u0007\u0010\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00022\b\u0010\b\u001a\u0004\u0018\u0001H\u00072\b\u0010\f\u001a\u0004\u0018\u0001H\u000b2\b\u0010\u0010\u001a\u0004\u0018\u0001H\u000f2\b\u0010\u0014\u001a\u0004\u0018\u0001H\u00132\b\u0010\u0018\u001a\u0004\u0018\u0001H\u00172\b\u0010\u001c\u001a\u0004\u0018\u0001H\u001b26\u0010\u0004\u001a2\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u00010\u001dH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"ifNonNull", ExifInterface.GPS_DIRECTION_TRUE, "R1", "r1", "func", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "R2", "r2", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "R3", "r3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "R4", "r4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "R5", "r5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "R6", "r6", "Lkotlin/Function6;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function6;)Ljava/lang/Object;", "R7", "r7", "Lkotlin/Function7;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function7;)Ljava/lang/Object;", "navigation-camera_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NullUtils {
    public static final <R1, T> T ifNonNull(R1 r1, Function1<? super R1, ? extends T> func) {
        Intrinsics.checkNotNullParameter(func, "func");
        if (r1 != null) {
            return func.invoke(r1);
        }
        return null;
    }

    public static final <R1, R2, T> T ifNonNull(R1 r1, R2 r2, Function2<? super R1, ? super R2, ? extends T> func) {
        Intrinsics.checkNotNullParameter(func, "func");
        if (r1 == null || r2 == null) {
            return null;
        }
        return func.invoke(r1, r2);
    }

    public static final <R1, R2, R3, T> T ifNonNull(R1 r1, R2 r2, R3 r3, Function3<? super R1, ? super R2, ? super R3, ? extends T> func) {
        Intrinsics.checkNotNullParameter(func, "func");
        if (r1 == null || r2 == null || r3 == null) {
            return null;
        }
        return func.invoke(r1, r2, r3);
    }

    public static final <R1, R2, R3, R4, T> T ifNonNull(R1 r1, R2 r2, R3 r3, R4 r4, Function4<? super R1, ? super R2, ? super R3, ? super R4, ? extends T> func) {
        Intrinsics.checkNotNullParameter(func, "func");
        if (r1 == null || r2 == null || r3 == null || r4 == null) {
            return null;
        }
        return func.invoke(r1, r2, r3, r4);
    }

    public static final <R1, R2, R3, R4, R5, T> T ifNonNull(R1 r1, R2 r2, R3 r3, R4 r4, R5 r5, Function5<? super R1, ? super R2, ? super R3, ? super R4, ? super R5, ? extends T> func) {
        Intrinsics.checkNotNullParameter(func, "func");
        if (r1 == null || r2 == null || r3 == null || r4 == null || r5 == null) {
            return null;
        }
        return func.invoke(r1, r2, r3, r4, r5);
    }

    public static final <R1, R2, R3, R4, R5, R6, T> T ifNonNull(R1 r1, R2 r2, R3 r3, R4 r4, R5 r5, R6 r6, Function6<? super R1, ? super R2, ? super R3, ? super R4, ? super R5, ? super R6, ? extends T> func) {
        Intrinsics.checkNotNullParameter(func, "func");
        if (r1 == null || r2 == null || r3 == null || r4 == null || r5 == null || r6 == null) {
            return null;
        }
        return func.invoke(r1, r2, r3, r4, r5, r6);
    }

    public static final <R1, R2, R3, R4, R5, R6, R7, T> T ifNonNull(R1 r1, R2 r2, R3 r3, R4 r4, R5 r5, R6 r6, R7 r7, Function7<? super R1, ? super R2, ? super R3, ? super R4, ? super R5, ? super R6, ? super R7, ? extends T> func) {
        Intrinsics.checkNotNullParameter(func, "func");
        if (r1 == null || r2 == null || r3 == null || r4 == null || r5 == null || r6 == null || r7 == null) {
            return null;
        }
        return func.invoke(r1, r2, r3, r4, r5, r6, r7);
    }
}
