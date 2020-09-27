package com.portal.service;

import com.portal.model.User;

public interface AdvertisementService {
    /**
     * Advertisement code : this code generates using team code,user code and user advertisement Count
     * @param usr
     * @return
     */
    String generateAdCode(User usr);
}
