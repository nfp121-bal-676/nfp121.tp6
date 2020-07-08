package question1;


public class Contributeur extends Cotisant{
  private int solde;
  
  public Contributeur(String nom, int somme){
    super(nom);
    if(somme>=0)                             
        this.solde = somme; 
     
    else 
        throw new RuntimeException("nombre negatif !!!"); 
    
  }
  
  public int solde(){
    return this.solde;
  }
  
  public int nombreDeCotisants(){
    return 1;
  }
  
  public void debit(int somme) throws SoldeDebiteurException{
    if(somme > solde)
        throw new SoldeDebiteurException(); 
     else if (somme < 0)
        throw new RuntimeException("nombre negatif !!!"); 
    else                               
        this.solde -= somme; 
    
  }
    
    /**
     * throws RuntimeException new RuntimeException("nombre négatif !!!");
     */
  public  void credit(int somme){
      if(somme <  0) 
            throw new RuntimeException("nombre negatif !!!"); 
         else                            
            this.solde += somme; 
        
    }
    
    /**
     * throws RuntimeException new RuntimeException("nombre négatif !!!");
     */
  public void affecterSolde(int somme){
    if(somme <0) 
        throw new RuntimeException("nombre n�gatif !!!"); 
    try{                             
        debit(solde());                             
        credit(somme);
    }catch(SoldeDebiteurException sde){             
        this.solde = somme;
    } 
  }
  
  public <T> T accepter(Visiteur<T> visiteur){
    return visiteur.visite(this);
  }
  
  public String toString(){
    return "<Contributeur : " + nom + "," + solde + ">";
  }

}
