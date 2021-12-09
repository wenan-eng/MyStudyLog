package com.wenan.design.facade;

/**
 * 描述：    FacadeDemo
 */
public class FacadeDemo {
    public static void main(String[] args) {
        FacadeMaker facadeMaker = new FacadeMaker();
        facadeMaker.drawAnimal();
        facadeMaker.drawSquare();
        facadeMaker.drawStar();
    }
}

/**
 * 创建一个Shape实体类
 */
interface Shape{
    void draw();
}

/**
 * 画圆实体类
 */
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("draw a square!");
    }
}

/**
 * 画一个动物实体类
 */
class Animal implements Shape {

    @Override
    public void draw() {
        System.out.println("draw a animal");
    }
}

/**
 * 画一个五角星
 */
class Star implements Shape {

    @Override
    public void draw() {
        System.out.println("draw a star!");
    }
}

/**
 * 创建一个外观类
 */
class FacadeMaker {
    private Shape square;
    private Shape star;
    private Shape animal;

    FacadeMaker(){
        square = new Square();
        star = new Star();
        animal = new Animal();
    }

    public void drawSquare() {
        square.draw();
    }

    public void drawStar() {
        star.draw();
    }

    public void drawAnimal() {
        animal.draw();
    }
}

