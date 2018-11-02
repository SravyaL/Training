package com.verizon.subswing.service;

import java.util.List;

import com.verizon.subswing.dao.SubjectDaoInterface;
import com.verizon.subswing.dao.SubjectDaoJDBCImp;
import com.verizon.subswing.exception.SubjectException;
import com.verizon.subswing.model.Subject;

public class SubjectServiceImp implements SubjectService {

	private SubjectDaoInterface subjectDao = null;

	public SubjectServiceImp() {
		subjectDao = new SubjectDaoJDBCImp();
	}

	private boolean isValidTitle(String title) {
		String nameRegEx = "[A-Z][A-za-z]{3,14}";
		return title != null && title.matches(nameRegEx);
	}

	private boolean isValidHours(Integer hours) {
		return hours != null;
	}

	private boolean isValidId(Integer id) {
		return id != null;
	}

	@Override
	public boolean isValid(Subject subject) throws SubjectException {
		boolean isValid = true;
		StringBuilder errs = new StringBuilder();
		if (isValidId(subject.getSubjectId())) {
			errs.append("Enter Valid Id");
		}
		if (isValidTitle(subject.getSubtitle())) {
			errs.append("4-15 chars");
		}
		if (isValidHours(subject.getDurationInHours())) {
			errs.append("Invalid");
		}
		if (!isValid)
			throw new SubjectException(errs.toString());
		return isValid;
	}

	@Override
	public Subject add(Subject subject) throws SubjectException {
		if (subject != null && isValid(subject))
			subjectDao.add(subject);
		return subject;
	}

	@Override
	public Subject findByID(int id) throws SubjectException {
		return subjectDao.findByID(id);
	}

	@Override
	public List<Subject> getAllSubjects() throws SubjectException {
		return subjectDao.getAllSubjects();
	}

	@Override
	public boolean deleteSubject(int id) throws SubjectException {
		return subjectDao.deleteSubject(id);
	}

}
