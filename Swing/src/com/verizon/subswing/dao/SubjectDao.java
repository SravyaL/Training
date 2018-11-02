
package com.verizon.subswing.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.verizon.subswing.exception.SubjectException;
import com.verizon.subswing.model.Subject;

public class SubjectDao implements SubjectDaoInterface {
	
	public static final String DATA_STORE = "Subject.data";
	
	private Map<Integer, Subject> subjects;
	
	public SubjectDao() {
		boolean isLoaded = loadData();
		if(!isLoaded) {
			subjects = new TreeMap<Integer, Subject>();
		}
	}
	
	private boolean loadData() {
		boolean isLoaded = false;
		try(ObjectInputStream fin = new ObjectInputStream(new FileInputStream(DATA_STORE));){
			Object obj = fin.readObject();
			if(obj instanceof Map) {
				subjects = (Map<Integer, Subject>)obj;
				isLoaded = true;
			}
		} catch(IOException | ClassNotFoundException ce) {
			isLoaded = false;
		}
		return isLoaded;
	}
	
	private void saveData() throws SubjectException {
		try(ObjectOutputStream fon  = new ObjectOutputStream(new FileOutputStream(DATA_STORE));){
			fon.writeObject(subjects);
		} catch(IOException e) {
			throw new SubjectException("Data Storage is corrupt or not available");
		}
	}

	@Override
	public Subject add(Subject subject) throws SubjectException {
		if(subject!=null) {
			subjects.put(subject.getSubjectId(), subject);
			saveData();
		}
		return subject;
	}

	@Override
	public Subject findByID(int subjectId) throws SubjectException {
		return subjects.get(subjectId);
	}


	@Override
	public List<Subject> getAllSubjects() throws SubjectException {
		return new ArrayList<Subject>(subjects.values());
	}

	@Override
	public boolean deleteSubject(int subjectId) throws SubjectException {
		boolean isDeleted = false;
		if(subjects.containsKey(subjectId)) {
			subjects.remove(subjectId);
			saveData();
			isDeleted = true;
		}
		return isDeleted;
	}

}
