package DAO;

import domain.Worker;
import java.util.List;
/**
 * DAO interface specifying the worker methods
 * 
 */
public interface WorkerDAO {
    
	public List<Worker> findById(Integer id);
	public List<Worker> findAll();
	public void save(Worker worker);
	public void edit(Worker worker);
	public void delete(Worker worker);
        public int getNextPrimaryKey();  
}
