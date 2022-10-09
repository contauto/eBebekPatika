package entities;
import java.util.Date;

public class Employee {
    public String Name;
    public float Salary;
    public float WorkHours;
    public int StartedYear;

    public Employee(String name, float salary, float workHours, int startedYear) {
        Name = name;
        Salary = salary;
        WorkHours = workHours;
        StartedYear = startedYear;

    }

    public float Tax(Employee employee) {
        if (employee.Salary < 1000) {
            return 0;
        } else {

            return employee.Salary * 3 / 100;
        }
    }

    public float Bonus(Employee employee) {
        if (employee.WorkHours > 40) {

            return (WorkHours - 40) * 30;
        } else {
            return 0;
        }
    }

    public float RaiseSalary(Employee employee) {
        int date = new Date().getYear();
        if (date - StartedYear < 10) {
            return (employee.Salary + employee.Bonus(employee) - employee.Tax(employee)) * 5 / 100;
        } else if (date - StartedYear < 20 && date - StartedYear > 9) {
            return (employee.Salary + employee.Bonus(employee) - employee.Tax(employee)) * 10 / 100;
        } else {
            return (employee.Salary + employee.Bonus(employee) - employee.Tax(employee)) * 15 / 100;
        }
    }

    public void toString(Employee employee) {
        System.out.println(employee.Name + " isimli çalışan"+" " + employee.StartedYear + " yılında başlamış olup haftada " + employee.WorkHours + " saat çalışıp " + employee.Salary + " Türk Lirası maaş almaktadır.");
        System.out.println((employee.Name + " isimli çalışana")+(" ")+employee.Tax(employee) + " Türk Lirası vergi uygulanacaktır.");
        System.out.println((employee.Name + " isimli çalışan")+(" ")+employee.Bonus(employee) + " Türk Lirası bonus alacaktır.");
        System.out.println((employee.Name + " isimli çalışan")+(" ")+employee.RaiseSalary(employee) + " Türk Lirası zam alacaktır.");
    }

}
