package com.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portal.exception.ResourceNotFoundException;
import com.portal.model.BasicAdvertisement;
import com.portal.repository.BasicAdvertisementRepository;

@Service
public class BasicAdvertisementServiceImpl implements BasicAdvertisementService {

    @Autowired
    BasicAdvertisementRepository basicAdvertisementRepository;

    @Autowired
    ProductTypeService productTypeService;

	@Autowired
	AdvertisementService advertisementService;

    @Override
    public List<BasicAdvertisement> getAll() {
        return basicAdvertisementRepository.findAll();
    }

    @Override
    public BasicAdvertisement create(BasicAdvertisement obj) {
        /**
         * Reduce selling units
         * If success then save the advertisement
         */

        if (obj.getProductType() != null && productTypeService.reduceUnitCount(obj.getProductType().getId(), 1)) {
            obj.setAdCode(advertisementService.generateAdCode(obj.getUserAdvertisement()));
            BasicAdvertisement ad = null;
            try {
                ad = basicAdvertisementRepository.save(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ad != null && ad.getId() != null && !ad.getId().isEmpty()) { // reduce unit count after successfully saving advertisement
                productTypeService.revertUnitCount(obj.getProductType().getId(), 1);
            }
            return ad;
        }
        return null;
    }

    @Override
    public BasicAdvertisement getById(String id) {
        return basicAdvertisementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
    }

    @Override
    public BasicAdvertisement update(String id, BasicAdvertisement obj) {
        BasicAdvertisement basicAd = basicAdvertisementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ad", "id", id));
        basicAd.setAdCode(obj.getAdCode());
        basicAd.setAdId(obj.getAdId());
        BasicAdvertisement updatedNode = basicAdvertisementRepository.save(basicAd);
        return updatedNode;
    }

    @Override
    public BasicAdvertisement delete(String id, BasicAdvertisement obj) {
        BasicAdvertisement basicAdvertisement = basicAdvertisementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ad", "id", id));
        basicAdvertisement.setStatusCode(false);
        BasicAdvertisement deletedNote = basicAdvertisementRepository.save(basicAdvertisement);
        return deletedNote;
    }

    @Override
    public ResponseEntity<String> hardDelete(String id) {
        basicAdvertisementRepository.deleteById(id);
        return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
    }


}
