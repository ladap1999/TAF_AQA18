package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Listener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Make a screenshot");
    }

}
