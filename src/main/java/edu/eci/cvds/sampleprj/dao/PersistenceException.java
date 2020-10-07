package edu.eci.cvds.sampleprj.dao;

public class PersistenceException extends Exception{
    public PersistenceException (String m,Exception e){
        super(m+e.toString());
    }
}
