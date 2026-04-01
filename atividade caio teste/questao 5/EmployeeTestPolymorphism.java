// Questão 5
// a. Classe abstrata
abstract class Employee {
    private String firstName, lastName, cpf;

    public Employee(String firstName, String lastName, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    // d. Métodos Get/Set completos
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return lastName; }

    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getCpf() { return cpf; }

    // b. Método abstrato
    public abstract double earnings();

    // e. toString
    @Override
    public String toString() {
        return String.format("%s %s\nCPF: %s", firstName, lastName, cpf);
    }
}

// 1. Assalariado (Salaried)
class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String f, String l, String c, double s) {
        super(f, l, c);
        setWeeklySalary(s);
    }

    public void setWeeklySalary(double s) { this.weeklySalary = s > 0 ? s : 0; }
    public double getWeeklySalary() { return weeklySalary; }

    @Override
    public double earnings() { return weeklySalary; }

    @Override
    public String toString() {
        return String.format("Assalariado: %s\nSalário Semanal: $%.2f", super.toString(), weeklySalary);
    }
}

// 2. Horista (Hourly)
class HourlyEmployee extends Employee {
    private double wage, hours;

    public HourlyEmployee(String f, String l, String c, double w, double h) {
        super(f, l, c);
        setWage(w);
        setHours(h);
    }

    public void setWage(double w) { this.wage = w > 0 ? w : 0; }
    public double getWage() { return wage; }

    public void setHours(double h) { this.hours = (h >= 0 && h <= 168) ? h : 0; }
    public double getHours() { return hours; }

    @Override
    public double earnings() {
        if (hours <= 40) return wage * hours;
        else return (40 * wage) + ((hours - 40) * wage * 1.5);
    }

    @Override
    public String toString() {
        return String.format("Horista: %s\nValor por Hora: $%.2f | Horas Trabalhadas: %.2f", 
            super.toString(), wage, hours);
    }
}

// 3. Comissionado (Commission)
class CommissionEmployee extends Employee {
    private double grossSales, commissionRate;

    public CommissionEmployee(String f, String l, String c, double s, double r) {
        super(f, l, c);
        setGrossSales(s);
        setCommissionRate(r);
    }

    public void setGrossSales(double s) { this.grossSales = s > 0 ? s : 0; }
    public double getGrossSales() { return grossSales; }

    public void setCommissionRate(double r) { this.commissionRate = (r > 0 && r < 1) ? r : 0; }
    public double getCommissionRate() { return commissionRate; }

    @Override
    public double earnings() { return grossSales * commissionRate; }

    @Override
    public String toString() {
        return String.format("Comissionado: %s\nVendas Brutas: $%.2f | Taxa de Comissão: %.2f", 
            super.toString(), grossSales, commissionRate);
    }
}

// 4. Base + Comissão (BasePlusCommission)
class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String f, String l, String c, double s, double r, double b) {
        super(f, l, c, s, r);
        setBaseSalary(b);
    }

    public void setBaseSalary(double b) { this.baseSalary = b > 0 ? b : 0; }
    public double getBaseSalary() { return baseSalary; }

    @Override
    public double earnings() { return getBaseSalary() + super.earnings(); }

    @Override
    public String toString() {
        return String.format("Base + Comissão: %s\nSalário Base: $%.2f", 
            super.toString(), baseSalary); // super.toString() aqui chama o toString do CommissionEmployee
    }
}

// f. Classe de Teste
public class EmployeeTestPolymorphism {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];
        
        employees[0] = new SalariedEmployee("Joao", "Silva", "111.111.111-11", 800.00);
        employees[1] = new HourlyEmployee("Maria", "Souza", "222.222.222-22", 20.0, 45.0);
        employees[2] = new CommissionEmployee("Jose", "Pereira", "333.333.333-33", 10000, 0.06);
        employees[3] = new BasePlusCommissionEmployee("Ana", "Luz", "444.444.444-44", 5000, 0.04, 300);

        System.out.println("--- PROCESSANDO FOLHA DE PAGAMENTO (POLIMORFISMO) ---\n");
        
        for (Employee currentEmployee : employees) {
            // Isso chama automaticamente o método toString() sobrescrito de cada classe
            System.out.println(currentEmployee);
            // Isso chama o método earnings() correto de acordo com a classe do objeto
            System.out.printf("Ganhos Totais: $%.2f\n", currentEmployee.earnings());
            System.out.println("---------------------------------------------------");
        }
    }
}