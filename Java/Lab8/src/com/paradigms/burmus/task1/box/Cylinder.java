package com.paradigms.burmus.task1.box;

public class Cylinder extends Box {
    private final double r;
    private final double h;

    public Cylinder(int h, int r) {
        super();
        this.h = h;
        this.r = r;
        volume();
        externalBoxVolume();
        internalBoxVolume();
    }

    @Override
    public void volume() {
        this.volume = Math.PI * Math.pow(r, 2) * h;
    }

    @Override
    public void externalBoxVolume() {
        this.externalBoxVolume = Math.pow(2 * r, 2) * h;
    }

    @Override
    public void internalBoxVolume() {
        this.internalBoxVolume = 2 * Math.pow(r, 2) * h;
    }

    @Override
    public String toString() {
        return "---> Cylinder {" + String.format("h = %.2f, r = %.2f, [V=%.2f]", h, r, volume) + "}";
    }
}
