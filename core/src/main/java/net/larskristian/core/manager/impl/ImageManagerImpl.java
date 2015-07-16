package net.larskristian.core.manager.impl;

import net.larskristian.core.dao.ImageDao;
import net.larskristian.core.dao.dto.Image;
import net.larskristian.core.manager.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lars K. Johansen
 */
@Service
public class ImageManagerImpl implements ImageManager {

    @Autowired
    private ImageDao imageDao;

    @Override
    public Image getImage(String imageId) {
        return imageDao.getImage(imageId);
    }

    @Override
    public List<Image> listImagesOfSize(String type) {
        return imageDao.listImagesOfSize(type);
    }

}
