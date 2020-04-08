package com.avatarduel;
import java.util.*;

public abstract class Phase {
    protected boolean isEndphase;
    protected String type;
    protected boolean turn;
    protected Player P1;
    protected Player P2;

    public Phase(Player P1, Player P2, boolean turn, String type) {
        this.P1 = P1;
        this.P2 = P2;
        this.isEndphase = false; //phase always not end when created
        this.turn = turn;//P1 true for P2
        this.type = "";//type of phase {D,M1,B,M2,E}
    }
    public abstract Phase run();
    public abstract Phase nextPhase();
}