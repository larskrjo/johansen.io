package net.larskristian.core.manager;

import net.larskristian.core.dao.dto.Image;

import java.util.List;

/**
 * @author Lars K. Johansen
 */
public interface ImageManager {

    /**
     * Retrieves the image for the given {@code imageId}.
     *
     * @param   imageId The string that represents the image's id.
     * @return         The {@link Image} with the specified {@code imageId}.
     */
    Image getImage(String imageId);

    /**
     * Retrieves all the image's with the given {@code size}.
     *
     * @param size The size of the images
     * @return {@link List <Image>} with all the images.
     */
    List<Image> listImagesOfSize(String size);

}
