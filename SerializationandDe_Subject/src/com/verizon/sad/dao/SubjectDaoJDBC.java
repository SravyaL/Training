package com.verizon.sad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.verizon.sad.dao.IqueryMapper;
import com.verizon.sad.jd.ui.ConnectionProvider;
import com.verizon.sad.exception.SubjectClassException;
import com.verizon.sad.model.Subject;

public class SubjectDaoJDBC implements SubjectDao {
	
	public SubjectDaoJDBC() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Subject add(Subject subject) throws SubjectClassException {
		if (subject != null) {

			try (Connection con = ConnectionProvider.getInstance().getConnection();
					PreparedStatement st = con.prepareStatement(IqueryMapper.INS_CONT_QRY);) {
				st.setLong(1, subject.getSubjectId());
				st.setString(2, subject.getSubtitle());
				st.setInt(3, subject.getDurationInHours());
				st.executeUpdate();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return subject;
	}

	@Override
	public Subject findByID(long id) throws SubjectClassException {
		Subject subject = null;
		try (Connection con = ConnectionProvider.getInstance().getConnection();
				PreparedStatement st = con.prepareStatement(IqueryMapper.SEL_CONT_BY_CONT_QRY);) {
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				subject = new Subject();
				subject.setSubjectId(rs.getLong(1));
				subject.setSubtitle(rs.getString(2));
				subject.setDurationInHours(rs.getInt(3));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return subject;
	}

	@Override
	public List<Subject> DisplayByID() throws SubjectClassException {
		Subject subject = null;
		List<Subject> list = new ArrayList<>();
		try (Connection con = ConnectionProvider.getInstance().getConnection();
				PreparedStatement st = con.prepareStatement(IqueryMapper.SEL_ALL_CONT_QRY);) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				subject = new Subject();
				subject.setSubjectId(rs.getLong(1));
				subject.setSubtitle(rs.getString(2));
				subject.setDurationInHours(rs.getInt(3));
				list.add(subject);

			}

		} catch (SQLException | ClassNotFoundException e) {
			throw new SubjectClassException("Retrieval Failed! Err:" + e.getMessage());
		}
		return list;

	}

	@Override
	public boolean deleteSubject(long id, String title, int duration) throws SubjectClassException {
		boolean isDeleted = false;
		try (Connection con = ConnectionProvider.getInstance().getConnection();
				PreparedStatement st = con.prepareStatement(IqueryMapper.DEL_CONT_QRY);) {
			st.setLong(1, id);
			int count = st.executeUpdate();
			if (count == 0)
				isDeleted = false;
			else
				isDeleted = true;
		} catch (SQLException | ClassNotFoundException e) {
			throw new SubjectClassException("Retrieval Failed! Err:" + e.getMessage());
		}
		return isDeleted;	
		}

}
