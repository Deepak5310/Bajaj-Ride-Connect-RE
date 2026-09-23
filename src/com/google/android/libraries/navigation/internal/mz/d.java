package com.google.android.libraries.navigation.internal.mz;

import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bajajconnect.rideapp.R;
import com.google.android.libraries.navigation.internal.ms.ax;
import com.google.android.libraries.navigation.internal.ms.bs;
import com.google.android.libraries.navigation.internal.ms.bu;
import com.google.android.libraries.navigation.internal.ms.cf;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cr;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.nc.x;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends com.google.android.libraries.navigation.internal.ms.a {
    private final ax a;
    private final l b = new l();

    public d(ax axVar) {
        this.a = axVar;
    }

    public static void c(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
        m.a(recyclerView).b(adapter);
    }

    private static void d(List list, n nVar) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            nVar.a.f((bu) it2.next());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ms.a, com.google.android.libraries.navigation.internal.ms.cx
    public final boolean a(cw cwVar, Object obj, ck ckVar) {
        boolean z = cwVar instanceof b;
        View view = ckVar.c;
        n nVar = null;
        if (!z) {
            if (!(cwVar instanceof com.google.android.libraries.navigation.internal.ms.e)) {
                return false;
            }
            int iOrdinal = ((com.google.android.libraries.navigation.internal.ms.e) cwVar).ordinal();
            if (iOrdinal == 31) {
                if (!(view instanceof RecyclerView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((RecyclerView) view).setClipToPadding(((Boolean) obj).booleanValue());
                return true;
            }
            if (iOrdinal == 97) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (!(layoutParams instanceof Toolbar.LayoutParams) || !(obj instanceof Integer)) {
                    return false;
                }
                ((Toolbar.LayoutParams) layoutParams).gravity = ((Integer) obj).intValue();
                view.setLayoutParams(layoutParams);
                return true;
            }
            if (iOrdinal != 114) {
                if ((iOrdinal == 176 || iOrdinal == 170 || iOrdinal == 171 || iOrdinal == 173 || iOrdinal == 174) && cf.a && (view instanceof CardView)) {
                    throw new IllegalArgumentException("Cannot apply padding to a CardView. Use contentPadding instead. See https://developer.android.com/reference/android/support/v7/widget/CardView.html");
                }
                return false;
            }
            if (!(view instanceof RecyclerView)) {
                return false;
            }
            RecyclerView recyclerView = (RecyclerView) view;
            if (obj instanceof RecyclerView.Adapter) {
                c(recyclerView, (RecyclerView.Adapter) obj);
                if (obj instanceof n) {
                    nVar = (n) obj;
                }
            } else {
                if (!(obj instanceof bs)) {
                    return false;
                }
                cr crVarL = this.a.l();
                bs bsVar = (bs) obj;
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (adapter instanceof n) {
                    nVar = (n) adapter;
                    boolean z2 = bsVar.a;
                    nVar.c();
                    d(bsVar.b, nVar);
                    nVar.notifyDataSetChanged();
                } else {
                    List list = bsVar.b;
                    nVar = new n(crVarL);
                    d(list, nVar);
                    c(recyclerView, nVar);
                }
            }
            if (nVar == null) {
                return true;
            }
            recyclerView.setRecycledViewPool(new i(this.a.l(), nVar));
            return true;
        }
        switch ((b) cwVar) {
            case AUTO_SIZE_CONFIG:
                if (!(view instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nb.b) {
                    throw null;
                }
                if (!(obj instanceof com.google.android.libraries.navigation.internal.nb.a)) {
                    return false;
                }
                throw null;
            case BACKGROUND_TINT_LIST:
                ViewCompat.setBackgroundTintList(view, com.google.android.libraries.navigation.internal.ms.m.b(obj, view));
                return true;
            case BUTTON_TINT_LIST:
                if (!(view instanceof CompoundButton)) {
                    return false;
                }
                CompoundButtonCompat.setButtonTintList((CompoundButton) view, com.google.android.libraries.navigation.internal.ms.m.b(obj, view));
                return true;
            case CARD_BACKGROUND_COLOR:
                if (!(view instanceof CardView)) {
                    return false;
                }
                CardView cardView = (CardView) view;
                if (obj == null) {
                    cardView.setCardBackgroundColor(0);
                    return true;
                }
                if (obj instanceof x) {
                    cardView.setCardBackgroundColor(((x) obj).c(view.getContext()));
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                cardView.setCardBackgroundColor(((Integer) obj).intValue());
                return true;
            case CARD_CORNER_RADIUS:
                if (!(obj instanceof ap) || !(view instanceof CardView)) {
                    return false;
                }
                ((CardView) view).setRadius(((ap) obj).a(view.getContext()));
                return true;
            case CARD_ELEVATION:
                if (!(obj instanceof ap) || !(view instanceof CardView)) {
                    return false;
                }
                ((CardView) view).setCardElevation(((ap) obj).a(view.getContext()));
                return true;
            case CONTENT_PADDING:
                if (!(view instanceof CardView)) {
                    return false;
                }
                int iA = com.google.android.libraries.navigation.internal.ms.m.a(obj, view);
                ((CardView) view).setContentPadding(iA, iA, iA, iA);
                return true;
            case CONTENT_PADDING_BOTTOM:
                if (!(view instanceof CardView)) {
                    return false;
                }
                int iA2 = com.google.android.libraries.navigation.internal.ms.m.a(obj, view);
                CardView cardView2 = (CardView) view;
                cardView2.setContentPadding(cardView2.getContentPaddingLeft(), cardView2.getContentPaddingTop(), cardView2.getContentPaddingRight(), iA2);
                return true;
            case CONTENT_PADDING_LEFT:
                if (!(view instanceof CardView)) {
                    return false;
                }
                int iA3 = com.google.android.libraries.navigation.internal.ms.m.a(obj, view);
                CardView cardView3 = (CardView) view;
                cardView3.setContentPadding(iA3, cardView3.getContentPaddingTop(), cardView3.getContentPaddingRight(), cardView3.getContentPaddingBottom());
                return true;
            case CONTENT_PADDING_RIGHT:
                if (!(view instanceof CardView)) {
                    return false;
                }
                int iA4 = com.google.android.libraries.navigation.internal.ms.m.a(obj, view);
                CardView cardView4 = (CardView) view;
                cardView4.setContentPadding(cardView4.getContentPaddingLeft(), cardView4.getContentPaddingTop(), iA4, cardView4.getContentPaddingBottom());
                return true;
            case CONTENT_PADDING_TOP:
                if (!(view instanceof CardView)) {
                    return false;
                }
                int iA5 = com.google.android.libraries.navigation.internal.ms.m.a(obj, view);
                CardView cardView5 = (CardView) view;
                cardView5.setContentPadding(cardView5.getContentPaddingLeft(), iA5, cardView5.getContentPaddingRight(), cardView5.getContentPaddingBottom());
                return true;
            case HAS_FIXED_SIZE:
                if (!(obj instanceof Boolean) || !(view instanceof RecyclerView)) {
                    return false;
                }
                ((RecyclerView) view).setHasFixedSize(((Boolean) obj).booleanValue());
                return true;
            case ITEM_ANIMATOR:
                if (!(view instanceof RecyclerView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof RecyclerView.ItemAnimator)) {
                    return false;
                }
                ((RecyclerView) view).setItemAnimator((RecyclerView.ItemAnimator) obj);
                return true;
            case ITEM_DECORATION:
                if (!(view instanceof RecyclerView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof RecyclerView.ItemDecoration)) {
                    return false;
                }
                RecyclerView.ItemDecoration itemDecoration = (RecyclerView.ItemDecoration) view.getTag(R.id.automatic);
                RecyclerView.ItemDecoration itemDecoration2 = (RecyclerView.ItemDecoration) obj;
                if (itemDecoration != null) {
                    ((RecyclerView) view).removeItemDecoration(itemDecoration);
                }
                if (itemDecoration2 != null) {
                    ((RecyclerView) view).addItemDecoration(itemDecoration2);
                }
                view.setTag(R.id.automatic, itemDecoration2);
                return true;
            case ITEM_TOUCH_HELPER:
                if (!(view instanceof RecyclerView) || !(obj instanceof ItemTouchHelper)) {
                    return false;
                }
                ((ItemTouchHelper) obj).attachToRecyclerView((RecyclerView) view);
                return true;
            case LAYOUT_MANAGER:
                if (!(obj instanceof h) || !(view instanceof RecyclerView)) {
                    return false;
                }
                Integer num = (Integer) view.getTag(R.id.ba);
                Object objValueOf = Integer.valueOf(obj.hashCode());
                if (Objects.equals(objValueOf, num)) {
                    return true;
                }
                view.setTag(R.id.ba, objValueOf);
                ((RecyclerView) view).setLayoutManager(((h) obj).a(view.getContext()));
                return true;
            case MAX_CARD_ELEVATION:
                if (!(obj instanceof ap) || !(view instanceof CardView)) {
                    return false;
                }
                ((CardView) view).setMaxCardElevation(((ap) obj).a(view.getContext()));
                return true;
            case ON_ITEM_TOUCH_LISTENER:
                if (!(view instanceof RecyclerView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof RecyclerView.OnItemTouchListener)) {
                    return false;
                }
                m mVarA = m.a((RecyclerView) view);
                RecyclerView.OnItemTouchListener onItemTouchListener = (RecyclerView.OnItemTouchListener) obj;
                RecyclerView.OnItemTouchListener onItemTouchListener2 = mVarA.b;
                if (onItemTouchListener2 != null) {
                    mVarA.a.removeOnItemTouchListener(onItemTouchListener2);
                }
                if (onItemTouchListener != null) {
                    mVarA.a.addOnItemTouchListener(onItemTouchListener);
                }
                mVarA.b = onItemTouchListener;
                return true;
            case ON_SCROLL_LISTENER:
                if (!(view instanceof RecyclerView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof RecyclerView.OnScrollListener)) {
                    return false;
                }
                ((RecyclerView) view).setOnScrollListener((RecyclerView.OnScrollListener) obj);
                return true;
            case ON_VIEW_ATTACHED_TO_WINDOW:
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof m)) {
                    return false;
                }
                if (!(view instanceof RecyclerView)) {
                    return false;
                }
                m.a((RecyclerView) view).c = (m) obj;
                return true;
            case ON_VIEW_DETACHED_FROM_WINDOW:
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof m)) {
                    return false;
                }
                if (!(view instanceof RecyclerView)) {
                    return false;
                }
                m.a((RecyclerView) view).d = (m) obj;
                return true;
            case ORIENTATION:
                if (!(obj instanceof Integer) || !(view instanceof RecyclerView)) {
                    return false;
                }
                RecyclerView.LayoutManager layoutManager = ((RecyclerView) view).getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    return false;
                }
                ((LinearLayoutManager) layoutManager).setOrientation(((Integer) obj).intValue());
                return true;
            case PREVENT_CORNER_OVERLAP:
                if (!(obj instanceof Boolean) || !(view instanceof CardView)) {
                    return false;
                }
                ((CardView) view).setPreventCornerOverlap(((Boolean) obj).booleanValue());
                return true;
            case RECYCLER_LISTENER:
                if (!(view instanceof RecyclerView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof RecyclerView.RecyclerListener)) {
                    return false;
                }
                ((RecyclerView) view).setRecyclerListener((RecyclerView.RecyclerListener) obj);
                return true;
            case RECYCLER_VIEW_SCROLL_POSITION:
                if (!(view instanceof RecyclerView)) {
                    return false;
                }
                if (obj == null) {
                    return true;
                }
                if (!(obj instanceof com.google.android.libraries.navigation.internal.na.a)) {
                    return false;
                }
                RecyclerView recyclerView2 = (RecyclerView) view;
                com.google.android.libraries.navigation.internal.na.a aVar = (com.google.android.libraries.navigation.internal.na.a) obj;
                if (!(recyclerView2.getLayoutManager() instanceof LinearLayoutManager)) {
                    throw new IllegalArgumentException("Invalid LayoutManager type. Expected LinearLayoutManager, found ".concat(String.valueOf(String.valueOf(recyclerView2.getLayoutManager()))));
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView2.getLayoutManager();
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int iA6 = aVar.a();
                if (iFindFirstVisibleItemPosition == iA6) {
                    return true;
                }
                if (Math.abs(iFindFirstVisibleItemPosition - iA6) > aVar.b()) {
                    linearLayoutManager.scrollToPosition(((-Integer.signum(iA6 - iFindFirstVisibleItemPosition)) * aVar.b()) + iA6);
                }
                c cVar = new c(recyclerView2.getContext());
                cVar.setTargetPosition(iA6);
                recyclerView2.getLayoutManager().startSmoothScroll(cVar);
                return true;
            case SNAP_HELPER:
                if (!(obj instanceof k) || !(view instanceof RecyclerView)) {
                    return false;
                }
                RecyclerView recyclerView3 = (RecyclerView) view;
                view.getContext();
                SnapHelper snapHelperA = ((k) obj).a();
                Object tag = recyclerView3.getTag(R.id.badge_text_view);
                SnapHelper snapHelper = tag instanceof SnapHelper ? (SnapHelper) tag : null;
                if (snapHelper != null) {
                    snapHelper.attachToRecyclerView(null);
                }
                if (snapHelperA != null) {
                    snapHelperA.attachToRecyclerView(recyclerView3);
                }
                recyclerView3.setTag(R.id.badge_text_view, snapHelperA);
                return true;
            case SPAN_COUNT:
                if (!(view instanceof RecyclerView)) {
                    return false;
                }
                RecyclerView.LayoutManager layoutManager2 = ((RecyclerView) view).getLayoutManager();
                if (!(layoutManager2 instanceof GridLayoutManager)) {
                    return false;
                }
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager2;
                if (!(obj instanceof Integer)) {
                    return false;
                }
                Integer num2 = (Integer) obj;
                if (num2.intValue() <= 0) {
                    num2 = 1;
                }
                gridLayoutManager.setSpanCount(num2.intValue());
                return true;
            case SPAN_SIZE_LOOKUP:
                if (!(view instanceof RecyclerView)) {
                    return false;
                }
                RecyclerView.LayoutManager layoutManager3 = ((RecyclerView) view).getLayoutManager();
                if (!(layoutManager3 instanceof GridLayoutManager)) {
                    return false;
                }
                GridLayoutManager gridLayoutManager2 = (GridLayoutManager) layoutManager3;
                if (!(obj instanceof GridLayoutManager.SpanSizeLookup)) {
                    return false;
                }
                gridLayoutManager2.setSpanSizeLookup((GridLayoutManager.SpanSizeLookup) obj);
                return true;
            case THUMB_DRAWABLE:
                if (!(view instanceof SwitchCompat)) {
                    return false;
                }
                SwitchCompat switchCompat = (SwitchCompat) view;
                if (obj == null) {
                    switchCompat.setThumbDrawable(null);
                    return true;
                }
                if (!(obj instanceof ah)) {
                    return false;
                }
                switchCompat.setThumbDrawable(((ah) obj).a(switchCompat.getContext()));
                return true;
            case THUMB_TINT_LIST:
                if (!(view instanceof SwitchCompat)) {
                    return false;
                }
                ((SwitchCompat) view).setThumbTintList(obj != null ? com.google.android.libraries.navigation.internal.ms.m.b(obj, view) : null);
                return true;
            case THUMB_TINT_MODE:
                if (!(view instanceof SwitchCompat)) {
                    return false;
                }
                SwitchCompat switchCompat2 = (SwitchCompat) view;
                if (obj == null) {
                    switchCompat2.setThumbTintMode(null);
                    return true;
                }
                if (!(obj instanceof PorterDuff.Mode)) {
                    return false;
                }
                switchCompat2.setThumbTintMode((PorterDuff.Mode) obj);
                return true;
            case TRACK_TINT_LIST:
                if (!(view instanceof SwitchCompat)) {
                    return false;
                }
                ((SwitchCompat) view).setTrackTintList(obj != null ? com.google.android.libraries.navigation.internal.ms.m.b(obj, view) : null);
                return true;
            case TRACK_TINT_MODE:
                if (!(view instanceof SwitchCompat)) {
                    return false;
                }
                SwitchCompat switchCompat3 = (SwitchCompat) view;
                if (obj == null) {
                    switchCompat3.setTrackTintMode(null);
                    return true;
                }
                if (!(obj instanceof PorterDuff.Mode)) {
                    return false;
                }
                switchCompat3.setTrackTintMode((PorterDuff.Mode) obj);
                return true;
            case USE_COMPAT_PADDING:
                if (!(obj instanceof Boolean) || !(view instanceof CardView)) {
                    return false;
                }
                ((CardView) view).setUseCompatPadding(((Boolean) obj).booleanValue());
                return true;
            case SET_FULL_SPAN:
                if (!(obj instanceof Boolean) || !(view.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams)) {
                    return false;
                }
                ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).setFullSpan(((Boolean) obj).booleanValue());
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ms.a, com.google.android.libraries.navigation.internal.ms.cx
    public final boolean b(cw cwVar, ck ckVar) {
        boolean z = cwVar instanceof com.google.android.libraries.navigation.internal.ms.e;
        View view = ckVar.c;
        if (z) {
            if (((com.google.android.libraries.navigation.internal.ms.e) cwVar).ordinal() != 114 || !(view instanceof RecyclerView)) {
                return false;
            }
            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (!(adapter instanceof n)) {
                return false;
            }
            recyclerView.setAdapter(null);
            ((n) adapter).c();
            return true;
        }
        if (!(cwVar instanceof b) || !(view instanceof RecyclerView)) {
            return false;
        }
        int iOrdinal = ((b) cwVar).ordinal();
        if (iOrdinal == 12) {
            RecyclerView recyclerView2 = (RecyclerView) view;
            if (recyclerView2.getItemAnimator() == null) {
                return false;
            }
            recyclerView2.setItemAnimator(null);
            return true;
        }
        if (iOrdinal == 13) {
            RecyclerView recyclerView3 = (RecyclerView) view;
            RecyclerView.ItemDecoration itemDecoration = (RecyclerView.ItemDecoration) recyclerView3.getTag(R.id.automatic);
            if (itemDecoration == null) {
                return false;
            }
            recyclerView3.removeItemDecoration(itemDecoration);
            recyclerView3.setTag(R.id.automatic, null);
            return true;
        }
        if (iOrdinal != 15) {
            if (iOrdinal != 18) {
                return false;
            }
            ((RecyclerView) view).setOnScrollListener(null);
            return true;
        }
        RecyclerView recyclerView4 = (RecyclerView) view;
        if (recyclerView4.getLayoutManager() == null) {
            return false;
        }
        recyclerView4.setLayoutManager(null);
        recyclerView4.setTag(R.id.ba, null);
        return true;
    }
}
