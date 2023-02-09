package com.paradigms.burmus.task2.test;

import com.paradigms.burmus.elf.Elf;
import com.paradigms.burmus.elf.SlowpokeElfImpl;
import com.paradigms.burmus.task2.box.BadBox;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.paradigms.burmus.task2.figure.Figure.*;

class NonPolymorphismTests {
    @AfterEach
    public void line(){
        System.out.println("________________________________________________________________________________");
    }
    @Test
    public void successTest1() {
        BadBox a = new BadBox(CUBOID, 3, 4, 1);
        BadBox b = new BadBox(CYLINDER, 9, 3);
        BadBox c = new BadBox(REGULAR_TETRAHEDRON, 6);
        BadBox d = new BadBox(CUBOID, 3, 10, 3);
        BadBox e = new BadBox(CYLINDER, 100, 4);
        List<BadBox> boxes = new ArrayList<>(List.of(a, b, c, d, e));
        Elf elf = new SlowpokeElfImpl(boxes);
        elf.arrange();
        List<BadBox> resBoxes = (List<BadBox>) elf.getBoxes();
        Assertions.assertEquals(2, resBoxes.size());
        Assertions.assertEquals(CYLINDER, resBoxes.get(0).getType());
        Assertions.assertEquals(CYLINDER, resBoxes.get(0).getBoxInside().getType());
        Assertions.assertEquals(CUBOID, resBoxes.get(0).getBoxInside().getBoxInside().getType());
        Assertions.assertEquals(CUBOID, resBoxes.get(0).getOldestChild().getType());
        Assertions.assertEquals(REGULAR_TETRAHEDRON, resBoxes.get(1).getType());
        Assertions.assertNull(resBoxes.get(1).getBoxInside());
        System.out.println(elf.show());
    }

    @Test
    public void successTest2() {
        BadBox a = new BadBox(CUBOID, 3, 40, 1);
        BadBox b = new BadBox(CYLINDER, 9, 3);
        BadBox c = new BadBox(REGULAR_TETRAHEDRON, 6);
        BadBox d = new BadBox(CUBOID, 3, 10, 3);
        BadBox e = new BadBox(CYLINDER, 2, 4);
        BadBox f = new BadBox(CYLINDER, 9, 4);

        List<BadBox> boxes = new ArrayList<>(List.of(a, b, c, d, e, f));
        Elf elf = new SlowpokeElfImpl(boxes);
        elf.arrange();
        List<BadBox> resBoxes = (List<BadBox>) elf.getBoxes();
        Assertions.assertEquals(3, resBoxes.size());
        Assertions.assertEquals(CYLINDER, resBoxes.get(0).getType());
        Assertions.assertEquals(CYLINDER, resBoxes.get(1).getType());
        Assertions.assertEquals(REGULAR_TETRAHEDRON, resBoxes.get(2).getType());

        Assertions.assertEquals(CUBOID, resBoxes.get(0).getBoxInside().getBoxInside().getType());
        Assertions.assertEquals(CUBOID, resBoxes.get(0).getOldestChild().getType());

        Assertions.assertEquals(CYLINDER, resBoxes.get(1).getOldestChild().getType());
        Assertions.assertNull(resBoxes.get(2).getBoxInside());
        System.out.println(elf.show());
    }

    @Test
    public void failTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BadBox(CUBOID, 1, 1, 1, 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BadBox(REGULAR_TETRAHEDRON, 1, 1, 1, 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BadBox(CYLINDER, 1, 1, 1, 1));
        Assertions.assertThrows(UnsupportedOperationException.class, () -> new BadBox(NON_DEFINED_FIGURE, 1, 1, 1, 1));
    }

    @Test
    public void modificationTest() {
        BadBox a = new BadBox(SPHERE, 3);
        BadBox b = new BadBox(SPHERE, 5);
        BadBox c = new BadBox(SPHERE, 6);
        BadBox d = new BadBox(CUBOID, 8, 8, 8);
        BadBox e = new BadBox(CUBOID, 6, 6, 6);
        BadBox f = new BadBox(CYLINDER, 4, 5);
        List<BadBox> boxes = new ArrayList<>(List.of(a, b, c, d, e, f));
        Elf elf = new SlowpokeElfImpl(boxes);
        elf.arrange();
        List<BadBox> resBoxes = (List<BadBox>) elf.getBoxes();
        Assertions.assertEquals(4, resBoxes.size());


        Assertions.assertEquals(SPHERE, resBoxes.get(0).getType());

        Assertions.assertEquals(CUBOID, resBoxes.get(0).getBoxInside().getType());
        Assertions.assertEquals(CUBOID, resBoxes.get(1).getType());

        Assertions.assertEquals(CYLINDER, resBoxes.get(1).getBoxInside().getType());

        Assertions.assertEquals(SPHERE, resBoxes.get(2).getOldestChild().getType());
        Assertions.assertEquals(SPHERE, resBoxes.get(3).getOldestChild().getType());
        Assertions.assertNull(resBoxes.get(2).getBoxInside());
        System.out.println(elf.show());
    }


}