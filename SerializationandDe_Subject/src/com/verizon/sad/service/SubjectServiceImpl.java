package com.verizon.sad.service;

import java.util.List;

import com.verizon.sad.dao.SubjectDao;
import com.verizon.sad.dao.SubjectDaoImpl;
import com.verizon.sad.dao.SubjectDaoJDBC;
import com.verizon.sad.exception.SubjectClassException;
import com.verizon.sad.model.Subject;

public class SubjectServiceImpl implements SubjectService {
	
	private SubjectDao sdao = null;
	
	public SubjectServiceImpl(){
		sdao = new SubjectDaoJDBC();
	}
	
	private boolean isValidDuration(int durationInHours) {
		if(durationInHours <= 0)
			return false;
		else
			return true;
	}
	private boolean isValidName(String subtitle) {
		String nameRegEx = "[A-Z][A-Za-z]{3,14}";
		return subtitle!=null && subtitle.matches(nameRegEx);	}

	
	private boolean isValidID(long subjectId) {
		if(subjectId <= 0)
			return false;
		else
			return true;
	}




	@Override
	public boolean isValid(Subject subject) throws SubjectClassException {
		boolean isValid = true;
		StringBuilder errs = new StringBuilder();
		if(!isValidDuration(subject.getDurationInHours())){
			errs.append("must be greater than 0");
			isValid=false;
		}
		if(!isValidID(subject.getSubjectId())){
			errs.append("must be greater than 0");
			isValid=false;
		}
		if(!isValidName(subject.getSubtitle())){
			errs.append("name must be init caped");
			isValid=false;
		}
		
		
		if(!isValid){
			throw new SubjectClassException(errs.toString());
		}
		return isValid;
	}

	
	
	
	@Override
	public Subject add(Subject subject) throws SubjectClassException {
		if(subject!=null && isValid(subject)){
			sdao.add(subject);
		}
		return subject;	
	}

	@Override
	public Subject findByID(long id) throws SubjectClassException {
		return sdao.findByID(id);
	}

	@Override
	public List<Subject> Display() throws SubjectClassException {
		return sdao.DisplayByID();
	}

	
	@Override
	public boolean deleteSubject(long id, String title, int duration) throws SubjectClassException {
		return sdao.deleteSubject(id, title, duration);
	}

}
