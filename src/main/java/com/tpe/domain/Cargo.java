package com.tpe.domain;

public enum Cargo {
    STANDARTDELIVERY("Standart",50,true),
    FASTDELIVERY("Fast",75,false),
    BRANCHDELIVERY("Branch",25,true);
    private final String cargoType;
    private final int price;
    private final boolean returnOption;

    Cargo(String cargoType, int price, boolean returnOption) {
        this.cargoType = cargoType;
        this.price = price;
        this.returnOption = returnOption;
    }

    public String getCargoType() {
        return cargoType;
    }

    public int getPrice() {
        return price;
    }

    public boolean isReturnOption() {
        return returnOption;
    }
}
