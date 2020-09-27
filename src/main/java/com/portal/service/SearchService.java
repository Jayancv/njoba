package com.portal.service;

import com.portal.operationUtils.AdSearchCriteria;
import com.portal.model.Advertisement;
import com.portal.operationUtils.AvailabilityResult;

import java.util.List;
import java.util.Map;

public interface SearchService {
    /**
     * Uses to search advertisements using different criteria
     *
     * @param criteria
     * @return Advertisement list
     */
    List<Advertisement> searchAdvertisements(AdSearchCriteria criteria);

    /**
     * Provide remaining advertisement count against productType id
     *
     * @param souvenirId
     * @param adTypeId
     * @param productId
     * @return
     */
    AvailabilityResult checkAvailability(long souvenirId, long adTypeId, long productId);
}
