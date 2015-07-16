package net.larskristian.api.dto.services;

import net.larskristian.api.dto.ImageSection;

import java.util.List;

/**
 * @author Lars K. Johansen
 */
public interface ImageSectionMediationService {

    /**
     * Retrieves the image for the given {@code imageId}.
     *
     * @param   imageId The string that represents the image's id.
     * @return          The {@link ImageSection} with the specified {@code imageId}.
     */
    ImageSection getImageSection(String imageId);

    /**
     * Lists a random number of the imageSections.
     *
     * @param numberOfImageSections The number of random imageSections.
     * @return                      The {@link List< ImageSection >} of random imageSections.
     */
    List<ImageSection> listRandomImageSections(int numberOfImageSections);

}
