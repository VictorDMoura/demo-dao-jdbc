package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: seller find by id ======");
        Seller seller = sellerDao.findById(2);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller find by department ======");
        List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 3: seller findAll ======");
        list = sellerDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 4: seller indert ======");
        Seller seller1 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, new Department(2, null));
        sellerDao.insert(seller1);
        System.out.println("Inserted! New id  = " + seller1.getId());

        System.out.println("\n=== TEST 5: seller update ======");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Seller updated");

        System.out.println("\n=== TEST 5: seller update ======");
        System.out.print("Enter if for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();

    }
}
