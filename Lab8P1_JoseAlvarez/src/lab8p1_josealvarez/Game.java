/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8p1_josealvarez;

/**
 *
 * @author jkalvarezb
 */
import java.util.ArrayList;
import java.util.Random;

public class Game {
    public int[][] generacionact;
    public int[][] generaciondesp;
    public int rondasporjugar;

    public Game() {
        this.generacionact = new int[10][10];
        this.generaciondesp = new int[10][10];
        this.rondasporjugar = 0;
    }

public void initializeBoard() {
    Random random = new Random();
    ArrayList<String> initialLiveCellCoordinates = new ArrayList<>();


    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (i == 0 || i == 9 || j == 0 || j == 9) {
                generacionact[i][j] = 0;
            } else {
                int randomValue = random.nextInt(2);
                generacionact[i][j] = randomValue;

                if (randomValue == 1) {
                    initialLiveCellCoordinates.add(i + ":" + j);
                }
            }
        }
    }

    System.out.println("Coordenadas del tablero inicial: " + initialLiveCellCoordinates);
    print(); 
}


    public void play(int rounds) {
        this.rondasporjugar = rounds;

        for (int round = 1; round <= rounds; round++) {
            nextGen();
            printCoordinates();
            print();
        }
    }

    public void nextGen() {
        int[][] newLiveCellCoordinates = new int[10][10];

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);

                if (generacionact[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    generaciondesp[i][j] = 0;
                } else if (generacionact[i][j] == 0 && liveNeighbors == 3) {
                    generaciondesp[i][j] = 1; 
                    newLiveCellCoordinates[i][j] = 1;
                } else {
                    generaciondesp[i][j] = generacionact[i][j];
                    newLiveCellCoordinates[i][j] = generacionact[i][j];
                }
            }
        }

        generacionact = newLiveCellCoordinates;
    }

    private int countLiveNeighbors(int x, int y) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                count += generacionact[x + i][y + j];
            }
        }

        count -= generacionact[x][y]; 
        return count;
    }

    public void print() {
        System.out.println("Generación Actual:");
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                System.out.print(generacionact[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printCoordinates() {
        ArrayList<String> liveCellCoordinates = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (generacionact[i][j] == 1) {
                    liveCellCoordinates.add(i + ":" + j);
                }
            }
        }

        System.out.println("Coordenadas de celdas vivas: " + liveCellCoordinates);
    }
}