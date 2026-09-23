package com.google.android.libraries.navigation.internal.ly;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.FeatureLayerOptions;
import com.google.android.gms.maps.model.FollowMyLocationOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapColorScheme;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.libraries.navigation.internal.afl.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface k {
    void A() throws RemoteException;

    void B(boolean z) throws RemoteException;

    void C(String str) throws RemoteException;

    void D(m mVar) throws RemoteException;

    void E(LatLngBounds latLngBounds) throws RemoteException;

    void F(@MapColorScheme int i) throws RemoteException;

    void G(int i) throws RemoteException;

    void H(float f) throws RemoteException;

    void I(float f) throws RemoteException;

    void J(boolean z) throws RemoteException;

    void K(u uVar) throws RemoteException;

    void L(x xVar) throws RemoteException;

    void M(z zVar) throws RemoteException;

    void N(ab abVar) throws RemoteException;

    void O(ad adVar) throws RemoteException;

    void P(af afVar) throws RemoteException;

    void Q(v vVar) throws RemoteException;

    void R(ah ahVar) throws RemoteException;

    void S(aj ajVar) throws RemoteException;

    void T(al alVar) throws RemoteException;

    void U(an anVar) throws RemoteException;

    void V(ap apVar) throws RemoteException;

    void W(av avVar) throws RemoteException;

    void X(ax axVar) throws RemoteException;

    void Y(az azVar) throws RemoteException;

    void Z(bd bdVar) throws RemoteException;

    float a() throws RemoteException;

    void aa(bf bfVar) throws RemoteException;

    void ab(bh bhVar) throws RemoteException;

    void ac(bj bjVar) throws RemoteException;

    void ad(bl blVar) throws RemoteException;

    void ae(bn bnVar) throws RemoteException;

    void af(bp bpVar) throws RemoteException;

    void ag(br brVar) throws RemoteException;

    void ah(int i, int i2, int i3, int i4) throws RemoteException;

    void ai(boolean z) throws RemoteException;

    void aj(ch chVar, com.google.android.libraries.navigation.internal.lo.l lVar) throws RemoteException;

    void ak() throws RemoteException;

    boolean al() throws RemoteException;

    boolean am() throws RemoteException;

    boolean an() throws RemoteException;

    boolean ao() throws RemoteException;

    boolean ap() throws RemoteException;

    boolean aq(boolean z) throws RemoteException;

    boolean ar(MapStyleOptions mapStyleOptions) throws RemoteException;

    float b() throws RemoteException;

    @MapColorScheme
    int c() throws RemoteException;

    int d() throws RemoteException;

    Location e() throws RemoteException;

    cf f() throws RemoteException;

    cp g() throws RemoteException;

    CameraPosition h() throws RemoteException;

    com.google.android.libraries.navigation.internal.lz.d i(CircleOptions circleOptions) throws RemoteException;

    com.google.android.libraries.navigation.internal.lz.f j(FeatureLayerOptions featureLayerOptions) throws RemoteException;

    com.google.android.libraries.navigation.internal.lz.h k(GroundOverlayOptions groundOverlayOptions) throws RemoteException;

    com.google.android.libraries.navigation.internal.lz.j l() throws RemoteException;

    com.google.android.libraries.navigation.internal.lz.n m() throws RemoteException;

    com.google.android.libraries.navigation.internal.lz.p n(MarkerOptions markerOptions) throws RemoteException;

    com.google.android.libraries.navigation.internal.lz.t o(PolygonOptions polygonOptions) throws RemoteException;

    com.google.android.libraries.navigation.internal.lz.v p(PolylineOptions polylineOptions) throws RemoteException;

    com.google.android.libraries.navigation.internal.lz.z q(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    void r(at atVar) throws RemoteException;

    void s(com.google.android.libraries.navigation.internal.lo.l lVar) throws RemoteException;

    void t(com.google.android.libraries.navigation.internal.lo.l lVar, g gVar) throws RemoteException;

    void u(com.google.android.libraries.navigation.internal.lo.l lVar, int i, g gVar) throws RemoteException;

    void v() throws RemoteException;

    void w(fd fdVar, FollowMyLocationOptions followMyLocationOptions) throws RemoteException;

    void x(bb bbVar) throws RemoteException;

    void y(com.google.android.libraries.navigation.internal.lo.l lVar) throws RemoteException;

    void z(at atVar) throws RemoteException;
}
