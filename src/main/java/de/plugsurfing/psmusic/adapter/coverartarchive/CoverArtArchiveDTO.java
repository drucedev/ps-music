package de.plugsurfing.psmusic.adapter.coverartarchive;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * @author Andrei Kukharau
 * @since 0.0.1
 */
@Getter
@Builder
public class CoverArtArchiveDTO {
    private List<ImageInfo> images;

    public String getFrontImageUrl() {
        return this.images.stream()
                .filter(ImageInfo::getFront)
                .map(ImageInfo::getImage)
                .findAny()
                .orElseThrow(NoFrontAlbumImageException::new);
    }

    @Getter
    @Builder
    public static final class ImageInfo {
        private String image;
        private Boolean front;
    }
}
