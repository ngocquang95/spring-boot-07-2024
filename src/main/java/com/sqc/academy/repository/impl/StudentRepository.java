package com.sqc.academy.repository.impl;

import com.sqc.academy.entity.Student;
import com.sqc.academy.repository.IStudentRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    public List<Student> findAll() {
        Session session = ConnectionUtil.sessionFactory.openSession(); // Bước 1: Mở phiên làm việc (Session) từ ConnectionUtil
        List<Student> students = null;
        try {
            students = session.createQuery("FROM Student").getResultList(); // Bước 2: Sử dụng HQL để lấy danh sách sinh viên
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close(); // Bước 3: Đóng phiên làm việc sau khi lấy danh sách xong
        }
        return students;
    }


    public Student findById(Integer id) {
        Session session = ConnectionUtil.sessionFactory.openSession(); // Bước 1: Mở phiên làm việc (Session) từ ConnectionUtil
        Student student = null;
        try {
            student = (Student) session.createQuery("FROM Student where id = :id")
                    .setParameter("id", id)
                    .uniqueResult(); // Bước 2: Sử dụng HQL để lấy danh sách sinh viên
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close(); // Bước 3: Đóng phiên làm việc sau khi lấy danh sách xong
        }
        return student;
    }

    public Student save(Student student) {
        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.saveOrUpdate(student);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback(); // Rollback nếu có lỗi
                }
                throw new RuntimeException(e);
            }
        }
        return student;
    }
}
