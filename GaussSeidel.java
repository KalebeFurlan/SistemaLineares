import java.util.Scanner;
public class GaussSeidel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tamanho da matriz (n): ");
        int n = scanner.nextInt();
        double[][] matriz = new double[n][n];
        double[] b = new double[n];
        System.out.println("Digite os valores da matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = scanner.nextDouble();
            }
            System.out.print("Digite o valor de b[" + i + "]: ");
            b[i] = scanner.nextDouble();
        }
        System.out.print("Digite o valor de epsilon: ");
        double epsilon = scanner.nextDouble();
        System.out.println("Digite os valores de x^(0):");
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o valor de x[" + i + "]: ");
            x[i] = scanner.nextDouble();
        }
        scanner.close();
        int iteracoes = gaussSeidel(matriz, b, x, epsilon);
        System.out.println("\nSolução encontrada:");
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
        System.out.println("Número de iterações: " + iteracoes);
    }
    private static int gaussSeidel(double[][] matriz, double[] b, double[] x, double epsilon) {
        int n = matriz.length;
        double[] xAnterior = new double[n];
        int iteracoes = 0;
        boolean criterioAtendido = false;
        while (!criterioAtendido) {
            for (int i = 0; i < n; i++) {
                xAnterior[i] = x[i];
            }
            for (int i = 0; i < n; i++) {
                double soma = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        soma += matriz[i][j] * x[j];
                    }
                }
                x[i] = (b[i] - soma) / matriz[i][i];
            }
            double maxDiferenca = 0.0;
            for (int i = 0; i < n; i++) {
                double diferenca = Math.abs(x[i] - xAnterior[i]);
                if (diferenca > maxDiferenca) {
                    maxDiferenca = diferenca;
                }
            }
            if (maxDiferenca <= epsilon) {
                criterioAtendido = true;
            }
            iteracoes++;
        }
        return iteracoes;
    }
}
