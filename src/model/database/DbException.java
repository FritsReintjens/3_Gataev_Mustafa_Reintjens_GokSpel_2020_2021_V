package model.database;

/**
 * @Author team
 */

public class DbException extends RuntimeException{
    public DbException(){}
    public DbException(String message){super(message);}
}
