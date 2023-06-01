import java.util.Scanner;
public class Gauss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tamanho da matriz (n): ");
        int n = scanner.nextInt();
        double[][] matriz = new double[n][n + 1];
        System.out.println("Digite os valores da matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                matriz[i][j] = scanner.nextDouble();
            }
        }
        System.out.println("\nMatriz original:");
        exibirMatriz(matriz);
        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                double fator = matriz[i][k] / matriz[k][k];
                for (int j = k + 1; j <= n; j++) {
                    matriz[i][j] -= matriz[k][j] * fator;
                }
            }
            System.out.println("\nMatriz para k = " + k + ":");
            exibirMatriz(matriz);
        }
        double[] solucao = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            solucao[i] = matriz[i][n];
            for (int j = i + 1; j < n; j++) {
                solucao[i] -= matriz[i][j] * solucao[j];
            }
            solucao[i] /= matriz[i][i];
        }
        System.out.println("\nSolução:");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + solucao[i]);
        }
        scanner.close();
    }
    private static void exibirMatriz(double[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
