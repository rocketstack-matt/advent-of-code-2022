package co.rocketstack.aoc.day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AOCFile {
    public enum TYPE {
        FILE,
        DIRECTORY
    }

    private TYPE type;
    private String name;
    private int size;
    private AOCFile parentDirectory;
    private int depth;
    private Map<String, AOCFile> subDirectories;
    private List<AOCFile> files;

    private AOCFile(TYPE type, String name, int size, int depth) {
        this.type = type;
        this.name = name;
        this.size = size;
        subDirectories = new HashMap<>();
        files = new ArrayList<>();
        this.depth = depth;
    }

    private AOCFile(TYPE type, String name, int size, AOCFile parentDirectory) {
        this(type, name, size, parentDirectory.depth + 1);
        this.parentDirectory = parentDirectory;
    }

    public AOCFile addFile(String size, String name) {
        AOCFile file = new AOCFile(TYPE.FILE, name, Integer.parseInt(size), this);
        files.add(file);
        return file;
    }

    public AOCFile addDirectory(String name) {
        AOCFile directory = new AOCFile(TYPE.DIRECTORY, name, 0, this);
        subDirectories.put(name, directory);
        return directory;
    }

    public static AOCFile createDirectory(String name) {
        return new AOCFile(TYPE.DIRECTORY, name, 0, 0);
    }

    public AOCFile getParentDirectory() {
        return this.parentDirectory;
    }

    public String getName() {
        return name;
    }

    public AOCFile getOrCreateSubSirectory(String name) {
        if (subDirectories.get(name) != null)
            return subDirectories.get(name);
        return addDirectory(name);
    }

    public int getDirectorySize() {
        int size = 0;
        for (AOCFile file : files) {
            size += file.size;
        }
        for (AOCFile directory : subDirectories.values()) {
            size += directory.getDirectorySize();
        }
        return size;
    }

    @Override
    public String toString() {
        if (type == TYPE.DIRECTORY) {
            StringBuilder builder = new StringBuilder();
            builder.append("- " + name + " (dir, size=" + getDirectorySize() + ")\n");
            for (AOCFile file : subDirectories.values()) {
                for (int i = 0; i < depth; i++) {
                    builder.append("  ");
                }
                builder.append("  " + file.toString());
            }
            for (AOCFile file : files) {
                for (int i = 0; i < depth; i++) {
                    builder.append("  ");
                }
                builder.append("  " + file.toString());
            }
            return builder.toString();
        } else {
            return "- " + name + " (file, size=" + size + ")\n";
        }
    }

    public List<AOCFile> getFilesWithMaxSize(int maxSize) {
        List<AOCFile> dirsToReturn = new ArrayList<>();
        for (AOCFile dir : subDirectories.values()) {
            dirsToReturn.addAll(dir.getFilesWithMaxSize(maxSize));
        }
        if (getDirectorySize() <= maxSize)
            dirsToReturn.add(this);
        return dirsToReturn;
    }

}
