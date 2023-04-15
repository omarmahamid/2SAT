package com.omar.sat;

import java.util.ArrayList;
import java.util.List;

public class CNFSAT implements SAT{

    private final List<Clause> clauses;

    public CNFSAT() {
        this.clauses = new ArrayList<>();
    }

    public void or(Literal l1, Literal l2){
        Clause clause = new Clause(l1,l2);
        clauses.add(clause);
    }

    public void not(Literal l1){

    }

    public void and(Clause c1, Clause c2){
    }

    @Override
    public List<Clause> getClauses() {
        return clauses;
    }
}
