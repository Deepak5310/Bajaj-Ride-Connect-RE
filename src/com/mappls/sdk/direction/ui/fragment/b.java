package com.mappls.sdk.direction.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.mappls.sdk.direction.ui.DirectionFragment;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionPreviewFragmentBinding;
import com.mappls.sdk.direction.ui.model.DirectionOptions;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.utils.PolylineUtils;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.services.api.directions.models.LegStep;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class b extends Fragment implements OnMapReadyCallback {
    MapplsDirectionPreviewFragmentBinding a;
    com.mappls.sdk.direction.ui.adapters.a b;
    List<LegStep> c;
    int d;
    private MapView e;
    private MapplsMap f;
    private com.mappls.sdk.direction.ui.plugin.a g;
    private int h = 0;
    private com.mappls.sdk.direction.ui.viewmodel.a i;
    private com.mappls.sdk.direction.ui.plugin.f j;
    private DirectionOptions k;

    final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (b.this.a.pagerDirectionPreview.getCurrentItem() + 1 < b.this.c.size()) {
                ViewPager viewPager = b.this.a.pagerDirectionPreview;
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                b.this.i.b = b.this.a.pagerDirectionPreview.getCurrentItem() + 1;
            }
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.direction.ui.fragment.b$b, reason: collision with other inner class name */
    final class ViewOnClickListenerC0072b implements View.OnClickListener {
        ViewOnClickListenerC0072b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (b.this.a.pagerDirectionPreview.getCurrentItem() > 0) {
                ViewPager viewPager = b.this.a.pagerDirectionPreview;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                b.this.i.b = b.this.a.pagerDirectionPreview.getCurrentItem() - 1;
            }
        }
    }

    final class c implements ViewPager.OnPageChangeListener {
        c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            b.a(b.this, i);
            b.this.i.b = i;
        }
    }

    final class d extends OnBackPressedCallback {
        d() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackPressed() {
            b.this.getParentFragmentManager().popBackStack(b.this.getClass().getName(), 1);
        }
    }

    final class e implements Style.OnStyleLoaded {
        final /* synthetic */ MapplsMap a;

        e(MapplsMap mapplsMap) {
            this.a = mapplsMap;
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            b bVar = b.this;
            bVar.g = new com.mappls.sdk.direction.ui.plugin.a(bVar.e, this.a);
            b.this.g.a(true);
            b bVar2 = b.this;
            b.a(bVar2, bVar2.h);
        }
    }

    public static b a(List<LegStep> list, MapView mapView, int i, int i2, DirectionOptions directionOptions) {
        b bVar = new b();
        bVar.c = list;
        bVar.e = mapView;
        bVar.h = i;
        bVar.d = i2;
        bVar.k = directionOptions;
        return bVar;
    }

    static void a(b bVar, int i) {
        List<LegStep> list;
        if (bVar.f == null || (list = bVar.c) == null || list.size() <= i) {
            return;
        }
        LegStep legStep = bVar.c.get(i);
        List<Point> listDecode = PolylineUtils.decode((String) Objects.requireNonNull(legStep.geometry()), 6);
        if (listDecode.size() > 0) {
            Point point = listDecode.get(0);
            double dDoubleValue = legStep.maneuver().bearingAfter() != null ? legStep.maneuver().bearingAfter().doubleValue() : 0.0d;
            com.mappls.sdk.direction.ui.plugin.a aVar = bVar.g;
            if (aVar != null) {
                aVar.a((float) dDoubleValue, new LatLng(point.latitude(), point.longitude()));
            }
            bVar.f.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(point.latitude(), point.longitude()), 16.0d));
        }
    }

    public final void a(MapView mapView, int i) {
        this.e = mapView;
        this.d = i;
        if (isAdded()) {
            if (mapView != null) {
                mapView.getMapAsync(this);
            }
            requireContext().setTheme(this.d);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        List<LegStep> list;
        requireContext().setTheme(this.d);
        this.a = (MapplsDirectionPreviewFragmentBinding) DataBindingUtil.inflate(layoutInflater, R.layout.mappls_direction_preview_fragment, viewGroup, false);
        com.mappls.sdk.direction.ui.viewmodel.a aVar = (com.mappls.sdk.direction.ui.viewmodel.a) new ViewModelProvider(this).get(com.mappls.sdk.direction.ui.viewmodel.a.class);
        this.i = aVar;
        List<LegStep> list2 = this.c;
        if (list2 != null || (list = aVar.a) == null) {
            aVar.a = list2;
            aVar.b = this.h;
        } else {
            this.c = list;
            this.h = aVar.b;
        }
        List<LegStep> list3 = aVar.a;
        if (list3 == null || list3.size() == 0) {
            getParentFragmentManager().popBackStack(getClass().getName(), 1);
        }
        if (getParentFragment() != null && (getParentFragment() instanceof DirectionFragment)) {
            com.mappls.sdk.direction.ui.plugin.f directionPolylinePlugin = ((DirectionFragment) getParentFragment()).getDirectionPolylinePlugin();
            this.j = directionPolylinePlugin;
            if (directionPolylinePlugin != null) {
                directionPolylinePlugin.a(true);
            }
        }
        this.a.layoutCommonToolbar.toolbar.setTitle("Direction List");
        this.a.layoutCommonToolbar.toolbar.setNavigationOnClickListener(new com.mappls.sdk.direction.ui.fragment.c(this));
        this.a.pagerDirectionPreview.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_step_list_background, ContextCompat.getColor(requireContext(), R.color.mappls_directions_white), requireContext()));
        this.a.layoutCommonToolbar.toolbar.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_background, ContextCompat.getColor(requireContext(), R.color.mappls_direction_colorPrimary), requireContext()));
        this.a.layoutCommonToolbar.toolbar.setTitleTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_color, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.a.layoutCommonToolbar.toolbar.setNavigationIcon(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_route_back, R.drawable.mappls_direction_baseline_arrow_back_24, requireContext()));
        this.a.previewView.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_toolbar_seperator, Color.parseColor("#eeeeee"), requireContext()));
        this.a.btnPrevDown.setBackgroundResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_preview_prev_btn_background, R.drawable.mappls_direction_prev_down_background, requireContext()));
        this.a.btnPrevDown.setImageResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_preview_prev_btn_icon, R.drawable.mappls_direction_left_button_arrow_selector, requireContext()));
        this.a.btnNextUp.setImageResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_preview_next_btn_icon, R.drawable.mappls_direction_right_button_arrow_selector, requireContext()));
        this.a.btnNextUp.setBackgroundResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_preview_next_btn_background, R.drawable.mappls_direction_next_up_background, requireContext()));
        MapView mapView = this.e;
        if (mapView != null) {
            mapView.getMapAsync(this);
        }
        com.mappls.sdk.direction.ui.adapters.a aVar2 = new com.mappls.sdk.direction.ui.adapters.a(this.c, this.d, getContext(), this.k);
        this.b = aVar2;
        this.a.pagerDirectionPreview.setAdapter(aVar2);
        com.mappls.sdk.direction.ui.adapters.a aVar3 = this.b;
        if (this.c != null) {
            aVar3.notifyDataSetChanged();
        } else {
            aVar3.getClass();
        }
        this.a.pagerDirectionPreview.setCurrentItem(this.h);
        this.a.setOnNextClick(new a());
        this.a.setOnPreviousClick(new ViewOnClickListenerC0072b());
        this.a.pagerDirectionPreview.addOnPageChangeListener(new c());
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new d());
        return this.a.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        com.mappls.sdk.direction.ui.plugin.a aVar = this.g;
        if (aVar != null) {
            aVar.a();
        }
        com.mappls.sdk.direction.ui.plugin.f fVar = this.j;
        if (fVar != null) {
            fVar.a(false);
        }
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public final void onMapError(int i, String str) {
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public final void onMapReady(MapplsMap mapplsMap) {
        this.f = mapplsMap;
        mapplsMap.getStyle(new e(mapplsMap));
    }
}
