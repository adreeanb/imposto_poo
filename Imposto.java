package projeto_imposto;

import java.util.Scanner;

public class Imposto{

    public static double calcularImpostoSalario(double salarioAnual) {
        double salarioMensal = salarioAnual / 12;
        if (salarioMensal < 3000) {
            return 0;
        } else if (salarioMensal >= 3000 && salarioMensal < 5000) {
            return salarioAnual * 0.10;
        } else {
            return salarioAnual * 0.20;
        }
    }

    public static double calcularImpostoServicos(double rendaServicos) {
        return rendaServicos * 0.15;
    }

    public static double calcularImpostoGanhoCapital(double ganhoCapital) {
        return ganhoCapital * 0.20;
    }

    public static double calcularImpostoBruto(double salarioAnual, double rendaServicos, double ganhoCapital) {
        double impostoSalario = calcularImpostoSalario(salarioAnual);
        double impostoServicos = calcularImpostoServicos(rendaServicos);
        double impostoGanhoCapital = calcularImpostoGanhoCapital(ganhoCapital);
        return impostoSalario + impostoServicos + impostoGanhoCapital;
    }

    public static double calcularAbatimento(double impostoBruto, double gastosMedicosEducacionais) {
        double limiteAbatimento = impostoBruto * 0.30;
        return Math.min(gastosMedicosEducacionais, limiteAbatimento);
    }

    public static void calcularImpostoRenda(double salarioAnual, double rendaServicos, double ganhoCapital, double gastosMedicosEducacionais) {
        double impostoBruto = calcularImpostoBruto(salarioAnual, rendaServicos, ganhoCapital);
        double abatimento = calcularAbatimento(impostoBruto, gastosMedicosEducacionais);
        double impostoLiquido = impostoBruto - abatimento;

        System.out.printf("Relatório de Imposto de Renda:\n");
        System.out.printf("Imposto bruto devido: R$ %.2f\n", impostoBruto);
        System.out.printf("Abatimento permitido: R$ %.2f\n", abatimento);
        System.out.printf("Imposto líquido a pagar: R$ %.2f\n", impostoLiquido);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a renda anual com salário: R$ ");
        double salarioAnual = scanner.nextDouble();

        System.out.print("Informe a renda anual com prestação de serviços: R$ ");
        double rendaServicos = scanner.nextDouble();

        System.out.print("Informe o ganho de capital anual: R$ ");
        double ganhoCapital = scanner.nextDouble();

        System.out.print("Informe os gastos médicos e educacionais anuais: R$ ");
        double gastosMedicosEducacionais = scanner.nextDouble();

        calcularImpostoRenda(salarioAnual, rendaServicos, ganhoCapital, gastosMedicosEducacionais);

        scanner.close();
    }
}
