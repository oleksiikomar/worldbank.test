package org.worldbank;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;


public class Data {

    String name;
    int income;
    int population;
    float air;

    public Data(String name, String income, String population, String air) {
        this.name = name;
        this.income = parseIncome(income);
        this.population = parsePopulation(population);
        this.air = parseAir(air);
    }

    public int parseIncome(String income) {
       try {
           if(income.contains("million")){
               return (int) (Float.parseFloat(income.replace("million", "").replace("$", "").trim()));
           }else if (income.contains("billion")){
               return (int) (Float.parseFloat(income.replace("billion", "").replace("$", "").trim()) * 1000);
           }else if (income.contains("trillion")){
               return (int) (Float.parseFloat(income.replace("trillion", "").replace("$", "").trim()) * 1000000);
           }
       }catch(Exception ignore){}
       return -1;
    }


    public int parsePopulation(String population) {
        if(population.contains("million")){
            return (int) (Float.parseFloat(population.replace("million", "").trim()) * 1000000);
        }else {
            try {
                return NumberFormat.getNumberInstance(Locale.US).parse(population.trim()).intValue();
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return -2;
    }

    public float parseAir(String air) {
        try{
            return Float.parseFloat(air);
        }catch (Exception e){
            return -3;
        }
    }

    public int getIncome() {
        return this.income;
    }

    public int getPopulation() {
        return this.population;
    }

    public float getAir() {
        return this.air;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", income=" + income +
                ", population=" + population +
                ", air=" + air +
                '}';
    }

    public static List<Data> getMostPopulation(List<Data> all) {
        Collections.sort(all, new Comparator<Data>() {
            @Override
            public int compare(Data lhs, Data rhs) {
                return Integer.compare(rhs.getPopulation(), lhs.getPopulation());
            }
        });
        return all.subList(0, 3);

    }

    public static List<Data> getMostIncome(List<Data> all) {
        Collections.sort(all, new Comparator<Data>() {
            @Override
            public int compare(Data lhs, Data rhs) {
                return Integer.compare(rhs.getIncome(), lhs.getIncome());
            }
        });
        return all.subList(0, 3);

    }

    public static List<Data> getMostCo2(List<Data> all) {
        Collections.sort(all, new Comparator<Data>() {
            @Override
            public int compare(Data lhs, Data rhs) {
                return Float.compare(rhs.getAir(), lhs.getAir());
            }
        });
        return all.subList(0, 3);

    }
}

