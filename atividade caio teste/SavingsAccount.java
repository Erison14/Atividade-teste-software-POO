//questao 4
public class SavingsAccount {
    private static double annualInterestRate; 
    private double savingsBalance;

    public SavingsAccount(double saldo) {
        savingsBalance = saldo;
    }

   
    public void calculateMonthlyInterest() {
        double juros = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += juros;
    }

    
    public static void modifyInterestRate(double novaTaxa) {
        annualInterestRate = novaTaxa;
    }

    public void imprimirSaldo(String nome) {
        System.out.printf("%s - Saldo atual: $%.2f\n", nome, savingsBalance);
    }

    public static void main(String[] args) {
       
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);

        
        SavingsAccount.modifyInterestRate(0.04);
        
        
System.out.println("Saldos mensais com taxa de 4%:");
for(int i = 1; i <= 12; i++) {
    saver1.calculateMonthlyInterest();
    saver2.calculateMonthlyInterest();
    
    
    System.out.printf("Mês %d -> ", i);
    saver1.imprimirSaldo("Saver 1");
    System.out.printf("Mês %d -> ", i);
    saver2.imprimirSaldo("Saver 2");
    System.out.println("---------------------------");
}

        
       
        SavingsAccount.modifyInterestRate(0.05);
        
      
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("\nSaldos após o mês seguinte com taxa de 5%:");
        saver1.imprimirSaldo("Saver 1");
        saver2.imprimirSaldo("Saver 2");
    }
}