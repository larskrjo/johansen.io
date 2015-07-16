package net.larskristian.api.dto.services.impl;

import net.larskristian.api.dto.ImageSection;
import net.larskristian.api.dto.services.ImageSectionMediationService;
import net.larskristian.core.dao.dto.Image;
import net.larskristian.core.service.ImageService;
import net.larskristian.framework.number.NumberUtility;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Lars K. Johansen
 */
@Component
public class ImageSectionMediationServiceImpl implements ImageSectionMediationService {

    @Autowired
    private ImageService imageService;

    @Override
    public ImageSection getImageSection(String imageId) {
        return toMediatedImageSection(imageService.getImage(imageId));
    }

    @Override
    public List<ImageSection> listRandomImageSections(int numberOfImageSections) {
        List<Image> allImages = imageService.listImageSections();
        Map<Integer, Image> allSectionsMap = new HashMap<Integer, Image>();
        int index = 0;
        for (Image image : allImages) {
            allSectionsMap.put(index++, image);
        }
        Set<Integer> randomNumbers = NumberUtility.getRandomIntegers(numberOfImageSections, 0, CollectionUtils.size(allImages) - 1);
        List<ImageSection> randomSections = new ArrayList<ImageSection>();
        for (Integer randomNumber : randomNumbers) {
            randomSections.add(toMediatedImageSection(allSectionsMap.get(randomNumber)));
        }
        return randomSections;
    }

    private static ImageSection toMediatedImageSection(Image persisted) {
        ImageSection mediated = new ImageSection();
        mediated.setUrl(persisted.getUrl());
        mediated.setDescription(persisted.getDescription());
        return mediated;
    }

}
