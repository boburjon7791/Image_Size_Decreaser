package org.example;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Main {
    public static final long MAX_SIZE=400;
    public static void main(String[] args) {
        File file = new File("part 1.jpg");
        File newFile = new File("new_image.jpg");
        if (newFile.exists()) {
            newFile.delete();
        }
        try {
            BufferedImage read = ImageIO.read(file);
            int type = read.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : read.getType();
            BufferedImage resized = resize(read, type);
            ImageIO.write(resized,"jpg",newFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static BufferedImage resize(BufferedImage originalImage, int type){
        double with=500;
        double value = originalImage.getWidth() / with;
        double heightValue = originalImage.getHeight() / value;
        int height = (int)Math.round(heightValue);
        BufferedImage resizedImage = new BufferedImage(500,height,type);
        Graphics graphics = resizedImage.getGraphics();
        graphics.drawImage(originalImage,0,0,500,height,null);
        graphics.dispose();
        return resizedImage;
    }
}