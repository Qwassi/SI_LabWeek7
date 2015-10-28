/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

/**
 *
 * @author MIIT190614
 */
public class CalculateShippingPrice {

    double pricePerKg;

    public CalculateShippingPrice() {

    }

    public double calculatePricePerKg(double weight) {
        if (weight < 2.5) {
            pricePerKg = 3.5;
        } else if (weight >= 2.5 && weight <= 5.0) {
            pricePerKg = 2.85;
        } else if (weight > 5.0) {
            pricePerKg = 2.45;
        }
        return pricePerKg;
    }
    
    public double calculateTotalShippingPrice(double pricePerKg, double weight){
        return pricePerKg * weight;
    }
}
