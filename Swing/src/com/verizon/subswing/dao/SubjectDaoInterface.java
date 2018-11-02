package com.verizon.subswing.dao;

import java.util.List;

import com.verizon.subswing.exception.SubjectException;
import com.verizon.subswing.model.Subject;

public interface SubjectDaoInterface {
	Subject add(Subject subject) throws SubjectException;
	Subject findByID(int subjectId) throws SubjectException;
	List<Subject> getAllSubjects() throws SubjectException;
	boolean deleteSubject(int subjectId) throws SubjectException;
}
