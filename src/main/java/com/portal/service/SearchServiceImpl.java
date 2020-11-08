package com.portal.service;

import com.portal.operationUtils.*;
import com.portal.model.Advertisement;
import com.portal.model.ProductType;
import com.portal.operationUtils.criteria.AdSearchCriteria;
import com.portal.operationUtils.criteria.SearchCriteria;
import com.portal.operationUtils.result.AdTypeResult;
import com.portal.operationUtils.result.AvailabilityResult;
import com.portal.operationUtils.result.ProductTypeResult;
import com.portal.operationUtils.result.SouvenirResult;
import com.portal.repository.ProductTypeRepository;
import com.portal.repository.AdvertisementRepository;
import com.portal.specification.AdSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService {

    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Override
    public List<Advertisement> searchAdvertisements(AdSearchCriteria criteria) {
        //TODO need to complete search
        AdSpecification spec = new AdSpecification();
        if (criteria.getAdId() > 0) {
            spec.add(new SearchCriteria("adId", criteria.getAdId(), SearchOperation.EQUAL));
        }
        if (criteria.getId() != null && !criteria.getId().isEmpty()) {
            spec.add(new SearchCriteria("id", criteria.getId(), SearchOperation.EQUAL));
        }
        if (criteria.getAdCode() != null && !criteria.getAdCode().isEmpty()) {
            spec.add(new SearchCriteria("adCode", criteria.getAdCode(), SearchOperation.EQUAL));
        }
        if (criteria.getAdType() > 0) {
            spec.add(new SearchCriteria("advertisementType~id", criteria.getAdType(), SearchOperation.EQUAL));
        }
        if (criteria.getUserId() != null && !criteria.getUserId().isEmpty()) {
            spec.add(new SearchCriteria("userAdvertisement~id", criteria.getUserId(), SearchOperation.MATCH));
        }
        if (criteria.getTeamId() != null && !criteria.getTeamId().isEmpty()) {
            spec.add(new SearchCriteria("userAdvertisement:userTeam:id", criteria.getTeamId(), SearchOperation.MATCH));
        }
        if (criteria.getOrgId() > 0) {
            spec.add(new SearchCriteria("orgId", criteria.getOrgId(), SearchOperation.EQUAL));
        }
        if (criteria.getCompanyName() != null && !criteria.getCompanyName().isEmpty()) {
            spec.add(new SearchCriteria("orgName", criteria.getCompanyName(), SearchOperation.EQUAL));
        }
        if (criteria.getStatus() > 0) {
            spec.add(new SearchCriteria("status", criteria.getStatus(), SearchOperation.EQUAL));
        }


        List<Advertisement> result = advertisementRepository.findAll(spec);
        return result;
    }

    @Override
    public AvailabilityResult checkAvailability(long souvenirId, long adTypeId, long productId) {
        Map<Long, Integer> availabilityMap = new HashMap<>();
        AvailabilityResult availResult = new AvailabilityResult();
        ProductType productType = null;
        //validate souvenirId and ProductId
        if (souvenirId > 0 && productId > 0) {
            Optional<ProductType> productTypeOpt = productTypeRepository.findById(productId);
            if (productTypeOpt.isPresent()) {
                productType = productTypeOpt.get();
                if (productType.getSouvenir().getId() != souvenirId) {
                    return availResult;
                }
            }
        }
        //validate adTypeId and ProductId
        if (adTypeId > 0 && productId > 0) {
            Optional<ProductType> productTypeOpt = productTypeRepository.findById(productId);
            if (productTypeOpt.isPresent()) {
                productType = productTypeOpt.get();
                if (productType.getAdvertisementType().getId() != adTypeId) {
                    return availResult;
                }
            }
        }
        //If souvenirId and ProductId match
        //Send availability for
        if (productId > 0) {
            if (productType == null) {
                Optional<ProductType> productTypeOpt = productTypeRepository.findById(productId);
                if (productTypeOpt.isPresent()) {
                    productType = productTypeOpt.get();
                }
            }
            if (productType != null) {

                fillProductTypeToResult(productType, availResult);
                availabilityMap.put(productId, productType.getSellingUnit().getRemainCount());
            }
            return availResult;

        } else if (adTypeId > 0) {
            if (souvenirId > 0) {
                List<ProductType> list1 = productTypeRepository.findBySouvenir_Id(souvenirId);
                List<ProductType> list2 = productTypeRepository.findByAdvertisementType_Id(adTypeId);

                for (ProductType type1 : list1) {
                    for (ProductType type2 : list2) {
                        if (type1.getId() == type2.getId()) {
                            fillProductTypeToResult(type1, availResult);
                            availabilityMap.put(type1.getId(), type1.getSellingUnit().getRemainCount());
                            break;
                        }
                    }
                }
            } else {
                List<ProductType> list = productTypeRepository.findByAdvertisementType_Id(adTypeId);
                for (ProductType type : list) {
                    fillProductTypeToResult(type, availResult);
                    availabilityMap.put(type.getId(), type.getSellingUnit().getRemainCount());
                }
            }
            return availResult;

        } else if (souvenirId > 0) {
            List<ProductType> list = productTypeRepository.findBySouvenir_Id(souvenirId);
            for (ProductType type : list) {
                fillProductTypeToResult(type, availResult);
                availabilityMap.put(type.getId(), type.getSellingUnit().getRemainCount());
            }
            return availResult;

        }
        return availResult;

    }

    private void fillProductTypeToResult(ProductType productType, AvailabilityResult availResult) {
        ProductTypeResult productResult = new ProductTypeResult(productType.getId(), productType.getProdCode(),
                productType.getProdName(), productType.getSellingUnit().getRemainCount(), productType.getSellingUnit().getPrice());

        if (availResult.getSouvenirResults().get(productType.getSouvenir().getId()) == null) {
            SouvenirResult souvResult = new SouvenirResult(productType.getSouvenir().getId(), productType.getSouvenir().getSouvenirCode(), productType.getSouvenir().getYear());
            availResult.getSouvenirResults().put(productType.getSouvenir().getId(), souvResult);
        }
        if (availResult.getSouvenirResults().get(productType.getSouvenir().getId()).getAdTypeResults().get(productType.getAdvertisementType().getId()) == null) {
            AdTypeResult typeResult = new AdTypeResult(productType.getAdvertisementType().getId(), productType.getAdvertisementType().getTypeCode());
            availResult.getSouvenirResults().get(productType.getSouvenir().getId()).getAdTypeResults().put(productType.getAdvertisementType().getId(), typeResult);
        }
        availResult.getSouvenirResults().get(productType.getSouvenir().getId()).getAdTypeResults()
                .get(productType.getAdvertisementType().getId()).getProductTypeResults().put(productType.getId(), productResult);
    }

}
