package com.mappls.sdk.direction.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionListHeaderBinding;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionStepAdapterBinding;
import com.mappls.sdk.direction.ui.model.DirectionOptions;
import com.mappls.sdk.direction.ui.model.StopModel;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.plugin.directions.DirectionsUtils;
import com.mappls.sdk.plugin.directions.DistanceType;
import com.mappls.sdk.plugin.directions.view.ManeuverView;
import com.mappls.sdk.services.api.directions.models.LegStep;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int a;
    private List<LegStep> b;
    private List<StopModel> c = new ArrayList();
    Context d;
    private e e;
    private DirectionOptions f;
    private boolean g;

    final class a implements View.OnClickListener {
        final /* synthetic */ RecyclerView.ViewHolder a;

        a(RecyclerView.ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.a.getAdapterPosition() == 0 || this.a.getAdapterPosition() == b.this.getItemCount() - 1) {
                return;
            }
            b.this.e.a(this.a.getAdapterPosition() - 1);
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.direction.ui.adapters.b$b, reason: collision with other inner class name */
    public static class C0070b extends RecyclerView.ViewHolder {
        private final MapplsDirectionListHeaderBinding a;

        public C0070b(MapplsDirectionListHeaderBinding mapplsDirectionListHeaderBinding) {
            super(mapplsDirectionListHeaderBinding.getRoot());
            this.a = mapplsDirectionListHeaderBinding;
            mapplsDirectionListHeaderBinding.imageIcon.setImageDrawable(ContextCompat.getDrawable(mapplsDirectionListHeaderBinding.getRoot().getContext(), R.drawable.mappls_direction_baseline_stop));
        }
    }

    public static class c extends RecyclerView.ViewHolder {
        private final MapplsDirectionListHeaderBinding a;

        public c(MapplsDirectionListHeaderBinding mapplsDirectionListHeaderBinding) {
            super(mapplsDirectionListHeaderBinding.getRoot());
            this.a = mapplsDirectionListHeaderBinding;
            mapplsDirectionListHeaderBinding.imageIcon.setImageDrawable(ContextCompat.getDrawable(mapplsDirectionListHeaderBinding.getRoot().getContext(), R.drawable.mappls_direction_play_arrow));
            mapplsDirectionListHeaderBinding.directionListDesc.setText(mapplsDirectionListHeaderBinding.getRoot().getContext().getResources().getString(R.string.mappls_direction_starting_text));
        }
    }

    public static class d extends RecyclerView.ViewHolder {
        private final MapplsDirectionStepAdapterBinding a;

        public d(MapplsDirectionStepAdapterBinding mapplsDirectionStepAdapterBinding) {
            super(mapplsDirectionStepAdapterBinding.getRoot());
            this.a = mapplsDirectionStepAdapterBinding;
        }
    }

    public interface e {
        void a(int i);
    }

    public b(Context context, int i, DirectionOptions directionOptions, boolean z) {
        this.d = context;
        this.a = i;
        this.f = directionOptions;
        this.g = z;
        setHasStableIds(true);
    }

    public final void a(e eVar) {
        this.e = eVar;
    }

    public final void a(List<LegStep> list, List<StopModel> list2) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.b = list;
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        this.c = list2;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.c.size() > 0) {
            List<LegStep> list = this.b;
            if (list == null) {
                return 1;
            }
            return 1 + list.size();
        }
        List<LegStep> list2 = this.b;
        if (list2 == null) {
            return 0;
        }
        return list2.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        return i == getItemCount() - 1 ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        String placeName;
        TextView textView2;
        String textInstructions;
        ManeuverView maneuverView;
        float fFloatValue;
        if (getItemViewType(viewHolder.getBindingAdapterPosition()) == 1) {
            if (!(viewHolder instanceof d)) {
                return;
            }
            d dVar = (d) viewHolder;
            LegStep legStep = this.b.get(viewHolder.getBindingAdapterPosition() - 1);
            if (legStep.maneuver().instruction() != null) {
                textView2 = dVar.a.stepsText;
                textInstructions = legStep.maneuver().instruction();
            } else {
                textView2 = dVar.a.stepsText;
                textInstructions = DirectionsUtils.getTextInstructions(legStep);
            }
            textView2.setText(textInstructions);
            Context applicationContext = this.d.getApplicationContext();
            Integer maneuverId = DirectionsUtils.getManeuverId(legStep);
            int iIntValue = maneuverId.intValue();
            int i2 = this.g ? 2 : 1;
            Integer.valueOf(i2).getClass();
            StringBuilder sb = i2 == 2 ? new StringBuilder("mappls_maneuver_dark_icon_") : new StringBuilder("mappls_maneuver_icon_");
            sb.append(iIntValue);
            int identifier = applicationContext.getResources().getIdentifier(sb.toString(), "drawable", applicationContext.getPackageName());
            Pair pair = identifier != 0 ? new Pair(Integer.valueOf(identifier), maneuverId) : null;
            if (pair != null) {
                dVar.a.navigateIcon.setVisibility(8);
                dVar.a.navigateManeuverIcon.setVisibility(0);
                dVar.a.navigateManeuverIcon.setImageResource(((Integer) pair.first).intValue());
            } else {
                dVar.a.navigateIcon.setVisibility(0);
                dVar.a.navigateManeuverIcon.setVisibility(8);
                dVar.a.navigateIcon.setManeuverTypeAndModifier((String) Objects.requireNonNull(legStep.maneuver().type()), legStep.maneuver().modifier());
            }
            dVar.a.stepsText.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_color, ContextCompat.getColor(this.d, R.color.mappls_directions_colorTextPrimary), this.d));
            dVar.a.distanceText.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_secondary, ContextCompat.getColor(this.d, R.color.mappls_directions_colorTextSecondary), this.d));
            dVar.a.maneuverViewContainer.setBackgroundResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_mv_bg_drawable, R.drawable.mappls_direction_circle_black, this.d));
            dVar.a.navigateIcon.setPrimaryColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_mv_primary_color, ContextCompat.getColor(this.d, R.color.mappls_directions_mv_primarycolor), this.d));
            dVar.a.navigateIcon.setSecondaryColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_mv_secondary_color, ContextCompat.getColor(this.d, R.color.mappls_directions_mv_secondarycolor), this.d));
            dVar.a.stepsListSeperator.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_steps_list_seperator, Color.parseColor("#757575"), this.d));
            String strType = legStep.maneuver().type();
            if (strType != null && (strType.equalsIgnoreCase("roundabout") || strType.equalsIgnoreCase("rotary"))) {
                if (legStep.maneuver().degree() != null) {
                    maneuverView = dVar.a.navigateIcon;
                    fFloatValue = legStep.maneuver().degree().floatValue();
                } else {
                    maneuverView = dVar.a.navigateIcon;
                    fFloatValue = 180.0f;
                }
                maneuverView.setRoundaboutAngle(fFloatValue);
            }
            dVar.a.mapplsDirectionSteplistContainer.setOnClickListener(new a(viewHolder));
            DirectionOptions directionOptions = this.f;
            if (directionOptions == null || directionOptions.distanceType().intValue() == 0) {
                textView = dVar.a.distanceText;
                placeName = String.format("GO  %s", DirectionFormatter.getFormattedDistanceRound(legStep.distance(), DistanceType.METRIC));
            } else {
                textView = dVar.a.distanceText;
                placeName = String.format("GO  %s", DirectionFormatter.getFormattedDistanceRound(legStep.distance(), DistanceType.IMPERIAL));
            }
        } else {
            if (getItemViewType(viewHolder.getAdapterPosition()) != 0) {
                if (getItemViewType(viewHolder.getAdapterPosition()) == 2 && (viewHolder instanceof C0070b)) {
                    C0070b c0070b = (C0070b) viewHolder;
                    c0070b.a.imageIconContainer.setBackgroundResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_mv_bg_drawable, R.drawable.mappls_direction_circle_black, this.d));
                    c0070b.a.directionListPlaceName.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_color, ContextCompat.getColor(this.d, R.color.mappls_directions_colorTextPrimary), this.d));
                    c0070b.a.directionListDesc.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_secondary, ContextCompat.getColor(this.d, R.color.mappls_directions_colorTextSecondary), this.d));
                    c0070b.a.directionListSeperator.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_steps_list_seperator, Color.parseColor("#757575"), this.d));
                    if (this.c.size() > 0) {
                        List<StopModel> list = this.c;
                        StopModel stopModel = list.get(list.size() - 1);
                        if (stopModel.getLocationType() == StopModel.TYPE_CURRENT_LOCATION) {
                            c0070b.a.directionListPlaceName.setText("Your Current Location");
                        } else if (stopModel.getLocationType() == StopModel.TYPE_BLANK) {
                            TextView textView3 = c0070b.a.directionListPlaceName;
                            List<StopModel> list2 = this.c;
                            textView3.setText(list2.get(list2.size() - 2).getPlaceName());
                        } else {
                            c0070b.a.directionListPlaceName.setText(stopModel.getPlaceName());
                        }
                    }
                    if (this.b.get(c0070b.getBindingAdapterPosition() - 1).maneuver().instruction() != null) {
                        c0070b.a.directionListDesc.setText(this.b.get(c0070b.getBindingAdapterPosition() - 1).maneuver().instruction());
                        return;
                    } else {
                        c0070b.a.directionListDesc.setText(DirectionsUtils.getTextInstructions(this.b.get(viewHolder.getBindingAdapterPosition() - 1)));
                        return;
                    }
                }
                return;
            }
            if (!(viewHolder instanceof c)) {
                return;
            }
            c cVar = (c) viewHolder;
            cVar.a.imageIconContainer.setBackgroundResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_mv_bg_drawable, R.drawable.mappls_direction_circle_black, this.d));
            cVar.a.directionListPlaceName.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(this.d, R.color.mappls_directions_colorTextPrimary), this.d));
            cVar.a.directionListDesc.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_secondary, ContextCompat.getColor(this.d, R.color.mappls_directions_colorTextSecondary), this.d));
            cVar.a.directionListSeperator.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_steps_list_seperator, Color.parseColor("#757575"), this.d));
            if (this.c.size() <= 0) {
                return;
            }
            StopModel stopModel2 = this.c.get(0);
            int locationType = stopModel2.getLocationType();
            int i3 = StopModel.TYPE_CURRENT_LOCATION;
            textView = cVar.a.directionListPlaceName;
            if (locationType == i3) {
                textView.setText("Your Current Location");
                return;
            }
            placeName = stopModel2.getPlaceName();
        }
        textView.setText(placeName);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.d.setTheme(this.a);
        if (i == 0) {
            return new c((MapplsDirectionListHeaderBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.mappls_direction_list_header, viewGroup, false));
        }
        return i == 2 ? new C0070b((MapplsDirectionListHeaderBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.mappls_direction_list_header, viewGroup, false)) : new d((MapplsDirectionStepAdapterBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.mappls_direction_step_adapter, viewGroup, false));
    }
}
