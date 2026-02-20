import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIMULASI SISTEM KARYAWAN ===");

        // 1. MENGUJI STATIC FIELD & METHOD
        System.out.println("ID Karyawan yang akan dibuat selanjutnya: " + Employee.getNextId());

        // 2. MENGUJI AGGREGATION (Relasi "Has-A" / Memiliki)
        // Kita buat Departemen dan Tipe Pekerjaan terlebih dahulu
        Department deptIT = new Department("Information Technology");
        Department deptHR = new Department("Human Resources");
        
        EmploymentType typeFullTime = new EmploymentType("Full-Time");
        EmploymentType typeIntern = new EmploymentType("Internship");

        // Kita buat Karyawannya (Karyawan "memiliki" Departemen dan Tipe Pekerjaan)
        Employee emp1 = new Employee("Budi Santoso", deptIT, typeFullTime, 8000000);
        Employee emp2 = new Employee("Siti Aminah", deptHR, typeIntern, 3000000);

        // Mari kita cek ID-nya (otomatis terisi 1 dan 2 berkat 'static')
        System.out.println("\nKaryawan 1: " + emp1.getName() + " | ID: " + emp1.getId() + " | Dept: " + emp1.getDepartment().getName());
        System.out.println("Karyawan 2: " + emp2.getName() + " | ID: " + emp2.getId() + " | Dept: " + emp2.getDepartment().getName());
        
        System.out.println("ID Karyawan yang akan dibuat selanjutnya: " + Employee.getNextId());

        // 3. MENGUJI DEPENDENCY (Relasi "Uses-A" / Menggunakan)
        // EmployeeService "menggunakan" Employee sebagai parameternya
        EmployeeService service = new EmployeeService();
        
        // Memasukkan karyawan ke dalam sistem service
        service.addEmployee(emp1);
        service.addEmployee(emp2);

        System.out.println("\n=== NAIK GAJI (DEPENDENCY TEST) ===");
        System.out.println("Gaji Budi sebelum naik: Rp " + emp1.getSalary());
        
        // Service memproses kenaikan gaji Budi (ID 1) sebesar 10%
        service.raiseSalary(1, 10); 
        
        // Ambil data Budi yang baru dari service
        Employee budiUpdate = service.getEmployee(1);
        System.out.println("Gaji Budi setelah naik 10%: Rp " + budiUpdate.getSalary());
    }
}