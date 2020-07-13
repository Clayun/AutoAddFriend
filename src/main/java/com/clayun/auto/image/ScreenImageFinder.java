package com.clayun.auto.image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static com.clayun.auto.image.ImageUtil.getRGB;
import static java.util.stream.Collectors.toList;

public class ScreenImageFinder implements ImageFinder {

    private final Robot robot = new Robot() ;
    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private final BufferedImage screen = robot.createScreenCapture(new Rectangle(dimension));

    private ScreenImageFinder() throws AWTException {

    }
    public static ScreenImageFinder getFinder(){
        try {
            return new ScreenImageFinder();
        } catch (AWTException e) {
            e.printStackTrace();

        }
        return null;
    }
    public java.util.List<Coordinate> match(BufferedImage image, double percent) {
        //0 0  left top
        //5 0  right top
        //0 5  left  bottom
        //5 5  right bottom
        //2 2  center
        int[][] screenRgbs = getRGB(screen);
        ColorBlock block = new ColorBlock(image);
        java.util.List<Coordinate> coordinates = new ArrayList<>();
        for(int x=0;x<screen.getWidth()-block.getWidth();x++){
            for(int y=0;y<screen.getHeight()-block.getHeight();y++){
                int topLeft = screenRgbs[x][y];
                int topRight= screenRgbs[x+ block.getRightTop().getX()][y+block.getRightTop().getY()];
                int bottomLeft= screenRgbs[x+ block.getLeftBottom().getX()][y+block.getLeftBottom().getY()];
                int bottomRight= screenRgbs[x+ block.getRightBottom().getX()][y+block.getRightBottom().getY()];
                int center= screenRgbs[x+ block.getCenter().getX()][y+block.getCenter().getY()];
                if(!block.isPointMatch(topLeft,topRight,bottomLeft,bottomRight,center)) continue;
                coordinates.add(new Coordinate(x,y));
            }
        }

        return coordinates.stream().filter(coordinate -> block.allMatch(coordinate,screenRgbs,percent)).collect(toList());
    }



    private boolean colorCompare(int source,int compare){
        return source==compare;
    }

    public Robot getRobot() {
        return robot;
    }


    public BufferedImage getScreen() {
        return screen;
    }


    public Dimension getDimension() {
        return dimension;
    }

}
