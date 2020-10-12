//package com.mycompany.ee.mainpackage;
//
//import com.mycompany.ee.exceptions.InvalidMarkException;
//
//public class Mark {
//    private Enum subject;
//    private int mark;
//
//    public Mark(Enum subject, int mark) {
//        this.subject = subject;
//        if (mark < 0 || mark > 10) throw new InvalidMarkException("Invalid mark: " + mark);
//        this.mark = mark;
//    }
//
//    @Override
//    public String toString() {
//        return System.lineSeparator() + "subject:" + subject + " ,mark" + mark;
//    }
//}
