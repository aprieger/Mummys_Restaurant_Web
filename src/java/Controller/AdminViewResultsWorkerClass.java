/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import domain.Worker;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author syntel
 */
public class AdminViewResultsWorkerClass extends SimpleFormController {
    
    public AdminViewResultsWorkerClass() {
        setCommandClass(Worker.class);
        setCommandName("worker");
    }
    
    
}

