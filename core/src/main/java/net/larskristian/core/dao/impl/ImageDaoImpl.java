package net.larskristian.core.dao.impl;

import net.larskristian.core.dao.ImageDao;
import net.larskristian.core.dao.base.AbstractBaseDao;
import net.larskristian.core.dao.dto.Image;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Lars K. Johansen
 */
@Transactional
@Repository
public class ImageDaoImpl extends AbstractBaseDao<Image> implements ImageDao {

    private static final String IMAGE_SIZE = "size";

    @Override
    public Image getImage(String imageId) {
        return read(imageId);
    }

    @Override
    public List<Image> listImagesOfSize(String size) {
        return readByFieldName(IMAGE_SIZE, size);
    }

}
