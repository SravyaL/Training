package com.verizon.sad.service;

import java.util.List;

import com.verizon.sad.exception.SubjectClassException;
import com.verizon.sad.model.Subject;


public interface SubjectService {
	boolean isValid(Subject subject) throws SubjectClassException;
	Subject add(Subject subject) throws SubjectClassException;
	Subject findByID(long id) throws SubjectClassException;
	List<Subject> Display() throws SubjectClassException;
	boolean deleteSubject(long id, String title, int duration) throws SubjectClassException;


}
