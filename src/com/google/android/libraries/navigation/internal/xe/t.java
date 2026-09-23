package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.adr.hu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t {
    public static final o[] a;
    public static final com.google.android.libraries.navigation.internal.yz.fd b;

    static {
        com.google.android.libraries.navigation.internal.aap.l lVar = com.google.android.libraries.navigation.internal.aap.l.DESTINATION;
        hs hsVar = hs.SIDE_LEFT;
        hs hsVar2 = hs.SIDE_UNSPECIFIED;
        com.google.android.libraries.navigation.internal.aap.l lVar2 = com.google.android.libraries.navigation.internal.aap.l.TURN;
        hs hsVar3 = hs.SIDE_LEFT;
        com.google.android.libraries.navigation.internal.aap.l lVar3 = com.google.android.libraries.navigation.internal.aap.l.OFF_RAMP;
        hs hsVar4 = hs.SIDE_UNSPECIFIED;
        com.google.android.libraries.navigation.internal.aap.l lVar4 = com.google.android.libraries.navigation.internal.aap.l.UTURN;
        hs hsVar5 = hs.SIDE_RIGHT;
        com.google.android.libraries.navigation.internal.aap.l lVar5 = com.google.android.libraries.navigation.internal.aap.l.FORK;
        hs hsVar6 = hs.SIDE_LEFT;
        com.google.android.libraries.navigation.internal.aap.l lVar6 = com.google.android.libraries.navigation.internal.aap.l.MERGE;
        a = new o[]{new o(com.google.android.libraries.navigation.internal.aap.l.DEPART, hs.SIDE_UNSPECIFIED, 1), new o(lVar, hs.SIDE_RIGHT, 4), new o(lVar, hsVar, 3), new o(lVar, hsVar2, 2), new o(com.google.android.libraries.navigation.internal.aap.l.NAME_CHANGE, hsVar2, 5), new s(hsVar, hu.TURN_NORMAL, 6), new s(hs.SIDE_RIGHT, hu.TURN_NORMAL, 7), new s(hs.SIDE_LEFT, hu.TURN_SLIGHT, 10), new s(hs.SIDE_RIGHT, hu.TURN_SLIGHT, 11), new s(hs.SIDE_LEFT, hu.TURN_KEEP, 8), new s(hs.SIDE_RIGHT, hu.TURN_KEEP, 9), new s(hs.SIDE_LEFT, hu.TURN_SHARP, 12), new s(hs.SIDE_RIGHT, hu.TURN_SHARP, 13), new s(hs.SIDE_RIGHT, hu.TURN_UTURN, 15), new s(hs.SIDE_UNSPECIFIED, hu.TURN_UTURN, 15), new s(hs.SIDE_UNSPECIFIED, hu.TURN_STRAIGHT, 5), new o(lVar2, hsVar3, 6), new o(lVar2, hs.SIDE_RIGHT, 7), new q(hsVar3, hu.TURN_NORMAL, 22), new q(hs.SIDE_RIGHT, hu.TURN_NORMAL, 23), new q(hs.SIDE_LEFT, hu.TURN_SLIGHT, 26), new q(hs.SIDE_RIGHT, hu.TURN_SLIGHT, 27), new q(hs.SIDE_LEFT, hu.TURN_KEEP, 24), new q(hs.SIDE_RIGHT, hu.TURN_KEEP, 25), new q(hs.SIDE_LEFT, hu.TURN_SHARP, 28), new q(hs.SIDE_RIGHT, hu.TURN_SHARP, 29), new q(hs.SIDE_RIGHT, hu.TURN_UTURN, 31), new q(hs.SIDE_UNSPECIFIED, hu.TURN_UNKNOWN, 21), new o(com.google.android.libraries.navigation.internal.aap.l.ON_RAMP, hs.SIDE_UNSPECIFIED, 21), new p(hs.SIDE_LEFT, hu.TURN_NORMAL, 33), new p(hs.SIDE_RIGHT, hu.TURN_NORMAL, 34), new p(hs.SIDE_LEFT, hu.TURN_SLIGHT, 37), new p(hs.SIDE_RIGHT, hu.TURN_SLIGHT, 38), new p(hs.SIDE_LEFT, hu.TURN_KEEP, 35), new p(hs.SIDE_RIGHT, hu.TURN_KEEP, 36), new p(hs.SIDE_LEFT, hu.TURN_SHARP, 39), new p(hs.SIDE_RIGHT, hu.TURN_SHARP, 40), new p(hs.SIDE_RIGHT, hu.TURN_UTURN, 42), new p(hs.SIDE_UNSPECIFIED, hu.TURN_UNKNOWN, 32), new o(lVar3, hsVar4, 32), new o(lVar4, hsVar5, 15), new o(lVar4, hsVar4, 15), new o(lVar5, hsVar6, 19), new o(lVar5, hsVar5, 20), new o(lVar6, hsVar6, 17), new o(lVar6, hsVar5, 18), new o(lVar6, hsVar4, 16), new o(com.google.android.libraries.navigation.internal.aap.l.STRAIGHT, hsVar4, 5), new o(com.google.android.libraries.navigation.internal.aap.l.FERRY, hsVar4, 63), new o(com.google.android.libraries.navigation.internal.aap.l.FERRY_TRAIN, hsVar4, 64), new o(com.google.android.libraries.navigation.internal.aap.l.NAME_CHANGE, hsVar4, 65), new r(hsVar5, hu.TURN_SHARP, 58), new r(hs.SIDE_RIGHT, hu.TURN_NORMAL, 50), new r(hs.SIDE_RIGHT, hu.TURN_SLIGHT, 54), new r(hs.SIDE_UNSPECIFIED, hu.TURN_STRAIGHT, 46), new r(hs.SIDE_LEFT, hu.TURN_SLIGHT, 52), new r(hs.SIDE_LEFT, hu.TURN_NORMAL, 48), new r(hs.SIDE_LEFT, hu.TURN_SHARP, 56), new r(hs.SIDE_UNSPECIFIED, hu.TURN_UTURN, 60), new r(hs.SIDE_UNSPECIFIED, hu.TURN_UNKNOWN, 44), new r(com.google.android.libraries.navigation.internal.aap.l.ROUNDABOUT_ENTER, hs.SIDE_UNSPECIFIED, hu.TURN_UNKNOWN, 44), new r(com.google.android.libraries.navigation.internal.aap.l.ROUNDABOUT_EXIT, hs.SIDE_UNSPECIFIED, hu.TURN_UNKNOWN, 62)};
        com.google.android.libraries.navigation.internal.yz.ez ezVar = new com.google.android.libraries.navigation.internal.yz.ez();
        ezVar.f(15, 14);
        ezVar.f(44, 43);
        ezVar.f(46, 45);
        ezVar.f(48, 47);
        ezVar.f(50, 49);
        ezVar.f(52, 51);
        ezVar.f(54, 53);
        ezVar.f(56, 55);
        ezVar.f(58, 57);
        ezVar.f(60, 59);
        ezVar.f(62, 61);
        ezVar.f(31, 30);
        ezVar.f(42, 41);
        b = ezVar.d();
    }
}
