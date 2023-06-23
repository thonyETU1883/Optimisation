public class Fraction{
    float Numerateur;
    float Denominateur=1;

    public Fraction(float numerateur){
        this.Numerateur=numerateur;
    }  

    public Fraction(float numerateur,float denominateur){
        this.Numerateur=numerateur;
        this.Denominateur=denominateur;
    }    

    public float getNumerateur(){
        return this.Numerateur;
    }

    public void setNumerateur(float numerateur){
        this.Numerateur=numerateur;
    }

    public float getDenominateur(){
        return this.Denominateur;
    }

    public void setDenominateur(float denominateur){
        this.Denominateur=denominateur;
    }

    /*simplification fraction
    */

   //a) calcul du plus grand diviseur du fraction
   public float pgcd(float a,float b){
        if(b==0){
            return a;
        }
        return pgcd(b,a%b);
   }
    
    /*b)simplification
    diviser le numerateur et le denominateur avec le pgcd
    si (5/-6) => -5/6
    si -5/-6 =>  5/6
    */ 
   public void simplification(){
        float plusGrandDiviseur=pgcd(this.getNumerateur(),this.getDenominateur());
         this.setNumerateur(this.getNumerateur()/plusGrandDiviseur);
         this.setDenominateur(this.getDenominateur()/plusGrandDiviseur);
         if(this.getDenominateur()<0){
            this.setNumerateur(-1*this.getNumerateur());
            this.setDenominateur(-1*this.getDenominateur());
         }
   }

    /*division entre deux fraction
    c'est le dividende qui appelle la fonction et le diviseur est dans l'argument
    3/2 : 5/2
    3/2 * 2/5
    3*2/2*5
    */

   /*a)inverser le diviseur 
    le numerateur devient le denominateur 
    le denominateur devient le numerateur
    return une nouvelle Fraction mba tsy changer ilay fraction original
   */
    public Fraction inverserFraction(){
        float numerateur=this.getNumerateur();
        float denominateur=this.getDenominateur();
        Fraction newFraction=new Fraction(denominateur,numerateur);  //inverser le numerateur et le denominateur
        return newFraction;
    }

    /*b)multiplication
        multiplication entre le dividende et le diviseur inverser
        la fraction appelant * la fraction dans l'argument
        numerateur * numerateur et denominateur * denominateur
        simplifier la fraction retourner
    */
   public Fraction multiplication(Fraction fractMulti){
        float numerateur=this.getNumerateur()*fractMulti.getNumerateur();
        float denominateur=this.getDenominateur()*fractMulti.getDenominateur();
        Fraction reponseMultiplication=new Fraction(numerateur,denominateur);
        reponseMultiplication.simplification();             //simplifier la fraction
        return reponseMultiplication;
   }

    /*c)division
    Fraction appelant diviser par la fraction dans l'argument
    */
   public Fraction division(Fraction diviseur){
        Fraction diviseurInverse=diviseur.inverserFraction(); //inverser le diviseur
        //faire une multiplication du dividende et le diviseur inverser
        Fraction reponse=this.multiplication(diviseurInverse);
        reponse.simplification();        //simplifier la fraction obtenue
        return reponse;
   }

   /*Comparaison entre deux fraction
    calculer les deux fractions et puis comparer
    si la fraction appelant est plus grand(ou egal) que la fraction dans la fraction argument retourn 1 sinon 0, si egal 2 
   */

  public int comparaison(Fraction fractAcompa){
        float a=this.getNumerateur()/this.getDenominateur();
        float b=fractAcompa.getNumerateur()/fractAcompa.getDenominateur();
        if(a>b){
            return 1;
        }else if(a<b){
            return 0;
        }
        return 2;       //si egale 0
  }

  /*soustraction
    2/3 - 5/6    (2*6-5*3)/6*3
    numerateur1/denominateur1 - numerateur2/denominateur2
    (numerateur1*denominateur2-denominateur1*numerateur2)/denominateur1*denominateur2

   la fraction appelant - la fraction dans l'argument
  */
    public Fraction soustraction(Fraction fractSous){
        Fraction fraction=new Fraction(this.getNumerateur()*fractSous.getDenominateur()-this.getDenominateur()*fractSous.getNumerateur());
        fraction.setDenominateur(this.getDenominateur()*fractSous.getDenominateur());
        fraction.simplification();
        return fraction; 
    }
}