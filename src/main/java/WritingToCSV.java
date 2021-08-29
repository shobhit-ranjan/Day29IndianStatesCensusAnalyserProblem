import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

public class WritingToCSV {
	public static void main(String args[]) throws Exception {

		CSVWriter writer = new CSVWriter(new FileWriter("src\\resoucesforcsv\\csvfileforreading.csv"));

		String line1[] = { "id", "State name", "TEMP" };
		String line2[] = { "1", "Himachal Pradesh", "25" };
		String line3[] = { "2", "Uttar Pradesh", "45" };
		String line4[] = { "3", "West Bengal", "30" };
		String line5[] = { "4", "Karnataka", "63" };

		writer.writeNext(line1);
		writer.writeNext(line2);
		writer.writeNext(line3);
		writer.writeNext(line4);

		writer.flush();
		System.out.println("Data entered");

		CSVReader dataReader = new CSVReader(new FileReader("src\\resoucesforcsv\\csvfileforreading.csv"));

		// System.out.println(dataReader);

		try {

			FileReader filereader = new FileReader("src\\resoucesforcsv\\csvfileforreading.csv");

			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			List<String[]> allData = csvReader.readAll();

			// print Data
			for (String[] row : allData) {
				for (String cell : row) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
