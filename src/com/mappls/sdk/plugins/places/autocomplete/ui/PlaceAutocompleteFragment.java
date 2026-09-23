package com.mappls.sdk.plugins.places.autocomplete.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.mappls.sdk.plugins.places.R;
import com.mappls.sdk.plugins.places.autocomplete.model.MapplsFavoritePlace;
import com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions;
import com.mappls.sdk.plugins.places.common.PlaceConstants;
import com.mappls.sdk.services.api.autosuggest.model.AutoSuggestAtlasResponse;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.autosuggest.model.SuggestedSearchAtlas;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public class PlaceAutocompleteFragment extends Fragment implements ResultClickCallback, SearchView.b, SearchView.a, ViewTreeObserver.OnScrollChangedListener, SearchView.c, View.OnClickListener {
    public static final String TAG = "PlaceAutocompleteFragment";
    private CardView currentLocationView;
    private View dropShadowView;
    private Integer favoriteCount;
    private Integer historyCount;
    private int mode;
    private CardView offlineResultView;
    private PlaceOptions placeOptions;
    private PlaceSelectionListener placeSelectionListener;
    private TextView poorConnectionTextView;
    private CardView poorConnectionView;
    private NestedScrollView resultScrollView;
    private View rootView;
    private ResultView searchHistoryView;
    private ResultView searchResultView;
    private SearchView searchView;
    private ResultView starredView;
    private SuggestedSearchSelectionListener suggestedSearchSelectionListener;
    private com.mappls.sdk.plugins.places.autocomplete.viewmodel.a viewModel;
    private boolean isSelectItem = false;
    private String query = "";
    private Handler handler = new Handler(Looper.getMainLooper());
    private List<String> historyPlaceIds = new ArrayList();

    final class a implements Runnable {
        final /* synthetic */ CharSequence a;

        a(CharSequence charSequence) {
            this.a = charSequence;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PlaceAutocompleteFragment.this.query = this.a.toString();
            PlaceAutocompleteFragment.this.viewModel.a(this.a);
        }
    }

    final class b implements Observer<com.mappls.sdk.plugins.places.common.utils.d<AutoSuggestAtlasResponse>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(com.mappls.sdk.plugins.places.common.utils.d<AutoSuggestAtlasResponse> dVar) {
            com.mappls.sdk.plugins.places.common.utils.d<AutoSuggestAtlasResponse> dVar2 = dVar;
            int i = dVar2.a;
            if (i == 2) {
                PlaceAutocompleteFragment.this.searchView.showProgress();
                return;
            }
            if (i == 1) {
                PlaceAutocompleteFragment.this.poorConnectionView.setVisibility(8);
                PlaceAutocompleteFragment.this.searchView.hideProgress();
                PlaceAutocompleteFragment.this.updateSearchResultView(dVar2.b);
            } else {
                PlaceAutocompleteFragment.this.poorConnectionView.setVisibility(8);
                PlaceAutocompleteFragment.this.searchView.hideProgress();
                Timber.v(dVar2.c, new Object[0]);
            }
        }
    }

    final class c implements Observer<List<MapplsFavoritePlace>> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(List<MapplsFavoritePlace> list) {
            PlaceAutocompleteFragment.this.updateFavoritePlacesView(list);
        }
    }

    final class d implements Observer<List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a>> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a> list) {
            PlaceAutocompleteFragment.this.updateSearchHistoryView(list);
        }
    }

    private void bindClickListeners() {
        this.searchHistoryView.setOnItemClickListener(this);
        this.searchResultView.setOnItemClickListener(this);
        this.starredView.setOnItemClickListener(this);
        this.searchView.setBackButtonListener(this);
        this.searchView.setQueryListener(this);
        if (this.placeOptions.enableTextSearch().booleanValue()) {
            this.searchView.setOnSearchClick(this);
        }
        this.currentLocationView.setOnClickListener(this);
    }

    private void bindViews() {
        this.searchHistoryView = (ResultView) this.rootView.findViewById(R.id.searchHistoryResultsView);
        this.resultScrollView = (NestedScrollView) this.rootView.findViewById(R.id.scroll_view_results);
        this.offlineResultView = (CardView) this.rootView.findViewById(R.id.offlineResultView);
        this.searchResultView = (ResultView) this.rootView.findViewById(R.id.searchResultView);
        this.dropShadowView = this.rootView.findViewById(R.id.scroll_drop_shadow);
        this.starredView = (ResultView) this.rootView.findViewById(R.id.favoriteResultView);
        this.searchView = (SearchView) this.rootView.findViewById(R.id.searchView);
        View viewFindViewById = this.rootView.findViewById(R.id.root_layout);
        this.rootView = viewFindViewById;
        this.poorConnectionView = (CardView) viewFindViewById.findViewById(R.id.poor_connection_view);
        this.poorConnectionTextView = (TextView) this.rootView.findViewById(R.id.poor_connection_view_text_view);
        this.currentLocationView = (CardView) this.rootView.findViewById(R.id.current_location_layout);
        this.searchHistoryView.setPlaceOption(this.placeOptions);
        this.searchResultView.setPlaceOption(this.placeOptions);
        ((TextView) this.offlineResultView.findViewById(R.id.tv_error)).setTextColor(this.placeOptions.errorTextColor());
        this.offlineResultView.setCardBackgroundColor(this.placeOptions.errorBackgroundColor());
        this.poorConnectionTextView.setTextColor(this.placeOptions.errorTextColor());
        this.poorConnectionView.setCardBackgroundColor(this.placeOptions.errorBackgroundColor());
    }

    public static PlaceAutocompleteFragment newInstance() {
        PlaceAutocompleteFragment placeAutocompleteFragment = new PlaceAutocompleteFragment();
        placeAutocompleteFragment.setArguments(new Bundle());
        return placeAutocompleteFragment;
    }

    public static PlaceAutocompleteFragment newInstance(PlaceOptions placeOptions) {
        PlaceAutocompleteFragment placeAutocompleteFragment = new PlaceAutocompleteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(PlaceConstants.PLACE_OPTIONS, placeOptions);
        placeAutocompleteFragment.setArguments(bundle);
        return placeAutocompleteFragment;
    }

    private void showOfflineView(String str) {
        this.searchResultView.setVisibility(8);
        this.offlineResultView.setVisibility(0);
        ((TextView) this.offlineResultView.findViewById(R.id.tv_error)).setText(str);
        if (com.mappls.sdk.plugins.places.common.utils.a.a(getContext())) {
            this.offlineResultView.findViewById(R.id.error_image).setVisibility(4);
        } else {
            this.offlineResultView.findViewById(R.id.error_image).setVisibility(0);
        }
    }

    private void styleView() {
        View view;
        int dimension;
        int dimension2;
        float f;
        int i;
        int i2;
        if (this.placeOptions == null || (view = this.rootView) == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_powered);
        TextView textView2 = (TextView) this.rootView.findViewById(R.id.tv_powered_bottom);
        textView.setVisibility(this.placeOptions.showPoweredByText().booleanValue() ? 0 : 8);
        textView2.setVisibility(this.placeOptions.showPoweredByText().booleanValue() ? 0 : 8);
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R.id.layout_signature);
        LinearLayout linearLayout2 = (LinearLayout) this.rootView.findViewById(R.id.layout_signature_bottom);
        CardView cardView = (CardView) this.rootView.findViewById(R.id.signature_layout_top);
        CardView cardView2 = (CardView) this.rootView.findViewById(R.id.signature_layout_bottom);
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.iv_logo);
        ImageView imageView2 = (ImageView) this.rootView.findViewById(R.id.iv_logo_bottom);
        TextView textView3 = (TextView) this.rootView.findViewById(R.id.tv_current_location);
        ImageView imageView3 = (ImageView) this.rootView.findViewById(R.id.iv_current_location);
        this.rootView.findViewById(R.id.layout_current_location).setBackgroundColor(this.placeOptions.currentLocationBackground().intValue());
        if (this.placeOptions.logoSize() == 10) {
            dimension = (int) getResources().getDimension(R.dimen.mappls_search_plugins_logo_height_large);
            dimension2 = (int) getResources().getDimension(R.dimen.mappls_search_plugins_logo_width_large);
            f = 16.0f;
        } else if (this.placeOptions.logoSize() == 8) {
            dimension = (int) getResources().getDimension(R.dimen.mappls_search_plugins_logo_height_small);
            dimension2 = (int) getResources().getDimension(R.dimen.mappls_search_plugins_logo_width_small);
            f = 12.0f;
        } else {
            dimension = (int) getResources().getDimension(R.dimen.mappls_search_plugins_logo_height_medium);
            dimension2 = (int) getResources().getDimension(R.dimen.mappls_search_plugins_logo_width_medium);
            f = 14.0f;
        }
        textView.setTextSize(2, f);
        textView2.setTextSize(2, f);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(dimension2, dimension));
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(dimension2, dimension));
        if (this.placeOptions.attributionVerticalAlignment() == 4) {
            i = 17;
        } else {
            i = this.placeOptions.attributionVerticalAlignment() == 5 ? GravityCompat.END : 8388611;
        }
        linearLayout.setGravity(i);
        linearLayout2.setGravity(i);
        if (this.placeOptions.isShowCurrentLocation().booleanValue()) {
            i2 = 0;
            this.currentLocationView.setVisibility(0);
        } else {
            i2 = 0;
        }
        this.rootView.setBackgroundColor(this.placeOptions.backgroundColor());
        cardView.setVisibility(this.placeOptions.attributionHorizontalAlignment() == 6 ? i2 : 8);
        if (this.placeOptions.attributionHorizontalAlignment() != 7) {
            i2 = 8;
        }
        cardView2.setVisibility(i2);
        cardView2.setCardBackgroundColor(this.placeOptions.attributionBackgroundColor());
        cardView.setCardBackgroundColor(this.placeOptions.attributionBackgroundColor());
        textView.setTextColor(this.placeOptions.poweredByTextColor().intValue());
        textView2.setTextColor(this.placeOptions.poweredByTextColor().intValue());
        View viewFindViewById = this.rootView.findViewById(R.id.toolbar);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(this.placeOptions.toolbarColor());
        }
        CardView cardView3 = (CardView) this.rootView.findViewById(R.id.toolbar_cardView);
        if (cardView3 != null) {
            cardView3.setCardBackgroundColor(this.placeOptions.toolbarColor());
        }
        this.searchView.setTintColor(this.placeOptions.toolbarTintColor());
        if (this.placeOptions.hintColor() != null) {
            this.searchView.setHintColor(this.placeOptions.hintColor().intValue());
        }
        if (this.placeOptions.statusBarColor() != null) {
            ((Activity) this.rootView.getContext()).getWindow().setStatusBarColor(this.placeOptions.statusBarColor().intValue());
        }
        textView3.setTextColor(this.placeOptions.currentLocationTextColor().intValue());
        imageView3.setImageResource(this.placeOptions.currentLocationIcon().intValue());
        SearchView searchView = (SearchView) this.rootView.findViewById(R.id.searchView);
        this.searchView = searchView;
        searchView.setHint(this.placeOptions.hint() == null ? getString(R.string.mappls_search_autocomplete_search_hint) : this.placeOptions.hint());
    }

    private void subscribe() {
        this.viewModel.a.observe(getViewLifecycleOwner(), new b());
        this.viewModel.b.observe(getViewLifecycleOwner(), new c());
        if (this.placeOptions.saveHistory().booleanValue()) {
            com.mappls.sdk.plugins.places.autocomplete.a.a(this.viewModel.d()).a().observe(getViewLifecycleOwner(), new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFavoritePlacesView(List<MapplsFavoritePlace> list) {
        this.starredView.getResultsList().clear();
        if (this.placeOptions.favoriteCount() != null) {
            this.favoriteCount = this.placeOptions.favoriteCount();
            for (int i = 0; i < this.favoriteCount.intValue() && i < list.size(); i++) {
                this.starredView.getResultsList().add(new com.mappls.sdk.plugins.places.autocomplete.model.d(list.get(i)));
            }
        } else {
            Iterator<MapplsFavoritePlace> it2 = list.iterator();
            while (it2.hasNext()) {
                this.starredView.getResultsList().add(new com.mappls.sdk.plugins.places.autocomplete.model.d(it2.next()));
            }
        }
        ResultView resultView = this.starredView;
        resultView.setVisibility(resultView.getResultsList().isEmpty() ? 8 : 0);
        this.starredView.notifyDataSetChanged();
    }

    public Integer getHistoryCount() {
        return this.historyCount;
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.ui.SearchView.a
    public void onBackButtonPress() {
        if (this.placeSelectionListener != null) {
            com.mappls.sdk.plugins.places.common.utils.c.a(this.searchView);
            this.placeSelectionListener.onCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.current_location_layout) {
            com.mappls.sdk.plugins.places.common.utils.c.a(this.searchView);
            PlaceSelectionListener placeSelectionListener = this.placeSelectionListener;
            if (placeSelectionListener != null) {
                placeSelectionListener.requestForCurrentLocation();
            }
        }
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.ui.ResultClickCallback
    public void onClick(com.mappls.sdk.plugins.places.autocomplete.model.d dVar) {
        this.isSelectItem = true;
        com.mappls.sdk.plugins.places.common.utils.c.a(this.searchView);
        if (dVar.c() == 4) {
            if (this.suggestedSearchSelectionListener != null) {
                this.searchResultView.getResultsList().clear();
                this.searchResultView.notifyDataSetChanged();
                this.searchResultView.setVisibility(8);
                this.suggestedSearchSelectionListener.onSuggestedSearchSelected(dVar.b());
                return;
            }
            return;
        }
        if (dVar.c() == 2) {
            if (dVar.d().placeName != null) {
                this.searchView.setText(dVar.d().placeName.trim() + ", " + dVar.d().placeAddress);
            }
            this.viewModel.a(dVar.d());
            this.viewModel.a(dVar.d(), this.query);
            if (this.placeSelectionListener == null) {
                return;
            }
        } else {
            if (dVar.c() != 1) {
                if (dVar.a().getPlaceName() != null) {
                    this.searchView.setText(dVar.a().getPlaceName().trim() + ", " + dVar.a().getPlaceAddress());
                }
                if (this.placeSelectionListener != null) {
                    this.searchResultView.getResultsList().clear();
                    this.searchResultView.notifyDataSetChanged();
                    this.searchResultView.setVisibility(8);
                    this.placeSelectionListener.onFavoritePlaceSelected(dVar.a());
                    return;
                }
                return;
            }
            if (dVar.d().placeName != null) {
                this.searchView.setText(dVar.d().placeName.trim() + ", " + dVar.d().placeAddress);
            }
            this.viewModel.a(dVar.d());
            if (this.placeSelectionListener == null) {
                return;
            }
        }
        this.searchResultView.getResultsList().clear();
        this.searchResultView.notifyDataSetChanged();
        this.searchResultView.setVisibility(8);
        this.placeSelectionListener.onPlaceSelected(dVar.d());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.placeOptions = (PlaceOptions) arguments.getParcelable(PlaceConstants.PLACE_OPTIONS);
        }
        if (this.placeOptions == null) {
            this.placeOptions = PlaceOptions.builder().build();
        }
        int iViewMode = this.placeOptions.viewMode();
        this.mode = iViewMode;
        this.rootView = layoutInflater.inflate(iViewMode == 2 ? R.layout.mappls_search_fragment_autocomplete_card : R.layout.mappls_search_fragment_autocomplete_full, viewGroup, false);
        bindViews();
        bindClickListeners();
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        NestedScrollView nestedScrollView = this.resultScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.getViewTreeObserver().removeOnScrollChangedListener(this);
        }
        this.placeSelectionListener = null;
        super.onDestroyView();
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.ui.SearchView.b
    public void onQueryChange(CharSequence charSequence) {
        this.handler.removeCallbacksAndMessages(null);
        this.viewModel.b();
        if (this.placeOptions.saveHistory().booleanValue()) {
            com.mappls.sdk.plugins.places.autocomplete.a.a(this.viewModel.d()).a(charSequence.toString());
        }
        if (charSequence.length() > 0) {
            this.viewModel.a(charSequence.toString());
        } else {
            this.viewModel.c();
        }
        if (!com.mappls.sdk.plugins.places.common.utils.a.a(getContext())) {
            showOfflineView(getString(R.string.mappls_search_offline_message));
            return;
        }
        this.offlineResultView.setVisibility(8);
        if (!this.isSelectItem && charSequence.length() >= this.placeOptions.internalMinCharactersForSearch().intValue()) {
            this.handler.postDelayed(new a(charSequence), this.placeOptions.internalDebounce().intValue());
            if (!com.mappls.sdk.plugins.places.common.utils.a.b(getContext())) {
                this.poorConnectionView.setVisibility(0);
            }
            this.isSelectItem = false;
        }
        this.searchView.hideProgress();
        this.searchResultView.getResultsList().clear();
        ResultView resultView = this.searchResultView;
        resultView.setVisibility(resultView.getResultsList().isEmpty() ? 8 : 0);
        this.searchResultView.notifyDataSetChanged();
        this.poorConnectionView.setVisibility(8);
        this.isSelectItem = false;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        NestedScrollView nestedScrollView = this.resultScrollView;
        if (nestedScrollView != null) {
            if (nestedScrollView.getScrollY() != 0) {
                com.mappls.sdk.plugins.places.common.utils.c.a(this.resultScrollView);
            }
            if (this.mode == 1) {
                return;
            }
            this.dropShadowView.setVisibility(this.resultScrollView.canScrollVertically(-1) ? 0 : 4);
        }
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.ui.SearchView.c
    public void onSearchClick(String str) {
        if (!this.placeOptions.enableTextSearch().booleanValue() || str.length() < this.placeOptions.internalMinCharactersForSearch().intValue()) {
            return;
        }
        this.query = str;
        this.viewModel.b(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.mappls.sdk.plugins.places.autocomplete.viewmodel.a aVar = (com.mappls.sdk.plugins.places.autocomplete.viewmodel.a) new ViewModelProvider(this, new com.mappls.sdk.plugins.places.autocomplete.viewmodel.a.b(getActivity().getApplication(), this.placeOptions)).get(com.mappls.sdk.plugins.places.autocomplete.viewmodel.a.class);
        this.viewModel = aVar;
        aVar.e();
        this.viewModel.a();
        this.viewModel.c();
        subscribe();
        this.resultScrollView.getViewTreeObserver().addOnScrollChangedListener(this);
        styleView();
    }

    public void setOnPlaceSelectedListener(PlaceSelectionListener placeSelectionListener) {
        this.placeSelectionListener = placeSelectionListener;
    }

    public void setSuggestedSearchSelectionListener(SuggestedSearchSelectionListener suggestedSearchSelectionListener) {
        this.suggestedSearchSelectionListener = suggestedSearchSelectionListener;
    }

    void updateSearchHistoryView(List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a> list) {
        this.searchHistoryView.getResultsList().clear();
        this.historyPlaceIds.clear();
        if (list != null) {
            if (this.placeOptions.historyCount() != null) {
                this.historyCount = this.placeOptions.historyCount();
                for (int i = 0; i < this.historyCount.intValue() && i < list.size(); i++) {
                    this.historyPlaceIds.add(list.get(i).d());
                    this.searchHistoryView.getResultsList().add(new com.mappls.sdk.plugins.places.autocomplete.model.d(list.get(i).b(), 1));
                }
            } else {
                for (com.mappls.sdk.plugins.places.autocomplete.data.entity.a aVar : list) {
                    this.historyPlaceIds.add(aVar.d());
                    this.searchHistoryView.getResultsList().add(new com.mappls.sdk.plugins.places.autocomplete.model.d(aVar.b(), 1));
                }
            }
        }
        this.searchHistoryView.notifyDataSetChanged();
        ResultView resultView = this.searchHistoryView;
        resultView.setVisibility(resultView.getResultsList().isEmpty() ? 8 : 0);
    }

    void updateSearchResultView(AutoSuggestAtlasResponse autoSuggestAtlasResponse) {
        this.searchResultView.getResultsList().clear();
        if (autoSuggestAtlasResponse != null) {
            if (autoSuggestAtlasResponse.getSuggestedSearches() != null) {
                Iterator<SuggestedSearchAtlas> it2 = autoSuggestAtlasResponse.getSuggestedSearches().iterator();
                while (it2.hasNext()) {
                    this.searchResultView.getResultsList().add(new com.mappls.sdk.plugins.places.autocomplete.model.d(it2.next()));
                }
            }
            ArrayList<ELocation> arrayList = new ArrayList();
            if (autoSuggestAtlasResponse.getSuggestedLocations() != null) {
                arrayList.addAll(autoSuggestAtlasResponse.getSuggestedLocations());
            }
            if (this.placeOptions.userAddedLocationEnable().booleanValue() && autoSuggestAtlasResponse.getUserAddedLocations() != null) {
                arrayList.addAll(autoSuggestAtlasResponse.getUserAddedLocations());
            }
            for (ELocation eLocation : arrayList) {
                if (!this.historyPlaceIds.contains(eLocation.mapplsPin)) {
                    this.searchResultView.getResultsList().add(new com.mappls.sdk.plugins.places.autocomplete.model.d(eLocation, 2));
                }
            }
        }
        ResultView resultView = this.searchResultView;
        resultView.setVisibility(resultView.getResultsList().isEmpty() ? 8 : 0);
        this.searchResultView.notifyDataSetChanged();
        if (this.offlineResultView.getVisibility() == 0) {
            this.offlineResultView.setVisibility(8);
        }
    }
}
