package com.paradigms.burmus.task1.box;

public class Sphere extends Box {
    private final double r;

    public Sphere(double r) {
        super();
        this.r = r;
        volume();
        externalBoxVolume();
        internalBoxVolume();
    }

    @Override
    public void volume() {
        this.volume = (4 / 3) * Math.PI * Math.pow(r, 3);

    }

    @Override
    public void externalBoxVolume() {
        this.externalBoxVolume = 8 * Math.pow(r, 3);
    }

    @Override
    public void internalBoxVolume() {
        this.internalBoxVolume = Math.pow(r * (2 / Math.sqrt(3)), 3);

    }

    @Override
    public String toString() {
        return "---> Sphere {" + String.format(" r = %.2f, [V=%.2f]", r, volume) + "}";
    }
}
