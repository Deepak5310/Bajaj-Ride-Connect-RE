package com.google.android.libraries.navigation.internal.hh;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.google.android.libraries.navigation.internal.hh.r[], still in use, count: 1, list:
  (r0v1 com.google.android.libraries.navigation.internal.hh.r[]) from 0x004e: INVOKE (r0v1 com.google.android.libraries.navigation.internal.hh.r[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
public final class r implements t {
    ARRIVED_AT_PLACEMARK("ArrivedAtPlacemark"),
    AUTH_TOKEN_RECENCY("AuthTokenRecency"),
    COMPLETED_NAVIGATION("CompletedNavigation"),
    GEOFENCE_DATA("GeofenceData"),
    TRANSIT_TRIP_PARAMS("TransitTripParams"),
    WAYPOINTS_CHANGED_IN_NAVIGATION("WaypointsHaveChangedInNav");

    private final String h;

    static {
        EnumEntriesKt.enumEntries(rVarArr);
    }

    private r(String str) {
        super(str, i);
        this.h = str;
    }

    public static r[] values() {
        return (r[]) g.clone();
    }

    @Override // com.google.android.libraries.navigation.internal.hh.t
    public final String a() {
        return this.h;
    }
}
