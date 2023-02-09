package com.paradigms.burmus.task1.box;


public class Cuboid extends Box {
    private final double a;
    private final double b;
    private final double c;

    public Cuboid(int a, int b, int c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        volume();
        externalBoxVolume();
        internalBoxVolume();
    }

    @Override
    public void volume() {
        this.volume = a * b * c;
    }

    @Override
    public void externalBoxVolume() {
        this.externalBoxVolume = volume;
    }

    @Override
    public void internalBoxVolume() {
        this.internalBoxVolume = volume;
    }

    @Override
    public String toString() {
        return "---> Cuboid {" + String.format("a = %.2f, b = %.2f, c = %.2f, [V=%.2f]", a, b, c, volume) + "}";
    }
}
