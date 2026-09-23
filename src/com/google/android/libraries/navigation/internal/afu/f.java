package com.google.android.libraries.navigation.internal.afu;

import com.google.android.libraries.navigation.internal.xt.az;
import com.google.android.libraries.navigation.internal.xt.bh;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements e {
    public static final az A;
    public static final az B;
    public static final az C;
    public static final az D;
    public static final az E;
    public static final az F;
    public static final az G;
    public static final az H;
    public static final az I;
    public static final az J;
    public static final az K;
    public static final az L;
    public static final az M;
    public static final az N;
    public static final az O;
    public static final az P;
    public static final az Q;
    public static final az a;
    public static final az b;
    public static final az c;
    public static final az d;
    public static final az e;
    public static final az f;
    public static final az g;
    public static final az h;
    public static final az i;
    public static final az j;
    public static final az k;
    public static final az l;
    public static final az m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final az f330n;
    public static final az o;
    public static final az p;
    public static final az q;
    public static final az r;
    public static final az s;
    public static final az t;
    public static final az u;
    public static final az v;
    public static final az w;
    public static final az x;
    public static final az y;
    public static final az z;

    static {
        mb mbVar = mb.a;
        fy fyVarQ = fy.q("MAPS_API", "GMM_REALTIME_COUNTERS");
        a = bh.d("BugFixes__add_gmm_version_in_client_parameter_request", true, "com.google.android.gms.maps", fyVarQ, true);
        b = bh.d("BugFixes__add_renderer_version_for_phoenix", false, "com.google.android.gms.maps", fyVarQ, true);
        c = bh.d("BugFixes__check_for_null_points_in_polyline_options", false, "com.google.android.gms.maps", fyVarQ, true);
        d = bh.d("BugFixes__check_for_ui_thread_in_map_view_api_calls", true, "com.google.android.gms.maps", fyVarQ, true);
        e = bh.d("BugFixes__cloud_styling_styled_map_ready_logging_enabled", true, "com.google.android.gms.maps", fyVarQ, true);
        f = bh.d("BugFixes__cloud_styling_version_logging_enabled", true, "com.google.android.gms.maps", fyVarQ, true);
        g = bh.d("BugFixes__datasets_layer_creation", true, "com.google.android.gms.maps", fyVarQ, true);
        h = bh.d("BugFixes__enable_process_name_in_clearcut_counters", true, "com.google.android.gms.maps", fyVarQ, true);
        i = bh.d("BugFixes__enable_zwieback_always", true, "com.google.android.gms.maps", fyVarQ, true);
        j = bh.d("BugFixes__enforce_per_event_sampling_rates_in_usagelog_for_gmm10", false, "com.google.android.gms.maps", fyVarQ, true);
        k = bh.d("BugFixes__fallback_lite_mode_native_lib_load_failure", false, "com.google.android.gms.maps", fyVarQ, true);
        l = bh.d("BugFixes__fix_maps_api_version", true, "com.google.android.gms.maps", fyVarQ, true);
        m = bh.a("BugFixes__frame_end_callback_short_circuit_optimization", false, "com.google.android.gms.maps", fyVarQ, true);
        f330n = bh.d("BugFixes__handle_info_window_as_marker_property", true, "com.google.android.gms.maps", fyVarQ, true);
        o = bh.a("BugFixes__initialize_flogger_for_all_apps", false, "com.google.android.gms.maps", fyVarQ, true);
        p = bh.d("BugFixes__let_mapcore_detect_hardware_acceleration", false, "com.google.android.gms.maps", fyVarQ, true);
        q = bh.a("BugFixes__log_detailed_device_type_in_clearcut_gmm10", false, "com.google.android.gms.maps", fyVarQ, true);
        r = bh.d("BugFixes__log_map_load_for_sli_events_nav_exclusive", true, "com.google.android.gms.maps", fyVarQ, true);
        s = bh.d("BugFixes__log_on_low_memory_safe", false, "com.google.android.gms.maps", fyVarQ, true);
        t = bh.d("BugFixes__logging_with_metadata_allowed", true, "com.google.android.gms.maps", fyVarQ, true);
        u = bh.d("BugFixes__marker_click_priority", true, "com.google.android.gms.maps", fyVarQ, true);
        v = bh.d("BugFixes__marker_renderer_off_ui_thread_nav_safe", true, "com.google.android.gms.maps", fyVarQ, true);
        w = bh.d("BugFixes__muted_color_logo_on_cloud_styling", true, "com.google.android.gms.maps", fyVarQ, true);
        x = bh.d("BugFixes__noop_on_compass_missing_from_map_bundle_enabled", true, "com.google.android.gms.maps", fyVarQ, true);
        y = bh.d("BugFixes__nullness_check_in_lite_marker_list_enabled", true, "com.google.android.gms.maps", fyVarQ, true);
        z = bh.d("BugFixes__on_camera_move_exhaustion_fix", true, "com.google.android.gms.maps", fyVarQ, true);
        A = bh.d("BugFixes__propagate_marker_long_press_to_map_pick_handler", false, "com.google.android.gms.maps", fyVarQ, true);
        B = bh.a("BugFixes__reset_tilting_flag_when_tilt_disabled", false, "com.google.android.gms.maps", fyVarQ, true);
        C = bh.d("BugFixes__rotating_flag_respects_rotation_gesture_settings_enabled", false, "com.google.android.gms.maps", fyVarQ, true);
        D = bh.d("BugFixes__street_view_panorama_crash_logging_nesting_fix", true, "com.google.android.gms.maps", fyVarQ, true);
        E = bh.d("BugFixes__sync_ui_camera_and_render_camera_when_on_ui_thread_enabled", false, "com.google.android.gms.maps", fyVarQ, true);
        F = bh.d("BugFixes__throw_illegal_state_exception_on_null_snapshot_bitmap", true, "com.google.android.gms.maps", fyVarQ, true);
        G = bh.d("BugFixes__trigger_on_camera_move_on_animation_interrupted", false, "com.google.android.gms.maps", fyVarQ, true);
        H = bh.d("BugFixes__use_clientline_without_accumulated_distance_propagation", true, "com.google.android.gms.maps", fyVarQ, true);
        I = bh.d("BugFixes__use_consolidated_camera", false, "com.google.android.gms.maps", fyVarQ, true);
        J = bh.d("BugFixes__use_label_point_for_poi", true, "com.google.android.gms.maps", fyVarQ, true);
        K = bh.d("BugFixes__use_locally_scoped_reference_for_camera_move_listener", false, "com.google.android.gms.maps", fyVarQ, true);
        L = bh.d("BugFixes__use_null_checks_in_map_fragment_delegate", false, "com.google.android.gms.maps", fyVarQ, true);
        M = bh.a("BugFixes__use_user_provided_width_and_height_for_bounds", false, "com.google.android.gms.maps", fyVarQ, true);
        N = bh.d("BugFixes__use_zwieback_cookie_manager", true, "com.google.android.gms.maps", fyVarQ, true);
        O = bh.d("BugFixes__verbalize_info_window_content_only_for_accessibility_marker", true, "com.google.android.gms.maps", fyVarQ, true);
        P = bh.d("BugFixes__zoom_buttons_use_api_reason", true, "com.google.android.gms.maps", fyVarQ, true);
        Q = bh.d("BugFixes__zoom_rotate_smooth_exhaust_fix", true, "com.google.android.gms.maps", fyVarQ, true);
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean A() {
        return ((Boolean) O.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean B() {
        return ((Boolean) P.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean C() {
        return ((Boolean) Q.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void D() {
        ((Boolean) d.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void E() {
        ((Boolean) m.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void F() {
        ((Boolean) o.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void G() {
        ((Boolean) p.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void H() {
        ((Boolean) s.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void I() {
        ((Boolean) u.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void J() {
        ((Boolean) x.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void K() {
        ((Boolean) z.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void L() {
        ((Boolean) A.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void M() {
        ((Boolean) C.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void N() {
        ((Boolean) F.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void O() {
        ((Boolean) G.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void P() {
        ((Boolean) J.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final void Q() {
        ((Boolean) K.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean a() {
        return ((Boolean) a.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean b() {
        return ((Boolean) b.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean c() {
        return ((Boolean) c.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean d() {
        return ((Boolean) e.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean e() {
        return ((Boolean) f.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean f() {
        return ((Boolean) g.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean g() {
        return ((Boolean) h.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean h() {
        return ((Boolean) i.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean i() {
        return ((Boolean) j.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean j() {
        return ((Boolean) k.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean k() {
        return ((Boolean) l.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean l() {
        return ((Boolean) f330n.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean m() {
        return ((Boolean) q.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean n() {
        return ((Boolean) r.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean o() {
        return ((Boolean) t.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean p() {
        return ((Boolean) v.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean q() {
        return ((Boolean) w.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean r() {
        return ((Boolean) y.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean s() {
        return ((Boolean) B.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean t() {
        return ((Boolean) D.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean u() {
        return ((Boolean) E.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean v() {
        return ((Boolean) H.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean w() {
        return ((Boolean) I.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean x() {
        return ((Boolean) L.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean y() {
        return ((Boolean) M.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.e
    public final boolean z() {
        return ((Boolean) N.a()).booleanValue();
    }
}
