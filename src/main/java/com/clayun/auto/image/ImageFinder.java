package com.clayun.auto.image;

import java.awt.image.BufferedImage;
import java.util.List;

public interface ImageFinder {

    List<Coordinate> match(BufferedImage image, double percent);
}
