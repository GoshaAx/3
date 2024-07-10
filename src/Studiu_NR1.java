
import java.io.*;
import java.util.*;


class Student implements Serializable {
    protected int id;
    protected String nume;
    protected String prenume;
    protected String patronimic;
    protected String dataNasterii;
    protected String adresa;
    protected String telefon;
    protected String specialitate;
    protected int an;
    protected String grupa;

    public void setId(int id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setPatronimic(String patronimic) {
        this.patronimic = patronimic;
    }

    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setSpecialitate(String specialitate) {
        this.specialitate = specialitate;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String toString() {
        return "ID: " + id + "\n" +
                "Nume: " + nume + "\n" +
                "Prenume: " + prenume + "\n" +
                "Patronimic: " + patronimic + "\n" +
                "Data Nasterii: " + dataNasterii + "\n" +
                "Adresa: " + adresa + "\n" +
                "Telefon: " + telefon + "\n" +
                "Specialitate: " + specialitate + "\n" +
                "An: " + an + "\n" +
                "Grupa: " + grupa + "\n";
    }
}

public class Studiu_NR1 {


    public static Student[] studenti = new Student[1000];
    public static final String FILENAME = "Students.txt";
    private static int cnt = 0;

    public static void incarcaEleviDinFisier() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            Student elev;
            while ((elev = (Student) inputStream.readObject())!=null) {

                studenti[cnt] = elev;
                cnt++;
            }
        } catch (EOFException e) {
            System.out.println("Datele au fost incarcate cu succes.");
        } catch (ClassNotFoundException e) {
            System.out.println("Eroare la citirea din fișierul cu studenți: ");
        }
        catch (IOException e){
            System.out.println("De CE NU MERGE");
        }
    }


    public static void adaugaStudent(Scanner in) {
        if (cnt >= studenti.length) {
            System.out.println("\u001B[37mNumărul maxim de studenți a fost atins!");
            return;
        }
        Student newStudent = new Student();
try {

    System.out.println("\u001B[35mIntroduceți datele noului student:");
    System.out.print("ID: ");
    newStudent.setId(in.nextInt());
    in.nextLine();
    System.out.print("Nume: ");
    newStudent.setNume(in.nextLine());
    System.out.print("Prenume: ");
    newStudent.setPrenume(in.nextLine());
    System.out.print("Patronimic: ");
    newStudent.setPatronimic(in.nextLine());
    System.out.print("Data nașterii (zi luna an): ");
    newStudent.setDataNasterii(in.nextLine());
    System.out.print("Adresa: ");
    newStudent.setAdresa(in.nextLine());
    System.out.print("Telefon: ");
    newStudent.setTelefon(in.nextLine());
    System.out.print("Specialitate (Web Developer, Programare, Baze de Date, Contabilitate, Secretariat): ");
    newStudent.setSpecialitate(in.nextLine());
    System.out.print("An: ");
    newStudent.setAn(in.nextInt());
    in.nextLine();
    System.out.print("Grupa: ");
    newStudent.setGrupa(in.nextLine());

    studenti[cnt] = newStudent;
    cnt++;
    System.out.println("Student adăugat cu succes!");

}catch(InputMismatchException e) {
    System.out.println("Datele introduse de la tastatura nu coincid cu cele cerute");
}

    }


    public static void AfisareStudenti() {
        if (cnt==0) {
            System.out.println("Nu există studenți înregistrati.");
            return;
        }

        System.out.println("\u001B[32mLista studenților:");
        for (int i = 0; i < cnt; i++) {
            System.out.println(studenti[i]);
        }
    }




public static void AfisareDupaNume(Student []studenti){
    System.out.println("\u001B[32m");
        for(int i=0;i<cnt-1;i++)
            for(int j=i+1;j<cnt;j++)
        if(studenti[i].nume.compareTo(studenti[j].nume)>0) {
            Student aux;
            aux=studenti[j];
            studenti[j]=studenti[i];
            studenti[i]=aux;

        }

        for(int i=0;i<cnt;i++)
            System.out.println(studenti[i]);
}



public static void AfisareDupaSpecialitate(Scanner in){
        int nr=0;
    System.out.println("\u001B[0m Ce specialitate vă interesează?");
        String spec=in.nextLine();

        for(int i=0;i<cnt;i++){
            if(studenti[i].specialitate.equalsIgnoreCase(spec))
            {System.out.println(studenti[i]);
            nr++;}
        }
    System.out.println("Grupa are "+nr+" studenti.");
}

public static void AfisarePentruFiecareCurs() {
    String spec[] = new String[101];
    for (int i = 0; i < 101; i++)
        spec[i] = "nimic";

    int k = 0;

    for (int i = 0; i < cnt; i++) {
        String spec_curenta = studenti[i].specialitate;
        boolean gasit = false;
        for (int j = 0; j < k; j++) {
            if (spec[j].equalsIgnoreCase(spec_curenta)) {
                gasit = true;
                break;
            }
        }
        if (!gasit) {
            spec[k] = spec_curenta;
            k++;
        }
    }


    for (int i = 0; i < k; i++) {
        System.out.println("\u001B[33mSTUDENTII PENTRU SPECIALITATEA: " + spec[i]);
        for (int j = 0; j < cnt; j++) {
            System.out.println("\u001B[31m");
            if (studenti[j].specialitate.equalsIgnoreCase(spec[i])) {
                System.out.println(studenti[j]);
            }
        }
        System.out.println("---------------------------------");
    }
}

public static void AfisareDupaGrupa() {

    String spec[] = new String[101];
    for (int i = 0; i < 101; i++)
        spec[i] = "nimic";

    int k = 0;

    for (int i = 0; i < cnt; i++) {
        String grupa_curenta = studenti[i].grupa;
        boolean gasit = false;
        for (int j = 0; j < k; j++) {
            if (spec[j].equalsIgnoreCase(grupa_curenta)) {
                gasit = true;
                break;
            }
        }
        if (!gasit) {
            spec[k] = grupa_curenta;
            k++;
        }

    }

    for (int i = 0; i < k; i++) {
        System.out.println("\u001B[33mSTUDENTII PENTRU GRUPA: " + spec[i]);
        for (int j = 0; j < cnt; j++) {
            System.out.println("\u001B[31m");
            if (studenti[j].grupa.equalsIgnoreCase(spec[i])) {
                System.out.println(studenti[j]);
            }
        }
        System.out.println("---------------------------------");
    }
}






    static void salveazaStudentiInFisier() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            for (int i = 0; i < cnt; i++) {
                outputStream.writeObject(studenti[i]);
            }

            System.out.println("\u001B[36mDatele au fost salvate cu succes în fișier.");
        } catch (IOException e) {
            System.out.println("\u001B[31mEroare la salvarea în fișierul cu studenți: ");
        }
    }






        public static void main(String[] args) {
        incarcaEleviDinFisier();
        Scanner in = new Scanner(System.in);


            String RESET = "\u001B[0m";



        while (true) {
            System.out.println(RESET);
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║                   Meniu                      ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║ 1. Adăugare student                          ║");
            System.out.println("║ 2. Afișare studenți                          ║");
            System.out.println("║ 3. Afisare dupa nume                         ║");
            System.out.println("║ 4. Afisarea elevilor  după specialitate      ║");
            System.out.println("║ 5. Afisare dupa o specialitate anumita       ║");
            System.out.println("║ 6. Afisare după grupă                        ║");
            System.out.println("║ 0. Ieșire                                    ║");
            System.out.println("╚══════════════════════════════════════════════╝");


            int x = in.nextInt();
            in.nextLine();

            switch (x) {
                case 1:
                    adaugaStudent(in);
                    break;
                case 2:
                    AfisareStudenti();
                    break;
                case 3:
                    AfisareDupaNume(studenti);
                    break;
                case 4:
                    AfisarePentruFiecareCurs();
                    break;
                case 5:
                    AfisareDupaSpecialitate(in);
                    break;
                case 6:
                    AfisareDupaGrupa();
                    break;
                case 0:
                    salveazaStudentiInFisier();
                    return;
                default:
                    System.out.println("Opțiune invalidă!");

            }
        }
    }

}