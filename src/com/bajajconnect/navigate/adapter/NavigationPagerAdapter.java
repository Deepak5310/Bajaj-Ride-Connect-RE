package com.bajajconnect.navigate.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.navigate.model.Stop;
import com.mappls.sdk.navigation.NavigationApplication;
import com.mappls.sdk.navigation.NavigationFormatter;
import com.mappls.sdk.navigation.routing.NavigationStep;
import com.mappls.sdk.navigation.ui.views.turnlane.TurnLaneAdapter;
import com.mappls.sdk.plugin.directions.view.ManeuverView;
import com.mappls.sdk.services.api.directions.models.LegStep;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationPagerAdapter extends PagerAdapter {
    private Stop endPoint;
    private List<NavigationStep> mAdvises;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private OnStripClickListener stripClickListener;
    private int selectedPosition = 0;
    private long distance = 0;

    public interface OnStripClickListener {
        void onStripClicked();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public NavigationPagerAdapter(Context context, List<NavigationStep> list, Stop stop) {
        this.mContext = context;
        this.mAdvises = list;
        this.endPoint = stop;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public void setOnStripClickListener(OnStripClickListener onStripClickListener) {
        this.stripClickListener = onStripClickListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<NavigationStep> list = this.mAdvises;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Resources resources;
        int i2;
        Resources resources2;
        int i3;
        View viewInflate = this.mLayoutInflater.inflate(R.layout.navigation_strip_item, viewGroup, false);
        viewGroup.addView(viewInflate);
        MyViewHolder myViewHolder = new MyViewHolder(viewInflate);
        NavigationStep navigationStep = this.mAdvises.get(i);
        myViewHolder.directionPreviewText.setText(navigationStep.getDescriptionRoutePartHTML());
        myViewHolder.directionShortText.setText(navigationStep.getShortInstruction());
        if (this.selectedPosition == i) {
            long j = this.distance;
            myViewHolder.directionPreviewDist.setText(NavigationFormatter.getFormattedDistance(j > 0 ? Math.round(j / 10) * 10 : 0, getNavigationContext()));
        } else if (i > 0) {
            myViewHolder.directionPreviewDist.setText(NavigationFormatter.getFormattedDistance(this.mAdvises.get(i - 1).distance, getNavigationContext()));
        } else {
            myViewHolder.directionPreviewDist.setText("");
        }
        View view = myViewHolder.container;
        if (i == this.selectedPosition) {
            resources = this.mContext.getResources();
            i2 = R.color.app_blue;
        } else {
            resources = this.mContext.getResources();
            i2 = R.color.colorGray700;
        }
        view.setBackgroundColor(resources.getColor(i2));
        myViewHolder.repeatCurrentInstructionsLayout.setTag(Integer.valueOf(i));
        myViewHolder.container.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.adapter.NavigationPagerAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$instantiateItem$0(view2);
            }
        });
        myViewHolder.repeatCurrentInstructionsLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.adapter.NavigationPagerAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$instantiateItem$1(view2);
            }
        });
        myViewHolder.directionPreviewDist.setVisibility(this.mAdvises.size() + (-1) == i ? 8 : 0);
        if (this.mAdvises.size() - 1 == i && navigationStep.getManeuverID() == 8) {
            myViewHolder.directionPreviewText.setText(this.endPoint.getName());
        }
        if (navigationStep.getExtraInfo() instanceof LegStep) {
            LegStep legStep = (LegStep) navigationStep.getExtraInfo();
            myViewHolder.maneuverViewImageView.setManeuverTypeAndModifier(legStep.maneuver().type(), legStep.maneuver().modifier());
            if (legStep.maneuver().degree() != null) {
                myViewHolder.maneuverViewImageView.setRoundaboutAngle(legStep.maneuver().degree().floatValue());
            } else {
                myViewHolder.maneuverViewImageView.setRoundaboutAngle(180.0f);
            }
            if (legStep.intersections() != null && legStep.intersections().size() > 0 && legStep.intersections().get(0).lanes() != null && !TextUtils.isEmpty(legStep.maneuver().modifier())) {
                RecyclerView recyclerView = myViewHolder.rvTurnLanes;
                if (i == this.selectedPosition) {
                    resources2 = this.mContext.getResources();
                    i3 = R.color.app_blue;
                } else {
                    resources2 = this.mContext.getResources();
                    i3 = R.color.colorGray700;
                }
                recyclerView.setBackgroundColor(resources2.getColor(i3));
                myViewHolder.turnLaneAdapter.addTurnLanes(legStep.intersections().get(0).lanes(), legStep.maneuver().modifier());
                myViewHolder.laneGuidanceContainer.setVisibility(0);
            } else {
                myViewHolder.laneGuidanceContainer.setVisibility(8);
            }
        }
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$instantiateItem$0(View view) {
        OnStripClickListener onStripClickListener = this.stripClickListener;
        if (onStripClickListener != null) {
            onStripClickListener.onStripClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$instantiateItem$1(View view) {
        OnStripClickListener onStripClickListener = this.stripClickListener;
        if (onStripClickListener != null) {
            onStripClickListener.onStripClicked();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getSelectedPosition() {
        return this.selectedPosition;
    }

    public void setSelectedPosition(int i) {
        this.selectedPosition = i;
        notifyDataSetChanged();
    }

    public void setDistance(long j) {
        if (j > 0) {
            this.distance = Math.round(j / 10) * 10;
        } else {
            this.distance = j;
        }
    }

    public NavApplication getMyApplication() {
        return NavApplication.forFragments();
    }

    private NavigationApplication getNavigationContext() {
        NavigationApplication navigationApplicationNavigationContext = NavApplication.navigationContext();
        return navigationApplicationNavigationContext != null ? navigationApplicationNavigationContext : (NavigationApplication) this.mContext.getApplicationContext();
    }

    int getDrawableResId(int i) {
        return this.mContext.getResources().getIdentifier("ic_step_" + i, "drawable", this.mContext.getPackageName());
    }

    class MyViewHolder {
        private View container;
        private TextView directionPreviewDist;
        private TextView directionPreviewText;
        private TextView directionShortText;
        private View laneGuidanceContainer;
        private ManeuverView maneuverViewImageView;
        private LinearLayout repeatCurrentInstructionsLayout;
        private final RecyclerView rvTurnLanes;
        private TurnLaneAdapter turnLaneAdapter;

        public MyViewHolder(View view) {
            this.maneuverViewImageView = (ManeuverView) view.findViewById(R.id.maneuver_image_view);
            this.directionPreviewText = (TextView) view.findViewById(R.id.navigation_strip_text);
            this.directionShortText = (TextView) view.findViewById(R.id.navigation_strip_short_text);
            this.directionPreviewDist = (TextView) view.findViewById(R.id.navigation_strip_dist);
            this.container = view.findViewById(R.id.strip_item_container);
            this.repeatCurrentInstructionsLayout = (LinearLayout) view.findViewById(R.id.repeat_current_instructions_layout);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvTurnLanes);
            this.rvTurnLanes = recyclerView;
            this.laneGuidanceContainer = view.findViewById(R.id.lane_guidance_container);
            TurnLaneAdapter turnLaneAdapter = new TurnLaneAdapter();
            this.turnLaneAdapter = turnLaneAdapter;
            recyclerView.setAdapter(turnLaneAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
        }
    }
}
