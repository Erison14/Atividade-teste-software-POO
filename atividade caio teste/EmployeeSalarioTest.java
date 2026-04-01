//questao 1
class EmployeeSalario {
    private String primeiroNome;
    private String ultimoNome;
    private double salarioMensal;

    // Construtor
    public EmployeeSalario(String nome, String sobrenome, double salario) {
        this.primeiroNome = nome;
        this.ultimoNome = sobrenome;

        if (salario > 0.0) {
            this.salarioMensal = salario;
        }
    }

    // Getters e Setters para cada atributo
    
    public void setPrimeiroNome(String nome) { this.primeiroNome = nome; }
    public String getPrimeiroNome() { return primeiroNome; }

    public void setUltimoNome(String sobrenome) { this.ultimoNome = sobrenome; }
    public String getUltimoNome() { return ultimoNome; }

    public void setSalarioMensal(double salario) {
        if (salario > 0.0) {
            this.salarioMensal = salario;
        }
    }
    public double getSalarioMensal() { return salarioMensal; }

    // Método extra para facilitar o teste
    public double getSalarioAnual() {
        return salarioMensal * 12;
    }
}

// Classe de Teste
public class EmployeeSalarioTest {
    public static void main(String[] args) {
        // Instanciando dois objetos usando o novo nome da classe
        EmployeeSalario func1 = new EmployeeSalario("Caio", "Silva", 2500.0);
        EmployeeSalario func2 = new EmployeeSalario("Ana", "Souza", 4000.0);

        // Exibindo o salário anual inicial
        System.out.printf("Salário anual de %s: R$ %.2f\n", func1.getPrimeiroNome(), func1.getSalarioAnual());
        System.out.printf("Salário anual de %s: R$ %.2f\n", func2.getPrimeiroNome(), func2.getSalarioAnual());

        // Aumento de 10%
        func1.setSalarioMensal(func1.getSalarioMensal() * 1.10);
        func2.setSalarioMensal(func2.getSalarioMensal() * 1.10);

        // Exibindo os salários após o aumento
        System.out.println("\n--- Após aumento de 10% ---");
        System.out.printf("Novo salário anual de %s: R$ %.2f\n", func1.getPrimeiroNome(), func1.getSalarioAnual());
        System.out.printf("Novo salário anual de %s: R$ %.2f\n", func2.getPrimeiroNome(), func2.getSalarioAnual());
    }
}