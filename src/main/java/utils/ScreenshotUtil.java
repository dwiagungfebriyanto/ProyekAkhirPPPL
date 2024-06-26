package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    static Integer screenshotNo = 0;
    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        String fileName = screenshotName + screenshotNo.toString();
        String dest = "D:/Documents/Semester 4/Praktikum Pengujian Perangkat Lunak/Java/Proyek Akhir PPPL/test-output/screenshots/" + fileName + ".png";
        String directory = "screenshots/" + fileName + ".png";
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            screenshotNo += 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return directory;
    }
}
