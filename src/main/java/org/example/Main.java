package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //WebDriver driver = new ChromeDriver();
       // WebDriver driver= new FirefoxDriver();
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.instagram.com/");
        System.out.println(driver.getTitle());
    }
}