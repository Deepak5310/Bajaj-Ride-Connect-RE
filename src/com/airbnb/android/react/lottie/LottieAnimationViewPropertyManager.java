package com.airbnb.android.react.lottie;

import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.net.Uri;
import android.widget.ImageView;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.util.RNLog;
import com.facebook.react.views.text.ReactFontManager;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: LottieAnimationViewPropertyManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010N\u001a\u00020OJ\u0018\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001c\u0010#\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010\nR\u001e\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u0018R\u001e\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\b\"\u0004\bE\u0010\nR\u001e\u0010F\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\bG\u00103\"\u0004\bH\u00105R\u001c\u0010I\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001d\"\u0004\bK\u0010\u001fR\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030MX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/airbnb/android/react/lottie/LottieAnimationViewPropertyManager;", "", "view", "Lcom/airbnb/lottie/LottieAnimationView;", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "animationJson", "", "getAnimationJson", "()Ljava/lang/String;", "setAnimationJson", "(Ljava/lang/String;)V", "value", "animationName", "getAnimationName", "setAnimationName", "animationNameDirty", "", "animationURL", "getAnimationURL", "setAnimationURL", "autoPlay", "getAutoPlay", "()Ljava/lang/Boolean;", "setAutoPlay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "colorFilters", "Lcom/facebook/react/bridge/ReadableArray;", "getColorFilters", "()Lcom/facebook/react/bridge/ReadableArray;", "setColorFilters", "(Lcom/facebook/react/bridge/ReadableArray;)V", "enableMergePaths", "getEnableMergePaths", "setEnableMergePaths", "imageAssetsFolder", "getImageAssetsFolder", "setImageAssetsFolder", "layerType", "", "getLayerType", "()Ljava/lang/Integer;", "setLayerType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "loop", "getLoop", "setLoop", "progress", "", "getProgress", "()Ljava/lang/Float;", "setProgress", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "renderMode", "Lcom/airbnb/lottie/RenderMode;", "getRenderMode", "()Lcom/airbnb/lottie/RenderMode;", "setRenderMode", "(Lcom/airbnb/lottie/RenderMode;)V", "scaleType", "Landroid/widget/ImageView$ScaleType;", "getScaleType", "()Landroid/widget/ImageView$ScaleType;", "setScaleType", "(Landroid/widget/ImageView$ScaleType;)V", "sourceDotLottie", "getSourceDotLottie", "setSourceDotLottie", "speed", "getSpeed", "setSpeed", "textFilters", "getTextFilters", "setTextFilters", "viewWeakReference", "Ljava/lang/ref/WeakReference;", "commitChanges", "", "parseColorFilter", "colorFilter", "Lcom/facebook/react/bridge/ReadableMap;", "lottie-react-native_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LottieAnimationViewPropertyManager {
    private String animationJson;
    private String animationName;
    private boolean animationNameDirty;
    private String animationURL;
    private Boolean autoPlay;
    private ReadableArray colorFilters;
    private Boolean enableMergePaths;
    private String imageAssetsFolder;
    private Integer layerType;
    private Boolean loop;
    private Float progress;
    private RenderMode renderMode;
    private ImageView.ScaleType scaleType;
    private String sourceDotLottie;
    private Float speed;
    private ReadableArray textFilters;
    private final WeakReference<LottieAnimationView> viewWeakReference;

    public LottieAnimationViewPropertyManager(final LottieAnimationView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.viewWeakReference = new WeakReference<>(view);
        view.setFontAssetDelegate(new FontAssetDelegate() { // from class: com.airbnb.android.react.lottie.LottieAnimationViewPropertyManager.1
            @Override // com.airbnb.lottie.FontAssetDelegate
            public Typeface fetchFont(String fontFamily) {
                Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
                Typeface typeface = ReactFontManager.getInstance().getTypeface(fontFamily, -1, -1, view.getContext().getAssets());
                Intrinsics.checkNotNullExpressionValue(typeface, "getTypeface(...)");
                return typeface;
            }

            /* JADX WARN: Code duplicated, block: B:26:0x0059  */
            @Override // com.airbnb.lottie.FontAssetDelegate
            public Typeface fetchFont(String fontFamily, String fontStyle, String fontName) {
                int i;
                Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
                Intrinsics.checkNotNullParameter(fontStyle, "fontStyle");
                Intrinsics.checkNotNullParameter(fontName, "fontName");
                switch (fontStyle) {
                    case "Medium":
                        i = 500;
                        break;
                    case "Normal":
                    case "Regular":
                        i = 400;
                        break;
                    case "Bold":
                        i = 700;
                        break;
                    case "Thin":
                        i = 100;
                        break;
                    case "Black":
                        i = 900;
                        break;
                    case "Light":
                        i = 200;
                        break;
                    default:
                        i = -1;
                        break;
                }
                Typeface typeface = ReactFontManager.getInstance().getTypeface(fontName, -1, i, view.getContext().getAssets());
                Intrinsics.checkNotNullExpressionValue(typeface, "getTypeface(...)");
                return typeface;
            }
        });
    }

    public final String getAnimationName() {
        return this.animationName;
    }

    public final void setAnimationName(String str) {
        this.animationName = str;
        this.animationNameDirty = true;
    }

    public final ImageView.ScaleType getScaleType() {
        return this.scaleType;
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    public final String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    public final void setImageAssetsFolder(String str) {
        this.imageAssetsFolder = str;
    }

    public final Boolean getEnableMergePaths() {
        return this.enableMergePaths;
    }

    public final void setEnableMergePaths(Boolean bool) {
        this.enableMergePaths = bool;
    }

    public final ReadableArray getColorFilters() {
        return this.colorFilters;
    }

    public final void setColorFilters(ReadableArray readableArray) {
        this.colorFilters = readableArray;
    }

    public final ReadableArray getTextFilters() {
        return this.textFilters;
    }

    public final void setTextFilters(ReadableArray readableArray) {
        this.textFilters = readableArray;
    }

    public final RenderMode getRenderMode() {
        return this.renderMode;
    }

    public final void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
    }

    public final Integer getLayerType() {
        return this.layerType;
    }

    public final void setLayerType(Integer num) {
        this.layerType = num;
    }

    public final String getAnimationJson() {
        return this.animationJson;
    }

    public final void setAnimationJson(String str) {
        this.animationJson = str;
    }

    public final String getAnimationURL() {
        return this.animationURL;
    }

    public final void setAnimationURL(String str) {
        this.animationURL = str;
    }

    public final String getSourceDotLottie() {
        return this.sourceDotLottie;
    }

    public final void setSourceDotLottie(String str) {
        this.sourceDotLottie = str;
    }

    public final Float getProgress() {
        return this.progress;
    }

    public final void setProgress(Float f) {
        this.progress = f;
    }

    public final Boolean getLoop() {
        return this.loop;
    }

    public final void setLoop(Boolean bool) {
        this.loop = bool;
    }

    public final Boolean getAutoPlay() {
        return this.autoPlay;
    }

    public final void setAutoPlay(Boolean bool) {
        this.autoPlay = bool;
    }

    public final Float getSpeed() {
        return this.speed;
    }

    public final void setSpeed(Float f) {
        this.speed = f;
    }

    public final void commitChanges() {
        Object objM2319constructorimpl;
        LottieAnimationView lottieAnimationView = this.viewWeakReference.get();
        if (lottieAnimationView == null) {
            return;
        }
        ReadableArray readableArray = this.textFilters;
        if (readableArray != null && readableArray.size() > 0) {
            TextDelegate textDelegate = new TextDelegate(lottieAnimationView);
            ReadableArray readableArray2 = this.textFilters;
            Intrinsics.checkNotNull(readableArray2);
            int size = readableArray2.size();
            for (int i = 0; i < size; i++) {
                ReadableArray readableArray3 = this.textFilters;
                Intrinsics.checkNotNull(readableArray3);
                ReadableMap map = readableArray3.getMap(i);
                textDelegate.setText(map.getString("find"), map.getString("replace"));
            }
            lottieAnimationView.setTextDelegate(textDelegate);
        }
        String str = this.animationJson;
        if (str != null) {
            lottieAnimationView.setAnimationFromJson(str, String.valueOf(str.hashCode()));
            this.animationJson = null;
        }
        String str2 = this.animationURL;
        if (str2 != null) {
            File file = new File(str2);
            if (file.exists()) {
                lottieAnimationView.setAnimation(new FileInputStream(file), String.valueOf(str2.hashCode()));
            } else {
                lottieAnimationView.setAnimationFromUrl(str2, String.valueOf(str2.hashCode()));
            }
            this.animationURL = null;
        }
        String str3 = this.sourceDotLottie;
        if (str3 != null) {
            File file2 = new File(str3);
            if (file2.exists()) {
                lottieAnimationView.setAnimation(new ZipInputStream(new FileInputStream(file2)), String.valueOf(str3.hashCode()));
                this.sourceDotLottie = null;
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager = this;
                objM2319constructorimpl = Result.m2319constructorimpl(Uri.parse(str3).getScheme());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM2319constructorimpl = Result.m2319constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m2325isFailureimpl(objM2319constructorimpl)) {
                objM2319constructorimpl = null;
            }
            if (((String) objM2319constructorimpl) != null) {
                lottieAnimationView.setAnimationFromUrl(str3);
                this.sourceDotLottie = null;
                return;
            }
            int identifier = lottieAnimationView.getResources().getIdentifier(str3, "raw", lottieAnimationView.getContext().getPackageName());
            if (identifier == 0) {
                RNLog.e("Animation for " + str3 + " was not found in raw resources");
                return;
            }
            lottieAnimationView.setAnimation(identifier);
            this.animationNameDirty = false;
            this.sourceDotLottie = null;
        }
        if (this.animationNameDirty) {
            lottieAnimationView.setAnimation(this.animationName);
            this.animationNameDirty = false;
        }
        Float f = this.progress;
        if (f != null) {
            lottieAnimationView.setProgress(f.floatValue());
            this.progress = null;
        }
        Boolean bool = this.loop;
        if (bool != null) {
            lottieAnimationView.setRepeatCount(bool.booleanValue() ? -1 : 0);
            this.loop = null;
        }
        Boolean bool2 = this.autoPlay;
        if (bool2 != null && bool2.booleanValue() && !lottieAnimationView.isAnimating()) {
            lottieAnimationView.playAnimation();
        }
        Float f2 = this.speed;
        if (f2 != null) {
            lottieAnimationView.setSpeed(f2.floatValue());
            this.speed = null;
        }
        ImageView.ScaleType scaleType = this.scaleType;
        if (scaleType != null) {
            lottieAnimationView.setScaleType(scaleType);
            this.scaleType = null;
        }
        RenderMode renderMode = this.renderMode;
        if (renderMode != null) {
            lottieAnimationView.setRenderMode(renderMode);
            this.renderMode = null;
        }
        Integer num = this.layerType;
        if (num != null) {
            lottieAnimationView.setLayerType(num.intValue(), null);
        }
        String str4 = this.imageAssetsFolder;
        if (str4 != null) {
            lottieAnimationView.setImageAssetsFolder(str4);
            this.imageAssetsFolder = null;
        }
        Boolean bool3 = this.enableMergePaths;
        if (bool3 != null) {
            lottieAnimationView.enableMergePathsForKitKatAndAbove(bool3.booleanValue());
            this.enableMergePaths = null;
        }
        ReadableArray readableArray4 = this.colorFilters;
        if (readableArray4 == null || readableArray4.size() <= 0) {
            return;
        }
        int size2 = readableArray4.size();
        for (int i2 = 0; i2 < size2; i2++) {
            parseColorFilter(readableArray4.getMap(i2), lottieAnimationView);
        }
    }

    private final void parseColorFilter(ReadableMap colorFilter, LottieAnimationView view) {
        int iIntValue;
        List listEmptyList;
        if (colorFilter.getType("color") == ReadableType.Map) {
            Integer color = ColorPropConverter.getColor(colorFilter.getMap("color"), view.getContext());
            Intrinsics.checkNotNull(color);
            iIntValue = color.intValue();
        } else {
            iIntValue = colorFilter.getInt("color");
        }
        String str = colorFilter.getString("keypath") + ".**";
        String strQuote = Pattern.quote(".");
        Intrinsics.checkNotNullExpressionValue(strQuote, "quote(...)");
        List<String> listSplit = new Regex(strQuote).split(str, 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        view.addValueCallback(new KeyPath((String[]) Arrays.copyOf(strArr, strArr.length)), LottieProperty.COLOR_FILTER, (LottieValueCallback<ColorFilter>) new LottieValueCallback(new SimpleColorFilter(iIntValue)));
    }
}
