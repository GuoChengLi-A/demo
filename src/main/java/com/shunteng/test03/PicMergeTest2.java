package com.shunteng.test03;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/9/16 上午11:25
 */
public class PicMergeTest2 {
    /**
     * @param file      源文件(图片)
     * @param waterFile 水印文件(图片)
     * @param x         距离右下角的X偏移量
     * @param y         距离右下角的Y偏移量
     * @param alpha     透明度, 选择值从0.0~1.0: 完全透明~完全不透明
     * @param scale     缩放比例, 选择值从0.0~1.0
     * @return byte[]
     * @throws IOException
     * @Title: 构造图片
     * @Description: 生成水印并返回java.awt.image.BufferedImage
     */
    public static BufferedImage watermark(File file, File waterFile, int x, int y, float alpha, float scale) throws IOException {
        // 获取底图
        BufferedImage buffImg = ImageIO.read(file);
        // 获取层图
        BufferedImage waterImg = ImageIO.read(waterFile);
        // 创建Graphics2D对象，用在底图对象上绘图
        Graphics2D g2d = buffImg.createGraphics();
        int waterImgWidth = new Float(waterImg.getWidth() * scale).intValue();// 获取层图的宽度
        int waterImgHeight = new Float(waterImg.getHeight() * scale).intValue();// 获取层图的高度
        // 在图形和图像中实现混合和透明效果
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        // 绘制
        g2d.drawImage(waterImg, x, y, waterImgWidth, waterImgHeight, null);
        g2d.dispose();// 释放图形上下文使用的系统资源

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(waterImg, "jpg", out);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                out.close();
            }
        }
        return buffImg;
    }

    /**
     * 输出水印图片
     *
     * @param buffImg  图像加水印之后的BufferedImage对象
     * @param savePath 图像加水印之后的保存路径
     */
    private void generateWaterFile(BufferedImage buffImg, String savePath) {
        int temp = savePath.lastIndexOf(".") + 1;
        try {
            ImageIO.write(buffImg, savePath.substring(temp), new File(savePath));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * @param args
     * @throws IOException IO异常直接抛出了
     * @author bls
     */
    public static void main(String[] args) throws IOException {
        String sourceFilePath = "/home/gcl/桌面/work/2.jpg";
        String waterFilePath = "/home/gcl/桌面/work/watermark-logo.png";
        String saveFilePath = "/home/gcl/桌面/work/test.jpeg";
        PicMergeTest2 newImageUtils = new PicMergeTest2();
        // 构建叠加层
        BufferedImage buffImg = PicMergeTest2.watermark(new File(sourceFilePath), new File(waterFilePath), 50, 100, 1f, .7f);
        // 输出水印图片
        newImageUtils.generateWaterFile(buffImg, saveFilePath);
    }
}