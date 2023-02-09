package com.paradigms.burmus.elf;

import com.paradigms.burmus.elf.Elf;
import com.paradigms.burmus.task2.box.BadBox;

import java.util.ArrayList;
import java.util.List;

public class SlowpokeElfImpl implements Elf {
    private List<BadBox> boxes;

    public SlowpokeElfImpl(List<BadBox> boxes) {
        this.boxes = boxes;
    }

    @Override
    public void arrange() {
        boxes.sort((o1, o2) -> (int) (o2.getVolume() - o1.getVolume()));
        List<BadBox> baseBoxes = new ArrayList<>();

        for (BadBox box : boxes) {
            boolean isInserted = false;
            for (BadBox baseBox : baseBoxes) {
                BadBox lastFreeBox = baseBox.getOldestChild();
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

    @Override
    public String show() {
        StringBuilder sb = new StringBuilder();
        for (BadBox box : boxes) {
            sb.append(box.show());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public List<?> getBoxes() {
        return boxes;
    }

    @Override
    public void setBoxes(List<?> boxes) {
        this.boxes = (List<BadBox>) boxes;
    }
}
