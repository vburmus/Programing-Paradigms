package com.paradigms.burmus.task1.box;

import com.paradigms.burmus.task2.box.BadBox;

public abstract class Box {

    protected double volume;
    protected double externalBoxVolume;
    protected double internalBoxVolume;

    private Box boxInside;

    protected Box() {
        this.boxInside = null;
    }

    public double getVolume() {
        return volume;
    }

    public double getExternalBoxVolume() {
        return externalBoxVolume;
    }

    public double getInternalBoxVolume() {
        return internalBoxVolume;
    }

    public void setBoxInside(Box boxInside) {
        this.boxInside = boxInside;
    }

    public Box getBoxInside() {
        return boxInside;
    }

    public boolean isInternalExists() {
        return boxInside != null;
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        if (isInternalExists()) {
            sb.append("\n\t\t\t\t┕---");
            sb.append(boxInside.show());
        }
        return sb.toString();
    }

    public Box getOldestChild() {
        if (isInternalExists()) return boxInside.getOldestChild();
        return this;
    }

    public abstract void volume();

    public abstract void externalBoxVolume();

    public abstract void internalBoxVolume();

    public abstract String toString();
}
