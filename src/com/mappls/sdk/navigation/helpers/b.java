package com.mappls.sdk.navigation.helpers;

import com.google.gson.Gson;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.data.LocationPoint;
import com.mappls.sdk.navigation.events.NavEvent;
import com.mappls.sdk.navigation.iface.CongestionInfoChangedListener;
import com.mappls.sdk.navigation.iface.JunctionInfoChangedListener;
import com.mappls.sdk.navigation.iface.NavigationEventListener;
import com.mappls.sdk.navigation.iface.POIAlongTheRouteChangedListener;
import com.mappls.sdk.navigation.model.CongestionInfo;
import com.mappls.sdk.navigation.model.Junction;
import com.mappls.sdk.navigation.refresh.d;
import com.mappls.sdk.navigation.routing.NavigationRoute;
import com.mappls.sdk.navigation.routing.h;
import com.mappls.sdk.navigation.s;
import com.mappls.sdk.navigation.util.NavigationUtils;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private NavigationRoute d;
    private POIAlongTheRouteChangedListener f;
    private List<d> g;
    private NavigationEventListener k;
    private JunctionInfoChangedListener l;
    private List<List<C0096b>> a = new ArrayList();
    private ConcurrentHashMap<LocationPoint, Integer> b = new ConcurrentHashMap<>();
    private ArrayList<Integer> c = new ArrayList<>();
    private CopyOnWriteArrayList h = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList i = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList j = new CopyOnWriteArrayList();
    private com.mappls.sdk.navigation.d e = NavigationContext.getNavigationContext().k().e();

    final class a implements Comparator<C0096b> {
        a() {
        }

        @Override // java.util.Comparator
        public final int compare(C0096b c0096b, C0096b c0096b2) {
            int i;
            C0096b c0096b3 = c0096b;
            C0096b c0096b4 = c0096b2;
            int i2 = c0096b3.d;
            if (i2 == 0 || (i = c0096b4.d) == 0) {
                i2 = c0096b3.c;
                i = c0096b4.c;
            }
            if (i2 == i) {
                return Float.compare(c0096b3.b, c0096b4.b);
            }
            return i2 < i ? -1 : 1;
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.navigation.helpers.b$b, reason: collision with other inner class name */
    public static class C0096b {
        LocationPoint a;
        float b;
        int c;
        int d;
        int e;

        public C0096b() {
        }

        public C0096b(LocationPoint locationPoint, float f, int i) {
            this.a = locationPoint;
            this.b = f;
            this.c = i;
            this.d = 0;
            this.e = 0;
        }

        public C0096b(LocationPoint locationPoint, int i, int i2, int i3) {
            this.a = locationPoint;
            this.b = 0.0f;
            this.c = i;
            this.d = i2;
            this.e = i3;
        }

        public final float a() {
            return this.b;
        }

        public final LocationPoint b() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0096b.class != obj.getClass()) {
                return false;
            }
            LocationPoint locationPoint = this.a;
            LocationPoint locationPoint2 = ((C0096b) obj).a;
            if (locationPoint == null) {
                return locationPoint2 == null;
            }
            return locationPoint.equals(locationPoint2);
        }

        public final int hashCode() {
            LocationPoint locationPoint = this.a;
            if (locationPoint == null) {
                return 0;
            }
            return locationPoint.hashCode();
        }
    }

    protected static h a() {
        return NavigationContext.getNavigationContext().h().o();
    }

    private static List a(List list, int i) {
        while (list.size() <= i) {
            list.add(new ArrayList());
        }
        if (list.get(i) != null) {
            ((List) list.get(i)).clear();
        }
        return (List) list.get(i);
    }

    private void a(Junction junction) {
        CopyOnWriteArrayList<JunctionInfoChangedListener> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            for (JunctionInfoChangedListener junctionInfoChangedListener : copyOnWriteArrayList) {
                if (junctionInfoChangedListener != null) {
                    junctionInfoChangedListener.junctionInfoChanged(junction);
                }
            }
        }
        JunctionInfoChangedListener junctionInfoChangedListener2 = this.l;
        if (junctionInfoChangedListener2 != null) {
            junctionInfoChangedListener2.junctionInfoChanged(junction);
        }
    }

    private static void a(NavigationRoute navigationRoute, List list, List list2) {
        List<NavLocation> immutableAllLocations = navigationRoute.getImmutableAllLocations();
        int[] iArr = new int[1];
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            LocationPoint locationPoint = (LocationPoint) it2.next();
            float f = Float.POSITIVE_INFINITY;
            for (int i = 1; i < immutableAllLocations.size(); i++) {
                int i2 = i - 1;
                double dA = com.mappls.sdk.navigation.util.d.a(locationPoint.getLatitude(), locationPoint.getLongitude(), immutableAllLocations.get(i2).getLatitude(), immutableAllLocations.get(i2).getLongitude(), immutableAllLocations.get(i).getLatitude(), immutableAllLocations.get(i).getLongitude());
                if (dA < f) {
                    iArr[0] = i;
                    f = (float) dA;
                }
            }
            if (f < Float.POSITIVE_INFINITY) {
                int i3 = iArr[0];
                locationPoint.getLatitude();
                locationPoint.getLongitude();
                int i4 = i3 - 1;
                immutableAllLocations.get(i4).getLatitude();
                immutableAllLocations.get(i4).getLongitude();
                immutableAllLocations.get(i3).getLatitude();
                immutableAllLocations.get(i3).getLongitude();
            }
            if (f <= 500) {
                list.add(new C0096b(locationPoint, f, iArr[0]));
            }
        }
    }

    protected static void b(List list) {
        Collections.sort(list, new a());
    }

    public final void a(int i) {
        a(this.d, i, this.a);
        this.c = new ArrayList<>(Collections.nCopies(this.a.size(), 0));
    }

    public final void a(CongestionInfoChangedListener congestionInfoChangedListener) {
        this.j.add(congestionInfoChangedListener);
    }

    public final void a(JunctionInfoChangedListener junctionInfoChangedListener) {
        this.i.add(junctionInfoChangedListener);
    }

    public final void a(NavigationEventListener navigationEventListener) {
        this.h.add(navigationEventListener);
    }

    public final void a(POIAlongTheRouteChangedListener pOIAlongTheRouteChangedListener) {
        this.f = pOIAlongTheRouteChangedListener;
    }

    public final void a(List<d> list) {
        this.g = list;
        if (this.f == null || list == null || list.size() <= 0) {
            return;
        }
        this.f.onPlaceChanged(list);
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0276 A[Catch: all -> 0x027e, TRY_LEAVE, TryCatch #1 {, blocks: (B:92:0x024b, B:94:0x0251, B:96:0x0259, B:97:0x025f, B:99:0x0265, B:102:0x026e, B:103:0x0272, B:105:0x0276), top: B:264:0x024b }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0281  */
    /* JADX WARN: Code duplicated, block: B:113:0x0284  */
    /* JADX WARN: Code duplicated, block: B:115:0x029c  */
    /* JADX WARN: Code duplicated, block: B:135:0x0306  */
    /* JADX WARN: Code duplicated, block: B:137:0x031f  */
    /* JADX WARN: Code duplicated, block: B:167:0x03a7 A[Catch: all -> 0x03c9, TryCatch #0 {, blocks: (B:165:0x039f, B:167:0x03a7, B:168:0x03ad, B:170:0x03b3, B:173:0x03bc, B:174:0x03c0, B:176:0x03c4), top: B:262:0x039f }] */
    /* JADX WARN: Code duplicated, block: B:170:0x03b3 A[Catch: all -> 0x03c9, TryCatch #0 {, blocks: (B:165:0x039f, B:167:0x03a7, B:168:0x03ad, B:170:0x03b3, B:173:0x03bc, B:174:0x03c0, B:176:0x03c4), top: B:262:0x039f }] */
    /* JADX WARN: Code duplicated, block: B:176:0x03c4 A[Catch: all -> 0x03c9, TRY_LEAVE, TryCatch #0 {, blocks: (B:165:0x039f, B:167:0x03a7, B:168:0x03ad, B:170:0x03b3, B:173:0x03bc, B:174:0x03c0, B:176:0x03c4), top: B:262:0x039f }] */
    /* JADX WARN: Code duplicated, block: B:183:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:187:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:194:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:200:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:203:0x0425  */
    /* JADX WARN: Code duplicated, block: B:205:0x0431  */
    /* JADX WARN: Code duplicated, block: B:209:0x045f  */
    /* JADX WARN: Code duplicated, block: B:212:0x0469  */
    /* JADX WARN: Code duplicated, block: B:214:0x046f  */
    /* JADX WARN: Code duplicated, block: B:217:0x0477  */
    /* JADX WARN: Code duplicated, block: B:218:0x0480  */
    /* JADX WARN: Code duplicated, block: B:220:0x0483  */
    /* JADX WARN: Code duplicated, block: B:221:0x048c  */
    /* JADX WARN: Code duplicated, block: B:224:0x0490 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:225:0x0492  */
    /* JADX WARN: Code duplicated, block: B:226:0x049a  */
    /* JADX WARN: Code duplicated, block: B:228:0x049d  */
    /* JADX WARN: Code duplicated, block: B:234:0x04da  */
    /* JADX WARN: Code duplicated, block: B:237:0x0508  */
    /* JADX WARN: Code duplicated, block: B:239:0x050f  */
    /* JADX WARN: Code duplicated, block: B:240:0x0515  */
    /* JADX WARN: Code duplicated, block: B:242:0x0518  */
    /* JADX WARN: Code duplicated, block: B:243:0x0520  */
    /* JADX WARN: Code duplicated, block: B:245:0x0523  */
    /* JADX WARN: Code duplicated, block: B:246:0x052b  */
    /* JADX WARN: Code duplicated, block: B:248:0x052e  */
    /* JADX WARN: Code duplicated, block: B:251:0x053e A[LOOP:8: B:249:0x0538->B:251:0x053e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:255:0x055a A[LOOP:9: B:253:0x0554->B:255:0x055a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:256:0x0579 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:257:0x057b  */
    /* JADX WARN: Code duplicated, block: B:262:0x039f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:264:0x024b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:271:0x0585 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:277:0x013a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:278:0x016c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x01f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:283:0x038a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:0x038a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:301:0x03bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:302:0x03bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:307:0x03f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:309:0x03e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:313:0x0458 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:316:0x026e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:317:0x026d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0169  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:78:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:91:0x024a  */
    /* JADX WARN: Code duplicated, block: B:94:0x0251 A[Catch: all -> 0x027e, TryCatch #1 {, blocks: (B:92:0x024b, B:94:0x0251, B:96:0x0259, B:97:0x025f, B:99:0x0265, B:102:0x026e, B:103:0x0272, B:105:0x0276), top: B:264:0x024b }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0259 A[Catch: all -> 0x027e, TryCatch #1 {, blocks: (B:92:0x024b, B:94:0x0251, B:96:0x0259, B:97:0x025f, B:99:0x0265, B:102:0x026e, B:103:0x0272, B:105:0x0276), top: B:264:0x024b }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0265 A[Catch: all -> 0x027e, TryCatch #1 {, blocks: (B:92:0x024b, B:94:0x0251, B:96:0x0259, B:97:0x025f, B:99:0x0265, B:102:0x026e, B:103:0x0272, B:105:0x0276), top: B:264:0x024b }] */
    public final void b() {
        int i;
        int i2;
        boolean z;
        boolean z2;
        List<C0096b> list;
        EnumSet enumSetNoneOf;
        Iterator<C0096b> it2;
        Iterator it3;
        List<C0096b> listSubList;
        List<C0096b> listSubList2;
        NavEvent navEvent;
        ArrayList arrayList;
        POIAlongTheRouteChangedListener pOIAlongTheRouteChangedListener;
        int i3;
        int i4;
        NavigationEventListener navigationEventListener;
        Junction junction;
        NavEvent navEvent2;
        NavigationEventListener navigationEventListener2;
        CongestionInfo congestionInfo;
        CongestionInfo congestionInfo2;
        NavigationContext.getNavigationContext().getClass();
        NavLocation navLocationF = NavigationContext.getNavigationContext().h().f();
        if (navLocationF == null || !NavigationContext.getNavigationContext().h().q()) {
            return;
        }
        int i5 = 0;
        while (i5 < this.a.size()) {
            int currentRoute = this.d.getCurrentRoute();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            List<C0096b> list2 = this.a.get(i5);
            if (list2 == null || this.c.size() <= i5) {
                i = i5;
            } else {
                int iIntValue = this.c.get(i5).intValue();
                while (iIntValue < list2.size() && list2.get(iIntValue).c < currentRoute) {
                    iIntValue++;
                }
                this.c.set(i5, Integer.valueOf(iIntValue));
                boolean z3 = false;
                while (true) {
                    if (iIntValue < list2.size()) {
                        C0096b c0096b = list2.get(iIntValue);
                        double distanceToPoint = this.d.getDistanceToPoint(c0096b.c);
                        if (distanceToPoint <= 1400.0d) {
                            LocationPoint locationPoint = c0096b.a;
                            int i6 = i5;
                            double dMax = Math.max(0.0d, com.mappls.sdk.navigation.util.d.a(navLocationF.getLatitude(), navLocationF.getLongitude(), locationPoint.getLatitude(), locationPoint.getLongitude()) - ((double) c0096b.a()));
                            Integer num = this.b.get(locationPoint);
                            List<C0096b> list3 = list2;
                            if (num == null || i6 == 6 || i6 == 5 || i6 == 7) {
                                i2 = currentRoute;
                            } else {
                                i2 = currentRoute;
                                if (num.intValue() == 1 && a().a(navLocationF.getSpeed(), dMax, 150.0d, 0.0f)) {
                                    this.b.put(locationPoint, 2);
                                    arrayList3.add(c0096b);
                                }
                                iIntValue++;
                                i5 = i6;
                                list2 = list3;
                                currentRoute = i2;
                            }
                            int i7 = 4;
                            if (i6 == 4) {
                                if (i6 == i7) {
                                    if ((num != null || num.intValue() == 0) && a().a(navLocationF.getSpeed(), dMax, 150.0d, 0.0f)) {
                                        this.b.put(locationPoint, 1);
                                        arrayList2.add(c0096b);
                                    }
                                } else if (i6 == 5) {
                                    if ((num != null || num.intValue() == 0) && a().a(navLocationF.getSpeed(), dMax, 150.0d, 0.0f)) {
                                        this.b.put(locationPoint, 1);
                                        arrayList2.add(c0096b);
                                    }
                                    junction = (Junction) locationPoint;
                                    if (junction.getStartLatitude() != null || junction.getStartLongitude() == null) {
                                        if (distanceToPoint < ((Integer) NavigationContext.getNavigationContext().k().g.get()).intValue()) {
                                            junction.setLeftDistance(distanceToPoint);
                                            a(junction);
                                            i = i6;
                                            z2 = false;
                                            z = true;
                                        }
                                    } else if (this.d.getDistanceToPoint(c0096b.d) == 0.0d) {
                                        if (junction.getViaLatitude() != null && junction.getViaLongitude() != null) {
                                            junction.setEntryLeftDistance(this.d.getDistanceToPoint(c0096b.e));
                                        }
                                        junction.setLeftDistance(distanceToPoint);
                                        a(junction);
                                        i = i6;
                                        z2 = false;
                                        z = true;
                                    }
                                } else if (i6 == 6) {
                                    navEvent2 = (NavEvent) c0096b.a;
                                    navEvent2.setDistanceLeft(distanceToPoint);
                                    if ((num != null || num.intValue() == 0 || num.intValue() == 1) && distanceToPoint < ((Integer) NavigationContext.getNavigationContext().k().e.get()).intValue()) {
                                        this.b.put(locationPoint, 2);
                                        arrayList3.add(c0096b);
                                    }
                                    if (distanceToPoint < ((Integer) NavigationContext.getNavigationContext().k().d.get()).intValue()) {
                                        synchronized (this) {
                                            if (navEvent2.isVisible()) {
                                                if (!this.h.isEmpty()) {
                                                    for (NavigationEventListener navigationEventListener3 : this.h) {
                                                        if (navigationEventListener3 == null) {
                                                            navigationEventListener3.onNavigationEvent(navEvent2);
                                                        }
                                                    }
                                                }
                                                navigationEventListener2 = this.k;
                                                if (navigationEventListener2 != null) {
                                                    navigationEventListener2.onNavigationEvent(navEvent2);
                                                }
                                            }
                                        }
                                        i = i6;
                                        z2 = true;
                                    }
                                    z = false;
                                } else {
                                    if (i6 != 7) {
                                        if (((Integer) NavigationContext.getNavigationContext().k().h.get()).intValue() < 20) {
                                            congestionInfo2 = (CongestionInfo) locationPoint;
                                            if (congestionInfo2.getStartPoint() == null && congestionInfo2.getStartNodeIndex() != null && this.d.getDistanceToPoint(c0096b.d) == 0.0d) {
                                                if (congestionInfo2.getEndPoint() != null && congestionInfo2.getEndNodeIndex() != null) {
                                                    congestionInfo2.setCongestionRemainingDistance(this.d.getDistanceToPoint(c0096b.e));
                                                    congestionInfo2.setCongestionRemainingDelay(this.d.getDurationToNodeFromCurrent(c0096b.e) - this.d.getBaseDurationToNodeFromCurrent(c0096b.e));
                                                }
                                                if (!this.j.isEmpty()) {
                                                    for (CongestionInfoChangedListener congestionInfoChangedListener : this.j) {
                                                        if (congestionInfoChangedListener != null) {
                                                            congestionInfoChangedListener.onCongestionInfoChanged(congestionInfo2);
                                                        }
                                                    }
                                                }
                                                z3 = true;
                                            }
                                        } else if (distanceToPoint < ((Integer) NavigationContext.getNavigationContext().k().h.get()).intValue()) {
                                            congestionInfo = (CongestionInfo) locationPoint;
                                            if (congestionInfo.getStartPoint() == null && congestionInfo.getStartNodeIndex() != null) {
                                                if (congestionInfo.getEndPoint() != null && congestionInfo.getEndNodeIndex() != null) {
                                                    congestionInfo.setCongestionRemainingDistance(this.d.getDistanceToPoint(c0096b.e));
                                                    congestionInfo.setCongestionRemainingDelay(this.d.getDurationToNodeFromCurrent(congestionInfo.getEndNodeIndex().intValue()) - this.d.getBaseDurationToNodeFromCurrent(congestionInfo.getEndNodeIndex().intValue()));
                                                }
                                                congestionInfo.setCongestionStartDistance(distanceToPoint);
                                                if (!this.j.isEmpty()) {
                                                    for (CongestionInfoChangedListener congestionInfoChangedListener2 : this.j) {
                                                        if (congestionInfoChangedListener2 != null) {
                                                            congestionInfoChangedListener2.onCongestionInfoChanged(congestionInfo);
                                                        }
                                                    }
                                                }
                                                z3 = true;
                                            }
                                        }
                                    }
                                    iIntValue++;
                                    i5 = i6;
                                    list2 = list3;
                                    currentRoute = i2;
                                }
                                i = i6;
                                z2 = false;
                                z = false;
                            } else {
                                if ((num == null || num.intValue() == 0) && a().a(navLocationF.getSpeed(), dMax, 700.0d, 0.0f)) {
                                    this.b.put(locationPoint, 1);
                                    arrayList2.add(c0096b);
                                } else {
                                    i7 = 4;
                                    if (i6 == i7) {
                                        if (num != null) {
                                            this.b.put(locationPoint, 1);
                                            arrayList2.add(c0096b);
                                        } else {
                                            this.b.put(locationPoint, 1);
                                            arrayList2.add(c0096b);
                                        }
                                    } else if (i6 == 5) {
                                        if (num != null) {
                                            this.b.put(locationPoint, 1);
                                            arrayList2.add(c0096b);
                                        } else {
                                            this.b.put(locationPoint, 1);
                                            arrayList2.add(c0096b);
                                        }
                                        junction = (Junction) locationPoint;
                                        if (junction.getStartLatitude() != null) {
                                            if (distanceToPoint < ((Integer) NavigationContext.getNavigationContext().k().g.get()).intValue()) {
                                                junction.setLeftDistance(distanceToPoint);
                                                a(junction);
                                                i = i6;
                                                z2 = false;
                                                z = true;
                                            }
                                        } else if (distanceToPoint < ((Integer) NavigationContext.getNavigationContext().k().g.get()).intValue()) {
                                            junction.setLeftDistance(distanceToPoint);
                                            a(junction);
                                            i = i6;
                                            z2 = false;
                                            z = true;
                                        }
                                    } else if (i6 == 6) {
                                        navEvent2 = (NavEvent) c0096b.a;
                                        navEvent2.setDistanceLeft(distanceToPoint);
                                        if (num != null) {
                                            this.b.put(locationPoint, 2);
                                            arrayList3.add(c0096b);
                                        } else {
                                            this.b.put(locationPoint, 2);
                                            arrayList3.add(c0096b);
                                        }
                                        if (distanceToPoint < ((Integer) NavigationContext.getNavigationContext().k().d.get()).intValue()) {
                                            synchronized (this) {
                                                if (navEvent2.isVisible()) {
                                                    if (!this.h.isEmpty()) {
                                                        while (r3.hasNext()) {
                                                            if (navigationEventListener3 == null) {
                                                                navigationEventListener3.onNavigationEvent(navEvent2);
                                                            }
                                                        }
                                                    }
                                                    navigationEventListener2 = this.k;
                                                    if (navigationEventListener2 != null) {
                                                        navigationEventListener2.onNavigationEvent(navEvent2);
                                                    }
                                                }
                                                i = i6;
                                                z2 = true;
                                            }
                                            if (!z && i == 5) {
                                                a((Junction) null);
                                            }
                                            if (!z3 && i == 7 && !this.j.isEmpty()) {
                                                for (CongestionInfoChangedListener congestionInfoChangedListener3 : this.j) {
                                                    if (congestionInfoChangedListener3 != null) {
                                                        congestionInfoChangedListener3.onCongestionInfoChanged(null);
                                                    }
                                                }
                                            }
                                            if (i == 2) {
                                                arrayList = new ArrayList();
                                                List<C0096b> list4 = this.a.get(2);
                                                NavigationLogger.d("total pois = %d", Integer.valueOf(list4.size()));
                                                for (C0096b c0096b2 : list4) {
                                                    i3 = c0096b2.c;
                                                    i4 = i2;
                                                    if (i4 < i3) {
                                                        d dVar = (d) c0096b2.a;
                                                        this.d.getDistanceToPoint(i3);
                                                        dVar.getClass();
                                                        arrayList.add((d) c0096b2.a);
                                                        NavigationLogger.d("POIs = %s", new Gson().toJson(c0096b2.a));
                                                    }
                                                    i2 = i4;
                                                }
                                                pOIAlongTheRouteChangedListener = this.f;
                                                if (pOIAlongTheRouteChangedListener != null) {
                                                    pOIAlongTheRouteChangedListener.onPlaceChanged(arrayList);
                                                }
                                            }
                                            if (!arrayList3.isEmpty()) {
                                                if (arrayList3.size() > 3) {
                                                    listSubList2 = arrayList3;
                                                    listSubList2 = arrayList3.subList(0, 3);
                                                }
                                                listSubList2 = arrayList3;
                                                if (i == 1) {
                                                    a().c(listSubList2);
                                                } else if (i == 2) {
                                                    a().b(listSubList2);
                                                } else if (i != 4) {
                                                    if (i == 3) {
                                                        a().a(listSubList2);
                                                    } else if (i == 6 && ((Boolean) NavigationContext.getNavigationContext().k().M.get()).booleanValue() && !((Boolean) NavigationContext.getNavigationContext().k().p0.get()).booleanValue()) {
                                                        navEvent = (NavEvent) listSubList2.get(0).a;
                                                        if (navEvent.isShouldSpeak()) {
                                                            a().a(String.format(Locale.getDefault(), "%s in %s ahead", navEvent.getName(), DirectionFormatter.getFormattedDistanceRound((float) navEvent.getDistanceLeft(), NavigationUtils.getDistanceType(), true)));
                                                        }
                                                    }
                                                }
                                            }
                                            if (!arrayList2.isEmpty()) {
                                                if (arrayList2.size() > 1) {
                                                    listSubList = arrayList2.subList(0, 1);
                                                }
                                                if (i == 1) {
                                                    list = arrayList2;
                                                    list = listSubList;
                                                    a().c(navLocationF, list);
                                                } else {
                                                    list = arrayList2;
                                                    if (i == 2) {
                                                        list = listSubList;
                                                        a().b(navLocationF, list);
                                                    } else if (i == 4) {
                                                        list = listSubList;
                                                        enumSetNoneOf = EnumSet.noneOf(com.mappls.sdk.navigation.routing.a.EnumC0099a.class);
                                                        it2 = list.iterator();
                                                        while (it2.hasNext()) {
                                                            enumSetNoneOf.add(((com.mappls.sdk.navigation.routing.a) it2.next().a).b());
                                                        }
                                                        it3 = enumSetNoneOf.iterator();
                                                        while (it3.hasNext()) {
                                                            NavigationContext.getNavigationContext().h().o().a(new com.mappls.sdk.navigation.routing.a((com.mappls.sdk.navigation.routing.a.EnumC0099a) it3.next()), navLocationF.getSpeed());
                                                        }
                                                    } else if (i == 3) {
                                                        a().a(navLocationF, list);
                                                    }
                                                }
                                            }
                                        }
                                        z = false;
                                    } else if (i6 != 7) {
                                        if (((Integer) NavigationContext.getNavigationContext().k().h.get()).intValue() < 20) {
                                            congestionInfo2 = (CongestionInfo) locationPoint;
                                            if (congestionInfo2.getStartPoint() == null) {
                                            }
                                        } else if (distanceToPoint < ((Integer) NavigationContext.getNavigationContext().k().h.get()).intValue()) {
                                            congestionInfo = (CongestionInfo) locationPoint;
                                            if (congestionInfo.getStartPoint() == null) {
                                            }
                                        }
                                    }
                                    i = i6;
                                    z2 = false;
                                    z = false;
                                }
                                iIntValue++;
                                i5 = i6;
                                list2 = list3;
                                currentRoute = i2;
                            }
                            i5 = i + 1;
                        }
                        if (!z2 && i == 6) {
                            synchronized (this) {
                                if (!this.h.isEmpty()) {
                                    for (NavigationEventListener navigationEventListener4 : this.h) {
                                        if (navigationEventListener4 == null) {
                                            navigationEventListener4.onNavigationEvent(null);
                                        }
                                    }
                                }
                                navigationEventListener = this.k;
                                if (navigationEventListener != null) {
                                    navigationEventListener.onNavigationEvent(null);
                                }
                            }
                        }
                        if (!z) {
                            a((Junction) null);
                        }
                        if (!z3) {
                            while (r3.hasNext()) {
                                if (congestionInfoChangedListener3 != null) {
                                    congestionInfoChangedListener3.onCongestionInfoChanged(null);
                                }
                            }
                        }
                        if (i == 2) {
                            arrayList = new ArrayList();
                            List<C0096b> list5 = this.a.get(2);
                            NavigationLogger.d("total pois = %d", Integer.valueOf(list5.size()));
                            while (r3.hasNext()) {
                                i3 = c0096b2.c;
                                i4 = i2;
                                if (i4 < i3) {
                                    d dVar2 = (d) c0096b2.a;
                                    this.d.getDistanceToPoint(i3);
                                    dVar2.getClass();
                                    arrayList.add((d) c0096b2.a);
                                    NavigationLogger.d("POIs = %s", new Gson().toJson(c0096b2.a));
                                }
                                i2 = i4;
                            }
                            pOIAlongTheRouteChangedListener = this.f;
                            if (pOIAlongTheRouteChangedListener != null) {
                                pOIAlongTheRouteChangedListener.onPlaceChanged(arrayList);
                            }
                        }
                        if (!arrayList3.isEmpty()) {
                            if (arrayList3.size() > 3) {
                                listSubList2 = arrayList3;
                                listSubList2 = arrayList3.subList(0, 3);
                            }
                            listSubList2 = arrayList3;
                            if (i == 1) {
                                a().c(listSubList2);
                            } else if (i == 2) {
                                a().b(listSubList2);
                            } else if (i != 4) {
                                if (i == 3) {
                                    a().a(listSubList2);
                                } else if (i == 6) {
                                    navEvent = (NavEvent) listSubList2.get(0).a;
                                    if (navEvent.isShouldSpeak()) {
                                        a().a(String.format(Locale.getDefault(), "%s in %s ahead", navEvent.getName(), DirectionFormatter.getFormattedDistanceRound((float) navEvent.getDistanceLeft(), NavigationUtils.getDistanceType(), true)));
                                    }
                                }
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            if (arrayList2.size() > 1) {
                                listSubList = arrayList2.subList(0, 1);
                            }
                            if (i == 1) {
                                list = arrayList2;
                                list = listSubList;
                                a().c(navLocationF, list);
                            } else {
                                list = arrayList2;
                                if (i == 2) {
                                    list = listSubList;
                                    a().b(navLocationF, list);
                                } else if (i == 4) {
                                    list = listSubList;
                                    enumSetNoneOf = EnumSet.noneOf(com.mappls.sdk.navigation.routing.a.EnumC0099a.class);
                                    it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        enumSetNoneOf.add(((com.mappls.sdk.navigation.routing.a) it2.next().a).b());
                                    }
                                    it3 = enumSetNoneOf.iterator();
                                    while (it3.hasNext()) {
                                        NavigationContext.getNavigationContext().h().o().a(new com.mappls.sdk.navigation.routing.a((com.mappls.sdk.navigation.routing.a.EnumC0099a) it3.next()), navLocationF.getSpeed());
                                    }
                                } else if (i == 3) {
                                    a().a(navLocationF, list);
                                }
                            }
                        }
                        i5 = i + 1;
                    }
                    i = i5;
                    i2 = currentRoute;
                    z2 = false;
                    z = false;
                    if (!z2) {
                        synchronized (this) {
                            if (!this.h.isEmpty()) {
                                while (r3.hasNext()) {
                                    if (navigationEventListener4 == null) {
                                        navigationEventListener4.onNavigationEvent(null);
                                    }
                                }
                            }
                            navigationEventListener = this.k;
                            if (navigationEventListener != null) {
                                navigationEventListener.onNavigationEvent(null);
                            }
                        }
                    }
                    if (!z) {
                        a((Junction) null);
                    }
                    if (!z3) {
                        while (r3.hasNext()) {
                            if (congestionInfoChangedListener3 != null) {
                                congestionInfoChangedListener3.onCongestionInfoChanged(null);
                            }
                        }
                    }
                    if (i == 2) {
                        arrayList = new ArrayList();
                        List<C0096b> list6 = this.a.get(2);
                        NavigationLogger.d("total pois = %d", Integer.valueOf(list6.size()));
                        while (r3.hasNext()) {
                            i3 = c0096b2.c;
                            i4 = i2;
                            if (i4 < i3) {
                                d dVar3 = (d) c0096b2.a;
                                this.d.getDistanceToPoint(i3);
                                dVar3.getClass();
                                arrayList.add((d) c0096b2.a);
                                NavigationLogger.d("POIs = %s", new Gson().toJson(c0096b2.a));
                            }
                            i2 = i4;
                        }
                        pOIAlongTheRouteChangedListener = this.f;
                        if (pOIAlongTheRouteChangedListener != null) {
                            pOIAlongTheRouteChangedListener.onPlaceChanged(arrayList);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        if (arrayList3.size() > 3) {
                            listSubList2 = arrayList3;
                            listSubList2 = arrayList3.subList(0, 3);
                        }
                        listSubList2 = arrayList3;
                        if (i == 1) {
                            a().c(listSubList2);
                        } else if (i == 2) {
                            a().b(listSubList2);
                        } else if (i != 4) {
                            if (i == 3) {
                                a().a(listSubList2);
                            } else if (i == 6) {
                                navEvent = (NavEvent) listSubList2.get(0).a;
                                if (navEvent.isShouldSpeak()) {
                                    a().a(String.format(Locale.getDefault(), "%s in %s ahead", navEvent.getName(), DirectionFormatter.getFormattedDistanceRound((float) navEvent.getDistanceLeft(), NavigationUtils.getDistanceType(), true)));
                                }
                            }
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        if (arrayList2.size() > 1) {
                            listSubList = arrayList2.subList(0, 1);
                        }
                        if (i == 1) {
                            list = arrayList2;
                            list = listSubList;
                            a().c(navLocationF, list);
                        } else {
                            list = arrayList2;
                            if (i == 2) {
                                list = listSubList;
                                a().b(navLocationF, list);
                            } else if (i == 4) {
                                list = listSubList;
                                enumSetNoneOf = EnumSet.noneOf(com.mappls.sdk.navigation.routing.a.EnumC0099a.class);
                                it2 = list.iterator();
                                while (it2.hasNext()) {
                                    enumSetNoneOf.add(((com.mappls.sdk.navigation.routing.a) it2.next().a).b());
                                }
                                it3 = enumSetNoneOf.iterator();
                                while (it3.hasNext()) {
                                    NavigationContext.getNavigationContext().h().o().a(new com.mappls.sdk.navigation.routing.a((com.mappls.sdk.navigation.routing.a.EnumC0099a) it3.next()), navLocationF.getSpeed());
                                }
                            } else if (i == 3) {
                                a().a(navLocationF, list);
                            }
                        }
                    }
                    i5 = i + 1;
                }
            }
            i5 = i + 1;
        }
    }

    public final void b(CongestionInfoChangedListener congestionInfoChangedListener) {
        this.j.remove(congestionInfoChangedListener);
    }

    public final void b(JunctionInfoChangedListener junctionInfoChangedListener) {
        this.i.remove(junctionInfoChangedListener);
    }

    public final void b(NavigationEventListener navigationEventListener) {
        this.h.remove(navigationEventListener);
    }

    @Deprecated
    public final void c(JunctionInfoChangedListener junctionInfoChangedListener) {
        this.l = junctionInfoChangedListener;
    }

    @Deprecated
    public final void c(NavigationEventListener navigationEventListener) {
        this.k = navigationEventListener;
    }

    protected final void a(NavigationRoute navigationRoute, int i, List<List<C0096b>> list) {
        Iterator<com.mappls.sdk.navigation.routing.a> it2;
        C0096b c0096b;
        s.j jVar;
        boolean z = i == -1;
        this.e = NavigationContext.getNavigationContext().k().e();
        if (navigationRoute == null || navigationRoute.isEmpty()) {
            return;
        }
        boolean zBooleanValue = ((Boolean) NavigationContext.getNavigationContext().k().E.get()).booleanValue();
        ((Boolean) NavigationContext.getNavigationContext().k().Z.get()).booleanValue();
        if (navigationRoute.getAppMode() != null) {
            this.e = navigationRoute.getAppMode();
        }
        boolean zBooleanValue2 = ((Boolean) NavigationContext.getNavigationContext().k().G.a(this.e)).booleanValue();
        ((Boolean) NavigationContext.getNavigationContext().k().F.a(this.e)).booleanValue();
        ((Boolean) NavigationContext.getNavigationContext().k().a0.a(this.e)).booleanValue();
        ((Boolean) NavigationContext.getNavigationContext().k().b0.a(this.e)).booleanValue();
        boolean zBooleanValue3 = ((Boolean) NavigationContext.getNavigationContext().k().J.a(this.e)).booleanValue();
        boolean zBooleanValue4 = ((Boolean) NavigationContext.getNavigationContext().k().K.a(this.e)).booleanValue();
        boolean zBooleanValue5 = ((Boolean) NavigationContext.getNavigationContext().k().L.a(this.e)).booleanValue();
        ((Boolean) NavigationContext.getNavigationContext().k().c0.a(this.e)).booleanValue();
        ((Boolean) NavigationContext.getNavigationContext().k().d0.a(this.e)).booleanValue();
        if (i == 4 || z) {
            List listA = a(list, 4);
            if (navigationRoute.getAppMode() != null) {
                com.mappls.sdk.navigation.d dVar = this.e;
                Iterator<com.mappls.sdk.navigation.routing.a> it3 = navigationRoute.getAlarmInfo().iterator();
                while (it3.hasNext()) {
                    com.mappls.sdk.navigation.routing.a next = it3.next();
                    if (next.b() != com.mappls.sdk.navigation.routing.a.EnumC0099a.b) {
                        it2 = it3;
                        if (NavigationContext.getNavigationContext().k().C.a(dVar).booleanValue() || ((Boolean) NavigationContext.getNavigationContext().k().V.a(dVar)).booleanValue()) {
                            c0096b = new C0096b(next, 0.0f, next.a());
                            jVar = NavigationContext.getNavigationContext().k().V;
                        }
                        it3 = it2;
                    } else if (((Boolean) NavigationContext.getNavigationContext().k().D.a(dVar)).booleanValue() || ((Boolean) NavigationContext.getNavigationContext().k().Y.a(dVar)).booleanValue()) {
                        it2 = it3;
                        c0096b = new C0096b(next, 0.0f, next.a());
                        jVar = NavigationContext.getNavigationContext().k().Y;
                    }
                    ((Boolean) jVar.get()).booleanValue();
                    listA.add(c0096b);
                    it3 = it2;
                }
                b(listA);
            }
        }
        if (i == 1 || z) {
            List listA2 = a(list, 1);
            if (zBooleanValue) {
                NavigationContext.getNavigationContext().c().getClass();
                a(navigationRoute, listA2, Collections.emptyList());
                a(navigationRoute, listA2, navigationRoute.getLocationPoints());
                b(listA2);
            }
        }
        if (i == 2 || z) {
            List listA3 = a(list, 2);
            if (zBooleanValue2) {
                for (d dVar2 : this.g) {
                    if (navigationRoute.getCurrentRoute() < dVar2.a()) {
                        listA3.add(new C0096b(dVar2, 0.0f, dVar2.a()));
                    }
                }
                b(listA3);
            }
        }
        if (i == 5 || z) {
            List listA4 = a(list, 5);
            if (zBooleanValue3) {
                List<Junction> junctionViews = navigationRoute.getJunctionViews();
                if (junctionViews != null && junctionViews.size() > 0) {
                    for (Junction junction : junctionViews) {
                        Integer num = junction.startNodeIdx;
                        listA4.add(num != null ? new C0096b(junction, junction.nodeIdx, num.intValue(), junction.viaNodeIdx) : new C0096b(junction, 0.0f, junction.nodeIdx));
                    }
                }
                NavigationLogger.d("calculateJunction", new Object[0]);
                b(listA4);
            }
        }
        if (i == 6 || z) {
            List listA5 = a(list, 6);
            if (zBooleanValue4) {
                List<NavEvent> internalEvents = navigationRoute.getInternalEvents();
                if (internalEvents != null && internalEvents.size() > 0) {
                    for (NavEvent navEvent : internalEvents) {
                        listA5.add(new C0096b(navEvent, 0.0f, navEvent.getIndex() != null ? navEvent.getIndex().intValue() : 0));
                    }
                }
                NavigationLogger.d("calculateNavigationEvents", new Object[0]);
                b(listA5);
            }
        }
        if (i == 7 || z) {
            List listA6 = a(list, 7);
            if (zBooleanValue5) {
                List<CongestionInfo> congestionInfos = navigationRoute.getCongestionInfos();
                if (congestionInfos != null && congestionInfos.size() > 0) {
                    for (CongestionInfo congestionInfo : congestionInfos) {
                        listA6.add(new C0096b(congestionInfo, congestionInfo.getStartNodeIndex().intValue(), congestionInfo.getStartNodeIndex().intValue(), congestionInfo.getEndNodeIndex().intValue()));
                    }
                }
                NavigationLogger.d("calculateCongestionDelayEvents", new Object[0]);
                b(listA6);
            }
        }
    }

    public final void a(NavigationRoute navigationRoute) {
        ArrayList arrayList = new ArrayList();
        a(navigationRoute, 1, arrayList);
        if (navigationRoute.getEvents().size() > 0) {
            a(navigationRoute, 6, arrayList);
        }
        if (navigationRoute.getJunctionViews().size() > 0) {
            a(navigationRoute, 5, arrayList);
        }
        if (navigationRoute.getCongestionInfos().size() > 0) {
            a(navigationRoute, 7, arrayList);
        }
        synchronized (this) {
            this.a = arrayList;
            ConcurrentHashMap<LocationPoint, Integer> concurrentHashMap = this.b;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(0);
            }
            this.c = new ArrayList<>(Collections.nCopies(arrayList.size(), 0));
            this.d = navigationRoute;
        }
    }
}
