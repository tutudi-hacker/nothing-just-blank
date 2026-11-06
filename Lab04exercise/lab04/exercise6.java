package lab04;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class exercise6 {
    public static void main(String[] args) {
        
        String csvFile = "dataset.csv"; 
        analyzeCandidateData(csvFile);
    }

    public static void analyzeCandidateData(String filePath) {
        String line;
        String csvSplitBy = ",";
        int totalCandidates = 0;
        int maleCount = 0;
        int femaleCount = 0;
        int genderColumnIndex = -1;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            if ((line = br.readLine()) != null) {
                String[] headers = line.split(csvSplitBy);
                for (int i = 0; i < headers.length; i++) {
                
                    String headerName = headers[i].replace("\"", "").trim().toLowerCase();
                    if (headerName.equals("gender")) {
                        genderColumnIndex = i;
                        break;
                    }
                }
            }

            if (genderColumnIndex == -1) {
                System.out.println("Warning: 'gender' column header not explicitly found. Defaulting to column index 1.");
                genderColumnIndex = 1; 
            }
            while ((line = br.readLine()) != null) {
                String[] row = line.split(csvSplitBy, -1);
                
                if (row.length > genderColumnIndex) {
                    totalCandidates++;
                    String gender = row[genderColumnIndex].replace("\"", "").trim().toLowerCase();
                    
                    if (gender.equals("male")) {
                        maleCount++;
                    } else if (gender.equals("female")) {
                        femaleCount++;
                    }
                }
            }

            if (totalCandidates == 0) {
                System.out.println("The dataset is empty.");
                return;
            }
            double malePercentage = ((double) maleCount / totalCandidates) * 100;
            double femalePercentage = ((double) femaleCount / totalCandidates) * 100;
            System.out.println("--- Candidate Analysis Results ---");
            System.out.println("Total candidates in total : " + totalCandidates);
            System.out.printf("Percentage of male candidates   : %.2f%%\n", malePercentage);
            System.out.printf("Percentage of female candidates : %.2f%%\n", femalePercentage);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
