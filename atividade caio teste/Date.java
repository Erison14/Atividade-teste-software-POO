//questao 2
public class Date {
    private int dia;
    private int mes;
    private int ano;

    // Construtor com validação
    public Date(int d, int m, int a) {
        setDia(d);
        setMes(m);
        setAno(a);
    }

    // Métodos SET com validação
    public void setDia(int d) {
        if (d > 0 && d <= 31) this.dia = d;
    }

    public void setMes(int m) {
        if (m > 0 && m <= 12) this.mes = m;
    }

    public void setAno(int a) {
        this.ano = a;
    }

    // Métodos GET
    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAno() { return ano; }

    // Exibe no formato DD/MM/YYYY
    public void displayDate() {
        System.out.printf("%02d/%02d/%d%n", dia, mes, ano);
    }
}

// Classe de teste separada conforme o enunciado
class DateTest {
    public static void main(String[] args) {
        // Criando uma data válida
        Date data1 = new Date(29, 3, 2026);
        System.out.print("Data 1: ");
        data1.displayDate();

        // Testando os métodos SET com valores inválidos (não devem alterar o objeto)
        data1.setDia(99); 
        data1.setMes(13);
        System.out.print("Data após tentativa de valores inválidos: ");
        data1.displayDate();

        // Criando uma data e testando os GETs
        Date data2 = new Date(1, 1, 2025);
        System.out.printf("Data 2 via GETs: %02d/%02d/%d%n", 
                          data2.getDia(), data2.getMes(), data2.getAno());
    }
}