package com.paradigms.burmus.elf;

import java.util.List;

public interface Elf {
    List<?> getBoxes();

    void setBoxes(List<?> boxes);

    void arrange();

    String show();
}
