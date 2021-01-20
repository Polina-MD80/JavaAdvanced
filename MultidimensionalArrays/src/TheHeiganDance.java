import java.util.Scanner;

public
class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double bossPoins = 3000000.0;
        int playerPoints = 18500;

        int playerRow = 7;
        int playerCol = 7;

        String lastSpell = "";
        boolean activeCloud = false;

        double damage = Double.parseDouble(scanner.nextLine());

        while (playerPoints > 0 && bossPoins > 0) {
            bossPoins -= damage;

            if (activeCloud) {
                playerPoints -= 3500;
                activeCloud = false;

                if (playerPoints < 0) {
                    break;
                }
            }

            if (bossPoins < 0) {
                break;
            }

            String[] tokens = scanner.nextLine().split("\\s+");

            String spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            boolean[][] chamber = new boolean[15][15];
            for (int i = row - 1; i <= row + 1; i++) {
                if (i >= 0 && i < chamber.length) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (j >= 0 && j < chamber[row].length) {
                            chamber[i][j] = true;
                        }
                    }
                }
            }

            if (chamber[playerRow][playerCol]) {
                if (rowIsInChamber (chamber, playerRow - 1) && !chamber[playerRow - 1][playerCol]) {
                    playerRow--;
                } else if (colonIsInChamber (chamber, playerCol + 1) && !chamber[playerRow][playerCol + 1]) {
                    playerCol++;
                } else if (rowIsInChamber (chamber, playerRow + 1) && !chamber[playerRow + 1][playerCol]) {
                    playerRow++;
                } else if (colonIsInChamber (chamber, playerCol - 1) && !chamber[playerRow][playerCol - 1]) {
                    playerCol--;
                }

                if (chamber[playerRow][playerCol]) {
                    switch (spell) {
                        case "Cloud":
                            playerPoints -= 3500;
                            activeCloud = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerPoints -= 6000;
                            lastSpell = spell;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid spell: " + spell);
                    }
                }
            }
        }

        if (bossPoins > 0) {
            System.out.printf("Heigan: %.2f%n", bossPoins);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerPoints > 0) {
            System.out.printf("Player: %d%n", playerPoints);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }

        System.out.println("Final position: " + playerRow + ", " + playerCol);
    }

    private static boolean rowIsInChamber (boolean[][] chamber, int playerRow) {
        return playerRow >= 0 && playerRow < chamber[playerRow].length;
    }

    private static boolean colonIsInChamber (boolean[][] chamber, int playerCol) {
        return playerCol >= 0 && playerCol < chamber.length;
    }
}
