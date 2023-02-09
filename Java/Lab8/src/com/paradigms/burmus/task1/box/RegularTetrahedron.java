package com.paradigms.burmus.task1.box;

public class RegularTetrahedron extends Box {
    private final double a;

    public RegularTetrahedron(double a) {
        super();
        this.a = a;
        volume();
        externalBoxVolume();
        internalBoxVolume();
    }

    @Override
    public void volume() {
        this.volume = Math.pow(a, 3) * Math.sqrt(2) / 12;
    }

    @Override
    public void externalBoxVolume() {
        this.externalBoxVolume = Math.pow(a, 3) * 3 * Math.sqrt(2) / 6;
    }

    @Override
    public void internalBoxVolume() {
        this.internalBoxVolume = externalBoxVolume * 4/9;
    }

    @Override
    public String toString() {
        return "---> RegularTetrahedron {" + String.format("a = %.2f, [V=%.2f]", a, volume) + "}";
    }
}
