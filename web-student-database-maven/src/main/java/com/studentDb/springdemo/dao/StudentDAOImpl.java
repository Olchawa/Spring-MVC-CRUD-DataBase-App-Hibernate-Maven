package com.studentDb.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.studentDb.springdemo.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// injecting the session factory
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<Student> getStudents() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query sort by last name
		Query<Student> theQuery = currentSession.createQuery("from Student order by lastName", Student.class);

		// execute query and get result list
		List<Student> students = theQuery.getResultList();

		// return the results
		return students;
	}

	@Override
	public void saveStudent(Student theStudent) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/update the student
		currentSession.saveOrUpdate(theStudent);

	}

	@Override
	public Student getStudent(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// retrive from database using the primary key
		Student theStudent = currentSession.get(Student.class, theId);

		return theStudent;
	}

	@Override
	public void deleteStudent(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from Student where id=:studentId");
		theQuery.setParameter("studentId", theId);
		theQuery.executeUpdate();

	}

	@Override
	public List<Student> getsortedFirstNameStudents() {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// create a query sort by last name
				Query<Student> theQuery = currentSession.createQuery("from Student order by firstName", Student.class);

				// execute query and get result list
				List<Student> students = theQuery.getResultList();

				// return the results
				return students;
	}

}
