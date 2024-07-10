import java.util.Scanner;

public class Vehicul {
    String culoare;
    double viteza, greutate;
    Vehicul(String culoare, double viteza, double greutate){

        this.culoare=culoare;
        this.greutate=greutate;
        this.viteza=viteza;
    }
    void atribute()
    {
        System.out.println("Culoare:"+culoare);
        System.out.println("Viteza:"+viteza);
        System.out.println("Greutate:"+greutate);
    }
}

class MasinaMea extends Vehicul{
    int cod;
    double km;
    MasinaMea(String culoare, double viteza, double greutate, int cod, double km){
        super(culoare, viteza, greutate);
        this.cod=cod;
        this.km=km;
    }

    @Override
    void atribute() {
        super.atribute();
        System.out.println("Nr masinii: "+cod);
        System.out.println("Km parcurse: "+km);
    }
}

class TestMasinaMea{
    static int k=0;
    static int culoareRosie(MasinaMea []v){
        for(int i=0; i<v.length; i++)
        {
            if(v[i].culoare.equalsIgnoreCase("rosie"))
                k++;
        }
        return k;
    }


    static double max=-000000.00;
    static  void kmMaxim(MasinaMea []v)
    {
        for (int i=0; i<v.length; i++)
        {if(v[i].km>v[i+1].km)
            max=v[i].km;
        }
        for (int i=0; i<v.length; i++)
        {
            if(max==v[i].km)
                v[i].atribute();
        }
    }

    static int cnt=0;
    static int greutate(MasinaMea []v, double x, double y ){
        for (int i=0; i<v.length;i++)
        {
            if(x<v[i].km && v[i].km<y)
                cnt++;
        }return cnt;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        System.out.println("Cate masini avem?");
        int n= input.nextInt();
        MasinaMea []v=new MasinaMea[n];
        for (int i=0; i<n; i++)
        {
            System.out.println("Introduceti culoarea masinii, viteza, greutatea, codul, km parcurse:");
            v[i]=new MasinaMea(input.next(), input.nextDouble(), input.nextDouble(), input.nextInt(), input.nextDouble());
            v[i].atribute();
        }
        System.out.println("Avem "+culoareRosie(v)+" masini rosii.");
        System.out.println("Maximul de km: ");
        kmMaxim(v);
        System.out.println("Introduceti diapazonul:");
        double a= input.nextDouble();
        double b= input.nextDouble();
        System.out.println("Numarul de masini ce au greutatea cuprinsa intre "+a+" "+b+" "+greutate(v,a,b));

    }
}