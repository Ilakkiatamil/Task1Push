package org.lib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
WebDriver driver;
Robot r;
Alert a;
Actions acc;
public WebDriver browserLaunch() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	return driver;
}
public void loadurl(String url) {
	driver.get(url);
	driver.manage().window().maximize();
}
public void fillTextBox(WebElement element,String data) {
	element.sendKeys(data);
}
public void btnClick(WebElement element) {
	element.click();
}
public void quitBrowser() {
	driver.quit();
}
public String getCurrentUrl() {
	String url = driver.getCurrentUrl();
	return url;
}
public String getTitle() {
	String title = driver.getTitle();
	return title;
}
public void close() {
	driver.close();
}
public Robot robot() throws AWTException {
	r=new Robot();
	return r;
	}
public void robotKeyPressEnter() {
	r.keyPress(KeyEvent.VK_ENTER);
}
public void robotKeyPressDown() {
	r.keyPress(KeyEvent.VK_DOWN);
}
public void robotKeyPressUp() {
	r.keyPress(KeyEvent.VK_UP);
}
public void robotKeyReleaseEnter() {
	r.keyRelease(KeyEvent.VK_ENTER);
}
public void robotKeyReleaseDown() {
	r.keyRelease(KeyEvent.VK_DOWN);
}
public void robotKeyReleaseUp() {
	r.keyRelease(KeyEvent.VK_UP);
}
public Actions actions(WebDriver driver) {
	acc=new Actions(driver);
	return acc;
}
public void actionsMove(Actions acc,WebElement element) {
	acc.moveToElement(element).perform();
}
public void actionsDragandDrop(Actions acc,WebElement dragfile,WebElement dropfile) {
	acc.dragAndDrop(dragfile, dropfile).perform();
}
public void actionsContextClick(Actions acc,WebElement element) {
	acc.contextClick(element).perform();
}
public void actionsDoubleClick(Actions acc,WebElement element) {
	acc.doubleClick(element).perform();
}
public Alert alert(Alert a) {
a=driver.switchTo().alert();
return a;
}
public void alertAccept(Alert a) {
	a.accept();
}
public void alertDismiss(Alert a) {
	a.dismiss();
}
public void alertSendkeys(Alert a,String data) {
	a.sendKeys(data);
}
public void alertGetText(Alert a) {
	a.getText();
}
public void isDisplayed(WebElement element) {
	boolean displayed = element.isDisplayed();
System.out.println(displayed);
}
public void isEnabled(WebElement element) {
	boolean enabled = element.isEnabled();
System.out.println(enabled);
}
public void isSelected(WebElement element) {
	boolean selected = element.isSelected();
System.out.println(selected);
}
public void excelUpdate(String sName,int rNo,int cNo,String data) throws IOException {
	File f=new File("C:\\Users\\User\\ilakkiaselenium\\MavenDemo\\TestDatas\\AmA.xlsx");
	FileInputStream fin=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(fin);
	Sheet s = w.getSheet(sName);
	Row r = s.getRow(rNo);
	Cell c = r.getCell(cNo);
	c.setCellValue(data);
	FileOutputStream fout=new FileOutputStream(f);
	w.write(fout);
}
public void excelWrite(String sName,int rNo,int cNo,String data) throws IOException {
	File f=new File("C:\\Users\\User\\ilakkiaselenium\\MavenDemo\\TestDatas\\New1.xlsx");
	Workbook w=new XSSFWorkbook();
    Sheet s = w.createSheet(sName);
    Row r = s.createRow(rNo);
    Cell c = r.createCell(cNo);
    c.setCellValue(data);
    FileOutputStream fout=new FileOutputStream(f);
	w.write(fout);
}
}
