import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrizeDistributorTest {

    @Test
    void testPrizeDistribution() {
        // Prepare input
        String input = "100\n200\n300\nnext\nsteve\njoshua\nevans\nexit\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Redirect output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method of the PrizeDistributor class
        PrizeDistributor.main(null);

        // Expected output
        String expectedOutput = "Enter integers (enter a non-integer value to stop):\n" +
                "Enter names (enter 'exit' to stop):\n" +
                "More names than numbers, removed the last name.\n" +
                "evans: 100, 200 = 300\n" +
                "joshua: 300 = 300\n" +
                "steve: 200 = 200\n";

        // Compare actual output with expected output
        assertEquals(expectedOutput, outputStream.toString());
    }
}
