package com.mappls.sdk.services.api.predictive;

import com.mappls.sdk.services.api.predictive.distance.PredictiveDistanceCriteria;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsDirectionSpeedTypeOptimal implements MapplsDirectionSpeedType {
    @Override // com.mappls.sdk.services.api.predictive.MapplsDirectionSpeedType
    public String speedDateTime() {
        return null;
    }

    @Override // com.mappls.sdk.services.api.predictive.MapplsDirectionSpeedType
    public String speedType() {
        return PredictiveDistanceCriteria.SPEED_TYPES_OPTIMAL;
    }
}
