package crud;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Crud<T extends Cruddable> {
	
	HashMap<Integer, T> banco;
	AtomicInteger geradorId;

	public Crud(){

		banco = new HashMap<Integer, T>();
		geradorId = new AtomicInteger();
	}

	public void create(T instancia) {

		int id = geradorId.incrementAndGet();
		instancia.setId(id);
		banco.put(id, instancia);
	}

	public List<T> list(){

		return new ArrayList<T>(banco.values());
	}

	public void update(T instancia) {

		banco.replace(instancia.getId(), instancia);
	}

	public void delete(int id) {

		banco.remove(id);
	}

	public T findById(int id) {

		return banco.get(id);
	}
}
