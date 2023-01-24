package tests;

import models.Milestone;
import models.MilestoneBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestoneTest {
    @Test
    public void lombokTest1(){
        Milestone milestone1 = new Milestone();
        milestone1.setName("ml_01");
        milestone1.setCompleted(true);
        milestone1.setId(1);

        Milestone milestone2 = new Milestone();
        milestone2.setName("ml_01");
        milestone2.setCompleted(true);
        milestone2.setId(2);
        System.out.println(milestone1.toString());
        System.out.println(milestone2.toString());
        Assert.assertTrue(milestone1.equals(milestone2));
    }

    @Test
    public void lombokTest2(){
        MilestoneBuilder milestone1 = MilestoneBuilder.builder()
                .name("mln_02")
                .id(3)
                .completed(false)
                .build();

        MilestoneBuilder milestone2 = MilestoneBuilder.builder()
                .name("mln_02")
                .id(4)
                .completed(false)
                .build();
        System.out.println(milestone2.toString());
        System.out.println(milestone1.toString());

        Assert.assertTrue(milestone1.equals(milestone2));
    }
}
