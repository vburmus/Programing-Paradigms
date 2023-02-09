package com.paradigms.burmus.elf;

import com.paradigms.burmus.task1.box.Box;

import java.util.ArrayList;
import java.util.List;

public class ElfImpl implements Elf {

    private List<Box> boxes;

    public ElfImpl(List<Box> boxes) {
        this.boxes = boxes;
    }

    @Override
    public List<?> getBoxes() {
        return boxes;
    }

    @Override
    public void setBoxes(List<?> boxes) {
        this.boxes = (List<Box>) boxes;
    }

    @Override
    public void arrange() {
        boxes.sort((o1, o2) -> (int) (o2.getVolume() - o1.getVolume()));
        List<Box> baseBoxes = new ArrayList<>();

        for (Box box : boxes) {
            boolean isInserted = false;
            for (Box baseBox : baseBoxes) {
                Box lastFreeBox = baseBox.getOldestChild();
                if (lastFreeBox.getInternalBoxVolume() > box.getExternalBoxVolume()) {
                    lastFreeBox.setBoxInside(box);
                    isInserted = true;
                    break;
                }
            }
            if (!isInserted) baseBoxes.add(box);

        }
        setBoxes(baseBoxes);
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        for (Box box : boxes) {
            sb.append(box.show());
            sb.append("\n");
        }
        return sb.toString();
    }
}
