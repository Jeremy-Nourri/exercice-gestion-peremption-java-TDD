package org.example.entity;

import org.example.exception.NegativeValueException;
import org.example.exception.ValueGreaterThan50Exception;

import java.util.List;

public class Shop {
    private List<Product> products;


    public void update(Product product) {

        if (product.getQuality() < 0) {
            throw new NegativeValueException("Quality can't be negative");
        }
        else if (product.getQuality() > 50) {
            throw new ValueGreaterThan50Exception("Quality can't be greater than 50");
        }

            if (product.getSellIn() == 0) {
                product.setQuality(product.getQuality()-2);
            }
            else {
                product.setSellIn(product.getSellIn()-1);
                if (product.getName().equals("brie vieilli")) {
                    product.setQuality(product.getQuality() + 1);

                } else if (product.getType().equals("laitier")) {
                    product.setQuality(product.getQuality() - 2);

                } else {
                    product.setQuality(product.getQuality() - 1);
                }
            }
        }

    }
