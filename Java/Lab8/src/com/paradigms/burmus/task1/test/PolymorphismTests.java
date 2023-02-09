package com.paradigms.burmus.task1.test;

import com.paradigms.burmus.elf.Elf;
import com.paradigms.burmus.elf.ElfImpl;
import com.paradigms.burmus.task1.box.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PolymorphismTests {
    @AfterEach
    public void line(){
        System.out.println("________________________________________________________________________________");
    }
    @Test
    public void successTest1() {
        Box a = new Cuboid(3, 4, 1);
        Box b = new Cylinder(9, 3);
        Box c = new RegularTetrahedron(6);
        Box d = new Cuboid(3, 10, 3);
        Box e = new Cylinder(100, 4);
        List<Box> boxes = new ArrayList<>(List.of(a, b, c, d, e));
        Elf elf = new ElfImpl(boxes);
        elf.arrange();
        List<Box> resBoxes = (List<Box>) elf.getBoxes();
        Assertions.assertEquals(2, resBoxes.size());
        Assertions.assertEquals(Cylinder.class, resBoxes.get(0).getClass());
        Assertions.assertEquals(Cylinder.class, resBoxes.get(0).getBoxInside().getClass());
        Assertions.assertEquals(Cuboid.class, resBoxes.get(0).getBoxInside().getBoxInside().getClass());
        Assertions.assertEquals(Cuboid.class, resBoxes.get(0).getOldestChild().getClass());
        Assertions.assertEquals(RegularTetrahedron.class, resBoxes.get(1).getClass());
        Assertions.assertNull(resBoxes.get(1).getBoxInside());
        System.out.println(elf.show());
    }

    @Test
    public void successTest2() {
        Box a = new Cuboid(3, 40, 1);
        Box b = new Cylinder(9, 3);
        Box c = new RegularTetrahedron(6);
        Box d = new Cuboid(3, 10, 3);
        Box e = new Cylinder(2, 4);
        Box f = new Cylinder(9, 4);
        List<Box> boxes = new ArrayList<>(List.of(a, b, c, d, e, f));
        Elf elf = new ElfImpl(boxes);
        elf.arrange();
        List<Box> resBoxes = (List<Box>) elf.getBoxes();
        Assertions.assertEquals(3, resBoxes.size());
        Assertions.assertEquals(Cylinder.class, resBoxes.get(0).getClass());
        Assertions.assertEquals(Cylinder.class, resBoxes.get(1).getClass());
        Assertions.assertEquals(RegularTetrahedron.class, resBoxes.get(2).getClass());

        Assertions.assertEquals(Cuboid.class, resBoxes.get(0).getBoxInside().getBoxInside().getClass());
        Assertions.assertEquals(Cuboid.class, resBoxes.get(0).getOldestChild().getClass());

        Assertions.assertEquals(Cylinder.class, resBoxes.get(1).getOldestChild().getClass());
        Assertions.assertNull(resBoxes.get(2).getBoxInside());
        System.out.println(elf.show());
    }

    @Test
    public void modification() {
        Box a = new Sphere(3);
        Box b = new Sphere(5);
        Box c = new Sphere(6);
        Box d = new Cuboid(8, 8, 8);
        Box e = new Cuboid(6, 6, 6);
        Box f = new Cylinder(4, 5);
        List<Box> boxes = new ArrayList<>(List.of(a, b, c, d, e, f));
        Elf elf = new ElfImpl(boxes);
        elf.arrange();
        List<Box> resBoxes = (List<Box>) elf.getBoxes();
        Assertions.assertEquals(4, resBoxes.size());


        Assertions.assertEquals(Sphere.class, resBoxes.get(0).getClass());
        Assertions.assertEquals(Cuboid.class, resBoxes.get(0).getBoxInside().getClass());

        Assertions.assertEquals(Cuboid.class, resBoxes.get(1).getClass());
        Assertions.assertEquals(Cylinder.class, resBoxes.get(1).getBoxInside().getClass());
        Assertions.assertEquals(Sphere.class, resBoxes.get(2).getClass());
        Assertions.assertEquals(Sphere.class, resBoxes.get(3).getClass());
        Assertions.assertNull(resBoxes.get(3).getBoxInside());
        System.out.println(elf.show());
    }


}