package com.paradigms.burmus.task2.box;

import com.paradigms.burmus.task2.figure.Figure;

import java.util.Arrays;

public class BadBox {
    static final String ERROR = "Check your args for ";
    private final Figure type;
    private final double volume;
    private final double externalBoxVolume;
    private final double internalBoxVolume;
    private BadBox badBoxInside;
    private final double[] params;

    public BadBox(Figure type, double... args) {
        this.type = type;
        this.params = args;

        switch (type) {
            case CUBOID -> {
                if (params.length == 3) {
                    this.volume = params[0] * params[1] * params[2];
                    this.externalBoxVolume = volume;
                    this.internalBoxVolume = volume;
                } else {
                    throw new IllegalArgumentException(ERROR + type);
                }
            }
            case CYLINDER -> {
                if (params.length == 2) {
                    double r = params[1];
                    double h = params[0];
                    this.volume = Math.PI * Math.pow(r, 2) * h;
                    this.externalBoxVolume = Math.pow(2 * r, 2) * h;
                    this.internalBoxVolume = 2 * Math.pow(r, 2) * h;
                } else {
                    throw new IllegalArgumentException(ERROR + type);
                }
            }
            case REGULAR_TETRAHEDRON -> {
                if (params.length == 1) {
                    double a = params[0];
                    this.volume = Math.pow(a, 3) * Math.sqrt(2) / 12;
                    this.externalBoxVolume = Math.pow(a, 3) * 3 * Math.sqrt(2) / 6;
                    this.internalBoxVolume = externalBoxVolume * 4 / 9;
                } else {
                    throw new IllegalArgumentException(ERROR + type);
                }
            }
            case SPHERE -> {
                if (params.length == 1) {
                    double r = params[0];

                    this.volume = (4/3) * Math.PI * Math.pow(r,3);
                    this.externalBoxVolume = 8 * Math.pow(r,3);
                    this.internalBoxVolume = Math.pow(r * (2 / Math.sqrt(3)),3);
                } else {
                    throw new IllegalArgumentException(ERROR + type);
                }
            }
            default -> throw new UnsupportedOperationException("There are no such type");
        }

    }

    public double getVolume() {
        return volume;
    }

    public BadBox getBoxInside() {
        return badBoxInside;
    }

    public Figure getType() {
        return type;
    }

    public double getExternalBoxVolume() {
        return externalBoxVolume;
    }

    public double getInternalBoxVolume() {
        return internalBoxVolume;
    }

    public void setBoxInside(BadBox badBoxInside) {
        this.badBoxInside = badBoxInside;
    }

    public boolean isInternalExists() {
        return badBoxInside != null;
    }

    public BadBox getOldestChild() {
        if (isInternalExists()) return badBoxInside.getOldestChild();
        return this;
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        if (isInternalExists()) {
            sb.append("\n\t\t\t\t┕---");
            sb.append(badBoxInside.show());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "---->" + type + "{ " + Arrays.toString(params) + String.format(" [V = %.2f]", volume) + " }";
    }
}
