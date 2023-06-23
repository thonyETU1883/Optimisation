/*
    elimination(indiceLigne,indiceColonne) : division d'une ligne du matrice avec un nombre
*/ 
public class Matrice{
    Fraction[][] Tableau;
    String[] Base;
    String[] HorsBase;

    /*constructeur pour les methodes de simplexe*/
    public Matrice(Fraction[][] tableau,String[] base,String[] horsBase){
        this.Tableau=tableau;
        this.Base=base;
        this.HorsBase=horsBase;
    }

    public Matrice(){}


    /*Constructeur pour les methodes de gauss et gauss jordan*/
    public Matrice(Fraction[][] tableau){
        this.Tableau=tableau;
    }

    public Fraction[][] getTableau(){
        return this.Tableau;
    }

    public void setTableau(Fraction[][] tableau){
        this.Tableau=tableau;
    }

    public String[] getBase(){
        return this.Base;
    } 

    public String[] getHorsBase(){
        return this.HorsBase;
    }

    /*Affichage pour matrice simple comme gauss, gauss de jardan*/
    public void affichageMatriceSimple(){
        Fraction[][] matrice=this.getTableau();
        
        for(int i=0;i<matrice.length;i++){
            for(int j=0;j<matrice[0].length;j++){
                if(matrice[i][j].getDenominateur()!=1)
                    System.out.print(matrice[i][j].getNumerateur()+"/"+matrice[i][j].getDenominateur()+"           ");
                else
                    System.out.print(matrice[i][j].getNumerateur()+"           ");
            }
            System.out.println("");
        }
    }

    /*Affichage pour les matrices resultats d'une simplexe car il contient des colonnes et des lignes x1,x2,....
    */
    public void affichageSimplexe(){
        Fraction[][] matrice=this.getTableau();
        String[] base=this.getBase();
        String[] horsBase=this.getHorsBase();
        System.out.print("        ");
        for(int i=0;i<horsBase.length;i++){
            System.out.print(horsBase[i]+"            ");
        }
        System.out.println("");
        for(int i=0;i<matrice.length;i++){
            System.out.print(base[i]+"      ");
            for(int j=0;j<matrice[0].length;j++){
                if(matrice[i][j].getDenominateur()!=1)
                    System.out.print(matrice[i][j].getNumerateur()+"/"+matrice[i][j].getDenominateur()+"           ");
                else
                    System.out.print(matrice[i][j].getNumerateur()+"           ");
            }
            System.out.println("");
        }
    }

    /*methode de gauss
        elimination des element inferieur du diagonal
        la premiere ligne est le premier pivaut

        1   1   1   6       1   1   1   6       1   1   1   6
        1   2   4   15  ->  0   1   3   9   ->  0   1   3   9
        1   3   9   20      0   2   8   22      0   0   2   4   

        a b c d       a*e b*e c*e d*e
        e f g h   ->  e*a f*a g*a h*a   -> soustraction entre la premiere et deuxieme ligne
    */
   public void methodeDeGauss(){
        Fraction[][] matrice=this.getTableau();
        for(int i=0;i<matrice.length;i++){
            Fraction[] pivaut=matrice[i];
            this.affichageMatriceSimple();
            System.out.println("---------------------------------------");
            for(int j=(i+1);j<matrice.length;j++){       //matrice en bas du pivaut car on elimine que les triangles en bas   
                Fraction matriceAEliminer=matrice[j][i];   //le nombre a mettre a egale 0
                for(int k=i;k<matrice[j].length;k++){    //k=i parce que les colonnes avant i sont 0
                    Fraction pivautMultipli=pivaut[k].multiplication(matriceAEliminer);
                    matrice[j][k]=matrice[j][k].multiplication(pivaut[i]);
                    matrice[j][k]=matrice[j][k].soustraction(pivautMultipli);
                }
            }
        }
   }
    /*methode jordan
    matrice teste:
    
    2  1   1  10                            1  1/2  1/2  5              1  1/2  1/2  5
    1  2  -1  5    ->  diviser le pivaut    1  2    -1   5  -> L2-L1 -> 0  3/2 -1/2  0
    1  0   2  0                             1  0     2   0              1  0     2   0
    
    */

   /*a)rendre le premier nombre du pivaut 1
        si egale 0 ou egale a 1 on ne divise plus
   */ 
     public void elimination(int indiceLigne,int indiceColonne){      //IndiceColonne= indice colonne ou on veut diviser la matice ex: 1 5 4 3 (colonne=2 diviser par 5)  
            Fraction[][] matrice=this.getTableau();
            Fraction diviseur=matrice[indiceLigne][indiceColonne];
            if(diviseur.getNumerateur()!=0){
                for(int i=0;i<matrice[indiceLigne].length;i++){
                    matrice[indiceLigne][i]=matrice[indiceLigne][i].division(diviseur);
                }
            }
     } 

    /**
     * methode de gauss de jordan:
     * prendre la ligne pivaut (commencer par le debut de la matrice)
     * divier la ligne par matrice[lignePivaut][lignePivaut]
     * soustraction des autres lignes par le pivaut
    */

   public void methodeDeGaussJordan(){
        Fraction[][] matrice=this.getTableau();
        for(int i=0;i<matrice.length;i++){
            this.elimination(i,i);
            Fraction[] pivaut=matrice[i];
            for(int j=0;j<matrice.length;j++){       //matrice en bas du pivaut car on elimine que les triangles en bas   
                if(i!=j){                           //different de la ligne du pivaut
                    Fraction matriceAEliminer=matrice[j][i];   //le nombre a mettre a egale 0
                    for(int k=i;k<matrice[j].length;k++){    //k=i parce que les colonnes avant i sont 0
                        Fraction pivautMultipli=pivaut[k].multiplication(matriceAEliminer);
                        matrice[j][k]=matrice[j][k].multiplication(pivaut[i]);
                        matrice[j][k]=matrice[j][k].soustraction(pivautMultipli);
                    }
                }
            }
        }
   }

    /*matrice teste        
            1.0           3.0           1.0           1.0           0.0           0.0           0.0           3.0
            -1.0           0.0           3.0           0.0           1.0           0.0           0.0           2.0
            2.0           4.0           -1.0           0.0           0.0           1.0           0.0           4.0
            1.0           3.0           -1.0           0.0           0.0           0.0           1.0           2.0
            1.0           5.0           1.0           0.0           0.0           0.0           0.0           0.0
    */


    /*etape1: prendre l'indice du max dans z , c est a dire la derniere ligne
           max dans z=5
           indice du colonne = 1 
            x1
            3
            0
            4
            3
            5
    */

        public int etape1(){
            Fraction[][] matrice=this.getTableau();
            int ligneZ=matrice.length-1;            //la derniere ligne
            float max=matrice[ligneZ][0].getNumerateur()/matrice[ligneZ][0].getDenominateur(); //Initialisation
            int indice=0;                           //initialisation de l'indice a retourner
            for(int i=0;i<matrice[ligneZ].length;i++){                         //mitety colonne an le ligne
                if(max<(matrice[ligneZ][i].getNumerateur()/matrice[ligneZ][i].getDenominateur()) && i!=(matrice[ligneZ].length-1)){
                    max=matrice[ligneZ][i].getNumerateur()/matrice[ligneZ][i].getDenominateur();
                    indice=i;
                }
            }
            return indice;
        }

    /*etape 2: prendre le minimum entre les R/xi
        xi = la colonne de l'indice obtenu dans l'etape1 
        R = la derniere colonne du matrice
    */
            /*a) prendre la colonne xi et R 
                x1      R
                3       3
                0       2
                4       4
                3       2
                5       0
            */

           public Fraction[] getColonneMatrice(int indice){         //fonction qui prend la colonne d'un indice donnee
                Fraction[][] matrice=this.getTableau();
                Fraction[] vecteurColonne=new Fraction[matrice.length];
                for(int i=0;i<matrice.length;i++){                  //mitanisa ligne fa colonne mijanona indice
                    vecteurColonne[i]=matrice[i][indice];
                }
                return vecteurColonne;
           }

           public Fraction[] getLigneMatrice(int indice){           //fonction qqui prend une ligne a partir d'un indice donnee
                Fraction[][] matrice=this.getTableau();
                Fraction[] vecteurLigne=new Fraction[matrice[indice].length];
                for(int i=0;i<matrice[indice].length;i++){
                    vecteurLigne[i]=matrice[indice][i];
                }
                return vecteurLigne;
           }

           /*b) trouver tous les R/xi
                si xi = 0 c'est a dire R/xi=infini on affecte une valeur 0
                si xi<0 on affecte une valeur 0
                
                R/x1
                1
                0
                1
                2/

                on prend pas la derniere ligne parce que c'est Z
            */
           public Fraction[] rsurxi(){
                //prendre R 
                Fraction[][] matrice=this.getTableau();
                int indiceZ=matrice[0].length-1;        //indice e la derniere colonne 
                Fraction[] r=this.getColonneMatrice(indiceZ);
                int indicexi=this.etape1();             //inidce de la colonne max 
                Fraction[] xi=this.getColonneMatrice(indicexi);
                Fraction[] enregistrement=new Fraction[matrice.length-1];
                for(int i=0;i<(xi.length-1);i++){       //-1 parce que 
                    if(xi[i].getNumerateur()>0){
                        enregistrement[i]=r[i].division(xi[i]);
                    }else{
                        enregistrement[i]=new Fraction(0);
                    }
                }
                return enregistrement;
           }
           
           /*c) chercher le minimum entre ces r/xi
                on choisit aue les minimum >0 et fraction non null

                il faut d'abord chercher le debut ou on va comparer les elements de R/xi satria raha 0 ny debut d tsy mety
                izay premier nombre>0

                si a la fin du fonction la fraction est 0 dons on saute la fraction dans la boucke

                pivaut:  1  3   -1  0   0   0   1   2
           */
            public int getIndiceDebutComparaison()throws Exception{
                Fraction[] listeRsurXi=this.rsurxi();
                int indice=-1;
                for(int i=0;i<listeRsurXi.length;i++){
                    if(listeRsurXi[i].getNumerateur()>0){
                        indice=i;
                        break;
                    }
                }
                if(indice<0)
                    throw new Exception("Pas de solution");
                return indice;
            } 

          public int etape2()throws Exception{
             Fraction[] listeRsurXi=this.rsurxi();
             int indice=this.getIndiceDebutComparaison();
             Fraction fraction=listeRsurXi[0];
             for(int i=indice;i<listeRsurXi.length;i++){
                if(listeRsurXi[i].comparaison(fraction)==0 && listeRsurXi[i].getNumerateur()>0){
                    fraction=listeRsurXi[i];
                    indice=i;
                }
             } 
            

             return indice;
          }
        
        /*etape3 diviser le pivaut par l'intersection du ligne et du colonne obtenu
        ligne=3     dans l'etape2
        colonne=1   dans l'etape1
        intersection=3
        pivaut : 1/3    1   -1/3    0   0   0   1/3     2/3      

        afamadika n valeur ny horsbase sy ilay base ao amn string[]
                *horsbase[colonne]<=>base[ligne]
        */

       public Fraction getIntersection()throws Exception{
            int ligne=this.etape2();
            int colonne=this.etape1();
            Fraction intersection=this.getTableau()[ligne][colonne];       
            return intersection;
       }

       public void etape3()throws Exception{
            Fraction[][] matrice=this.getTableau();
            Fraction intersection=this.getIntersection();
            int ligne=this.etape2();
            //diviser la matrice a la ligne de l'etape2 par l'intersection
            for(int i=0;i<matrice[ligne].length;i++){
                matrice[ligne][i]=matrice[ligne][i].division(intersection);
            }


            //mamadika an ilay base sy horsbase 
            String[] base=this.getBase();
            String[] horsBase=this.getHorsBase();
            int colonneMax=this.etape1();
            String tahiryBase=base[ligne];
            String tahiryHorsBase=horsBase[colonneMax];
            base[ligne]=tahiryHorsBase;
       }

       /*etape4 soustrait toutes les lignes (avec le z) par le pivaut


        prendre le pivaut       getLigneMatrice(etape2)
        prendre la colonne max      getColonneMatrice(etape1)
        prendre la valeur d'intersection

        aciver d'abord l'etape 3
        xij=xij-(colonneMax[i]/intersection)*pivaut[j]
       */

      public void etape4()throws Exception{
        int ligne=this.etape2();       //ligne du pivaut
        int colonne=this.etape1();     //colonne du colonne max
        Fraction[] pivaut=this.getLigneMatrice(ligne);          //notation piv
        Fraction[] colonneMax=this.getColonneMatrice(colonne);  //notation cm
        Fraction intersection=this.getIntersection();          //notation inter
        
        this.etape3();                  //activation de l'etape3
        Fraction[][] matrice=this.getTableau();

        for(int i=0;i<matrice.length;i++){
            for(int j=0;j<matrice[i].length;j++){
                if(i!=ligne){
                    Fraction cmSurinter=colonneMax[i].division(intersection);
                    Fraction cmSurinterFoisPiv=cmSurinter.multiplication(pivaut[j]); 
                    matrice[i][j]=matrice[i][j].soustraction(cmSurinterFoisPiv);
                }
            }
        }
      }

      /*condition d'arret
        si la ligne de z est tous <0
      */

     public boolean conditionDarret(){
        Fraction[][] matrice=this.getTableau();
        int indiceZ=matrice.length-1;
        Fraction[] ligneZ=matrice[indiceZ];
        boolean val=true;
        for(int i=0;i<ligneZ.length;i++){
            if(ligneZ[i].getNumerateur()>0){
                val=false;
            }
        }
        return val;
     }

     /*methode de simplexe: repeter l'algorithme jusqu a ce que la condition d'arret soit true*/

     public void methodeSimplexeMax()throws Exception{
        if(this.conditionDarret()==false){
            this.etape4();
            methodeSimplexeMax();
        this.affichageSimplexe();
        }
     }


     /*
        phase1 : faire le minimum de la matrice

        atao * -1 ilay Z dia atao max 

      */
     public void methodeSimplexeMin()throws Exception{
        Fraction[][] matrice=this.getTableau();
        int indiceZ=matrice.length-1;
        Fraction[] ligneZ=matrice[indiceZ];
        for(int i=0;i<ligneZ.length;i++){
            Fraction a=ligneZ[i].multiplication(new Fraction(-1));
            ligneZ[i]=a;
        }
        this.methodeSimplexeMax();
     }


    /*Phase 2 : changement du z 
        elimination des t 
        maximisation
        l'attribut est le z en fonction de x 
    */


}