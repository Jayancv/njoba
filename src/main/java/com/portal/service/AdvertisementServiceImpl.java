package com.portal.service;

import com.portal.model.User;
import com.portal.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementServiceImpl implements AdvertisementService{

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Autowired
    UserService userService;

    public String generateAdCode(User usr) {
        //Todo What happens when user delete an ad ? Then ad count is not a unique number
        User user = userService.getById(usr.getId());
        String adSize = String.valueOf(advertisementRepository.findByUserAdvertisement_Id(user.getId()).size() + 1);
        String adSizeStr = ("0000" + adSize).substring(adSize.length());
        return user.getUserTeam().getTeamCode() + "_" + user.getUserCode() + "_" + adSizeStr;
    }
}
