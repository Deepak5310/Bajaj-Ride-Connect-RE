package com.bajajconnect.wifi.views;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.TouchPoint;
import com.bajajconnect.wifi.UdpServerService;
import com.bajajconnect.wifi.adapter.SearchResultAdapter;
import com.bajajconnect.wifi.model.SearchResultModel;
import com.bajajconnect.wifi.model.SearchResultsTFTModel;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.placedetail.MapplsPlaceDetail;
import com.mappls.sdk.services.api.placedetail.MapplsPlaceDetailManager;
import com.mappls.sdk.services.api.placedetail.model.PlaceDetailResponse;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class TftSearchListView {
    public static ArrayList<SearchResultsTFTModel> searchResultsTFTModelArrayList = new ArrayList<>();
    private View childView;
    final Context context;
    private final Handler handler;
    private ListView listView;
    private SearchResultAdapter searchResultAdapter;
    View v;
    private final View view;
    private boolean searchListFlag = false;
    private int currentListViewTopItem = 0;
    private int listOff = 0;
    private int totalListViewShownCount = 3;
    private boolean isLastScrollDown = false;
    private int listOffset = 0;
    private final ArrayList<TouchPoint> movePoints = new ArrayList<>();
    private boolean isMoving = false;

    public TftSearchListView(Context context) {
        this.context = context;
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.tft_search_list_item, (ViewGroup) null);
        this.view = viewInflate;
        viewInflate.measure(View.MeasureSpec.getSize(viewInflate.getMeasuredWidth()), View.MeasureSpec.getSize(viewInflate.getMeasuredHeight()));
        viewInflate.layout(0, 105, 800, 188);
        initVariables();
        this.handler = new Handler(Looper.getMainLooper());
    }

    private void initVariables() {
        this.listView = (ListView) this.view.findViewById(R.id.search_list);
    }

    public void setData(ArrayList<SearchResultModel> arrayList) {
        SearchResultAdapter searchResultAdapter = new SearchResultAdapter(this.context, arrayList);
        this.searchResultAdapter = searchResultAdapter;
        this.listView.setAdapter((ListAdapter) searchResultAdapter);
        this.listView.postInvalidate();
        View view = this.view;
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.view.getHeight(), 1073741824));
        View view2 = this.view;
        view2.layout(0, 0, view2.getMeasuredWidth(), this.view.getMeasuredHeight());
        setListneronListView();
        this.searchListFlag = true;
        NavApplication.customProjection.stopPresentation();
    }

    public synchronized Canvas drawList(Canvas canvas) {
        if (this.searchListFlag) {
            searchResultsTFTModelArrayList.clear();
        }
        this.listView.draw(canvas);
        if (this.childView != null) {
            canvas.translate(0.0f, (this.listOff * 97) + 4);
            this.childView.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.translate(0.0f, 188.0f);
            this.listView.onDrawForeground(canvas);
        }
        this.searchListFlag = false;
        return canvas;
    }

    public View getView() {
        return this.view;
    }

    public synchronized void injectTouchEvents(TouchPoint touchPoint, TftTurnByTurnScreen.TouchEventType touchEventType) {
        try {
            if (touchEventType != TftTurnByTurnScreen.TouchEventType.DOWN && touchEventType != TftTurnByTurnScreen.TouchEventType.MOVE) {
                this.movePoints.clear();
                if (this.isMoving) {
                    Log.e("TftSearchlist", "touch clear list ");
                    this.isMoving = false;
                    this.movePoints.clear();
                    return;
                }
                try {
                    int i = touchPoint.x;
                    int i2 = touchPoint.y;
                    final ELocation eLocation = new ELocation();
                    this.listOff = 0;
                    int i3 = this.currentListViewTopItem;
                    if (i2 <= 188 || i2 >= 283) {
                        if (i2 > 283 && i2 < 378) {
                            i3++;
                            this.listOff = 1;
                        } else if (i2 > 378) {
                            i3 += 2;
                            this.listOff = 2;
                        }
                    }
                    eLocation.mapplsPin = this.searchResultAdapter.getItem(i3).getMapplsPin();
                    eLocation.placeName = this.searchResultAdapter.getItem(i3).getPlaceName();
                    eLocation.placeAddress = this.searchResultAdapter.getItem(i3).getAddress();
                    if (this.totalListViewShownCount == 4) {
                        i3 = this.isLastScrollDown ? i3 + 1 : i3 - 1;
                        eLocation.mapplsPin = this.searchResultAdapter.getItem(i3).getMapplsPin();
                        eLocation.placeName = this.searchResultAdapter.getItem(i3).getPlaceName();
                        eLocation.placeAddress = this.searchResultAdapter.getItem(i3).getAddress();
                    }
                    if (eLocation.placeName == null) {
                        return;
                    }
                    try {
                        View view = this.listView.getAdapter().getView(i3, null, this.listView);
                        this.childView = view;
                        view.measure(View.MeasureSpec.makeMeasureSpec(this.listView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                        View view2 = this.childView;
                        view2.layout(0, 0, view2.getMeasuredWidth(), this.childView.getMeasuredHeight());
                        ((LinearLayout) this.childView.findViewById(R.id.select_ll)).setBackground(this.context.getDrawable(R.drawable.search_list_selected_background));
                        this.childView.setDrawingCacheEnabled(true);
                        this.childView.buildDrawingCache();
                        this.childView.getDrawingCache();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (GlobalVar.isGoogleNavigation) {
                        new Thread(new AnonymousClass1(MapplsPlaceDetail.builder().mapplsPin(eLocation.mapplsPin).build(), eLocation)).run();
                    } else {
                        UdpServerService.executors.schedule(new Runnable() { // from class: com.bajajconnect.wifi.views.TftSearchListView.2
                            @Override // java.lang.Runnable
                            public void run() {
                                MirroringGlobarVar.isSearchProcessing = true;
                                TftSearchListView.this.startProcessingTimeOut();
                                TftSearchListView.this.childView = null;
                                NavApplication.streamingHandler.udpServerService.onScreenChange();
                                NavApplication.eLocation = eLocation;
                                NavApplication.streamingHandler.udpServerService.mapplsMap = null;
                                Log.e("ListView", "start nav");
                                NavApplication.customProjection.startActivityRoute(NavApplication.activity);
                                NavApplication.streamingHandler.udpServerService.stopScreenCapture();
                            }
                        }, 500L, TimeUnit.MILLISECONDS);
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (this.listView.getAdapter().getCount() <= 3) {
                return;
            }
            this.movePoints.add(touchPoint);
            if (this.movePoints.size() > 1) {
                this.isMoving = true;
                ArrayList<TouchPoint> arrayList = this.movePoints;
                int i4 = arrayList.get(arrayList.size() - 1).y - this.movePoints.get(0).y;
                this.movePoints.clear();
                this.childView = null;
                if (i4 > 0) {
                    this.listOffset = Math.max(0, this.listOffset - 1);
                    scrollListView(-97);
                    this.isLastScrollDown = false;
                } else {
                    this.listOffset = Math.min(this.listOffset + 1, this.listView.getAdapter().getCount() - 3);
                    scrollListView(97);
                    this.isLastScrollDown = true;
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.bajajconnect.wifi.views.TftSearchListView$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ELocation val$eLocation;
        final /* synthetic */ MapplsPlaceDetail val$placeDetail;

        AnonymousClass1(MapplsPlaceDetail mapplsPlaceDetail, ELocation eLocation) {
            this.val$placeDetail = mapplsPlaceDetail;
            this.val$eLocation = eLocation;
        }

        @Override // java.lang.Runnable
        public void run() {
            MapplsPlaceDetailManager.newInstance(this.val$placeDetail).call(new OnResponseCallback<PlaceDetailResponse>() { // from class: com.bajajconnect.wifi.views.TftSearchListView.1.1
                @Override // com.mappls.sdk.services.api.OnResponseCallback
                public void onSuccess(PlaceDetailResponse placeDetailResponse) {
                    GlobalVar.lat = placeDetailResponse.getLatitude();
                    GlobalVar.lng = placeDetailResponse.getLongitude();
                    UdpServerService.executors.schedule(new Runnable() { // from class: com.bajajconnect.wifi.views.TftSearchListView.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TftSearchListView.this.startProcessingTimeOut();
                            TftSearchListView.this.childView = null;
                            MirroringGlobarVar.isSearchProcessing = true;
                            NavApplication.streamingHandler.udpServerService.onScreenChange();
                            NavApplication.eLocation = AnonymousClass1.this.val$eLocation;
                            NavApplication.streamingHandler.udpServerService.mapplsMap = null;
                            Log.e("ListView", "start nav");
                            NavApplication.customProjection.startActivityRoute(NavApplication.activity);
                            NavApplication.streamingHandler.udpServerService.stopScreenCapture();
                        }
                    }, 500L, TimeUnit.MILLISECONDS);
                }

                @Override // com.mappls.sdk.services.api.OnResponseCallback
                public void onError(int i, String str) {
                    MirroringGlobarVar.isSearchProcessing = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startProcessingTimeOut() {
        UdpServerService.executors.schedule(new Runnable() { // from class: com.bajajconnect.wifi.views.TftSearchListView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MirroringGlobarVar.isSearchProcessing = false;
            }
        }, 10000L, TimeUnit.MILLISECONDS);
    }

    private void setListneronListView() {
        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.bajajconnect.wifi.views.TftSearchListView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                TftSearchListView.this.currentListViewTopItem = i;
                TftSearchListView.this.totalListViewShownCount = i2;
            }
        });
    }

    private void scrollListView(int i) {
        this.listView.scrollListBy(i);
    }
}
