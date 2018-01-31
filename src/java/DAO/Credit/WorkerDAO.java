/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import domain.Worker;
import java.util.List;
/**
 *
 * @author syntel
 */
public interface WorkerDAO {
    
	public Worker findById(Integer id);

	public List<Worker> findAll();

	public void save(Worker worker);

	public void update(Worker worker);

	public void delete(Integer id);
        
        public int getNextPrimaryKey();
        
        public String getLoginId();
}
