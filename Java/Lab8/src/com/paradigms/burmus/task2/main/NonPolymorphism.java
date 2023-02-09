package com.paradigms.burmus.task2.main;


import com.paradigms.burmus.elf.SlowpokeElfImpl;
import com.paradigms.burmus.task2.box.BadBox;


import java.util.ArrayList;
import java.util.List;

import static com.paradigms.burmus.task2.figure.Figure.*;

public class NonPolymorphism {
    public static void main(String[] args) {
        BadBox a = new BadBox(CUBOID, 3, 3, 3);
        BadBox b = new BadBox(CYLINDER, 10, 3);
        BadBox c = new BadBox(REGULAR_TETRAHEDRON, 5);
        BadBox d = new BadBox(CUBOID, 2, 9, 5);
        BadBox e = new BadBox(CYLINDER, 5, 4);
        List<BadBox> boxes = new ArrayList<>(List.of(a, b, c, d, e));
        SlowpokeElfImpl elf = new SlowpokeElfImpl(boxes);
        elf.arrange();
        System.out.println(elf.show());
    }
}
