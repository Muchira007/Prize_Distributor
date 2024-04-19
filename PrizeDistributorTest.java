import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.ArrayList;

public class PrizeDistributorTest {

    @Test
    public void testNumberOfWinners() {
        // Set up your input data
        String input = "200,300,500,1000,600\nSteve,John,Joshua,Evans,Ernest\nexit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the main method
        PrizeDistributor.main(new String[0]);

        // Verify that the correct number of winners are selected
        Map<String, ArrayList<Integer>> winnerPrizes = PrizeDistributor.getWinnerPrizes();
        assertEquals(5, winnerPrizes.size());
    }

    @Test
    public void testEachWinnerReceivesPrize() {
        // Set up your input data
        String input = "200,300,500,1000,600\nSteve,John,Joshua,Evans,Ernest\nexit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the main method
        PrizeDistributor.main(new String[0]);

        // Verify that each winner receives at least one prize
        Map<String, ArrayList<Integer>> winnerPrizes = PrizeDistributor.getWinnerPrizes();
        for (ArrayList<Integer> prizes : winnerPrizes.values()) {
            assertFalse(prizes.isEmpty());
        }
    }

    @Test
    public void testTotalSumOfPrizes() {
        // Set up your input data
        String input = "200,300,500,1000,600\nSteve,John,Joshua,Evans,Ernest\nexit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the main method
        PrizeDistributor.main(new String[0]);

        // Verify that the total sum of prizes distributed is equal
        // to the total sum of prize amounts inputted
        Map<String, ArrayList<Integer>> winnerPrizes = PrizeDistributor.getWinnerPrizes();
        int totalSum = 0;
        for (ArrayList<Integer> prizes : winnerPrizes.values()) {
            for (int prize : prizes) {
                totalSum += prize;
            }
        }

        assertEquals(2600, totalSum);
    }
}
