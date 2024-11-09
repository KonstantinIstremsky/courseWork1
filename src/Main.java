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

    // Поиск сотрудника с максимальной зарплатой
    public Employee findEmployeeWithMaxSalary() {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary())) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    // Расчет общей суммы зарплат
    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    // Расчет средней зарплаты
    public double calculateAverageSalary() {
        double totalSalary = calculateTotalSalary();
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count > 0 ? totalSalary / count : 0;
    }
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

        // Поиск сотрудника с максимальной зарплатой
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeBook.findEmployeeWithMaxSalary());

        // Расчет общей суммы зарплат
        System.out.println("Общая сумма зарплат: " + employeeBook.calculateTotalSalary());

        // Расчет средней зарплаты
        System.out.println("Средняя зарплата: " + employeeBook.calculateAverageSalary());
    }
}
