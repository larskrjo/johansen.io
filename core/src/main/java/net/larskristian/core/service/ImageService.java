package net.larskristian.core.service;

import net.larskristian.core.dao.dto.Image;

import java.util.List;

/**
 * @author Lars K. Johansen
 */
public interface ImageService {

    /**
     * Retrieves the image for the given {@code imageId}.
     *
     * @param   imageId The string that represents the image's id.
     * @return         The {@link Image} with the specified {@code imageId}.
     */
    Image getImage(String imageId);

    /**
     * Retrieves all the imageHeaders.
     *
     * @return {@link List <Image>} with all the imageHeaders.
     */
    List<Image> listImageHeaders();

    /**
     * Retrieves all the imageSections.
     *
     * @return {@link List <Image>} with all the imageSections.
     */
    List<Image> listImageSections();

    /**
     * Retrieves all the imageFulls.
     *
     * @return {@link List <Image>} with all the imageFulls.
     */
    List<Image> listImageFulls();
}
