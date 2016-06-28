package org.worldbank;

import com.opencsv.CSVWriter;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Test {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();


        baseUrl = "http://www.worldbank.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @org.junit.Test
    public void test1() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("(//a[contains(text(),'Data')])[2]")).click();
        driver.findElement(By.linkText("By Country")).click();
        driver.findElement(By.linkText("High income")).click();

        List<Data> cities = new ArrayList();

        for (int j = 1; j < 3; j++) {
            for (int i = 1; i < 41; i++) {
                    WebElement element;
                try {
                    element = driver.findElement(By.xpath(".//*[@id='block-views-income_levels_countries-block_1']/div/div/div/table/tbody/tr[" + i + "]/td[" + j + "]/div/div/span/span/a"));
                }catch(Exception e){
                    continue;
                }
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

                String name = driver.findElement(By.className("page-title")).getText();
                String income;
                String population;
                String air;

                try {
                    income = driver.findElement(By.xpath(".//*[@id='block-views-44fcb918e09e0c366853ab1749e6380f']/div/div/div[1]/div/div[2]/span/span/a/span")).getText();
                }catch (Exception e){
                    income = null;
                }

                try {
                    if (income == null){population = driver.findElement(By.xpath(".//*[@id='block-views-44fcb918e09e0c366853ab1749e6380f']/div/div/div/div/div/div/div[2]/span/span/a/span")).getText();}
                    else {population = driver.findElement(By.xpath(".//*[@id='block-views-44fcb918e09e0c366853ab1749e6380f']/div/div/div[2]/div/div/div/div[2]/span/span/a/span")).getText();}
                }catch (Exception e){
                    population = null;
                }

                try {
                    air = driver.findElement(By.xpath(".//*[@id='boxes-box-country_wdi_block2']/div/div[2]/div/div/div/span[1]")).getText();
                }catch (Exception e){
                    air = null;
                }

                cities.add(new Data(name,income,population,air));
                driver.navigate().back();
            }
        }

        driver.close();


        //CSV WRITE MODULE
        String csv = System.getProperty("user.dir")+"/output.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));

        //INCOME
        List<Data> mostData1 = Data.getMostIncome(cities);
        System.out.println("GDP at market prices (current, million US$)");
        for (Data c: mostData1) {
            System.out.println(c.name);
        }
        writer.writeNext(new String[]{"GDP at market prices (current US$)"});
        writer.writeNext(new String[]{"", "GDP at market prices (current, million US$)", "Population, total: " ,"CO2 emissions"});
        for (Data data : mostData1) {
            writer.writeNext(new String[]{data.name, String.valueOf(data.income), String.valueOf(data.population), String.valueOf(data.air)});
        }

        //POPULATION
        List<Data> mostData2 = Data.getMostPopulation(cities);
        System.out.println("Population, total: ");
        for (Data c: mostData2) {
            System.out.println(c.name);
        }
        writer.writeNext(new String[]{""});
        writer.writeNext(new String[]{"Population, total: "});
        writer.writeNext(new String[]{"", "GDP at market prices (current, million US$)", "Population, total: " ,"CO2 emissions"});
        for (Data data : mostData2) {
            writer.writeNext(new String[]{data.name, String.valueOf(data.income), String.valueOf(data.population), String.valueOf(data.air)});
        }

        //CO2
        List<Data> mostData3 = Data.getMostCo2(cities);
        System.out.println("CO2 emissions: ");
        for (Data c: mostData3) {
            System.out.println(c.name);
        }
        writer.writeNext(new String[]{""});
        writer.writeNext(new String[]{"CO2 emissions"});
        writer.writeNext(new String[]{"", "GDP at market prices (current, million US$)", "Population, total: " ,"CO2 emissions"});
        for (Data data : mostData3) {
            writer.writeNext(new String[]{data.name, String.valueOf(data.income), String.valueOf(data.population), String.valueOf(data.air)});
        }
        writer.close();
    }
}

