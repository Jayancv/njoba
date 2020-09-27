package com.portal.controller;

import com.portal.model.Advertisement;
import com.portal.operationUtils.AdSearchCriteria;
import com.portal.operationUtils.AvailabilityResult;
import com.portal.service.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class AdOperationController {

    @Autowired
    SearchServiceImpl searchService;

    @GetMapping("/search")
    public List<Advertisement> search(
            @RequestParam(name = "adId", required = false, defaultValue = "0") long ad_id,
            @RequestParam(name = "id", required = false) String id,
            @RequestParam(name = "adCode", required = false) String ad_code,
            @RequestParam(name = "adType", required = false, defaultValue = "0") int adType,
            @RequestParam(name = "userId", required = false) String userId,
            @RequestParam(name = "teamId", required = false) String teamId,
            @RequestParam(name = "orgId", required = false, defaultValue = "0") long orgId,
            @RequestParam(name = "companyName", required = false) String companyName,
            @RequestParam(name = "status", required = false, defaultValue = "0") int status
    ) {
        AdSearchCriteria adSearchCriteria = new AdSearchCriteria();
        adSearchCriteria.setAdId(ad_id);
        adSearchCriteria.setId(id);
        adSearchCriteria.setAdCode(ad_code);
        adSearchCriteria.setAdType(adType);
        adSearchCriteria.setUserId(userId);
        adSearchCriteria.setTeamId(teamId);
        adSearchCriteria.setOrgId(orgId);
        adSearchCriteria.setCompanyName(companyName);
        adSearchCriteria.setStatus(status);
        return searchService.searchAdvertisements(adSearchCriteria);
    }

    @GetMapping("/availCheck")
    public AvailabilityResult checkAvailability(@RequestParam(name = "souvenirId", required = false, defaultValue = "0") long souvenirId,
                                                @RequestParam(name = "adTypeId", required = false, defaultValue = "0") long adTypeId,
                                                @RequestParam(name = "productTypeId", required = false, defaultValue = "0") long productTypeId) {
        return searchService.checkAvailability(souvenirId, adTypeId, productTypeId);
    }

}
