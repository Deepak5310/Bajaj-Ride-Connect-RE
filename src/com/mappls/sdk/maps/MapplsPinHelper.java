package com.mappls.sdk.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
class MapplsPinHelper {
    private static final MapplsPinHelper ourInstance = new MapplsPinHelper();
    private HashMap<String, CoordinateResult> mapplsPinMap = new HashMap<>();

    private MapplsPinHelper() {
    }

    static MapplsPinHelper getInstance() {
        return ourInstance;
    }

    void getAnnotation(String str, final CoordinateCallback coordinateCallback) {
        if (this.mapplsPinMap.containsKey(str.toUpperCase())) {
            List<CoordinateResult> arrayList = new ArrayList<>();
            arrayList.add(this.mapplsPinMap.get(str.toUpperCase()));
            if (coordinateCallback != null) {
                coordinateCallback.coordinateResultSuccess(arrayList);
                return;
            }
            return;
        }
        MapplsGetCoordinates.builder().mapplsPin(str).build().enqueueCall(new Callback<CoordinateResponse>() { // from class: com.mappls.sdk.maps.MapplsPinHelper.1
            @Override // retrofit2.Callback
            public void onResponse(Call<CoordinateResponse> call, Response<CoordinateResponse> response) {
                if (response.code() == 200 && response.body() != null) {
                    List<CoordinateResult> results = response.body().getResults();
                    if (results != null && results.size() > 0 && results.get(0) != null) {
                        CoordinateResult coordinateResult = results.get(0);
                        if (coordinateResult.getMapplsPin() != null && coordinateResult.getLongitude() != null && coordinateResult.getLatitude() != null) {
                            MapplsPinHelper.this.mapplsPinMap.put(coordinateResult.getMapplsPin().toUpperCase(), coordinateResult);
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(coordinateResult);
                            CoordinateCallback coordinateCallback2 = coordinateCallback;
                            if (coordinateCallback2 != null) {
                                coordinateCallback2.coordinateResultSuccess(arrayList2);
                                return;
                            }
                            return;
                        }
                        CoordinateCallback coordinateCallback3 = coordinateCallback;
                        if (coordinateCallback3 != null) {
                            coordinateCallback3.onFailure();
                            return;
                        }
                        return;
                    }
                    CoordinateCallback coordinateCallback4 = coordinateCallback;
                    if (coordinateCallback4 != null) {
                        coordinateCallback4.onFailure();
                        return;
                    }
                    return;
                }
                CoordinateCallback coordinateCallback5 = coordinateCallback;
                if (coordinateCallback5 != null) {
                    coordinateCallback5.onFailure();
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<CoordinateResponse> call, Throwable th) {
                CoordinateCallback coordinateCallback2 = coordinateCallback;
                if (coordinateCallback2 != null) {
                    coordinateCallback2.onFailure();
                }
            }
        });
    }

    void getAnnotation(List<String> list, final CoordinateCallback coordinateCallback) {
        final List<CoordinateResult> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (String str : list) {
            if (this.mapplsPinMap.containsKey(str.toUpperCase())) {
                arrayList.add(this.mapplsPinMap.get(str.toUpperCase()));
            } else {
                arrayList2.add(str);
            }
        }
        if (arrayList2.size() > 0) {
            MapplsGetCoordinates.builder().mapplsPin(arrayList2).build().enqueueCall(new Callback<CoordinateResponse>() { // from class: com.mappls.sdk.maps.MapplsPinHelper.2
                @Override // retrofit2.Callback
                public void onResponse(Call<CoordinateResponse> call, Response<CoordinateResponse> response) {
                    if (response.code() == 200 && response.body() != null) {
                        List<CoordinateResult> results = response.body().getResults();
                        if (results != null && results.size() > 0) {
                            for (CoordinateResult coordinateResult : results) {
                                if (coordinateResult.getMapplsPin() != null && coordinateResult.getLongitude() != null && coordinateResult.getLatitude() != null) {
                                    MapplsPinHelper.this.mapplsPinMap.put(coordinateResult.getMapplsPin().toUpperCase(), coordinateResult);
                                    arrayList.add(coordinateResult);
                                }
                            }
                            CoordinateCallback coordinateCallback2 = coordinateCallback;
                            if (coordinateCallback2 != null) {
                                coordinateCallback2.coordinateResultSuccess(arrayList);
                                return;
                            }
                            return;
                        }
                        CoordinateCallback coordinateCallback3 = coordinateCallback;
                        if (coordinateCallback3 != null) {
                            coordinateCallback3.coordinateResultSuccess(arrayList);
                            return;
                        }
                        return;
                    }
                    CoordinateCallback coordinateCallback4 = coordinateCallback;
                    if (coordinateCallback4 != null) {
                        coordinateCallback4.coordinateResultSuccess(arrayList);
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<CoordinateResponse> call, Throwable th) {
                    CoordinateCallback coordinateCallback2 = coordinateCallback;
                    if (coordinateCallback2 != null) {
                        coordinateCallback2.coordinateResultSuccess(arrayList);
                    }
                }
            });
        } else if (coordinateCallback != null) {
            coordinateCallback.coordinateResultSuccess(arrayList);
        }
    }
}
