import java.util.*;

public class PrizeDistributor {
    private static Map<String, ArrayList<Integer>> winnerPrizes; // Declare winnerPrizes as a class-level variable

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> prizeAmounts = new ArrayList<>();
        ArrayList<String> winners = new ArrayList<>();

        // Input prize amounts
        System.out.println("\nWELCOME!\nEnter this week's prizes' values (comma-separated, e.g., 100,200,300):");
        String prizeValuesInput = scanner.nextLine();
        String[] prizeValues = prizeValuesInput.split(",");
        for (String value : prizeValues) {
            try {
                int amount = Integer.parseInt(value.trim());
                prizeAmounts.add(amount);
            } catch (NumberFormatException e) {
                // Skip non-integer values
            }
        }

        // Input winners' names
        System.out.println("Enter this week's winners' names (comma-separated, e.g., Steve,John,Joshua,(double entries will be treated as one entry)):");
        String winnersInput = scanner.nextLine();
        String[] winnerNames = winnersInput.split(",");
        for (String name : winnerNames) {
            winners.add(name.trim());
        }

        // Check if there are more winners than prizes
        if (winners.size() > prizeAmounts.size()) {
            winners.subList(prizeAmounts.size(), winners.size()).clear(); // Remove extra winners
            System.out.println("Detected more winners than prizes, removing the extra winners.");
        }

        // Sort prize amounts in descending order
        Collections.sort(prizeAmounts, Collections.reverseOrder());

        // Map prize amounts to winners in descending order
        winnerPrizes = new HashMap<>();
        for (int i = 0; i < Math.min(winners.size(), prizeAmounts.size()); i++) {
            String winner = winners.get(i);
            if (!winnerPrizes.containsKey(winner)) {
                winnerPrizes.put(winner, new ArrayList<>());
            }
            winnerPrizes.get(winner).add(prizeAmounts.get(i));
        }

        // Distribute remaining prizes
        for (int i = winners.size(); i < prizeAmounts.size(); i++) {
            String winnerWithMinPrize = null;
            int minPrizeValue = Integer.MAX_VALUE;
            for (Map.Entry<String, ArrayList<Integer>> entry : winnerPrizes.entrySet()) {
                int currentPrizeValue = sum(entry.getValue());
                if (currentPrizeValue < minPrizeValue) {
                    winnerWithMinPrize = entry.getKey();
                    minPrizeValue = currentPrizeValue;
                }
            }
            winnerPrizes.get(winnerWithMinPrize).add(prizeAmounts.get(i));
        }
        System.out.println("\nCongratulations!!! Here are the prize winners :)");

        // Print the prize distribution
        for (Map.Entry<String, ArrayList<Integer>> entry : winnerPrizes.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            ArrayList<Integer> prizes = entry.getValue();
            for (int i = 0; i < prizes.size(); i++) {
                System.out.print(prizes.get(i));
                if (i < prizes.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" = " + sum(prizes));
        }

        // Close the scanner
        scanner.close();
    }

    // Method to calculate the sum of elements in an ArrayList
    private static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    // Getter method to access the winnerPrizes map for testing purposes
    public static Map<String, ArrayList<Integer>> getWinnerPrizes() {
        return winnerPrizes;
    }
}










