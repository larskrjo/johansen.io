package net.larskristian.core.service.impl;

import net.larskristian.core.dao.dto.Image;
import net.larskristian.core.manager.ImageManager;
import net.larskristian.core.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lars K. Johansen
 */
@Service
public class ImageServiceImpl implements ImageService {

    private static final String FULL_SIZE = "1920x1200";
    private static final String HEADER_SIZE = "1920x300";
    private static final String SECTION_SIZE = "960x600";

    @Autowired
    private ImageManager imageManager;

    @Override
    public Image getImage(String imageHeaderId) {
        return imageManager.getImage(imageHeaderId);
    }

    @Override
    public List<Image> listImageHeaders() {
        return imageManager.listImagesOfSize(HEADER_SIZE);
    }

    @Override
    public List<Image> listImageSections() {
        return imageManager.listImagesOfSize(SECTION_SIZE);
    }

    public List<Image> listImageFulls() {
        return imageManager.listImagesOfSize(FULL_SIZE);
    }

}
