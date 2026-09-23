package com.mappls.sdk.direction.ui.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionItemStopBinding;
import com.mappls.sdk.direction.ui.model.DirectionOptions;
import com.mappls.sdk.direction.ui.model.StopModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class j extends RecyclerView.Adapter<b> implements DraggableItemAdapter<b> {
    private List<StopModel> a = new ArrayList();
    private a b;
    private final DirectionOptions c;

    public interface a {
        void a();

        void a(int i);

        void a(StopModel stopModel);

        void b(int i);
    }

    public class b extends AbstractDraggableItemViewHolder {
        MapplsDirectionItemStopBinding a;

        public b(MapplsDirectionItemStopBinding mapplsDirectionItemStopBinding) {
            super(mapplsDirectionItemStopBinding.getRoot());
            this.a = mapplsDirectionItemStopBinding;
        }
    }

    public j(DirectionOptions directionOptions) {
        setHasStableIds(true);
        this.c = directionOptions;
    }

    public final void a(a aVar) {
        this.b = aVar;
    }

    public final void a(List<StopModel> list) {
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.a.size();
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
        if (this.a.size() == 2 && i == 1) {
            return 1;
        }
        if (i != this.a.size() - 1) {
            return (i == this.a.size() - 2 && com.mappls.sdk.direction.ui.common.a.a(this.a.get(i + 1))) ? 1 : 2;
        }
        List<StopModel> list = this.a;
        return com.mappls.sdk.direction.ui.common.a.a(list.get(list.size() - 1)) ? 3 : 1;
    }

    /* JADX WARN: Code duplicated, block: B:73:0x02d4  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        String placeName;
        int resourceId;
        ImageView imageView;
        Resources resources;
        int i2;
        MapplsDirectionItemStopBinding mapplsDirectionItemStopBinding;
        ImageView imageView2;
        int i3;
        int i4;
        ImageView imageView3;
        Resources resources2;
        int i5;
        b bVar = (b) viewHolder;
        StopModel stopModel = this.a.get(bVar.getBindingAdapterPosition());
        MapplsDirectionItemStopBinding mapplsDirectionItemStopBinding2 = bVar.a;
        mapplsDirectionItemStopBinding2.textViewAddStop.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_color, ContextCompat.getColor(mapplsDirectionItemStopBinding2.getRoot().getContext(), R.color.mappls_directions_colorTextPrimary), bVar.a.getRoot().getContext()));
        bVar.a.mapplsDirectionRouteStepSeperatorView.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_stop_seperator_color, Color.parseColor("#DDDDDD"), bVar.a.getRoot().getContext()));
        MapplsDirectionItemStopBinding mapplsDirectionItemStopBinding3 = bVar.a;
        mapplsDirectionItemStopBinding3.imgDrag.setImageResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_drag_stop, R.drawable.mappls_direction_drag_handle_dark, mapplsDirectionItemStopBinding3.getRoot().getContext()));
        if (stopModel.getLocationType() == StopModel.TYPE_CURRENT_LOCATION) {
            textView = bVar.a.textViewAddStop;
            placeName = "Your Current Location";
        } else if (stopModel.getLocationType() == StopModel.TYPE_STOP) {
            textView = bVar.a.textViewAddStop;
            placeName = stopModel.getPlaceName();
        } else {
            textView = bVar.a.textViewAddStop;
            placeName = "";
        }
        textView.setText(placeName);
        if (this.a.size() > 2) {
            bVar.a.imgDrag.setVisibility(0);
            if (stopModel.getLocationType() == StopModel.TYPE_BLANK) {
                bVar.a.imgClear.setVisibility(4);
            } else {
                bVar.a.imgClear.setVisibility(0);
                MapplsDirectionItemStopBinding mapplsDirectionItemStopBinding4 = bVar.a;
                mapplsDirectionItemStopBinding4.imgClear.setImageResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_clear_stop, R.drawable.mappls_direction_clear_input_text_dark, mapplsDirectionItemStopBinding4.getRoot().getContext()));
            }
        } else {
            bVar.a.imgClear.setVisibility(4);
            bVar.a.imgDrag.setVisibility(8);
        }
        if (bVar.getBindingAdapterPosition() == 0 || (stopModel.getLocationType() == StopModel.TYPE_BLANK && this.a.size() > 2 && bVar.getBindingAdapterPosition() == this.a.size() - 1)) {
            bVar.a.connector.setVisibility(8);
        } else {
            bVar.a.connector.setVisibility(0);
        }
        if (getItemViewType(bVar.getBindingAdapterPosition()) == 0) {
            if (this.a.get(bVar.getBindingAdapterPosition()).getLocationType() == StopModel.TYPE_CURRENT_LOCATION) {
                MapplsDirectionItemStopBinding mapplsDirectionItemStopBinding5 = bVar.a;
                imageView3 = mapplsDirectionItemStopBinding5.imgStopType;
                resources2 = mapplsDirectionItemStopBinding5.getRoot().getContext().getResources();
                i5 = R.drawable.mappls_direction_current_location_icon;
            } else {
                MapplsDirectionItemStopBinding mapplsDirectionItemStopBinding6 = bVar.a;
                imageView3 = mapplsDirectionItemStopBinding6.imgStopType;
                resources2 = mapplsDirectionItemStopBinding6.getRoot().getContext().getResources();
                i5 = R.drawable.mappls_direction_start_loc;
            }
            imageView3.setImageDrawable(resources2.getDrawable(i5));
            if (this.a.size() < 3) {
                bVar.a.imgClear.setVisibility(0);
                mapplsDirectionItemStopBinding = bVar.a;
                imageView2 = mapplsDirectionItemStopBinding.imgClear;
                i3 = R.styleable.mappls_direction_mappls_directions_reverse_stop;
                i4 = R.drawable.mappls_direction_reverse_route_dark;
                imageView2.setImageResource(com.mappls.sdk.direction.ui.utils.b.b(i3, i4, mapplsDirectionItemStopBinding.getRoot().getContext()));
            }
        } else if (getItemViewType(bVar.getBindingAdapterPosition()) == 1) {
            if (this.a.get(bVar.getBindingAdapterPosition()).getLocationType() == StopModel.TYPE_CURRENT_LOCATION) {
                MapplsDirectionItemStopBinding mapplsDirectionItemStopBinding7 = bVar.a;
                imageView = mapplsDirectionItemStopBinding7.imgStopType;
                resources = mapplsDirectionItemStopBinding7.getRoot().getContext().getResources();
                i2 = R.drawable.mappls_direction_current_location_icon;
            } else {
                MapplsDirectionItemStopBinding mapplsDirectionItemStopBinding8 = bVar.a;
                imageView = mapplsDirectionItemStopBinding8.imgStopType;
                resources = mapplsDirectionItemStopBinding8.getRoot().getContext().getResources();
                i2 = R.drawable.mappls_direction_end_loc_red;
            }
            imageView.setImageDrawable(resources.getDrawable(i2));
            if (this.a.size() == 2 && !com.mappls.sdk.direction.ui.common.a.a(this.a.get(bVar.getBindingAdapterPosition())) && !com.mappls.sdk.direction.ui.common.a.a(this.a.get(0))) {
                if (this.c.showAddWaypointOption().booleanValue()) {
                    bVar.a.imgClear.setVisibility(0);
                    mapplsDirectionItemStopBinding = bVar.a;
                    imageView2 = mapplsDirectionItemStopBinding.imgClear;
                    i3 = R.styleable.mappls_direction_mappls_directions_add_waypoint;
                    i4 = R.drawable.mappls_direction_add_black_24dp;
                    imageView2.setImageResource(com.mappls.sdk.direction.ui.utils.b.b(i3, i4, mapplsDirectionItemStopBinding.getRoot().getContext()));
                } else {
                    bVar.a.imgClear.setVisibility(4);
                }
            }
        } else if (getItemViewType(bVar.getBindingAdapterPosition()) == 3) {
            MapplsDirectionItemStopBinding mapplsDirectionItemStopBinding9 = bVar.a;
            mapplsDirectionItemStopBinding9.imgStopType.setImageResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_add_waypoint, R.drawable.mappls_direction_add_black_24dp, mapplsDirectionItemStopBinding9.getRoot().getContext()));
        } else if (getItemViewType(bVar.getBindingAdapterPosition()) == 2) {
            if (this.a.get(bVar.getBindingAdapterPosition()).getLocationType() == StopModel.TYPE_CURRENT_LOCATION) {
                MapplsDirectionItemStopBinding mapplsDirectionItemStopBinding10 = bVar.a;
                mapplsDirectionItemStopBinding10.imgStopType.setImageDrawable(mapplsDirectionItemStopBinding10.getRoot().getContext().getResources().getDrawable(R.drawable.mappls_direction_current_location_icon));
            } else if (this.a.get(bVar.getBindingAdapterPosition()).getLocationType() == StopModel.TYPE_STOP) {
                MapplsDirectionItemStopBinding mapplsDirectionItemStopBinding11 = bVar.a;
                ImageView imageView4 = mapplsDirectionItemStopBinding11.imgStopType;
                Context context = mapplsDirectionItemStopBinding11.getRoot().getContext();
                if (i == 1) {
                    resourceId = context.getTheme().obtainStyledAttributes(R.styleable.mappls_direction).getResourceId(R.styleable.mappls_direction_mappls_directions_stop_via_point_1, R.drawable.mappls_direction_via_point_1);
                } else if (i == 2) {
                    resourceId = context.getTheme().obtainStyledAttributes(R.styleable.mappls_direction).getResourceId(R.styleable.mappls_direction_mappls_directions_stop_via_point_2, R.drawable.mappls_direction_via_point_2);
                } else {
                    resourceId = context.getTheme().obtainStyledAttributes(R.styleable.mappls_direction).getResourceId(R.styleable.mappls_direction_mappls_directions_stop_via_point_3, R.drawable.mappls_direction_via_point_3);
                }
                imageView4.setImageResource(resourceId);
            } else if (com.mappls.sdk.direction.ui.common.a.a(this.a.get(i))) {
                MapplsDirectionItemStopBinding mapplsDirectionItemStopBinding12 = bVar.a;
                mapplsDirectionItemStopBinding12.imgStopType.setImageResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_add_waypoint, R.drawable.mappls_direction_add_black_24dp, mapplsDirectionItemStopBinding12.getRoot().getContext()));
            }
        }
        bVar.a.imgClear.setOnClickListener(new h(this, bVar));
        bVar.a.textViewAddStop.setOnClickListener(new i(this, bVar));
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public final boolean onCheckCanDrop(int i, int i2) {
        return true;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public final boolean onCheckCanStartDrag(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3) {
        return this.a.size() >= 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b((MapplsDirectionItemStopBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.mappls_direction_item_stop, viewGroup, false));
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public final /* bridge */ /* synthetic */ ItemDraggableRange onGetItemDraggableRange(RecyclerView.ViewHolder viewHolder, int i) {
        return null;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public final void onItemDragFinished(int i, int i2, boolean z) {
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public final void onItemDragStarted(int i) {
        notifyDataSetChanged();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public final void onMoveItem(int i, int i2) {
        if (i < i2) {
            while (i < i2) {
                int i3 = i + 1;
                Collections.swap(this.a, i, i3);
                i = i3;
            }
        } else {
            while (i > i2) {
                Collections.swap(this.a, i, i - 1);
                i--;
            }
        }
        notifyDataSetChanged();
    }
}
