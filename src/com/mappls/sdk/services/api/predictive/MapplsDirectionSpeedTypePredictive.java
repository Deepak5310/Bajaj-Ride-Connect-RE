package com.mappls.sdk.services.api.predictive;

import com.mappls.sdk.services.api.directions.predictive.MapplsDirectionDateTime;
import com.mappls.sdk.services.api.predictive.distance.PredictiveDistanceCriteria;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsDirectionSpeedTypePredictive implements MapplsDirectionSpeedType {
    private MapplsDirectionDateTime mapplsDirectionDateTime;

    public MapplsDirectionSpeedTypePredictive(MapplsDirectionDateTime mapplsDirectionDateTime) {
        this.mapplsDirectionDateTime = mapplsDirectionDateTime;
    }

    @Override // com.mappls.sdk.services.api.predictive.MapplsDirectionSpeedType
    public String speedType() {
        return PredictiveDistanceCriteria.SPEED_TYPES_PREDICTIVE;
    }

    @Override // com.mappls.sdk.services.api.predictive.MapplsDirectionSpeedType
    public String speedDateTime() {
        return this.mapplsDirectionDateTime.type() + "," + this.mapplsDirectionDateTime.dateTime();
    }
}
