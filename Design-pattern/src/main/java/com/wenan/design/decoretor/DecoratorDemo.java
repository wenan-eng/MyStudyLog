package com.wenan.design.decoretor;

/**
 * 描述：    DecoratorDemo
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        // circle 常规
        System.out.println("normal circle");
        Circle circle = new Circle();
        circle.draw();
        // circle 红边的
        System.out.println("red border circle");
        RedDecorator redDecorator = new RedDecorator(circle);
        redDecorator.draw();
    }
}

interface Shape{
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}

abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}

class RedDecorator extends ShapeDecorator{

    public RedDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        super.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
