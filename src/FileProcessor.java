//209625946 Tomer Berenstein
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * The FileProcessor class is responsible for processing files in a directory.
 *
 * @author Tomer Berenstein tomerbrotem@gmail.com
 * @version 19.0.2
 * @since 2023-01-17
 */
public class FileProcessor {
    /**
     * Processes all files in the specified directory.
     *
     * @param directoryPath    the path to the directory containing the files
     * @param discoverHypernym an instance of the DiscoverHypernym class to perform hypernym discovery
     */
    public void processAllFilesInDirectory(String directoryPath, DiscoverHypernym discoverHypernym) {
        // Create a File object from the provided directory path
        File directory = new File(directoryPath);

        // Check if the file object is a directory
        if (!directory.isDirectory()) {
            System.err.println(directoryPath + " is not a directory.");
            return;
        }

        // Get a list of all files in the directory
        File[] filesInDirectory = directory.listFiles();

        // If the directory has files, process each one
        if (filesInDirectory != null) {
            // Use a parallel stream for processing files concurrently
            Arrays.stream(filesInDirectory).parallel().forEach(file -> processFile(file, discoverHypernym));
        }
    }

    /**
     * Processes a single file and discovers hypernyms.
     *
     * @param fileToProcess    the file to process
     * @param discoverHypernym an instance of the DiscoverHypernym class to perform hypernym discovery
     */
    public void processFile(File fileToProcess, DiscoverHypernym discoverHypernym) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileToProcess))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(discoverHypernym.getLemma())) {
                    // Process each sentence in the line
                    Arrays.stream(line.split(" \\. ")).forEach(discoverHypernym::processLine);
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error reading file: " + fileToProcess.getPath());
            throw new RuntimeException(ioException);
        }

    }
}
