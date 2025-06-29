package org.example.service;

import org.example.model.LoanInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputService {
    public LoanInput getFromConsole() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Jenis Kendaraan (Mobil/Motor): ");
        String vehicleType = sc.nextLine();

        System.out.print("Kondisi (Baru/Bekas): ");
        String condition = sc.nextLine();

        System.out.print("Tahun Kendaraan: ");
        int year = Integer.parseInt(sc.nextLine());

        System.out.print("Jumlah Pinjaman: ");
        long loanAmount = Long.parseLong(sc.nextLine());

        System.out.print("Tenor (1-6 tahun): ");
        int tenor = Integer.parseInt(sc.nextLine());

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

            return new LoanInput(vehicleType, condition, year, loanAmount, tenor, downPayment);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filename);
        }
    }
}
