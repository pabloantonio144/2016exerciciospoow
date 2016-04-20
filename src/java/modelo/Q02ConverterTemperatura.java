/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author maicon
 */
public class Q02ConverterTemperatura {
    
    //métodos para conversõa de temperaturas
    public static double celsiusToFahrenheit(double value){
        return (value * 1.8) + 32;
    }
    
    public static double fahrenheitToCelsius(double value){
        return (value - 32) /1.8;
    }
    
    public static double celsiusToKelvin(double value){
        return (value + 273.15d);
    }
    
    public static double kelvinToCelsius(double value){
        return (value - 273.15d);
    }
    
}
