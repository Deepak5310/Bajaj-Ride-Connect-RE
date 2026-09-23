package com.google.android.libraries.navigation.internal.ms;

import android.animation.LayoutTransition;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.MovementMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.AbsSeekBar;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.CalendarView;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;
import android.widget.VideoView;
import android.widget.ViewAnimator;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.drew.metadata.exif.makernotes.KodakMakernoteDirectory;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.drew.metadata.exif.makernotes.ReconyxHyperFireMakernoteDirectory;
import com.drew.metadata.mp4.media.Mp4VideoDirectory;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.facebook.imageutils.JfifUtil;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTMGLShapeSourceManager;
import com.mappls.sdk.navigation.camera.NavigationConstants;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements cx {
    final m a;
    final com.google.android.libraries.navigation.internal.mt.a b;

    public f(m mVar, com.google.android.libraries.navigation.internal.mt.a aVar) {
        this.a = mVar;
        this.b = aVar;
    }

    static final Adapter c(Object obj) {
        return (Adapter) obj;
    }

    static final ListAdapter d(Object obj) {
        return (ListAdapter) obj;
    }

    /* JADX WARN: Code duplicated, block: B:1291:0x1024  */
    /* JADX WARN: Code duplicated, block: B:1293:0x1028  */
    /* JADX WARN: Code duplicated, block: B:1302:0x1046  */
    /* JADX WARN: Code duplicated, block: B:1304:0x104e  */
    /* JADX WARN: Code duplicated, block: B:1306:0x105c  */
    /* JADX WARN: Code duplicated, block: B:2575:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:2577:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:2579:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:2789:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:355:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:377:0x0509  */
    /* JADX WARN: Code duplicated, block: B:399:0x0548  */
    /* JADX WARN: Code restructure failed: missing block: B:1651:0x1515, code lost:
    
        if ((r7 instanceof android.graphics.Matrix) != false) goto L1654;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1742:0x163d, code lost:
    
        if ((r7 instanceof java.lang.Runnable) != false) goto L1745;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2493:0x206f, code lost:
    
        if ((r7 instanceof android.view.View.AccessibilityDelegate) != false) goto L2496;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0347, code lost:
    
        if ((r7 instanceof java.lang.CharSequence) == false) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x03c3, code lost:
    
        if ((r7 instanceof java.lang.CharSequence) == false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:454:0x05f9, code lost:
    
        if ((r7 instanceof java.lang.CharSequence) == false) goto L463;
     */
    /* JADX WARN: Code restructure failed: missing block: B:999:0x0ca7, code lost:
    
        if ((r7 instanceof android.widget.AdapterView.OnItemClickListener) == false) goto L1004;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.libraries.navigation.internal.ms.cx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(cw cwVar, Object obj, ck ckVar) {
        CharSequence charSequenceL;
        CharSequence charSequenceM;
        Animation animationN;
        Drawable drawableH;
        Animation animationN2;
        ColorStateList colorStateListP;
        ColorStateList colorStateListP2;
        ColorStateList colorStateListP3;
        boolean z = cwVar instanceof e;
        View viewG = ckVar.g();
        if (!z) {
            return false;
        }
        switch (((e) cwVar).ordinal()) {
            case 0:
                boolean z2 = viewG instanceof View;
                if (z2) {
                    if (obj != null) {
                        break;
                    } else {
                        obj = null;
                    }
                    this.a.m((View.AccessibilityDelegate) obj, viewG);
                    return true;
                }
                if (!z2 || !(obj instanceof AccessibilityDelegateCompat)) {
                    return false;
                }
                this.a.n((AccessibilityDelegateCompat) obj, viewG);
                return true;
            case 1:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                this.a.o(((Boolean) obj).booleanValue(), viewG);
                return true;
            case 2:
                if (!(viewG instanceof View) || !(obj instanceof Integer)) {
                    return false;
                }
                this.a.p(((Integer) obj).intValue(), viewG);
                return true;
            case 3:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if ((obj instanceof com.google.android.libraries.navigation.internal.nc.t) && (charSequenceM = this.b.m(viewG, (com.google.android.libraries.navigation.internal.nc.t) obj)) != null) {
                    this.a.q(charSequenceM, viewG);
                    return true;
                }
                if ((obj instanceof Integer) && (charSequenceL = this.b.l(viewG, ((Integer) obj).intValue())) != null) {
                    this.a.q(charSequenceL, viewG);
                    return true;
                }
                if (!(obj instanceof CharSequence)) {
                    return false;
                }
                this.a.q((CharSequence) obj, viewG);
                return true;
            case 4:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof Integer) {
                    this.a.s((Integer) obj, viewG);
                    return true;
                }
                if (!(obj instanceof cc)) {
                    return false;
                }
                this.a.r((cc) obj, viewG);
                return true;
            case 5:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof Integer) {
                    this.a.u((Integer) obj, viewG);
                    return true;
                }
                if (!(obj instanceof cc)) {
                    return false;
                }
                this.a.t((cc) obj, viewG);
                return true;
            case 6:
                if (!(viewG instanceof AdapterView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Adapter)) {
                    return false;
                }
                ((AdapterView) viewG).setAdapter(c(obj));
                return true;
            case 7:
                if (!(viewG instanceof ViewGroup) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((ViewGroup) viewG).setAddStatesFromChildren(((Boolean) obj).booleanValue());
                return true;
            case 8:
                if (!(viewG instanceof ImageView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((ImageView) viewG).setAdjustViewBounds(((Boolean) obj).booleanValue());
                return true;
            case 9:
                return (viewG instanceof View) && (obj instanceof Boolean) && this.a.e(((Boolean) obj).booleanValue(), viewG);
            case 10:
                if (!(viewG instanceof TextView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((TextView) viewG).setAllCaps(((Boolean) obj).booleanValue());
                return true;
            case 11:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Number)) {
                    return false;
                }
                this.a.v((Number) obj, viewG);
                return true;
            case 12:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof ag)) {
                    return false;
                }
                this.a.w((ag) obj, viewG);
                return true;
            case 13:
                if (!(viewG instanceof ViewAnimator) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((ViewAnimator) viewG).setAnimateFirstView(((Boolean) obj).booleanValue());
                return true;
            case 14:
                if (!(viewG instanceof ViewGroup) || !(obj instanceof Boolean)) {
                    return false;
                }
                this.a.x(((Boolean) obj).booleanValue(), (ViewGroup) viewG);
                return true;
            case 15:
                if (!(viewG instanceof AutoCompleteTextView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof ListAdapter) || !(obj instanceof Filterable)) {
                    return false;
                }
                ((AutoCompleteTextView) viewG).setAdapter(d(obj));
                return true;
            case 16:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                this.a.y(((Boolean) obj).booleanValue(), viewG, ckVar);
                return true;
            case 17:
                if (!(viewG instanceof TextView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((TextView) viewG).setAutoLinkMask(((Integer) obj).intValue());
                return true;
            case 18:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        viewG.setBackgroundDrawable(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj));
                        return true;
                    }
                    if (obj instanceof Picture) {
                        viewG.setBackgroundDrawable(this.b.i(viewG, (Picture) obj));
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    viewG.setBackgroundDrawable(this.b.h(viewG, ((Integer) obj).intValue()));
                    return true;
                }
                viewG.setBackgroundDrawable(this.b.j(viewG, (Drawable) obj));
                return true;
            case 19:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.x) {
                    this.a.z(Integer.valueOf(this.b.b(viewG, (com.google.android.libraries.navigation.internal.nc.x) obj)), viewG);
                    return true;
                }
                if (obj instanceof Number) {
                    this.a.z(Integer.valueOf(this.b.o((Number) obj)), viewG);
                    return true;
                }
                if (obj != null) {
                    return false;
                }
                this.b.v(null);
                this.a.z(null, viewG);
                return true;
            case 20:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        this.a.A(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj), viewG);
                        return true;
                    }
                    if (obj instanceof Picture) {
                        this.a.A(this.b.i(viewG, (Picture) obj), viewG);
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    this.a.A(this.b.h(viewG, ((Integer) obj).intValue()), viewG);
                    return true;
                }
                this.a.A(this.b.j(viewG, (Drawable) obj), viewG);
                return true;
            case 21:
                if (!(viewG instanceof ImageView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    ((ImageView) viewG).setBaseline(this.b.d(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj));
                    return true;
                }
                if (obj instanceof Integer) {
                    ((ImageView) viewG).setBaseline(this.b.s((Integer) obj));
                    return true;
                }
                if (obj != null) {
                    return false;
                }
                this.b.w(null);
                return false;
            case 22:
                if (!(viewG instanceof LinearLayout) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((LinearLayout) viewG).setBaselineAligned(((Boolean) obj).booleanValue());
                return true;
            case 23:
                if (!(viewG instanceof LinearLayout) || !(obj instanceof Integer)) {
                    return false;
                }
                ((LinearLayout) viewG).setBaselineAlignedChildIndex(((Integer) obj).intValue());
                return true;
            case 24:
                if (!(viewG instanceof ImageView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((ImageView) viewG).setBaselineAlignBottom(((Boolean) obj).booleanValue());
                return true;
            case 25:
                if (!(viewG instanceof TextView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((TextView) viewG).setBreakStrategy(((Integer) obj).intValue());
                return true;
            case 26:
                if (!(viewG instanceof CompoundButton)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        ((CompoundButton) viewG).setButtonDrawable(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj));
                        return true;
                    }
                    if (obj instanceof Picture) {
                        ((CompoundButton) viewG).setButtonDrawable(this.b.i(viewG, (Picture) obj));
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    ((CompoundButton) viewG).setButtonDrawable(this.b.h(viewG, ((Integer) obj).intValue()));
                    return true;
                }
                ((CompoundButton) viewG).setButtonDrawable(this.b.j(viewG, (Drawable) obj));
                return true;
            case 27:
                if (!(viewG instanceof Checkable) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((Checkable) viewG).setChecked(((Boolean) obj).booleanValue());
                return true;
            case 28:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setClickable(((Boolean) obj).booleanValue());
                return true;
            case 29:
                if (!(viewG instanceof ViewGroup) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((ViewGroup) viewG).setClipChildren(((Boolean) obj).booleanValue());
                return true;
            case 30:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setClipToOutline(((Boolean) obj).booleanValue());
                return true;
            case 31:
                if (!(viewG instanceof ViewGroup) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((ViewGroup) viewG).setClipToPadding(((Boolean) obj).booleanValue());
                return true;
            case 32:
                if (!(viewG instanceof ImageView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof ColorFilter)) {
                    return false;
                }
                this.a.B((ColorFilter) obj, (ImageView) viewG);
                return true;
            case 33:
                if (!(viewG instanceof GridLayout) || !(obj instanceof Integer)) {
                    return false;
                }
                ((GridLayout) viewG).setColumnCount(((Integer) obj).intValue());
                return true;
            case 34:
                if (!(viewG instanceof GridView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((GridView) viewG).setColumnWidth(((Integer) obj).intValue());
                return true;
            case 35:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.t) {
                    viewG.setContentDescription(this.b.m(viewG, (com.google.android.libraries.navigation.internal.nc.t) obj));
                    return true;
                }
                if (obj instanceof Integer) {
                    viewG.setContentDescription(this.b.l(viewG, ((Integer) obj).intValue()));
                    return true;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof CharSequence)) {
                    return false;
                }
                viewG.setContentDescription((CharSequence) obj);
                return true;
            case 36:
                if (!(viewG instanceof TimePicker) || !(obj instanceof Integer)) {
                    return false;
                }
                ((TimePicker) viewG).setCurrentHour((Integer) obj);
                return true;
            case 37:
                if (!(viewG instanceof TimePicker) || !(obj instanceof Integer)) {
                    return false;
                }
                ((TimePicker) viewG).setCurrentMinute((Integer) obj);
                return true;
            case 38:
                if (!(viewG instanceof TextView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((TextView) viewG).setCursorVisible(((Boolean) obj).booleanValue());
                return true;
            case 39:
                if (!(viewG instanceof CalendarView) || !(obj instanceof Long)) {
                    return false;
                }
                ((CalendarView) viewG).setDate(((Long) obj).longValue());
                return true;
            case 40:
                if (Build.VERSION.SDK_INT < 26 || !(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setDefaultFocusHighlightEnabled(((Boolean) obj).booleanValue());
                return true;
            case 41:
                if (!(viewG instanceof ViewGroup) || !(obj instanceof Integer)) {
                    return false;
                }
                ((ViewGroup) viewG).setDescendantFocusability(((Integer) obj).intValue());
                return true;
            case 42:
                if (!(viewG instanceof ViewAnimator) || !(obj instanceof cc)) {
                    return false;
                }
                this.a.C((cc) obj, (ViewAnimator) viewG, ckVar);
                return true;
            case 43:
                if (!(viewG instanceof NumberPicker) || !(obj instanceof List)) {
                    return false;
                }
                this.a.D((List) obj, (NumberPicker) viewG);
                return true;
            case 44:
                if (viewG instanceof LinearLayout) {
                    if (obj == null) {
                        obj = null;
                    } else if (!(obj instanceof Drawable)) {
                        if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                            ((LinearLayout) viewG).setDividerDrawable(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj));
                            return true;
                        }
                        if (obj instanceof Picture) {
                            ((LinearLayout) viewG).setDividerDrawable(this.b.i(viewG, (Picture) obj));
                            return true;
                        }
                        if (obj instanceof Integer) {
                            ((LinearLayout) viewG).setDividerDrawable(this.b.h(viewG, ((Integer) obj).intValue()));
                            return true;
                        }
                    }
                    ((LinearLayout) viewG).setDividerDrawable(this.b.j(viewG, (Drawable) obj));
                    return true;
                }
                if (!(viewG instanceof ListView)) {
                    return false;
                }
                if (obj == null || (obj instanceof Drawable)) {
                    ((ListView) viewG).setDivider(this.b.j(viewG, (Drawable) obj));
                    return true;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                    ((ListView) viewG).setDivider(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj));
                    return true;
                }
                if (obj instanceof Picture) {
                    ((ListView) viewG).setDivider(this.b.i(viewG, (Picture) obj));
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                ((ListView) viewG).setDivider(this.b.h(viewG, ((Integer) obj).intValue()));
                return true;
            case 45:
                if (!(viewG instanceof ListView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    ((ListView) viewG).setDividerHeight(this.b.d(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj));
                    return true;
                }
                if (obj instanceof Integer) {
                    ((ListView) viewG).setDividerHeight(this.b.s((Integer) obj));
                    return true;
                }
                if (obj != null) {
                    return false;
                }
                this.b.w(null);
                return false;
            case 46:
                if (!(viewG instanceof LinearLayout)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    ((LinearLayout) viewG).setDividerPadding(this.b.c(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj));
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                ((LinearLayout) viewG).setDividerPadding(this.b.r((Integer) obj));
                return true;
            case 47:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        this.a.E(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj), (TextView) viewG);
                        return true;
                    }
                    if (obj instanceof Picture) {
                        this.a.E(this.b.i(viewG, (Picture) obj), (TextView) viewG);
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    this.a.E(this.b.h(viewG, ((Integer) obj).intValue()), (TextView) viewG);
                    return true;
                }
                this.a.E(this.b.j(viewG, (Drawable) obj), (TextView) viewG);
                return true;
            case 48:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        this.a.F(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj), (TextView) viewG);
                        return true;
                    }
                    if (obj instanceof Picture) {
                        this.a.F(this.b.i(viewG, (Picture) obj), (TextView) viewG);
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    this.a.F(this.b.h(viewG, ((Integer) obj).intValue()), (TextView) viewG);
                    return true;
                }
                this.a.F(this.b.j(viewG, (Drawable) obj), (TextView) viewG);
                return true;
            case 49:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        this.a.G(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj), (TextView) viewG);
                        return true;
                    }
                    if (obj instanceof Picture) {
                        this.a.G(this.b.i(viewG, (Picture) obj), (TextView) viewG);
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    this.a.G(this.b.h(viewG, ((Integer) obj).intValue()), (TextView) viewG);
                    return true;
                }
                this.a.G(this.b.j(viewG, (Drawable) obj), (TextView) viewG);
                return true;
            case 50:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    ((TextView) viewG).setCompoundDrawablePadding(this.b.c(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj));
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                ((TextView) viewG).setCompoundDrawablePadding(this.b.r((Integer) obj));
                return true;
            case 51:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        this.a.H(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj), (TextView) viewG);
                        return true;
                    }
                    if (obj instanceof Picture) {
                        this.a.H(this.b.i(viewG, (Picture) obj), (TextView) viewG);
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    this.a.H(this.b.h(viewG, ((Integer) obj).intValue()), (TextView) viewG);
                    return true;
                }
                this.a.H(this.b.j(viewG, (Drawable) obj), (TextView) viewG);
                return true;
            case 52:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        this.a.I(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj), (TextView) viewG);
                        return true;
                    }
                    if (obj instanceof Picture) {
                        this.a.I(this.b.i(viewG, (Picture) obj), (TextView) viewG);
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    this.a.I(this.b.h(viewG, ((Integer) obj).intValue()), (TextView) viewG);
                    return true;
                }
                this.a.I(this.b.j(viewG, (Drawable) obj), (TextView) viewG);
                return true;
            case 53:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        this.a.J(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj), (TextView) viewG);
                        return true;
                    }
                    if (obj instanceof Picture) {
                        this.a.J(this.b.i(viewG, (Picture) obj), (TextView) viewG);
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    this.a.J(this.b.h(viewG, ((Integer) obj).intValue()), (TextView) viewG);
                    return true;
                }
                this.a.J(this.b.j(viewG, (Drawable) obj), (TextView) viewG);
                return true;
            case 54:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                this.a.K(((Boolean) obj).booleanValue(), viewG);
                return true;
            case 55:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.L((com.google.android.libraries.navigation.internal.nc.ap) obj, viewG);
                    return true;
                }
                if (!(obj instanceof Number)) {
                    return false;
                }
                this.a.M((Number) obj, viewG);
                return true;
            case 56:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof TextUtils.TruncateAt)) {
                    return false;
                }
                ((TextView) viewG).setEllipsize((TextUtils.TruncateAt) obj);
                return true;
            case 57:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setEnabled(((Boolean) obj).booleanValue());
                return true;
            case 58:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.t) {
                    ((TextView) viewG).setError(this.b.m(viewG, (com.google.android.libraries.navigation.internal.nc.t) obj));
                    return true;
                }
                if (obj instanceof Integer) {
                    ((TextView) viewG).setError(this.b.l(viewG, ((Integer) obj).intValue()));
                    return true;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof CharSequence)) {
                    return false;
                }
                ((TextView) viewG).setError((CharSequence) obj);
                return true;
            case 59:
                if (!(viewG instanceof AbsListView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((AbsListView) viewG).setFastScrollEnabled(((Boolean) obj).booleanValue());
                return true;
            case 60:
                if ((viewG instanceof HorizontalScrollView) && (obj instanceof Boolean)) {
                    ((HorizontalScrollView) viewG).setFillViewport(((Boolean) obj).booleanValue());
                    return true;
                }
                if (!(viewG instanceof ScrollView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((ScrollView) viewG).setFillViewport(((Boolean) obj).booleanValue());
                return true;
            case 61:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Boolean)) {
                    return false;
                }
                this.a.N((Boolean) obj, viewG);
                return true;
            case 62:
                boolean z3 = viewG instanceof View;
                if (z3 && (obj instanceof Boolean)) {
                    viewG.setFocusable(((Boolean) obj).booleanValue());
                    return true;
                }
                if (Build.VERSION.SDK_INT < 26 || !z3 || !(obj instanceof Integer)) {
                    return false;
                }
                viewG.setFocusable(((Integer) obj).intValue());
                return true;
            case 63:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setFocusableInTouchMode(((Boolean) obj).booleanValue());
                return true;
            case 64:
                if (Build.VERSION.SDK_INT < 26 || !(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setFocusedByDefault(((Boolean) obj).booleanValue());
                return true;
            case 65:
                if (!(viewG instanceof TextView) || !(obj instanceof String)) {
                    return false;
                }
                this.a.O((String) obj, (TextView) viewG);
                return true;
            case 66:
                if (!(viewG instanceof FrameLayout)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        this.a.P(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj), (FrameLayout) viewG);
                        return true;
                    }
                    if (obj instanceof Picture) {
                        this.a.P(this.b.i(viewG, (Picture) obj), (FrameLayout) viewG);
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    this.a.P(this.b.h(viewG, ((Integer) obj).intValue()), (FrameLayout) viewG);
                    return true;
                }
                this.a.P(this.b.j(viewG, (Drawable) obj), (FrameLayout) viewG);
                return true;
            case 67:
                if (!(viewG instanceof NumberPicker)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof NumberPicker.Formatter)) {
                    return false;
                }
                ((NumberPicker) viewG).setFormatter((NumberPicker.Formatter) obj);
                return true;
            case 68:
                if (!(viewG instanceof ViewPager) || !(obj instanceof FragmentPagerAdapter)) {
                    return false;
                }
                this.a.Q((FragmentPagerAdapter) obj, (ViewPager) viewG);
                return true;
            case 69:
                if ((viewG instanceof LinearLayout) && (obj instanceof Integer)) {
                    ((LinearLayout) viewG).setGravity(((Integer) obj).intValue());
                    return true;
                }
                if ((viewG instanceof RelativeLayout) && (obj instanceof Integer)) {
                    ((RelativeLayout) viewG).setGravity(((Integer) obj).intValue());
                    return true;
                }
                if (!(viewG instanceof TextView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((TextView) viewG).setGravity(((Integer) obj).intValue());
                return true;
            case 70:
                boolean z4 = viewG instanceof View;
                if (z4) {
                    if (obj != null) {
                        break;
                    } else {
                        obj = null;
                    }
                    this.a.R((Runnable) obj, viewG);
                    return true;
                }
                if (Build.VERSION.SDK_INT < 34 || !z4 || !(obj instanceof Runnable)) {
                    return false;
                }
                viewG.setHandwritingDelegatorCallback((Runnable) obj);
                return true;
            case PanasonicMakernoteDirectory.TAG_WB_ADJUST_GM /* 71 */:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setHapticFeedbackEnabled(((Boolean) obj).booleanValue());
                return true;
            case 72:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.t) {
                    ((TextView) viewG).setHint(this.b.m(viewG, (com.google.android.libraries.navigation.internal.nc.t) obj));
                    return true;
                }
                if (obj instanceof Integer) {
                    ((TextView) viewG).setHint(this.b.l(viewG, ((Integer) obj).intValue()));
                    return true;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof CharSequence)) {
                    return false;
                }
                ((TextView) viewG).setHint((CharSequence) obj);
                return true;
            case 73:
                if (!(viewG instanceof TextView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((TextView) viewG).setHorizontallyScrolling(((Boolean) obj).booleanValue());
                return true;
            case ReconyxHyperFireMakernoteDirectory.TAG_BRIGHTNESS /* 74 */:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setHorizontalFadingEdgeEnabled(((Boolean) obj).booleanValue());
                return true;
            case 75:
                if (!(viewG instanceof GridView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((GridView) viewG).setHorizontalSpacing(((Integer) obj).intValue());
                return true;
            case 76:
                if (!(viewG instanceof TextView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((TextView) viewG).setHyphenationFrequency(((Integer) obj).intValue());
                return true;
            case PanasonicMakernoteDirectory.TAG_AF_POINT_POSITION /* 77 */:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Integer)) {
                    return false;
                }
                this.a.S((Integer) obj, viewG);
                return true;
            case 78:
                if (!(viewG instanceof ImageView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        ((ImageView) viewG).setImageDrawable(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj));
                        return true;
                    }
                    if (obj instanceof Picture) {
                        ((ImageView) viewG).setImageDrawable(this.b.i(viewG, (Picture) obj));
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    ((ImageView) viewG).setImageDrawable(this.b.h(viewG, ((Integer) obj).intValue()));
                    return true;
                }
                ((ImageView) viewG).setImageDrawable(this.b.j(viewG, (Drawable) obj));
                return true;
            case 79:
                boolean z5 = viewG instanceof ImageView;
                if (z5) {
                    if (obj != null) {
                        break;
                    } else {
                        obj = null;
                    }
                    this.a.T((Matrix) obj, (ImageView) viewG);
                    return true;
                }
                if (!z5 || !(obj instanceof Matrix)) {
                    return false;
                }
                ((ImageView) viewG).setImageMatrix((Matrix) obj);
                return true;
            case 80:
                boolean z6 = viewG instanceof ImageView;
                if (z6) {
                    if (obj == null) {
                        obj = null;
                    } else if (!(obj instanceof com.google.android.libraries.navigation.internal.nc.x)) {
                        if (obj instanceof Number) {
                            this.a.U(this.b.p((Number) obj), (ImageView) viewG);
                            return true;
                        }
                        if (obj instanceof ColorStateList) {
                            this.a.U((ColorStateList) obj, (ImageView) viewG);
                            return true;
                        }
                    }
                    this.a.U(this.b.g(viewG, (com.google.android.libraries.navigation.internal.nc.x) obj), (ImageView) viewG);
                    return true;
                }
                if (!z6) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.x) {
                    ((ImageView) viewG).setImageTintList(this.b.g(viewG, (com.google.android.libraries.navigation.internal.nc.x) obj));
                    return true;
                }
                if (obj instanceof Number) {
                    ((ImageView) viewG).setImageTintList(this.b.p((Number) obj));
                    return true;
                }
                if (!(obj instanceof ColorStateList)) {
                    return false;
                }
                ((ImageView) viewG).setImageTintList((ColorStateList) obj);
                return true;
            case PanasonicMakernoteDirectory.TAG_LENS_TYPE /* 81 */:
                if (!(viewG instanceof TextView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((TextView) viewG).setImeOptions(((Integer) obj).intValue());
                return true;
            case 82:
                if (!(viewG instanceof View) || !(obj instanceof Integer)) {
                    return false;
                }
                viewG.setImportantForAccessibility(((Integer) obj).intValue());
                return true;
            case PanasonicMakernoteDirectory.TAG_ACCESSORY_TYPE /* 83 */:
                if (!(viewG instanceof ViewAnimator)) {
                    return false;
                }
                if ((obj instanceof com.google.android.libraries.navigation.internal.nc.k) && (animationN = this.b.n(viewG, (com.google.android.libraries.navigation.internal.nc.k) obj)) != null) {
                    ((ViewAnimator) viewG).setInAnimation(animationN);
                    return true;
                }
                if (!(obj instanceof Animation)) {
                    return false;
                }
                ((ViewAnimator) viewG).setInAnimation((Animation) obj);
                return true;
            case 84:
                if (!(viewG instanceof TextView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((TextView) viewG).setIncludeFontPadding(((Boolean) obj).booleanValue());
                return true;
            case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
                if (!(viewG instanceof ProgressBar)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof ColorFilter)) {
                    return false;
                }
                this.a.V((ColorFilter) obj, (ProgressBar) viewG);
                return true;
            case ReconyxHyperFireMakernoteDirectory.TAG_USER_LABEL /* 86 */:
                if (!(viewG instanceof ProgressBar)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        ((ProgressBar) viewG).setIndeterminateDrawable(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj));
                        return true;
                    }
                    if (obj instanceof Picture) {
                        ((ProgressBar) viewG).setIndeterminateDrawable(this.b.i(viewG, (Picture) obj));
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    ((ProgressBar) viewG).setIndeterminateDrawable(this.b.h(viewG, ((Integer) obj).intValue()));
                    return true;
                }
                ((ProgressBar) viewG).setIndeterminateDrawable(this.b.j(viewG, (Drawable) obj));
                return true;
            case 87:
                if (!(viewG instanceof ProgressBar)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof com.google.android.libraries.navigation.internal.nc.x)) {
                    if (obj instanceof Number) {
                        ((ProgressBar) viewG).setIndeterminateTintList(this.b.p((Number) obj));
                        return true;
                    }
                    if (!(obj instanceof ColorStateList)) {
                        return false;
                    }
                    ((ProgressBar) viewG).setIndeterminateTintList((ColorStateList) obj);
                    return true;
                }
                ((ProgressBar) viewG).setIndeterminateTintList(this.b.g(viewG, (com.google.android.libraries.navigation.internal.nc.x) obj));
                return true;
            case 88:
                if (!(viewG instanceof DatePicker) || !(obj instanceof ab)) {
                    return false;
                }
                this.a.W((ab) obj, (DatePicker) viewG);
                return true;
            case PanasonicMakernoteDirectory.TAG_TRANSFORM /* 89 */:
                if (!(viewG instanceof TextView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((TextView) viewG).setRawInputType(((Integer) obj).intValue());
                return true;
            case 90:
                if (!(viewG instanceof TimePicker) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((TimePicker) viewG).setIs24HourView((Boolean) obj);
                return true;
            case 91:
                boolean z7 = viewG instanceof View;
                if (z7 && (obj instanceof Boolean)) {
                    this.a.X(((Boolean) obj).booleanValue(), viewG);
                    return true;
                }
                if (Build.VERSION.SDK_INT < 34 || !z7 || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setIsHandwritingDelegate(((Boolean) obj).booleanValue());
                return true;
            case KodakMakernoteDirectory.TAG_FLASH_MODE /* 92 */:
                if (Build.VERSION.SDK_INT < 26 || !(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setKeyboardNavigationCluster(((Boolean) obj).booleanValue());
                return true;
            case 93:
                if (!(viewG instanceof View) || !(obj instanceof Integer)) {
                    return false;
                }
                viewG.setLabelFor(((Integer) obj).intValue());
                return true;
            case KodakMakernoteDirectory.TAG_ISO_SETTING /* 94 */:
                if (!(viewG instanceof View) || !(obj instanceof Integer)) {
                    return false;
                }
                this.a.Y(((Integer) obj).intValue(), viewG);
                return true;
            case 95:
                if (!(viewG instanceof View) || !(obj instanceof Float)) {
                    return false;
                }
                this.a.Z(((Float) obj).floatValue(), viewG);
                return true;
            case 96:
                if (!(viewG instanceof View) || !(obj instanceof Integer)) {
                    return false;
                }
                this.a.aa(((Integer) obj).intValue(), viewG);
                return true;
            case PanasonicMakernoteDirectory.TAG_FACE_RECOGNITION_INFO /* 97 */:
                if (!(viewG instanceof View) || !(obj instanceof Integer)) {
                    return false;
                }
                this.a.ab(((Integer) obj).intValue(), viewG);
                return true;
            case 98:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.bd) {
                    this.a.ac(this.b.t((com.google.android.libraries.navigation.internal.nc.bd) obj), viewG);
                    return true;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.ac(this.b.e(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), viewG);
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                this.a.ac(this.b.u((Integer) obj), viewG);
                return true;
            case 99:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.ad(this.b.c(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), viewG);
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                this.a.ad(this.b.r((Integer) obj), viewG);
                return true;
            case 100:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.ae(this.b.c(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), viewG);
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                this.a.ae(this.b.r((Integer) obj), viewG);
                return true;
            case 101:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.af(this.b.c(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), viewG);
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                this.a.af(this.b.r((Integer) obj), viewG);
                return true;
            case 102:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.ag(this.b.c(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), viewG);
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                this.a.ag(this.b.r((Integer) obj), viewG);
                return true;
            case 103:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.ah(this.b.c(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), viewG);
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                this.a.ah(this.b.r((Integer) obj), viewG);
                return true;
            case 104:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.ai(this.b.c(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), viewG);
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                this.a.ai(this.b.r((Integer) obj), viewG);
                return true;
            case 105:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.aj(this.b.c(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), viewG);
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                this.a.aj(this.b.r((Integer) obj), viewG);
                return true;
            case RCTMGLShapeSourceManager.METHOD_GET_CLUSTER_CHILDREN /* 106 */:
                if (!(viewG instanceof View) || !(obj instanceof Float)) {
                    return false;
                }
                this.a.ak(((Float) obj).floatValue(), viewG);
                return true;
            case 107:
                if (!(viewG instanceof ViewGroup)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ay) {
                    ((ViewGroup) viewG).setLayoutTransition(this.b.f(viewG, (com.google.android.libraries.navigation.internal.nc.ay) obj));
                    return true;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof LayoutTransition)) {
                    return false;
                }
                ((ViewGroup) viewG).setLayoutTransition((LayoutTransition) obj);
                return true;
            case 108:
                if (!(viewG instanceof View) || !(obj instanceof Float)) {
                    return false;
                }
                this.a.al(((Float) obj).floatValue(), viewG);
                return true;
            case 109:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.bd) {
                    this.a.am(this.b.t((com.google.android.libraries.navigation.internal.nc.bd) obj), viewG);
                    return true;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.am(this.b.e(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), viewG);
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                this.a.am(this.b.u((Integer) obj), viewG);
                return true;
            case 110:
                if (!(viewG instanceof TextView) || !(obj instanceof Float)) {
                    return false;
                }
                this.a.an(((Float) obj).floatValue(), (TextView) viewG);
                return true;
            case PanasonicMakernoteDirectory.TAG_LANDMARK /* 111 */:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.ao(this.b.a(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), (TextView) viewG);
                    return true;
                }
                if (!(obj instanceof Number)) {
                    return false;
                }
                this.a.ao(this.b.q((Number) obj), (TextView) viewG);
                return true;
            case PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION /* 112 */:
                if (!(viewG instanceof TextView) || !(obj instanceof Number)) {
                    return false;
                }
                this.a.ap((Number) obj, (TextView) viewG);
                return true;
            case 113:
                if (!(viewG instanceof TextView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((TextView) viewG).setLines(((Integer) obj).intValue());
                return true;
            case 114:
                return (viewG instanceof View) && (obj instanceof Object) && this.a.f(obj, viewG);
            case 115:
                if (!(viewG instanceof AbsListView)) {
                    return false;
                }
                if (obj != null) {
                    if (obj instanceof Drawable) {
                    }
                    if (!(obj instanceof com.google.android.libraries.navigation.internal.nc.ah)) {
                        ((AbsListView) viewG).setSelector(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj));
                        return true;
                    }
                    if (!(obj instanceof Picture)) {
                        ((AbsListView) viewG).setSelector(this.b.i(viewG, (Picture) obj));
                        return true;
                    }
                    if (!(obj instanceof Integer) && (drawableH = this.b.h(viewG, ((Integer) obj).intValue())) != null) {
                        ((AbsListView) viewG).setSelector(drawableH);
                        return true;
                    }
                    if (obj instanceof Drawable) {
                        return false;
                    }
                    ((AbsListView) viewG).setSelector((Drawable) obj);
                    return true;
                }
                obj = null;
                Drawable drawableJ = this.b.j(viewG, (Drawable) obj);
                if (drawableJ != null) {
                    ((AbsListView) viewG).setSelector(drawableJ);
                    return true;
                }
                if (!(obj instanceof com.google.android.libraries.navigation.internal.nc.ah)) {
                    ((AbsListView) viewG).setSelector(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj));
                    return true;
                }
                if (!(obj instanceof Picture)) {
                    ((AbsListView) viewG).setSelector(this.b.i(viewG, (Picture) obj));
                    return true;
                }
                if (!(obj instanceof Integer)) {
                }
                if (obj instanceof Drawable) {
                    return false;
                }
                ((AbsListView) viewG).setSelector((Drawable) obj);
                return true;
            case 116:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setLongClickable(((Boolean) obj).booleanValue());
                return true;
            case 117:
                if (!(viewG instanceof ProgressBar) || !(obj instanceof Integer)) {
                    return false;
                }
                ((ProgressBar) viewG).setMax(((Integer) obj).intValue());
                return true;
            case 118:
                if ((viewG instanceof CalendarView) && (obj instanceof Long)) {
                    ((CalendarView) viewG).setMaxDate(((Long) obj).longValue());
                    return true;
                }
                if (!(viewG instanceof DatePicker) || !(obj instanceof Long)) {
                    return false;
                }
                ((DatePicker) viewG).setMaxDate(((Long) obj).longValue());
                return true;
            case PanasonicMakernoteDirectory.TAG_BURST_SPEED /* 119 */:
                if (viewG instanceof ImageView) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                        ((ImageView) viewG).setMaxHeight(this.b.d(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj));
                        return true;
                    }
                    if (obj instanceof Integer) {
                        ((ImageView) viewG).setMaxHeight(this.b.s((Integer) obj));
                        return true;
                    }
                    if (obj == null) {
                        this.b.w(null);
                        obj = null;
                    }
                }
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    ((TextView) viewG).setMaxHeight(this.b.d(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj));
                    return true;
                }
                boolean z8 = obj instanceof Integer;
                if (z8) {
                    ((TextView) viewG).setMaxHeight(this.b.s((Integer) obj));
                    return true;
                }
                if (obj != null && !z8) {
                    return false;
                }
                this.b.w((Integer) obj);
                return false;
            case 120:
                if (!(viewG instanceof TextView) || !(obj instanceof Integer)) {
                    return false;
                }
                this.a.aq(((Integer) obj).intValue(), (TextView) viewG);
                return true;
            case PanasonicMakernoteDirectory.TAG_INTELLIGENT_D_RANGE /* 121 */:
                if (!(viewG instanceof TextView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((TextView) viewG).setMaxLines(((Integer) obj).intValue());
                return true;
            case 122:
                if (!(viewG instanceof NumberPicker) || !(obj instanceof Integer)) {
                    return false;
                }
                ((NumberPicker) viewG).setMaxValue(((Integer) obj).intValue());
                return true;
            case 123:
                if (viewG instanceof ImageView) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                        ((ImageView) viewG).setMaxWidth(this.b.d(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj));
                        return true;
                    }
                    if (obj instanceof Integer) {
                        ((ImageView) viewG).setMaxWidth(this.b.s((Integer) obj));
                        return true;
                    }
                    if (obj == null) {
                        this.b.w(null);
                        obj = null;
                    }
                }
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    ((TextView) viewG).setMaxWidth(this.b.d(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj));
                    return true;
                }
                boolean z9 = obj instanceof Integer;
                if (z9) {
                    ((TextView) viewG).setMaxWidth(this.b.s((Integer) obj));
                    return true;
                }
                if (obj != null && !z9) {
                    return false;
                }
                this.b.w((Integer) obj);
                return false;
            case PanasonicMakernoteDirectory.TAG_CLEAR_RETOUCH /* 124 */:
                if (!(viewG instanceof FrameLayout) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((FrameLayout) viewG).setMeasureAllChildren(((Boolean) obj).booleanValue());
                return true;
            case NavigationConstants.NAVIGATION_LOW_ALERT_DURATION /* 125 */:
                if (!(viewG instanceof LinearLayout) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((LinearLayout) viewG).setMeasureWithLargestChildEnabled(((Boolean) obj).booleanValue());
                return true;
            case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                if (!(viewG instanceof VideoView) || !(obj instanceof MediaController)) {
                    return false;
                }
                ((VideoView) viewG).setMediaController((MediaController) obj);
                return true;
            case 127:
                if ((viewG instanceof CalendarView) && (obj instanceof Long)) {
                    ((CalendarView) viewG).setMinDate(((Long) obj).longValue());
                    return true;
                }
                if (!(viewG instanceof DatePicker) || !(obj instanceof Long)) {
                    return false;
                }
                ((DatePicker) viewG).setMinDate(((Long) obj).longValue());
                return true;
            case 128:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.ar(this.b.d(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), viewG);
                    return true;
                }
                if (obj instanceof Integer) {
                    this.a.ar(this.b.s((Integer) obj), viewG);
                    return true;
                }
                if (obj != null) {
                    return false;
                }
                this.b.w(null);
                return false;
            case 129:
                if (!(viewG instanceof NumberPicker) || !(obj instanceof Integer)) {
                    return false;
                }
                ((NumberPicker) viewG).setMinValue(((Integer) obj).intValue());
                return true;
            case NikonType2MakernoteDirectory.TAG_ADAPTER /* 130 */:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.as(this.b.d(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), viewG);
                    return true;
                }
                if (obj instanceof Integer) {
                    this.a.as(this.b.s((Integer) obj), viewG);
                    return true;
                }
                if (obj != null) {
                    return false;
                }
                this.b.w(null);
                return false;
            case 131:
            case Mp4VideoDirectory.TAG_COLOR_TABLE /* 213 */:
            default:
                return false;
            case NikonType2MakernoteDirectory.TAG_LENS /* 132 */:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof MovementMethod)) {
                    return false;
                }
                ((TextView) viewG).setMovementMethod((MovementMethod) obj);
                return true;
            case NikonType2MakernoteDirectory.TAG_MANUAL_FOCUS_DISTANCE /* 133 */:
                if (!(viewG instanceof View) || !(obj instanceof Object)) {
                    return false;
                }
                this.a.at(obj, viewG);
                return true;
            case NikonType2MakernoteDirectory.TAG_DIGITAL_ZOOM /* 134 */:
                if (!(viewG instanceof View) || !(obj instanceof Object)) {
                    return false;
                }
                this.a.au(obj, viewG);
                return true;
            case NikonType2MakernoteDirectory.TAG_FLASH_USED /* 135 */:
                if (!(viewG instanceof View) || !(obj instanceof Object)) {
                    return false;
                }
                this.a.av(obj, viewG);
                return true;
            case 136:
                if (!(viewG instanceof View) || !(obj instanceof Object)) {
                    return false;
                }
                this.a.aw(obj, viewG);
                return true;
            case 137:
                if (!(viewG instanceof View) || !(obj instanceof Object)) {
                    return false;
                }
                this.a.ax(obj, viewG);
                return true;
            case 138:
                if (!(viewG instanceof GridView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((GridView) viewG).setNumColumns(((Integer) obj).intValue());
                return true;
            case NikonType2MakernoteDirectory.TAG_LENS_STOPS /* 139 */:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof View.OnAttachStateChangeListener)) {
                    return false;
                }
                this.a.ay((View.OnAttachStateChangeListener) obj, viewG);
                return true;
            case 140:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                }
                return this.a.g(obj, viewG);
            case 141:
                if (!(viewG instanceof VideoView) || !(obj instanceof MediaPlayer.OnCompletionListener)) {
                    return false;
                }
                ((VideoView) viewG).setOnCompletionListener((MediaPlayer.OnCompletionListener) obj);
                return true;
            case 142:
                if (!(viewG instanceof CompoundButton)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof CompoundButton.OnCheckedChangeListener)) {
                    return false;
                }
                ((CompoundButton) viewG).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) obj);
                return true;
            case 143:
                if (!(viewG instanceof CalendarView) || !(obj instanceof CalendarView.OnDateChangeListener)) {
                    return false;
                }
                this.a.az((CalendarView.OnDateChangeListener) obj, (CalendarView) viewG);
                return true;
            case 144:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof TextView.OnEditorActionListener)) {
                    return false;
                }
                this.a.aA((TextView.OnEditorActionListener) obj, (TextView) viewG);
                return true;
            case 145:
                if (!(viewG instanceof VideoView) || !(obj instanceof MediaPlayer.OnErrorListener)) {
                    return false;
                }
                ((VideoView) viewG).setOnErrorListener((MediaPlayer.OnErrorListener) obj);
                return true;
            case 146:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof View.OnFocusChangeListener)) {
                    return false;
                }
                this.a.aB((View.OnFocusChangeListener) obj, viewG);
                return true;
            case 147:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof View.OnGenericMotionListener)) {
                    return false;
                }
                this.a.aC((View.OnGenericMotionListener) obj, viewG);
                return true;
            case 148:
                if (viewG instanceof AdapterView) {
                    if (obj != null) {
                        break;
                    } else {
                        obj = null;
                    }
                    ((AdapterView) viewG).setOnItemClickListener((AdapterView.OnItemClickListener) obj);
                    return true;
                }
                if (!(viewG instanceof AutoCompleteTextView)) {
                    return false;
                }
                if (obj != null && !(obj instanceof AdapterView.OnItemClickListener)) {
                    return false;
                }
                ((AutoCompleteTextView) viewG).setOnItemClickListener((AdapterView.OnItemClickListener) obj);
                return true;
            case 149:
                if (!(viewG instanceof AdapterView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof AdapterView.OnItemSelectedListener)) {
                    return false;
                }
                ((AdapterView) viewG).setOnItemSelectedListener((AdapterView.OnItemSelectedListener) obj);
                return true;
            case 150:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof View.OnLayoutChangeListener)) {
                    return false;
                }
                this.a.aD((View.OnLayoutChangeListener) obj, viewG);
                return true;
            case 151:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof View.OnLongClickListener)) {
                    return false;
                }
                this.a.aE(viewG);
                return true;
            case 152:
                if (!(viewG instanceof ViewPager)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof ViewPager.OnPageChangeListener)) {
                    return false;
                }
                ((ViewPager) viewG).setOnPageChangeListener((ViewPager.OnPageChangeListener) obj);
                return true;
            case 153:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof c)) {
                    return false;
                }
                this.a.aF((c) obj, viewG, ckVar);
                return true;
            case 154:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof d)) {
                    return false;
                }
                this.a.aG((d) obj, viewG, ckVar);
                return true;
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_10 /* 155 */:
                if (!(viewG instanceof VideoView) || !(obj instanceof MediaPlayer.OnPreparedListener)) {
                    return false;
                }
                ((VideoView) viewG).setOnPreparedListener((MediaPlayer.OnPreparedListener) obj);
                return true;
            case NikonType2MakernoteDirectory.TAG_SCENE_ASSIST /* 156 */:
                if (!(viewG instanceof RadioGroup)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof RadioGroup.OnCheckedChangeListener)) {
                    return false;
                }
                ((RadioGroup) viewG).setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) obj);
                return true;
            case 157:
                if (!(viewG instanceof SwipeRefreshLayout)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof SwipeRefreshLayout.OnRefreshListener)) {
                    return false;
                }
                this.a.aH((SwipeRefreshLayout.OnRefreshListener) obj, (SwipeRefreshLayout) viewG);
                return true;
            case 158:
                if (!(viewG instanceof SeekBar)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof SeekBar.OnSeekBarChangeListener)) {
                    return false;
                }
                ((SeekBar) viewG).setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) obj);
                return true;
            case 159:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof View.OnScrollChangeListener)) {
                    return false;
                }
                viewG.setOnScrollChangeListener((View.OnScrollChangeListener) obj);
                return true;
            case 160:
                if (!(viewG instanceof TextView) || !(obj instanceof TextWatcher)) {
                    return false;
                }
                this.a.aI((TextWatcher) obj, (TextView) viewG, ckVar);
                return true;
            case CanonMakernoteDirectory.TAG_TONE_CURVE_TABLE /* 161 */:
                if (!(viewG instanceof TimePicker)) {
                    return false;
                }
                boolean z10 = obj instanceof TimePicker.OnTimeChangedListener;
                if (z10) {
                    this.a.aJ((TimePicker.OnTimeChangedListener) obj, (TimePicker) viewG);
                    return true;
                }
                if (!z10) {
                    return false;
                }
                ((TimePicker) viewG).setOnTimeChangedListener((TimePicker.OnTimeChangedListener) obj);
                return true;
            case 162:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof View.OnTouchListener)) {
                    return false;
                }
                this.a.aK((View.OnTouchListener) obj, viewG);
                return true;
            case 163:
                if (!(viewG instanceof NumberPicker)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof NumberPicker.OnValueChangeListener)) {
                    return false;
                }
                ((NumberPicker) viewG).setOnValueChangedListener((NumberPicker.OnValueChangeListener) obj);
                return true;
            case 164:
                if (!(viewG instanceof LinearLayout) || !(obj instanceof Integer)) {
                    return false;
                }
                ((LinearLayout) viewG).setOrientation(((Integer) obj).intValue());
                return true;
            case NikonType2MakernoteDirectory.TAG_IMAGE_COUNT /* 165 */:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.x) {
                    this.a.aL(Integer.valueOf(this.b.b(viewG, (com.google.android.libraries.navigation.internal.nc.x) obj)), viewG);
                    return true;
                }
                if (obj instanceof Number) {
                    this.a.aL(Integer.valueOf(this.b.o((Number) obj)), viewG);
                    return true;
                }
                if (obj != null) {
                    return false;
                }
                this.b.v(null);
                this.a.aL(null, viewG);
                return true;
            case NikonType2MakernoteDirectory.TAG_DELETED_IMAGE_COUNT /* 166 */:
                if (!(viewG instanceof View) || !(obj instanceof ViewOutlineProvider)) {
                    return false;
                }
                viewG.setOutlineProvider((ViewOutlineProvider) obj);
                return true;
            case NikonType2MakernoteDirectory.TAG_EXPOSURE_SEQUENCE_NUMBER /* 167 */:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.x) {
                    this.a.aM(Integer.valueOf(this.b.b(viewG, (com.google.android.libraries.navigation.internal.nc.x) obj)), viewG);
                    return true;
                }
                if (obj instanceof Number) {
                    this.a.aM(Integer.valueOf(this.b.o((Number) obj)), viewG);
                    return true;
                }
                if (obj != null) {
                    return false;
                }
                this.b.v(null);
                this.a.aM(null, viewG);
                return true;
            case 168:
                if (!(viewG instanceof ViewAnimator)) {
                    return false;
                }
                if ((obj instanceof com.google.android.libraries.navigation.internal.nc.k) && (animationN2 = this.b.n(viewG, (com.google.android.libraries.navigation.internal.nc.k) obj)) != null) {
                    ((ViewAnimator) viewG).setOutAnimation(animationN2);
                    return true;
                }
                if (!(obj instanceof Animation)) {
                    return false;
                }
                ((ViewAnimator) viewG).setOutAnimation((Animation) obj);
                return true;
            case 169:
                if (!(viewG instanceof View) || !(obj instanceof Integer)) {
                    return false;
                }
                viewG.setOverScrollMode(((Integer) obj).intValue());
                return true;
            case 170:
                if (!(viewG instanceof View) || !(obj instanceof Object[])) {
                    return false;
                }
                this.a.aN((Object[]) obj, viewG);
                return true;
            case 171:
                if (!(viewG instanceof View) || !(obj instanceof Object)) {
                    return false;
                }
                this.a.aO(obj, viewG);
                return true;
            case NikonType2MakernoteDirectory.TAG_IMAGE_STABILISATION /* 172 */:
                if (!(viewG instanceof View) || !(obj instanceof Object)) {
                    return false;
                }
                this.a.aP(obj, viewG);
                return true;
            case NikonType2MakernoteDirectory.TAG_AF_RESPONSE /* 173 */:
                if (!(viewG instanceof View) || !(obj instanceof Object)) {
                    return false;
                }
                this.a.aQ(obj, viewG);
                return true;
            case 174:
                if (!(viewG instanceof View) || !(obj instanceof Object)) {
                    return false;
                }
                this.a.aR(obj, viewG);
                return true;
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_30 /* 175 */:
                if (!(viewG instanceof View) || !(obj instanceof Object)) {
                    return false;
                }
                this.a.aS(obj, viewG);
                return true;
            case 176:
                if (!(viewG instanceof View) || !(obj instanceof Object)) {
                    return false;
                }
                this.a.aT(obj, viewG);
                return true;
            case 177:
                if (!(viewG instanceof TextView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((TextView) viewG).setPaintFlags(((Integer) obj).intValue());
                return true;
            case 178:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    viewG.setPivotX(this.b.a(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj));
                    return true;
                }
                if (!(obj instanceof Number)) {
                    return false;
                }
                viewG.setPivotX(this.b.q((Number) obj));
                return true;
            case 179:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    viewG.setPivotY(this.b.a(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj));
                    return true;
                }
                if (!(obj instanceof Number)) {
                    return false;
                }
                viewG.setPivotY(this.b.q((Number) obj));
                return true;
            case 180:
                if (!(viewG instanceof VideoView) || !(obj instanceof Boolean)) {
                    return false;
                }
                this.a.aU((Boolean) obj, (VideoView) viewG);
                return true;
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_48 /* 181 */:
                if (!(viewG instanceof ProgressBar) || !(obj instanceof Integer)) {
                    return false;
                }
                ((ProgressBar) viewG).setProgress(((Integer) obj).intValue());
                return true;
            case 182:
                if (!(viewG instanceof ProgressBar)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        ((ProgressBar) viewG).setProgressDrawable(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj));
                        return true;
                    }
                    if (obj instanceof Picture) {
                        ((ProgressBar) viewG).setProgressDrawable(this.b.i(viewG, (Picture) obj));
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    ((ProgressBar) viewG).setProgressDrawable(this.b.h(viewG, ((Integer) obj).intValue()));
                    return true;
                }
                ((ProgressBar) viewG).setProgressDrawable(this.b.j(viewG, (Drawable) obj));
                return true;
            case NikonType2MakernoteDirectory.TAG_AF_INFO_2 /* 183 */:
                if (!(viewG instanceof SwipeRefreshLayout)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof com.google.android.libraries.navigation.internal.nc.ap)) {
                    return false;
                }
                this.a.aV((com.google.android.libraries.navigation.internal.nc.ap) obj, (SwipeRefreshLayout) viewG);
                return true;
            case NikonType2MakernoteDirectory.TAG_FILE_INFO /* 184 */:
                if (!(viewG instanceof SwipeRefreshLayout) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((SwipeRefreshLayout) viewG).setRefreshing(((Boolean) obj).booleanValue());
                return true;
            case NikonType2MakernoteDirectory.TAG_AF_TUNE /* 185 */:
                if (!(viewG instanceof View) || !(obj instanceof ca)) {
                    return false;
                }
                this.a.aW((ca) obj, viewG);
                return true;
            case 186:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Boolean)) {
                    return false;
                }
                this.a.aX((Boolean) obj, viewG);
                return true;
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_49 /* 187 */:
                if (!(viewG instanceof View) || !(obj instanceof Float)) {
                    return false;
                }
                viewG.setRotation(((Float) obj).floatValue());
                return true;
            case 188:
                if (!(viewG instanceof GridLayout) || !(obj instanceof Integer)) {
                    return false;
                }
                ((GridLayout) viewG).setRowCount(((Integer) obj).intValue());
                return true;
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_50 /* 189 */:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setSaveEnabled(((Boolean) obj).booleanValue());
                return true;
            case 190:
                if (!(viewG instanceof ImageView) || !(obj instanceof ImageView.ScaleType)) {
                    return false;
                }
                ((ImageView) viewG).setScaleType((ImageView.ScaleType) obj);
                return true;
            case 191:
                if (!(viewG instanceof View) || !(obj instanceof Float)) {
                    return false;
                }
                viewG.setScaleX(((Float) obj).floatValue());
                return true;
            case JfifUtil.MARKER_SOFn /* 192 */:
                if (!(viewG instanceof View) || !(obj instanceof Float)) {
                    return false;
                }
                viewG.setScaleY(((Float) obj).floatValue());
                return true;
            case 193:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                this.a.aZ(((Boolean) obj).booleanValue(), viewG);
                return true;
            case 194:
                if (!(viewG instanceof View) || !(obj instanceof Integer)) {
                    return false;
                }
                viewG.setScrollBarStyle(((Integer) obj).intValue());
                return true;
            case 195:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                this.a.ba(((Boolean) obj).booleanValue(), viewG);
                return true;
            case 196:
                if (!(viewG instanceof ProgressBar) || !(obj instanceof Integer)) {
                    return false;
                }
                ((ProgressBar) viewG).setSecondaryProgress(((Integer) obj).intValue());
                return true;
            case 197:
                if (!(viewG instanceof VideoView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Integer)) {
                    return false;
                }
                this.a.bb((Integer) obj, (VideoView) viewG);
                return true;
            case 198:
                if (!(viewG instanceof TextView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((TextView) viewG).setSelectAllOnFocus(((Boolean) obj).booleanValue());
                return true;
            case 199:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setSelected(((Boolean) obj).booleanValue());
                return true;
            case 200:
                if ((viewG instanceof AdapterView) && (obj instanceof Integer)) {
                    ((AdapterView) viewG).setSelection(((Integer) obj).intValue());
                    return true;
                }
                if (!(viewG instanceof EditText) || !(obj instanceof Integer)) {
                    return false;
                }
                ((EditText) viewG).setSelection(((Integer) obj).intValue());
                return true;
            case 201:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.x) {
                    this.a.bc(this.b.b(viewG, (com.google.android.libraries.navigation.internal.nc.x) obj), (TextView) viewG);
                    return true;
                }
                if (obj instanceof Number) {
                    this.a.bc(this.b.o((Number) obj), (TextView) viewG);
                    return true;
                }
                if (obj != null) {
                    return false;
                }
                this.b.v(null);
                return false;
            case 202:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.bd(this.b.a(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), (TextView) viewG);
                    return true;
                }
                if (!(obj instanceof Number)) {
                    return false;
                }
                this.a.bd(this.b.q((Number) obj), (TextView) viewG);
                return true;
            case 203:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.be(this.b.a(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), (TextView) viewG);
                    return true;
                }
                if (!(obj instanceof Number)) {
                    return false;
                }
                this.a.be(this.b.q((Number) obj), (TextView) viewG);
                return true;
            case 204:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.bf(this.b.a(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), (TextView) viewG);
                    return true;
                }
                if (!(obj instanceof Number)) {
                    return false;
                }
                this.a.bf(this.b.q((Number) obj), (TextView) viewG);
                return true;
            case 205:
                if (!(viewG instanceof LinearLayout) || !(obj instanceof Integer)) {
                    return false;
                }
                ((LinearLayout) viewG).setShowDividers(((Integer) obj).intValue());
                return true;
            case 206:
                if (!(viewG instanceof TextView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((TextView) viewG).setShowSoftInputOnFocus(((Boolean) obj).booleanValue());
                return true;
            case 207:
                if (!(viewG instanceof TableLayout) || !(obj instanceof Integer[])) {
                    return false;
                }
                this.a.bg((Integer[]) obj, (TableLayout) viewG);
                return true;
            case 208:
                if (!(viewG instanceof TextView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((TextView) viewG).setSingleLine(((Boolean) obj).booleanValue());
                return true;
            case Mp4VideoDirectory.TAG_DEPTH /* 209 */:
                if (!(viewG instanceof ImageView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof Drawable)) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                        ((ImageView) viewG).setImageDrawable(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj));
                        return true;
                    }
                    if (obj instanceof Picture) {
                        ((ImageView) viewG).setImageDrawable(this.b.i(viewG, (Picture) obj));
                        return true;
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    ((ImageView) viewG).setImageDrawable(this.b.h(viewG, ((Integer) obj).intValue()));
                    return true;
                }
                ((ImageView) viewG).setImageDrawable(this.b.j(viewG, (Drawable) obj));
                return true;
            case Mp4VideoDirectory.TAG_COMPRESSION_TYPE /* 210 */:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                }
                return this.a.h(obj, viewG);
            case Mp4VideoDirectory.TAG_GRAPHICS_MODE /* 211 */:
                if (!(viewG instanceof TableLayout) || !(obj instanceof Integer[])) {
                    return false;
                }
                this.a.bh((Integer[]) obj, (TableLayout) viewG);
                return true;
            case Mp4VideoDirectory.TAG_OPCOLOR /* 212 */:
                if (!(viewG instanceof GridView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((GridView) viewG).setStretchMode(((Integer) obj).intValue());
                return true;
            case Mp4VideoDirectory.TAG_FRAME_RATE /* 214 */:
                if (viewG instanceof TextView) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.t) {
                        this.a.bi(this.b.m(viewG, (com.google.android.libraries.navigation.internal.nc.t) obj), (TextView) viewG);
                        return true;
                    }
                    if (obj instanceof Integer) {
                        this.a.bi(this.b.l(viewG, ((Integer) obj).intValue()), (TextView) viewG);
                        return true;
                    }
                    if (obj != null) {
                        break;
                    } else {
                        obj = null;
                    }
                    this.a.bi((CharSequence) obj, (TextView) viewG);
                    return true;
                }
                if (!(viewG instanceof TextSwitcher)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.t) {
                    ((TextSwitcher) viewG).setText(this.b.m(viewG, (com.google.android.libraries.navigation.internal.nc.t) obj));
                    return true;
                }
                if (obj instanceof Integer) {
                    ((TextSwitcher) viewG).setText(this.b.l(viewG, ((Integer) obj).intValue()));
                    return true;
                }
                if (obj != null && !(obj instanceof CharSequence)) {
                    return false;
                }
                ((TextSwitcher) viewG).setText((CharSequence) obj);
                return true;
            case JfifUtil.MARKER_RST7 /* 215 */:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof ac)) {
                    return false;
                }
                this.a.bj((ac) obj, (TextView) viewG);
                return true;
            case JfifUtil.MARKER_SOI /* 216 */:
                return (viewG instanceof View) && (obj instanceof Integer) && this.a.i(((Integer) obj).intValue(), viewG);
            case JfifUtil.MARKER_EOI /* 217 */:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.t) {
                    this.a.bk(this.b.m(viewG, (com.google.android.libraries.navigation.internal.nc.t) obj), (TextView) viewG);
                    return true;
                }
                if (obj instanceof Integer) {
                    this.a.bk(this.b.l(viewG, ((Integer) obj).intValue()), (TextView) viewG);
                    return true;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof CharSequence)) {
                    return false;
                }
                this.a.bk((CharSequence) obj, (TextView) viewG);
                return true;
            case JfifUtil.MARKER_SOS /* 218 */:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof Integer) {
                    this.a.bl(((Integer) obj).intValue(), (TextView) viewG);
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                this.a.bm((b) obj, (TextView) viewG);
                return true;
            case 219:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj != null) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.x) {
                    }
                    if (!(obj instanceof Number) && (colorStateListP = this.b.p((Number) obj)) != null) {
                        ((TextView) viewG).setTextColor(colorStateListP);
                        return true;
                    }
                    if (obj instanceof ColorStateList) {
                        return false;
                    }
                    ((TextView) viewG).setTextColor((ColorStateList) obj);
                    return true;
                }
                obj = null;
                ColorStateList colorStateListG = this.b.g(viewG, (com.google.android.libraries.navigation.internal.nc.x) obj);
                if (colorStateListG != null) {
                    ((TextView) viewG).setTextColor(colorStateListG);
                    return true;
                }
                if (!(obj instanceof Number)) {
                }
                if (obj instanceof ColorStateList) {
                    return false;
                }
                ((TextView) viewG).setTextColor((ColorStateList) obj);
                return true;
            case 220:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj != null) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.x) {
                    }
                    if (!(obj instanceof Number) && (colorStateListP2 = this.b.p((Number) obj)) != null) {
                        ((TextView) viewG).setHintTextColor(colorStateListP2);
                        return true;
                    }
                    if (obj instanceof ColorStateList) {
                        return false;
                    }
                    ((TextView) viewG).setHintTextColor((ColorStateList) obj);
                    return true;
                }
                obj = null;
                ColorStateList colorStateListG2 = this.b.g(viewG, (com.google.android.libraries.navigation.internal.nc.x) obj);
                if (colorStateListG2 != null) {
                    ((TextView) viewG).setHintTextColor(colorStateListG2);
                    return true;
                }
                if (!(obj instanceof Number)) {
                }
                if (obj instanceof ColorStateList) {
                    return false;
                }
                ((TextView) viewG).setHintTextColor((ColorStateList) obj);
                return true;
            case 221:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj != null) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.x) {
                    }
                    if (!(obj instanceof Number) && (colorStateListP3 = this.b.p((Number) obj)) != null) {
                        ((TextView) viewG).setLinkTextColor(colorStateListP3);
                        return true;
                    }
                    if (obj instanceof ColorStateList) {
                        return false;
                    }
                    ((TextView) viewG).setLinkTextColor((ColorStateList) obj);
                    return true;
                }
                obj = null;
                ColorStateList colorStateListG3 = this.b.g(viewG, (com.google.android.libraries.navigation.internal.nc.x) obj);
                if (colorStateListG3 != null) {
                    ((TextView) viewG).setLinkTextColor(colorStateListG3);
                    return true;
                }
                if (!(obj instanceof Number)) {
                }
                if (obj instanceof ColorStateList) {
                    return false;
                }
                ((TextView) viewG).setLinkTextColor((ColorStateList) obj);
                return true;
            case 222:
                if (!(viewG instanceof View) || !(obj instanceof Integer)) {
                    return false;
                }
                this.a.bn(((Integer) obj).intValue(), viewG);
                return true;
            case 223:
                if (!(viewG instanceof TextView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((TextView) viewG).setTextIsSelectable(((Boolean) obj).booleanValue());
                return true;
            case CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY /* 224 */:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.t) {
                    this.a.bo(this.b.m(viewG, (com.google.android.libraries.navigation.internal.nc.t) obj), (TextView) viewG);
                    return true;
                }
                if (obj instanceof Integer) {
                    this.a.bo(this.b.l(viewG, ((Integer) obj).intValue()), (TextView) viewG);
                    return true;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof CharSequence)) {
                    return false;
                }
                this.a.bo((CharSequence) obj, (TextView) viewG);
                return true;
            case JfifUtil.MARKER_APP1 /* 225 */:
                if (viewG instanceof ToggleButton) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.t) {
                        this.a.bp(this.b.m(viewG, (com.google.android.libraries.navigation.internal.nc.t) obj), (ToggleButton) viewG);
                        return true;
                    }
                    if (obj instanceof Integer) {
                        this.a.bp(this.b.l(viewG, ((Integer) obj).intValue()), (ToggleButton) viewG);
                        return true;
                    }
                    if (obj != null) {
                        break;
                    } else {
                        obj = null;
                    }
                    this.a.bp((CharSequence) obj, (ToggleButton) viewG);
                    return true;
                }
                if (!(viewG instanceof Switch)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.t) {
                    ((Switch) viewG).setTextOff(this.b.m(viewG, (com.google.android.libraries.navigation.internal.nc.t) obj));
                    return true;
                }
                if (obj instanceof Integer) {
                    ((Switch) viewG).setTextOff(this.b.l(viewG, ((Integer) obj).intValue()));
                    return true;
                }
                if (obj != null && !(obj instanceof CharSequence)) {
                    return false;
                }
                ((Switch) viewG).setTextOff((CharSequence) obj);
                return true;
            case 226:
                if (viewG instanceof ToggleButton) {
                    if (obj instanceof com.google.android.libraries.navigation.internal.nc.t) {
                        this.a.bq(this.b.m(viewG, (com.google.android.libraries.navigation.internal.nc.t) obj), (ToggleButton) viewG);
                        return true;
                    }
                    if (obj instanceof Integer) {
                        this.a.bq(this.b.l(viewG, ((Integer) obj).intValue()), (ToggleButton) viewG);
                        return true;
                    }
                    if (obj != null) {
                        break;
                    } else {
                        obj = null;
                    }
                    this.a.bq((CharSequence) obj, (ToggleButton) viewG);
                    return true;
                }
                if (!(viewG instanceof Switch)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.t) {
                    ((Switch) viewG).setTextOn(this.b.m(viewG, (com.google.android.libraries.navigation.internal.nc.t) obj));
                    return true;
                }
                if (obj instanceof Integer) {
                    ((Switch) viewG).setTextOn(this.b.l(viewG, ((Integer) obj).intValue()));
                    return true;
                }
                if (obj != null && !(obj instanceof CharSequence)) {
                    return false;
                }
                ((Switch) viewG).setTextOn((CharSequence) obj);
                return true;
            case 227:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.br(this.b.a(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj), (TextView) viewG);
                    return true;
                }
                if (!(obj instanceof Number)) {
                    return false;
                }
                this.a.br(this.b.q((Number) obj), (TextView) viewG);
                return true;
            case 228:
                if (!(viewG instanceof TextView) || !(obj instanceof Integer)) {
                    return false;
                }
                this.a.bs(((Integer) obj).intValue(), (TextView) viewG);
                return true;
            case 229:
                if (!(viewG instanceof TextView) || !(obj instanceof com.google.android.libraries.navigation.internal.nc.bh)) {
                    return false;
                }
                this.a.bt((com.google.android.libraries.navigation.internal.nc.bh) obj, (TextView) viewG);
                return true;
            case 230:
                if (viewG instanceof AbsSeekBar) {
                    if (obj == null) {
                        obj = null;
                    } else if (!(obj instanceof Drawable)) {
                        if (obj instanceof com.google.android.libraries.navigation.internal.nc.ah) {
                            this.a.bu(this.b.k(viewG, (com.google.android.libraries.navigation.internal.nc.ah) obj), (AbsSeekBar) viewG);
                            return true;
                        }
                        if (obj instanceof Picture) {
                            this.a.bu(this.b.i(viewG, (Picture) obj), (AbsSeekBar) viewG);
                            return true;
                        }
                        if (obj instanceof Integer) {
                            this.a.bu(this.b.h(viewG, ((Integer) obj).intValue()), (AbsSeekBar) viewG);
                            return true;
                        }
                    }
                    this.a.bu(this.b.j(viewG, (Drawable) obj), (AbsSeekBar) viewG);
                    return true;
                }
                return (viewG instanceof Switch) && this.a.j(obj, (Switch) viewG);
            case 231:
                if (!(viewG instanceof ImageView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.x) {
                    this.a.bv(Integer.valueOf(this.b.b(viewG, (com.google.android.libraries.navigation.internal.nc.x) obj)), (ImageView) viewG);
                    return true;
                }
                if (obj instanceof Number) {
                    this.a.bv(Integer.valueOf(this.b.o((Number) obj)), (ImageView) viewG);
                    return true;
                }
                if (obj != null) {
                    return false;
                }
                this.b.v(null);
                this.a.bv(null, (ImageView) viewG);
                return true;
            case 232:
                if (!(viewG instanceof ImageView)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.x) {
                    this.a.bw(Integer.valueOf(this.b.b(viewG, (com.google.android.libraries.navigation.internal.nc.x) obj)), (ImageView) viewG);
                    return true;
                }
                if (obj instanceof Number) {
                    this.a.bw(Integer.valueOf(this.b.o((Number) obj)), (ImageView) viewG);
                    return true;
                }
                if (obj != null) {
                    return false;
                }
                this.b.v(null);
                this.a.bw(null, (ImageView) viewG);
                return true;
            case 233:
                if (!(viewG instanceof TextView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof TransformationMethod)) {
                    return false;
                }
                ((TextView) viewG).setTransformationMethod((TransformationMethod) obj);
                return true;
            case 234:
                if (!(viewG instanceof View) || !(obj instanceof String)) {
                    return false;
                }
                this.a.bx((String) obj, viewG);
                return true;
            case 235:
                if (!(viewG instanceof View)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    this.a.by((com.google.android.libraries.navigation.internal.nc.ap) obj, viewG);
                    return true;
                }
                if (!(obj instanceof Number)) {
                    return false;
                }
                this.a.bz((Number) obj, viewG);
                return true;
            case 236:
                return (viewG instanceof View) && (obj instanceof Object) && this.a.k(obj, viewG);
            case 237:
                return (viewG instanceof View) && (obj instanceof Object) && this.a.l(obj, viewG);
            case 238:
                if (!(viewG instanceof NumberPicker) || !(obj instanceof Integer)) {
                    return false;
                }
                ((NumberPicker) viewG).setValue(((Integer) obj).intValue());
                return true;
            case 239:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setVerticalFadingEdgeEnabled(((Boolean) obj).booleanValue());
                return true;
            case 240:
                if (!(viewG instanceof View) || !(obj instanceof Boolean)) {
                    return false;
                }
                viewG.setVerticalScrollBarEnabled(((Boolean) obj).booleanValue());
                return true;
            case 241:
                if (!(viewG instanceof GridView) || !(obj instanceof Integer)) {
                    return false;
                }
                ((GridView) viewG).setVerticalSpacing(((Integer) obj).intValue());
                return true;
            case 242:
                if (!(viewG instanceof VideoView) || !(obj instanceof String)) {
                    return false;
                }
                ((VideoView) viewG).setVideoPath((String) obj);
                return true;
            case 243:
                if (!(viewG instanceof VideoView) || !(obj instanceof Uri)) {
                    return false;
                }
                ((VideoView) viewG).setVideoURI((Uri) obj);
                return true;
            case 244:
                if (!(viewG instanceof ViewPager)) {
                    return false;
                }
                if (obj instanceof bt) {
                    this.a.bB((bt) obj, (ViewPager) viewG);
                    return true;
                }
                if (!(obj instanceof PagerAdapter)) {
                    return false;
                }
                this.a.bA((PagerAdapter) obj, (ViewPager) viewG);
                return true;
            case 245:
                if (!(viewG instanceof ViewPager) || !(obj instanceof Integer)) {
                    return false;
                }
                ((ViewPager) viewG).setCurrentItem(((Integer) obj).intValue());
                return true;
            case 246:
                if (!(viewG instanceof ViewPager)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof List)) {
                    return false;
                }
                this.a.bC((List) obj, (ViewPager) viewG);
                return true;
            case 247:
                if (!(viewG instanceof ViewPager) || !(obj instanceof Integer)) {
                    return false;
                }
                ((ViewPager) viewG).setOffscreenPageLimit(((Integer) obj).intValue());
                return true;
            case 248:
                if (!(viewG instanceof ViewPager)) {
                    return false;
                }
                if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                    ((ViewPager) viewG).setPageMargin(this.b.c(viewG, (com.google.android.libraries.navigation.internal.nc.ap) obj));
                    return true;
                }
                if (!(obj instanceof Integer)) {
                    return false;
                }
                ((ViewPager) viewG).setPageMargin(this.b.r((Integer) obj));
                return true;
            case 249:
                if (!(viewG instanceof ViewPager)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof ViewPager.PageTransformer)) {
                    return false;
                }
                this.a.bD((ViewPager.PageTransformer) obj, (ViewPager) viewG);
                return true;
            case 250:
                if (!(viewG instanceof View) || !(obj instanceof Integer)) {
                    return false;
                }
                viewG.setVisibility(((Integer) obj).intValue());
                return true;
            case 251:
                if (!(viewG instanceof WebView) || !(obj instanceof WebViewClient)) {
                    return false;
                }
                ((WebView) viewG).setWebViewClient((WebViewClient) obj);
                return true;
            case 252:
                if (!(viewG instanceof WebView) || !(obj instanceof String)) {
                    return false;
                }
                this.a.bE((String) obj, (WebView) viewG);
                return true;
            case 253:
                if (!(viewG instanceof WebView) || !(obj instanceof String)) {
                    return false;
                }
                ((WebView) viewG).loadUrl((String) obj);
                return true;
            case ExifDirectoryBase.TAG_NEW_SUBFILE_TYPE /* 254 */:
                if (!(viewG instanceof LinearLayout) || !(obj instanceof Float)) {
                    return false;
                }
                ((LinearLayout) viewG).setWeightSum(((Float) obj).floatValue());
                return true;
            case 255:
                if (!(viewG instanceof NumberPicker) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((NumberPicker) viewG).setWrapSelectorWheel(((Boolean) obj).booleanValue());
                return true;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean b(cw cwVar, ck ckVar) {
        if (!(cwVar instanceof e)) {
            return false;
        }
        View view = ckVar.c;
        int iOrdinal = ((e) cwVar).ordinal();
        if (iOrdinal == 114) {
            if (view instanceof ListView) {
                ((ListView) view).setAdapter((ListAdapter) null);
                return true;
            }
            if (view instanceof GridView) {
                ((GridView) view).setAdapter((ListAdapter) null);
                return true;
            }
            if (view instanceof AutoCompleteTextView) {
                ((AutoCompleteTextView) view).setAdapter(null);
                return true;
            }
            if (view instanceof ViewPager) {
                ((ViewPager) view).setAdapter(null);
                return true;
            }
            if (!(view instanceof ViewGroup)) {
                return false;
            }
            m.d((ViewGroup) view);
            return true;
        }
        if (iOrdinal == 144) {
            if (!(view instanceof TextView)) {
                return false;
            }
            this.a.aA(null, (TextView) view);
            return true;
        }
        if (iOrdinal == 246) {
            if (!(view instanceof ViewPager)) {
                return false;
            }
            com.google.android.libraries.navigation.internal.mt.b bVar = (com.google.android.libraries.navigation.internal.mt.b) ((ViewPager) view).getAdapter();
            if (bVar != null) {
                bVar.b(null);
            }
            return true;
        }
        if (iOrdinal == 249) {
            if (!(view instanceof ViewPager)) {
                return false;
            }
            this.a.bD(null, (ViewPager) view);
            return true;
        }
        if (iOrdinal == 139) {
            if (!(view instanceof View)) {
                return false;
            }
            m.c(view);
            return true;
        }
        if (iOrdinal == 140) {
            return (view instanceof View) && this.a.g(null, view);
        }
        if (iOrdinal == 150) {
            if (!(view instanceof View)) {
                return false;
            }
            this.a.aD(null, view);
            return true;
        }
        if (iOrdinal == 151) {
            if (!(view instanceof View)) {
                return false;
            }
            this.a.aE(view);
            return true;
        }
        if (iOrdinal == 153) {
            if (!(view instanceof View)) {
                return false;
            }
            this.a.aF(null, view, ckVar);
            return true;
        }
        if (iOrdinal == 154) {
            if (!(view instanceof View)) {
                return false;
            }
            this.a.aG(null, view, ckVar);
            return true;
        }
        if (iOrdinal == 156) {
            if (!(view instanceof RadioGroup)) {
                return false;
            }
            ((RadioGroup) view).setOnCheckedChangeListener(null);
            return true;
        }
        if (iOrdinal == 157) {
            if (!(view instanceof SwipeRefreshLayout)) {
                return false;
            }
            ((SwipeRefreshLayout) view).setOnRefreshListener(null);
            return true;
        }
        switch (iOrdinal) {
            case 160:
                if (!(view instanceof TextView)) {
                    return false;
                }
                this.a.aI(null, (TextView) view, ckVar);
                return true;
            case CanonMakernoteDirectory.TAG_TONE_CURVE_TABLE /* 161 */:
                if (!(view instanceof TimePicker)) {
                    return false;
                }
                ((TimePicker) view).setOnTimeChangedListener(null);
                return true;
            case 162:
                if (!(view instanceof View)) {
                    return false;
                }
                this.a.aK(null, view);
                return true;
            default:
                return false;
        }
    }
}
