/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

//Fila 2 asiento 10 JoseAlvarez

package lab8p1_josealvarez;


import java.util.Scanner;

public class Lab8P1_JoseAlvarez {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        System.out.println("Bienvenido al Juego de la Vida");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Game of Life");
        System.out.println("2. Salir");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                startGame(scanner, game);
                break;
            case 2:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida. Saliendo del programa...");
        }
    }

    private static void startGame(Scanner scanner, Game game) {
        game.initializeBoard(); // Mover la inicialización del tablero aquí

        System.out.print("Ingrese el número de rondas: ");
        int rounds = scanner.nextInt();

        game.play(rounds);
    }
}

