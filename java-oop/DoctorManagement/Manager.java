package DoctorManagement;

import java.util.ArrayList;

import javax.print.Doc;

public class Manager {
    public static void addDoctor(ArrayList<Doctor> list) {
        System.out.println("--------- Add Doctor ----------");
        System.out.print("Enter Code: ");

        String code = Valid.inputString();
        if (!Valid.codeExist(list, code)) {
            System.err.println("Code exist.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = Valid.inputString();
        System.out.print("Enter Specilization: ");
        String specilization = Valid.inputString();
        System.out.print("Enter Availability: ");
        String availability = Valid.inputString();

        if (!Valid.checkDuplicate(list, code, name, specialization, availability))  {
            System.err.println("Duplicate.");
            return;
        }
        list.add(new Doctor(code, name, specialization, availability));
        System.err.println("Doctor added!");
    }

    public static void updateDoctor(ArrayList<Doctor> list) {
        System.out.print("Enter Code: ");
        String code = Valid.inputString();

        if (Valid.codeExist(list, code)) {
            System.err.println("Doctor not found!");
            return;
        }

        System.out.print("Enter Code: ");
        String codeUpdate = Valid.inputString();
        Doctor doctor = getDoctorByCode(ld, code);
        System.out.print("Enter Name: ");
        String name = Valid.inputString();
        System.out.print("Enter Specialization: ");
        String specialization = Valid.inputString();
        System.out.print("Enter Availability: ");
        int availability = Valid.inputInt();

        if (!Valid.checkChangeInfo(doctor, code, name, specialization, availability)) {
            System.err.println("No update!");
            return;
        }

        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Doctor updated!");
    }

    public static void deleteDoctor(ArrayList<Doctor> list) {
        System.out.print("Enter Code: ");
        String code = Valid.inputString();
        Doctor doctor = getDoctorByCode(list, code);

        if (doctor = null) {
            System.err.println("Doctor not found!");
            return;
        } else {
            list.remove(doctor);
        }
        System.err.println("Doctor deleted!");
    }

    public static void searchDoctor(ArrayList<Doctor> list) {
        System.out.print("Enter Name: ");
        String nameSearch = Valid.inputString();        
        ArrayList<Doctor> listFoundByName = listFoundByName(list, nameSearch);

        if (listFoundByName.isEmpty()) {
            System.err.println("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor: listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }
        }
    }

    public static Doctor getDoctorByCode(ArrayList<Doctor> list, String code) {
        for (Doctor doctor: list) {
            if (doctor.getCode().equalsIgnoreCase(code))    return doctor;
        }
        return null;
    }

    public static ArrayList<Doctor> listFoundByName(ArrayList<Doctor> list, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor: list) {
            if (doctor.getName().contains(name))    listFoundByName.add(doctor);
        }
        return listFoundByName;
    }
}