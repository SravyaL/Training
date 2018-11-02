

package com.verizon.subswing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.verizon.subswing.exception.SubjectException;
import com.verizon.subswing.model.Subject;
import com.verizon.subswing.util.ConnectionProvider;

public class SubjectDaoJDBCImp implements SubjectDaoInterface {

	public SubjectDaoJDBCImp(){
		//default constructor
	}
	

	@Override
	public Subject add(Subject subject) throws SubjectException {
		if(subject!=null){
			try(Connection con = ConnectionProvider.getInstance().getConnection();
					
				PreparedStatement st = con.prepareStatement(QueryMapper.INS_CONT_QRY);){
				st.setInt(1, subject.getSubjectId());
				st.setString(2, subject.getSubtitle());
				st.setInt(3, subject.getDurationInHours());
				
				st.executeUpdate();
			}catch(SQLException | ClassNotFoundException e){
				throw new SubjectException(
						"Insertion failed! Error: " + e.getMessage());
			}
		}
		return subject;
	}

	@Override
	public Subject findByID(int id) throws SubjectException {
		Subject subject = null;
		
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				
			PreparedStatement st = con.prepareStatement(QueryMapper.SEL_CONT_BY_MNO_QRY);){
			
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				subject = new Subject();
				subject.setSubjectId(rs.getInt(1));
				subject.setSubtitle(rs.getString(2));
				subject.setDurationInHours(rs.getInt(3));
			}
			
			
			
			
			}catch(SQLException | ClassNotFoundException e){
				throw new SubjectException(
						"Retrieval failed! Error: " + e.getMessage());
			}
		
		return subject;
		
	}

	@Override
	public List<Subject> getAllSubjects() throws SubjectException {
		List<Subject> list = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				
			PreparedStatement st = con.prepareStatement(QueryMapper.SET_ALL_CONT_QRY);){
				
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				
				Subject subject = new Subject();
				subject.setSubjectId(rs.getInt(1));
				subject.setSubtitle(rs.getString(2));
				subject.setDurationInHours(rs.getInt(3));
				list.add(subject);
				
			}
			
			}catch(SQLException | ClassNotFoundException e){
				throw new SubjectException(
						"Retreival failed! Error: " + e.getMessage());
			}
		return list;
	}

	@Override
	public boolean deleteSubject(int id) throws SubjectException {
		
		boolean isDeleted = false;
		
		
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				
			PreparedStatement st = con.prepareStatement(QueryMapper.DEL_CONT_QRY);){
				
			st.setInt(1, id);
			int count = st.executeUpdate();
			
			if(count==0)
				isDeleted = false;
			else
				isDeleted = true;
			
			}catch(SQLException | ClassNotFoundException e){
				throw new SubjectException(
						"Deletion failed! Error: " + e.getMessage());
			}
		return isDeleted;
		
	}

}
