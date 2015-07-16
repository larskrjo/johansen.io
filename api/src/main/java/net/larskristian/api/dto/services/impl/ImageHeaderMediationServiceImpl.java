package net.larskristian.api.dto.services.impl;

import net.larskristian.api.dto.ImageHeader;
import net.larskristian.api.dto.services.ImageHeaderMediationService;
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
public class ImageHeaderMediationServiceImpl implements ImageHeaderMediationService {

    @Autowired
    private ImageService imageService;

    @Override
    public ImageHeader getImageHeader(String imageHeaderId) {
        return toMediatedImageHeader(imageService.getImage(imageHeaderId));
    }

    @Override
    public List<ImageHeader> listRandomImageHeaders(int numberOfImageHeaders) {
        List<Image> allImages = imageService.listImageHeaders();
        Map<Integer, Image> allHeadersMap = new HashMap<Integer, Image>();
        int index = 0;
        for (Image image : allImages) {
            allHeadersMap.put(index++, image);
        }
        Set<Integer> randomNumbers = NumberUtility.getRandomIntegers(numberOfImageHeaders, 0, CollectionUtils.size(allImages) - 1);
        List<ImageHeader> randomHeaders = new ArrayList<ImageHeader>();
        for (Integer randomNumber : randomNumbers) {
            randomHeaders.add(toMediatedImageHeader(allHeadersMap.get(randomNumber)));
        }
        return randomHeaders;
    }

    private static ImageHeader toMediatedImageHeader(Image persisted) {
        ImageHeader mediated = new ImageHeader();
        mediated.setUrl(persisted.getUrl());
        mediated.setDescription(persisted.getDescription());
        return mediated;
    }

}
