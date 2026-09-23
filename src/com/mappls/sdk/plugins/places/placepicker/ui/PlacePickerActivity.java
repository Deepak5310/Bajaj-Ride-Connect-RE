package com.mappls.sdk.plugins.places.placepicker.ui;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.camera.CameraMapplsPinUpdateFactory;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.camera.CameraUpdate;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.location.LocationComponent;
import com.mappls.sdk.maps.location.LocationComponentActivationOptions;
import com.mappls.sdk.maps.location.engine.LocationEngine;
import com.mappls.sdk.maps.location.engine.LocationEngineCallback;
import com.mappls.sdk.maps.location.engine.LocationEngineRequest;
import com.mappls.sdk.maps.location.engine.LocationEngineResult;
import com.mappls.sdk.maps.location.permissions.PermissionsListener;
import com.mappls.sdk.maps.location.permissions.PermissionsManager;
import com.mappls.sdk.plugins.places.R;
import com.mappls.sdk.plugins.places.autocomplete.model.MapplsFavoritePlace;
import com.mappls.sdk.plugins.places.autocomplete.ui.PlaceAutocompleteFragment;
import com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener;
import com.mappls.sdk.plugins.places.common.PlaceConstants;
import com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions;
import com.mappls.sdk.plugins.places.placepicker.viewmodel.PlacePickerViewModel;
import com.mappls.sdk.services.api.EntryCoordinate;
import com.mappls.sdk.services.api.Place;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class PlacePickerActivity extends AppCompatActivity implements OnMapReadyCallback, MapplsMap.OnCameraMoveStartedListener, MapplsMap.OnCameraIdleListener, Observer<com.mappls.sdk.plugins.places.common.utils.d<Place>>, PermissionsListener, MapplsMap.CancelableCallback, LocationEngineCallback<LocationEngineResult> {
    CurrentPlaceSelectionBottomSheet bottomSheet;
    private com.mappls.sdk.plugins.places.placepicker.plugin.c buildingFootprintPlugin;
    private com.mappls.sdk.plugins.places.placepicker.plugin.d entryCoordinatePlugin;
    private ImageView ivSearch;
    private LocationEngine locationEngine;
    private MapView mapView;
    private MapplsMap mapplsMap;
    private ImageView markerImage;
    private PlacePickerOptions options;
    private PermissionsManager permissionsManager;
    private FloatingActionButton userLocationButton;
    private PlacePickerViewModel viewModel;
    private boolean includeReverseGeocode = false;
    private boolean isCurrentLocation = true;
    private final String ENTRY_COORDINATE_SOURCE_ID = "entry-coordinates-source";
    private final String ENTRY_COORDINATE_LAYER_ID = "entry-coordinates-layer";
    private Integer entryCoordinatesRadius = 50;

    final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (PlacePickerActivity.this.mapplsMap != null) {
                PlacePickerActivity.this.searchOptions();
            } else {
                Toast.makeText(PlacePickerActivity.this, "Please wait for loading map", 0).show();
            }
        }
    }

    final class b implements PlaceSelectionListener {
        b() {
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener
        public final void onCancel() {
            PlacePickerActivity.this.getSupportFragmentManager().popBackStack(PlaceAutocompleteFragment.TAG, 1);
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener
        public final void onFavoritePlaceSelected(MapplsFavoritePlace mapplsFavoritePlace) {
            if (mapplsFavoritePlace != null) {
                if (PlacePickerActivity.this.entryCoordinatePlugin != null) {
                    PlacePickerActivity.this.entryCoordinatePlugin.a();
                }
                PlacePickerActivity.this.bottomSheet.a(null, true);
                PlacePickerActivity.this.isCurrentLocation = false;
                if (mapplsFavoritePlace.getLatitude() == null && mapplsFavoritePlace.getLongitude() == null) {
                    PlacePickerActivity.this.mapplsMap.moveCamera(CameraMapplsPinUpdateFactory.newMapplsPinZoom(mapplsFavoritePlace.getMapplsPin(), 14.0d));
                } else {
                    PlacePickerActivity.this.mapplsMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mapplsFavoritePlace.getLatitude().doubleValue(), mapplsFavoritePlace.getLongitude().doubleValue()), 14.0d));
                }
                PlacePickerActivity.this.includeReverseGeocode = false;
                PlacePickerActivity.this.viewModel.place = new Place();
                PlacePickerActivity.this.viewModel.place.setLat(mapplsFavoritePlace.getLatitude());
                PlacePickerActivity.this.viewModel.place.setLng(mapplsFavoritePlace.getLongitude());
                PlacePickerActivity.this.viewModel.place.setFormattedAddress(com.mappls.sdk.plugins.places.common.utils.b.a(mapplsFavoritePlace));
                PlacePickerActivity.this.viewModel.place.setMapplsPin(mapplsFavoritePlace.getMapplsPin());
                PlacePickerActivity placePickerActivity = PlacePickerActivity.this;
                placePickerActivity.bottomSheet.a(placePickerActivity.viewModel.place, false);
            }
            PlacePickerActivity.this.getSupportFragmentManager().popBackStack(PlaceAutocompleteFragment.TAG, 1);
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener
        public final void onPlaceSelected(ELocation eLocation) {
            if (eLocation != null) {
                if (PlacePickerActivity.this.entryCoordinatePlugin != null) {
                    PlacePickerActivity.this.entryCoordinatePlugin.a();
                }
                PlacePickerActivity.this.bottomSheet.a(null, true);
                PlacePickerActivity.this.isCurrentLocation = false;
                if (eLocation.latitude == null && eLocation.longitude == null) {
                    PlacePickerActivity.this.mapplsMap.moveCamera(CameraMapplsPinUpdateFactory.newMapplsPinZoom(eLocation.mapplsPin, 14.0d));
                } else {
                    PlacePickerActivity.this.mapplsMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(eLocation.latitude.doubleValue(), eLocation.longitude.doubleValue()), 14.0d));
                }
                PlacePickerActivity.this.includeReverseGeocode = false;
                PlacePickerActivity.this.viewModel.place = new Place();
                PlacePickerActivity.this.viewModel.place.setLat(eLocation.latitude);
                PlacePickerActivity.this.viewModel.place.setLng(eLocation.longitude);
                PlacePickerActivity.this.viewModel.place.setLng(eLocation.longitude);
                PlacePickerActivity.this.viewModel.place.setPoiDist("0");
                PlacePickerActivity.this.viewModel.place.setPoi(eLocation.placeName);
                PlacePickerActivity.this.viewModel.place.setFormattedAddress(com.mappls.sdk.plugins.places.common.utils.b.a(eLocation));
                PlacePickerActivity.this.viewModel.place.setMapplsPin(eLocation.mapplsPin);
                if (eLocation.addressTokens != null) {
                    PlacePickerActivity.this.viewModel.place.setCity(eLocation.addressTokens.city);
                    PlacePickerActivity.this.viewModel.place.setDistrict(eLocation.addressTokens.district);
                    PlacePickerActivity.this.viewModel.place.setHouseName(eLocation.addressTokens.houseName);
                    PlacePickerActivity.this.viewModel.place.setHouseNumber(eLocation.addressTokens.houseNumber);
                    PlacePickerActivity.this.viewModel.place.setLocality(eLocation.addressTokens.locality);
                    PlacePickerActivity.this.viewModel.place.setPincode(eLocation.addressTokens.pincode);
                    PlacePickerActivity.this.viewModel.place.setState(eLocation.addressTokens.state);
                    PlacePickerActivity.this.viewModel.place.setStreet(eLocation.addressTokens.street);
                    PlacePickerActivity.this.viewModel.place.setSubDistrict(eLocation.addressTokens.subDistrict);
                    PlacePickerActivity.this.viewModel.place.setSubLocality(eLocation.addressTokens.subLocality);
                    PlacePickerActivity.this.viewModel.place.setSubSubLocality(eLocation.addressTokens.subSubLocality);
                    PlacePickerActivity.this.viewModel.place.setVillage(eLocation.addressTokens.village);
                }
                PlacePickerActivity placePickerActivity = PlacePickerActivity.this;
                placePickerActivity.bottomSheet.a(placePickerActivity.viewModel.place, false);
            }
            PlacePickerActivity.this.getSupportFragmentManager().popBackStack(PlaceAutocompleteFragment.TAG, 1);
        }

        @Override // com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener
        public final void requestForCurrentLocation() {
            if (PlacePickerActivity.this.entryCoordinatePlugin != null) {
                PlacePickerActivity.this.entryCoordinatePlugin.a();
            }
            if (ActivityCompat.checkSelfPermission(PlacePickerActivity.this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(PlacePickerActivity.this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                if (PlacePickerActivity.this.mapplsMap.getLocationComponent().getLastKnownLocation() != null) {
                    Location lastKnownLocation = PlacePickerActivity.this.mapplsMap.getLocationComponent().getLastKnownLocation();
                    if (PlacePickerActivity.this.bottomSheet.b()) {
                        PlacePickerActivity.this.bottomSheet.a();
                    }
                    PlacePickerActivity.this.isCurrentLocation = true;
                    PlacePickerActivity.this.mapplsMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude())).zoom(17.5d).build()), 1400, PlacePickerActivity.this);
                    PlacePickerActivity.this.includeReverseGeocode = true;
                } else {
                    PlacePickerActivity placePickerActivity = PlacePickerActivity.this;
                    Toast.makeText(placePickerActivity, placePickerActivity.getString(R.string.mappls_search_place_picker_user_location_not_found), 0).show();
                }
                PlacePickerActivity.this.getSupportFragmentManager().popBackStack(PlaceAutocompleteFragment.TAG, 1);
            }
        }
    }

    final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PlacePickerActivity.this.finish();
        }
    }

    final class d implements Style.OnStyleLoaded {
        d() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            PlacePickerActivity.this.adjustCameraBasedOnOptions();
            if (PlacePickerActivity.this.options == null || !PlacePickerActivity.this.options.includeDeviceLocationButton().booleanValue()) {
                PlacePickerActivity.this.userLocationButton.hide();
            } else {
                PlacePickerActivity.this.enableLocationComponent(style);
            }
            PlacePickerActivity.this.bindListeners();
        }
    }

    final class e implements Style.OnStyleLoaded {
        e() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            PlacePickerActivity.this.enableLocationComponent(style);
        }
    }

    final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (PlacePickerActivity.this.viewModel.place != null) {
                PlacePickerActivity.this.placeSelected();
            } else {
                PlacePickerActivity placePickerActivity = PlacePickerActivity.this;
                Snackbar.make(placePickerActivity.bottomSheet, placePickerActivity.getString(R.string.mappls_search_place_picker_not_valid_selection), 0).show();
            }
        }
    }

    final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (ActivityCompat.checkSelfPermission(PlacePickerActivity.this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(PlacePickerActivity.this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                if (PlacePickerActivity.this.mapplsMap.getLocationComponent().getLastKnownLocation() == null) {
                    PlacePickerActivity placePickerActivity = PlacePickerActivity.this;
                    Toast.makeText(placePickerActivity, placePickerActivity.getString(R.string.mappls_search_place_picker_user_location_not_found), 0).show();
                    return;
                }
                Location lastKnownLocation = PlacePickerActivity.this.mapplsMap.getLocationComponent().getLastKnownLocation();
                if (PlacePickerActivity.this.bottomSheet.b()) {
                    PlacePickerActivity.this.bottomSheet.a();
                }
                PlacePickerActivity.this.isCurrentLocation = true;
                PlacePickerActivity.this.mapplsMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude())).zoom(17.5d).build()), 1400, PlacePickerActivity.this);
            }
        }
    }

    private void addBackButtonListener() {
        ((ImageView) findViewById(R.id.mappls_place_picker_toolbar_back_button)).setOnClickListener(new c());
    }

    private void addPlaceSelectedButton() {
        TextView textView = (TextView) findViewById(R.id.mappls_search_place_chosen_button);
        textView.setOnClickListener(new f());
        PlacePickerOptions placePickerOptions = this.options;
        if (placePickerOptions != null) {
            if (placePickerOptions.pickerButtonBackgroundColor() != null) {
                textView.setBackgroundColor(this.options.pickerButtonBackgroundColor().intValue());
            } else {
                textView.setBackgroundResource(this.options.pickerButtonBackgroundResource().intValue());
            }
            textView.setTextColor(this.options.pickerButtonTextColor().intValue());
            textView.setText(this.options.pickerButtonText());
        }
    }

    private void addSearchAutocomplete() {
        this.ivSearch.setOnClickListener(new a());
    }

    private void addUserLocationButton() {
        this.userLocationButton.show();
        this.userLocationButton.setOnClickListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustCameraBasedOnOptions() {
        MapplsMap mapplsMap;
        CameraUpdate cameraUpdateNewCameraPosition;
        PlacePickerOptions placePickerOptions = this.options;
        if (placePickerOptions != null) {
            if (placePickerOptions.startingBounds() != null) {
                if (this.bottomSheet.b()) {
                    this.bottomSheet.a();
                }
                this.isCurrentLocation = false;
                mapplsMap = this.mapplsMap;
                cameraUpdateNewCameraPosition = CameraUpdateFactory.newLatLngBounds(this.options.startingBounds(), 0);
            } else {
                if (this.options.statingCameraPosition() == null) {
                    if (this.options.startingMapplsPinBounds() != null) {
                        if (this.bottomSheet.b()) {
                            this.bottomSheet.a();
                        }
                        this.isCurrentLocation = false;
                        this.mapplsMap.moveCamera(CameraMapplsPinUpdateFactory.newMapplsPinBounds(this.options.startingMapplsPinBounds(), 0), this);
                        return;
                    }
                    if (this.options.startingMapplsPinPosition() != null) {
                        if (this.bottomSheet.b()) {
                            this.bottomSheet.a();
                        }
                        this.isCurrentLocation = false;
                        this.mapplsMap.moveCamera(CameraMapplsPinUpdateFactory.newMapplsPinZoom(this.options.startingMapplsPinPosition(), 16.0d), this);
                        return;
                    }
                    return;
                }
                if (this.bottomSheet.b()) {
                    this.bottomSheet.a();
                }
                this.isCurrentLocation = false;
                mapplsMap = this.mapplsMap;
                cameraUpdateNewCameraPosition = CameraUpdateFactory.newCameraPosition(this.options.statingCameraPosition());
            }
            mapplsMap.moveCamera(cameraUpdateNewCameraPosition, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindListeners() {
        this.mapplsMap.addOnCameraMoveStartedListener(this);
        this.mapplsMap.addOnCameraIdleListener(this);
    }

    private void bindViews() {
        this.mapView = (MapView) findViewById(R.id.mappls_search_map_view);
        this.bottomSheet = (CurrentPlaceSelectionBottomSheet) findViewById(R.id.mappls_search_picker_bottom_sheet);
        this.markerImage = (ImageView) findViewById(R.id.mappls_search_image_view_marker);
        this.userLocationButton = (FloatingActionButton) findViewById(R.id.user_location_button);
        this.ivSearch = (ImageView) findViewById(R.id.mappls_search_picker_search);
        if (this.options.includeSearch().booleanValue()) {
            this.ivSearch.setVisibility(0);
        }
    }

    private void customizeViews() {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.place_picker_toolbar);
        ImageView imageView = (ImageView) findViewById(R.id.mappls_search_image_view_shadow);
        PlacePickerOptions placePickerOptions = this.options;
        constraintLayout.setBackgroundColor((placePickerOptions == null || placePickerOptions.toolbarColor() == null) ? ContextCompat.getColor(this, R.color.mappls_search_plugins_white) : this.options.toolbarColor().intValue());
        PlacePickerOptions placePickerOptions2 = this.options;
        if (placePickerOptions2 != null) {
            if (placePickerOptions2.markerBitmap() != null) {
                this.markerImage.setImageBitmap(this.options.markerBitmap());
            } else {
                this.markerImage.setImageResource(this.options.marker().intValue());
            }
            this.bottomSheet.a(this.options);
            setToolbarTintColor(this.options.toolbarTintColor());
            imageView.setVisibility(this.options.showMarkerShadow().booleanValue() ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableLocationComponent(Style style) {
        if (!PermissionsManager.areLocationPermissionsGranted(this)) {
            PermissionsManager permissionsManager = new PermissionsManager(this);
            this.permissionsManager = permissionsManager;
            permissionsManager.requestLocationPermissions(this);
            return;
        }
        LocationComponent locationComponent = this.mapplsMap.getLocationComponent();
        locationComponent.activateLocationComponent(LocationComponentActivationOptions.builder(this, style).build());
        locationComponent.setLocationComponentEnabled(true);
        this.locationEngine = locationComponent.getLocationEngine();
        new LocationEngineRequest.Builder(1000L).setPriority(0).setMaxWaitTime(5000L).build();
        this.locationEngine.getLastLocation(this);
        locationComponent.setCameraMode(8);
        locationComponent.setRenderMode(18);
        addUserLocationButton();
    }

    private void makeReverseGeocodingSearch() {
        com.mappls.sdk.plugins.places.placepicker.plugin.d dVar = this.entryCoordinatePlugin;
        if (dVar != null) {
            dVar.a();
        }
        LatLng latLng = this.mapplsMap.getCameraPosition().target;
        if (com.mappls.sdk.plugins.places.common.utils.a.a(this)) {
            if (latLng != null) {
                this.viewModel.reverseGeocode(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()), this.options);
            }
        } else {
            com.mappls.sdk.plugins.places.placepicker.plugin.c cVar = this.buildingFootprintPlugin;
            if (cVar != null) {
                cVar.a();
            }
            Snackbar.make(this.bottomSheet, getString(R.string.mappls_search_offline_message), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchOptions() {
        PlaceAutocompleteFragment placeAutocompleteFragmentNewInstance = PlaceAutocompleteFragment.newInstance(this.options.searchPlaceOption());
        placeAutocompleteFragmentNewInstance.setOnPlaceSelectedListener(new b());
        getSupportFragmentManager().beginTransaction().add(R.id.mappls_picker_fragment_container, placeAutocompleteFragmentNewInstance, PlaceAutocompleteFragment.TAG).addToBackStack(PlaceAutocompleteFragment.TAG).commit();
    }

    private void setToolbarTintColor(Integer num) {
        ImageView imageView = (ImageView) findViewById(R.id.mappls_place_picker_toolbar_back_button);
        TextView textView = (TextView) findViewById(R.id.place_picker_toolbar_primary_text_view);
        imageView.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        this.ivSearch.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        textView.setTextColor(num.intValue());
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnCameraIdleListener
    public void onCameraIdle() {
        this.markerImage.animate().translationY(0.0f).setInterpolator(new OvershootInterpolator()).setDuration(250L).start();
        if (this.mapplsMap.getCameraPosition().zoom < 14.0d) {
            this.mapplsMap.animateCamera(CameraUpdateFactory.zoomTo(14.0d));
        } else if (this.includeReverseGeocode) {
            this.bottomSheet.a(null, true);
            this.viewModel.place = null;
            makeReverseGeocodingSearch();
        }
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnCameraMoveStartedListener
    public void onCameraMoveStarted(int i) {
        if (this.markerImage.getTranslationY() == 0.0f) {
            this.markerImage.animate().translationY(-75.0f).setInterpolator(new OvershootInterpolator()).setDuration(250L).start();
            boolean z = i == 1;
            this.includeReverseGeocode = z;
            if (z) {
                this.viewModel.place = null;
                if (this.bottomSheet.b()) {
                    this.bottomSheet.a();
                }
            }
        }
    }

    @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
    public void onCancel() {
        this.viewModel.place = null;
        CurrentPlaceSelectionBottomSheet currentPlaceSelectionBottomSheet = this.bottomSheet;
        if (currentPlaceSelectionBottomSheet != null) {
            currentPlaceSelectionBottomSheet.a(null, true);
        }
        makeReverseGeocodingSearch();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00f1 A[PHI: r0
      0x00f1: PHI (r0v13 int) = (r0v10 int), (r0v11 int) binds: [B:34:0x00ef, B:37:0x00f5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(com.mappls.sdk.plugins.places.common.utils.d<Place> dVar) {
        if (dVar.a == 3) {
            com.mappls.sdk.plugins.places.placepicker.plugin.c cVar = this.buildingFootprintPlugin;
            if (cVar != null) {
                cVar.a();
            }
            this.viewModel.place = new Place();
            this.viewModel.place.setFormattedAddress(String.format(Locale.US, "[%f, %f]", Double.valueOf(this.mapplsMap.getCameraPosition().target.getLatitude()), Double.valueOf(this.mapplsMap.getCameraPosition().target.getLongitude())));
        } else {
            this.viewModel.place = dVar.b;
            if (this.options.buildingFootprintsEnabled().booleanValue()) {
                if (this.viewModel.place.isRoofTop() == null || !this.viewModel.place.isRoofTop().booleanValue()) {
                    this.buildingFootprintPlugin.a();
                } else {
                    com.mappls.sdk.plugins.places.placepicker.plugin.c cVar2 = this.buildingFootprintPlugin;
                    if (cVar2 != null) {
                        cVar2.a(this.viewModel.place.getMapplsPin());
                    }
                }
            }
            List<EntryCoordinate> entryCoordinates = this.viewModel.place.getEntryCoordinates();
            if (entryCoordinates != null && !entryCoordinates.isEmpty()) {
                com.mappls.sdk.plugins.places.placepicker.plugin.d dVar2 = this.entryCoordinatePlugin;
                if (dVar2 != null) {
                    dVar2.a(entryCoordinates);
                }
                if (this.options.entryCoordinateSnapEnable().booleanValue()) {
                    LatLng latLng = this.mapplsMap.getCameraPosition().target;
                    double d2 = Double.MAX_VALUE;
                    LatLng latLng2 = null;
                    for (EntryCoordinate entryCoordinate : entryCoordinates) {
                        LatLng latLng3 = new LatLng(entryCoordinate.getEntryLatitude(), entryCoordinate.getEntryLongitude());
                        double dDistanceTo = latLng.distanceTo(latLng3);
                        if (dDistanceTo < d2) {
                            latLng2 = latLng3;
                            d2 = dDistanceTo;
                        }
                    }
                    int iIntValue = this.options.entryCoordinateSnappingRadius().intValue();
                    int i = 5;
                    if (iIntValue < 5) {
                        iIntValue = i;
                    } else {
                        i = 150;
                        if (iIntValue > 150) {
                            iIntValue = i;
                        }
                    }
                    if (d2 <= iIntValue && latLng2 != null) {
                        this.isCurrentLocation = false;
                        this.mapplsMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng2, 17.5d));
                        this.includeReverseGeocode = false;
                    }
                }
            }
        }
        this.bottomSheet.a(this.viewModel.place, true);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mappls_search_activity_place_picker);
        this.options = (PlacePickerOptions) (bundle == null ? getIntent().getParcelableExtra(PlaceConstants.PICKER_OPTIONS) : bundle.getParcelable(PlaceConstants.PICKER_OPTIONS));
        if (this.options == null) {
            this.options = PlacePickerOptions.builder().build();
        }
        PlacePickerViewModel placePickerViewModel = (PlacePickerViewModel) new ViewModelProvider(this).get(PlacePickerViewModel.class);
        this.viewModel = placePickerViewModel;
        placePickerViewModel.getResults().observe(this, this);
        bindViews();
        addSearchAutocomplete();
        addBackButtonListener();
        addPlaceSelectedButton();
        customizeViews();
        this.mapView.onCreate(bundle);
        this.mapView.getMapAsync(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.mappls.sdk.plugins.places.placepicker.plugin.d dVar = this.entryCoordinatePlugin;
        if (dVar != null) {
            dVar.c();
        }
        this.mapView.onDestroy();
    }

    @Override // com.mappls.sdk.maps.location.permissions.PermissionsListener
    public void onExplanationNeeded(List<String> list) {
        Toast.makeText(this, R.string.mappls_search_place_picker_user_location_permission_explanation, 1).show();
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
    public void onFailure(Exception exc) {
    }

    @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
    public void onFinish() {
        this.viewModel.place = null;
        CurrentPlaceSelectionBottomSheet currentPlaceSelectionBottomSheet = this.bottomSheet;
        if (currentPlaceSelectionBottomSheet != null) {
            currentPlaceSelectionBottomSheet.a(null, true);
        }
        makeReverseGeocodingSearch();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mapView.onLowMemory();
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapError(int i, String str) {
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapReady(MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
        if (this.options.buildingFootprintsEnabled().booleanValue()) {
            this.buildingFootprintPlugin = new com.mappls.sdk.plugins.places.placepicker.plugin.c(this.mapView, mapplsMap, this.options);
        }
        if (this.options.showEntryCoordinate().booleanValue()) {
            this.entryCoordinatePlugin = new com.mappls.sdk.plugins.places.placepicker.plugin.d(this.mapView, mapplsMap, this.options);
        }
        PlacePickerOptions placePickerOptions = this.options;
        if (placePickerOptions != null) {
            mapplsMap.setMaxZoomPreference(placePickerOptions.mapMaxZoom().doubleValue());
            mapplsMap.setMinZoomPreference(this.options.mapMinZoom().doubleValue());
        }
        mapplsMap.getStyle(new d());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mapView.onPause();
    }

    @Override // com.mappls.sdk.maps.location.permissions.PermissionsListener
    public void onPermissionResult(boolean z) {
        if (z) {
            this.mapplsMap.getStyle(new e());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.permissionsManager.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mapView.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mapView.onSaveInstanceState(bundle);
        bundle.putParcelable(PlaceConstants.PICKER_OPTIONS, this.options);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mapView.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mapView.onStop();
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
    public void onSuccess(LocationEngineResult locationEngineResult) {
        Location lastLocation;
        if (locationEngineResult == null || !this.isCurrentLocation || (lastLocation = locationEngineResult.getLastLocation()) == null) {
            return;
        }
        if (this.bottomSheet.b()) {
            this.bottomSheet.a();
        }
        this.isCurrentLocation = false;
        this.mapplsMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude()), 16.0d), this);
    }

    void placeSelected() {
        Intent intent = new Intent();
        intent.putExtra(PlaceConstants.RETURNING_PLACE_DATA, new Gson().toJson(this.viewModel.place));
        intent.putExtra(PlaceConstants.MAP_CAMERA_POSITION, this.mapplsMap.getCameraPosition());
        setResult(-1, intent);
        finish();
    }
}
