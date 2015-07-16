package net.larskristian.api.dto.services;

import net.larskristian.api.dto.ImageFull;

import java.util.List;

/**
 * @author Lars K. Johansen
 */
public interface ImageFullMediationService {

    /**
     * Retrieves the image for the given {@code imageId}.
     *
     * @param   imageId The string that represents the image's id.
     * @return          The {@link ImageFull} with the specified {@code imageId}.
     */
    ImageFull getImageFull(String imageId);

    /**
     * Lists a random number of the imageFulls.
     *
     * @param numberOfImageFulls The number of random imageFulls.
     * @return                   The {@link List< ImageFull >} of random imageFulls.
     */
    List<ImageFull> listRandomImageFulls(int numberOfImageFulls);

}
