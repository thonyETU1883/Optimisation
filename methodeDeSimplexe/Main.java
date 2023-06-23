public class Main{
    public static void main(String[] args)throws Exception{
       Fraction[][] tableau=new Fraction[3][8];
        tableau[0][0]=new Fraction(2);
        tableau[0][1]=new Fraction(1);
        tableau[0][2]=new Fraction(0);
        tableau[0][3]=new Fraction(-1);
        tableau[0][4]=new Fraction(0);
        tableau[0][5]=new Fraction(1);
        tableau[0][6]=new Fraction(0);
        tableau[0][7]=new Fraction(40);
        
        
        tableau[1][0]=new Fraction(1);
        tableau[1][1]=new Fraction(2);
        tableau[1][2]=new Fraction(1);
        tableau[1][3]=new Fraction(0);
        tableau[1][4]=new Fraction(-1);
        tableau[1][5]=new Fraction(0);
        tableau[1][6]=new Fraction(1);
        tableau[1][7]=new Fraction(50);

        tableau[2][0]=new Fraction(-3);
        tableau[2][1]=new Fraction(-3);
        tableau[2][2]=new Fraction(-1);
        tableau[2][3]=new Fraction(1);
        tableau[2][4]=new Fraction(1);
        tableau[2][5]=new Fraction(0);
        tableau[2][6]=new Fraction(0);
        tableau[2][7]=new Fraction(-90);


        //les variable de base//
        String[] base=new String[4];
        base[0]="a1";
        base[1]="a2";
        base[2]="Z";

        //les variables hors base sont x1 et x2
        String[] horsBase=new String[8];
        horsBase[0]="t1";
        horsBase[1]="t2";     
        horsBase[2]="t3";
        horsBase[3]="S1";
        horsBase[4]="S2";
        horsBase[5]="a1";
        horsBase[6]="a2";
        horsBase[7]="R";

        /*Fraction[][] tableau=new Fraction[4][7];
        tableau[0][0]=new Fraction(2);
        tableau[0][1]=new Fraction(3);
        tableau[0][2]=new Fraction(1);
        tableau[0][3]=new Fraction(1);
        tableau[0][4]=new Fraction(0);
        tableau[0][5]=new Fraction(0);
        tableau[0][6]=new Fraction(5mm7p);
        
        
        tableau[1][0]=new Fraction(4);
        tableau[1][1]=new Fraction(1);
        tableau[1][2]=new Fraction(2);
        tableau[1][3]=new Fraction(0);
        tableau[1][4]=new Fraction(1);
        tableau[1][5]=new Fraction(0);
        tableau[1][6]=new Fraction(11);


        tableau[2][0]=new Fraction(3);
        tableau[2][1]=new Fraction(4);
        tableau[2][2]=new Fraction(2);
        tableau[2][3]=new Fraction(0);
        tableau[2][4]=new Fraction(0);
        tableau[2][5]=new Fraction(1);
        tableau[2][6]=new Fraction(8);

        tableau[3][0]=new Fraction(5);
        tableau[3][1]=new Fraction(4);
        tableau[3][2]=new Fraction(3);
        tableau[3][3]=new Fraction(0);
        tableau[3][4]=new Fraction(0);
        tableau[3][5]=new Fraction(0);
        tableau[3][6]=new Fraction(0);


        //les variable de base//
        String[] base=new String[4];
        base[0]="x1";
        base[1]="x2";
        base[2]="x3";
        base[3]="Z";

        //les variables hors base sont x1 et x2
        String[] horsBase=new String[7];
        horsBase[0]="x1";
        horsBase[1]="x2";     
        horsBase[2]="x3";
        horsBase[3]="S2";
        horsBase[4]="S3";
        horsBase[5]="S4";
        horsBase[6]="R";*/
 
        Matrice matrice=new Matrice(tableau,base,horsBase);
        //matrice.affichageSimplexe();
        //matrice.methodeSimplexeMax();
        matrice.affichageSimplexe();
        System.out.println("-------------------------");
        matrice.methodeSimplexeMin();
    }
}