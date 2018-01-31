/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import domain.Login;
import domain.Worker;
import java.util.List;
/**
 *
 * @author syntel
 */
public interface LoginDAO {
    
    public boolean validateLoginId(String s);
    public Login validateUser(Login login);
    public Worker assignUser(Login login);
    public Login changePassword(Worker worker);
    public List<Login> getSystemUsers();
  
    
}
