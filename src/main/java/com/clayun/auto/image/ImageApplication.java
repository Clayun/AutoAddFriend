package com.clayun.auto.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.clayun.auto.Finder.writeImageFile;
import static com.clayun.auto.image.ImageUtil.getRGB;
import static java.util.stream.Collectors.toList;

public class ImageApplication {

    public static void main(String[] args) throws IOException, AWTException {
        ImageFinder finder = ScreenImageFinder.getFinder();

        BufferedImage search = ImageIO.read(ImageApplication.class.getClassLoader().getResourceAsStream("test.png"));
        long start = System.currentTimeMillis();
        List<Coordinate> coordinateList = finder.match(search,0.75);
        System.out.println("耗时:"+(System.currentTimeMillis()-start));

        coordinateList.stream().findAny().ifPresent(coordinate ->
                System.out.println(String.format("find help image x:%d,y:%d",coordinate.getX(),coordinate.getY())));
    }

    public static Coordinate getPosition(String path) throws IOException, AWTException {
        ImageFinder finder = ScreenImageFinder2.getFinder();

        BufferedImage search = ImageIO.read(ImageApplication.class.getClassLoader().getResourceAsStream(path));
        long start = System.currentTimeMillis();
        List<Coordinate> coordinateList = finder.match(search,0.99);
//        System.out.println("耗时:"+(System.currentTimeMillis()-start));

        if(coordinateList != null && coordinateList.size() > 0){
//            System.out.println("x="+coordinateList.get(0).getX()+",y="+coordinateList.get(0).getY());
            for(Coordinate coordinate : coordinateList){
                System.out.println(coordinate);
            }
            return coordinateList.get(0);
        }

        return null;
    }

    public static Coordinate getFinalPosition(String path) throws IOException, AWTException {
        ImageFinder finder = ScreenImageFinder.getFinder();

        BufferedImage search = ImageIO.read(ImageApplication.class.getClassLoader().getResourceAsStream(path));
        long start = System.currentTimeMillis();
        List<Coordinate> coordinateList = finder.match(search,0.99);
        System.out.println("耗时:"+(System.currentTimeMillis()-start));

        if(coordinateList != null && coordinateList.size() > 0){
            System.out.println("x="+coordinateList.get(coordinateList.size()-1).getX()
                    +",y="+coordinateList.get(coordinateList.size()-1).getY());
            return coordinateList.get(coordinateList.size()-1);
        }

        return null;
    }



}
