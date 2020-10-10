package com.shunteng.test03;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Description 图片合并
 * @Author GCL
 * @Date 2020/9/16 上午11:10
 */
public class PicMergeTest {
    private Graphics2D g        = null;

    /**
     * 导入本地图片到缓冲区
     */
    public BufferedImage loadImageLocal(String imgName) {
        try {
            return ImageIO.read(new File(imgName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public BufferedImage modifyImagetogeter(BufferedImage b, BufferedImage d) {

        try {
            int w = b.getWidth();
            int h = b.getHeight();

            g = d.createGraphics();
            g.drawImage(b, 300, -800, w, h, null);
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return d;
    }

    /**
     * 生成新图片到本地
     */
    public void writeImageLocal(String newImage, BufferedImage img) {
        if (newImage != null && img != null) {
            try {
                File outputfile = new File(newImage);
                ImageIO.write(img, "jpg", outputfile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        PicMergeTest tt = new PicMergeTest();

        BufferedImage d = tt.loadImageLocal("/home/gcl/桌面/work/1.jpeg");
        BufferedImage b = tt.loadImageLocal("/home/gcl/桌面/work/2.jpg");

        tt.writeImageLocal("/home/gcl/桌面/work/test.jpeg", tt.modifyImagetogeter(d, b));
        //将多张图片合在一起
        System.out.println("success");
    }

}