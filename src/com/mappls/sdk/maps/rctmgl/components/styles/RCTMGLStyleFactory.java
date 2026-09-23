package com.mappls.sdk.maps.rctmgl.components.styles;

import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.henninghall.date_picker.props.TextColorProp;
import com.mappls.sdk.maps.rctmgl.utils.DownloadMapImageTask;
import com.mappls.sdk.maps.style.layers.BackgroundLayer;
import com.mappls.sdk.maps.style.layers.CircleLayer;
import com.mappls.sdk.maps.style.layers.FillExtrusionLayer;
import com.mappls.sdk.maps.style.layers.FillLayer;
import com.mappls.sdk.maps.style.layers.HeatmapLayer;
import com.mappls.sdk.maps.style.layers.HillshadeLayer;
import com.mappls.sdk.maps.style.layers.LineLayer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.RasterLayer;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.style.layers.TransitionOptions;
import com.mappls.sdk.maps.style.light.Light;
import com.mappls.sdk.maps.style.light.Position;
import java.util.List;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLStyleFactory {
    public static final String SHOULD_ADD_IMAGE_KEY = "shouldAddImage";
    public static final String VALUE_KEY = "value";

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void setFillLayerStyle(final FillLayer fillLayer, RCTMGLStyle rCTMGLStyle) {
        List<String> allStyleKeys = rCTMGLStyle.getAllStyleKeys();
        if (allStyleKeys.size() == 0) {
            return;
        }
        for (String str : allStyleKeys) {
            final RCTMGLStyleValue styleValueForKey = rCTMGLStyle.getStyleValueForKey(str);
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -1984592619:
                    if (str.equals("fillColorTransition")) {
                        b = 0;
                    }
                    break;
                case -1730029888:
                    if (str.equals("fillTranslateTransition")) {
                        b = 1;
                    }
                    break;
                case -1635251751:
                    if (str.equals("fillOutlineColorTransition")) {
                        b = 2;
                    }
                    break;
                case -1141881952:
                    if (str.equals("fillColor")) {
                        b = 3;
                    }
                    break;
                case -977559797:
                    if (str.equals("fillTranslate")) {
                        b = 4;
                    }
                    break;
                case -53677816:
                    if (str.equals("fillOpacity")) {
                        b = 5;
                    }
                    break;
                case 103064002:
                    if (str.equals("fillPatternTransition")) {
                        b = 6;
                    }
                    break;
                case 122984864:
                    if (str.equals("fillTranslateAnchor")) {
                        b = 7;
                    }
                    break;
                case 145968619:
                    if (str.equals("fillAntialias")) {
                        b = 8;
                    }
                    break;
                case 422438029:
                    if (str.equals("fillPattern")) {
                        b = 9;
                    }
                    break;
                case 1425616228:
                    if (str.equals("fillOutlineColor")) {
                        b = 10;
                    }
                    break;
                case 1900449917:
                    if (str.equals("fillOpacityTransition")) {
                        b = Ascii.VT;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        b = Ascii.FF;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    setFillColorTransition(fillLayer, styleValueForKey);
                    break;
                case 1:
                    setFillTranslateTransition(fillLayer, styleValueForKey);
                    break;
                case 2:
                    setFillOutlineColorTransition(fillLayer, styleValueForKey);
                    break;
                case 3:
                    setFillColor(fillLayer, styleValueForKey);
                    break;
                case 4:
                    setFillTranslate(fillLayer, styleValueForKey);
                    break;
                case 5:
                    setFillOpacity(fillLayer, styleValueForKey);
                    break;
                case 6:
                    setFillPatternTransition(fillLayer, styleValueForKey);
                    break;
                case 7:
                    setFillTranslateAnchor(fillLayer, styleValueForKey);
                    break;
                case 8:
                    setFillAntialias(fillLayer, styleValueForKey);
                    break;
                case 9:
                    rCTMGLStyle.addImage(styleValueForKey, new DownloadMapImageTask.OnAllImagesLoaded() { // from class: com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyleFactory.1
                        @Override // com.mappls.sdk.maps.rctmgl.utils.DownloadMapImageTask.OnAllImagesLoaded
                        public void onAllImagesLoaded() {
                            RCTMGLStyleFactory.setFillPattern(fillLayer, styleValueForKey);
                        }
                    });
                    break;
                case 10:
                    setFillOutlineColor(fillLayer, styleValueForKey);
                    break;
                case 11:
                    setFillOpacityTransition(fillLayer, styleValueForKey);
                    break;
                case 12:
                    setVisibility(fillLayer, styleValueForKey);
                    break;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void setLineLayerStyle(final LineLayer lineLayer, RCTMGLStyle rCTMGLStyle) {
        List<String> allStyleKeys = rCTMGLStyle.getAllStyleKeys();
        if (allStyleKeys.size() == 0) {
            return;
        }
        for (String str : allStyleKeys) {
            final RCTMGLStyleValue styleValueForKey = rCTMGLStyle.getStyleValueForKey(str);
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -1928202383:
                    if (str.equals("linePatternTransition")) {
                        b = 0;
                    }
                    break;
                case -1822070833:
                    if (str.equals("lineColor")) {
                        b = 1;
                    }
                    break;
                case -1803786702:
                    if (str.equals("lineWidth")) {
                        b = 2;
                    }
                    break;
                case -1762877983:
                    if (str.equals("lineRoundLimit")) {
                        b = 3;
                    }
                    break;
                case -1111871207:
                    if (str.equals("lineGapWidthTransition")) {
                        b = 4;
                    }
                    break;
                case -880163465:
                    if (str.equals("lineOpacity")) {
                        b = 5;
                    }
                    break;
                case -796928188:
                    if (str.equals("lineGradient")) {
                        b = 6;
                    }
                    break;
                case -771065212:
                    if (str.equals("lineColorTransition")) {
                        b = 7;
                    }
                    break;
                case -661318726:
                    if (str.equals("lineTranslate")) {
                        b = 8;
                    }
                    break;
                case -404047620:
                    if (str.equals("linePattern")) {
                        b = 9;
                    }
                    break;
                case -314558041:
                    if (str.equals("lineOffset")) {
                        b = 10;
                    }
                    break;
                case -130816468:
                    if (str.equals("lineOpacityTransition")) {
                        b = Ascii.VT;
                    }
                    break;
                case 176874302:
                    if (str.equals("lineCap")) {
                        b = Ascii.FF;
                    }
                    break;
                case 433093807:
                    if (str.equals("lineTranslateTransition")) {
                        b = Ascii.CR;
                    }
                    break;
                case 536864304:
                    if (str.equals("lineBlurTransition")) {
                        b = Ascii.SO;
                    }
                    break;
                case 734880970:
                    if (str.equals("lineMiterLimit")) {
                        b = Ascii.SI;
                    }
                    break;
                case 1188117115:
                    if (str.equals("lineBlur")) {
                        b = Ascii.DLE;
                    }
                    break;
                case 1188357950:
                    if (str.equals("lineJoin")) {
                        b = 17;
                    }
                    break;
                case 1336512271:
                    if (str.equals("lineTranslateAnchor")) {
                        b = Ascii.DC2;
                    }
                    break;
                case 1532137587:
                    if (str.equals("lineDasharray")) {
                        b = 19;
                    }
                    break;
                case 1712809124:
                    if (str.equals("lineGapWidth")) {
                        b = Ascii.DC4;
                    }
                    break;
                case 1835866407:
                    if (str.equals("lineWidthTransition")) {
                        b = Ascii.NAK;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        b = Ascii.SYN;
                    }
                    break;
                case 1948788264:
                    if (str.equals("lineDasharrayTransition")) {
                        b = Ascii.ETB;
                    }
                    break;
                case 2051726940:
                    if (str.equals("lineOffsetTransition")) {
                        b = Ascii.CAN;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    setLinePatternTransition(lineLayer, styleValueForKey);
                    break;
                case 1:
                    setLineColor(lineLayer, styleValueForKey);
                    break;
                case 2:
                    setLineWidth(lineLayer, styleValueForKey);
                    break;
                case 3:
                    setLineRoundLimit(lineLayer, styleValueForKey);
                    break;
                case 4:
                    setLineGapWidthTransition(lineLayer, styleValueForKey);
                    break;
                case 5:
                    setLineOpacity(lineLayer, styleValueForKey);
                    break;
                case 6:
                    setLineGradient(lineLayer, styleValueForKey);
                    break;
                case 7:
                    setLineColorTransition(lineLayer, styleValueForKey);
                    break;
                case 8:
                    setLineTranslate(lineLayer, styleValueForKey);
                    break;
                case 9:
                    rCTMGLStyle.addImage(styleValueForKey, new DownloadMapImageTask.OnAllImagesLoaded() { // from class: com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyleFactory.2
                        @Override // com.mappls.sdk.maps.rctmgl.utils.DownloadMapImageTask.OnAllImagesLoaded
                        public void onAllImagesLoaded() {
                            RCTMGLStyleFactory.setLinePattern(lineLayer, styleValueForKey);
                        }
                    });
                    break;
                case 10:
                    setLineOffset(lineLayer, styleValueForKey);
                    break;
                case 11:
                    setLineOpacityTransition(lineLayer, styleValueForKey);
                    break;
                case 12:
                    setLineCap(lineLayer, styleValueForKey);
                    break;
                case 13:
                    setLineTranslateTransition(lineLayer, styleValueForKey);
                    break;
                case 14:
                    setLineBlurTransition(lineLayer, styleValueForKey);
                    break;
                case 15:
                    setLineMiterLimit(lineLayer, styleValueForKey);
                    break;
                case 16:
                    setLineBlur(lineLayer, styleValueForKey);
                    break;
                case 17:
                    setLineJoin(lineLayer, styleValueForKey);
                    break;
                case 18:
                    setLineTranslateAnchor(lineLayer, styleValueForKey);
                    break;
                case 19:
                    setLineDasharray(lineLayer, styleValueForKey);
                    break;
                case 20:
                    setLineGapWidth(lineLayer, styleValueForKey);
                    break;
                case 21:
                    setLineWidthTransition(lineLayer, styleValueForKey);
                    break;
                case 22:
                    setVisibility(lineLayer, styleValueForKey);
                    break;
                case 23:
                    setLineDasharrayTransition(lineLayer, styleValueForKey);
                    break;
                case 24:
                    setLineOffsetTransition(lineLayer, styleValueForKey);
                    break;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void setSymbolLayerStyle(final SymbolLayer symbolLayer, RCTMGLStyle rCTMGLStyle) {
        List<String> allStyleKeys = rCTMGLStyle.getAllStyleKeys();
        if (allStyleKeys.size() == 0) {
            return;
        }
        for (String str : allStyleKeys) {
            final RCTMGLStyleValue styleValueForKey = rCTMGLStyle.getStyleValueForKey(str);
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -2107142626:
                    if (str.equals("textOpacity")) {
                        b = 0;
                    }
                    break;
                case -2089418589:
                    if (str.equals("textJustify")) {
                        b = 1;
                    }
                    break;
                case -2057882389:
                    if (str.equals("iconTextFit")) {
                        b = 2;
                    }
                    break;
                case -1979070486:
                    if (str.equals("iconTranslateAnchor")) {
                        b = 3;
                    }
                    break;
                case -1958433749:
                    if (str.equals("textColorTransition")) {
                        b = 4;
                    }
                    break;
                case -1907226286:
                    if (str.equals("iconOpacity")) {
                        b = 5;
                    }
                    break;
                case -1879178031:
                    if (str.equals("iconHaloBlurTransition")) {
                        b = 6;
                    }
                    break;
                case -1862421794:
                    if (str.equals("textVariableAnchor")) {
                        b = 7;
                    }
                    break;
                case -1807506772:
                    if (str.equals("symbolZOrder")) {
                        b = 8;
                    }
                    break;
                case -1646276060:
                    if (str.equals("textPadding")) {
                        b = 9;
                    }
                    break;
                case -1480756154:
                    if (str.equals("textIgnorePlacement")) {
                        b = 10;
                    }
                    break;
                case -1446359720:
                    if (str.equals("iconPadding")) {
                        b = Ascii.VT;
                    }
                    break;
                case -1416436118:
                    if (str.equals("iconColor")) {
                        b = Ascii.FF;
                    }
                    break;
                case -1410965406:
                    if (str.equals("iconImage")) {
                        b = Ascii.CR;
                    }
                    break;
                case -1336804080:
                    if (str.equals("textLetterSpacing")) {
                        b = Ascii.SO;
                    }
                    break;
                case -1199109335:
                    if (str.equals("symbolSortKey")) {
                        b = Ascii.SI;
                    }
                    break;
                case -1186657397:
                    if (str.equals("symbolSpacing")) {
                        b = Ascii.DLE;
                    }
                    break;
                case -1158635046:
                    if (str.equals("textHaloColor")) {
                        b = 17;
                    }
                    break;
                case -1140350915:
                    if (str.equals("textHaloWidth")) {
                        b = Ascii.DC2;
                    }
                    break;
                case -1063571914:
                    if (str.equals(TextColorProp.name)) {
                        b = 19;
                    }
                    break;
                case -1060986931:
                    if (str.equals("textField")) {
                        b = Ascii.DC4;
                    }
                    break;
                case -1018303346:
                    if (str.equals("iconAnchor")) {
                        b = Ascii.NAK;
                    }
                    break;
                case -1004050660:
                    if (str.equals("textFont")) {
                        b = Ascii.SYN;
                    }
                    break;
                case -1003668786:
                    if (str.equals("textSize")) {
                        b = Ascii.ETB;
                    }
                    break;
                case -737956838:
                    if (str.equals("iconSize")) {
                        b = Ascii.CAN;
                    }
                    break;
                case -726538404:
                    if (str.equals("iconPitchAlignment")) {
                        b = Ascii.EM;
                    }
                    break;
                case -699323086:
                    if (str.equals("textWritingMode")) {
                        b = Ascii.SUB;
                    }
                    break;
                case -624783764:
                    if (str.equals("iconOffset")) {
                        b = Ascii.ESC;
                    }
                    break;
                case -584404152:
                    if (str.equals("textLineHeight")) {
                        b = Ascii.FS;
                    }
                    break;
                case -530184396:
                    if (str.equals("iconRotate")) {
                        b = Ascii.GS;
                    }
                    break;
                case -347244627:
                    if (str.equals("textOptional")) {
                        b = Ascii.RS;
                    }
                    break;
                case -314502384:
                    if (str.equals("textHaloBlur")) {
                        b = Ascii.US;
                    }
                    break;
                case -242244336:
                    if (str.equals("textPitchAlignment")) {
                        b = 32;
                    }
                    break;
                case -178346657:
                    if (str.equals("textRadialOffset")) {
                        b = 33;
                    }
                    break;
                case -171596660:
                    if (str.equals("iconRotationAlignment")) {
                        b = 34;
                    }
                    break;
                case -47001946:
                    if (str.equals("iconHaloWidthTransition")) {
                        b = 35;
                    }
                    break;
                case 111988252:
                    if (str.equals("textMaxAngle")) {
                        b = 36;
                    }
                    break;
                case 132154127:
                    if (str.equals("textMaxWidth")) {
                        b = 37;
                    }
                    break;
                case 149143734:
                    if (str.equals("textTranslateAnchor")) {
                        b = 38;
                    }
                    break;
                case 173788373:
                    if (str.equals("iconTranslate")) {
                        b = 39;
                    }
                    break;
                case 208319327:
                    if (str.equals("iconColorTransition")) {
                        b = 40;
                    }
                    break;
                case 428573042:
                    if (str.equals("textHaloWidthTransition")) {
                        b = 41;
                    }
                    break;
                case 459887687:
                    if (str.equals("iconOpacityTransition")) {
                        b = 42;
                    }
                    break;
                case 530941997:
                    if (str.equals("symbolPlacement")) {
                        b = 43;
                    }
                    break;
                case 637835864:
                    if (str.equals("textRotationAlignment")) {
                        b = 44;
                    }
                    break;
                case 638968459:
                    if (str.equals("textAllowOverlap")) {
                        b = 45;
                    }
                    break;
                case 685996922:
                    if (str.equals("iconIgnorePlacement")) {
                        b = 46;
                    }
                    break;
                case 879628003:
                    if (str.equals("iconKeepUpright")) {
                        b = 47;
                    }
                    break;
                case 926348697:
                    if (str.equals("symbolAvoidEdges")) {
                        b = 48;
                    }
                    break;
                case 960251863:
                    if (str.equals("iconAllowOverlap")) {
                        b = 49;
                    }
                    break;
                case 1164103690:
                    if (str.equals("iconTranslateTransition")) {
                        b = 50;
                    }
                    break;
                case 1269320211:
                    if (str.equals("textOpacityTransition")) {
                        b = 51;
                    }
                    break;
                case 1327548607:
                    if (str.equals(ReactBaseTextShadowNode.PROP_TEXT_TRANSFORM)) {
                        b = 52;
                    }
                    break;
                case 1327713953:
                    if (str.equals("textTranslate")) {
                        b = 53;
                    }
                    break;
                case 1330552386:
                    if (str.equals("textAnchor")) {
                        b = 54;
                    }
                    break;
                case 1555194617:
                    if (str.equals("iconOptional")) {
                        b = 55;
                    }
                    break;
                case 1587936860:
                    if (str.equals("iconHaloBlur")) {
                        b = 56;
                    }
                    break;
                case 1639678678:
                    if (str.equals("textTranslateTransition")) {
                        b = 57;
                    }
                    break;
                case 1641033731:
                    if (str.equals("iconHaloColorTransition")) {
                        b = 58;
                    }
                    break;
                case 1700548015:
                    if (str.equals("textKeepUpright")) {
                        b = 59;
                    }
                    break;
                case 1724071968:
                    if (str.equals("textOffset")) {
                        b = 60;
                    }
                    break;
                case 1724076198:
                    if (str.equals("iconTextFitPadding")) {
                        b = Base64.padSymbol;
                    }
                    break;
                case 1738393733:
                    if (str.equals("textHaloBlurTransition")) {
                        b = 62;
                    }
                    break;
                case 1818671336:
                    if (str.equals("textRotate")) {
                        b = Utf8.REPLACEMENT_BYTE;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        b = SignedBytes.MAX_POWER_OF_TWO;
                    }
                    break;
                case 1982406670:
                    if (str.equals("iconHaloColor")) {
                        b = 65;
                    }
                    break;
                case 2000690801:
                    if (str.equals("iconHaloWidth")) {
                        b = 66;
                    }
                    break;
                case 2116608719:
                    if (str.equals("textHaloColorTransition")) {
                        b = 67;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    setTextOpacity(symbolLayer, styleValueForKey);
                    break;
                case 1:
                    setTextJustify(symbolLayer, styleValueForKey);
                    break;
                case 2:
                    setIconTextFit(symbolLayer, styleValueForKey);
                    break;
                case 3:
                    setIconTranslateAnchor(symbolLayer, styleValueForKey);
                    break;
                case 4:
                    setTextColorTransition(symbolLayer, styleValueForKey);
                    break;
                case 5:
                    setIconOpacity(symbolLayer, styleValueForKey);
                    break;
                case 6:
                    setIconHaloBlurTransition(symbolLayer, styleValueForKey);
                    break;
                case 7:
                    setTextVariableAnchor(symbolLayer, styleValueForKey);
                    break;
                case 8:
                    setSymbolZOrder(symbolLayer, styleValueForKey);
                    break;
                case 9:
                    setTextPadding(symbolLayer, styleValueForKey);
                    break;
                case 10:
                    setTextIgnorePlacement(symbolLayer, styleValueForKey);
                    break;
                case 11:
                    setIconPadding(symbolLayer, styleValueForKey);
                    break;
                case 12:
                    setIconColor(symbolLayer, styleValueForKey);
                    break;
                case 13:
                    rCTMGLStyle.addImage(styleValueForKey, new DownloadMapImageTask.OnAllImagesLoaded() { // from class: com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyleFactory.3
                        @Override // com.mappls.sdk.maps.rctmgl.utils.DownloadMapImageTask.OnAllImagesLoaded
                        public void onAllImagesLoaded() {
                            RCTMGLStyleFactory.setIconImage(symbolLayer, styleValueForKey);
                        }
                    });
                    break;
                case 14:
                    setTextLetterSpacing(symbolLayer, styleValueForKey);
                    break;
                case 15:
                    setSymbolSortKey(symbolLayer, styleValueForKey);
                    break;
                case 16:
                    setSymbolSpacing(symbolLayer, styleValueForKey);
                    break;
                case 17:
                    setTextHaloColor(symbolLayer, styleValueForKey);
                    break;
                case 18:
                    setTextHaloWidth(symbolLayer, styleValueForKey);
                    break;
                case 19:
                    setTextColor(symbolLayer, styleValueForKey);
                    break;
                case 20:
                    setTextField(symbolLayer, styleValueForKey);
                    break;
                case 21:
                    setIconAnchor(symbolLayer, styleValueForKey);
                    break;
                case 22:
                    setTextFont(symbolLayer, styleValueForKey);
                    break;
                case 23:
                    setTextSize(symbolLayer, styleValueForKey);
                    break;
                case 24:
                    setIconSize(symbolLayer, styleValueForKey);
                    break;
                case 25:
                    setIconPitchAlignment(symbolLayer, styleValueForKey);
                    break;
                case 26:
                    setTextWritingMode(symbolLayer, styleValueForKey);
                    break;
                case 27:
                    setIconOffset(symbolLayer, styleValueForKey);
                    break;
                case 28:
                    setTextLineHeight(symbolLayer, styleValueForKey);
                    break;
                case 29:
                    setIconRotate(symbolLayer, styleValueForKey);
                    break;
                case 30:
                    setTextOptional(symbolLayer, styleValueForKey);
                    break;
                case 31:
                    setTextHaloBlur(symbolLayer, styleValueForKey);
                    break;
                case 32:
                    setTextPitchAlignment(symbolLayer, styleValueForKey);
                    break;
                case 33:
                    setTextRadialOffset(symbolLayer, styleValueForKey);
                    break;
                case 34:
                    setIconRotationAlignment(symbolLayer, styleValueForKey);
                    break;
                case 35:
                    setIconHaloWidthTransition(symbolLayer, styleValueForKey);
                    break;
                case 36:
                    setTextMaxAngle(symbolLayer, styleValueForKey);
                    break;
                case 37:
                    setTextMaxWidth(symbolLayer, styleValueForKey);
                    break;
                case 38:
                    setTextTranslateAnchor(symbolLayer, styleValueForKey);
                    break;
                case 39:
                    setIconTranslate(symbolLayer, styleValueForKey);
                    break;
                case 40:
                    setIconColorTransition(symbolLayer, styleValueForKey);
                    break;
                case 41:
                    setTextHaloWidthTransition(symbolLayer, styleValueForKey);
                    break;
                case 42:
                    setIconOpacityTransition(symbolLayer, styleValueForKey);
                    break;
                case 43:
                    setSymbolPlacement(symbolLayer, styleValueForKey);
                    break;
                case 44:
                    setTextRotationAlignment(symbolLayer, styleValueForKey);
                    break;
                case 45:
                    setTextAllowOverlap(symbolLayer, styleValueForKey);
                    break;
                case 46:
                    setIconIgnorePlacement(symbolLayer, styleValueForKey);
                    break;
                case 47:
                    setIconKeepUpright(symbolLayer, styleValueForKey);
                    break;
                case 48:
                    setSymbolAvoidEdges(symbolLayer, styleValueForKey);
                    break;
                case 49:
                    setIconAllowOverlap(symbolLayer, styleValueForKey);
                    break;
                case 50:
                    setIconTranslateTransition(symbolLayer, styleValueForKey);
                    break;
                case 51:
                    setTextOpacityTransition(symbolLayer, styleValueForKey);
                    break;
                case 52:
                    setTextTransform(symbolLayer, styleValueForKey);
                    break;
                case 53:
                    setTextTranslate(symbolLayer, styleValueForKey);
                    break;
                case 54:
                    setTextAnchor(symbolLayer, styleValueForKey);
                    break;
                case 55:
                    setIconOptional(symbolLayer, styleValueForKey);
                    break;
                case 56:
                    setIconHaloBlur(symbolLayer, styleValueForKey);
                    break;
                case 57:
                    setTextTranslateTransition(symbolLayer, styleValueForKey);
                    break;
                case 58:
                    setIconHaloColorTransition(symbolLayer, styleValueForKey);
                    break;
                case 59:
                    setTextKeepUpright(symbolLayer, styleValueForKey);
                    break;
                case 60:
                    setTextOffset(symbolLayer, styleValueForKey);
                    break;
                case 61:
                    setIconTextFitPadding(symbolLayer, styleValueForKey);
                    break;
                case 62:
                    setTextHaloBlurTransition(symbolLayer, styleValueForKey);
                    break;
                case 63:
                    setTextRotate(symbolLayer, styleValueForKey);
                    break;
                case 64:
                    setVisibility(symbolLayer, styleValueForKey);
                    break;
                case 65:
                    setIconHaloColor(symbolLayer, styleValueForKey);
                    break;
                case 66:
                    setIconHaloWidth(symbolLayer, styleValueForKey);
                    break;
                case 67:
                    setTextHaloColorTransition(symbolLayer, styleValueForKey);
                    break;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void setCircleLayerStyle(CircleLayer circleLayer, RCTMGLStyle rCTMGLStyle) {
        List<String> allStyleKeys = rCTMGLStyle.getAllStyleKeys();
        if (allStyleKeys.size() == 0) {
            return;
        }
        for (String str : allStyleKeys) {
            RCTMGLStyleValue styleValueForKey = rCTMGLStyle.getStyleValueForKey(str);
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -1872906981:
                    if (str.equals("circleStrokeColor")) {
                        b = 0;
                    }
                    break;
                case -1854622850:
                    if (str.equals("circleStrokeWidth")) {
                        b = 1;
                    }
                    break;
                case -1844562061:
                    if (str.equals("circleStrokeWidthTransition")) {
                        b = 2;
                    }
                    break;
                case -1111393961:
                    if (str.equals("circleBlur")) {
                        b = 3;
                    }
                    break;
                case -982470989:
                    if (str.equals("circleTranslateAnchor")) {
                        b = 4;
                    }
                    break;
                case -886257381:
                    if (str.equals("circleOpacity")) {
                        b = 5;
                    }
                    break;
                case -555842701:
                    if (str.equals("circlePitchAlignment")) {
                        b = 6;
                    }
                    break;
                case -156526384:
                    if (str.equals("circleStrokeColorTransition")) {
                        b = 7;
                    }
                    break;
                case -92470157:
                    if (str.equals("circleColor")) {
                        b = 8;
                    }
                    break;
                case 46416396:
                    if (str.equals("circleBlurTransition")) {
                        b = 9;
                    }
                    break;
                case 301410899:
                    if (str.equals("circleTranslateTransition")) {
                        b = 10;
                    }
                    break;
                case 414297296:
                    if (str.equals("circleOpacityTransition")) {
                        b = Ascii.VT;
                    }
                    break;
                case 1204918824:
                    if (str.equals("circleColorTransition")) {
                        b = Ascii.FF;
                    }
                    break;
                case 1230058202:
                    if (str.equals("circlePitchScale")) {
                        b = Ascii.CR;
                    }
                    break;
                case 1805905859:
                    if (str.equals("circleStrokeOpacity")) {
                        b = Ascii.SO;
                    }
                    break;
                case 1844656514:
                    if (str.equals("circleRadius")) {
                        b = Ascii.SI;
                    }
                    break;
                case 1915750519:
                    if (str.equals("circleRadiusTransition")) {
                        b = Ascii.DLE;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        b = 17;
                    }
                    break;
                case 2030477688:
                    if (str.equals("circleStrokeOpacityTransition")) {
                        b = Ascii.DC2;
                    }
                    break;
                case 2072362590:
                    if (str.equals("circleTranslate")) {
                        b = 19;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    setCircleStrokeColor(circleLayer, styleValueForKey);
                    break;
                case 1:
                    setCircleStrokeWidth(circleLayer, styleValueForKey);
                    break;
                case 2:
                    setCircleStrokeWidthTransition(circleLayer, styleValueForKey);
                    break;
                case 3:
                    setCircleBlur(circleLayer, styleValueForKey);
                    break;
                case 4:
                    setCircleTranslateAnchor(circleLayer, styleValueForKey);
                    break;
                case 5:
                    setCircleOpacity(circleLayer, styleValueForKey);
                    break;
                case 6:
                    setCirclePitchAlignment(circleLayer, styleValueForKey);
                    break;
                case 7:
                    setCircleStrokeColorTransition(circleLayer, styleValueForKey);
                    break;
                case 8:
                    setCircleColor(circleLayer, styleValueForKey);
                    break;
                case 9:
                    setCircleBlurTransition(circleLayer, styleValueForKey);
                    break;
                case 10:
                    setCircleTranslateTransition(circleLayer, styleValueForKey);
                    break;
                case 11:
                    setCircleOpacityTransition(circleLayer, styleValueForKey);
                    break;
                case 12:
                    setCircleColorTransition(circleLayer, styleValueForKey);
                    break;
                case 13:
                    setCirclePitchScale(circleLayer, styleValueForKey);
                    break;
                case 14:
                    setCircleStrokeOpacity(circleLayer, styleValueForKey);
                    break;
                case 15:
                    setCircleRadius(circleLayer, styleValueForKey);
                    break;
                case 16:
                    setCircleRadiusTransition(circleLayer, styleValueForKey);
                    break;
                case 17:
                    setVisibility(circleLayer, styleValueForKey);
                    break;
                case 18:
                    setCircleStrokeOpacityTransition(circleLayer, styleValueForKey);
                    break;
                case 19:
                    setCircleTranslate(circleLayer, styleValueForKey);
                    break;
            }
        }
    }

    public static void setHeatmapLayerStyle(HeatmapLayer heatmapLayer, RCTMGLStyle rCTMGLStyle) {
        List<String> allStyleKeys = rCTMGLStyle.getAllStyleKeys();
        if (allStyleKeys.size() == 0) {
            return;
        }
        for (String str : allStyleKeys) {
            RCTMGLStyleValue styleValueForKey = rCTMGLStyle.getStyleValueForKey(str);
            str.hashCode();
            switch (str) {
                case "heatmapOpacityTransition":
                    setHeatmapOpacityTransition(heatmapLayer, styleValueForKey);
                    break;
                case "heatmapColor":
                    setHeatmapColor(heatmapLayer, styleValueForKey);
                    break;
                case "heatmapIntensityTransition":
                    setHeatmapIntensityTransition(heatmapLayer, styleValueForKey);
                    break;
                case "heatmapIntensity":
                    setHeatmapIntensity(heatmapLayer, styleValueForKey);
                    break;
                case "heatmapOpacity":
                    setHeatmapOpacity(heatmapLayer, styleValueForKey);
                    break;
                case "heatmapRadiusTransition":
                    setHeatmapRadiusTransition(heatmapLayer, styleValueForKey);
                    break;
                case "heatmapRadius":
                    setHeatmapRadius(heatmapLayer, styleValueForKey);
                    break;
                case "heatmapWeight":
                    setHeatmapWeight(heatmapLayer, styleValueForKey);
                    break;
                case "visibility":
                    setVisibility(heatmapLayer, styleValueForKey);
                    break;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void setFillExtrusionLayerStyle(final FillExtrusionLayer fillExtrusionLayer, RCTMGLStyle rCTMGLStyle) {
        List<String> allStyleKeys = rCTMGLStyle.getAllStyleKeys();
        if (allStyleKeys.size() == 0) {
            return;
        }
        for (String str : allStyleKeys) {
            final RCTMGLStyleValue styleValueForKey = rCTMGLStyle.getStyleValueForKey(str);
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -2034325811:
                    if (str.equals("fillExtrusionTranslateTransition")) {
                        b = 0;
                    }
                    break;
                case -1357538158:
                    if (str.equals("fillExtrusionHeightTransition")) {
                        b = 1;
                    }
                    break;
                case -1312838507:
                    if (str.equals("fillExtrusionOpacity")) {
                        b = 2;
                    }
                    break;
                case -987754225:
                    if (str.equals("fillExtrusionPatternTransition")) {
                        b = 3;
                    }
                    break;
                case -836722662:
                    if (str.equals("fillExtrusionPattern")) {
                        b = 4;
                    }
                    break;
                case -747740254:
                    if (str.equals("fillExtrusionColorTransition")) {
                        b = 5;
                    }
                    break;
                case -486297977:
                    if (str.equals("fillExtrusionBase")) {
                        b = 6;
                    }
                    break;
                case 149793624:
                    if (str.equals("fillExtrusionTranslate")) {
                        b = 7;
                    }
                    break;
                case 809631690:
                    if (str.equals("fillExtrusionOpacityTransition")) {
                        b = 8;
                    }
                    break;
                case 994255709:
                    if (str.equals("fillExtrusionHeight")) {
                        b = 9;
                    }
                    break;
                case 1097448252:
                    if (str.equals("fillExtrusionBaseTransition")) {
                        b = 10;
                    }
                    break;
                case 1359837229:
                    if (str.equals("fillExtrusionTranslateAnchor")) {
                        b = Ascii.VT;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        b = Ascii.FF;
                    }
                    break;
                case 2105966189:
                    if (str.equals("fillExtrusionColor")) {
                        b = Ascii.CR;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    setFillExtrusionTranslateTransition(fillExtrusionLayer, styleValueForKey);
                    break;
                case 1:
                    setFillExtrusionHeightTransition(fillExtrusionLayer, styleValueForKey);
                    break;
                case 2:
                    setFillExtrusionOpacity(fillExtrusionLayer, styleValueForKey);
                    break;
                case 3:
                    setFillExtrusionPatternTransition(fillExtrusionLayer, styleValueForKey);
                    break;
                case 4:
                    rCTMGLStyle.addImage(styleValueForKey, new DownloadMapImageTask.OnAllImagesLoaded() { // from class: com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyleFactory.4
                        @Override // com.mappls.sdk.maps.rctmgl.utils.DownloadMapImageTask.OnAllImagesLoaded
                        public void onAllImagesLoaded() {
                            RCTMGLStyleFactory.setFillExtrusionPattern(fillExtrusionLayer, styleValueForKey);
                        }
                    });
                    break;
                case 5:
                    setFillExtrusionColorTransition(fillExtrusionLayer, styleValueForKey);
                    break;
                case 6:
                    setFillExtrusionBase(fillExtrusionLayer, styleValueForKey);
                    break;
                case 7:
                    setFillExtrusionTranslate(fillExtrusionLayer, styleValueForKey);
                    break;
                case 8:
                    setFillExtrusionOpacityTransition(fillExtrusionLayer, styleValueForKey);
                    break;
                case 9:
                    setFillExtrusionHeight(fillExtrusionLayer, styleValueForKey);
                    break;
                case 10:
                    setFillExtrusionBaseTransition(fillExtrusionLayer, styleValueForKey);
                    break;
                case 11:
                    setFillExtrusionTranslateAnchor(fillExtrusionLayer, styleValueForKey);
                    break;
                case 12:
                    setVisibility(fillExtrusionLayer, styleValueForKey);
                    break;
                case 13:
                    setFillExtrusionColor(fillExtrusionLayer, styleValueForKey);
                    break;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void setRasterLayerStyle(RasterLayer rasterLayer, RCTMGLStyle rCTMGLStyle) {
        List<String> allStyleKeys = rCTMGLStyle.getAllStyleKeys();
        if (allStyleKeys.size() == 0) {
            return;
        }
        for (String str : allStyleKeys) {
            RCTMGLStyleValue styleValueForKey = rCTMGLStyle.getStyleValueForKey(str);
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -1918733362:
                    if (str.equals("rasterOpacity")) {
                        b = 0;
                    }
                    break;
                case -1916423978:
                    if (str.equals("rasterBrightnessMax")) {
                        b = 1;
                    }
                    break;
                case -1916423740:
                    if (str.equals("rasterBrightnessMin")) {
                        b = 2;
                    }
                    break;
                case -1806875529:
                    if (str.equals("rasterResampling")) {
                        b = 3;
                    }
                    break;
                case -1650170165:
                    if (str.equals("rasterBrightnessMaxTransition")) {
                        b = 4;
                    }
                    break;
                case -920959697:
                    if (str.equals("rasterSaturation")) {
                        b = 5;
                    }
                    break;
                case 126079939:
                    if (str.equals("rasterOpacityTransition")) {
                        b = 6;
                    }
                    break;
                case 172135993:
                    if (str.equals("rasterBrightnessMinTransition")) {
                        b = 7;
                    }
                    break;
                case 710545311:
                    if (str.equals("rasterContrast")) {
                        b = 8;
                    }
                    break;
                case 1598446454:
                    if (str.equals("rasterHueRotate")) {
                        b = 9;
                    }
                    break;
                case 1838358500:
                    if (str.equals("rasterSaturationTransition")) {
                        b = 10;
                    }
                    break;
                case 1919655508:
                    if (str.equals("rasterContrastTransition")) {
                        b = Ascii.VT;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        b = Ascii.FF;
                    }
                    break;
                case 1982444109:
                    if (str.equals("rasterFadeDuration")) {
                        b = Ascii.CR;
                    }
                    break;
                case 2093500779:
                    if (str.equals("rasterHueRotateTransition")) {
                        b = Ascii.SO;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    setRasterOpacity(rasterLayer, styleValueForKey);
                    break;
                case 1:
                    setRasterBrightnessMax(rasterLayer, styleValueForKey);
                    break;
                case 2:
                    setRasterBrightnessMin(rasterLayer, styleValueForKey);
                    break;
                case 3:
                    setRasterResampling(rasterLayer, styleValueForKey);
                    break;
                case 4:
                    setRasterBrightnessMaxTransition(rasterLayer, styleValueForKey);
                    break;
                case 5:
                    setRasterSaturation(rasterLayer, styleValueForKey);
                    break;
                case 6:
                    setRasterOpacityTransition(rasterLayer, styleValueForKey);
                    break;
                case 7:
                    setRasterBrightnessMinTransition(rasterLayer, styleValueForKey);
                    break;
                case 8:
                    setRasterContrast(rasterLayer, styleValueForKey);
                    break;
                case 9:
                    setRasterHueRotate(rasterLayer, styleValueForKey);
                    break;
                case 10:
                    setRasterSaturationTransition(rasterLayer, styleValueForKey);
                    break;
                case 11:
                    setRasterContrastTransition(rasterLayer, styleValueForKey);
                    break;
                case 12:
                    setVisibility(rasterLayer, styleValueForKey);
                    break;
                case 13:
                    setRasterFadeDuration(rasterLayer, styleValueForKey);
                    break;
                case 14:
                    setRasterHueRotateTransition(rasterLayer, styleValueForKey);
                    break;
            }
        }
    }

    public static void setHillshadeLayerStyle(HillshadeLayer hillshadeLayer, RCTMGLStyle rCTMGLStyle) {
        List<String> allStyleKeys = rCTMGLStyle.getAllStyleKeys();
        if (allStyleKeys.size() == 0) {
            return;
        }
        for (String str : allStyleKeys) {
            RCTMGLStyleValue styleValueForKey = rCTMGLStyle.getStyleValueForKey(str);
            str.hashCode();
            switch (str) {
                case "hillshadeHighlightColorTransition":
                    setHillshadeHighlightColorTransition(hillshadeLayer, styleValueForKey);
                    break;
                case "hillshadeShadowColorTransition":
                    setHillshadeShadowColorTransition(hillshadeLayer, styleValueForKey);
                    break;
                case "hillshadeAccentColorTransition":
                    setHillshadeAccentColorTransition(hillshadeLayer, styleValueForKey);
                    break;
                case "hillshadeExaggeration":
                    setHillshadeExaggeration(hillshadeLayer, styleValueForKey);
                    break;
                case "hillshadeHighlightColor":
                    setHillshadeHighlightColor(hillshadeLayer, styleValueForKey);
                    break;
                case "hillshadeExaggerationTransition":
                    setHillshadeExaggerationTransition(hillshadeLayer, styleValueForKey);
                    break;
                case "hillshadeIlluminationDirection":
                    setHillshadeIlluminationDirection(hillshadeLayer, styleValueForKey);
                    break;
                case "hillshadeShadowColor":
                    setHillshadeShadowColor(hillshadeLayer, styleValueForKey);
                    break;
                case "hillshadeAccentColor":
                    setHillshadeAccentColor(hillshadeLayer, styleValueForKey);
                    break;
                case "hillshadeIlluminationAnchor":
                    setHillshadeIlluminationAnchor(hillshadeLayer, styleValueForKey);
                    break;
                case "visibility":
                    setVisibility(hillshadeLayer, styleValueForKey);
                    break;
            }
        }
    }

    public static void setBackgroundLayerStyle(final BackgroundLayer backgroundLayer, RCTMGLStyle rCTMGLStyle) {
        List<String> allStyleKeys = rCTMGLStyle.getAllStyleKeys();
        if (allStyleKeys.size() == 0) {
            return;
        }
        for (String str : allStyleKeys) {
            final RCTMGLStyleValue styleValueForKey = rCTMGLStyle.getStyleValueForKey(str);
            str.hashCode();
            switch (str) {
                case "backgroundPattern":
                    rCTMGLStyle.addImage(styleValueForKey, new DownloadMapImageTask.OnAllImagesLoaded() { // from class: com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyleFactory.5
                        @Override // com.mappls.sdk.maps.rctmgl.utils.DownloadMapImageTask.OnAllImagesLoaded
                        public void onAllImagesLoaded() {
                            RCTMGLStyleFactory.setBackgroundPattern(backgroundLayer, styleValueForKey);
                        }
                    });
                    break;
                case "backgroundPatternTransition":
                    setBackgroundPatternTransition(backgroundLayer, styleValueForKey);
                    break;
                case "backgroundColorTransition":
                    setBackgroundColorTransition(backgroundLayer, styleValueForKey);
                    break;
                case "backgroundOpacityTransition":
                    setBackgroundOpacityTransition(backgroundLayer, styleValueForKey);
                    break;
                case "backgroundColor":
                    setBackgroundColor(backgroundLayer, styleValueForKey);
                    break;
                case "visibility":
                    setVisibility(backgroundLayer, styleValueForKey);
                    break;
                case "backgroundOpacity":
                    setBackgroundOpacity(backgroundLayer, styleValueForKey);
                    break;
            }
        }
    }

    public static void setLightLayerStyle(Light light, RCTMGLStyle rCTMGLStyle) {
        List<String> allStyleKeys = rCTMGLStyle.getAllStyleKeys();
        if (allStyleKeys.size() == 0) {
            return;
        }
        for (String str : allStyleKeys) {
            RCTMGLStyleValue styleValueForKey = rCTMGLStyle.getStyleValueForKey(str);
            str.hashCode();
            switch (str) {
                case "anchor":
                    setAnchor(light, styleValueForKey);
                    break;
                case "positionTransition":
                    setPositionTransition(light, styleValueForKey);
                    break;
                case "colorTransition":
                    setColorTransition(light, styleValueForKey);
                    break;
                case "color":
                    setColor(light, styleValueForKey);
                    break;
                case "intensity":
                    setIntensity(light, styleValueForKey);
                    break;
                case "position":
                    setPosition(light, styleValueForKey);
                    break;
                case "intensityTransition":
                    setIntensityTransition(light, styleValueForKey);
                    break;
            }
        }
    }

    public static void setVisibility(FillLayer fillLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        fillLayer.setProperties(PropertyFactory.visibility(rCTMGLStyleValue.getString("value")));
    }

    public static void setFillAntialias(FillLayer fillLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            fillLayer.setProperties(PropertyFactory.fillAntialias(rCTMGLStyleValue.getExpression()));
        } else {
            fillLayer.setProperties(PropertyFactory.fillAntialias(rCTMGLStyleValue.getBoolean("value")));
        }
    }

    public static void setFillOpacity(FillLayer fillLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            fillLayer.setProperties(PropertyFactory.fillOpacity(rCTMGLStyleValue.getExpression()));
        } else {
            fillLayer.setProperties(PropertyFactory.fillOpacity(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setFillOpacityTransition(FillLayer fillLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            fillLayer.setFillOpacityTransition(transition);
        }
    }

    public static void setFillColor(FillLayer fillLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            fillLayer.setProperties(PropertyFactory.fillColor(rCTMGLStyleValue.getExpression()));
        } else {
            fillLayer.setProperties(PropertyFactory.fillColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setFillColorTransition(FillLayer fillLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            fillLayer.setFillColorTransition(transition);
        }
    }

    public static void setFillOutlineColor(FillLayer fillLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            fillLayer.setProperties(PropertyFactory.fillOutlineColor(rCTMGLStyleValue.getExpression()));
        } else {
            fillLayer.setProperties(PropertyFactory.fillOutlineColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setFillOutlineColorTransition(FillLayer fillLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            fillLayer.setFillOutlineColorTransition(transition);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setFillTranslate(FillLayer fillLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            fillLayer.setProperties(PropertyFactory.fillTranslate(rCTMGLStyleValue.getExpression()));
        } else {
            fillLayer.setProperties(PropertyFactory.fillTranslate(rCTMGLStyleValue.getFloatArray("value")));
        }
    }

    public static void setFillTranslateTransition(FillLayer fillLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            fillLayer.setFillTranslateTransition(transition);
        }
    }

    public static void setFillTranslateAnchor(FillLayer fillLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            fillLayer.setProperties(PropertyFactory.fillTranslateAnchor(rCTMGLStyleValue.getExpression()));
        } else {
            fillLayer.setProperties(PropertyFactory.fillTranslateAnchor(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setFillPattern(FillLayer fillLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            if (rCTMGLStyleValue.isImageStringValue().booleanValue()) {
                fillLayer.setProperties(PropertyFactory.fillPattern(rCTMGLStyleValue.getImageStringValue()));
                return;
            } else {
                fillLayer.setProperties(PropertyFactory.fillPattern(rCTMGLStyleValue.getExpression()));
                return;
            }
        }
        fillLayer.setProperties(PropertyFactory.fillPattern(rCTMGLStyleValue.getImageURI()));
    }

    public static void setFillPatternTransition(FillLayer fillLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            fillLayer.setFillPatternTransition(transition);
        }
    }

    public static void setLineCap(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineCap(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineCap(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setLineJoin(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineJoin(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineJoin(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setLineMiterLimit(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineMiterLimit(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineMiterLimit(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setLineRoundLimit(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineRoundLimit(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineRoundLimit(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setVisibility(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        lineLayer.setProperties(PropertyFactory.visibility(rCTMGLStyleValue.getString("value")));
    }

    public static void setLineOpacity(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineOpacity(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineOpacity(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setLineOpacityTransition(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            lineLayer.setLineOpacityTransition(transition);
        }
    }

    public static void setLineColor(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineColor(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setLineColorTransition(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            lineLayer.setLineColorTransition(transition);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setLineTranslate(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineTranslate(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineTranslate(rCTMGLStyleValue.getFloatArray("value")));
        }
    }

    public static void setLineTranslateTransition(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            lineLayer.setLineTranslateTransition(transition);
        }
    }

    public static void setLineTranslateAnchor(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineTranslateAnchor(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineTranslateAnchor(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setLineWidth(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineWidth(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineWidth(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setLineWidthTransition(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            lineLayer.setLineWidthTransition(transition);
        }
    }

    public static void setLineGapWidth(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineGapWidth(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineGapWidth(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setLineGapWidthTransition(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            lineLayer.setLineGapWidthTransition(transition);
        }
    }

    public static void setLineOffset(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineOffset(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineOffset(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setLineOffsetTransition(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            lineLayer.setLineOffsetTransition(transition);
        }
    }

    public static void setLineBlur(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineBlur(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineBlur(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setLineBlurTransition(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            lineLayer.setLineBlurTransition(transition);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setLineDasharray(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineDasharray(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineDasharray(rCTMGLStyleValue.getFloatArray("value")));
        }
    }

    public static void setLineDasharrayTransition(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            lineLayer.setLineDasharrayTransition(transition);
        }
    }

    public static void setLinePattern(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            if (rCTMGLStyleValue.isImageStringValue().booleanValue()) {
                lineLayer.setProperties(PropertyFactory.linePattern(rCTMGLStyleValue.getImageStringValue()));
                return;
            } else {
                lineLayer.setProperties(PropertyFactory.linePattern(rCTMGLStyleValue.getExpression()));
                return;
            }
        }
        lineLayer.setProperties(PropertyFactory.linePattern(rCTMGLStyleValue.getImageURI()));
    }

    public static void setLinePatternTransition(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            lineLayer.setLinePatternTransition(transition);
        }
    }

    public static void setLineGradient(LineLayer lineLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            lineLayer.setProperties(PropertyFactory.lineGradient(rCTMGLStyleValue.getExpression()));
        } else {
            lineLayer.setProperties(PropertyFactory.lineGradient(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setSymbolPlacement(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.symbolPlacement(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.symbolPlacement(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setSymbolSpacing(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.symbolSpacing(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.symbolSpacing(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setSymbolAvoidEdges(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.symbolAvoidEdges(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.symbolAvoidEdges(rCTMGLStyleValue.getBoolean("value")));
        }
    }

    public static void setSymbolSortKey(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.symbolSortKey(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.symbolSortKey(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setSymbolZOrder(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.symbolZOrder(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.symbolZOrder(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setIconAllowOverlap(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconAllowOverlap(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconAllowOverlap(rCTMGLStyleValue.getBoolean("value")));
        }
    }

    public static void setIconIgnorePlacement(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconIgnorePlacement(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconIgnorePlacement(rCTMGLStyleValue.getBoolean("value")));
        }
    }

    public static void setIconOptional(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconOptional(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconOptional(rCTMGLStyleValue.getBoolean("value")));
        }
    }

    public static void setIconRotationAlignment(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconRotationAlignment(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconRotationAlignment(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setIconSize(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconSize(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconSize(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setIconTextFit(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconTextFit(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconTextFit(rCTMGLStyleValue.getString("value")));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setIconTextFitPadding(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconTextFitPadding(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconTextFitPadding(rCTMGLStyleValue.getFloatArray("value")));
        }
    }

    public static void setIconImage(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            if (rCTMGLStyleValue.isImageStringValue().booleanValue()) {
                symbolLayer.setProperties(PropertyFactory.iconImage(rCTMGLStyleValue.getImageStringValue()));
                return;
            } else {
                symbolLayer.setProperties(PropertyFactory.iconImage(rCTMGLStyleValue.getExpression()));
                return;
            }
        }
        symbolLayer.setProperties(PropertyFactory.iconImage(rCTMGLStyleValue.getImageURI()));
    }

    public static void setIconRotate(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconRotate(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconRotate(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setIconPadding(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconPadding(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconPadding(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setIconKeepUpright(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconKeepUpright(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconKeepUpright(rCTMGLStyleValue.getBoolean("value")));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setIconOffset(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconOffset(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconOffset(rCTMGLStyleValue.getFloatArray("value")));
        }
    }

    public static void setIconAnchor(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconAnchor(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconAnchor(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setIconPitchAlignment(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconPitchAlignment(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconPitchAlignment(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setTextPitchAlignment(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textPitchAlignment(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textPitchAlignment(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setTextRotationAlignment(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textRotationAlignment(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textRotationAlignment(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setTextField(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textField(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textField(rCTMGLStyleValue.getString("value")));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTextFont(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textFont(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textFont(rCTMGLStyleValue.getStringArray("value")));
        }
    }

    public static void setTextSize(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textSize(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textSize(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setTextMaxWidth(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textMaxWidth(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textMaxWidth(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setTextLineHeight(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textLineHeight(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textLineHeight(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setTextLetterSpacing(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textLetterSpacing(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textLetterSpacing(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setTextJustify(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textJustify(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textJustify(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setTextRadialOffset(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textRadialOffset(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textRadialOffset(rCTMGLStyleValue.getFloat("value")));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTextVariableAnchor(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textVariableAnchor(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textVariableAnchor(rCTMGLStyleValue.getStringArray("value")));
        }
    }

    public static void setTextAnchor(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textAnchor(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textAnchor(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setTextMaxAngle(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textMaxAngle(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textMaxAngle(rCTMGLStyleValue.getFloat("value")));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTextWritingMode(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textWritingMode(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textWritingMode(rCTMGLStyleValue.getStringArray("value")));
        }
    }

    public static void setTextRotate(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textRotate(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textRotate(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setTextPadding(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textPadding(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textPadding(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setTextKeepUpright(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textKeepUpright(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textKeepUpright(rCTMGLStyleValue.getBoolean("value")));
        }
    }

    public static void setTextTransform(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textTransform(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textTransform(rCTMGLStyleValue.getString("value")));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTextOffset(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textOffset(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textOffset(rCTMGLStyleValue.getFloatArray("value")));
        }
    }

    public static void setTextAllowOverlap(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textAllowOverlap(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textAllowOverlap(rCTMGLStyleValue.getBoolean("value")));
        }
    }

    public static void setTextIgnorePlacement(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textIgnorePlacement(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textIgnorePlacement(rCTMGLStyleValue.getBoolean("value")));
        }
    }

    public static void setTextOptional(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textOptional(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textOptional(rCTMGLStyleValue.getBoolean("value")));
        }
    }

    public static void setVisibility(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        symbolLayer.setProperties(PropertyFactory.visibility(rCTMGLStyleValue.getString("value")));
    }

    public static void setIconOpacity(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconOpacity(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconOpacity(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setIconOpacityTransition(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            symbolLayer.setIconOpacityTransition(transition);
        }
    }

    public static void setIconColor(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconColor(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setIconColorTransition(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            symbolLayer.setIconColorTransition(transition);
        }
    }

    public static void setIconHaloColor(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconHaloColor(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconHaloColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setIconHaloColorTransition(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            symbolLayer.setIconHaloColorTransition(transition);
        }
    }

    public static void setIconHaloWidth(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconHaloWidth(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconHaloWidth(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setIconHaloWidthTransition(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            symbolLayer.setIconHaloWidthTransition(transition);
        }
    }

    public static void setIconHaloBlur(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconHaloBlur(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconHaloBlur(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setIconHaloBlurTransition(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            symbolLayer.setIconHaloBlurTransition(transition);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setIconTranslate(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconTranslate(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconTranslate(rCTMGLStyleValue.getFloatArray("value")));
        }
    }

    public static void setIconTranslateTransition(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            symbolLayer.setIconTranslateTransition(transition);
        }
    }

    public static void setIconTranslateAnchor(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.iconTranslateAnchor(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.iconTranslateAnchor(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setTextOpacity(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textOpacity(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textOpacity(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setTextOpacityTransition(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            symbolLayer.setTextOpacityTransition(transition);
        }
    }

    public static void setTextColor(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textColor(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setTextColorTransition(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            symbolLayer.setTextColorTransition(transition);
        }
    }

    public static void setTextHaloColor(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textHaloColor(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textHaloColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setTextHaloColorTransition(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            symbolLayer.setTextHaloColorTransition(transition);
        }
    }

    public static void setTextHaloWidth(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textHaloWidth(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textHaloWidth(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setTextHaloWidthTransition(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            symbolLayer.setTextHaloWidthTransition(transition);
        }
    }

    public static void setTextHaloBlur(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textHaloBlur(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textHaloBlur(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setTextHaloBlurTransition(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            symbolLayer.setTextHaloBlurTransition(transition);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTextTranslate(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textTranslate(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textTranslate(rCTMGLStyleValue.getFloatArray("value")));
        }
    }

    public static void setTextTranslateTransition(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            symbolLayer.setTextTranslateTransition(transition);
        }
    }

    public static void setTextTranslateAnchor(SymbolLayer symbolLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            symbolLayer.setProperties(PropertyFactory.textTranslateAnchor(rCTMGLStyleValue.getExpression()));
        } else {
            symbolLayer.setProperties(PropertyFactory.textTranslateAnchor(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setVisibility(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        circleLayer.setProperties(PropertyFactory.visibility(rCTMGLStyleValue.getString("value")));
    }

    public static void setCircleRadius(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            circleLayer.setProperties(PropertyFactory.circleRadius(rCTMGLStyleValue.getExpression()));
        } else {
            circleLayer.setProperties(PropertyFactory.circleRadius(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setCircleRadiusTransition(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            circleLayer.setCircleRadiusTransition(transition);
        }
    }

    public static void setCircleColor(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            circleLayer.setProperties(PropertyFactory.circleColor(rCTMGLStyleValue.getExpression()));
        } else {
            circleLayer.setProperties(PropertyFactory.circleColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setCircleColorTransition(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            circleLayer.setCircleColorTransition(transition);
        }
    }

    public static void setCircleBlur(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            circleLayer.setProperties(PropertyFactory.circleBlur(rCTMGLStyleValue.getExpression()));
        } else {
            circleLayer.setProperties(PropertyFactory.circleBlur(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setCircleBlurTransition(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            circleLayer.setCircleBlurTransition(transition);
        }
    }

    public static void setCircleOpacity(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            circleLayer.setProperties(PropertyFactory.circleOpacity(rCTMGLStyleValue.getExpression()));
        } else {
            circleLayer.setProperties(PropertyFactory.circleOpacity(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setCircleOpacityTransition(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            circleLayer.setCircleOpacityTransition(transition);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCircleTranslate(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            circleLayer.setProperties(PropertyFactory.circleTranslate(rCTMGLStyleValue.getExpression()));
        } else {
            circleLayer.setProperties(PropertyFactory.circleTranslate(rCTMGLStyleValue.getFloatArray("value")));
        }
    }

    public static void setCircleTranslateTransition(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            circleLayer.setCircleTranslateTransition(transition);
        }
    }

    public static void setCircleTranslateAnchor(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            circleLayer.setProperties(PropertyFactory.circleTranslateAnchor(rCTMGLStyleValue.getExpression()));
        } else {
            circleLayer.setProperties(PropertyFactory.circleTranslateAnchor(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setCirclePitchScale(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            circleLayer.setProperties(PropertyFactory.circlePitchScale(rCTMGLStyleValue.getExpression()));
        } else {
            circleLayer.setProperties(PropertyFactory.circlePitchScale(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setCirclePitchAlignment(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            circleLayer.setProperties(PropertyFactory.circlePitchAlignment(rCTMGLStyleValue.getExpression()));
        } else {
            circleLayer.setProperties(PropertyFactory.circlePitchAlignment(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setCircleStrokeWidth(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            circleLayer.setProperties(PropertyFactory.circleStrokeWidth(rCTMGLStyleValue.getExpression()));
        } else {
            circleLayer.setProperties(PropertyFactory.circleStrokeWidth(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setCircleStrokeWidthTransition(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            circleLayer.setCircleStrokeWidthTransition(transition);
        }
    }

    public static void setCircleStrokeColor(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            circleLayer.setProperties(PropertyFactory.circleStrokeColor(rCTMGLStyleValue.getExpression()));
        } else {
            circleLayer.setProperties(PropertyFactory.circleStrokeColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setCircleStrokeColorTransition(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            circleLayer.setCircleStrokeColorTransition(transition);
        }
    }

    public static void setCircleStrokeOpacity(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            circleLayer.setProperties(PropertyFactory.circleStrokeOpacity(rCTMGLStyleValue.getExpression()));
        } else {
            circleLayer.setProperties(PropertyFactory.circleStrokeOpacity(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setCircleStrokeOpacityTransition(CircleLayer circleLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            circleLayer.setCircleStrokeOpacityTransition(transition);
        }
    }

    public static void setVisibility(HeatmapLayer heatmapLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        heatmapLayer.setProperties(PropertyFactory.visibility(rCTMGLStyleValue.getString("value")));
    }

    public static void setHeatmapRadius(HeatmapLayer heatmapLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            heatmapLayer.setProperties(PropertyFactory.heatmapRadius(rCTMGLStyleValue.getExpression()));
        } else {
            heatmapLayer.setProperties(PropertyFactory.heatmapRadius(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setHeatmapRadiusTransition(HeatmapLayer heatmapLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            heatmapLayer.setHeatmapRadiusTransition(transition);
        }
    }

    public static void setHeatmapWeight(HeatmapLayer heatmapLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            heatmapLayer.setProperties(PropertyFactory.heatmapWeight(rCTMGLStyleValue.getExpression()));
        } else {
            heatmapLayer.setProperties(PropertyFactory.heatmapWeight(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setHeatmapIntensity(HeatmapLayer heatmapLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            heatmapLayer.setProperties(PropertyFactory.heatmapIntensity(rCTMGLStyleValue.getExpression()));
        } else {
            heatmapLayer.setProperties(PropertyFactory.heatmapIntensity(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setHeatmapIntensityTransition(HeatmapLayer heatmapLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            heatmapLayer.setHeatmapIntensityTransition(transition);
        }
    }

    public static void setHeatmapColor(HeatmapLayer heatmapLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            heatmapLayer.setProperties(PropertyFactory.heatmapColor(rCTMGLStyleValue.getExpression()));
        } else {
            heatmapLayer.setProperties(PropertyFactory.heatmapColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setHeatmapOpacity(HeatmapLayer heatmapLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            heatmapLayer.setProperties(PropertyFactory.heatmapOpacity(rCTMGLStyleValue.getExpression()));
        } else {
            heatmapLayer.setProperties(PropertyFactory.heatmapOpacity(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setHeatmapOpacityTransition(HeatmapLayer heatmapLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            heatmapLayer.setHeatmapOpacityTransition(transition);
        }
    }

    public static void setVisibility(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        fillExtrusionLayer.setProperties(PropertyFactory.visibility(rCTMGLStyleValue.getString("value")));
    }

    public static void setFillExtrusionOpacity(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionOpacity(rCTMGLStyleValue.getExpression()));
        } else {
            fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionOpacity(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setFillExtrusionOpacityTransition(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            fillExtrusionLayer.setFillExtrusionOpacityTransition(transition);
        }
    }

    public static void setFillExtrusionColor(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionColor(rCTMGLStyleValue.getExpression()));
        } else {
            fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setFillExtrusionColorTransition(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            fillExtrusionLayer.setFillExtrusionColorTransition(transition);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setFillExtrusionTranslate(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionTranslate(rCTMGLStyleValue.getExpression()));
        } else {
            fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionTranslate(rCTMGLStyleValue.getFloatArray("value")));
        }
    }

    public static void setFillExtrusionTranslateTransition(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            fillExtrusionLayer.setFillExtrusionTranslateTransition(transition);
        }
    }

    public static void setFillExtrusionTranslateAnchor(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionTranslateAnchor(rCTMGLStyleValue.getExpression()));
        } else {
            fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionTranslateAnchor(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setFillExtrusionPattern(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            if (rCTMGLStyleValue.isImageStringValue().booleanValue()) {
                fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionPattern(rCTMGLStyleValue.getImageStringValue()));
                return;
            } else {
                fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionPattern(rCTMGLStyleValue.getExpression()));
                return;
            }
        }
        fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionPattern(rCTMGLStyleValue.getImageURI()));
    }

    public static void setFillExtrusionPatternTransition(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            fillExtrusionLayer.setFillExtrusionPatternTransition(transition);
        }
    }

    public static void setFillExtrusionHeight(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionHeight(rCTMGLStyleValue.getExpression()));
        } else {
            fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionHeight(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setFillExtrusionHeightTransition(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            fillExtrusionLayer.setFillExtrusionHeightTransition(transition);
        }
    }

    public static void setFillExtrusionBase(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionBase(rCTMGLStyleValue.getExpression()));
        } else {
            fillExtrusionLayer.setProperties(PropertyFactory.fillExtrusionBase(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setFillExtrusionBaseTransition(FillExtrusionLayer fillExtrusionLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            fillExtrusionLayer.setFillExtrusionBaseTransition(transition);
        }
    }

    public static void setVisibility(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        rasterLayer.setProperties(PropertyFactory.visibility(rCTMGLStyleValue.getString("value")));
    }

    public static void setRasterOpacity(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            rasterLayer.setProperties(PropertyFactory.rasterOpacity(rCTMGLStyleValue.getExpression()));
        } else {
            rasterLayer.setProperties(PropertyFactory.rasterOpacity(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setRasterOpacityTransition(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            rasterLayer.setRasterOpacityTransition(transition);
        }
    }

    public static void setRasterHueRotate(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            rasterLayer.setProperties(PropertyFactory.rasterHueRotate(rCTMGLStyleValue.getExpression()));
        } else {
            rasterLayer.setProperties(PropertyFactory.rasterHueRotate(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setRasterHueRotateTransition(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            rasterLayer.setRasterHueRotateTransition(transition);
        }
    }

    public static void setRasterBrightnessMin(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            rasterLayer.setProperties(PropertyFactory.rasterBrightnessMin(rCTMGLStyleValue.getExpression()));
        } else {
            rasterLayer.setProperties(PropertyFactory.rasterBrightnessMin(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setRasterBrightnessMinTransition(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            rasterLayer.setRasterBrightnessMinTransition(transition);
        }
    }

    public static void setRasterBrightnessMax(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            rasterLayer.setProperties(PropertyFactory.rasterBrightnessMax(rCTMGLStyleValue.getExpression()));
        } else {
            rasterLayer.setProperties(PropertyFactory.rasterBrightnessMax(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setRasterBrightnessMaxTransition(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            rasterLayer.setRasterBrightnessMaxTransition(transition);
        }
    }

    public static void setRasterSaturation(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            rasterLayer.setProperties(PropertyFactory.rasterSaturation(rCTMGLStyleValue.getExpression()));
        } else {
            rasterLayer.setProperties(PropertyFactory.rasterSaturation(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setRasterSaturationTransition(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            rasterLayer.setRasterSaturationTransition(transition);
        }
    }

    public static void setRasterContrast(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            rasterLayer.setProperties(PropertyFactory.rasterContrast(rCTMGLStyleValue.getExpression()));
        } else {
            rasterLayer.setProperties(PropertyFactory.rasterContrast(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setRasterContrastTransition(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            rasterLayer.setRasterContrastTransition(transition);
        }
    }

    public static void setRasterResampling(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            rasterLayer.setProperties(PropertyFactory.rasterResampling(rCTMGLStyleValue.getExpression()));
        } else {
            rasterLayer.setProperties(PropertyFactory.rasterResampling(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setRasterFadeDuration(RasterLayer rasterLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            rasterLayer.setProperties(PropertyFactory.rasterFadeDuration(rCTMGLStyleValue.getExpression()));
        } else {
            rasterLayer.setProperties(PropertyFactory.rasterFadeDuration(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setVisibility(HillshadeLayer hillshadeLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        hillshadeLayer.setProperties(PropertyFactory.visibility(rCTMGLStyleValue.getString("value")));
    }

    public static void setHillshadeIlluminationDirection(HillshadeLayer hillshadeLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            hillshadeLayer.setProperties(PropertyFactory.hillshadeIlluminationDirection(rCTMGLStyleValue.getExpression()));
        } else {
            hillshadeLayer.setProperties(PropertyFactory.hillshadeIlluminationDirection(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setHillshadeIlluminationAnchor(HillshadeLayer hillshadeLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            hillshadeLayer.setProperties(PropertyFactory.hillshadeIlluminationAnchor(rCTMGLStyleValue.getExpression()));
        } else {
            hillshadeLayer.setProperties(PropertyFactory.hillshadeIlluminationAnchor(rCTMGLStyleValue.getString("value")));
        }
    }

    public static void setHillshadeExaggeration(HillshadeLayer hillshadeLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            hillshadeLayer.setProperties(PropertyFactory.hillshadeExaggeration(rCTMGLStyleValue.getExpression()));
        } else {
            hillshadeLayer.setProperties(PropertyFactory.hillshadeExaggeration(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setHillshadeExaggerationTransition(HillshadeLayer hillshadeLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            hillshadeLayer.setHillshadeExaggerationTransition(transition);
        }
    }

    public static void setHillshadeShadowColor(HillshadeLayer hillshadeLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            hillshadeLayer.setProperties(PropertyFactory.hillshadeShadowColor(rCTMGLStyleValue.getExpression()));
        } else {
            hillshadeLayer.setProperties(PropertyFactory.hillshadeShadowColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setHillshadeShadowColorTransition(HillshadeLayer hillshadeLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            hillshadeLayer.setHillshadeShadowColorTransition(transition);
        }
    }

    public static void setHillshadeHighlightColor(HillshadeLayer hillshadeLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            hillshadeLayer.setProperties(PropertyFactory.hillshadeHighlightColor(rCTMGLStyleValue.getExpression()));
        } else {
            hillshadeLayer.setProperties(PropertyFactory.hillshadeHighlightColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setHillshadeHighlightColorTransition(HillshadeLayer hillshadeLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            hillshadeLayer.setHillshadeHighlightColorTransition(transition);
        }
    }

    public static void setHillshadeAccentColor(HillshadeLayer hillshadeLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            hillshadeLayer.setProperties(PropertyFactory.hillshadeAccentColor(rCTMGLStyleValue.getExpression()));
        } else {
            hillshadeLayer.setProperties(PropertyFactory.hillshadeAccentColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setHillshadeAccentColorTransition(HillshadeLayer hillshadeLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            hillshadeLayer.setHillshadeAccentColorTransition(transition);
        }
    }

    public static void setVisibility(BackgroundLayer backgroundLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        backgroundLayer.setProperties(PropertyFactory.visibility(rCTMGLStyleValue.getString("value")));
    }

    public static void setBackgroundColor(BackgroundLayer backgroundLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            backgroundLayer.setProperties(PropertyFactory.backgroundColor(rCTMGLStyleValue.getExpression()));
        } else {
            backgroundLayer.setProperties(PropertyFactory.backgroundColor(rCTMGLStyleValue.getInt("value")));
        }
    }

    public static void setBackgroundColorTransition(BackgroundLayer backgroundLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            backgroundLayer.setBackgroundColorTransition(transition);
        }
    }

    public static void setBackgroundPattern(BackgroundLayer backgroundLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            if (rCTMGLStyleValue.isImageStringValue().booleanValue()) {
                backgroundLayer.setProperties(PropertyFactory.backgroundPattern(rCTMGLStyleValue.getImageStringValue()));
                return;
            } else {
                backgroundLayer.setProperties(PropertyFactory.backgroundPattern(rCTMGLStyleValue.getExpression()));
                return;
            }
        }
        backgroundLayer.setProperties(PropertyFactory.backgroundPattern(rCTMGLStyleValue.getImageURI()));
    }

    public static void setBackgroundPatternTransition(BackgroundLayer backgroundLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            backgroundLayer.setBackgroundPatternTransition(transition);
        }
    }

    public static void setBackgroundOpacity(BackgroundLayer backgroundLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        if (rCTMGLStyleValue.isExpression()) {
            backgroundLayer.setProperties(PropertyFactory.backgroundOpacity(rCTMGLStyleValue.getExpression()));
        } else {
            backgroundLayer.setProperties(PropertyFactory.backgroundOpacity(rCTMGLStyleValue.getFloat("value")));
        }
    }

    public static void setBackgroundOpacityTransition(BackgroundLayer backgroundLayer, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            backgroundLayer.setBackgroundOpacityTransition(transition);
        }
    }

    public static void setAnchor(Light light, RCTMGLStyleValue rCTMGLStyleValue) {
        light.setAnchor(rCTMGLStyleValue.getString("value"));
    }

    public static void setPosition(Light light, RCTMGLStyleValue rCTMGLStyleValue) {
        Float[] floatArray = rCTMGLStyleValue.getFloatArray("value");
        light.setPosition(Position.fromPosition(floatArray[0].floatValue(), floatArray[1].floatValue(), floatArray[2].floatValue()));
    }

    public static void setPositionTransition(Light light, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            light.setPositionTransition(transition);
        }
    }

    public static void setColor(Light light, RCTMGLStyleValue rCTMGLStyleValue) {
        light.setColor(rCTMGLStyleValue.getInt("value"));
    }

    public static void setColorTransition(Light light, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            light.setColorTransition(transition);
        }
    }

    public static void setIntensity(Light light, RCTMGLStyleValue rCTMGLStyleValue) {
        light.setIntensity(rCTMGLStyleValue.getFloat("value").floatValue());
    }

    public static void setIntensityTransition(Light light, RCTMGLStyleValue rCTMGLStyleValue) {
        TransitionOptions transition = rCTMGLStyleValue.getTransition();
        if (transition != null) {
            light.setIntensityTransition(transition);
        }
    }
}
