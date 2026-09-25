package com.bajaj.rideconnect.re

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Outline
import android.graphics.Path
import android.graphics.RectF
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewOutlineProvider
import android.webkit.ConsoleMessage
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import org.json.JSONArray
import java.util.Locale

class MapplsMapView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    fun interface OnMapReadyCallback {
        fun onMapReady()
    }

    fun interface OnMapClickListener {
        fun onMapClick(lat: Double, lng: Double)
    }

    interface OnMapInteractionListener {
        fun onMapDragged()
        fun onMapRecentered()
        fun onMapBearingChanged(bearing: Double)
        fun onOrientationModeChanged(is3D: Boolean, bearing: Double)
    }

    private var webView: WebView? = null
    private val mainHandler = Handler(Looper.getMainLooper())
    private var isMapLoaded = false
    private var lastLat = 28.6139
    private var lastLng = 77.2090
    private var lastBearing = 0f
    private var currentAccentHex = "#38BDF8"
    private var currentAccentRgb = "56, 189, 248"
    var isDarkMode: Boolean = true
        private set

    private val clipPath = Path()
    private val rectF = RectF()
    private var cornerRadiusDp = 0f

    private var mapReadyCallback: OnMapReadyCallback? = null
    private var mapClickListener: OnMapClickListener? = null
    private var mapInteractionListener: OnMapInteractionListener? = null

    init {
        init(context)
    }

    fun setOnMapReadyCallback(callback: OnMapReadyCallback?) {
        this.mapReadyCallback = callback
        if (isMapLoaded && callback != null) {
            callback.onMapReady()
        }
    }

    fun setOnMapClickListener(listener: OnMapClickListener?) {
        this.mapClickListener = listener
    }

    fun setOnMapInteractionListener(listener: OnMapInteractionListener?) {
        this.mapInteractionListener = listener
    }

    private fun init(context: Context) {
        setBackgroundColor(Color.TRANSPARENT)
        val density = context.resources.displayMetrics.density
        if (cornerRadiusDp > 0f) {
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    if (view.width > 0 && view.height > 0) {
                        outline.setRoundRect(0, 0, view.width, view.height, cornerRadiusDp * density)
                    }
                }
            }
            clipToOutline = true
        } else {
            clipToOutline = false
        }

        try {
            val prefs = context.getSharedPreferences("bajaj_ride_prefs", Context.MODE_PRIVATE)
            val savedLat = prefs.getFloat("saved_rider_lat", 0.0f)
            val savedLng = prefs.getFloat("saved_rider_lng", 0.0f)
            if (savedLat != 0.0f && savedLng != 0.0f) {
                lastLat = savedLat.toDouble()
                lastLng = savedLng.toDouble()
            }
        } catch (ignored: Exception) {}

        val wv = WebView(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            setBackgroundColor(Color.TRANSPARENT)
            setLayerType(LAYER_TYPE_HARDWARE, null)
        }
        this.webView = wv

        val ws: WebSettings = wv.settings
        ws.javaScriptEnabled = true
        ws.domStorageEnabled = true
        ws.allowFileAccess = true
        ws.cacheMode = WebSettings.LOAD_DEFAULT
        ws.useWideViewPort = true
        ws.loadWithOverviewMode = true

        wv.addJavascriptInterface(object {
            @JavascriptInterface
            fun onMapInitialized() {
                mainHandler.post {
                    isMapLoaded = true
                    val script = String.format(
                        Locale.US,
                        "setMapAccentColor('%s', '%s');",
                        currentAccentHex,
                        currentAccentRgb
                    )
                    webView?.evaluateJavascript(script, null)
                    webView?.evaluateJavascript("setMapTheme($isDarkMode);", null)
                    mapReadyCallback?.onMapReady()
                }
            }

            @JavascriptInterface
            fun onMapTapped(lat: Double, lng: Double) {
                mainHandler.post {
                    mapClickListener?.onMapClick(lat, lng)
                }
            }

            @JavascriptInterface
            fun onMapDragged() {
                mainHandler.post {
                    mapInteractionListener?.onMapDragged()
                }
            }

            @JavascriptInterface
            fun onMapRecentered() {
                mainHandler.post {
                    mapInteractionListener?.onMapRecentered()
                }
            }

            @JavascriptInterface
            fun onMapBearingChanged(bearing: Double) {
                mainHandler.post {
                    mapInteractionListener?.onMapBearingChanged(bearing)
                }
            }

            @JavascriptInterface
            fun onOrientationModeChanged(is3D: Boolean, bearing: Double) {
                mainHandler.post {
                    mapInteractionListener?.onOrientationModeChanged(is3D, bearing)
                }
            }
        }, "AndroidBridge")

        wv.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                Log.d(
                    "MapplsMapView",
                    "Console [" + consoleMessage.messageLevel() + "]: " +
                        consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")"
                )
                return true
            }
        }

        wv.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Log.d("MapplsMapView", "Page finished loading: $url")
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                Log.e("MapplsMapView", "Resource error on ${request?.url}: ${error?.description}")
            }
        }

        addView(wv)
        loadMapplsHtml()
    }

    private fun loadMapplsHtml() {
        val apiKey = MapplsApiClient.MAPPLS_REST_KEY
        val html = """
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset='utf-8' />
              <meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />
              <title>Mappls Cockpit Navigation</title>
              <script src='https://apis.mappls.com/advancedmaps/api/$apiKey/map_sdk?v=3.0&layer=vector&callback=initMap'></script>
              <style>
                :root { --accent-hex: $currentAccentHex; --accent-rgb: $currentAccentRgb; }
                body, html { margin:0; padding:0; height:100%; width:100%; overflow:hidden; font-family:sans-serif; }
                #map { position:absolute; top:0; bottom:0; width:100%; height:100%; }
                body.dark-mode, body.dark-mode #map { background:#000000 !important; }
                body.light-mode, body.light-mode #map { background:#F8FAFC !important; }
                body.dark-mode #map canvas { filter: invert(92%) hue-rotate(180deg) brightness(85%) contrast(108%) !important; }
                body.light-mode #map canvas { filter: none !important; }
                .mapboxgl-ctrl-attrib, .maplibregl-ctrl-attrib, .mappls-ctrl-attrib, .mappls-attrib,
                .mapboxgl-ctrl-bottom-right, .maplibregl-ctrl-bottom-right, .mappls-ctrl-bottom-right,
                .mapboxgl-ctrl-bottom-left, .maplibregl-ctrl-bottom-left, .mappls-ctrl-bottom-left,
                .mapboxgl-ctrl-logo, .maplibregl-ctrl-logo, .mappls-logo,
                .mapboxgl-compact, .maplibregl-compact,
                .mapboxgl-ctrl, .maplibregl-ctrl, .mappls-ctrl,
                div[class*='attrib'], div[class*='logo'], div[class*='ctrl-bottom'],
                a[href*='mapmyindia'], a[href*='mappls'], [title*='MapmyIndia'], [title*='Mappls'],
                .maplibregl-ctrl-attrib-inner, .mapboxgl-ctrl-attrib-inner {
                   display: none !important; visibility: hidden !important; opacity: 0 !important; height: 0 !important; width: 0 !important; pointer-events: none !important;
                }
                .puck-marker {
                   width: 44px; height: 44px;
                   background: radial-gradient(circle, rgba(var(--accent-rgb),0.45) 0%, rgba(var(--accent-rgb),0.1) 70%, transparent 100%);
                   border-radius: 50%;
                   display: flex; align-items: center; justify-content: center;
                   transition: transform 0.3s cubic-bezier(0.2, 0.9, 0.3, 1);
                }
                .puck-arrow {
                   width: 0; height: 0;
                   border-left: 9px solid transparent;
                   border-right: 9px solid transparent;
                   border-bottom: 22px solid var(--accent-hex);
                   filter: drop-shadow(0 0 8px var(--accent-hex));
                }
              </style>
            </head>
            <body class='dark-mode'>
            <div id='map'></div>
            <script>
              var map = null;
              var puckEl = null;
              var puckMarker = null;
              var routeLayerId = 'nav-route-line';
              var routeSourceId = 'nav-route-source';
              var currentAccentColor = '$currentAccentHex';

              function setMapAccentColor(hex, rgb) {
                currentAccentColor = hex;
                document.documentElement.style.setProperty('--accent-hex', hex);
                document.documentElement.style.setProperty('--accent-rgb', rgb);
                if (map && map.getLayer && map.getLayer(routeLayerId)) {
                  try { map.setPaintProperty(routeLayerId, 'line-color', hex); } catch(e) {}
                }
              }

              function purgeAttributions() {
                var toRemove = document.querySelectorAll('.mapboxgl-ctrl-attrib, .maplibregl-ctrl-attrib, .mappls-ctrl-attrib, .mapboxgl-ctrl-bottom-right, .maplibregl-ctrl-bottom-right, .mappls-ctrl-bottom-right, .mapboxgl-ctrl-bottom-left, .maplibregl-ctrl-bottom-left, .mappls-ctrl-bottom-left, .mapboxgl-ctrl-logo, .maplibregl-ctrl-logo, .mappls-logo, div[class*="attrib"], div[class*="logo"], a[href*="mapmyindia"], a[href*="mappls"]');
                for (var i = 0; i < toRemove.length; i++) {
                  var el = toRemove[i];
                  if (el && el.parentNode) { el.parentNode.removeChild(el); }
                }
              }
              setInterval(purgeAttributions, 300);

              function initMap() {
                if (map) return;
                console.log('initMap called, typeof mappls=' + typeof mappls);
                try {
                  if (typeof mappls === 'undefined' || !mappls.Map) {
                     setTimeout(initMap, 250);
                     return;
                  }
                  map = new mappls.Map('map', {
                    center: [$lastLat, $lastLng],
                    zoom: 15,
                    zoomControl: false,
                    attribution: false,
                    attributionControl: false
                  });
                  map.on('load', function() {
                    console.log('Mappls vector map loaded successfully!');
                    purgeAttributions();
                    createPuckMarker();
                    if (window.AndroidBridge) {
                      window.AndroidBridge.onMapInitialized();
                    }
                  });
                  map.on('error', function(err) {
                    console.error('Mappls map error: ' + JSON.stringify(err));
                  });
                  map.on('click', function(e) {
                    if (e && e.lngLat && window.AndroidBridge) {
                      window.AndroidBridge.onMapTapped(e.lngLat.lat, e.lngLat.lng);
                    }
                  });
                  map.on('dragstart', function() {
                    isUserInteracting = true;
                    if (window.AndroidBridge && window.AndroidBridge.onMapDragged) {
                      window.AndroidBridge.onMapDragged();
                    }
                  });
                  map.on('rotatestart', function() {
                    isUserInteracting = true;
                    if (window.AndroidBridge && window.AndroidBridge.onMapDragged) {
                      window.AndroidBridge.onMapDragged();
                    }
                  });
                  map.on('pitchstart', function() {
                    isUserInteracting = true;
                    if (window.AndroidBridge && window.AndroidBridge.onMapDragged) {
                      window.AndroidBridge.onMapDragged();
                    }
                  });
                  map.on('rotate', function() {
                    if (window.AndroidBridge && window.AndroidBridge.onMapBearingChanged && map) {
                      window.AndroidBridge.onMapBearingChanged(map.getBearing());
                    }
                  });
                } catch(err) {
                  console.error('initMap exception: ' + err);
                  setTimeout(initMap, 800);
                }
              }
              if (document.readyState === 'complete' || document.readyState === 'interactive') { initMap(); } else { window.addEventListener('DOMContentLoaded', initMap); }

              function createPuckMarker() {
                puckEl = document.createElement('div');
                puckEl.className = 'puck-marker';
                var arrow = document.createElement('div');
                arrow.className = 'puck-arrow';
                puckEl.appendChild(arrow);
                if (typeof mappls.Marker !== 'undefined') {
                   puckMarker = new mappls.Marker({
                      map: map,
                      position: {lat: $lastLat, lng: $lastLng},
                      element: puckEl
                   });
                }
              }
              var curRiderLat = $lastLat;
              var curRiderLng = $lastLng;
              var curBearing = 0;
              var isUserInteracting = false;
              var isNavigating = false;
              var is3DMode = false;

              function setNavigating(nav) {
                isNavigating = nav;
              }

              function setRiderPosition(lat, lng, bearing) {
                if (!map) return;
                curRiderLat = lat;
                curRiderLng = lng;
                curBearing = bearing;
                try {
                  if (puckMarker && puckMarker.setPosition) {
                    puckMarker.setPosition({lat: lat, lng: lng});
                  }
                  if (puckEl) {
                    puckEl.style.transform = 'rotate(' + bearing + 'deg)';
                  }
                  if (!isUserInteracting) {
                    map.easeTo({
                      center: [lng, lat],
                      bearing: (isNavigating || is3DMode) ? bearing : map.getBearing(),
                      pitch: is3DMode ? 55 : (isNavigating ? 45 : 0),
                      duration: 350
                    });
                  }
                } catch(e) {}
              }

              function recenterOnRider() {
                if (!map) return;
                isUserInteracting = false;
                try {
                  map.flyTo({
                    center: [curRiderLng, curRiderLat],
                    zoom: 16,
                    bearing: (is3DMode || isNavigating) ? curBearing : 0,
                    pitch: is3DMode ? 55 : (isNavigating ? 45 : 0),
                    speed: 1.3
                  });
                  if (window.AndroidBridge && window.AndroidBridge.onMapRecentered) {
                    window.AndroidBridge.onMapRecentered();
                  }
                } catch(e) {}
              }

              function toggleOrientation() {
                if (!map) return;
                try {
                  var currentBearing = map.getBearing();
                  if (Math.abs(currentBearing) > 5 && !is3DMode) {
                    is3DMode = false;
                    map.easeTo({ bearing: 0, pitch: 0, duration: 400 });
                    if (window.AndroidBridge && window.AndroidBridge.onOrientationModeChanged) {
                      window.AndroidBridge.onOrientationModeChanged(false, 0);
                    }
                  } else if (!is3DMode) {
                    is3DMode = true;
                    var targetBearing = (typeof curBearing !== 'undefined' && curBearing !== 0) ? curBearing : map.getBearing();
                    map.easeTo({ bearing: targetBearing, pitch: 55, duration: 500 });
                    if (window.AndroidBridge && window.AndroidBridge.onOrientationModeChanged) {
                      window.AndroidBridge.onOrientationModeChanged(true, targetBearing);
                    }
                  } else {
                    is3DMode = false;
                    map.easeTo({ bearing: 0, pitch: 0, duration: 400 });
                    if (window.AndroidBridge && window.AndroidBridge.onOrientationModeChanged) {
                      window.AndroidBridge.onOrientationModeChanged(false, 0);
                    }
                  }
                } catch(e) {
                  console.error('toggleOrientation error: ' + e);
                }
              }

              function resetNorth() {
                if (!map) return;
                is3DMode = false;
                try {
                  map.easeTo({
                    bearing: 0,
                    pitch: 0,
                    duration: 400
                  });
                  if (window.AndroidBridge && window.AndroidBridge.onOrientationModeChanged) {
                    window.AndroidBridge.onOrientationModeChanged(false, 0);
                  }
                  if (window.AndroidBridge && window.AndroidBridge.onMapBearingChanged) {
                    window.AndroidBridge.onMapBearingChanged(0);
                  }
                } catch(e) {}
              }

              var destMarker = null;
              function drawRouteLine(coordsJson) {
                if (!map) return;
                try {
                  var coords = JSON.parse(coordsJson);
                  if (map.getSource && map.getSource(routeSourceId)) {
                    map.getSource(routeSourceId).setData({
                      'type': 'Feature',
                      'properties': {},
                      'geometry': {
                        'type': 'LineString',
                        'coordinates': coords
                      }
                    });
                  } else if (map.addSource) {
                    map.addSource(routeSourceId, {
                      'type': 'geojson',
                      'data': {
                        'type': 'Feature',
                        'properties': {},
                        'geometry': {
                          'type': 'LineString',
                          'coordinates': coords
                        }
                      }
                    });
                    map.addLayer({
                      'id': routeLayerId,
                      'type': 'line',
                      'source': routeSourceId,
                      'layout': { 'line-join': 'round', 'line-cap': 'round' },
                      'paint': {
                        'line-color': currentAccentColor,
                        'line-width': 7,
                        'line-opacity': 0.95
                      }
                    });
                  }
                  if (coords && coords.length > 0 && typeof mappls.Marker !== 'undefined') {
                    var endPt = coords[coords.length - 1];
                    if (destMarker && destMarker.setPosition) {
                      destMarker.setPosition({lng: endPt[0], lat: endPt[1]});
                    } else {
                      var pinEl = document.createElement('div');
                      pinEl.style.width = '24px'; pinEl.style.height = '24px';
                      pinEl.style.borderRadius = '50%'; pinEl.style.background = '#EF4444';
                      pinEl.style.border = '3px solid #FFFFFF'; pinEl.style.boxShadow = '0 0 10px rgba(239,68,68,0.9)';
                      destMarker = new mappls.Marker({ map: map, position: {lng: endPt[0], lat: endPt[1]}, element: pinEl });
                    }
                  }
                } catch(e) {}
              }

              function fitRouteBounds(coordsJson) {
                if (!map) return;
                try {
                  var coords = JSON.parse(coordsJson);
                  if (!coords || coords.length === 0) return;
                  var minX = coords[0][0], minY = coords[0][1], maxX = coords[0][0], maxY = coords[0][1];
                  for (var i = 1; i < coords.length; i++) {
                    if (coords[i][0] < minX) minX = coords[i][0];
                    if (coords[i][0] > maxX) maxX = coords[i][0];
                    if (coords[i][1] < minY) minY = coords[i][1];
                    if (coords[i][1] > maxY) maxY = coords[i][1];
                  }
                  map.fitBounds([[minX, minY], [maxX, maxY]], { padding: 80, duration: 600 });
                } catch(e) {}
              }

              function clearRouteLine() {
                if (!map) return;
                try {
                  if (destMarker && destMarker.remove) { destMarker.remove(); destMarker = null; }
                  if (map.getLayer && map.getLayer(routeLayerId)) map.removeLayer(routeLayerId);
                  if (map.getSource && map.getSource(routeSourceId)) map.removeSource(routeSourceId);
                } catch(e) {}
              }

              function zoomIn() { if (map && map.zoomIn) map.zoomIn(); }
              function zoomOut() { if (map && map.zoomOut) map.zoomOut(); }
              function setMapTheme(isDark) {
                document.body.className = isDark ? 'dark-mode' : 'light-mode';
                var canvases = document.querySelectorAll('canvas');
                for (var i = 0; i < canvases.length; i++) {
                  canvases[i].style.filter = isDark ? 'invert(92%) hue-rotate(180deg) brightness(85%) contrast(108%) !important' : 'none !important';
                }
              }
              function setSatellite(isSat) { setMapTheme(!isSat); }
            </script>
            </body>
            </html>
        """.trimIndent()

        webView?.loadDataWithBaseURL("https://apis.mappls.com/", html, "text/html", "UTF-8", null)
    }

    fun setThemeAccent(accentColor: Int) {
        val r = Color.red(accentColor)
        val g = Color.green(accentColor)
        val b = Color.blue(accentColor)
        currentAccentHex = String.format("#%06X", 0xFFFFFF and accentColor)
        currentAccentRgb = "$r, $g, $b"
        if (!isMapLoaded || webView == null) return
        mainHandler.post {
            val script = String.format(
                Locale.US,
                "setMapAccentColor('%s', '%s');",
                currentAccentHex,
                currentAccentRgb
            )
            webView?.evaluateJavascript(script, null)
        }
    }

    fun updateRiderLocation(lat: Double, lng: Double, bearing: Float) {
        lastLat = lat
        lastLng = lng
        lastBearing = bearing
        try {
            context.getSharedPreferences("bajaj_ride_prefs", Context.MODE_PRIVATE)
                .edit()
                .putFloat("saved_rider_lat", lat.toFloat())
                .putFloat("saved_rider_lng", lng.toFloat())
                .apply()
        } catch (ignored: Exception) {}
        if (!isMapLoaded) return

        mainHandler.post {
            val script = String.format(Locale.US, "setRiderPosition(%.6f, %.6f, %.1f);", lat, lng, bearing)
            webView?.evaluateJavascript(script, null)
        }
    }

    fun plotRoute(coordinatesLngLat: List<DoubleArray>?) {
        if (!isMapLoaded || coordinatesLngLat.isNullOrEmpty()) return

        mainHandler.post {
            try {
                val arr = JSONArray()
                for (point in coordinatesLngLat) {
                    val p = JSONArray().apply {
                        put(point[0]) // Lng
                        put(point[1]) // Lat
                    }
                    arr.put(p)
                }
                val script = "drawRouteLine('$arr');"
                webView?.evaluateJavascript(script, null)
            } catch (ignored: Exception) {}
        }
    }

    fun fitRouteBounds(coordinatesLngLat: List<DoubleArray>?) {
        if (!isMapLoaded || coordinatesLngLat.isNullOrEmpty()) return

        mainHandler.post {
            try {
                val arr = JSONArray()
                for (point in coordinatesLngLat) {
                    val p = JSONArray().apply {
                        put(point[0]) // Lng
                        put(point[1]) // Lat
                    }
                    arr.put(p)
                }
                val script = "fitRouteBounds('$arr');"
                webView?.evaluateJavascript(script, null)
            } catch (ignored: Exception) {}
        }
    }

    fun clearRoute() {
        if (!isMapLoaded) return
        mainHandler.post { webView?.evaluateJavascript("clearRouteLine();", null) }
    }

    fun zoomIn() {
        if (!isMapLoaded) return
        mainHandler.post { webView?.evaluateJavascript("zoomIn();", null) }
    }

    fun zoomOut() {
        if (!isMapLoaded) return
        mainHandler.post { webView?.evaluateJavascript("zoomOut();", null) }
    }

    fun setMapTheme(dark: Boolean) {
        this.isDarkMode = dark
        if (!isMapLoaded) return
        mainHandler.post { webView?.evaluateJavascript("setMapTheme($dark);", null) }
    }

    fun toggleMapTheme() {
        setMapTheme(!isDarkMode)
    }

    fun setSatelliteMode(satellite: Boolean) {
        setMapTheme(!satellite)
    }

    fun centerOnCurrentLocation() {
        if (!isMapLoaded) return
        mainHandler.post { webView?.evaluateJavascript("recenterOnRider();", null) }
    }

    fun resetNorth() {
        if (!isMapLoaded) return
        mainHandler.post { webView?.evaluateJavascript("resetNorth();", null) }
    }

    fun toggleOrientation() {
        if (!isMapLoaded) return
        mainHandler.post { webView?.evaluateJavascript("toggleOrientation();", null) }
    }

    fun setNavigating(navigating: Boolean) {
        if (!isMapLoaded) return
        mainHandler.post { webView?.evaluateJavascript("setNavigating($navigating);", null) }
    }

    fun simulateDrag() {
        if (!isMapLoaded) return
        mainHandler.post {
            webView?.evaluateJavascript(
                "if (map) { map.panBy([150, 150]); isUserInteracting = true; if (window.AndroidBridge && window.AndroidBridge.onMapDragged) window.AndroidBridge.onMapDragged(); }",
                null
            )
        }
    }

    fun centerOnLocation(lat: Double, lng: Double) {
        lastLat = lat
        lastLng = lng
        if (!isMapLoaded) return
        mainHandler.post {
            val script = String.format(
                Locale.US,
                "if (map) { map.flyTo({ center: [%.6f, %.6f], zoom: 16, speed: 1.3 }); }",
                lng,
                lat
            )
            webView?.evaluateJavascript(script, null)
        }
    }

    fun setCornerRadius(radiusDp: Float) {
        this.cornerRadiusDp = radiusDp
        updateClipPath()
        invalidateOutline()
        invalidate()
    }

    private fun updateClipPath() {
        clipPath.reset()
        val w = width
        val h = height
        if (w <= 0 || h <= 0) return
        rectF.set(0f, 0f, w.toFloat(), h.toFloat())
        val r = cornerRadiusDp * resources.displayMetrics.density
        clipPath.addRoundRect(rectF, r, r, Path.Direction.CW)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        updateClipPath()
    }

    override fun draw(canvas: Canvas) {
        if (!clipPath.isEmpty) {
            canvas.save()
            canvas.clipPath(clipPath)
            super.draw(canvas)
            canvas.restore()
        } else {
            super.draw(canvas)
        }
    }

    override fun dispatchDraw(canvas: Canvas) {
        if (!clipPath.isEmpty) {
            canvas.save()
            canvas.clipPath(clipPath)
            super.dispatchDraw(canvas)
            canvas.restore()
        } else {
            super.dispatchDraw(canvas)
        }
    }

    fun onResume() {
        webView?.onResume()
    }

    fun onPause() {
        webView?.onPause()
    }

    fun onDestroy() {
        mainHandler.removeCallbacksAndMessages(null)
        webView?.let { wv ->
            removeView(wv)
            wv.stopLoading()
            wv.clearHistory()
            wv.clearCache(true)
            wv.loadUrl("about:blank")
            wv.onPause()
            wv.removeAllViews()
            wv.destroy()
            webView = null
        }
    }
}
