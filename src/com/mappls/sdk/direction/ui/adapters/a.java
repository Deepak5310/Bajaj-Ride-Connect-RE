package com.mappls.sdk.direction.ui.adapters;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionPreviewPagerBinding;
import com.mappls.sdk.direction.ui.model.DirectionOptions;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.plugin.directions.DirectionsUtils;
import com.mappls.sdk.plugin.directions.DistanceType;
import com.mappls.sdk.plugin.directions.view.ManeuverView;
import com.mappls.sdk.services.api.directions.models.LegStep;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends PagerAdapter {
    private final DirectionOptions a;
    MapplsDirectionPreviewPagerBinding b;
    Context c;
    private List<LegStep> d;
    private int e;

    public a(List<LegStep> list, int i, Context context, DirectionOptions directionOptions) {
        this.d = list == null ? new ArrayList<>() : list;
        this.e = i;
        this.c = context;
        this.a = directionOptions;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        List<LegStep> list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        TextView textView;
        String str;
        ManeuverView maneuverView;
        float fFloatValue;
        MapplsDirectionPreviewPagerBinding mapplsDirectionPreviewPagerBindingInflate = MapplsDirectionPreviewPagerBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.b = mapplsDirectionPreviewPagerBindingInflate;
        viewGroup.addView(mapplsDirectionPreviewPagerBindingInflate.getRoot());
        this.c.setTheme(this.e);
        this.b.directionPreviewText.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_color, ContextCompat.getColor(this.c, R.color.mappls_directions_colorTextPrimary), this.c));
        this.b.directionPreviewDist.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_secondary, ContextCompat.getColor(this.c, R.color.mappls_directions_colorTextSecondary), this.c));
        this.b.maneuverViewContainer.setBackgroundResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_mv_bg_drawable, R.drawable.mappls_direction_circle_black, this.c));
        this.b.navigateIcon.setPrimaryColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_mv_primary_color, ContextCompat.getColor(this.c, R.color.mappls_directions_mv_primarycolor), this.c));
        this.b.navigateIcon.setSecondaryColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_mv_secondary_color, ContextCompat.getColor(this.c, R.color.mappls_directions_mv_secondarycolor), this.c));
        this.b.directionPreviewText.setText(DirectionsUtils.getTextInstructions(this.d.get(i)));
        Context applicationContext = this.c.getApplicationContext();
        Integer maneuverId = DirectionsUtils.getManeuverId(this.d.get(i));
        int iIntValue = maneuverId.intValue();
        StringBuilder sb = this.a.theme().intValue() == 2 ? new StringBuilder("mappls_maneuver_dark_icon_") : new StringBuilder("mappls_maneuver_icon_");
        sb.append(iIntValue);
        int identifier = applicationContext.getResources().getIdentifier(sb.toString(), "drawable", applicationContext.getPackageName());
        Pair pair = identifier != 0 ? new Pair(Integer.valueOf(identifier), maneuverId) : null;
        if (pair != null) {
            this.b.navigateIcon.setVisibility(8);
            this.b.navigateManeuverIcon.setVisibility(0);
            this.b.navigateManeuverIcon.setImageResource(((Integer) pair.first).intValue());
        } else {
            this.b.navigateIcon.setVisibility(0);
            this.b.navigateManeuverIcon.setVisibility(8);
            this.b.navigateIcon.setManeuverTypeAndModifier((String) Objects.requireNonNull(this.d.get(i).maneuver().type()), this.d.get(i).maneuver().modifier());
        }
        String strType = this.d.get(i).maneuver().type();
        if (strType != null && (strType.equalsIgnoreCase("roundabout") || strType.equalsIgnoreCase("rotary"))) {
            if (this.d.get(i).maneuver().degree() != null) {
                maneuverView = this.b.navigateIcon;
                fFloatValue = this.d.get(i).maneuver().degree().floatValue();
            } else {
                maneuverView = this.b.navigateIcon;
                fFloatValue = 180.0f;
            }
            maneuverView.setRoundaboutAngle(fFloatValue);
        }
        DirectionOptions directionOptions = this.a;
        if (directionOptions == null || directionOptions.distanceType().intValue() == 0) {
            textView = this.b.directionPreviewDist;
            str = String.format("GO  %s", DirectionFormatter.getFormattedDistanceRound(this.d.get(i).distance(), DistanceType.METRIC));
        } else {
            textView = this.b.directionPreviewDist;
            str = String.format("GO  %s", DirectionFormatter.getFormattedDistanceRound(this.d.get(i).distance(), DistanceType.IMPERIAL));
        }
        textView.setText(str);
        return this.b.getRoot();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
