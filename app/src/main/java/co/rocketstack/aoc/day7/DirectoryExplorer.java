package co.rocketstack.aoc.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DirectoryExplorer {
    private Scanner scanner;
    private AOCFile rootDirectory;
    private AOCFile currentDirectory;

    public DirectoryExplorer(String filepath) throws FileNotFoundException {
        rootDirectory = AOCFile.createDirectory("/");
        currentDirectory = rootDirectory;
        scanner = new Scanner(new File(filepath));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] details = line.split(" ");
            switch (details[0]) {
                case "$":
                    switch (details[1]) {
                        case "cd":
                            if (details[2].equalsIgnoreCase("..")) {
                                currentDirectory = currentDirectory.getParentDirectory();
                            } else if (details[2].equalsIgnoreCase("/")) {
                                currentDirectory = rootDirectory;
                            } else {
                                currentDirectory = currentDirectory.getOrCreateSubSirectory(details[2]);
                            }
                            break;
                        default:
                            // Command must be ls, carry on reading the details
                            break;
                    }
                    break;
                case "dir":
                    break; // We can ignore directories, we'll create them if we navigate to them
                default:
                    currentDirectory.addFile(details[0], details[1]);
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return rootDirectory.toString();
    }

    public List<AOCFile> getDirsWithMaxSize(int maxSize) {
        return rootDirectory.getFilesWithMaxSize(maxSize);
    }

    public int getTotalOfDirsWithMaxSize(int maxSize) {
        return getDirsWithMaxSize(maxSize).stream().map(AOCFile::getDirectorySize).mapToInt(Integer::intValue).sum();
    }

    public AOCFile getSmallestFileBiggerThan(int size) {
        return getDirsWithMaxSize(Integer.MAX_VALUE).stream()
                .sorted(Comparator.comparingInt(AOCFile::getDirectorySize))
                .filter(dir -> dir.getDirectorySize() > size).findFirst().get();
    }

}
