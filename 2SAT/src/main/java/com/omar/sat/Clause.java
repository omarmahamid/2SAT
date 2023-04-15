package com.omar.sat;

public class Clause{

    private final Literal l1;
    private final Literal l2;

    public Clause(Literal l1, Literal l2){
        this.l1 = l1;
        this.l2 = l2;
    }

    public Literal getL1() {
        return l1;
    }

    public Literal getL2() {
        return l2;
    }
}
