package com.mappls.sdk.navigation.ui.navigation.instructioncontainer;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.routing.NavigationStep;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.views.turnlane.TurnLaneAdapter;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.plugin.directions.view.ManeuverView;
import com.mappls.sdk.services.api.directions.models.IntersectionLanes;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.services.api.directions.models.StepIntersection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends PagerAdapter {
    public final List a;
    public final Context b;
    public final LayoutInflater c;
    public int d = 1;
    public long e = 0;

    public f(Context context, List list) {
        this.b = context;
        this.a = list;
        this.c = LayoutInflater.from(context);
    }

    public static /* synthetic */ void a(View view) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        List list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        View view;
        TurnLaneAdapter turnLaneAdapter;
        Context context;
        int i2;
        int i3;
        List<IntersectionLanes> listLanes;
        Context context2;
        int i4;
        View viewInflate = this.c.inflate(R.layout.instruction_container_item, viewGroup, false);
        viewGroup.addView(viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.maneuver_image);
        ManeuverView maneuverView = (ManeuverView) viewInflate.findViewById(R.id.maneuver_image_view);
        TextView textView = (TextView) viewInflate.findViewById(R.id.maneuver_id_text_view);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.navigation_strip_text);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.navigation_strip_short_text);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.navigation_strip_dist);
        View viewFindViewById = viewInflate.findViewById(R.id.strip_item_container);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.repeat_current_instructions_layout);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.rvTurnLanes);
        View viewFindViewById2 = viewInflate.findViewById(R.id.lane_guidance_container);
        TurnLaneAdapter turnLaneAdapter2 = new TurnLaneAdapter();
        recyclerView.setAdapter(turnLaneAdapter2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewInflate.getContext(), 0, false));
        NavigationStep navigationStep = (NavigationStep) this.a.get(i);
        textView2.setText(navigationStep.getDescriptionRoutePartHTML());
        Locale.getDefault();
        textView3.setText(navigationStep.getShortInstruction());
        if (this.d == i) {
            turnLaneAdapter = turnLaneAdapter2;
            view = viewInflate;
            textView4.setText(DirectionFormatter.getFormattedDistanceRound(this.e, com.mappls.sdk.navigation.ui.utils.d.a()));
        } else {
            view = viewInflate;
            turnLaneAdapter = turnLaneAdapter2;
            if (i > 0) {
                textView4.setText(DirectionFormatter.getFormattedDistanceRound(((NavigationStep) this.a.get(i - 1)).distance, com.mappls.sdk.navigation.ui.utils.d.a()));
            } else {
                textView4.setText("");
            }
        }
        maneuverView.setPrimaryColor(com.mappls.sdk.navigation.ui.theme.a.b(this.b, R.attr.navigationViewBannerManeuverPrimary));
        maneuverView.setSecondaryColor(com.mappls.sdk.navigation.ui.theme.a.b(this.b, R.attr.navigationViewBannerManeuverSecondary));
        if (i == this.d) {
            context = this.b;
            i2 = R.attr.navigationViewBannerBackgroundSelected;
        } else {
            context = this.b;
            i2 = R.attr.navigationViewBannerBackgroundUnSelected;
        }
        viewFindViewById.setBackgroundResource(com.mappls.sdk.navigation.ui.theme.a.a(context, i2).resourceId);
        textView4.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(this.b, R.attr.navigationViewBannerSecondaryText));
        textView2.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(this.b, R.attr.navigationViewBannerPrimaryText));
        textView3.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(this.b, R.attr.navigationViewBannerPrimaryText));
        linearLayout.setTag(Integer.valueOf(i));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.navigation.ui.navigation.instructioncontainer.f$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f.a(view2);
            }
        });
        if (navigationStep.getExtraInfo() instanceof LegStep) {
            LegStep legStep = (LegStep) navigationStep.getExtraInfo();
            Pair pairA = com.mappls.sdk.navigation.ui.utils.a.a(this.b.getApplicationContext(), navigationStep.getManeuverID(), true);
            if (pairA != null) {
                maneuverView.setVisibility(8);
                imageView.setVisibility(0);
                imageView.setImageResource(((Integer) pairA.first).intValue());
            } else {
                maneuverView.setVisibility(0);
                imageView.setVisibility(8);
                maneuverView.setManeuverTypeAndModifier(legStep.maneuver().type(), legStep.maneuver().modifier());
            }
            if (legStep.maneuver().type().equalsIgnoreCase("roundabout") || legStep.maneuver().type().equalsIgnoreCase("rotary")) {
                if (legStep.maneuver().degree() != null) {
                    maneuverView.setRoundaboutAngle(com.mappls.sdk.navigation.ui.utils.d.a(legStep.maneuver().degree().floatValue()));
                    float fFloatValue = legStep.maneuver().degree().floatValue();
                    if (fFloatValue <= 45.0f) {
                        i3 = 65;
                    } else if (fFloatValue <= 90.0f) {
                        i3 = 66;
                    } else if (fFloatValue <= 135.0f) {
                        i3 = 67;
                    } else if (fFloatValue <= 180.0f) {
                        i3 = 68;
                    } else if (fFloatValue <= 225.0f) {
                        i3 = 69;
                    } else {
                        i3 = fFloatValue <= 270.0f ? 70 : 71;
                    }
                    navigationStep.setManeuverID(i3);
                } else {
                    maneuverView.setRoundaboutAngle(180.0f);
                }
            }
            textView.setText(String.format("Maneuver ID = %d", Integer.valueOf(navigationStep.getManeuverID())));
            if (legStep.intersections() != null && legStep.intersections().size() > 0) {
                Iterator<StepIntersection> it2 = legStep.intersections().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        listLanes = null;
                        break;
                    }
                    StepIntersection next = it2.next();
                    if (new LatLng(next.location().latitude(), next.location().longitude()).distanceTo(new LatLng(legStep.maneuver().location().latitude(), legStep.maneuver().location().longitude())) <= 0.0d) {
                        listLanes = next.lanes();
                        break;
                    }
                }
            } else {
                listLanes = null;
                break;
            }
            if (listLanes == null || TextUtils.isEmpty(legStep.maneuver().modifier())) {
                viewFindViewById2.setVisibility(8);
            } else {
                if (i == this.d) {
                    context2 = this.b;
                    i4 = R.attr.navigationViewLaneBackgroundSelected;
                } else {
                    context2 = this.b;
                    i4 = R.attr.navigationViewLaneBackgroundUnSelected;
                }
                recyclerView.setBackgroundColor(com.mappls.sdk.navigation.ui.theme.a.b(context2, i4));
                turnLaneAdapter.addTurnLanes(listLanes, legStep.maneuver().modifier());
                viewFindViewById2.setVisibility(0);
            }
        }
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
