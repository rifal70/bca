package org.example.service;

import org.example.model.LoanInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Year;
import java.util.Scanner;

public class InputService {
    public LoanInput getFromConsole() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Jenis Kendaraan (Mobil/Motor): ");
        String vehicleType = sc.nextLine();

        if (!vehicleType.equalsIgnoreCase("mobil") && !vehicleType.equalsIgnoreCase("motor")) {
            throw new IllegalArgumentException("Pilihan yang tersedia hanya mobil atau motor.");
        }

        System.out.print("Kondisi (Baru/Bekas): ");
        String condition = sc.nextLine();

        if (!condition.equalsIgnoreCase("baru") && !condition.equalsIgnoreCase("bekas")) {
            throw new IllegalArgumentException("Pilihan yang tersedia hanya baru atau bekas.");
        }

        System.out.print("Tahun Kendaraan: ");
        int year = Integer.parseInt(sc.nextLine());

        if (year < 1000 || year > 9999) {
            throw new IllegalArgumentException("Tahun Kendaraan wajib 4 digit angka.");
        }

        if (condition.equalsIgnoreCase("baru") && year < Year.now().getValue() - 1) {
            throw new IllegalArgumentException("Kendaraan baru wajib tahun ini atau tahun lalu.");
        }

        System.out.print("Jumlah Pinjaman: ");
        long loanAmount = Long.parseLong(sc.nextLine());

        if (loanAmount > 1_000_000_000L) {
            throw new IllegalArgumentException("Jumlah Pinjaman melebihi batas ketentuan.");
        }

        System.out.print("Tenor (1-6 tahun): ");
        int tenor = Integer.parseInt(sc.nextLine());

        if (tenor < 1 || tenor > 6) {
            throw new IllegalArgumentException("Tenor tidak bisa kurang dari 1 tahun dan lebih dari 6 tahun.");
        }

        System.out.print("Jumlah DP: ");
        long downPayment = Long.parseLong(sc.nextLine());

        return new LoanInput(vehicleType, condition, year, loanAmount, tenor, downPayment);
    }

    public LoanInput getFromFile(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            String vehicleType = sc.nextLine();
            String condition = sc.nextLine();
            int year = Integer.parseInt(sc.nextLine());
            long loanAmount = Long.parseLong(sc.nextLine());
            int tenor = Integer.parseInt(sc.nextLine());
            long downPayment = Long.parseLong(sc.nextLine());

            if (!vehicleType.equalsIgnoreCase("mobil") && !vehicleType.equalsIgnoreCase("motor")) {
                throw new IllegalArgumentException("Pilihan yang tersedia hanya mobil atau motor.");
            }

            if (!condition.equalsIgnoreCase("baru") && !condition.equalsIgnoreCase("bekas")) {
                throw new IllegalArgumentException("Pilihan yang tersedia hanya baru atau bekas.");
            }

            if (year < 1000 || year > 9999) {
                throw new IllegalArgumentException("Tahun Kendaraan wajib 4 digit angka.");
            }

            if (condition.equalsIgnoreCase("baru") && year < Year.now().getValue() - 1) {
                throw new IllegalArgumentException("Kendaraan baru wajib tahun ini atau tahun lalu.");
            }

            if (loanAmount > 1_000_000_000L) {
                throw new IllegalArgumentException("Jumlah Pinjaman melebihi batas ketentuan.");
            }

            if (tenor < 1 || tenor > 6) {
                throw new IllegalArgumentException("Tenor tidak bisa kurang dari 1 tahun dan lebih dari 6 tahun.");
            }

            return new LoanInput(vehicleType, condition, year, loanAmount, tenor, downPayment);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filename);
        }
    }
}
