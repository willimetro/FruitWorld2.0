package com.wugaldeq.udemy.fruitworld2.model;

/**
 * Clase que representa una fruta que se mostrará en el listado de la aplicación
 * Created by wugaldeq on 31-01-2018.
 */

public class Fruit {
    private String nameFruit;
    private String descriptionFruit;
    private int imgBackGroundFruit;
    private int imgIconFruit;
    private int quantity;

    public static final int QUANTITY_LIMIT = 10;
    public static final int QUANTITY_RESET = 0;

    public Fruit(String nameFruit, String descriptionFruit, int imgBackGroundFruit, int imgIconFruit, int quantity) {
        this.nameFruit = nameFruit;
        this.descriptionFruit = descriptionFruit;
        this.imgBackGroundFruit = imgBackGroundFruit;
        this.imgIconFruit = imgIconFruit;
        this.quantity = quantity;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public void setNameFruit(String nameFruit) {
        this.nameFruit = nameFruit;
    }

    public String getDescriptionFruit() {
        return descriptionFruit;
    }

    public void setDescriptionFruit(String descriptionFruit) {
        this.descriptionFruit = descriptionFruit;
    }

    public int getImgBackGroundFruit() {
        return imgBackGroundFruit;
    }

    public void setImgBackGroundFruit(int imgBackGroundFruit) {
        this.imgBackGroundFruit = imgBackGroundFruit;
    }

    public int getImgIconFruit() {
        return imgIconFruit;
    }

    public void setImgIconFruit(int imgIconFruit) {
        this.imgIconFruit = imgIconFruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setQuantityWithLimit(int quantity) {
        if(this.quantity < QUANTITY_LIMIT){
            this.quantity = this.quantity + quantity;
        }
    }

    public void resetQuantity(){
        this.quantity = QUANTITY_RESET;
    }
}
