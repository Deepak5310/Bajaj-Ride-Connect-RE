package com.bajajconnect.wifi.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ImageViewCompat;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.StreamingImageHandler;
import com.bajajconnect.wifi.TouchPoint;
import com.bajajconnect.wifi.model.FourDimensionalTouchPoint;
import com.bajajconnect.wifi.model.SearchResultModel;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest;
import com.mappls.sdk.services.api.autosuggest.MapplsAutosuggestManager;
import com.mappls.sdk.services.api.autosuggest.model.AutoSuggestAtlasResponse;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationSearchScreen {
    public static boolean isKeyboardOpen = false;
    Bitmap bitmap;
    public TextView btnFavroite;
    public TextView btnHome;
    public TextView btnWork;
    Canvas canvas;
    final Context context;
    public CustomKeyboard customKeyboard;
    public TextView dayNightTextView;
    public Handler handler;
    public TftProgressView progressView;
    public View searchBottomLine;
    public ImageView searchIcon;
    public ConstraintLayout searchLayout;
    public TftRouteInfoScreen tftRouteInfoScreen;
    public TftSearchBar tftSearchBar;
    public TftSearchListView tftSearchListView;
    public TftTurnByTurnScreen tftTurnByTurnScreen;
    private final View view;
    public static ArrayList<SearchResultModel> arrayList = new ArrayList<>();
    public static boolean searchResultAvailable = false;
    FourDimensionalTouchPoint nDirectButtonsCordinates = new FourDimensionalTouchPoint(300, 770, 400, 460);
    public CustomKeyboard.KeyPressCallback keyPressCallback = new CustomKeyboard.KeyPressCallback() { // from class: com.bajajconnect.wifi.views.NavigationSearchScreen.1
        @Override // com.bajajconnect.wifi.views.CustomKeyboard.KeyPressCallback
        public void onkeyPress(String str) {
            NavigationSearchScreen.this.tftSearchBar.addText(str);
        }

        @Override // com.bajajconnect.wifi.views.CustomKeyboard.KeyPressCallback
        public void onEnter() {
            NavigationSearchScreen.isKeyboardOpen = false;
            NavigationSearchScreen navigationSearchScreen = NavigationSearchScreen.this;
            navigationSearchScreen.performSearch(navigationSearchScreen.tftSearchBar.searchInput);
        }

        @Override // com.bajajconnect.wifi.views.CustomKeyboard.KeyPressCallback
        public void onSpace() {
            NavigationSearchScreen.this.tftSearchBar.addText(StringUtils.SPACE);
        }

        @Override // com.bajajconnect.wifi.views.CustomKeyboard.KeyPressCallback
        public void onKeyboardStatusChange(boolean z) {
            NavigationSearchScreen.isKeyboardOpen = z;
        }
    };
    private boolean isTouchDown = false;

    public NavigationSearchScreen(Context context) {
        this.context = context;
        isKeyboardOpen = false;
        searchResultAvailable = false;
        arrayList.clear();
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.navigation_start_screen, (ViewGroup) null);
        this.view = viewInflate;
        viewInflate.measure(View.MeasureSpec.getSize(viewInflate.getMeasuredWidth()), View.MeasureSpec.getSize(viewInflate.getMeasuredHeight()));
        viewInflate.layout(0, 0, 800, StreamingImageHandler.TFT_HEIGHT);
        CustomKeyboard customKeyboard = new CustomKeyboard(context);
        this.customKeyboard = customKeyboard;
        customKeyboard.registerKeyboardCallback(this.keyPressCallback);
        this.tftSearchBar = new TftSearchBar(context);
        this.tftSearchListView = new TftSearchListView(context);
        this.tftRouteInfoScreen = new TftRouteInfoScreen(context);
        this.tftTurnByTurnScreen = new TftTurnByTurnScreen(context);
        this.progressView = new TftProgressView(context);
        this.handler = new Handler(Looper.getMainLooper());
        initVariables();
    }

    private void initVariables() {
        this.dayNightTextView = (TextView) this.view.findViewById(R.id.lbl1);
        this.searchLayout = (ConstraintLayout) this.view.findViewById(R.id.search_layout);
        this.searchIcon = (ImageView) this.view.findViewById(R.id.search_icon);
        this.searchBottomLine = this.view.findViewById(R.id.search_bottom_line);
        this.btnHome = (TextView) this.view.findViewById(R.id.btn_home);
        this.btnWork = (TextView) this.view.findViewById(R.id.btn_work);
        this.btnFavroite = (TextView) this.view.findViewById(R.id.btn_favroite);
    }

    public View getView() {
        return this.view;
    }

    public void injectTouchEvents(TouchPoint touchPoint, TftTurnByTurnScreen.TouchEventType touchEventType) {
        if (!isKeyboardOpen && searchResultAvailable && touchEventType == TftTurnByTurnScreen.TouchEventType.MOVE) {
            if (touchPoint.y > 188) {
                Log.e("SSearchScreen", "touch move ");
                this.tftSearchListView.injectTouchEvents(touchPoint, TftTurnByTurnScreen.TouchEventType.MOVE);
                updateImage();
                return;
            }
            return;
        }
        try {
            if (touchEventType != TftTurnByTurnScreen.TouchEventType.DOWN && touchEventType != TftTurnByTurnScreen.TouchEventType.MOVE) {
                if (touchEventType == TftTurnByTurnScreen.TouchEventType.UP && this.isTouchDown) {
                    this.isTouchDown = false;
                    inject(touchPoint);
                    updateImage();
                    return;
                }
                return;
            }
            this.isTouchDown = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inject(TouchPoint touchPoint) {
        if (!isKeyboardOpen) {
            if (searchResultAvailable) {
                if (touchPoint.y > 105 && touchPoint.y < 188 && touchPoint.x > 720 && touchPoint.x < 797) {
                    this.tftSearchBar.removeOneCharacter();
                    return;
                } else {
                    this.tftSearchListView.injectTouchEvents(touchPoint, null);
                    return;
                }
            }
            if (touchPoint.x > 300 && touchPoint.x < 770 && touchPoint.y > 155 && touchPoint.y < 195) {
                Log.e("NavigationSearchScreen", "search icon selected");
                if (isKeyboardOpen) {
                    isKeyboardOpen = false;
                    return;
                }
                isKeyboardOpen = true;
                this.tftSearchBar.textView.setText("");
                this.tftSearchBar.searchInput = "";
                return;
            }
            if (touchPoint.x <= this.nDirectButtonsCordinates.getX1() || touchPoint.x >= this.nDirectButtonsCordinates.getX2() || touchPoint.y <= this.nDirectButtonsCordinates.getY1() || touchPoint.y >= this.nDirectButtonsCordinates.getY2() || isKeyboardOpen) {
                return;
            }
            this.searchBottomLine.setBackgroundResource(R.color.white);
            ImageViewCompat.setImageTintList(this.searchIcon, ColorStateList.valueOf(this.context.getResources().getColor(R.color.white)));
            int i = touchPoint.x - 300;
            if (i < 150) {
                this.btnHome.setBackgroundResource(R.drawable.tft_btn_rounded_blue);
                this.btnWork.setBackgroundResource(R.drawable.tft_btn_rounded_white);
                this.btnFavroite.setBackgroundResource(R.drawable.tft_btn_rounded_white);
                if (MirroringGlobarVar.homeAddress != null) {
                    ELocation eLocation = new ELocation();
                    eLocation.latitude = MirroringGlobarVar.homeAddress.getLat();
                    eLocation.longitude = MirroringGlobarVar.homeAddress.getLng();
                    eLocation.placeName = MirroringGlobarVar.homeAddress.getAddress();
                    NavApplication.eLocation = eLocation;
                    NavApplication.streamingHandler.udpServerService.mapplsMap = null;
                    GlobalVar.lat = MirroringGlobarVar.homeAddress.getLat();
                    GlobalVar.lng = MirroringGlobarVar.homeAddress.getLng();
                    Log.e("TFTLidt", "start navigation");
                    NavApplication.customProjection.startActivityRoute(NavApplication.activity);
                    return;
                }
                NavApplication.streamingHandler.tcpServerService.senCommandToshowPopup();
                return;
            }
            if (i > 160 && i < 306) {
                this.btnHome.setBackgroundResource(R.drawable.tft_btn_rounded_white);
                this.btnWork.setBackgroundResource(R.drawable.tft_btn_rounded_blue);
                this.btnFavroite.setBackgroundResource(R.drawable.tft_btn_rounded_white);
                if (MirroringGlobarVar.workAddress != null) {
                    ELocation eLocation2 = new ELocation();
                    eLocation2.latitude = MirroringGlobarVar.workAddress.getLat();
                    eLocation2.longitude = MirroringGlobarVar.workAddress.getLng();
                    eLocation2.placeName = MirroringGlobarVar.workAddress.getAddress();
                    NavApplication.eLocation = eLocation2;
                    NavApplication.streamingHandler.udpServerService.mapplsMap = null;
                    Log.e("TFTLidt", "start navigation");
                    GlobalVar.lat = MirroringGlobarVar.workAddress.getLat();
                    GlobalVar.lng = MirroringGlobarVar.workAddress.getLng();
                    NavApplication.customProjection.startActivityRoute(NavApplication.activity);
                    return;
                }
                NavApplication.streamingHandler.tcpServerService.senCommandToshowPopup();
                return;
            }
            this.btnHome.setBackgroundResource(R.drawable.tft_btn_rounded_white);
            this.btnWork.setBackgroundResource(R.drawable.tft_btn_rounded_white);
            this.btnFavroite.setBackgroundResource(R.drawable.tft_btn_rounded_blue);
            if (MirroringGlobarVar.favAddress != null) {
                ELocation eLocation3 = new ELocation();
                eLocation3.latitude = MirroringGlobarVar.favAddress.getLat();
                eLocation3.longitude = MirroringGlobarVar.favAddress.getLng();
                eLocation3.placeName = MirroringGlobarVar.favAddress.getAddress();
                NavApplication.eLocation = eLocation3;
                NavApplication.streamingHandler.udpServerService.mapplsMap = null;
                Log.e("TFTLidt", "start navigation");
                GlobalVar.lat = MirroringGlobarVar.favAddress.getLat();
                GlobalVar.lng = MirroringGlobarVar.favAddress.getLng();
                NavApplication.customProjection.startActivityRoute(NavApplication.activity);
                return;
            }
            NavApplication.streamingHandler.tcpServerService.senCommandToshowPopup();
            return;
        }
        if (touchPoint.y > 188) {
            this.customKeyboard.injectTouchEvents(touchPoint);
        } else {
            if (touchPoint.y <= 105 || touchPoint.y >= 188 || touchPoint.x <= 720 || touchPoint.x >= 800) {
                return;
            }
            this.tftSearchBar.removeOneCharacter();
        }
    }

    public void updateImage() {
        NavApplication.streamingHandler.udpServerService.onSearchScreenUpdated(null);
    }

    public synchronized Bitmap getBitmap() {
        if (this.bitmap == null) {
            this.bitmap = Bitmap.createBitmap(800, StreamingImageHandler.TFT_HEIGHT, Bitmap.Config.ARGB_8888);
            this.canvas = new Canvas(this.bitmap);
        } else {
            this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        if (MirroringGlobarVar.isSearchProcessing) {
            this.canvas.save();
            getView().draw(this.canvas);
            this.canvas.restore();
            this.canvas.save();
            this.canvas.translate(0.0f, 0.0f);
            this.progressView.getView().draw(this.canvas);
            this.canvas.restore();
            return this.bitmap;
        }
        if (isKeyboardOpen) {
            this.canvas.save();
            this.canvas.translate(0.0f, 188.0f);
            this.customKeyboard.getView().draw(this.canvas);
            this.canvas.restore();
            this.canvas.save();
            this.canvas.translate(0.0f, 105.0f);
            this.tftSearchBar.getView(true).draw(this.canvas);
            this.canvas.restore();
        } else if (searchResultAvailable) {
            this.canvas.save();
            this.canvas.translate(0.0f, 188.0f);
            Canvas canvasDrawList = this.tftSearchListView.drawList(this.canvas);
            this.canvas = canvasDrawList;
            canvasDrawList.restore();
            this.canvas.save();
            this.canvas.translate(0.0f, 105.0f);
            this.tftSearchBar.getView(false).draw(this.canvas);
            this.canvas.restore();
        } else {
            this.canvas.save();
            getView().draw(this.canvas);
            this.canvas.restore();
        }
        return this.bitmap;
    }

    public void performSearch(final String str) {
        if (!GlobalVar.isGoogleNavigation) {
            performSearchMMI(str);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.views.NavigationSearchScreen$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSearch$0();
                }
            }, 10000L);
            new Thread(new Runnable() { // from class: com.bajajconnect.wifi.views.NavigationSearchScreen$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSearch$1(str);
                }
            }).run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSearch$0() {
        MirroringGlobarVar.isSearchProcessing = false;
        updateImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSearch$1(String str) {
        MapplsAutoSuggest mapplsAutoSuggestBuild;
        MirroringGlobarVar.isSearchProcessing = true;
        updateImage();
        if (MirroringGlobarVar.currentLng != null) {
            Log.e("NavigationSearch", "setCurrent locations");
            mapplsAutoSuggestBuild = MapplsAutoSuggest.builder().query(str).bridge(true).setLocation(MirroringGlobarVar.currentLat, MirroringGlobarVar.currentLng).build();
        } else {
            mapplsAutoSuggestBuild = MapplsAutoSuggest.builder().query(str).build();
        }
        MapplsAutosuggestManager.newInstance(mapplsAutoSuggestBuild).call(new OnResponseCallback<AutoSuggestAtlasResponse>() { // from class: com.bajajconnect.wifi.views.NavigationSearchScreen.2
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(AutoSuggestAtlasResponse autoSuggestAtlasResponse) {
                ArrayList<ELocation> suggestedLocations = autoSuggestAtlasResponse.getSuggestedLocations();
                NavigationSearchScreen.arrayList.clear();
                for (ELocation eLocation : suggestedLocations) {
                    NavigationSearchScreen.arrayList.add(new SearchResultModel(eLocation.placeAddress, eLocation.placeName, eLocation.mapplsPin, null));
                }
                NavigationSearchScreen.this.tftSearchListView.setData(NavigationSearchScreen.arrayList);
                NavigationSearchScreen.searchResultAvailable = true;
                MirroringGlobarVar.isSearchProcessing = false;
                NavigationSearchScreen.this.updateImage();
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str2) {
                Log.e("NAVSearch", "on error");
                MirroringGlobarVar.isSearchProcessing = false;
                NavigationSearchScreen.this.updateImage();
            }
        });
    }

    public void performSearchMMI(final String str) {
        this.handler.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.views.NavigationSearchScreen$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSearchMMI$2();
            }
        }, 10000L);
        new Thread(new Runnable() { // from class: com.bajajconnect.wifi.views.NavigationSearchScreen$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSearchMMI$3(str);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSearchMMI$2() {
        MirroringGlobarVar.isSearchProcessing = false;
        updateImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSearchMMI$3(String str) {
        MapplsAutoSuggest mapplsAutoSuggestBuild;
        MirroringGlobarVar.isSearchProcessing = true;
        updateImage();
        if (MirroringGlobarVar.currentLng != null) {
            Log.e("NavigationSearch", "lat lng " + MirroringGlobarVar.currentLat + StringUtils.SPACE + MirroringGlobarVar.currentLng);
            mapplsAutoSuggestBuild = MapplsAutoSuggest.builder().query(str).bridge(true).setLocation(MirroringGlobarVar.currentLat, MirroringGlobarVar.currentLng).build();
        } else {
            Log.e("NavigationSearch", "current location nulll");
            mapplsAutoSuggestBuild = MapplsAutoSuggest.builder().query(str).build();
        }
        MapplsAutosuggestManager.newInstance(mapplsAutoSuggestBuild).call(new OnResponseCallback<AutoSuggestAtlasResponse>() { // from class: com.bajajconnect.wifi.views.NavigationSearchScreen.3
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(AutoSuggestAtlasResponse autoSuggestAtlasResponse) {
                ArrayList<ELocation> suggestedLocations = autoSuggestAtlasResponse.getSuggestedLocations();
                NavigationSearchScreen.arrayList.clear();
                for (ELocation eLocation : suggestedLocations) {
                    NavigationSearchScreen.arrayList.add(new SearchResultModel(eLocation.placeAddress, eLocation.placeName, eLocation.mapplsPin, null));
                }
                NavigationSearchScreen.this.tftSearchListView.setData(NavigationSearchScreen.arrayList);
                NavigationSearchScreen.searchResultAvailable = true;
                MirroringGlobarVar.isSearchProcessing = false;
                NavigationSearchScreen.this.updateImage();
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str2) {
                Log.e("NAVSearch", "on error");
                MirroringGlobarVar.isSearchProcessing = false;
                NavigationSearchScreen.this.updateImage();
            }
        });
    }
}
