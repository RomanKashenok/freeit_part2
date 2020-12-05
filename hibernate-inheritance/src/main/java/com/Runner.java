package com;

import com.config.AppConfig;
import com.strategy.embd.Address;
import com.strategy.embd.Person;
import com.strategy.joined_table.Cat;
import com.strategy.joined_table.Dog;
import com.strategy.mapped_superclass.Barista;
import com.strategy.mapped_superclass.Employee;
import com.strategy.single_table.Chocolate;
import com.strategy.single_table.Shampoo;
import com.strategy.table_per_class.Bicycle;
import com.strategy.table_per_class.Car;
import com.strategy.table_per_class.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SessionFactory sf = context.getBean(SessionFactory.class);
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

//        Employee employee = new Employee("EPAM");
//        employee.setName("Raman");
//        Employee employee1 = new Employee("EPAM");
//        employee1.setName("Vasilij");
//
//        Barista barista = new Barista();
//        barista.setAge(25);
//        barista.setOccupation("Manager");
//        barista.setName("Vasilij");
//
//        Barista barista2 = new Barista();
//        barista2.setAge(25);
//        barista2.setOccupation("Driver");
//        barista2.setName("Mafodij");
//
//        session.save(employee);
//        session.save(employee1);
//        session.save(barista);
//        session.save(barista2);
//
//        Chocolate chocolate = new Chocolate();
//        chocolate.setName("Alena");
//        chocolate.setColor("Milk");
//
//        Shampoo shampoo = new Shampoo();
//        shampoo.setName("Palmolive");
//        shampoo.setProducer("P&G");
//
//        session.save(chocolate);
//        session.save(shampoo);
//
//        Vehicle car = new Car();
//        car.setManufacturer("Nissan");
//
//        Vehicle bicycle = new Bicycle();
//        bicycle.setManufacturer("KROSS");
//
//        session.save(car);
//        session.save(bicycle);
//
//
//        Cat cat = new Cat();
//        cat.setIsHomeCat(true);
//        cat.setName("Vaska");
//        cat.setSpecies("main kun");
//
//        Dog dog = new Dog();
//        dog.setNickName("Remi");
//        dog.setSpecies("Malteze");
//
//        session.save(cat);
//        session.save(dog);

        Person p = new Person();
        p.setName("Raman");
        Address a = new Address();
        a.setHouseNumber(54);
        a.setStreet("Polevaya");
        p.setAddress(a);

        session.save(p);

        transaction.commit();
        session.close();
        context.close();
    }
}
