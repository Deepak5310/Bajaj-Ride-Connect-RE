package com.mappls.sdk.navigation.ui.navigation.directions;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.routing.NavigationStep;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.databinding.LayoutDirectionAdapterHeaderBinding;
import com.mappls.sdk.navigation.ui.databinding.LayoutDirectionAdapterLightBinding;
import com.mappls.sdk.navigation.ui.navigation.MapplsNavigationViewHelper;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.services.api.directions.models.LegStep;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends RecyclerView.Adapter {
    public List a;
    public h b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        return i == this.a.size() - 1 ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        NavigationStep navigationStep = (NavigationStep) this.a.get(viewHolder.getAdapterPosition());
        if (!(viewHolder instanceof d)) {
            if (!(viewHolder instanceof b)) {
                c cVar = (c) viewHolder;
                LayoutDirectionAdapterHeaderBinding layoutDirectionAdapterHeaderBinding = cVar.a;
                layoutDirectionAdapterHeaderBinding.navigationListDesc.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(layoutDirectionAdapterHeaderBinding.getRoot().getContext(), R.attr.navigationTextColorTertiary));
                LayoutDirectionAdapterHeaderBinding layoutDirectionAdapterHeaderBinding2 = cVar.a;
                layoutDirectionAdapterHeaderBinding2.navigationDirectionPlaceName.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(layoutDirectionAdapterHeaderBinding2.getRoot().getContext(), R.attr.navigationViewDirectionText));
                LayoutDirectionAdapterHeaderBinding layoutDirectionAdapterHeaderBinding3 = cVar.a;
                FrameLayout frameLayout = layoutDirectionAdapterHeaderBinding3.maneuverViewContainer;
                Context context = layoutDirectionAdapterHeaderBinding3.getRoot().getContext();
                frameLayout.setBackground(AppCompatResources.getDrawable(context, com.mappls.sdk.navigation.ui.theme.a.a(context, R.attr.navigationViewManeuverBackground).resourceId));
                return;
            }
            b bVar = (b) viewHolder;
            LayoutDirectionAdapterHeaderBinding layoutDirectionAdapterHeaderBinding4 = bVar.a;
            layoutDirectionAdapterHeaderBinding4.navigationListDesc.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(layoutDirectionAdapterHeaderBinding4.getRoot().getContext(), R.attr.navigationTextColorTertiary));
            LayoutDirectionAdapterHeaderBinding layoutDirectionAdapterHeaderBinding5 = bVar.a;
            layoutDirectionAdapterHeaderBinding5.navigationDirectionPlaceName.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(layoutDirectionAdapterHeaderBinding5.getRoot().getContext(), R.attr.navigationViewDirectionText));
            LayoutDirectionAdapterHeaderBinding layoutDirectionAdapterHeaderBinding6 = bVar.a;
            FrameLayout frameLayout2 = layoutDirectionAdapterHeaderBinding6.maneuverViewContainer;
            Context context2 = layoutDirectionAdapterHeaderBinding6.getRoot().getContext();
            frameLayout2.setBackground(AppCompatResources.getDrawable(context2, com.mappls.sdk.navigation.ui.theme.a.a(context2, R.attr.navigationViewManeuverBackground).resourceId));
            if (MapplsNavigationViewHelper.getInstance().getDestination() != null) {
                bVar.a.navigationDirectionPlaceName.setText(MapplsNavigationViewHelper.getInstance().getDestination().placeName);
            } else {
                bVar.a.navigationDirectionPlaceName.setText("End Stop");
            }
            bVar.a.navigationListDesc.setText(navigationStep.getDescriptionRoutePartHTML());
            return;
        }
        d dVar = (d) viewHolder;
        dVar.a.directionText.setText(navigationStep.getDescriptionRoutePartHTML());
        dVar.a.tvDistance.setText("GO  " + DirectionFormatter.getFormattedDistanceRound(navigationStep.getDistance(), com.mappls.sdk.navigation.ui.utils.d.a()));
        LayoutDirectionAdapterLightBinding layoutDirectionAdapterLightBinding = dVar.a;
        layoutDirectionAdapterLightBinding.tvDistance.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(layoutDirectionAdapterLightBinding.getRoot().getContext(), R.attr.navigationTextColorTertiary));
        LayoutDirectionAdapterLightBinding layoutDirectionAdapterLightBinding2 = dVar.a;
        layoutDirectionAdapterLightBinding2.directionText.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(layoutDirectionAdapterLightBinding2.getRoot().getContext(), R.attr.navigationViewDirectionText));
        LayoutDirectionAdapterLightBinding layoutDirectionAdapterLightBinding3 = dVar.a;
        FrameLayout frameLayout3 = layoutDirectionAdapterLightBinding3.maneuverViewContainer;
        Context context3 = layoutDirectionAdapterLightBinding3.getRoot().getContext();
        frameLayout3.setBackground(AppCompatResources.getDrawable(context3, com.mappls.sdk.navigation.ui.theme.a.a(context3, R.attr.navigationViewManeuverBackground).resourceId));
        LayoutDirectionAdapterLightBinding layoutDirectionAdapterLightBinding4 = dVar.a;
        layoutDirectionAdapterLightBinding4.directionImage.setPrimaryColor(com.mappls.sdk.navigation.ui.theme.a.b(layoutDirectionAdapterLightBinding4.getRoot().getContext(), R.attr.directionListManeuverPrimary));
        LayoutDirectionAdapterLightBinding layoutDirectionAdapterLightBinding5 = dVar.a;
        layoutDirectionAdapterLightBinding5.directionImage.setSecondaryColor(com.mappls.sdk.navigation.ui.theme.a.b(layoutDirectionAdapterLightBinding5.getRoot().getContext(), R.attr.directionListManeuverSecondary));
        if (navigationStep.getExtraInfo() instanceof LegStep) {
            LegStep legStep = (LegStep) navigationStep.getExtraInfo();
            Context applicationContext = dVar.a.getRoot().getContext().getApplicationContext();
            int maneuverID = navigationStep.getManeuverID();
            dVar.a.getRoot().getContext();
            Pair pairA = com.mappls.sdk.navigation.ui.utils.a.a(applicationContext, maneuverID, com.mappls.sdk.navigation.ui.theme.a.a());
            if (pairA != null) {
                dVar.a.directionImage.setVisibility(8);
                dVar.a.directionImageIcon.setVisibility(0);
                dVar.a.directionImageIcon.setImageResource(((Integer) pairA.first).intValue());
            } else {
                dVar.a.directionImage.setVisibility(0);
                dVar.a.directionImageIcon.setVisibility(8);
                dVar.a.directionImage.setManeuverTypeAndModifier(legStep.maneuver().type(), legStep.maneuver().modifier());
            }
            if (legStep.maneuver().type() != null && (legStep.maneuver().type().equalsIgnoreCase("roundabout") || legStep.maneuver().type().equalsIgnoreCase("rotary"))) {
                if (legStep.maneuver().degree() != null) {
                    dVar.a.directionImage.setRoundaboutAngle(com.mappls.sdk.navigation.ui.utils.d.a(legStep.maneuver().degree().floatValue()));
                } else {
                    dVar.a.directionImage.setRoundaboutAngle(com.mappls.sdk.navigation.ui.utils.d.a(180.0f));
                }
            }
        }
        dVar.a.getRoot().setOnClickListener(new a(this, navigationStep));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new c((LayoutDirectionAdapterHeaderBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.layout_direction_adapter_header, viewGroup, false));
        }
        return i == 2 ? new b((LayoutDirectionAdapterHeaderBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.layout_direction_adapter_header, viewGroup, false)) : new d((LayoutDirectionAdapterLightBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.layout_direction_adapter_light, viewGroup, false));
    }
}
