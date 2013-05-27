/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marius
 */
public class User {
    
    protected String first_name;
    protected String last_name;
    protected String username;
    protected String password;
    
    public User(String first_name, String last_name, String username, String password){
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
    }
    
    public String getFirstName(){
        return this.first_name;
    }
    
    public String setFirstName(String first_name){
        this.first_name = first_name;
        return this.first_name;
    }
    
    public String getLastName(){
        return this.last_name;
    }
    
    public String setLastName(String last_name){
        this.last_name = last_name;
        return this.last_name;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String setUsername(String username){
        this.username = username;
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String setPassword(String password){
        this.password = password;
        return this.password;
    }
    
    
}
