package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        System.out.println("=== TEST 1: seller find by id ======");
        Department dep = departmentDao.findById(2);
        System.out.println(dep);

        System.out.println("\n=== TEST 2: seller find all ======");
        List<Department> departments = departmentDao.findAll();
        departments.forEach(System.out::println);

        System.out.println("\n=== TEST 3: seller insert ======");
        Department newDep = new Department(null, "Smartphones");
        departmentDao.insert(newDep);
        departments = departmentDao.findAll();
        departments.forEach(System.out::println);

        System.out.println("\n=== TEST 4: seller insert ======");
        dep = departmentDao.findById(6);
        dep.setName("Novo Departamento");
        departmentDao.update(dep);
        departments = departmentDao.findAll();
        departments.forEach(System.out::println);

        System.out.println("\n=== TEST 4: seller insert ======");
        departmentDao.deleteById(7);
        departments = departmentDao.findAll();
        departments.forEach(System.out::println);



    }
}
