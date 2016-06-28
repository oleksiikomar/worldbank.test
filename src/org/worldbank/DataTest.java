package org.worldbank;

import org.junit.*;
import org.junit.Test;

public class DataTest {
    @Test
    public void parseIncome() throws Exception {
        Data data1 = new Data("Country", "$546.0 million", "0", "0");
        Data data2 = new Data("Country", "$1.200 billion", "0", "0");
        Data data3 = new Data("Country", "$1.200 trillion", "0", "0");
        Data data4 = new Data("Country", "null", "0", "0");
        Assert.assertEquals(546, data1.income);
        Assert.assertEquals(1200, data2.income);
        Assert.assertEquals(1200000, data3.income);
        Assert.assertEquals(-1, data4.income);
    }

    @Test
    public void parsePopulation() throws Exception {
        Data data1 = new Data("Country", "0", "23.80 million", "0");
        Data data2 = new Data("Country", "0", "104,000", "0");
        Data data3 = new Data("Country", "0", "null", "0");
        Assert.assertEquals(23800000, data1.population);
        Assert.assertEquals(104000, data2.population);
        Assert.assertEquals(-2, data3.population);
    }

    @Test
    public void parseAir() throws Exception {
        Data data1 = new Data("Country", "0", "0", "16.5");
        Data data2 = new Data("Country", "0", "0", "null");
        Assert.assertEquals(16.5, data1.air, 1);
        Assert.assertEquals(-3, data2.air, 1);
    }
}
