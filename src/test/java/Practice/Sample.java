package Practice;

public class Sample 
{
    public static String convertNumericToWord(String numericMonth) {
        // Define an array of month names
        String[] monthNames = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"
        };

        // Ensure the input is a valid numeric month (between 1 and 12)
        int numericValue = Integer.parseInt(numericMonth);
        if (numericValue < 1 || numericValue > 12) {
            throw new IllegalArgumentException("Invalid numeric month: " + numericMonth);
        }

        // Convert the numeric month to its corresponding word format
        return monthNames[numericValue - 1];
    }

    public static void main(String[] args) {
        // Example usage in a Selenium script
        String numericMonth = "10"; // Numeric month (e.g., "08" for August)
        String monthInWord = convertNumericToWord(numericMonth);
        System.out.println("Numeric month: " + numericMonth);
        System.out.println("Month in word: " + monthInWord);
    }
}
