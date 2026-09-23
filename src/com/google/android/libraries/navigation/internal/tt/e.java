package com.google.android.libraries.navigation.internal.tt;

import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adu.y;
import com.google.android.libraries.navigation.internal.afe.f;
import com.google.android.libraries.navigation.internal.afe.o;
import com.google.android.libraries.navigation.internal.afl.nz;
import com.google.android.libraries.navigation.internal.yz.cy;
import com.google.android.libraries.navigation.internal.yz.kc;
import java.util.EnumMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public static final EnumMap a;
    public static final EnumMap b;
    public static final cy c;

    static {
        EnumMap enumMapG = kc.g(Cdo.class);
        a = enumMapG;
        EnumMap enumMapG2 = kc.g(Cdo.class);
        b = enumMapG2;
        cy cyVar = new cy(Cdo.class, nz.class);
        c = cyVar;
        enumMapG.put(Cdo.INCIDENT_CRASH, o.x);
        enumMapG.put(Cdo.INCIDENT_CONSTRUCTION, o.y);
        enumMapG.put(Cdo.INCIDENT_OTHER, o.C);
        enumMapG.put(Cdo.INCIDENT_ROAD_CLOSED, o.F);
        enumMapG.put(Cdo.INCIDENT_JAM, o.C);
        enumMapG.put(Cdo.INCIDENT_SPEED_CAMERA, o.H);
        enumMapG.put(Cdo.INCIDENT_SPEED_TRAP, o.I);
        enumMapG.put(Cdo.INCIDENT_SUSPECTED_JAM, o.C);
        enumMapG.put(Cdo.INCIDENT_SUSPECTED_CLOSURE, o.K);
        enumMapG.put(Cdo.INCIDENT_LANE_CLOSURE, o.D);
        enumMapG.put(Cdo.INCIDENT_STALLED_VEHICLE, o.J);
        enumMapG.put(Cdo.INCIDENT_OBJECT_ON_ROAD, o.E);
        enumMapG.put(Cdo.INCIDENT_ICE, o.B);
        enumMapG.put(Cdo.INCIDENT_SNOW, o.G);
        enumMapG.put(Cdo.INCIDENT_FOG, o.A);
        enumMapG.put(Cdo.INCIDENT_FLOOD, o.z);
        enumMapG2.put(Cdo.INCIDENT_CRASH, o.a);
        enumMapG2.put(Cdo.INCIDENT_CONSTRUCTION, o.c);
        enumMapG2.put(Cdo.INCIDENT_OTHER, o.g);
        enumMapG2.put(Cdo.INCIDENT_ROAD_CLOSED, o.j);
        enumMapG2.put(Cdo.INCIDENT_JAM, f.a);
        enumMapG2.put(Cdo.INCIDENT_SPEED_CAMERA, o.l);
        enumMapG2.put(Cdo.INCIDENT_SPEED_TRAP, o.m);
        enumMapG2.put(Cdo.INCIDENT_SUSPECTED_JAM, f.a);
        enumMapG2.put(Cdo.INCIDENT_SUSPECTED_CLOSURE, o.o);
        enumMapG2.put(Cdo.INCIDENT_LANE_CLOSURE, o.h);
        enumMapG2.put(Cdo.INCIDENT_STALLED_VEHICLE, o.f258n);
        enumMapG2.put(Cdo.INCIDENT_OBJECT_ON_ROAD, o.i);
        enumMapG2.put(Cdo.INCIDENT_ICE, o.f);
        enumMapG2.put(Cdo.INCIDENT_SNOW, o.k);
        enumMapG2.put(Cdo.INCIDENT_FOG, o.e);
        enumMapG2.put(Cdo.INCIDENT_FLOOD, o.d);
        enumMapG2.put(Cdo.INCIDENT_CHECKPOINT, o.b);
        enumMapG2.put(Cdo.INCIDENT_RAILROAD_CROSSING, com.google.android.libraries.navigation.internal.afe.a.d);
        enumMapG2.put(Cdo.INCIDENT_POLICE_PRESENCE, com.google.android.libraries.navigation.internal.afe.a.c);
        enumMapG2.put(Cdo.INCIDENT_MOBILE_SPEED_CAMERA, com.google.android.libraries.navigation.internal.afe.a.b);
        cyVar.put(Cdo.INCIDENT_CRASH, nz.INCIDENT_CRASH);
        cyVar.put(Cdo.INCIDENT_CONSTRUCTION, nz.INCIDENT_CONSTRUCTION);
        cyVar.put(Cdo.INCIDENT_OTHER, nz.INCIDENT_OTHER);
        cyVar.put(Cdo.INCIDENT_ROAD_CLOSED, nz.INCIDENT_ROAD_CLOSED);
        cyVar.put(Cdo.INCIDENT_JAM, nz.INCIDENT_JAM);
        cyVar.put(Cdo.INCIDENT_SPEED_TRAP, nz.INCIDENT_SPEED_TRAP);
        cyVar.put(Cdo.INCIDENT_SPEED_CAMERA, nz.INCIDENT_SPEED_CAMERA);
        cyVar.put(Cdo.INCIDENT_SUSPECTED_JAM, nz.INCIDENT_SUSPECTED_JAM);
        cyVar.put(Cdo.INCIDENT_SUSPECTED_CLOSURE, nz.INCIDENT_SUSPECTED_CLOSURE);
        cyVar.put(Cdo.INCIDENT_LANE_CLOSURE, nz.INCIDENT_LANE_CLOSURE);
        cyVar.put(Cdo.INCIDENT_STALLED_VEHICLE, nz.INCIDENT_STALLED_VEHICLE);
        cyVar.put(Cdo.INCIDENT_OBJECT_ON_ROAD, nz.INCIDENT_OBJECT_ON_ROAD);
        cyVar.put(Cdo.INCIDENT_ICE, nz.INCIDENT_ICE);
        cyVar.put(Cdo.INCIDENT_SNOW, nz.INCIDENT_SNOW);
        cyVar.put(Cdo.INCIDENT_FOG, nz.INCIDENT_FOG);
        cyVar.put(Cdo.INCIDENT_FLOOD, nz.INCIDENT_FLOOD);
        cyVar.put(Cdo.INCIDENT_CHECKPOINT, nz.INCIDENT_CHECKPOINT);
        cyVar.put(Cdo.INCIDENT_POLICE_PRESENCE, nz.INCIDENT_POLICE_PRESENCE);
        cyVar.put(Cdo.INCIDENT_MOBILE_SPEED_CAMERA, nz.INCIDENT_MOBILE_SPEED_CAMERA);
    }

    public static y a(Cdo cdo) {
        switch (cdo) {
            case INCIDENT_ROAD_CLOSED:
                return y.INCIDENT_ROAD_CLOSED;
            case INCIDENT_CRASH:
                return y.INCIDENT_CRASH;
            case INCIDENT_CONSTRUCTION:
                return y.INCIDENT_CONSTRUCTION;
            case INCIDENT_JAM:
            default:
                return y.UNKNOWN_INCIDENT_TYPE;
            case INCIDENT_SPEED_TRAP:
                return y.INCIDENT_MOBILE_CAMERA;
            case INCIDENT_SPEED_CAMERA:
                return y.INCIDENT_FIXED_CAMERA;
            case INCIDENT_SUSPECTED_JAM:
                return y.INCIDENT_SUSPECTED_JAM;
            case INCIDENT_SPEED_LIMIT:
                return y.INCIDENT_SPEED_LIMIT;
            case INCIDENT_SUSPECTED_CLOSURE:
                return y.INCIDENT_SUSPECTED_CLOSURE;
            case INCIDENT_LANE_CLOSURE:
                return y.INCIDENT_LANE_CLOSURE;
            case INCIDENT_STALLED_VEHICLE:
                return y.INCIDENT_STALLED_VEHICLE;
            case INCIDENT_OBJECT_ON_ROAD:
                return y.INCIDENT_OBJECT_ON_ROAD;
            case INCIDENT_POLICE_PRESENCE:
                return y.INCIDENT_POLICE_PRESENCE;
            case INCIDENT_MOBILE_SPEED_CAMERA:
                return y.INCIDENT_MOBILE_SPEED_CAMERA;
            case INCIDENT_HAZARD:
                return y.INCIDENT_HAZARD;
            case INCIDENT_BROKEN_TRAFFIC_LIGHT:
                return y.INCIDENT_BROKEN_TRAFFIC_LIGHT;
            case INCIDENT_POTHOLE:
                return y.INCIDENT_POTHOLE;
            case INCIDENT_WEATHER:
                return y.INCIDENT_WEATHER;
            case INCIDENT_ICE:
                return y.INCIDENT_ICE;
            case INCIDENT_SNOW:
                return y.INCIDENT_SNOW;
            case INCIDENT_FOG:
                return y.INCIDENT_FOG;
            case INCIDENT_FLOOD:
                return y.INCIDENT_FLOOD;
            case INCIDENT_SLIPPERY_ROAD:
                return y.INCIDENT_SLIPPERY_ROAD;
        }
    }
}
