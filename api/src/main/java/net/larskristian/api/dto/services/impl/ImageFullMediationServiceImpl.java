package net.larskristian.api.dto.services.impl;

import net.larskristian.api.dto.ImageFull;
import net.larskristian.api.dto.services.ImageFullMediationService;
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
public class ImageFullMediationServiceImpl implements ImageFullMediationService {

    @Autowired
    private ImageService imageService;

    @Override
    public ImageFull getImageFull(String imageId) {
        return toMediatedImageFull(imageService.getImage(imageId));
    }

    @Override
    public List<ImageFull> listRandomImageFulls(int numberOfImages) {
        List<Image> allImages = imageService.listImageFulls();
        Map<Integer, Image> allFullsMap = new HashMap<Integer, Image>();
        int index = 0;
        for (Image image : allImages) {
            allFullsMap.put(index++, image);
        }
        Set<Integer> randomNumbers = NumberUtility.getRandomIntegers(numberOfImages, 0, CollectionUtils.size(allImages) - 1);
        List<ImageFull> randomFulls = new ArrayList<ImageFull>();
        for (Integer randomNumber : randomNumbers) {
            randomFulls.add(toMediatedImageFull(allFullsMap.get(randomNumber)));
        }
        return randomFulls;
    }

    private static ImageFull toMediatedImageFull(Image persisted) {
        ImageFull mediated = new ImageFull();
        mediated.setUrl(persisted.getUrl());
        mediated.setDescription(persisted.getDescription());
        return mediated;
    }

}
