package com.portal.service;

import com.portal.operationUtils.criteria.AdSearchCriteria;
import com.portal.model.Advertisement;
import com.portal.operationUtils.result.AvailabilityResult;

import java.util.List;

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
