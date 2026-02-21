import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class Main{
    public static void main(String[] args){

        //Agregation
        Department deptdesign = new Department("Graphic Designer");
        EmploymentType freelance = new EmploymentType("Freelancer");

        Employee Pekerja1 = new Employee("Faqih", deptdesign, freelance, 3000000);

        System.out.println("Nama: " + Pekerja1.getName() + "\nID Pekerja: " + 
            Pekerja1.getId()+"\nNama Departemen: "+ Pekerja1.getDepartment().getName()
            + "\nGaji Saat ini: " + Pekerja1.getSalary());

        //Dependency
        EmployeeService Salaryservice = new EmployeeService();

        Salaryservice.addEmployee(Pekerja1);
        Salaryservice.raiseSalary(Pekerja1.getId(),30);

        System.out.println("\n" + Pekerja1.getName() + " Mengalami kenaikan Gaji menjadi:");
        System.out.println("Gaji " + Pekerja1.getName() + " terbaru adalah = Rp." 
            + Salaryservice.getEmployee(Pekerja1.getId()).getSalary());

        System.out.println("\nId Pekerja Selanjutnya: " + Employee.getstepId());
    }
}