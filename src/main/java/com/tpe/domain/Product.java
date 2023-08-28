package com.tpe.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Product {

        @NotBlank(message = "Please provide name of product")
        private String name;
        @NotBlank(message = "Please provide brand of product")
        private String brand;
        private String color;

        public Product(String name, String brand, String color) {
                this.name = name;
                this.brand = brand;
                this.color = color;
        }

        public Product() {
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getBrand() {
                return brand;
        }

        public void setBrand(String brand) {
                this.brand = brand;
        }

        public String getColor() {
                return color;
        }

        public void setColor(String color) {
                this.color = color;
        }
}
