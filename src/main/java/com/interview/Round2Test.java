package com.interview;

import java.awt.color.ProfileDataException;
import java.io.File;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Round2Test implements Runnable {

    public static void main(String[] args) {
        File initialFolder = new File("D:/testdir");
        removeFolderIfEmpty(initialFolder);
        System.out.println("Finished");
    }

    public static void removeFolderIfEmpty(File folder) {
        File[] files = listFiles(folder);
        for (int i = 0; i < files.length; i++) {
            File nestedFile = files[i];
            boolean isDirectory = nestedFile.isDirectory();
            if (isDirectory) {
                removeFolderIfEmpty(nestedFile);
                if (listFiles(nestedFile).length == 0) {
                    nestedFile.delete();
                }
            }
        }
    }

    static File[] listFiles(File file) {
        return Optional.ofNullable(file).map(File::listFiles).orElse(new File[0]);
    }

    /// there are many

    private static final Map<Integer, Boolean> seatNumbers = new ConcurrentHashMap<>();

    // 1 - 100

    // show -->
    // 1, 2, 3

    /**
     * @param seatNum
     * @return
     *
     * shows
     * id       movie       ...
     *
     * show_seats
     * (show_id      seat_number)
     */
    public boolean bookSeat(int seatNum) {
        // addSeatNumber(seatNum);
        // many more steps --> 5 seconds
        return false;
    }


    @Override
    public void run() {

    }
}
