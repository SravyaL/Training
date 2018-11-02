package com.verizon.sad.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.verizon.sad.exception.SubjectClassException;
import com.verizon.sad.model.Subject;

public class SubjectDaoImpl implements SubjectDao {

	public static final String DATA_STORE = "subject.data";

	private Map<Long, Subject> subjects;

	public SubjectDaoImpl() {

		boolean isLoaded = loadData();
		if (!isLoaded) {
			subjects = new TreeMap<Long, Subject>();
		}
	}

	private boolean loadData() {
		boolean isLoaded = false;
		try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream(DATA_STORE));) {
			Object obj = fin.readObject();
			if (obj instanceof Map) {
				subjects = (Map<Long, Subject>) obj;
				isLoaded = true;
			}
		} catch (IOException | ClassNotFoundException e) {
			isLoaded = false;

		}
		return isLoaded;
	}

	private void saveData() throws FileNotFoundException, IOException, SubjectClassException{
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_STORE));){
			out.writeObject(subjects);
		}catch(IOException e){
			throw new SubjectClassException("Data stored is corrupt/ not available");
		}
	}

	@Override
	public Subject add(Subject subject) throws SubjectClassException {
	
			if(subject!=null){
				subjects.put(subject.getSubjectId(), subject);
			}
			try {
				saveData();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	return subject;	
}

	@Override
	public Subject findByID(long id) throws SubjectClassException {
		return subjects.get(id);
	}

	@Override
	public List<Subject> DisplayByID() throws SubjectClassException {
		 return new ArrayList<Subject>(subjects.values());
	}

	

	@Override
	public boolean deleteSubject(long id, String title, int duration) throws SubjectClassException {
		boolean isDeleted= false;
		if(subjects.containsKey(id)){
			subjects.remove(id);
			try {
				saveData();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			isDeleted = true;
		}
		return isDeleted;	}

}
