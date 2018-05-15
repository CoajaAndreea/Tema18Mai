import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

public class Agenda {
    static final int EXIT=6;
    static final int MAX=100;
    static int CONTOR=0;
    static String[] agendaPersoaneContact=new String[MAX];

    public static void main(String[] args) {

        Meniu();
        int optiune=SkeletonJava.readIntConsole("Optiunea dumneavoastra este: ");

        while (optiune>=0)
        {
            if (optiune>=EXIT)
                System.out.println("Optiune inexistenta");

            switch(optiune) {
                case 1: AfisareContacte(); break;
                case 2: Cautare(); break;
                case 3: Adaugare(); break;
                case 4: Modificare(); break;
                case 5: Stergere(); break;
            }
            Meniu();
            optiune=SkeletonJava.readIntConsole("Optiunea dvs este ");
        }
    }

    public static void Meniu() {
        System.out.println("1. Afisare contacte");
        System.out.println("2. Cautare");
        System.out.println("3. Adaugare");
        System.out.println("4. Modificare");
        System.out.println("5. Stergere");
    }

    public static void AfisareContacte() {
        for (String dateContact:agendaPersoaneContact)
            if(dateContact!=null)
                System.out.println(dateContact);
    }

    public static void Cautare() {
        String numeCautat=SkeletonJava.readStringConsole("Introduceti nume cautat ");
        for (int i=0;i<MAX;i++) {
            if (agendaPersoaneContact[i].startsWith(numeCautat)) {
                System.out.println(agendaPersoaneContact[i]); break;
            }
        }
    }

    public static void Adaugare() {

        if (CONTOR>agendaPersoaneContact.length-1) {
            System.out.println("Memorie plina!");
        }
        else

        {
            String adaugareNume = SkeletonJava.readStringConsole("Introduceti contactul dorit ");

            for (int i = 0; i < agendaPersoaneContact.length; i++) {
                if (agendaPersoaneContact[i] == null) {
                    agendaPersoaneContact[i] = adaugareNume;
                    CONTOR++;
                    break;
                }
            }
        }
    }

    public static void Modificare() {
        String numeModificat=SkeletonJava.readStringConsole("Introduceti numele persoanei carei doriti sa o modificati in contactele dvs ");
        for (int i=0;i<agendaPersoaneContact.length;i++) {
            if (agendaPersoaneContact[i].startsWith(numeModificat)) {
                agendaPersoaneContact[i]=SkeletonJava.readStringConsole("Introduceti nume si numar nou ");
                break;
            }
        }
    }

    public static void Stergere() {
        String numeSters=SkeletonJava.readStringConsole("Introduceti numele si numarul persoanei pe care doriti sa o stergeti din contacte ");
        for (int i=0;i<agendaPersoaneContact.length;i++) {
            if(agendaPersoaneContact[i]!=null && agendaPersoaneContact[i].startsWith(numeSters)) {
                agendaPersoaneContact[i]=null;
            }
        }
    }
}
