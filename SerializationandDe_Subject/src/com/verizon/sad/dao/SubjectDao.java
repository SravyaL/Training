package com.verizon.sad.dao;

import java.util.List;

import com.verizon.sad.exception.SubjectClassException;
import com.verizon.sad.model.Subject;

public interface SubjectDao {
	Subject add(Subject subject) throws SubjectClassException;
	Subject findByID(long id) throws SubjectClassException;
	List<Subject> DisplayByID() throws SubjectClassException;
	boolean deleteSubject(long id, String title, int duration) throws SubjectClassException;

}
