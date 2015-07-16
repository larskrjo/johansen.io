package net.larskristian.core.dao;

import net.larskristian.core.dao.dto.Image;

import java.util.List;

/**
 * @author Lars K. Johansen
 */
public interface ImageDao {

    /**
     * Retrieves the image for the given {@code imageId}.
     *
     * @param   imageId String that represents the image's id.
     * @return          {@link Image} with the specified {@code imageId}.
     */
    Image getImage(String imageId);

    /**
     * Retrieves all the images with the given {@code size} of type of {@code size}.
     *
     * @param size The image size
     * @return {@link List<  Image  >} with all the images of the given size.
     */
    List<Image> listImagesOfSize(String size);

}
