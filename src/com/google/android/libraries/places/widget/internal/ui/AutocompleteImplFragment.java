package com.google.android.libraries.places.widget.internal.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.zzdh;
import com.google.android.libraries.places.internal.zzif;
import com.google.android.libraries.places.internal.zziu;
import com.google.android.libraries.places.internal.zziw;
import com.google.android.libraries.places.internal.zzix;
import com.google.android.libraries.places.internal.zziy;
import com.google.android.libraries.places.internal.zzji;
import com.google.android.libraries.places.internal.zzjm;
import com.google.android.libraries.places.internal.zzjo;
import com.google.android.libraries.places.internal.zzjr;
import com.google.android.libraries.places.internal.zzjs;
import com.google.android.libraries.places.internal.zzkt;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteImplFragment extends Fragment {
    private final PlacesClient zza;
    private final zziu zzb;
    private final zzjs zzc;
    private final zzdh zzd;
    private zzjo zze;
    private PlaceSelectionListener zzf;
    private EditText zzg;
    private RecyclerView zzh;
    private View zzi;
    private View zzj;
    private View zzk;
    private View zzl;
    private View zzm;
    private View zzn;
    private View zzo;
    private View zzp;
    private TextView zzq;
    private TextView zzr;
    private zzr zzs;
    private final zzj zzt;

    private AutocompleteImplFragment(int i, PlacesClient placesClient, zziu zziuVar, zzjs zzjsVar, zzdh zzdhVar) {
        super(i);
        this.zzt = new zzj(this, null);
        this.zza = placesClient;
        this.zzb = zziuVar;
        this.zzc = zzjsVar;
        this.zzd = zzdhVar;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            zzjr zzjrVar = new zzjr(this.zzb.zzf(), this.zzb.zzh(), this.zzb.zzm(), this.zzd);
            zzjo zzjoVar = (zzjo) new ViewModelProvider(this, new zzjm(new zzji(this.zza, this.zzb, zzjrVar.zzh()), zzjrVar, this.zzc)).get(zzjo.class);
            this.zze = zzjoVar;
            zzjoVar.zze(bundle);
            requireActivity().getOnBackPressedDispatcher().addCallback(this, new zzf(this, true));
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.zze.zzi();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.zze.zzh();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        int identifier;
        try {
            this.zzg = (EditText) view.findViewById(R.id.places_autocomplete_search_bar);
            this.zzh = (RecyclerView) view.findViewById(R.id.places_autocomplete_list);
            this.zzi = view.findViewById(R.id.places_autocomplete_back_button);
            this.zzj = view.findViewById(R.id.places_autocomplete_clear_button);
            this.zzk = view.findViewById(R.id.places_autocomplete_search_bar_separator);
            this.zzl = view.findViewById(R.id.places_autocomplete_progress);
            this.zzm = view.findViewById(R.id.places_autocomplete_try_again_progress);
            this.zzn = view.findViewById(R.id.places_autocomplete_powered_by_google);
            this.zzo = view.findViewById(R.id.places_autocomplete_powered_by_google_separator);
            this.zzp = view.findViewById(R.id.places_autocomplete_sad_cloud);
            this.zzq = (TextView) view.findViewById(R.id.places_autocomplete_error_message);
            this.zzr = (TextView) view.findViewById(R.id.places_autocomplete_try_again);
            this.zzg.addTextChangedListener(this.zzt);
            this.zzg.setOnFocusChangeListener(new zzl(null));
            this.zzg.setHint(TextUtils.isEmpty(this.zzb.zzl()) ? zzix.zzc(requireContext(), R.string.places_autocomplete_search_hint) : this.zzb.zzl());
            AutocompleteActivityMode autocompleteActivityMode = AutocompleteActivityMode.FULLSCREEN;
            int iOrdinal = this.zzb.zzh().ordinal();
            if (iOrdinal == 0) {
                int iZza = this.zzb.zza();
                int iZzb = this.zzb.zzb();
                if (Color.alpha(iZza) < 255) {
                    iZza = 0;
                }
                if (iZza != 0 && iZzb != 0) {
                    int iZza2 = zziy.zza(iZza, ContextCompat.getColor(requireContext(), R.color.places_text_white_alpha_87), ContextCompat.getColor(requireContext(), R.color.places_text_black_alpha_87));
                    int iZza3 = zziy.zza(iZza, ContextCompat.getColor(requireContext(), R.color.places_text_white_alpha_26), ContextCompat.getColor(requireContext(), R.color.places_text_black_alpha_26));
                    view.findViewById(R.id.places_autocomplete_search_bar_container).setBackgroundColor(iZza);
                    Window window = requireActivity().getWindow();
                    if (zziy.zzc(iZzb, -1, ViewCompat.MEASURED_STATE_MASK)) {
                        window.setStatusBarColor(iZzb);
                        window.getDecorView().setSystemUiVisibility(8192);
                    } else {
                        window.setStatusBarColor(iZzb);
                    }
                    this.zzg.setTextColor(iZza2);
                    this.zzg.setHintTextColor(iZza3);
                    zziy.zzb((ImageView) this.zzi, iZza2);
                    zziy.zzb((ImageView) this.zzj, iZza2);
                }
            } else if (iOrdinal == 1 && (identifier = getResources().getIdentifier("status_bar_height", "dimen", SystemMediaRouteProvider.PACKAGE_NAME)) > 0) {
                requireActivity().getWindow().addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
                ViewCompat.setPaddingRelative(view, view.getPaddingLeft(), view.getPaddingTop() + getResources().getDimensionPixelSize(identifier), view.getPaddingRight(), view.getPaddingBottom());
            }
            this.zzi.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.ui.zzc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.zza.zzc(view2);
                }
            });
            this.zzj.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.ui.zzb
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.zza.zzd(view2);
                }
            });
            this.zzr.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.ui.zze
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.zza.zzf(view2);
                }
            });
            this.zzs = new zzr(new zzd(this));
            this.zzh.setLayoutManager(new LinearLayoutManager(requireContext()));
            this.zzh.setItemAnimator(new zzo(getResources()));
            this.zzh.setAdapter(this.zzs);
            this.zzh.addOnScrollListener(new zzg(this));
            this.zze.zza().observe(getViewLifecycleOwner(), new Observer() { // from class: com.google.android.libraries.places.widget.internal.ui.zza
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.zza.zzg((zziw) obj);
                }
            });
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    final /* synthetic */ void zzc(View view) {
        this.zze.zzj();
    }

    final /* synthetic */ void zzg(zziw zziwVar) {
        try {
            this.zzj.setVisibility(0);
            this.zzk.setVisibility(0);
            this.zzl.setVisibility(8);
            this.zzm.setVisibility(8);
            this.zzn.setVisibility(0);
            this.zzo.setVisibility(8);
            this.zzp.setVisibility(8);
            this.zzq.setVisibility(8);
            this.zzr.setVisibility(8);
            AutocompleteActivityMode autocompleteActivityMode = AutocompleteActivityMode.FULLSCREEN;
            switch (zziwVar.zzf() - 1) {
                case 0:
                    if (TextUtils.isEmpty(this.zzb.zzm())) {
                        this.zzj.setVisibility(8);
                    }
                    this.zzg.requestFocus();
                    this.zzg.setText(this.zzb.zzm());
                    EditText editText = this.zzg;
                    editText.setSelection(editText.getText().length());
                    return;
                case 1:
                    this.zzs.submitList(null);
                    this.zzj.setVisibility(8);
                    this.zzg.getText().clear();
                    return;
                case 2:
                    this.zzl.setVisibility(0);
                    return;
                case 3:
                    this.zzr.setVisibility(8);
                    this.zzm.setVisibility(0);
                    this.zzn.setVisibility(8);
                    this.zzp.setVisibility(0);
                    this.zzq.setVisibility(0);
                    return;
                case 4:
                    this.zzs.submitList(zziwVar.zzd());
                    this.zzo.setVisibility(0);
                    return;
                case 5:
                    this.zzs.submitList(null);
                    this.zzn.setVisibility(8);
                    this.zzp.setVisibility(0);
                    this.zzr.setVisibility(4);
                    this.zzq.setText(getString(R.string.places_autocomplete_no_results_for_query, zziwVar.zze()));
                    this.zzq.setVisibility(0);
                    return;
                case 6:
                    break;
                case 7:
                default:
                    PlaceSelectionListener placeSelectionListener = this.zzf;
                    Place placeZzc = zziwVar.zzc();
                    if (placeZzc == null) {
                        throw null;
                    }
                    placeSelectionListener.onPlaceSelected(placeZzc);
                    return;
                case 8:
                    AutocompletePrediction autocompletePredictionZzb = zziwVar.zzb();
                    zzkt.zzc(autocompletePredictionZzb, "Prediction should not be null.");
                    this.zzg.clearFocus();
                    this.zzg.removeTextChangedListener(this.zzt);
                    this.zzg.setText(autocompletePredictionZzb.getPrimaryText(null));
                    this.zzg.addTextChangedListener(this.zzt);
                    break;
                case 9:
                    PlaceSelectionListener placeSelectionListener2 = this.zzf;
                    Status statusZza = zziwVar.zza();
                    if (statusZza == null) {
                        throw null;
                    }
                    placeSelectionListener2.onError(statusZza);
                    return;
            }
            this.zzs.submitList(null);
            this.zzn.setVisibility(8);
            this.zzp.setVisibility(0);
            this.zzr.setVisibility(0);
            this.zzq.setText(getString(R.string.places_search_error));
            this.zzq.setVisibility(0);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    public final void zzh(PlaceSelectionListener placeSelectionListener) {
        this.zzf = placeSelectionListener;
    }

    final /* synthetic */ void zzd(View view) {
        try {
            this.zze.zzk();
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    final /* synthetic */ void zze(AutocompletePrediction autocompletePrediction, int i) {
        try {
            this.zze.zzf(autocompletePrediction, i);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    final /* synthetic */ void zzf(View view) {
        try {
            this.zze.zzl(this.zzg.getText().toString());
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }
}
