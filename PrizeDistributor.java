import java.util.*;

public class PrizeDistributor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> prizeAmounts = new ArrayList<>();
        ArrayList<String> winners = new ArrayList<>();

        // Input prize amounts
        System.out.println("Enter prize amounts  (when finished type any name to proceed to entering winners names):");
        while (scanner.hasNextInt()) {
            int amount = scanner.nextInt();
            prizeAmounts.add(amount);
        }

        // Input winners' names
        scanner.nextLine(); // Consume newline character
        System.out.println("You have now started entering winners' names (type 'exit' to stop):");
        while (true) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            winners.add(name);
        }

        // Check if there are more winners than prizes
        if (winners.size() > prizeAmounts.size()) {
            winners.remove(winners.size() - 1);
            System.out.println("Detected more winners than prizes, removing the last winner.");
        }

        // Sort prize amounts in descending order
        Collections.sort(prizeAmounts, Collections.reverseOrder());

        // Map prize amounts to winners in descending order
        Map<String, ArrayList<Integer>> winnerPrizes = new HashMap<>();
        for (int i = 0; i < Math.min(winners.size(), prizeAmounts.size()); i++) {
            winnerPrizes.put(winners.get(i), new ArrayList<>(Collections.singletonList(prizeAmounts.get(i))));
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
}





