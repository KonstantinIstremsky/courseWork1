import java.util.Objects;

class Employee {
    private static int idCounter = 1;  // Статическая переменная-счетчик для ID
    private int id;                    // Уникальный ID сотрудника
    private String fullName;           // ФИО сотрудника
    private int department;            // Отдел сотрудника (от 1 до 5)
    private double salary;             // Зарплата сотрудника

    // Конструктор
    public Employee(String fullName, int department, double salary) {
        this.id = idCounter++;         // Присваиваем ID из счетчика и увеличиваем его
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Сеттеры
    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Переопределяем equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    // Переопределяем hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Переопределяем toString для вывода информации о сотруднике
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}

class EmployeeBook {
    private Employee[] employees = new Employee[10]; // Массив сотрудников

    // Добавление нового сотрудника
    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;  // Если нет места
    }

    // Удаление сотрудника по ID
    public boolean removeEmployeeById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                return true;
            }
        }
        return false;  // Если сотрудник с таким ID не найден
    }

    // Получение сотрудника по ID
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;  // Если сотрудник с таким ID не найден
    }

    // Вывод всех сотрудников
    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    // Индексация зарплаты всех сотрудников
    public void indexSalary(double percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                double newSalary = employee.getSalary() * (1 + percent / 100);
                employee.setSalary(newSalary);
            }
        }
    }

    // Поиск сотрудника с минимальной зарплатой
    public Employee findEmployeeWithMinSalary() {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary())) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    // Другие методы работы с массивом сотрудников (индексация по отделам, расчеты и т.д.) можно реализовать аналогично
}

public class Main {
    public static void main(String[] args) {
        // Создание книги сотрудников
        EmployeeBook employeeBook = new EmployeeBook();

        // Добавление сотрудников
        employeeBook.addEmployee(new Employee("Иванов Иван Иванович", 1, 50000));
        employeeBook.addEmployee(new Employee("Петров Петр Петрович", 2, 60000));
        employeeBook.addEmployee(new Employee("Сидоров Сидор Сидорович", 3, 55000));

        // Печать всех сотрудников
        employeeBook.printAllEmployees();

        // Индексация зарплаты всех сотрудников на 10%
        employeeBook.indexSalary(10);

        // Печать всех сотрудников после индексации
        employeeBook.printAllEmployees();

        // Удаление сотрудника по ID
        employeeBook.removeEmployeeById(1);

        // Печать всех сотрудников после удаления
        employeeBook.printAllEmployees();

        // Поиск сотрудника с минимальной зарплатой
        System.out.println("Сотрудник с минимальной зарплатой: " + employeeBook.findEmployeeWithMinSalary());
    }
}
