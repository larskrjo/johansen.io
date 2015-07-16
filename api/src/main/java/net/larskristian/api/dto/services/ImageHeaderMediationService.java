package net.larskristian.api.dto.services;

import net.larskristian.api.dto.ImageHeader;

import java.util.List;

/**
 * @author Lars K. Johansen
 */
public interface ImageHeaderMediationService {

    /**
     * Retrieves the imageHeader for the given {@code imageHeaderId}.
     *
     * @param   imageHeaderId The string that represents the imageHeader's id.
     * @return         The {@link ImageHeader} with the specified {@code imageHeaderId}.
     */
    ImageHeader getImageHeader(String imageHeaderId);

    /**
     * Lists a random number of the imageHeaders.
     *
     * @param numberOfImageHeaders The number of random imageHeaders.
     * @return The {@link List< ImageHeader >} of random imageHeaders.
     */
    List<ImageHeader> listRandomImageHeaders(int numberOfImageHeaders);

}
