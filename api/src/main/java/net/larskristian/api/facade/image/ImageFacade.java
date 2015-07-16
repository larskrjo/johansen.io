package net.larskristian.api.facade.image;

import net.larskristian.api.dto.ImageFull;
import net.larskristian.api.dto.ImageHeader;
import net.larskristian.api.dto.ImageSection;
import net.larskristian.framework.exception.ExceptionMessages;
import net.larskristian.framework.exception.type.NotImplementedException;
import net.larskristian.framework.uri.UriPaths;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lars K. Johansen
 */
@RestController
public class ImageFacade {

    //private static final Logger LOG = LogManager.getLogger(ImageFacade.class);

    //@Autowired
    //private ImageFullMediationService imageFullMediationService;

    //@Autowired
    //private ImageSectionMediationService imageSectionMediationService;

    //@Autowired
    //private ImageHeaderMediationService imageHeaderMediationService;

    @RequestMapping(value = UriPaths.API_IMAGE_HEADER_COLLECTION, method = RequestMethod.GET)
    public List<ImageHeader> getRandomImageHeaders() {
        throw new NotImplementedException(ExceptionMessages.MESSAGE_METHOD_NOT_IMPLEMENTED_EXCEPTION);

        //LOG.info("Entered ImageFacade.getRandomImageHeaders");

        //List<ImageHeader> imageHeaders = imageHeaderMediationService.listRandomImageHeaders(3);

        //return imageHeaders;
    }

    @RequestMapping(value = UriPaths.API_IMAGE_SECTION_COLLECTION, method = RequestMethod.GET)
    public List<ImageSection> getRandomImageSections() {
        throw new NotImplementedException(ExceptionMessages.MESSAGE_METHOD_NOT_IMPLEMENTED_EXCEPTION);

        //LOG.info("Entered ImageFacade.getRandomImageSections");

        //List<ImageSection> imageSections = imageSectionMediationService.listRandomImageSections(2);

        //return imageSections;
    }

    @RequestMapping(value = UriPaths.API_IMAGE_SECTION, method = RequestMethod.GET)
    public ImageSection getImageSection(@PathVariable String id) {
        throw new NotImplementedException(ExceptionMessages.MESSAGE_METHOD_NOT_IMPLEMENTED_EXCEPTION);

        //LOG.info("Entered ImageFacade.getImageSection");

        //ImageSection imageSections = imageSectionMediationService.getImageSection(id);

        //return imageSections;
    }

    @RequestMapping(value = UriPaths.API_IMAGE_FULL, method = RequestMethod.GET)
    public ImageFull getImageFull(@PathVariable String id) {
        throw new NotImplementedException(ExceptionMessages.MESSAGE_METHOD_NOT_IMPLEMENTED_EXCEPTION);

        //LOG.info("Entered ImageFacade.getImageFull");

        //ImageFull imageFull = imageFullMediationService.getImageFull(id);

        //return imageFull;
    }
}
