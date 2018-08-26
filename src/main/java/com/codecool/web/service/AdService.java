package com.codecool.web.service;

import com.codecool.web.dto.AdDto;
import com.codecool.web.dto.UserAdDto;
import com.codecool.web.exception.NotEnoughBalanceForPremiumException;
import com.codecool.web.model.Ad;
import com.codecool.web.model.Notification;
import com.codecool.web.model.NotificationBuilder;
import com.codecool.web.model.User;
import com.codecool.web.repository.AdRepository;
import com.codecool.web.repository.NotificationRepository;
import com.codecool.web.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AdService {

    private static final Logger logger = LoggerFactory.getLogger(AdService.class);

    @Autowired
    private AdRepository adRepository;
    @Autowired
    private UserRepository uRepo;
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Ad> getAllForAdmin() {
        return adRepository.findAllByOrderByIsPremiumDescTimestampDesc();
    }

    public List<Ad> getAll() {
        return adRepository.findAllByStateOrderByIsPremiumDescTimestampDesc("Pending");
    }

    public List<Ad> getAllByAdvertiserId(int id) {
        return adRepository.findAllByStateAndAdvertiser_IdOrderByIsPremiumDescTimestampDesc("Pending", id);
    }

    private List<Ad> getAllByCategory(String category) {
        return adRepository.findAllByStateAndCategoryOrderByIsPremiumDescTimestampDesc("Pending", category);
    }

    private List<Ad> getAllByType(String type) {
        return adRepository.findAllByStateAndTypeOrderByIsPremiumDescTimestampDesc("Pending", type);
    }

    private List<Ad> getAllByCategoryAndType(String category, String type) {
        return adRepository.findAllByStateAndCategoryAndTypeOrderByIsPremiumDescTimestampDesc("Pending", category, type);
    }

    private List<Ad> getAllByTitleOrDescriptionContaining(String keyword) {
        List<Ad> ads = new ArrayList<>(adRepository.findAllByStateAndTitleContainingIgnoreCaseOrderByIsPremiumDescTimestampDesc("Pending", keyword));
        List<Ad> adsByDescription = adRepository.findAllByStateAndDescriptionContainingIgnoreCaseOrderByIsPremiumDescTimestampDesc("Pending", keyword);
        for (Ad ad : adsByDescription) {
            if (!ads.contains(ad)) {
                ads.add(ad);
            }
        }
        return ads;
    }

    private List<Ad> getAllByKeywordAndCategory(String keyword, String category) {
        List<Ad> ads = new ArrayList<>(adRepository.findAllByStateAndTitleContainingIgnoreCaseAndCategoryOrderByIsPremiumDescTimestampDesc("Pending", keyword, category));
        List<Ad> adsByDescriptionAndCategory = adRepository.findAllByStateAndDescriptionContainingIgnoreCaseAndCategoryOrderByIsPremiumDescTimestampDesc("Pending", keyword, category);
        for (Ad ad : adsByDescriptionAndCategory) {
            if (!ads.contains(ad)) {
                ads.add(ad);
            }
        }
        return ads;
    }

    private List<Ad> getAllByKeywordAndType(String keyword, String type) {
        List<Ad> ads = new ArrayList<>(adRepository.findAllByStateAndTitleContainingIgnoreCaseAndTypeOrderByIsPremiumDescTimestampDesc("Pending", keyword, type));
        List<Ad> adsByDescriptionAndCategory = adRepository.findAllByStateAndDescriptionContainingIgnoreCaseAndTypeOrderByIsPremiumDescTimestampDesc("Pending", keyword, type);
        for (Ad ad : adsByDescriptionAndCategory) {
            if (!ads.contains(ad)) {
                ads.add(ad);
            }
        }
        return ads;
    }

    private List<Ad> getAllByKeywordAndCategoryAndType(String keyword, String category, String type) {
        List<Ad> ads = new ArrayList<>(adRepository.findAllByStateAndTitleContainingIgnoreCaseAndCategoryAndTypeOrderByIsPremiumDescTimestampDesc("Pending", keyword, category, type));
        List<Ad> adsByDescriptionAndCategoryAndType = adRepository.findAllByStateAndDescriptionContainingIgnoreCaseAndCategoryAndTypeOrderByIsPremiumDescTimestampDesc("Pending", keyword, category, type);
        for (Ad ad : adsByDescriptionAndCategoryAndType) {
            if (!ads.contains(ad)) {
                ads.add(ad);
            }
        }
        return ads;
    }

    public List<Ad> getAllByFilter(String keyword, String category, String type) {
        List<Ad> filteredAds = new ArrayList<>();
        if (keyword.equals("") && category.equals("All") && type.equals("All")) {
            filteredAds = getAll();
        }

        if (!keyword.equals("") && category.equals("All") && type.equals("All")) {
            filteredAds = getAllByTitleOrDescriptionContaining(keyword);
        }

        if (keyword.equals("") && !category.equals("All") && type.equals("All")) {
            filteredAds = getAllByCategory(category);
        }

        if (keyword.equals("") && category.equals("All") && !type.equals("All")) {
            filteredAds = getAllByType(type);
        }

        if (!keyword.equals("") && !category.equals("All") && type.equals("All")) {
            filteredAds = getAllByKeywordAndCategory(keyword, category);
        }

        if (!keyword.equals("") && category.equals("All") && !type.equals("All")) {
            filteredAds = getAllByKeywordAndType(keyword, type);
        }

        if (keyword.equals("") && !category.equals("All") && !type.equals("All")) {
            filteredAds = getAllByCategoryAndType(category, type);
        }

        if (!keyword.equals("") && !category.equals("All") && !type.equals("All")) {
            filteredAds = getAllByKeywordAndCategoryAndType(keyword, category, type);
        }

        return filteredAds;
    }

    public Ad getById(int id) {
        return adRepository.findById(id);
    }

    public User addNewAd(AdDto adDto) throws NotEnoughBalanceForPremiumException {
        adDto.setTimestamp(new Timestamp(new Date().getTime()).toLocalDateTime());
        adDto.setState("Pending");
        // if premium decrease golden hand amount by 1
        if (adDto.getIsPremium()) {
            User user = uRepo.findById(adDto.getAdvertiserId());
            if (user.getBalance() > 0) {
                user.setBalance(user.getBalance() - 1);
                uRepo.save(user);
            } else {
                throw new NotEnoughBalanceForPremiumException();
            }
        }
        Ad ad = new Ad(adDto, uRepo.findById(adDto.getAdvertiserId()));
        adRepository.save(ad);
        logger.info(ad.getAdvertiser().getUserName() + " has created a new ad in the Category " + ad.getCategory() + " with ID " + ad.getId());
        return uRepo.findById(adDto.getAdvertiserId());
    }

    public void deleteAd(int id) {
        Ad ad = adRepository.findById(id);
        ad.setState("Archive");
        adRepository.save(ad);
        logger.info("The state of the ad with ID " + ad.getId() + " has been changed to 'Archive'");
    }

    public Ad updateAdData(Ad ad) {
        adRepository.save(ad);
        logger.info("The ad with ID " + ad.getId() + " has been updated");
        return ad;
    }

    public AdDto blockAd(int id) {
        Ad ad = adRepository.findById(id);
        User advertiser = ad.getAdvertiser();

        ad.setState("Blocked");
        adRepository.save(ad);

        Notification notification = NotificationBuilder.createBlockAdNotification(advertiser, advertiser, ad);
        notificationRepository.save(notification);

        return new AdDto(ad);
    }

    public UserAdDto setPremiumToTrue(AdDto adDto) throws NotEnoughBalanceForPremiumException {

        User user = uRepo.findById(adDto.getAdvertiserId());
        if (user.getBalance() > 0) {
            user.setBalance(user.getBalance() - 1);
            uRepo.save(user);
        } else {
            throw new NotEnoughBalanceForPremiumException();
        }
        Ad ad = adRepository.findById(adDto.getId());
        ad.setPremium(true);
        adRepository.save(ad);
        AdDto changed = new AdDto(ad);
        return new UserAdDto(user, changed);
    }


}
