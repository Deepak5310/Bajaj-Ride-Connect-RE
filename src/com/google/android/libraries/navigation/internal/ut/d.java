package com.google.android.libraries.navigation.internal.ut;

import android.view.View;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.t;
import com.google.android.libraries.navigation.internal.tj.u;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface d extends cs {

    /* JADX INFO: compiled from: PG */
    public interface a {
        int a();
    }

    /* JADX INFO: compiled from: PG */
    public interface b extends cs {

        /* JADX INFO: compiled from: PG */
        public enum a {
            ACCEPT,
            DISMISS,
            EXIT,
            NAVIGATE,
            REPLACE_STOP,
            ADD_STOP,
            REMOVE_STOP,
            SEARCH,
            REROUTE,
            SHARE,
            CONFIRM,
            DENY,
            EXIT_NAV_AND_ETA_SHARING,
            WHY_THIS_AD_DISMISS,
            REPLACE_EV_CHARGING_STATION,
            MAPS_SUGGEST_CHARGING_STATION_SEARCH
        }

        cs.a c();

        aa d();

        com.google.android.libraries.navigation.internal.ki.a e();

        com.google.android.libraries.navigation.internal.ms.c f();

        t h();

        t i();

        com.google.android.libraries.navigation.internal.ut.b j();

        a k();

        Boolean l();

        @Deprecated
        Boolean m();

        Boolean n();

        Boolean o();

        Boolean p();

        String q();
    }

    /* JADX INFO: compiled from: PG */
    public enum c {
        DEFAULT,
        CHEVRON_PICKER,
        PROMPT_WITH_CHOICE,
        NAVIGATION_POPUP,
        JRNY_PENDING,
        JRNY_PEOPLE_PICKER,
        REPORT_INCIDENT,
        VOTABLE_INCIDENT,
        SELF_REPORTED_INCIDENT,
        WAYPOINT_ALERT,
        ENROUTE_SEARCH_RESULT_LIST,
        AD_POI,
        NAVATARS_PICKER
    }

    /* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.ut.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PG */
    public interface InterfaceC0038d extends b, com.google.android.libraries.navigation.internal.ah.a.InterfaceC0032a {
        com.google.android.libraries.navigation.internal.ah.a b();
    }

    CharSequence A();

    Integer B();

    Integer C();

    Integer D();

    Integer E();

    String F();

    List<b> G();

    List<com.google.android.libraries.navigation.internal.ai.c> H();

    void M(int i, int i2, int i3);

    void O();

    void P(boolean z);

    void Q(int i);

    void b();

    void c();

    c f();

    View.AccessibilityDelegate i();

    aa j();

    ah k();

    u l();

    b n();

    b o();

    InterfaceC0038d p();

    Boolean r();

    Boolean s();

    Boolean t();

    Boolean u();

    Boolean v();

    Boolean w();

    CharSequence x();

    CharSequence y();

    CharSequence z();
}
