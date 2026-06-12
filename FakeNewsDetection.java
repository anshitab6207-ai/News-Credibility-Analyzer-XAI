import java.util.Scanner;

public class FakeNewsDetectionXAI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== AI Fake News Detection =====");
        System.out.print("Enter News Headline: ");

        String news = sc.nextLine().toLowerCase();

        int score = 0;

        String[] suspiciousWords = {
                "shocking",
                "secret",
                "miracle",
                "alien",
                "conspiracy",
                "viral",
                "unbelievable",
                "breaking",
                "exclusive",
                "click here"
        };

        System.out.println("\n===== Explainable AI Analysis =====");

        for (String word : suspiciousWords) {

            if (news.contains(word)) {
                score += 15;

                System.out.println(
                        "Suspicious keyword detected: " + word
                );
            }
        }

        // Fact-check rules
        if (news.contains("sun rises on the west")) {

            score += 60;

            System.out.println(
                    "Fact Violation: The sun rises in the east."
            );
        }

        if (news.contains("humans can breathe in space")) {

            score += 60;

            System.out.println(
                    "Fact Violation: Humans cannot breathe in space."
            );
        }

        if (news.contains("earth is flat")) {

            score += 60;

            System.out.println(
                    "Fact Violation: Earth is not flat."
            );
        }

        if (news.contains("2 + 2 = 5")) {

            score += 60;

            System.out.println(
                    "Fact Violation: Mathematical statement is false."
            );
        }

        if (score > 100)
            score = 100;

        System.out.println("\nConfidence Score: " + score + "%");

        if (score >= 50) {

            System.out.println("\nPrediction: FAKE NEWS");

            System.out.println(
                    "Reason: Multiple suspicious indicators detected."
            );

        } else {

            System.out.println("\nPrediction: LIKELY REAL NEWS");

            System.out.println(
                    "Reason: No major fake-news indicators detected."
            );
        }

        sc.close();
    }
}